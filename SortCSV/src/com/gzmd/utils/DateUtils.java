package com.gzmd.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author Meran
 *
 */
public class DateUtils {
	public Date parseDate(String str) {
		System.out.println(str);
		Date date = null;
		String[] s = new String[10];
		String strDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		if (str == null || str == "") {
			strDate = "9999/12/31";
		}
		try {
			if (str != null && str.length() < 10) {
				s = str.split("/");
				while (s[0].length() < 4) {
					s[0] = "0" + s[0];
				}
				if (s[1].length() < 2) {
					s[1] = "0" + s[1];
				} 
				if (s[2].length() < 2) {
					s[2] = "0" + s[2];
				}
				strDate = s[0] + "/" + s[1] + "/" + s[2];
			} else {
				strDate = str;
			}

			date = sdf.parse(strDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}

}
