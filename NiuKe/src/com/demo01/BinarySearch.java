/**
 * Project Name:NiuKe
 * File Name:BinarySearch.java
 * Package Name:com.demo01
 * Date:2017年10月13日下午9:54:04
 * Copyright (c) 2017, yhc8023tm@foxmail.com All Rights Reserved.
 *
*/

package com.demo01;
/**
 * 二分查找 
 */
public class BinarySearch {

	private int solution(int[] array, int k){
		int midIndex;
		int low = 0;
		int high = array.length-1;
		while (low<high) {
			midIndex = low+high/2;
			if (array[midIndex]==k) {
				return midIndex;
			}else if (array[midIndex]>k) {
				high = midIndex-1;
			}else{
				low = midIndex+1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {

		int[] array = {1,3,5,7,9};
		BinarySearch bs = new BinarySearch();
		int pos = bs.solution(array, 5);
		System.out.println(pos);
	}

}

