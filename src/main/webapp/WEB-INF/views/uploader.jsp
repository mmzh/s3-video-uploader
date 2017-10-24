<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Upload video</title>
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script src="http://vjs.zencdn.net/6.2.8/video.js"></script>
    <script src="<c:url value='/static/js/app.js'/>"></script>
    <link href="http://vjs.zencdn.net/6.2.8/video-js.css" rel="stylesheet">
    <link href="<c:url value='/static/css/bootstrap.min.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
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
              <a class="nav-link js-scroll-trigger" href="uploader">Upload</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="myvideos">My Videos</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="logout">Logout</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
    <section id="portfolio">
      <div class="success">
        <div>
          <div class="row">
            <div class="col-md-12">
              <h1>Uploader</h1>
              <form method="post" action='uploader?${_csrf.parameterName}=${_csrf.token}' enctype="multipart/form-data">
                <div class="form-group">
                  <label class="btn btn-primary btn-file">
                  Browse video...<input type="file" name="file" id="file" accept=".mp4" onchange="setFileInfo(this.files)" style="display:none;">
                  </label>  
                </div>
                <div id="vinfo">
                </div>
                <div class="alert alert-danger alert-danger-warning" id="alert">
                  <strong>Warning!</strong> Video is too long to upload! limit up to 10 minutes and 25M.
                </div>
                <button type="submit" id="submit-button" class="btn btn-success" disabled>Submit</button> 
                <b id="file-fmt-warning"> * mp4 file only</b>
              </form>
              <input id="page-hash-id" name="page-hash-id" type="hidden" value="${_csrf.parameterName}=${_csrf.token}">
            </div>
            <div class="col-md-12">
              <div class="progress hidden">
                <div id="progressBar" class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 0%">0%</div>
              </div>
              <!-- Alert -->
              <div id="alertMsg" style="color: red;font-size: 18px; text-align:center;"></div>
            </div>
          </div>
        </div>
      </div>
      <div class="player-box hidden">
        <h1 class="text-center">Video Uploaded!</h1>
        <hr class="star-primary">
        <div class="col-md-12">
          <div class="player-box-outer">
            <video id="my-video" class="video-js" controls preload="auto" width="640" data-setup="{}"></video>
          </div>
        </div>
        <div class="col-md-12">
          <div class="player-box-outer" id="video-info-box"></div>
        </div>
        <div class="col-md-12 text-center video-bucket-hint">
          <p><a id="a-video-link" href="" target="_BLANK">Click here</a> to access video on S3 bucket</p>
          <p>Your hls format of video will be <a id="a-hls-video-link" href="" target="_BLANK">here</a> once it's ready</p>
        </div>
      </div>
    </section>
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