package com.gzmd.sort;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.gzmd.domain.EnterpriseInfo;
import com.gzmd.utils.CompareCNUtils;
import com.gzmd.utils.DateUtils;

public class MergeSort {
	
	/**
	 * ����sort���ط�����list�������򣬲�ͳ������ʱ��
	 * @param list
	 * 			list����
	 * @param column
	 * 			ѡ��ָ�����ֶ�����
	 * @return	Object��������
	 */
	public Object[] sort (LinkedList<EnterpriseInfo> list , int column) {
		Object[] arr = list.toArray();//�Ѽ��ϱ������
		
		Object[] temp = new Object[arr.length];//�Ƚ���һ�����ȵ���Ԫ���鳤�ȵ���ʱ���飬����ݹ������Ƶ�����ٿռ�
		System.out.println("�����");
		long startTime = System.currentTimeMillis(); // ��ȡ��ʼʱ��
		
		sort(arr, 0, arr.length - 1, temp, column);
		
		long endTime = System.currentTimeMillis(); // ��ȡ����ʱ��
		System.out.println("��������ʱ�䣺 " + (endTime - startTime) + "ms");
		return arr;
	}
	
	
	/**
	 * �ݹ���Object���������е�Ԫ�ؽ�������
	 * @param oldArr
	 * 			Դ���飬δ�����
	 * @param left
	 * 			���������е��±�
	 * @param right
	 * 			����ұ����е��±�
	 * @param tempArr
	 * 			Ŀ�����飬�ź����
	 */
	private void sort(Object[] oldArr, int left, int right, Object[] tempArr, int column) {
		if (left < right) {
			int mid = (left + right) / 2;
			sort (oldArr, left, mid, tempArr, column);//ʹ�������
			sort (oldArr, mid + 1, right, tempArr, column);//ʹ�ұ�����
			merge (oldArr, left, mid, right, tempArr, column);
		}
	}
	
	
	/**
	 * ����
	 * @param oldArr
	 * 			Դ����
	 * @param left
	 * 			���������е��±�
	 * @param mid
	 * 			������������֮�������
	 * @param right
	 * 			����ұ����е��±�
	 * @param tempArr
	 * 			Ŀ������
	 */
	private void merge (Object[] oldArr, int left, int mid, int right, Object[] tempArr, int column) {
		DateUtils du = new DateUtils();
		CompareCNUtils cnu = new CompareCNUtils();
		int i = left;//������ָ��
		int j = mid + 1;//������ָ��
		int t= 0;//��ʱ���ϵ�ָ��
		
		switch (column) {
		case 1:
			
			while ((i <= mid) && (j <= right)) {
				if (Long.parseLong(((EnterpriseInfo)oldArr[i]).getNBXH()) <= Long.parseLong(((EnterpriseInfo)oldArr[j]).getNBXH())) {
					tempArr[t++] = oldArr[i++];
				} else {
					tempArr[t++] = oldArr[j++];
				}
			}
			while (i <= mid) {//�����ʣ��Ԫ������tempArr��
				tempArr[t++] = oldArr[i++];
			}
			while (j <= right) {//���ұ�ʣ��Ԫ������tempArr��
				tempArr[t++] = oldArr[j++];
			}
			t = 0;
			//��tempArr�е�Ԫ��ȫ��������ԭ����������
			while (left <= right) {
				oldArr[left++] = tempArr[t++];
			}
			
			break;
		case 2:
			
			while ((i <= mid) && (j <= right)) {
				if (((EnterpriseInfo)oldArr[i]).getZCZB() <= ((EnterpriseInfo)oldArr[j]).getZCZB()) {
					tempArr[t++] = oldArr[i++];
				} else {
					tempArr[t++] = oldArr[j++];
				}
			}
			while (i <= mid) {//�����ʣ��Ԫ������tempArr��
				tempArr[t++] = oldArr[i++];
			}
			while (j <= right) {//���ұ�ʣ��Ԫ������tempArr��
				tempArr[t++] = oldArr[j++];
			}
			t = 0;
			//��tempArr�е�Ԫ��ȫ��������ԭ����������
			while (left <= right) {
				oldArr[left++] = tempArr[t++];
			}
			
			break;
		case 3:
			
			while ((i <= mid) && (j <= right)) {
				//���ַ���ת����Date����
				Date date1 = du.parseDate(((EnterpriseInfo)oldArr[i]).getHZRQ());
				Date date2 = du.parseDate(((EnterpriseInfo)oldArr[j]).getHZRQ());
				if (date1.before(date2)) {
					tempArr[t++] = oldArr[i++];
				} else {
					tempArr[t++] = oldArr[j++];
				}
			}
			while (i <= mid) {//�����ʣ��Ԫ������tempArr��
				tempArr[t++] = oldArr[i++];
			}
			while (j <= right) {//���ұ�ʣ��Ԫ������tempArr��
				tempArr[t++] = oldArr[j++];
			}
			t = 0;
			//��tempArr�е�Ԫ��ȫ��������ԭ����������
			while (left <= right) {
				oldArr[left++] = tempArr[t++];
			}
			
			break;
		case 4:
			
			while ((i <= mid) && (j <= right)) {
				if ((cnu.compareChinese(((EnterpriseInfo)oldArr[i]).getQYMC(), ((EnterpriseInfo)oldArr[j]).getQYMC())) <= 0) {
					tempArr[t++] = oldArr[i++];
				} else {
					tempArr[t++] = oldArr[j++];
				}
			}
			while (i <= mid) {//�����ʣ��Ԫ������tempArr��
				tempArr[t++] = oldArr[i++];
			}
			while (j <= right) {//���ұ�ʣ��Ԫ������tempArr��
				tempArr[t++] = oldArr[j++];
			}
			t = 0;
			//��tempArr�е�Ԫ��ȫ��������ԭ����������
			while (left <= right) {
				oldArr[left++] = tempArr[t++];
			}
			
			break;
		default:
			
		} 
		
		
	}
}
