package com.vm.app.util;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.io.FilenameUtils;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ListObjectsV2Request;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.vm.app.service.AWSS3Service;
import com.vm.app.model.Video;
import com.vm.app.util.typeConverter;

/**
 * <h1>AwsS3Api class for upload and list files on s3 bucket</h1>
 * 
 * @author Ming M Zheng
 * @version 1.0
 * @since 2017-10-21
 */
public class AwsS3Api {

	private String awsKey;

	private String awsSecret;

	private String awsRegion;

	private String awsBucket;

	private String awsBaseurl;

	private String awsLocalpath;

	public AmazonS3 s3client;

	public AwsS3Api(HashMap<String, String> aws) {
		this.awsKey = aws.get("awsKey");
		this.awsSecret = aws.get("awsSecret");
		this.awsRegion = aws.get("awsRegion");
		this.awsBucket = aws.get("awsBucket");
		this.awsBaseurl = aws.get("awsBaseurl");
		this.awsLocalpath = aws.get("awsLocalpath");
		s3client = AmazonS3ClientBuilder.standard()
				.withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(this.awsKey, this.awsSecret)))
				.withRegion(this.awsRegion).build();
	}

	/**
	 * This method is used to transfer local file into s3 bucket.
	 * 
	 * @param file
	 *            This is first parameter which represents local file name in String
	 *            format
	 * @param vinfo
	 *            This is second parameter, a serialized data that contains basic
	 *            video information
	 * @param orinName
	 *            This is third parameter,
	 * @return String, a url link to s3 file location.
	 * @see IOException
	 */
	public String putfile(String file, String vinfo, String orinName) throws IOException {

		AWSS3Service awsService = new AWSS3Service(s3client);
		// uploading object
		ObjectMetadata objectMetadata = new ObjectMetadata();
		objectMetadata.addUserMetadata("orin-name", orinName);
		objectMetadata.addUserMetadata("detail", vinfo);
		awsService.putObject(awsBucket, file, new File(awsLocalpath + file), objectMetadata);
		String url = awsBaseurl + file;
		return url;
	}

	/**
	 * This method is used to list file on s3 bucket
	 * 
	 * @return ArrayList, a list contains video objects
	 * @see ParseException
	 */
	public ArrayList<Video> listObjects() throws ParseException {

		final ListObjectsV2Request req = new ListObjectsV2Request().withBucketName(awsBucket).withMaxKeys(12);
		ListObjectsV2Result result;

		ArrayList<Video> videos = new ArrayList<Video>();

		do {
			result = s3client.listObjectsV2(req);
			for (S3ObjectSummary objectSummary : result.getObjectSummaries()) {
				Map<String, String> vinfo = getObjectInfo(objectSummary.getKey());
				Video v = new Video();
				v.setName(FilenameUtils.removeExtension(vinfo.get("orin-name")));
				v.setS3url(awsBaseurl + objectSummary.getKey());
				v.setSize(typeConverter.getReadableSize(objectSummary.getSize() + ""));
				v.setDate(typeConverter.shiftTimeZone(objectSummary.getLastModified()));
				v.setHlsurl(getHlsFormat(objectSummary.getKey()));
				if (vinfo.get("detail") != null)
					v.setDetail(vinfo.get("detail").replace("||", "; ").replace("_", " ").replace("=", ": "));
				videos.add(v);
			}
			req.setContinuationToken(result.getNextContinuationToken());
		} while (result.isTruncated() == true);

		return videos;
	}

	/**
	 * This method is used to retrieve file's meta information from s3
	 * 
	 * @param key
	 *            This is first parameter, represent file name in s3 bucket
	 * @return Map, return key and value pairs of file meta information
	 */
	public Map<String, String> getObjectInfo(String key) {

		ObjectMetadata objectMetadata = s3client.getObjectMetadata(awsBucket, key);
		Map<String, String> userMetadataMap = objectMetadata.getUserMetadata();
		return userMetadataMap;
	}

	/**
	 * 
	 * @param key
	 *            file name on s3
	 * @return boolean
	 */
	public String getHlsFormat(String key) {
		String fname = "hls/" + FilenameUtils.removeExtension(key) + ".ts";
		if (s3client.doesObjectExist("plpm", fname))
			return (getHlsBaseUrl() + fname);
		else
			return "#";
	}

	/**
	 * no parameter
	 * 
	 * @return String link to hls video format folder
	 */
	public String getHlsBaseUrl() {
		return "https://s3.amazonaws.com/plpm/";
	}

	public String getHlsUrl(String key) {
		String fname = "hls/" + FilenameUtils.removeExtension(key) + ".ts";
		return "https://s3.amazonaws.com/plpm/" + fname;
	}

}