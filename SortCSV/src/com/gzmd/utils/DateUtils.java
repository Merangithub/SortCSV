package com.gzmd.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ��String����ת����Date���ͣ������е������У��º���ֻ��һλ�����磺2018/7/25
 * �����·ݾ�ֻ��һ��7�����²���ͨ��SimpleDateFormat��parse()��������������
 * �˹�����ͽ���Щ��������ݲ�����λ�����·����ڷֱ�����λ��ʱ������ǰ����0,������ parse()�����Ľ���������
 * 
 * @author Meran
 *
 */
public class DateUtils {
	public Date parseDate(String str) {
		Date date = null; // ���ս���������ڱ���
		String[] s = new String[10];
		String strDate = null; //���ո�ʽ�����String���͵�����
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
			date = sdf.parse(strDate); //������ȷ��ʽ������
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}
}
