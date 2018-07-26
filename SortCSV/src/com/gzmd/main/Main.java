package com.gzmd.main;

import java.util.LinkedList;
import java.util.List;

import com.gzmd.domain.EnterpriseInfo;
import com.gzmd.readfile.ReadCSV;
import com.gzmd.readfile.SequenceSearch;
import com.gzmd.search.BinarySearch;
import com.gzmd.sort.BubbleSort;
import com.gzmd.sort.MergeSort;
import com.gzmd.sort.QuickSort;
import com.gzmd.test.PrintTest;
import com.gzmd.writesortedfile.WriteCSV;

/**
 * �������
 * 
 * �������裺 
 * 1���ӱ��ض�ȡcsv�ļ� 
 * 2�����ļ���ʽ���й淶�������粻�ó��ֻ��з��ĵط������˻��з�
 * 3���Ѷ�ȡ���ڴ�����ݷ�װ�������棬Ȼ��ӵ�List����ȥ 
 * 4�����㷨�Լ��Ͻ������� 
 * 5��������ļ���д���µ�csv�ļ�����
 * 
 * @author Meran
 *
 */
public class Main {
	
	private static final int NBXH = 1;//�ڲ����
	private static final int ZCZB = 2;//ע���ʱ�
	private static final int HZRQ = 3;//��׼����
	private static final int QYMC = 4;//��ҵ����

	public static void main(String[] args) {
		ReadCSV rc = new ReadCSV();
		LinkedList<EnterpriseInfo> list = rc.readFile();
		PrintTest pt = new PrintTest();

		
		/*�鲢����*/
		Object[] obj = new MergeSort().sort(list, ZCZB);
		pt.printArray(obj);
//		new WriteCSV().writeFileByArr(obj);
		
		/*��������*/
//		QuickSort qs = new QuickSort();
//		LinkedList<EnterpriseInfo> list1 = qs.quickSort(list, 0, list.size() - 1, ZCZB);
//		pt.printList(list1);
		
		/*ð������*/
//		BubbleSort bs = new BubbleSort();
//		bs.bubbleSort(list, QYMC);
//		pt.printList(list);
		
		/*���ֲ���*/
//		BinarySearch bs = new BinarySearch();
//		bs.binarySearch(list1,123321);
		
		/*˳�����*/
//		SequenceSearch ss = new SequenceSearch();
//		ss.sequenceSearch(obj, 50.0);
	}
}
