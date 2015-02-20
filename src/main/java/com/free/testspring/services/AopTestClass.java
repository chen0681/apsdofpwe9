package com.free.testspring.services;

import org.aspectj.lang.ProceedingJoinPoint;

public class AopTestClass {

	public void aroundTest(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("Start Call " + joinPoint.getTarget());
		joinPoint.proceed();
		
		System.out.println("End Call " + joinPoint.getTarget());
	}
}
