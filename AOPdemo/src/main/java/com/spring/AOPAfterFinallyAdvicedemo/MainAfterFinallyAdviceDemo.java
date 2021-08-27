package com.spring.AOPAfterFinallyAdvicedemo;



import com.spring.AOPAfterFinallyAdvicedemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainAfterFinallyAdviceDemo {
    public static void main(String[] args) {

        //read the spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        //get the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);

        //call the method to find accounts
        List<Account> theAccounts = null;
        try{
            //add a boolean flag to simulate exceptions
            boolean tripWire = false;
            theAccounts = theAccountDAO.findAccounts(tripWire);

        }
        catch (Exception ex){
            System.out.println("\n\nMain Program ... caught exception: "+ex);
        }

        //display the accounts
        System.out.println("\n\n Main Program:AfterAdviceDemo");
        System.out.println("----");

        System.out.println(theAccounts);
        //close the context
        context.close();
    }
}
