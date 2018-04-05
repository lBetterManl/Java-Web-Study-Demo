package cn.test.generic;

import org.junit.Test;

//泛形练习题
public class Demo05 {

	//编写一个泛形方法，实现指定位置上的数组元素的交换
	public<T> void swap(T arr[], int pos1, int pos2 ) {
		
		T temp = arr[pos1];
		arr[pos1] = arr[pos2];
		arr[pos2] = temp;
	}
	
	//编写一个泛形，结合艘一个任意数组，并颠倒 数组中的所有元素
	public<T> void reserve(T arr[]) {
		
		int start = 0;
		int end = arr.length-1;
		
		while (start<end) {	
			T temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}
}
