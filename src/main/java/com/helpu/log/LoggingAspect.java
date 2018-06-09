package com.helpu.log;

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
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 日志切面,生效的两个条件：1.加入IoC容器(@Component)；2.声明为切面(@Aspect)。
 * @author zhengyadong
 * @date 2018年5月27日
 */
@Order(1)
@Aspect
@Component
public class LoggingAspect {
	
	@Pointcut("execution(public void com.helpu.user.service.UserService.add())")
	public void declareJoinPointExpression() {}

	@Before("execution(public void com.helpu.beans.Address.*(String))")
	public void beforeMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("The before method " + methodName + " begin with " + args);
	}

	@Before("declareJoinPointExpression()")
	public void beforeMethodd(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("The before method " + methodName + " begin with " + args);
	}
	
	@After("declareJoinPointExpression()")
	public void afterMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("The after method " + methodName + " begin with " + args);
	}
	
	@AfterReturning(value="declareJoinPointExpression()",returning="result")
	public void afterReturning(JoinPoint joinPoint,Object result) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The afterReturning method " + methodName + " end with " + result);
	}
	
	@AfterThrowing(value="declareJoinPointExpression()",throwing="ex")
	public void afterThrowing(JoinPoint joinPoint,NullPointerException ex) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The afterThrowing method " + methodName + " throwing " + ex);
	}
	
	@Around("declareJoinPointExpression()")
	public Object aroundThrowing(ProceedingJoinPoint pjp) {
		
		Object result = null;
		
		try {
			System.out.println("环绕通知的前置通知...");
			result = pjp.proceed();
			System.out.println("环绕通知的返回通知...");
		} catch (Throwable e) {
			System.out.println("环绕通知的异常通知...");
			throw new RuntimeException(e);
		}
		System.out.println("环绕通知的后置通知...");
		
		return result;
	}
	
}
