package com.test.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

	public static String formatDate(Date date){
		if(date == null){
			return "";
		}
		SimpleDateFormat format = new SimpleDateFormat("YYY-MM-dd HH:mm:ss");
		return format.format(date);
	}
}
