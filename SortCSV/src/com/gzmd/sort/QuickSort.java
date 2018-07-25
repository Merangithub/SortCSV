package com.gzmd.sort;

import java.util.Date;
import java.util.LinkedList;

import com.gzmd.domain.EnterpriseInfo;
import com.gzmd.utils.DateUtils;

/**
 * ���������㷨
 * 
 * @author Meran
 *
 */
public class QuickSort {
	
	/**
	 * ��EnterpriseInfo���͵�LinkedList���Ͻ��п�������
	 * @param list
	 * 			List����
	 * @param start
	 * 			���ϵ����
	 * @param end
	 * 			���ϵ�ĩβ
	 * @return	���������ļ���
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

//				��left����right��ʱ��,��key��λ
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

//				��left����right��ʱ��,��key��λ
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

//				��left����right��ʱ��,��key��λ
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
