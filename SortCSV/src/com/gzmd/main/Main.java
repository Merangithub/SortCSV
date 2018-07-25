package com.gzmd.main;

import java.util.LinkedList;
import java.util.List;

import com.gzmd.domain.EnterpriseInfo;
import com.gzmd.readfile.ReadCSV;
import com.gzmd.sort.BubbleSort;
import com.gzmd.sort.MergeSort;
import com.gzmd.sort.QuickSort;
import com.gzmd.test.PrintTest;
import com.gzmd.writesortedfile.WriteCSV;

/**
 * 程序入口
 * 
 * @author Meran
 *
 */
public class Main {
	
	private static final int NBXH = 1;//内部序号
	private static final int ZCZB = 2;//注册资本
	private static final int HZRQ = 3;//核准日期
	private static final int QYMC = 4;//企业名称

	public static void main(String[] args) {
		ReadCSV rc = new ReadCSV();
		LinkedList<EnterpriseInfo> list = rc.readFile();
		PrintTest pt = new PrintTest();
		
//		Object[] obj = new MergeSort().sort(list, HZRQ);
//		pt.printArray(obj);
//		new WriteCSV().writeFileByArr(obj);
		
		
		QuickSort qs = new QuickSort();
		LinkedList<EnterpriseInfo> list1 = qs.quickSort(list, 0, list.size() - 1, HZRQ);
		pt.printList(list1);
		
//		BubbleSort bs = new BubbleSort();
//		bs.bubbleSort(list, QYMC);
//		pt.printList(list);
	}
}
