package com.gzmd.test;

import java.util.LinkedList;

import com.gzmd.domain.EnterpriseInfo;
/**
 * �������
 * 
 * @author Meran
 *
 */
public class PrintTest {
	
	/**
	 * ��ӡ�������
	 * 
	 * @param list
	 * 			list����
	 */
	public void printList(LinkedList<EnterpriseInfo> list){
		for (EnterpriseInfo e : list) {
			System.out.println(e.getZCZB() + "\t" + e.getNBXH() + "\t" + e.getHZRQ() + "\t" + e.getQYMC());
		}
	}
	
	/**
	 * ��ӡ�������
	 * 
	 * @param obj
	 * 			Object���͵�����
	 */
	public void printArray (Object[] obj) {
		for (Object o : obj) {
			System.out.println(((EnterpriseInfo)o).getZCZB() + "\t" + ((EnterpriseInfo)o).getQYMC() + "\t" + ((EnterpriseInfo)o).getNBXH()+ "\t" + ((EnterpriseInfo)o).getHZRQ());
		}
	}
}
