package com.corey.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	
	// Setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	// Setup pointcut declarations
	@Pointcut("execution(* com.corey.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.corey.springdemo.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.corey.springdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	// Add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		
		// Display method we are calling
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info(theMethod);
		
		// Display the arguments to the method
		
	}
	
	// Add @AfterReturning advice

}
