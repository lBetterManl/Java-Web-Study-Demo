package cn.test.demo;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

//�ɱ����
public class Demo04 {

	@Test
	public void testSum(){
		sum(1,2,3,4,5,6);
	}
	
	
	public void sum(int ...nums){
		//�ɱ�����Ͱ�����������
		int sum = 0;
		for (int i : nums) {
			sum+=i;
		}
		System.out.println(sum);
	}
	
	@Test
	public void testAa(){
		aa(1,2,3,4,5,6);
	}
	
	
	//�ɱ������Ҫע������⣺public void aa(int ...nums, int x)�����ǲ��е�
	
	public void aa(int x, int ...nums){
		
	}
	
	@Test
	public void bb(){
		
		List list = Arrays.asList("1","2","3");
		System.out.println(list);
		
		String arr[] = {"1","2","3"};
		list = Arrays.asList(arr);
		System.out.println(list);
		
		
		Integer nums[] = {1,2,3,5};	//�������һ��ҪС��
		list = Arrays.asList(nums);
		System.out.println(list);
	}
}
