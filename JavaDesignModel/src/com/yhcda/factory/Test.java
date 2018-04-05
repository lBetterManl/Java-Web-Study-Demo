package com.yhcda.factory;

/**
 * ④测试
 * @author YHC
 *
 */
public class Test {

	public static void main(String[] args) {
		Builder builder = new Builder();
		builder.produceMailSender(10);
	}
}