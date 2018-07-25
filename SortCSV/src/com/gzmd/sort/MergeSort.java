package com.gzmd.sort;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.gzmd.domain.EnterpriseInfo;
import com.gzmd.utils.CompareCNUtils;
import com.gzmd.utils.DateUtils;

public class MergeSort {
	
	/**
	 * 调用sort重载方法对list集合排序，并统计排序时间
	 * @param list
	 * 			list集合
	 * @param column
	 * 			选择指定的字段排序
	 * @return	Object对象数组
	 */
	public Object[] sort (LinkedList<EnterpriseInfo> list , int column) {
		Object[] arr = list.toArray();//把集合变成数组
		
		Object[] temp = new Object[arr.length];//先建立一个长度等于元数组长度的临时数组，避免递归过程中频繁开辟空间
		System.out.println("排序后：");
		long startTime = System.currentTimeMillis(); // 获取开始时间
		
		sort(arr, 0, arr.length - 1, temp, column);
		
		long endTime = System.currentTimeMillis(); // 获取结束时间
		System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
		return arr;
	}
	
	
	/**
	 * 递归拆分Object对象数组中的元素进行排序
	 * @param oldArr
	 * 			源数组，未排序的
	 * @param left
	 * 			标记左边序列的下标
	 * @param right
	 * 			标记右边序列的下标
	 * @param tempArr
	 * 			目标数组，排好序的
	 */
	private void sort(Object[] oldArr, int left, int right, Object[] tempArr, int column) {
		if (left < right) {
			int mid = (left + right) / 2;
			sort (oldArr, left, mid, tempArr, column);//使左边有序
			sort (oldArr, mid + 1, right, tempArr, column);//使右边有序
			merge (oldArr, left, mid, right, tempArr, column);
		}
	}
	
	
	/**
	 * 排序
	 * @param oldArr
	 * 			源数组
	 * @param left
	 * 			标记左边序列的下标
	 * @param mid
	 * 			两个有序序列之间的坐标
	 * @param right
	 * 			标记右边序列的下标
	 * @param tempArr
	 * 			目标数组
	 */
	private void merge (Object[] oldArr, int left, int mid, int right, Object[] tempArr, int column) {
		DateUtils du = new DateUtils();
		CompareCNUtils cnu = new CompareCNUtils();
		int i = left;//左序列指针
		int j = mid + 1;//右序列指针
		int t= 0;//临时集合的指针
		
		switch (column) {
		case 1:
			
			while ((i <= mid) && (j <= right)) {
				if (Long.parseLong(((EnterpriseInfo)oldArr[i]).getNBXH()) <= Long.parseLong(((EnterpriseInfo)oldArr[j]).getNBXH())) {
					tempArr[t++] = oldArr[i++];
				} else {
					tempArr[t++] = oldArr[j++];
				}
			}
			while (i <= mid) {//将左边剩余元素填充进tempArr中
				tempArr[t++] = oldArr[i++];
			}
			while (j <= right) {//将右边剩余元素填充进tempArr中
				tempArr[t++] = oldArr[j++];
			}
			t = 0;
			//将tempArr中的元素全部拷贝到原来的数组中
			while (left <= right) {
				oldArr[left++] = tempArr[t++];
			}
			
			break;
		case 2:
			
			while ((i <= mid) && (j <= right)) {
				if (((EnterpriseInfo)oldArr[i]).getZCZB() <= ((EnterpriseInfo)oldArr[j]).getZCZB()) {
					tempArr[t++] = oldArr[i++];
				} else {
					tempArr[t++] = oldArr[j++];
				}
			}
			while (i <= mid) {//将左边剩余元素填充进tempArr中
				tempArr[t++] = oldArr[i++];
			}
			while (j <= right) {//将右边剩余元素填充进tempArr中
				tempArr[t++] = oldArr[j++];
			}
			t = 0;
			//将tempArr中的元素全部拷贝到原来的数组中
			while (left <= right) {
				oldArr[left++] = tempArr[t++];
			}
			
			break;
		case 3:
			
			while ((i <= mid) && (j <= right)) {
				//将字符串转换成Date类型
				Date date1 = du.parseDate(((EnterpriseInfo)oldArr[i]).getHZRQ());
				Date date2 = du.parseDate(((EnterpriseInfo)oldArr[j]).getHZRQ());
				if (date1.before(date2)) {
					tempArr[t++] = oldArr[i++];
				} else {
					tempArr[t++] = oldArr[j++];
				}
			}
			while (i <= mid) {//将左边剩余元素填充进tempArr中
				tempArr[t++] = oldArr[i++];
			}
			while (j <= right) {//将右边剩余元素填充进tempArr中
				tempArr[t++] = oldArr[j++];
			}
			t = 0;
			//将tempArr中的元素全部拷贝到原来的数组中
			while (left <= right) {
				oldArr[left++] = tempArr[t++];
			}
			
			break;
		case 4:
			
			while ((i <= mid) && (j <= right)) {
				if ((cnu.compareChinese(((EnterpriseInfo)oldArr[i]).getQYMC(), ((EnterpriseInfo)oldArr[j]).getQYMC())) <= 0) {
					tempArr[t++] = oldArr[i++];
				} else {
					tempArr[t++] = oldArr[j++];
				}
			}
			while (i <= mid) {//将左边剩余元素填充进tempArr中
				tempArr[t++] = oldArr[i++];
			}
			while (j <= right) {//将右边剩余元素填充进tempArr中
				tempArr[t++] = oldArr[j++];
			}
			t = 0;
			//将tempArr中的元素全部拷贝到原来的数组中
			while (left <= right) {
				oldArr[left++] = tempArr[t++];
			}
			
			break;
		default:
			
		} 
		
		
	}
}
