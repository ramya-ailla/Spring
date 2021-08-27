package com.spring.AOPOrderAspectsdemo.aspect;

import com.spring.AOPAfterReturningAdvicedemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Before("com.spring.AOPOrderAspectsdemo.aspect.AopPointCutExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJointPoint){
        System.out.println("\n======>>>>>> Executing @Before advice on addAccount()");

        //display the method signature
        MethodSignature methodSignature =(MethodSignature) theJointPoint.getSignature();
        System.out.println("Method: "+methodSignature);
        //display the method arguments
        //get the arguments
        Object[] tempArgs = theJointPoint.getArgs();

        //loop through the arguments
        for(Object tempArg:tempArgs){
            if(tempArg instanceof Account){
              Account theAccount =(Account) tempArg;

              System.out.println("Account name: "+theAccount.getName());
              System.out.println("Account level: "+theAccount.getLevel());
            }

        }


    }



}
