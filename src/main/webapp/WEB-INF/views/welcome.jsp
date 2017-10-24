<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
   <head>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
      <meta name="description" content="">
      <meta name="author" content="">
      <title>Welcome to S3 uploader project</title>
      <link href="<c:url value='/static/css/bootstrap.min.css' />" rel="stylesheet">
      </link>
      <link href="<c:url value='/static/css/app.css' />" rel="stylesheet">
      </link>
      <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
      <!-- Custom fonts for this template -->
      <link href="<c:url value='/static/css/font-awesome.min.css' />" rel="stylesheet">
      </link>
      <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
      <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">
   </head>
   <body>
      <!-- Navigation -->
      <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
         <div class="container">
            <a class="navbar-brand js-scroll-trigger" href="#page-top">S3 Video Uploader</a>
            <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            Menu
            <i class="fa fa-bars"></i>
            </button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
               <ul class="navbar-nav ml-auto">
                  <li class="nav-item">
                     <a class="nav-link js-scroll-trigger" href="login">login</a>
                  </li>
                  <li class="nav-item">
                     <a class="nav-link js-scroll-trigger" href="uploader">Upload</a>
                  </li>
                  <li class="nav-item">
                     <a class="nav-link js-scroll-trigger" href="myvideos">My Videos</a>
                  </li>
               </ul>
            </div>
         </div>
      </nav>
      <!-- Content -->
      <header class="masthead">
         <div class="container">
            <div class="intro-text">
               <span class="name">Get Start</span>
               <hr class="star-light">
               <span class="skills">This demo site is used to show how to upload video to s3 and retrieve video info, then use Lambda to create micro service that converts video to HLS format. </span>
            </div>
            <div class="text-left">
               <h3 style="padding-top:20px;">1. Objective</h3>
               <hr>
               <p>Need an application written in java using Spring Framework, this application should contain following features: </p>
               <p>1.1 Use Spring Security for authentication. </p>
               <p>1.2 Database to store username and password. </p>
               <p>1.3 Only logged in users can upload video files. </p>
               <p>1.4 Only allow video files in mp4 format and less then 10 minutes in duration.</p>
               <p>1.5 Deploy application to AWS EC2.</p>
               <p>1.6 Video files that being uploaded need to be in s3 bucket.</p>
               <p>1.7 Retrieve video information after upload</p>
               <p>1.8 Redirect properly. </p>
               <p>1.9 Encode mp4 to HLS stream. </p>
               <p>1.10 Limit upload size to 25Mb.</p>
               <p>1.11 documentation the API</p>
               <h3 style="padding-top:20px;">2. Analysis and the Approaches</h3>
               <hr>
               <p>2.1 Analysis</p>
               <p>Since it's a web application, Java and Spring framework will be a good answer for it, they have been most used to implement enterprise applications.  
                  This application also requires user authentication, Spring security framework can be used to handle that.  To retrieve users information, we also need database and Java Hiberate framework to work with. I am familiar with Mysql, so I will adopt Mysql database to store users information.</p>
               <p>For upload video process, there are two approaches, one way is directly post video to s3 bucket, the other will upload to EC2 server first, after retrieving video information, then move video file to S3 bucket. I will implement second approach in this application.</p>
               <p>There are some good open source tools can be used to retrieve video information, I will use "ffmpeg" and "ffprobe", "ffmpeg" can be used to encode video as well. </p>
               <p>For documentation, we can use javadoc.</p>
			   <p>2.2 AWS solution</p>
			   <p>AWS provides easy to use, reliable, scalable and flexible web service in different ways. I use AWS EC2 to host this application. AWS S3 service to store uploaded files. RDS for database, Elastic Transcoder for video conversion, create microservice using Lambda to automatically call video conversion task.</p>
			   
               <h3 style="padding-top:20px;">3. technology behind this project</h3>
               <hr>
               <p>3.1 AWS</p>
               <p>EC2 + S3 + Lambda + RDS + Elastic Transcoder + IAM + CloudWatch</p>
               <p>3.2 Back end</p>
               <p>Java + Spring + Spring Security + Hiberate + mvn + mysql + ffprobe + aws-sdk-java + MVC</p>
               <p>3.3 Front end</p>
               <p>javascript + html + css+ jQuery + videoJS + bootstrap.js + bootstrap freelancer template</p>
               <p>3.4 IDE</p>
			   <p>Eclipse 4.7.1</p>
               <h3 style="padding-top:20px;">4. Testing</h3>
               <hr>
               <p>Username and credential will be provided by email. User can conduct login, logout, upload video, list uploaded videos on s3, watch video and retrieve video information after uploading tasks. </p>
               <h3 style="padding-top:20px;">5. Documentation</h3>
               <hr>
               <p><a style="color:#cfe2de;" href="https://mmzh.github.io/s3-video-uploader/">Click here</a> to access app documentation</p>
            </div>
         </div>
      </header>
      <!-- Footer -->
      <footer class="text-center">
         <div class="footer-below">
            <div class="container">
               <div class="row">
                  <div class="col-lg-12">
                     By Ming @Oct 2017
                  </div>
               </div>
            </div>
         </div>
      </footer>
      <!-- Bootstrap core JavaScript -->
      <script src="<c:url value='/static/js/bootstrap.bundle.min.js'/>"></script>
      <script src="<c:url value='/static/js/jquery.easing.min.js'/>"></script>
      <script src="<c:url value='/static/js/freelancer.min.js'/>"></script>
   </body>
</html>