package cn.test.generic;

import org.junit.Test;

//������ϰ��
public class Demo05 {

	//��дһ�����η�����ʵ��ָ��λ���ϵ�����Ԫ�صĽ���
	public<T> void swap(T arr[], int pos1, int pos2 ) {
		
		T temp = arr[pos1];
		arr[pos1] = arr[pos2];
		arr[pos2] = temp;
	}
	
	//��дһ�����Σ������һ���������飬���ߵ� �����е�����Ԫ��
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
