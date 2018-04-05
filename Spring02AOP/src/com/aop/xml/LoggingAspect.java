package com.aop.xml;

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


public class LoggingAspect {

	public void beforeMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("The method begins " + methodName + " begins with " + args);
	}
	
	public void afterMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " ends with ");
	}
	
	public void afterReturnMethod(JoinPoint joinPoint, Object result){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " ends with " + result );
	}
	
	public void afterThrowing(JoinPoint joinPoint, Exception ex){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " occurs exception " + ex);
	}
	
}
