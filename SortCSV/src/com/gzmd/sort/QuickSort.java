package com.gzmd.sort;

import java.util.Date;
import java.util.LinkedList;

import com.gzmd.domain.EnterpriseInfo;
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
	 * @param list
	 * 			List集合
	 * @param start
	 * 			集合的起点
	 * @param end
	 * 			集合的末尾
	 * @return	快速排序后的集合
	 */
	public LinkedList<EnterpriseInfo> quickSort (LinkedList<EnterpriseInfo> list, int start, int end, int column) {
		int left = start;
		int right = end;
		EnterpriseInfo key = null;
		
		switch (column) {
		case 1:
			
			if (left <= right) {
				key = list.get(left);
				while (left != right) {
					while (left < right && Long.parseLong(list.get(right).getNBXH()) >= Long.parseLong(key.getNBXH())) {
						right--;
					}
					list.set(left, list.get(right));
					
					while ( left < right && Long.parseLong(list.get(left).getNBXH()) <= Long.parseLong(key.getNBXH())) {
						left++;
					}
					list.set(right, list.get(left));
				}

//				当left等于right的时候,将key归位
				list.set(right, key);
				
				quickSort(list,start, left - 1, column);
				quickSort(list,right + 1, end ,column);
			}
			
			break;
		case 2:
			
			if (left <= right) {
				key = list.get(left);
				while (left != right) {
					while (left < right && list.get(right).getZCZB() >= key.getZCZB()) {
						right--;
					}
					list.set(left, list.get(right));
					
					while ( left < right && list.get(left).getZCZB() <= key.getZCZB()) {
						left++;
					}
					list.set(right, list.get(left));
				}

//				当left等于right的时候,将key归位
				list.set(right, key);
				
				quickSort(list,start, left - 1, column);
				quickSort(list,right + 1, end ,column);
			}
			
			break;
		case 3:
			
			DateUtils du = new DateUtils();
			Date date1 = null;
			Date date2 = null;
			Date keyDate = null;
			if (left <= right) {
				key = list.get(left);
				
				while (left != right) {
					keyDate = du.parseDate(key.getHZRQ());
					
					date1 = du.parseDate(list.get(right).getHZRQ());
					while (left < right && (date1.before(keyDate) || date1 == keyDate)) {
						right--;
					}
					list.set(left, list.get(right));
					
					date2 = du.parseDate(list.get(left).getHZRQ());
					while ( left < right && (date2.before(keyDate) || date2 == keyDate)) {
						left++;
					}
					list.set(right, list.get(left));
				}

//				当left等于right的时候,将key归位
				list.set(right, key);
				
				quickSort(list,start, left - 1, column);
				quickSort(list,right + 1, end ,column);
			}
			
			break;
		case 4:
			break;
		}
		
		return list;
	}
}
