package com.yhcac.factory;

/**
 * ③建工厂类
 * 
 * @author YHC
 * 
 */
public class SendFactory {

	public static Sender produceMail(){  
        return new MailSender();  
    }  
      
    public static Sender produceSms(){  
        return new SmsSender();  
    }  
}
