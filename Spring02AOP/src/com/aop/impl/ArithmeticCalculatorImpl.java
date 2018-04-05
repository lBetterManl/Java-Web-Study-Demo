package com.aop.impl;

import org.springframework.stereotype.Component;

@Component("arithmeticCalculator")
public class ArithmeticCalculatorImpl implements ArithmeticCalculator {

	@Override
	public int add(int i, int j) {
		//System.out.println("The method add begins with[" + i + "," + j + "]");
		int result = i + j;
		//System.out.println("The method add ends with "+ result);
		return result;
	}

	@Override
	public int sub(int i, int j) {
		int result = i - j;
		return result;
	}

	@Override
	public int mul(int i, int j) {
		int result = i * j;
		return result;
	}

	@Override
	public int div(int i, int j) {
		int result = i / j;
		return result;
	}

}
