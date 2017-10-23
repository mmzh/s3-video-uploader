<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Welcome to S3 uploader project</title>
    <link href="<c:url value='/static/css/bootstrap.min.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <!-- Custom fonts for this template -->
    <link href="<c:url value='/static/css/font-awesome.min.css' />" rel="stylesheet"></link>
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
          <span class="skills">This is demo to show how to upload video to s3 and retrieve video info, then run Lambda to convert videos to HLS format. </span>
        </div>
      </div>
    </header>
    <!-- Footer -->
    <footer class="text-center">
      <div class="footer-below">
        <div class="container">
          <div class="row">
            <div class="col-lg-12">
              By Ming @Nov 2017
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