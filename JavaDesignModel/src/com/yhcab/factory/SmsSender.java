package com.yhcab.factory;

/**
 * ②创建实现类
 * @author YHC
 *
 */
public class SmsSender implements Sender {

	@Override
	public void Send() {
		 System.out.println("this is sms sender!");  

	}

}
