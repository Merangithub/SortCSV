package com.gzmd.utils;

import java.text.Collator;
import java.util.Comparator;

public class CompareCNUtils {
	public int compareChinese(String str1, String str2) {
		Comparator<Object> com=Collator.getInstance(java.util.Locale.CHINA);
		return com.compare(str1, str2);
	}
}
