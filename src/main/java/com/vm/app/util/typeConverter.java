/**
 * <h1>typeConverter class</h1>
 * @author Ming M Zheng 
 * @version 1.0
 * @since 2017-10-21
 */
package com.vm.app.util;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class typeConverter {

    /**
     * @param data, Date format
     * @return more friendly date String using the format MM/dd/yyyy kk:mm:ss
     */
    static String shiftTimeZone(Date date) throws ParseException {

        DateFormat inDF = new SimpleDateFormat("MM/dd/yyyy kk:mm:ss");
        String strDate = inDF.format(date);
        return strDate;
    }
	/**
	 * 
	 * @param size This is size in bit
	 * @return more human friendly format of size
	 */
    static String getReadableSize(String size) {

        String readableSize = "";
        int s = Integer.parseInt(size);
        double k = s / 1024.0;
        double m = s / 1048576.0;
        double g = s / 1073741824.0;
        double t = s / (1024 * 1073741824.0);

        DecimalFormat dec = new DecimalFormat("0.0");

        if (t > 1) {

            readableSize = dec.format(t).concat("TB");
        } else if (g > 1) {

            readableSize = dec.format(g).concat("GB");
        } else if (m > 1) {

            readableSize = dec.format(m).concat("MB");
        } else if (k > 1) {

            readableSize = dec.format(k).concat("KB");

        } else readableSize = dec.format(s).concat("B");

        return readableSize;

    }


}