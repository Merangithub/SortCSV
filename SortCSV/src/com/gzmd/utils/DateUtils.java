package com.gzmd.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 将String类型转换成Date类型，由于有的日期中，月和日只有一位数比如：2018/7/25
 * 其中月份就只有一个7，导致不能通过SimpleDateFormat的parse()方法解析成日期
 * 此工具类就将这些日期在年份不足四位数，月份日期分别不足两位数时，在其前面添0,来满足 parse()方法的解析条件。
 * 
 * @author Meran
 *
 */
public class DateUtils {
	public Date parseDate(String str) {
		Date date = null; // 接收解析后的日期变量
		String[] s = new String[10];
		String strDate = null; //接收格式化后的String类型的日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		try {
			if (str == "9999/99/99") {
				strDate = "9999/99/99";
			} else if (str.length() < 10) {
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
			date = sdf.parse(strDate); //解析正确格式的日期
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}
}
