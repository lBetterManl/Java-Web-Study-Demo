package com.yhcac.factory;

/**
 * ④测试
 * 
 * @author YHC
 * 
 */
public class FactoryTest {

	public static void main(String[] args) {
		Sender sender = SendFactory.produceMail();  
        sender.Send();
	}
}
