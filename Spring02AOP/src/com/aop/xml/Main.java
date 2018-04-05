package com.aop.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		// 1.创建 Spring IOC 容器
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-xml.xml");
		
		//2.从 IOC 容器中获取 Bean 的实例
		ArithmeticCalculator arithmeticCalculator = ctx.getBean(ArithmeticCalculator.class);
		
		//3.使用 Bean 
		int result = arithmeticCalculator.add(6, 2);
		System.out.println("result: " + result);

	}

}
