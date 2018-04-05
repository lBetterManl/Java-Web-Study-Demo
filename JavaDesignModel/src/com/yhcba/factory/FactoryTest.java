package com.yhcba.factory;

/**
 * ⑤测试 
 * @author YHC
 * 
 */
public class FactoryTest {

	public static void main(String[] args) {
		Provider provider = new SendMailFactory();  
        Sender sender = provider.produce();  
        sender.Send();  
	}
}
