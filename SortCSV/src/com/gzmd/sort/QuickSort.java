package com.gzmd.sort;

import java.util.LinkedList;

import com.gzmd.domain.EnterpriseInfo;

public class QuickSort {
	public LinkedList<EnterpriseInfo> quickSort (LinkedList<EnterpriseInfo> list, int start, int end) {
		int left = start;
		int right = end;
		EnterpriseInfo key = null;
		if (left <= right) {
			key = list.get(left);
			while (left != right) {
			
				while ( left < right && list.get(right).getZCZB() >= key.getZCZB()) {
					right--;
				}
				list.set(left, list.get(right));
				
				while ( left < right && list.get(left).getZCZB() <= key.getZCZB()) {
					left++;
				}
				list.set(right, list.get(left));
			}

//			当left等于right的时候,将key归位
			list.set(right, key);
			
			quickSort(list,start, left - 1);
			quickSort(list,right + 1, end);
		}
		return list;
	}
	
}
