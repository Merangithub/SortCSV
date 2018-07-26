package com.gzmd.search;

import java.util.LinkedList;

import com.gzmd.domain.EnterpriseInfo;

/**
 * 二分查找算法
 * 
 * @author Meran
 *
 */
public class BinarySearch {

	/**
	 * 二分查找
	 * 
	 * @param list
	 *            EnterpriseInfo类型的LinkedList集合
	 * @param value
	 *            目标查找数据
	 * @return EnterpriseInfo对象
	 */
	public EnterpriseInfo binarySearch(LinkedList<EnterpriseInfo> list, double value) {
		int low = 0;
		int high = list.size() - 1;
		int mid;
		while (low <= high) {
			mid = (low + high) / 2;
			if (list.get(mid).getZCZB() == value) {
				System.out.println("找到了");
				return list.get(mid);
			}
			if (list.get(mid).getZCZB() > value) {
				high = mid - 1;
			}
			if (list.get(mid).getZCZB() < value) {
				low = mid + 1;
			}
		}
		System.out.println("没有找到");
		return null;
	}
}
