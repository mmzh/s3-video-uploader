# s3 video uploader
```html
<div>
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
               <p>For upload video process, there are two approaches, one way is directly post video to s3 bucket, the other will be upload to EC2 server first, after retrieving video information, then move video file to S3 bucket. I will implement second approach in this application.</p>
               <p>There are some good open source tools can be used to retrieve video information, I will use "ffmpeg" and "ffprobe", "ffmpeg" can be used to encode video as well. </p>
               <p>For documentation, we can use javadoc.</p>
               <h3 style="padding-top:20px;">3. technology behind this project</h3>
               <hr>
               <p>3.1 AWS solution</p>
               <p>AWS provides easy to use, reliable, scalable and flexible web service in different ways. I use AWS EC2 to host this application. AWS S3 service to store uploaded files. RDS for database, Elastic Transcoder for video conversion, create microservice using Lambda to automatically call video conversion task.</p>
               <p>3.2 Back end</p>
               <p>Java + Spring + Spring Security + Hiberate + mvn + mysql + ffprobe + aws-sdk-java + MVC</p>
               <p>3.3 Front end</p>
               <p>javascript + html + css+ jQuery + videoJS + bootstrap.js + bootstrap freelancer template</p>
               <p>3.4 IDE</p>
               <p>eclipse 4.7.1</p>
               <h3 style="padding-top:20px;">4. Documentation</h3>
               <hr>
               <p><a href="https://mmzh.github.io/s3-video-uploader/" target="_BLANK" style="color:#cfe2de;">Click here</a> to access app documentation</p>
               </div>
```
