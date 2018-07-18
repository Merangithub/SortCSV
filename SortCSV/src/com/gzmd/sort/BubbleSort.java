package com.gzmd.sort;

import java.util.LinkedList;
import java.util.List;

import com.gzmd.domain.EnterpriseInfo;

public class BubbleSort {
	public LinkedList<EnterpriseInfo> bubbleSort (List<EnterpriseInfo> list) {
		
		System.out.println("≈≈–Ú«∞£∫");
		for (Object s: list) {
			System.out.println(((EnterpriseInfo) s).getZCZB());
		}
		
		System.out.println("≈≈–Ú∫Û£∫");
		Object[] objs = list.toArray();
		Object temp = null;
		for (int i = 0; i < objs.length; i++) {
			for (int j = 0; j < objs.length - i; j++) {
				 if(((EnterpriseInfo)objs[i]).getZCZB() > ((EnterpriseInfo)objs[j + 1]).getZCZB()){
					Object tmp = objs[j];
					objs[j] = objs[j + 1];
					objs[j + 1] = tmp;
				}
			}
		}
		for (int i = 0; i < objs.length; i++) {
			System.out.println(((EnterpriseInfo) objs[i]).getZCZB());
		}
		return null;
	}
}














/**
*https://www.cnblogs.com/wanggd/p/3214713.html
*https://www.cnblogs.com/shen-hua/p/5422676.html
*
**/