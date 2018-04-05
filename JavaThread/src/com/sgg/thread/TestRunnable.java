/**
 * Project Name:JavaThread
 * File Name:TestRunnable.java
 * Package Name:com.sgg.thread
 * Date:2017年10月9日下午2:55:26
 * Copyright (c) 2017, yhc8023tm@foxmail.com All Rights Reserved.
 *
*/

package com.sgg.thread;
/**
 * 创建多线程方式二：实现Runnable接口	 
 */
class PrintNum1 implements Runnable{
	//子线程执行方法
	@Override
	public void run() {
		for (int i = 1; i <= 100; i++) {
			if (i%2==0) {
				System.out.println(Thread.currentThread().getName()+":"+i);
			}
		}
	}
	
}

public class TestRunnable {
	public static void main(String[] args) {
		PrintNum1 p = new PrintNum1();
		Thread t1 = new Thread(p);
		t1.start();
		
		Thread t2 = new Thread(p);
		t2.start(); 
	}
}

