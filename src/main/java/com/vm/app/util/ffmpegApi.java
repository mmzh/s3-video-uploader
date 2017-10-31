package com.vm.app.util;

import java.io.*;
import java.util.ArrayList;

/**
 * util class for processing video and audio using ffmpeg and ffprobe
 * 
 * @author Ming M Zheng
 * @version 1.0
 * @since 2017-10-21
 */
public class ffmpegApi {
	
	private String ffprobePath;

	public ArrayList<String> infos;

	public ffmpegApi() {
		infos = new ArrayList<String>();
		this.ffprobePath="J:/uploaded/ffprobe.exe";
	}

	/**
	 * This method is used to retrieve video info using ffprobe.
	 * 
	 * @param vPath
	 *            This is the only parameter, which is file path in String form
	 * @return ArrayList, which contains a list of video information, including,
	 *         video/audio/data bitrate, duration, resolution and codec.
	 * @see IOException        
	 */
	public ArrayList<String> getVideoFileInfo(String vPath) throws IOException {
		Process p = Runtime.getRuntime().exec(this.ffprobePath + " -show_streams \"" + vPath + "\"");
		BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String s = "";
		boolean durationFlag = false;
		while ((s = stdInput.readLine()) != null) {
			if (s.indexOf("unknown") > -1)
				continue;
			if (s.indexOf("bit_rate=") == 0) {
				String br = s.replace("bit_rate=", "");
				if (isNumeric(br))
					br = Integer.parseInt(br) / 1000 + "kbs";
				infos.add("Bit_rate=" + br);
			}
			if (durationFlag == false && s.indexOf("duration=") == 0) {
				String dur = s.replace("duration=", "");
				if (isNumeric(dur)) {
					dur = (int) Float.parseFloat(dur) + "s";
					infos.add("Duration=" + dur);
					durationFlag = true;
				}
			}

			if (s.indexOf("height=") == 0 || s.indexOf("width=") == 0 || s.indexOf("codec_type=") == 0
					|| s.indexOf("codec_name=") == 0) {
				infos.add(s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase());
			}
		}

		return infos; 
	}

	/**
	 * This method is used to check if a String contains only numbers.
	 * 
	 * @param s
	 *            a string
	 * @return boolean
	 */
	public boolean isNumeric(String s) {
		return s != null && s.matches("[-+]?\\d*\\.?\\d+");
	}
}