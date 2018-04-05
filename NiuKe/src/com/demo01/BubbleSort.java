/**
 * Project Name:NiuKe
 * File Name:BubbleSort.java
 * Package Name:com.demo01
 * Date:2017年10月6日下午2:27:02
 * Copyright (c) 2017, yhc8023tm@foxmail.com All Rights Reserved.
 *
*/
package com.demo01;
/**
 * ClassName:BubbleSort <br/>
 * Date:     2017年10月6日 下午2:27:02 <br/>
 * @author   YHC 
 * @since    JDK 1.8
 * @see 	 冒泡排序
 */
public class BubbleSort {
	private void display(int[] array){
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+"\t");
			System.out.println();
		}
	}
	public void solution(int[] array) {
		int temp;
		int len = array.length;
		for (int i = 0; i < len-1; i++) {
			for (int j = 1; j < len-i; j++) {
				if (array[j-1]>array[j]) {
					temp = array[j-1];
					array[j-1] = array[j];
					array[j] = temp;
				}
			}
			display(array);
		}
	}
}

