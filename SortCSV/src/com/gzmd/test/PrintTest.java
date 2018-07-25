package com.gzmd.test;

import java.util.LinkedList;

import com.gzmd.domain.EnterpriseInfo;
/**
 * 输出测试
 * 
 * @author Meran
 *
 */
public class PrintTest {
	
	/**
	 * 打印输出集合
	 * 
	 * @param list
	 * 			list集合
	 */
	public void printList(LinkedList<EnterpriseInfo> list){
		for (EnterpriseInfo e : list) {
			System.out.println(e.getZCZB() + "\t" + e.getNBXH() + "\t" + e.getHZRQ() + "\t" + e.getQYMC());
		}
	}
	
	/**
	 * 打印输出数组
	 * 
	 * @param obj
	 * 			Object类型的数组
	 */
	public void printArray (Object[] obj) {
		for (Object o : obj) {
			System.out.println(((EnterpriseInfo)o).getZCZB() + "\t" + ((EnterpriseInfo)o).getQYMC() + "\t" + ((EnterpriseInfo)o).getNBXH()+ "\t" + ((EnterpriseInfo)o).getHZRQ());
		}
	}
}
