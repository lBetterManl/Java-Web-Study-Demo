/**
 * Project Name:JavaThread
 * File Name:TestThread1.java
 * Package Name:com.sgg.thread
 * Date:2017年10月9日下午12:29:33
 * Copyright (c) 2017, yhc8023tm@foxmail.com All Rights Reserved.
 *
*/

package com.sgg.thread;
/**
 * Thread的常用方法
 * 1.start():启动线程并执行相应的run()方法
 * 2.run():子线程要执行的代码放入run()方法中
 * 3.currentThread():静态的，调取当前的线程
 * 4.getName():获取此线程的名字
 * 5.setName():设置此线程的名字
 * 6.yield():调用此方法的线程释放当前CPU的执行权
 * 7.join():在A线程中调用B线程的join()方法，表示：
 * 	当执行到此方法，A线程停止执行，直到B线程执行完毕
 * 8.isAlive():判断当前线程是否存活
 * 9.sleep(long 1):显式的让当前线程睡眠1毫秒
 * 10.线程通信：wait() notify() notifyAll()
 * 
 * setPriority():设置线程的优先级，高优先级概率变大
 */
class SubThread1 extends Thread{
	@Override
	public void run() {
		for (int i = 1; i <= 100; i++) {
			/*try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				
			}*/
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
	}
	
}

public class TestThread1{
	public static void main(String[] args) {

		SubThread1 st1 = new SubThread1();
		st1.setName("子线程1");
		st1.start();
		
		Thread.currentThread().setName("=====主线程");
		
		for (int i = 1; i <= 100; i++) {
			System.out.println(Thread.currentThread().getName()+":"+i);
			/*if (i%10==0) {
				Thread.currentThread().yield();
			}*/
			if (i==20) {
				try {
					st1.join();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println(st1.isAlive());
	}
}

