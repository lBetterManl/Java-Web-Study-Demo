package com.yhcda.factory;

import java.util.ArrayList;
import java.util.List;

/**
 * ③建造者类
 * @author YHC
 *
 */
public class Builder {
	
	private List<Sender> list = new ArrayList<Sender>();
	
	public void produceMailSender(int count){
		for(int i=0; i<count; i++){
			list.add(new MailSender());
		}
	}
	
	public void produceSmsSender(int count){
		for(int i=0; i<count; i++){
			list.add(new SmsSender());
		}
	}
}