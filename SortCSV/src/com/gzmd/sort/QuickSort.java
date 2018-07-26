package com.gzmd.sort;

import java.util.Date;
import java.util.LinkedList;

import com.gzmd.domain.EnterpriseInfo;
import com.gzmd.utils.CompareCNUtils;
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
	 * 
	 * @param list
	 *            List����
	 * @param start
	 *            ���ϵ����
	 * @param end
	 *            ���ϵ�ĩβ
	 * @return ���������ļ���
	 */
	public LinkedList<EnterpriseInfo> quickSort(LinkedList<EnterpriseInfo> list, int start, int end, int column) {
		int left = start;
		int right = end;
		EnterpriseInfo key = null;

		switch (column) {
		// �ڲ����
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

				list.set(right, key);// ��left����right��ʱ��,��key��λ

				quickSort(list, start, left - 1, column);
				quickSort(list, right + 1, end, column);
			}

			break;
		// ע���ʱ�
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

				list.set(right, key);// ��left����right��ʱ��,��key��λ

				quickSort(list, start, left - 1, column);
				quickSort(list, right + 1, end, column);
			}

			break;
		// ��׼����
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

				list.set(right, key);// ��left����right��ʱ��,��key��λ

				quickSort(list, start, left - 1, column);
				quickSort(list, right + 1, end, column);
			}

			break;
		// ��ҵ����
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

				list.set(right, key);// ��left����right��ʱ��,��key��λ

				quickSort(list, start, left - 1, column);
				quickSort(list, right + 1, end, column);
			}

			break;
		}

		return list;
	}
}
