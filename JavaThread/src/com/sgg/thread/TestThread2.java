/**
 * Project Name:JavaThread
 * File Name:TestThread2.java
 * Package Name:com.sgg.thread
 * Date:2017年10月9日下午2:14:51
 * Copyright (c) 2017, yhc8023tm@foxmail.com All Rights Reserved.
 *
*/

package com.sgg.thread;

class SecThread1 extends Thread{
	//打印1-100偶数
	@Override
	public void run() {
		for (int i = 1; i <= 100; i++) {
			if (i%2==0) {
				System.out.println(Thread.currentThread().getName()+":"+i);
			}
		}
	}
}

class SecThread2 extends Thread{
	//打印1-100奇数
	@Override
	public void run() {
		for (int i = 1; i <= 100; i++) {
			if (i%2!=0) {
				System.out.println(Thread.currentThread().getName()+":"+i);
			}
		}
	}
}

public class TestThread2 {
	public static void main(String[] args) {
		SecThread1 st1 = new SecThread1();
		SecThread2 st2 = new SecThread2();
		st1.start();
		st2.start();
		//继承于Thread类的匿名类的对象
		/*
		new Thread(){
			public void run() {
				for (int i = 1; i <= 100; i++) {
					if (i%2==0) {
						System.out.println(Thread.currentThread().getName()+":"+i);
					}
				}
			}
		}.start();
		
		new Thread(){
			public void run() {
				for (int i = 1; i <= 100; i++) {
					if (i%2!=0) {
						System.out.println(Thread.currentThread().getName()+":"+i);
					}
				}
			}
		}.start();
		*/
	}
}

