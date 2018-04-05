package com.yhcab.factory;

/**
 * ④测试
 * 
 * @author YHC
 * 
 */
public class FactoryTest {

	public static void main(String[] args) {
		SendFactory factory = new SendFactory();
		Sender sender = factory.produceMail();
		sender.Send();
	}
}
