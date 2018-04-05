package com.yhc.thread;

/**
 * @author YHC
 * @email yhc8023tm@foxmail.com
 * @version 2016年8月4日 下午9:18:54
 * @see 继承Thread实现线程
 */
public class ThreadFirst extends Thread {

	@Override
	public void run() {
		System.out.println("我是线程1");
		try {
			sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("线程1中断");;
		}
	}

}
