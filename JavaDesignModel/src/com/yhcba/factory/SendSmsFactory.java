package com.yhcba.factory;

/**
 * ④分别创建工厂
 * @author YHC
 *
 */
public class SendSmsFactory implements Provider {

	@Override
	public Sender produce() {
		return new SmsSender(); 
	}

}
