package com.spring.AOP.pointcutdeclarationsdemo;

import com.spring.AOP.pointcutdeclarationsdemo.dao.AccountDAO;
import com.spring.AOP.pointcutdeclarationsdemo.dao.MembershipDAO;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainPointCutDemoApp {
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

        //call the accountdao getter/setter methods
        theAccountDAO.setName("foobar");
        theAccountDAO.setServiceCode("silver");

        String name = theAccountDAO.getName();
        String code = theAccountDAO.getServiceCode();

        //call the membership methods
        theMembershipDAO.addSillyMember();
        theMembershipDAO.goToSleep();


        //close the context
        context.close();
    }
}
