package cn.test.demo;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

//可变参数
public class Demo04 {

	@Test
	public void testSum(){
		sum(1,2,3,4,5,6);
	}
	
	
	public void sum(int ...nums){
		//可变参数就把它看成数组
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
	
	
	//可变参数需要注意的问题：public void aa(int ...nums, int x)这样是不行的
	
	public void aa(int x, int ...nums){
		
	}
	
	@Test
	public void bb(){
		
		List list = Arrays.asList("1","2","3");
		System.out.println(list);
		
		String arr[] = {"1","2","3"};
		list = Arrays.asList(arr);
		System.out.println(list);
		
		
		Integer nums[] = {1,2,3,5};	//这个问题一定要小心
		list = Arrays.asList(nums);
		System.out.println(list);
	}
}
