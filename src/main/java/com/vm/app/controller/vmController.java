package com.vm.app.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.vm.app.model.UserProfile;
import com.vm.app.model.Video;
import com.vm.app.service.UserProfileService;
import com.vm.app.service.UserService;
import com.vm.app.util.AwsS3Api;
import com.vm.app.util.ffmpegApi;

/**
 * <h1>Spring controller class</h1>
 * @author Ming M Zheng 
 * @version 1.0
 * @since 2017-10-21
 */

@Controller
public class vmController {


    @Autowired
    UserProfileService userProfileService;

    @Autowired
    UserService userService;


    @Value("${aws.key}")
    private String awsKey;

    @Value("${aws.secret}")
    private String awsSecret;

    @Value("${aws.region}")
    private String awsRegion;

    @Value("${aws.bucket}")
    private String awsBucket;

    @Value("${aws.baseurl}")
    private String awsBaseurl;

    @Value("${aws.localpath}")
    private String awsLocalpath;

    /**
     * 
     * @param model data
     * @return String value mapping with welcome.jsp file in the views
     * @see welcome page loads
     */
    @RequestMapping(value = {
        "/",
        "/home"
    }, method = RequestMethod.GET)
    public String homePage(ModelMap model) {
        model.addAttribute("greeting", "login and upload your video to AWS S3 Bucket");
        return "welcome";
    }


    @RequestMapping(value = "/uploader", method = RequestMethod.GET)
    public String uploaderPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "uploader";
    }

    // Handling single file upload request

    @RequestMapping(value = "/uploader", method = RequestMethod.POST)
    public ResponseEntity < String > singleFileUpload(@RequestParam("file") MultipartFile file)
    throws IOException {

        String responseJson = "";
        // Save file on system
        String fileExt=FilenameUtils.getExtension(file.getOriginalFilename());
        
        //System.out.println("dd:"+fileExt);
        if(!fileExt.toLowerCase().equals("mp4")) return new ResponseEntity < String > ("Invalid file.", HttpStatus.BAD_REQUEST);
        
        if (!file.getOriginalFilename().isEmpty()) {
        	String uniFileName=UUID.randomUUID() + "." + fileExt;
        	
            BufferedOutputStream outputStream = new BufferedOutputStream(
                new FileOutputStream(new File(awsLocalpath, uniFileName)));
            outputStream.write(file.getBytes());
            outputStream.flush();
            outputStream.close();

            ffmpegApi ff = new ffmpegApi();
            ArrayList < String > vinfo = ff.getVideoFileInfo(awsLocalpath + uniFileName);
            StringBuilder st = new StringBuilder();
            for (String s: vinfo) st.append(s + "||");
            AwsS3Api s3 = initS3();
            String url = s3.putfile(uniFileName, new String(st),file.getOriginalFilename());
            String videoinfo = new String(st);
            responseJson = "{\"url\":\"" + url + "\",\"videoinfo\":\"" + videoinfo + "\"}";
        } else {
            return new ResponseEntity < String > ("Invalid file.", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity < String > (responseJson, HttpStatus.OK);
    }



    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "accessDenied";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/myvideos", method = RequestMethod.GET)
    public String getvinfo(ModelMap model) throws IOException, ParseException {

        AwsS3Api s3 = initS3();
        ArrayList < Video > videos = s3.listObjects();

        model.addAttribute("videos", videos);
        return "myvideos";
    }



    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }

    private String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

    public AwsS3Api initS3() {

        HashMap < String, String > aws = new HashMap < String, String > ();
        aws.put("awsKey", this.awsKey);
        aws.put("awsSecret", this.awsSecret);
        aws.put("awsRegion", this.awsRegion);
        aws.put("awsBucket", this.awsBucket);
        aws.put("awsBaseurl", this.awsBaseurl);
        aws.put("awsLocalpath", this.awsLocalpath);

        AwsS3Api s3 = new AwsS3Api(aws);

        return s3;
    }

    @ModelAttribute("roles")
    public List < UserProfile > initializeProfiles() {
        return userProfileService.findAll();
    }

}