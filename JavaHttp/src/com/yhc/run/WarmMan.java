/**
 * Project Name:JavaHttp
 * File Name:WarmMan.java
 * Package Name:com.yhc.run
 * Date:2017年3月1日下午1:03:52
 * Copyright (c) 2017, yhc8023tm@foxmail.com All Rights Reserved.
 *
*/

package com.yhc.run;

import com.yhc.util.mail.MailUtil;

/**
 * ClassName:WarmMan <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年3月1日 下午1:03:52 <br/>
 * @author   YHC
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class WarmMan {

	public static void main(String[] args) {
		// TODO 提醒好友天气
		
		MailUtil cn = new MailUtil();
		cn.setAddress("yhc8023tm@163.com", "yhc8023tm@foxmail.com", "来自好人的温馨提示");
		cn.send("smtp.163.com", "yhc8023tm@163.com", "yhcqwer1029");
	}

}

