package com.vm.app.model;

/**
 * video model
 * 
 * @author ming
 * @version 1.0.0
 */
public class Video {

	/**
	 * video name
	 */
	private String Name;
	/**
	 * s3 url link
	 */
	private String S3url;
	/**
	 * video serialized detail
	 */
	private String Detail;
	/**
	 * video size
	 */
	private String Size;
	/**
	 * video added date
	 */
	private String Date;
	/**
	 * hls format url
	 */
	private String Hlsurl;

	/**
	 * set video name
	 * 
	 * @param name video name
	 */
	public void setName(String name) {

		this.Name = name;
	}

	/**
	 * get video name
	 * 
	 * @return String video name
	 */
	public String getName() {
		return this.Name;
	}

	/**
	 * set s3 url link
	 * 
	 * @param url
	 *            string link
	 */
	public void setS3url(String url) {
		this.S3url = url;
	}

	/**
	 * get s3 url link
	 * 
	 * @return String s3 url link
	 */
	public String getS3url() {
		return this.S3url;
	}

	/**
	 * set serialized video detail
	 * 
	 * @param detail
	 *            video detail
	 */
	public void setDetail(String detail) {
		this.Detail = detail;
	}

	/**
	 * get serialized video detail
	 * 
	 * @return String video detail
	 */
	public String getDetail() {
		return this.Detail;
	}

	/**
	 * set video size
	 * 
	 * @param size
	 *            video size
	 */
	public void setSize(String size) {
		this.Size = size;
	}

	/**
	 * get video size
	 * 
	 * @return size in String
	 */
	public String getSize() {
		return this.Size;
	}

	/**
	 * set video added date
	 * 
	 * @param date
	 *            video add date
	 */
	public void setDate(String date) {
		this.Date = date;
	}

	/**
	 * get video added date
	 * 
	 * @return date in string format
	 */
	public String getDate() {
		return this.Date;
	}

	/**
	 * set hls video format url
	 * 
	 * @param url
	 *            video hls format url
	 */
	public void setHlsurl(String url) {
		this.Hlsurl = url;
	}

	/**
	 * get hls video format url
	 * 
	 * @return String of url
	 */
	public String getHlsurl() {
		return this.Hlsurl;
	}
}