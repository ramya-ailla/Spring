package com.spring.AOPAfterReturningAdvicedemo.aspect;

import com.spring.AOPAfterReturningAdvicedemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    //add a new advice for @AfterReturning on the findAccounts method
    @AfterReturning(
            pointcut = "execution(* com.spring.AOPAfterReturningAspectdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(
            JoinPoint theJoinPoint, List<Account> result){
        // print out which method we are advising on
        String methodSignature = theJoinPoint.getSignature().toShortString();
        System.out.println("\n =======>Executing after returning from the method: "+methodSignature);

        // print out the results of the method call
        System.out.println("\n=======>>>>Result is: "+result);


        //let's post process the data
        //convert the account names to uppercase
        convertAccountNamesToUpperCase(result);

        System.out.println("\n=======>>>>Result is: "+result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        for(Account tempAccount: result){
            tempAccount.setName(tempAccount.getName().toUpperCase());
        }
    }


    @Before("com.spring.AOPAfterReturningAspectdemo.aspect.AopPointCutExpressions.forDaoPackageNoGetterSetter()")
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
