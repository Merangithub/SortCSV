package com.gzmd.search;

import java.util.LinkedList;

import com.gzmd.domain.EnterpriseInfo;

/**
 * ˳������㷨
 * 
 * @author Meran
 *
 */
public class SequenceSearch {
	
	/**
	 * ��������
	 * ˳����ҶԲ��ҵ����в�Ҫ������
	 * 
	 * @param obj
	 * 			Object����
	 * @param value
	 * 			Ŀ���������
	 * @return	Ŀ��������ݵĶ���
	 */
	public EnterpriseInfo sequenceSearchArray(Object[] obj, double value) {
		for (int i = 0; i < obj.length - 1; i++) {
			if (value == ((EnterpriseInfo) obj[i]).getZCZB()) {
				System.out.println("�ҵ���");
				return (EnterpriseInfo) obj[i];
			}
		}
		System.out.println("û�ҵ�");
		return null;
	}
	
	/**
	 * ���Ҽ���
	 * 
	 * @param list
	 * 			EnterpriseInfo���͵�LinkedList����
	 * @param value
	 * 			Ŀ���������
	 * @return	Ŀ��������ݵĶ���
	 */
	public EnterpriseInfo sequenceSearchList(LinkedList<EnterpriseInfo> list, double value) {
		for (int i = 0; i < list.size() - 1; i++) {
			if (value == list.get(i).getZCZB()) {
				System.out.println("�ҵ���");
				return list.get(i);
			}
		}
		System.out.println("û�ҵ�");
		return null;
	}
}
