package com.gzmd.search;

import java.util.LinkedList;

import com.gzmd.domain.EnterpriseInfo;

/**
 * ���ֲ����㷨
 * 
 * @author Meran
 *
 */
public class BinarySearch {

	/**
	 * ���ֲ���
	 * 
	 * @param list
	 *            EnterpriseInfo���͵�LinkedList����
	 * @param value
	 *            Ŀ���������
	 * @return EnterpriseInfo����
	 */
	public EnterpriseInfo binarySearch(LinkedList<EnterpriseInfo> list, double value) {
		int low = 0;
		int high = list.size() - 1;
		int mid;
		while (low <= high) {
			mid = (low + high) / 2;
			if (list.get(mid).getZCZB() == value) {
				System.out.println("�ҵ���");
				return list.get(mid);
			}
			if (list.get(mid).getZCZB() > value) {
				high = mid - 1;
			}
			if (list.get(mid).getZCZB() < value) {
				low = mid + 1;
			}
		}
		System.out.println("û���ҵ�");
		return null;
	}
}
