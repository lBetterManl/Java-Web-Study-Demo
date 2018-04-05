/**
 * Project Name:JavaThread
 * File Name:Main.java
 * Package Name:com.mt.de01
 * Date:2017年10月11日下午6:27:48
 * Copyright (c) 2017, yhc8023tm@foxmail.com All Rights Reserved.
 *
*/

package com.mt.de01;

public class Main {

	private void solution(int[] array, int low, int high){
		int left = low;
		int right = high;
		int povit = array[low];
		if (left>=right) {
			return;
		}
		while (left<right) {
			while (left<right && array[right]>=povit) {
				right--;
			}
			array[left] = array[right];
			while (left<right && array[left]<=povit) {
				left++;
			}
			array[right] = array[left];
		}
		array[left] = povit;
		solution(array, low, left-1);
		solution(array, left+1, high);
	}
	
	public static void main(String[] args) {
		int[] arr = {3,1,5,7,9,8,0};
		Main m = new Main();
		m.solution(arr, 0, 6);
		for (int i = 0; i < 7; i++) {
			System.out.println(arr[i]);
		}
	}

}

