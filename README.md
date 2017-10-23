# s3 video uploader

               <h3 style="padding-top:20px;">1. Objective</h3>
               <hr>
               <div>Need an application written in java using Spring Framework, this application should contain following features: </div>
               <div>1.1 Use Spring Security for authentication. </div>
               <div>1.2 Database to store username and password. </div>
               <div>1.3 Only logged in users can upload video files. </div>
               <div>1.4 Only allow video files in mp4 format and less then 10 minutes in duration.</div>
               <div>1.5 Deploy application to AWS EC2.</div>
               <div>1.6 Video files that being uploaded need to be in s3 bucket.</div>
               <div>1.7 Retrieve video information after upload</div>
               <div>1.8 Redirect properly. </div>
               <div>1.9 Encode mp4 to HLS stream. </div>
               <div>1.10 Limit upload size to 25Mb.</div>
               <div>1.11 documentation the API</div>
               <h3 style="padding-top:20px;">2. Analysis and the Approaches</h3>
               <hr>
               <div>2.1 Analysis</div>
               <div>Since it's a web application, Java and Spring framework will be a good answer for it, they have been most used to implement enterprise applications.  
                  This application also requires user authentication, Spring security framework can be used to handle that.  To retrieve users information, we also need database and Java Hiberate framework to work with. I am familiar with Mysql, so I will adopt Mysql database to store users information.</div>
               <div>For upload video process, there are two approaches, one way is directly post video to s3 bucket, the other will upload to EC2 server first, after retrieving video information, then move video file to S3 bucket. I will implement second approach in this application.</div>
               <div>There are some good open source tools can be used to retrieve video information, I will use "ffmpeg" and "ffprobe", "ffmpeg" can be used to encode video as well. </div>
               <div>For documentation, we can use javadoc.</div>
               <h3 style="padding-top:20px;">3. technology behind this project</h3>
               <hr>
               <div>3.1 AWS solution</div>
               <div>AWS provides easy to use, reliable, scalable and flexible web service in different ways. I use AWS EC2 to host this application. AWS S3 service to store uploaded files. RDS for database, Elastic Transcoder for video conversion, create microservice using Lambda to automatically call video conversion task.</div>
               <br>
               <div>3.2 Back end</div>
               <div>Java + Spring + Spring Security + Hiberate + mvn + mysql + ffprobe + aws-sdk-java + MVC</div>
               <br>
               <div>3.3 Front end</div>
               <div>javascript + html + css+ jQuery + videoJS + bootstrap.js + bootstrap freelancer template</div>
               <br>
               <div>3.4 IDE</div>
               <div>eclipse 4.7.1</div>
                <h3 style="padding-top:20px;">4. Testing</h3>
               <hr>
               <div><a href="http://s3video.snapvio.com:8080">Click here</a> to test the application, username and credential will be provided by email. User can conduct login, logout, upload video, list uploaded videos on s3, watch video and retrieve video information after uploading tasks. </div>
               <h3 style="padding-top:20px;">5. Documentation</h3>
               <hr>
               <div><a href="https://mmzh.github.io/s3-video-uploader/">Click here</a> to access app documentation</div>

