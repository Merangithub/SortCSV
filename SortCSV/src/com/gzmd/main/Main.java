package com.gzmd.main;

import java.util.LinkedList;
import java.util.List;

import com.gzmd.domain.EnterpriseInfo;
import com.gzmd.readfile.ReadCSV;
import com.gzmd.sort.BubbleSort;
import com.gzmd.sort.MergeSort;

public class Main {
	
	private static final int NBXH = 1;//�ڲ����
	private static final int ZCZB = 2;//ע���ʱ�
	private static final int HZRQ = 3;//��׼����
	private static final int QYMC = 4;//��ҵ����

	public static void main(String[] args) {
		ReadCSV rc = new ReadCSV();
		LinkedList<EnterpriseInfo> list = rc.readFile();
		new MergeSort().sort(list, HZRQ);
		
//		new BubbleSort().test();
		
	}
}
