package com.yhcba.factory;

/**
 * ④分别创建工厂
 * @author YHC
 *
 */
public class SendMailFactory implements Provider {

	@Override
	public Sender produce() {
		return new MailSender(); 
	}

}
