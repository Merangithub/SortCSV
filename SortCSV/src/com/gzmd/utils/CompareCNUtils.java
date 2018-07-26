package com.gzmd.utils;

import java.text.Collator;
import java.util.Comparator;

/**
 * �Ƚ�����ƴ������ĸ��˳���С
 * 
 * @author Meran
 *
 */
public class CompareCNUtils {

	/**
	 * �Ƚ����������ַ�ƴ������ĸ˳���С
	 * 
	 * @param str1
	 *            ��һ���ַ�
	 * @param str2
	 *            �ڶ����ַ�
	 * @return ���ݵ�һ������С�ڡ����ڻ���ڵڶ��������ֱ𷵻ظ������������������
	 */
	public int compareChinese(String str1, String str2) {
		Comparator<Object> com = Collator.getInstance(java.util.Locale.CHINA);
		return com.compare(str1, str2);
	}
}
