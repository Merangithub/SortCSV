package com.gzmd.sort;

import java.util.Date;
import java.util.LinkedList;

import com.gzmd.domain.EnterpriseInfo;
import com.gzmd.utils.CompareCNUtils;
import com.gzmd.utils.DateUtils;

/**
 * 快速排序算法
 * 
 * @author Meran
 *
 */
public class QuickSort {

	/**
	 * 对EnterpriseInfo类型的LinkedList集合进行快速排序
	 * 
	 * @param list
	 *            List集合
	 * @param start
	 *            集合的起点
	 * @param end
	 *            集合的末尾
	 * @return 快速排序后的集合
	 */
	public LinkedList<EnterpriseInfo> quickSort(LinkedList<EnterpriseInfo> list, int start, int end, int column) {
		int left = start;
		int right = end;
		EnterpriseInfo key = null;

		switch (column) {
		// 内部序号
		case 1:

			if (left <= right) {
				key = list.get(left);
				while (left != right) {
					while (left < right && Long.parseLong(list.get(right).getNBXH()) >= Long.parseLong(key.getNBXH())) {
						right--;
					}
					list.set(left, list.get(right));

					while (left < right && Long.parseLong(list.get(left).getNBXH()) <= Long.parseLong(key.getNBXH())) {
						left++;
					}
					list.set(right, list.get(left));
				}

				list.set(right, key);// 当left等于right的时候,将key归位

				quickSort(list, start, left - 1, column);
				quickSort(list, right + 1, end, column);
			}

			break;
		// 注册资本
		case 2:

			if (left <= right) {
				key = list.get(left);
				while (left != right) {
					while (left < right && list.get(right).getZCZB() >= key.getZCZB()) {
						right--;
					}
					list.set(left, list.get(right));

					while (left < right && list.get(left).getZCZB() <= key.getZCZB()) {
						left++;
					}
					list.set(right, list.get(left));
				}

				list.set(right, key);// 当left等于right的时候,将key归位

				quickSort(list, start, left - 1, column);
				quickSort(list, right + 1, end, column);
			}

			break;
		// 核准日期
		case 3:

			DateUtils du = new DateUtils();

			if (left <= right) {
				key = list.get(left);

				while (left != right) {
					while (left < right
							&& du.parseDate(list.get(right).getHZRQ()).compareTo(du.parseDate(key.getHZRQ())) >= 0) {
						right--;
					}
					list.set(left, list.get(right));

					while (left < right
							&& du.parseDate(list.get(left).getHZRQ()).compareTo(du.parseDate(key.getHZRQ())) <= 0) {
						left++;
					}
					list.set(right, list.get(left));
				}

				list.set(right, key);// 当left等于right的时候,将key归位

				quickSort(list, start, left - 1, column);
				quickSort(list, right + 1, end, column);
			}

			break;
		// 企业名称
		case 4:

			CompareCNUtils cc = new CompareCNUtils();

			if (left <= right) {
				key = list.get(left);
				while (left != right) {
					while (left < right && cc.compareChinese(list.get(right).getQYMC(), key.getQYMC()) >= 0) {
						right--;
					}
					list.set(left, list.get(right));

					while (left < right && cc.compareChinese(list.get(left).getQYMC(), key.getQYMC()) <= 0) {
						left++;
					}
					list.set(right, list.get(left));
				}

				list.set(right, key);// 当left等于right的时候,将key归位

				quickSort(list, start, left - 1, column);
				quickSort(list, right + 1, end, column);
			}

			break;
		}

		return list;
	}
}
