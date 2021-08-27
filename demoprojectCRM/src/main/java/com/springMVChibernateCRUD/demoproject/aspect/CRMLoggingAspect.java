package com.springMVChibernateCRUD.demoproject.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {
    //set up logger
    private Logger myLogger = Logger.getLogger(getClass().getName());

    //setup pointcut declarations
    @Pointcut("execution(* com.springMVChibernateCRUD.demoproject.controller.*.*(..))")
    private void forControllerPackage() {}

    @Pointcut("execution(* com.springMVChibernateCRUD.demoproject.service.*.*(..))")
    private void forServicePackage() {}

    @Pointcut("execution(* com.springMVChibernateCRUD.demoproject.dao.*.*(..))")
    private void forDAOPackage() {}

    @Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
    private void forAppFlow() {}

    //add @Before advice
    @Before("forAppFlow()")
    public void before(JoinPoint theJoinPoint){
        // display the method we are calling
          String methodName = theJoinPoint.getSignature().toShortString();
          myLogger.info("======>>>> in @Before: calling method: "+methodName);

        //display the arguments to the method

        //get the arguments
        Object [] args = theJoinPoint.getArgs();

        //loop through and display arguments
        for(Object temparg:args){
            myLogger.info("=====>>>> argument: "+temparg);
        }
    }

    //add @AfterReturning advice
    @AfterReturning(pointcut = "forAppFlow()",
    returning = "theResult")
    public void after(JoinPoint theJoinPoint, Object theResult){

        //display the method we are returning from
        String methodName = theJoinPoint.getSignature().toShortString();
        myLogger.info("======>>>> in @After: calling method: "+methodName);

        //display the data returned
        myLogger.info("=====>>>> Result: "+ theResult);
    }
}
