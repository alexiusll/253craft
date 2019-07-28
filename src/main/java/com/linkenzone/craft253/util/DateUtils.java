package com.linkenzone.craft253.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	/**
	 * date对象转换成String (datetime) 2017-09-18 12:17:18
	 * 
	 * @param date
	 * @return
	 */
	public static String getFormatDate(Date date) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(date);
	}

	/**
	 * String(datetime)转换成date对象
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date getDate(String date) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return format.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
}
