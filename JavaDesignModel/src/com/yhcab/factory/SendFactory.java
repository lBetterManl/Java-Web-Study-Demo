package com.yhcab.factory;

/**
 * ③建工厂类
 * 
 * @author YHC
 * 
 */
public class SendFactory {

	public Sender produceMail() {
		return new MailSender();
	}

	public Sender produceSms() {
		return new SmsSender();
	}
}
