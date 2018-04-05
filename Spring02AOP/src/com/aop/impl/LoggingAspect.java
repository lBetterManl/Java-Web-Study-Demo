package com.aop.impl;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 把这个类声明为一个切面：需要把该类放入到 IOC 容器中,再声明为一个切面
 * @author YHC
 *
 */
@Aspect
@Component
public class LoggingAspect {
	
	/**
	 * 定义一个方法，用于声明切入点表达式。一般地，改方法中不再添加其他代码
	 */
	@Pointcut("execution(public int com.aop.impl.ArithmeticCalculator.*(int, int))" )
	public void declareJoinPointExpression(){}
	
	
	/**
	 * 前置通知
	 * 在目标方法开始之前执行
	 */
	@Before("declareJoinPointExpression()" )
	public void beforeMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("The method begins " + methodName + " begins with " + args);
	}
	
	/**
	 * 后置通知
	 * 在目标方法执行后（无论是否发生异常），执行的通知
	 * 在后置通知中还不能访问目标方法执行的结果
	 */
	@After("execution(public int com.aop.impl.ArithmeticCalculator.*(int, int))" )
	public void afterMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " ends with ");
	}
	
	/**
	 * 返回通知
	 *  在方法正常结束后执行的代码
	 * 可以访问方法的返回值
	 * @param joinPoint
	 */
	@AfterReturning(value="execution(public int com.aop.impl.ArithmeticCalculator.*(int, int))", returning="result" )
	public void afterReturnMethod(JoinPoint joinPoint, Object result){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " ends with " + result );
	}
	
	/**
	 * 异常通知
	 * 在目标方法出现异常时会执行的代码
	 * 可以访问到异常对象；且可以指定在出现特定异常时再执行通知代码
	 */
	@AfterThrowing(value="execution(public int com.aop.impl.ArithmeticCalculator.*(int, int))", throwing="ex" )
	public void afterThrowing(JoinPoint joinPoint, Exception ex){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " occurs exception " + ex);
	}
	
	/**
	 * 环绕通知 
	 * 需要携带 ProceedingJoinPoint 类型的参数
	 * 类似于动态代理的全过程： ProceedingJoinPoint 类型的参数可以决定是否执行目标方法
	 * 且环绕通知必须有返回值，返回值即为目标方法的返回值
	 * 只做了解
	 */
	/*
	@Around("execution(public int com.aop.impl.ArithmeticCalculator.*(int, int))" )
	public Object aroundMethod(ProceedingJoinPoint pjd){
		
		Object result = null;
		String methodName = pjd.getSignature().getName();
		
		//执行目标方法
		try {
			//前置通知
			System.out.println("The mothod " + methodName + "begins with " + Arrays.asList(pjd.getArgs()));
			
			//执行程序
			result = pjd.proceed();
			
			//后置通知
			System.out.println("The method " + methodName + " ends with " + result);
		} catch (Throwable e) {
			// 异常通知
			System.out.println("The method " + methodName + " occurs exception: " + e);
		}
		//后置通知
		System.out.println("The method " + methodName + " ends");
		
		return result;
	}
	*/
}
