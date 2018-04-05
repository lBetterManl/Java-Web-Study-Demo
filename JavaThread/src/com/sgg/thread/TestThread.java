/**
 * Project Name:JavaThread
 * File Name:TestThread.java
 * Package Name:com.sgg.thread
 * Date:2017年10月9日下午12:29:33
 * Copyright (c) 2017, yhc8023tm@foxmail.com All Rights Reserved.
 *
*/

package com.sgg.thread;
/**
 * 创建一个子线程，完成1-100之间自然数的输出。
 * 方法一：继承Thread类
 */
//1.创建一个继承于Thread的子类
class SubThread extends Thread{

	//2.重写run()方法
	@Override
	public void run() {
		for (int i = 1; i <= 100; i++) {
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
	}
	
}

public class TestThread{
	public static void main(String[] args) {
		//3.创建一个子类的对象
		SubThread st = new SubThread();
		//4.调用线程的start()，启动此线程;调用相应的run()方法
		//一个线程只能执行一次start()
		//不能通过Thread实现类对象的run()方法启动线程
		st.start();
		
		for (int i = 1; i <= 100; i++) {
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
	}
}

