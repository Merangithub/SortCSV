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
 * 程序入口
 * 
 * 开发步骤： 
 * 1、从本地读取csv文件 
 * 2、对文件格式进行规范化，比如不该出现换行符的地方出现了换行符
 * 3、把读取到内存的数据封装到类里面，然后加到List集合去 
 * 4、用算法对集合进行排序 
 * 5、把有序的集合写到新的csv文件里面
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

		
		/*归并排序*/
		Object[] obj = new MergeSort().sort(list, ZCZB);
		pt.printArray(obj);
//		new WriteCSV().writeFileByArr(obj);
		
		/*快速排序*/
//		QuickSort qs = new QuickSort();
//		LinkedList<EnterpriseInfo> list1 = qs.quickSort(list, 0, list.size() - 1, ZCZB);
//		pt.printList(list1);
		
		/*冒泡排序*/
//		BubbleSort bs = new BubbleSort();
//		bs.bubbleSort(list, QYMC);
//		pt.printList(list);
		
		/*二分查找*/
//		BinarySearch bs = new BinarySearch();
//		bs.binarySearch(list1,123321);
		
		/*顺序查找*/
//		SequenceSearch ss = new SequenceSearch();
//		ss.sequenceSearch(obj, 50.0);
	}
}
