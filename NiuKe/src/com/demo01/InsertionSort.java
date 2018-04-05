/**
 * Project Name:NiuKe
 * File Name:InsertionSort.java
 * Package Name:com.demo01
 * Date:2017年10月6日下午2:48:23
 * Copyright (c) 2017, yhc8023tm@foxmail.com All Rights Reserved.
 *
*/

package com.demo01;
/**
 * ClassName:InsertionSort <br/>
 * Date:     2017年10月6日 下午2:48:23 <br/>
 * @author   YHC
 * @since    JDK 1.8
 * @see 	 插入排序
 */
public class InsertionSort {
	private void display(int[] array){
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+"\t");
			System.out.println();
		}
	}
	public void solution(int[] array) {
		int len = array.length;
		for (int i = 0; i < len; i++) {
			int temp = array[i];
			int insertIndex = i-1;
			while (insertIndex>=0 && array[insertIndex]>temp) {
				array[insertIndex+1] = array[insertIndex];
				insertIndex--;
			}
			array[insertIndex+1] = temp;
			display(array);
		}
	}
}

