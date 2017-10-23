<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>View video</title>
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="http://vjs.zencdn.net/6.2.8/video.js"></script>
     <link href="http://vjs.zencdn.net/6.2.8/video-js.css" rel="stylesheet">
     <script>
     $(document).ready(function(){
    	 var str="${videoinfo}";
    	 var strArray=str.split("||");
    	 var s; for(s in strArray){
    		 if(strArray[s].trim()!="") $("#video-info-box").append("<button  type='button' class='btn btn-primary btn-xs'>" + strArray[s].replace("=",":").replace("_"," ") + "</button>");
    	 }
     });
     </script>
    </head>
    <body>
        <div class="container">
            <div class="row">
	            <div class="col-md-12">
	              <div style="width:640px; margin:auto; padding:0px;" class="success">
					<nav class="navbar-collapse bs-navbar-collapse collapse in" role="navigation">
						<div class="navbar-header">
						    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
							<a class="navbar-brand" href="#"></a>
						</div>
						<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
							<ul class="nav navbar-nav ">
								<li><a class="nav-item nav-link" href="uploader">Upload</a></li>
								<li><a class="nav-item nav-link" href="myvideos">My videos</a></li>
								<li><a class="nav-item nav-link" href="logout">Logout</a></li>
							</ul>
						</div>
					</nav>
				</div>
             </div>
             <div class="col-md-12">
             	<div class="video-box-outer">
	             	<video id="my-video" class="video-js" controls preload="auto" width="640" data-setup="{}"> <source src="${videourl}" type='video/mp4'>
					   <p class="vjs-no-js">
					   To view this video please enable JavaScript, and consider upgrading to a web browser that
					   <a href="http://videojs.com/html5-video-support/" target="_blank">supports HTML5 video</a>
					    </p>
	    			</video>
    			</div>
             </div>
             <div class="col-md-12">
                 <div class="video-box-outer" id="video-info-box"></div>
             </div>
           </div>
        </div>
    </body>
</html>