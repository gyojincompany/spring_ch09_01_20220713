package com.gyojincompany.aoptest;

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

}
