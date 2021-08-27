package com.spring.AOPAfterThrowingAdvicedemo;


import com.spring.AOPAfterThrowingAdvicedemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainAfterThrowingAdviceDemo {
    public static void main(String[] args) {

        //read the spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        //get the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);

        //call the method to find accounts
        List<Account> theAccounts = null;
        try{
            //add a boolean flag to simulate exceptions
            boolean tripWire = true;
            theAccounts = theAccountDAO.findAccounts(tripWire);

        }
        catch (Exception ex){
            System.out.println("\n\nMain Program ... caught exception: "+ex);
        }

        //display the accounts
        System.out.println("\n\n Main Program:AfterThrowingAdviceDemo");
        System.out.println("----");

        System.out.println(theAccounts);
        //close the context
        context.close();
    }
}
