package com.test07;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

public class LoggingAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		String methodName = invocation.getMethod().getName();
		
		StopWatch timer = new StopWatch();
		
		timer.start(methodName);
		System.out.println("[LOG] METHOD : " + methodName + " is Calling..");
		//이전 실행할 코드
		Object obj = invocation.proceed();	//타겟 실행
		//이후 실행할 코드
		timer.stop();
		System.out.println("[LOG] METHOD : " + methodName + " was Called..");
		System.out.println("[LOG] TIME : " + timer.getTotalTimeSeconds()+"sec");
		
		return obj;
	}

}
