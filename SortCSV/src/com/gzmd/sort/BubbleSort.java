package com.gzmd.sort;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.gzmd.domain.EnterpriseInfo;
import com.gzmd.readfile.ReadCSV;
import com.gzmd.utils.CompareCNUtils;
import com.gzmd.utils.DateUtils;
import com.gzmd.writesortedfile.WriteCSV;

/**
 * ð�������㷨
 * 
 * @author Meran
 *
 */
public class BubbleSort {

	/**
	 * ��EnterpriseInfo���͵�List���Ͻ���ð������
	 * 
	 * @param list
	 *          EnterpriseInfo���͵�List����
	 * @param column
	 * 			ѡ��ָ�����ֶ�����
	 * @return �ź����List����
	 */

	public List bubbleSort(List<EnterpriseInfo> list, int column) {

		EnterpriseInfo temp = null;
		switch (column) {
		case 1:
			
			System.out.println("�����");
			for (int i = 0; i < list.size() - 1; i++) {
				for (int j = 0; j < list.size() - 1 - i; j++) {
					if (Long.parseLong((list.get(j)).getNBXH()) > Long.parseLong((list.get(j + 1)).getNBXH())) {
						temp = list.get(j);
						list.set(j, list.get(j + 1));
						list.set(j + 1, temp);
					}
				}
			}

			break;
		case 2:

			System.out.println("�����");
			for (int i = 0; i < list.size() - 1; i++) {
				for (int j = 0; j < list.size() - 1 - i; j++) {
					if ((list.get(j)).getZCZB() > (list.get(j + 1)).getZCZB()) {
						temp = list.get(j);
						list.set(j, list.get(j + 1));
						list.set(j + 1, temp);
					}
				}
			} 

			break;
		case 3:
			
			DateUtils du = new DateUtils();
			System.out.println("�����");
			for (int i = 0; i < list.size() - 1; i++) {
				for (int j = 0; j < list.size() - 1 - i; j++) {
					//���ַ���ת����Date����
					Date date1 = du.parseDate(list.get(j).getHZRQ());
					Date date2 = du.parseDate(list.get(j + 1).getHZRQ());
					if (date2.before(date1)) {
						temp = list.get(j);
						list.set(j, list.get(j + 1));
						list.set(j + 1, temp);
					}
				}
			} 
			
			break;
		case 4:
			
			CompareCNUtils cu = new CompareCNUtils();
			System.out.println("�����");
			for (int i = 0; i < list.size() - 1; i++) {
				for (int j = 0; j < list.size() - 1 - i; j++) {
					if (cu.compareChinese(list.get(j).getQYMC(), list.get(j + 1).getQYMC()) >= 0) {
						temp = list.get(j);
						list.set(j, list.get(j + 1));
						list.set(j + 1, temp);
					}
				}
			} 
			
			break;
		}

		
		return list;
		
		///////////////////////////////////////////////////////////////////////////////
		// ��ͨ��������ת�������飬�����������Դﵽ��ԭ���������Ŀ��
		//
		// Object[] objs = list.toArray();
		// Object temp = null;
		// for (int i = 0; i < objs.length -1; i++) {
		// for (int j = 0; j < objs.length - 1 - i; j++) {
		// if(((EnterpriseInfo)objs[j]).getZCZB() > ((EnterpriseInfo)objs[j + 1]).getZCZB()){
		// temp = objs[j];
		// objs[j] = objs[j + 1];
		// objs[j + 1] = temp;
		// }
		// }
		// }
		// for (int i = 0; i < objs.length; i++) {
		// System.out.println(((EnterpriseInfo) objs[i]).getZCZB() + "\t" + ((EnterpriseInfo)objs[i]).getQYMC());
		// }
		// return objs;
		///////////////////////////////////////////////////////////////////////////////
	}
}
