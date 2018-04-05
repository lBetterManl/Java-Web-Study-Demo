/**
 * Project Name:NiuKe
 * File Name:QuickSort.java
 * Package Name:com.demo01
 * Date:2017年10月6日下午3:14:31
 * Copyright (c) 2017, yhc8023tm@foxmail.com All Rights Reserved.
 *
*/

package com.demo01;
/**
 * ClassName:QuickSort <br/>
 * Date:     2017年10月6日 下午3:14:31 <br/>
 * @author   YHC 
 * @since    JDK 1.8
 * @see 	 快速排序
 */
public class QuickSort {
	private void display(int[] array){
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+"\t");
			System.out.println();
		}
	}
	public void solution(int[] array, int low, int high) {
		int pivot = array[low];
		int left = low;
		int right = high;
	
		if (left>=right) {
			return;
		}
		while (left<right) {
			while (left<right && array[right]>=pivot) {
				right--;
			}
			array[left] = array[right];	//把小的移动到左边
			while (left<right && array[left]<=pivot) {
				left++;
			}
			array[right] = array[left]; //把大的移动到右边
		}
		array[left] = pivot;  //最后把pivot赋值到中间
		solution(array, low, left-1);
		solution(array, left+1, high);
	}
	
	public static void main(String[] args) {
		int[] arr = {3,1,5,7,9,8,0};
		QuickSort qs = new QuickSort();
		qs.solution(arr, 0, 6);
		qs.display(arr);
	}
}

