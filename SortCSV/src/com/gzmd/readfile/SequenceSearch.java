package com.gzmd.readfile;

import com.gzmd.domain.EnterpriseInfo;

public class SequenceSearch {
	public EnterpriseInfo sequenceSearch(Object[] obj, double value) {
		for (int i = 0; i < obj.length - 1; i++) {
			if (value == ((EnterpriseInfo) obj[i]).getZCZB()) {
				System.out.println("�ҵ���");
				return (EnterpriseInfo) obj[i];
			}
		}
		System.out.println("û�ҵ�");
		return null;
	}
}
