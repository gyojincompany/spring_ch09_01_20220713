package com.gyojincompany.aoptest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LogAop {
	
	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable {
		
		String signatureStr = joinpoint.getSignature().toShortString();
		System.out.println(signatureStr + "가 시작되었습니다.");
		
		long st = System.currentTimeMillis();
		
		try {
			Object obj = joinpoint.proceed();
			return obj;
		} finally {
			long et = System.currentTimeMillis();
			System.out.println(signatureStr + "가 종료되었습니다.");
			System.out.println(signatureStr + "경과시간 : " + (et-st));
		}
	}
	
	public void beforeAdvice(JoinPoint joinpoint) {
		System.out.println("beforeAdvice 실행!");
	}
	
	public void afterAdvice(JoinPoint joinpoint) {
		System.out.println("afterAdvice 실행!");
	}
	
	public void afterReturnAdvice(JoinPoint joinpoint) {
		System.out.println("afterReturnAdvice 실행!");
	}
	
	public void afterThrowingAdvice(JoinPoint joinpoint) {
		System.out.println("afterThrowingAdvice 실행!");
	}

}
