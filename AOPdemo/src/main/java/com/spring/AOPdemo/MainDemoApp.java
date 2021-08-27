package com.spring.AOPdemo;

import com.spring.AOPdemo.dao.AccountDAO;
import com.spring.AOPdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {

        //read the spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        //get the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);
        MembershipDAO theMembershipDAO = context.getBean("membershipDAO",MembershipDAO.class);

        //call the business method
        Account account = new Account();
        theAccountDAO.addAccount(account,true);
        theAccountDAO.doWork();
        //call the membership
        theMembershipDAO.addSillyMember();
        theMembershipDAO.goToSleep();


        //close the context
        context.close();
    }
}
