package com.spring.AOPAroundAdvicedemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopPointCutExpressions {
    @Pointcut("execution(* com.spring.AOPAroundAdvicedemo.dao.*.*(..))")
    public void forDaoPackage() {}

    //create pointcut for getter methods
    @Pointcut("execution(* com.spring.AOPAroundAdvicedemo.dao.*.get*(..))")
    public void forDaoPackageGetters() {}

    //create pointcut for setter methods
    @Pointcut("execution(* com.spring.AOPAroundAdvicedemo.dao.*.set*(..))")
    public void forDaoPackageSetters() {}

    //create pointcut: include package...exclude getters/setters
    @Pointcut("forDaoPackage() && !(forDaoPackageGetters() || forDaoPackageSetters())")
    public void forDaoPackageNoGetterSetter() {}
}
