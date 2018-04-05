package com.yhc.thread;

import org.junit.Test;

/**
 * @author YHC
 * @email yhc8023tm@foxmail.com
 * @version 2016年8月4日 下午9:22:52
 */
public class MyTest {
	
	//测试Thread
	@Test
	public void test1(){
		ThreadFirst thread1 = new ThreadFirst();
		thread1.start();
		ThreadFirst thread2 = new ThreadFirst();
		thread2.start();
	}
	
	//测试Runnable
	@Test
	public void test2(){		
		RunnableFirst run1 = new RunnableFirst();
		run1.run();
		
		RunnableFirst run2 = new RunnableFirst();
		Thread thread1 = new Thread(run2, "nanshen");
		Thread thread2 = new Thread(run2,"nvshen");
		thread1.start();
		thread2.start();		
	}
	
	//循环测试
	@Test
	public void test3(){		
		for(int i=0;i<5;i++){
			ThreadFirst thread1 = new ThreadFirst();
			thread1.start();
			ThreadFirst thread2 = new ThreadFirst();
			thread2.start();
		}
	}

}
