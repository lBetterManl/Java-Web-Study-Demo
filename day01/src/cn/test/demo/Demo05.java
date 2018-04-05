package cn.test.demo;

import org.junit.Test;

//ÔöÇ¿forÑ­»·
public class Demo05 {

	@Test
	public void test1(){
		
		int[] s={1,2,3,4,5};
		int sum=0;
		for(int i:s){
			sum+=i;
		}
		System.out.println(sum);
	}
}
