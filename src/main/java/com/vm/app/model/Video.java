package com.vm.app.model;

public class Video {
 
    private String Name;
    private String S3url;
    private String Detail;
    private String Size;
    private String Date;
    
    public void setName(String name) {
    	
    	this.Name=name;
    }
    
    public String getName() {
    	return this.Name;
    }
    public void setS3url(String url) {
    	this.S3url=url;
    }
    
    public String getS3url() {
    	return this.S3url;
    }
    public void setDetail(String detail) {
    	this.Detail=detail;
    }
    
    public String getDetail() {
    	return this.Detail;
    }
    public void setSize(String size) {
    	this.Size=size;
    }
    
    public String getSize() {
    	return this.Size;
    }
    public void setDate(String date) {
    	this.Date=date;
    }
    
    public String getDate() {
    	return this.Date;
    }
}