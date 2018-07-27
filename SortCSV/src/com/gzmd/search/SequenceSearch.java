package com.gzmd.search;

import java.util.LinkedList;

import com.gzmd.domain.EnterpriseInfo;

/**
 * 顺序查找算法
 * 
 * @author Meran
 *
 */
public class SequenceSearch {
	
	/**
	 * 查找数组
	 * 顺序查找对查找的序列不要求有序
	 * 
	 * @param obj
	 * 			Object数组
	 * @param value
	 * 			目标查找数据
	 * @return	目标查找数据的对象
	 */
	public EnterpriseInfo sequenceSearchArray(Object[] obj, double value) {
		for (int i = 0; i < obj.length - 1; i++) {
			if (value == ((EnterpriseInfo) obj[i]).getZCZB()) {
				System.out.println("找到了");
				return (EnterpriseInfo) obj[i];
			}
		}
		System.out.println("没找到");
		return null;
	}
	
	/**
	 * 查找集合
	 * 
	 * @param list
	 * 			EnterpriseInfo类型的LinkedList集合
	 * @param value
	 * 			目标查找数据
	 * @return	目标查找数据的对象
	 */
	public EnterpriseInfo sequenceSearchList(LinkedList<EnterpriseInfo> list, double value) {
		for (int i = 0; i < list.size() - 1; i++) {
			if (value == list.get(i).getZCZB()) {
				System.out.println("找到了");
				return list.get(i);
			}
		}
		System.out.println("没找到");
		return null;
	}
}
