/**
 * Project Name:JavaHttp
 * File Name:MailUtil.java
 * Package Name:com.yhc.util.mail
 * Date:2017年3月1日上午11:49:55
 * Copyright (c) 2017, yhc8023tm@foxmail.com All Rights Reserved.
 *
*/

package com.yhc.util.mail;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.yhc.util.base64.Base64;
import com.yhc.util.http.HttpUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * ClassName:MailUtil <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2017年3月1日 上午11:49:55 <br/>
 * 
 * @author YHC
 * @version
 * @since JDK 1.8
 * @see
 */
public class MailUtil {

	private String host = ""; // smtp服务器
	private String from = ""; // 发件人地址
	private String to = ""; // 收件人地址
	private String affix = ""; // 附件地址
	private String affixName = ""; // 附件名称
	private String user = ""; // 用户名
	private String pwd = ""; // 密码
	private String subject = ""; // 邮件标题

	public void setAddress(String from, String to, String subject) {
		this.from = from;
		this.to = to;
		this.subject = subject;
	}

	public void setAffix(String affix, String affixName) {
		this.affix = affix;
		this.affixName = affixName;
	}

	public void send(String host, String user, String pwd) {
		this.host = host;
		this.user = user;
		this.pwd = pwd;

		Properties props = new Properties();

		// 设置发送邮件的邮件服务器的属性（这里使用网易的smtp服务器）
		props.put("mail.smtp.host", host);
		// 需要经过授权，也就是有户名和密码的校验，这样才能通过验证（一定要有这一条）
		props.put("mail.smtp.auth", "true");

		// 用刚刚设置好的props对象构建一个session
		Session session = Session.getDefaultInstance(props);

		// 有了这句便可以在发送邮件的过程中在console处显示过程信息，供调试使
		// 用（你可以在控制台（console)上看到发送邮件的过程）
		session.setDebug(true);

		// 用session为参数定义消息对象
		MimeMessage message = new MimeMessage(session);
		try {
			// 加载发件人地址
			message.setFrom(new InternetAddress(from));
			// 加载收件人地址
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			// 加载标题
			message.setSubject(subject);

			// 向multipart对象中添加邮件的各个部分内容，包括文本内容和附件
			Multipart multipart = new MimeMultipart();

			// 设置邮件的文本内容
			BodyPart contentPart = new MimeBodyPart();

			String httpUrl = "http://api.map.baidu.com/telematics/v3/weather";
			String httpArg = "location=武汉&output=json&ak=6tYzTvGZSOpYB5Oc2YGGOKt8";
			String result = HttpUtil.request(httpUrl, httpArg);
			JSONObject object = JSONObject.fromObject(result);
			JSONArray results = object.getJSONArray("results");
			JSONObject resultDet = results.getJSONObject(0);
			System.out.println("空气污染指数：" + resultDet.getString("pm25"));
			JSONArray weather_data = resultDet.getJSONArray("weather_data");
			JSONObject today_weather = weather_data.getJSONObject(0);

			StringBuilder sb = new StringBuilder();
			sb.append("城市：武汉\n当前日期：").append(today_weather.getString("date")).append(today_weather.getString("weather"))
					.append(today_weather.getString("temperature")).append(today_weather.getString("wind"));

			System.out.println("城市：武汉");
			System.out.println("当前日期：" + today_weather.getString("date"));
			System.out.println("天气：" + today_weather.getString("weather"));
			System.out.println("温度：" + today_weather.getString("temperature"));
			System.out.println("风向：" + today_weather.getString("wind"));

			contentPart.setText(sb.toString());
			multipart.addBodyPart(contentPart);
			/*
			 * // 添加附件 BodyPart messageBodyPart = new MimeBodyPart(); DataSource
			 * source = new FileDataSource(affix); // 添加附件的内容
			 * messageBodyPart.setDataHandler(new DataHandler(source)); //
			 * 添加附件的标题 // 这里很重要，通过下面的Base64编码的转换可以保证你的中文附件标题名在发送时不会变成乱码
			 * messageBodyPart.setFileName(Base64.encodeToString(affixName.
			 * getBytes())); multipart.addBodyPart(messageBodyPart);
			 */
			// 将multipart对象放到message中
			message.setContent(multipart);

			// html消息
			// String messageText = "";
			// message.setContent(messageText, "text/html;charset=gb2312");
			// 保存邮件
			message.saveChanges();
			// 发送邮件
			Transport transport = session.getTransport("smtp");
			// 连接服务器的邮箱
			transport.connect(host, user, pwd);
			// 把邮件发送出去
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		MailUtil cn = new MailUtil();
		// 设置发件人地址、收件人地址和邮件标题
		cn.setAddress("yhc8023tm@163.com", "414581067@qq.com", "来自许乐岩(强烈要求)的温馨提示");
		// 设置要发送附件的位置和标题
		// cn.setAffix("f:/123.txt", "123.txt");

		/**
		 * 设置smtp服务器以及邮箱的帐号和密码 用QQ 邮箱作为发生者不好使 （原因不明） 163 邮箱可以，但是必须开启 POP3/SMTP服务
		 * 和 IMAP/SMTP服务 因为程序属于第三方登录，所以登录密码必须使用163的授权码
		 */

		// 注意： [授权码和你平时登录的密码是不一样的]
		for(int i=0;i<100;i++){
			cn.send("smtp.163.com", "yhc8023tm@163.com", "yhcqwer1029");
		}
		//cn.send("smtp.163.com", "yhc8023tm@163.com", "yhcqwer1029");

	}
}
