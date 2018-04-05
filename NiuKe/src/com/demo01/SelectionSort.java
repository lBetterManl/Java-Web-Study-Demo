/**
 * Project Name:NiuKe
 * File Name:SelectionSort.java
 * Package Name:com.demo01
 * Date:2017年10月6日下午2:39:38
 * Copyright (c) 2017, yhc8023tm@foxmail.com All Rights Reserved.
 *
*/

package com.demo01;
/**
 * ClassName:SelectionSort <br/>
 * Date:     2017年10月6日 下午2:39:38 <br/>
 * @author   YHC
 * @since    JDK 1.8
 * @see 	  选择排序
 */
public class SelectionSort {
	private void display(int[] array){
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+"\t");
			System.out.println();
		}
	}
	public void solution(int[] array) {
		int minIndex;
		int len = array.length;
		int temp;
		for (int i = 0; i < len-1; i++) {
			minIndex = i;
			for (int j = i+1; j < len; j++) {
				if (array[j]<array[minIndex]) {
					minIndex = j;
				}
			}
			if (minIndex!=i) {
				temp = array[i];
				array[i] = array[minIndex];
				array[minIndex] = temp;
			}
			display(array);
		}
	}
}

