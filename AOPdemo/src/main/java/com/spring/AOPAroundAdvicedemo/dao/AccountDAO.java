package com.spring.AOPAroundAdvicedemo.dao;

import com.spring.AOPAroundAdvicedemo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;

    //add a method :find accounts
    public List<Account> findAccounts(boolean tripWire){
        //to simulate an exception
        if(tripWire){
            throw new RuntimeException("Created Exception");
        }
        List<Account> myAccounts = new ArrayList<>();

        //create sample accounts
        Account temp1 = new Account("John","Silver");
        Account temp2 = new Account("Madhu","platinum");
        Account temp3 = new Account("Luca","Gold");

        //add them to our accounts list
        myAccounts.add(temp1);
        myAccounts.add(temp2);
        myAccounts.add(temp3);

        return myAccounts;
    }

    public String getName() {
        System.out.println(getClass() + " : getName()");
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println(getClass() + " : in setName()");
    }

    public String getServiceCode() {
        System.out.println(getClass() + " : in getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + " : in setServiceCode()");
        this.serviceCode = serviceCode;
    }

    public void addAccount(Account theAccount, boolean vipFlag){

        System.out.println(getClass() + ": Doing my DB WORK: Adding an Account");

    }
    public boolean doWork(){
        System.out.println(getClass() + " :in doWork()");
        return false;
    }
}
