package com.gzmd.sort;

import java.util.LinkedList;
import java.util.List;

import com.gzmd.domain.EnterpriseInfo;
import com.gzmd.readfile.ReadCSV;
import com.gzmd.writesortedfile.WriteCSV;

/**
 * 冒泡排序
 * 
 * @author Meran
 *
 */
public class BubbleSort {

	/**
	 * @param list
	 *            EnterpriseInfo类型的List集合
	 * @return 排好序的集合
	 */

	public List bubbleSort(List<EnterpriseInfo> list) {

//		System.out.println("排序前：");
//		for (Object s : list) {
//			System.out.println(((EnterpriseInfo) s).getZCZB() + "\t" + ((EnterpriseInfo) s).getQYMC());
//		}

		System.out.println("排序后：");
		EnterpriseInfo temp = null;
		long startTime = System.currentTimeMillis(); // 获取开始时间
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = 0; j < list.size() - 1 - i; j++) {
				if ((list.get(j)).getZCZB() > (list.get(j + 1)).getZCZB()) {
					temp = list.get(j);
					list.set(j, list.get(j + 1));
					list.set(j + 1, temp);
				}
			}
		}
		long endTime = System.currentTimeMillis(); // 获取结束时间
		for (EnterpriseInfo e : list) {
			System.out.println(e.getZCZB() + "\t" + e.getQYMC());
		}

		System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
		return list;
		///////////////////////////////////////////////////////////////////////////////
		// 第二种交换集合中元素位置的方法
		//
		// Object[] objs = list.toArray();
		// Object temp = null;
		// for (int i = 0; i < objs.length -1; i++) {
		// for (int j = 0; j < objs.length - 1 - i; j++) {
		// if(((EnterpriseInfo)objs[j]).getZCZB() > ((EnterpriseInfo)objs[j + 1]).getZCZB()){
		// temp = objs[j];
		// objs[j] = objs[j + 1];
		// objs[j + 1] = temp;
		// }
		// }
		// }
		// for (int i = 0; i < objs.length; i++) {
		// System.out.println(((EnterpriseInfo) objs[i]).getZCZB() + "\t" + ((EnterpriseInfo)objs[i]).getQYMC());
		// }
		// return objs;
		///////////////////////////////////////////////////////////////////////////////
	}

	public void test() {
		ReadCSV rc = new ReadCSV();
		WriteCSV wc = new WriteCSV();
		List<EnterpriseInfo> list = rc.readFile();
		List sortedList = bubbleSort(list);
//		wc.writeFile(sortedList);
	}
}

/**
 * https://www.cnblogs.com/wanggd/p/3214713.html
 * https://www.cnblogs.com/shen-hua/p/5422676.html
 *
 **/