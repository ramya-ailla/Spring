package com.spring.AOPOrderAspectsdemo;


import com.spring.AOPAfterReturningAdvicedemo.Account;
import com.spring.AOPOrderAspectsdemo.dao.AccountDAO;
import com.spring.AOPOrderAspectsdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainOrderAspectsDemoApp {
    public static void main(String[] args) {

        //read the spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        //get the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);
        MembershipDAO theMembershipDAO = context.getBean("membershipDAO",MembershipDAO.class);

        //call the business method
        Account account = new Account();
        account.setName("Madhu");
        account.setLevel("Platinum");
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
