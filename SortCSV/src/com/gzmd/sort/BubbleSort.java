package com.gzmd.sort;

import java.util.LinkedList;
import java.util.List;

import com.gzmd.domain.EnterpriseInfo;
import com.gzmd.readfile.ReadCSV;
import com.gzmd.writesortedfile.WriteCSV;

/**
 * ð������
 * 
 * @author Meran
 *
 */
public class BubbleSort {

	/**
	 * @param list
	 *            EnterpriseInfo���͵�List����
	 * @return �ź���ļ���
	 */

	public List bubbleSort(List<EnterpriseInfo> list) {

//		System.out.println("����ǰ��");
//		for (Object s : list) {
//			System.out.println(((EnterpriseInfo) s).getZCZB() + "\t" + ((EnterpriseInfo) s).getQYMC());
//		}

		System.out.println("�����");
		EnterpriseInfo temp = null;
		long startTime = System.currentTimeMillis(); // ��ȡ��ʼʱ��
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = 0; j < list.size() - 1 - i; j++) {
				if ((list.get(j)).getZCZB() > (list.get(j + 1)).getZCZB()) {
					temp = list.get(j);
					list.set(j, list.get(j + 1));
					list.set(j + 1, temp);
				}
			}
		}
		long endTime = System.currentTimeMillis(); // ��ȡ����ʱ��
		for (EnterpriseInfo e : list) {
			System.out.println(e.getZCZB() + "\t" + e.getQYMC());
		}

		System.out.println("��������ʱ�䣺 " + (endTime - startTime) + "ms");
		return list;
		///////////////////////////////////////////////////////////////////////////////
		// �ڶ��ֽ���������Ԫ��λ�õķ���
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

	public void test() {
		ReadCSV rc = new ReadCSV();
		WriteCSV wc = new WriteCSV();
		List<EnterpriseInfo> list = rc.readFile();
		List sortedList = bubbleSort(list);
//		wc.writeFile(sortedList);
	}
}

/**
 * https://www.cnblogs.com/wanggd/p/3214713.html
 * https://www.cnblogs.com/shen-hua/p/5422676.html
 *
 **/