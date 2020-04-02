package com.tpsoft.platform.common.aop;

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

@Component
@Aspect
public class AopApplication {

	@Pointcut("execution(* *(..))")
	public void pcl() {
		
	}
	@Before(value = "pcl()")
	public void before(JoinPoint jp) {
		String name = jp.getSignature().getName();
		System.out.println("before---"+name);
	}
	@After(value = "pcl()")
	public void after(JoinPoint jp) {
		String name = jp.getSignature().getName();
		System.out.println("after---"+name);
	}
	@AfterReturning(value = "pcl()" ,returning = "result")
	public void afterReturning(JoinPoint jp,Object result) {
		String name = jp.getSignature().getName();
		System.out.println("afterReturning---"+name+"----"+result);
	}
	@AfterThrowing(value = "pcl()",throwing = "e")
	public void afterThrowing(JoinPoint jp,Exception e) {
		String name = jp.getSignature().getName();
		System.out.println("afterThrowing---"+name+"----"+e.getMessage());
	}
	
	//可以前置，可以后置可以抛出
	@Around("pel()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable{
		//只有调用.proceed方法才会执行方法
		Object proceed = pjp.proceed();
		return proceed;
	}
	
}
