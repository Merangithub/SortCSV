package com.gzmd.utils;

import java.text.Collator;
import java.util.Comparator;

/**
 * 比较中文拼音首字母的顺序大小
 * 
 * @author Meran
 *
 */
public class CompareCNUtils {

	/**
	 * 比较两个中文字符拼音首字母顺序大小
	 * 
	 * @param str1
	 *            第一个字符
	 * @param str2
	 *            第二个字符
	 * @return 根据第一个参数小于、等于或大于第二个参数分别返回负整数、零或正整数。
	 */
	public int compareChinese(String str1, String str2) {
		Comparator<Object> com = Collator.getInstance(java.util.Locale.CHINA);
		return com.compare(str1, str2);
	}
}
