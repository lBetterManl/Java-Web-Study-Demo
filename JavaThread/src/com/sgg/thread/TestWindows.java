/**
 * Project Name:JavaThread
 * File Name:TestWindows.java
 * Package Name:com.sgg.thread
 * Date:2017年10月9日下午2:38:58
 * Copyright (c) 2017, yhc8023tm@foxmail.com All Rights Reserved.
 *
*/

package com.sgg.thread;
/**
 * 模拟火车站售票窗口，开启三个窗口，总票数为100张	 
 */

class Window extends Thread{
	static int ticket = 10;	//对象公用属性static
	@Override
	public void run() {
		while (true) {
			if (ticket>0) {
				System.out.println(Thread.currentThread().getName()+"售票，票号为："+ticket--);
			}else{
				break;
			}
		}
	}
	
}

public class TestWindows {
	public static void main(String[] args) {
		Window w1 = new Window();
		Window w2 = new Window();
		Window w3 = new Window();
		
		w1.setName("窗口1");
		w2.setName("窗口2");
		w3.setName("窗口3");
		
		w1.start();
		w2.start();
		w3.start();
	}
}

