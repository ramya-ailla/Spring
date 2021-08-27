package com.spring.AOPAfterReturningAdvicedemo;



import com.spring.AOPAfterReturningAdvicedemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainAfterReturningAdviceDemoApp {
    public static void main(String[] args) {

        //read the spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        //get the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);

        //call the method to find accounts
        List<Account> theAccounts = theAccountDAO.findAccounts();

        //display the accounts
        System.out.println("\n\n Main Program:AfterReturningAdviceDemo");
        System.out.println("----");

        System.out.println(theAccounts);
        //close the context
        context.close();
    }
}
