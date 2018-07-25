package com.gzmd.test;

import java.util.LinkedList;

import com.gzmd.domain.EnterpriseInfo;

public class PrintTest {
	public void printList(LinkedList<EnterpriseInfo> list){
		for (EnterpriseInfo e : list) {
			System.out.println(e.getZCZB());
		}
	}
	
	public void printArray (Object[] obj) {
		for (Object o : obj) {
			System.out.println(((EnterpriseInfo)o).getZCZB() + "\t" + ((EnterpriseInfo)o).getQYMC() + "\t" + ((EnterpriseInfo)o).getNBXH()+ "\t" + ((EnterpriseInfo)o).getHZRQ());
		}
	}
}
