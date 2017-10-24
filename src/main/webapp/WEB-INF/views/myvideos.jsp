<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>List Videos from s3 bucket</title>
    <link href="<c:url value='/static/css/bootstrap.min.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <!-- Custom fonts for this template -->
    <link href="<c:url value='/static/css/font-awesome.min.css' />" rel="stylesheet"></link>
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">
    <script>
    $(document).ready(function(){
    	$(".hls-link[href='#']").html("Not ready");
    });
    </script>
  </head>
  <body>
    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
      <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="home">S3 Video Uploader</a>
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
              <a class="nav-link js-scroll-trigger" href="logout">Logout</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
    <!-- table Grid Section -->
    <section id="portfolio">
      <div class="container">
        <h2 class="text-center">videos from s3 bucket</h2>
        <hr class="star-primary">
        <div class="row">
          <table class="table table-striped table-video">
            <tr>
              <th class="co1l-md-2">Video Name</th>
              <th class="co1l-md-1">Size</th>
              <th class="co1l-md-1">Last Modified On</th>
              <th class="co1l-md-1">S3 link</th>
              <th class="co1l-md-1">Hls Format</th>
              <th class="co1l-md-4">Detail</th>
            </tr>
            <c:forEach var="video" items="${videos}">
              <tr>
                <td>${video.name}</td>
                <td>${video.size}</td>
                <td>${video.date}</td>
                <td><a href="${video.s3url}" target="_BLANK">View Link</a></td>
                <td><a href="${video.hlsurl}" class="hls-link">View Link</a></td>
                <td>${video.detail}</td>
              </tr>
            </c:forEach>
          </table>
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