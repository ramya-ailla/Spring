package com.spring.AOPAfterFinallyAdvicedemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopPointCutExpressions {
    @Pointcut("execution(* com.spring.AOPAfterFinallyAdvicedemo.dao.*.*(..))")
    public void forDaoPackage() {}

    //create pointcut for getter methods
    @Pointcut("execution(* com.spring.AOPAfterFinallyAdvicedemo.dao.*.get*(..))")
    public void forDaoPackageGetters() {}

    //create pointcut for setter methods
    @Pointcut("execution(* com.spring.AOPAfterFinallyAdvicedemo.dao.*.set*(..))")
    public void forDaoPackageSetters() {}

    //create pointcut: include package...exclude getters/setters
    @Pointcut("forDaoPackage() && !(forDaoPackageGetters() || forDaoPackageSetters())")
    public void forDaoPackageNoGetterSetter() {}
}
