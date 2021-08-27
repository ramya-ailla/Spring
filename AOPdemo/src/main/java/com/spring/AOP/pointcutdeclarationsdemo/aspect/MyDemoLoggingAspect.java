package com.spring.AOP.pointcutdeclarationsdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Pointcut("execution(* com.spring.AOP.pointcutdeclarationsdemo.dao.*.*(..))")
    private void forDaoPackage() {}

    //create pointcut for getter methods
    @Pointcut("execution(* com.spring.AOP.pointcutdeclarationsdemo.dao.*.get*(..))")
    private void forDaoPackageGetters() {}

    //create pointcut for setter methods
    @Pointcut("execution(* com.spring.AOP.pointcutdeclarationsdemo.dao.*.set*(..))")
    private void forDaoPackageSetters() {}


    //create pointcut: include package...exclude getters/setters
    @Pointcut("forDaoPackage() && !(forDaoPackageGetters() || forDaoPackageSetters())")
    private void forDaoPackageNoGetterSetter() {}


    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(){
        System.out.println("\n======>>>>>> Executing @Before advice on addAccount()");
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void performApiAnalytics(){
        System.out.println("\n =======>>>> Performing API Analytics");
    }

}
