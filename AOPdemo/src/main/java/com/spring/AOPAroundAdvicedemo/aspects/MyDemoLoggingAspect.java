package com.spring.AOPAroundAdvicedemo.aspects;

import com.spring.AOPAroundAdvicedemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
    private Logger mylogger = Logger.getLogger(getClass().getName());

    //add a new advice for @AfterReturning on the findAccounts method
    @AfterReturning(
            pointcut = "execution(* com.spring.AOPAroundAdvicedemo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(
            JoinPoint theJoinPoint, List<Account> result){
        // print out which method we are advising on
        String methodSignature = theJoinPoint.getSignature().toShortString();
        mylogger.info("\n =======>Executing after returning from the method: "+methodSignature);

        // print out the results of the method call
        mylogger.info("\n=======>>>>Result is: "+result);


        //let's post process the data
        //convert the account names to uppercase
        convertAccountNamesToUpperCase(result);

        mylogger.info("\n=======>>>>Result is: "+result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        for(Account tempAccount: result){
            tempAccount.setName(tempAccount.getName().toUpperCase());
        }
    }


    @Before("com.spring.AOPAroundAdvicedemo.aspects.AopPointCutExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJointPoint){
        mylogger.info("\n======>>>>>> Executing @Before advice on addAccount()");

        //display the method signature
        MethodSignature methodSignature =(MethodSignature) theJointPoint.getSignature();
        mylogger.info("Method: "+methodSignature);
        //display the method arguments
        //get the arguments
        Object[] tempArgs = theJointPoint.getArgs();

        //loop through the arguments
        for(Object tempArg:tempArgs){
            if(tempArg instanceof Account){
              Account theAccount =(Account) tempArg;

              mylogger.info("Account name: "+theAccount.getName());
              mylogger.info("Account level: "+theAccount.getLevel());
            }

        }


    }

    @AfterThrowing(
            pointcut = "execution(* com.spring.AOPAroundAdvicedemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExe")
    public void afterThrowingFindAccountAdvice(
            JoinPoint theJoinPoint, Throwable theExe){
        //print out which method we are advising on
        String methodSignature = theJoinPoint.getSignature().toShortString();
        mylogger.info("\n =======>Executing after throwing from the method: "+methodSignature);
        //log the exception
        mylogger.info("\n ========>>> The Exception is: "+theExe);
    }

    @After("execution(* com.spring.AOPAroundAdvicedemo.dao.AccountDAO.findAccounts(..)))")
    public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint){

        //print out which method we are advising on
        String methodSignature = theJoinPoint.getSignature().toShortString();
        mylogger.info("\n =======>Executing @After(finally) on  method: "+methodSignature);
    }
    /*** compute duration for target method execution*/
    /*
    @Around("execution(* com.spring.AOPAroundAdvicedemo.Service.*.getFortune(..)))")
    public Object aroundGetFortune(
            ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        //print out method we are advising on
        String methodSignature = proceedingJoinPoint.getSignature().toShortString();
        mylogger.info("\n =======>Executing @Around on the method: "+methodSignature);
        //get begin timestamp
        long begin = System.currentTimeMillis();
        //now,let's execute the method
        Object result = proceedingJoinPoint.proceed();
        //get end timestamp
        long end = System.currentTimeMillis();
        long duration = end - begin;
        //compute duration and display it
        mylogger.info("\n=======>>>>>Duration is :"+duration/1000.0+" Seconds");
        return result;
    }*/
    /***Handle the exception for target method or simple re-throw it  */
    @Around("execution(* com.spring.AOPAroundAdvicedemo.Service.*.getFortune(..)))")
    public Object aroundGetFortune(
            ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        //print out method we are advising on
        String methodSignature = proceedingJoinPoint.getSignature().toShortString();
        mylogger.info("\n =======>Executing @Around on the method: "+methodSignature);
        //get begin timestamp
        long begin = System.currentTimeMillis();
        Object result=null;
        try {
            //now,let's execute the method
            result = proceedingJoinPoint.proceed();
        }catch (Exception e){

            /***handling the exception */
            /*
           // log the exception
            mylogger.warning(e.getMessage());
            //give user a custom error message
            result = "Major accident! But no worries, "+"your private AOP helicopter is on the way!";

             */
            /*** Re-throwing the exception */
            mylogger.warning(e.getMessage());
            throw e;

        }

        //get end timestamp
        long end = System.currentTimeMillis();
        long duration = end - begin;
        //compute duration and display it
        mylogger.info("\n=======>>>>>Duration is :"+duration/1000.0+" Seconds");
        return result;
    }

}
