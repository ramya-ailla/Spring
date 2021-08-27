package com.spring.AOPOrderAspectsdemo.dao;


import com.spring.AOPAfterReturningAdvicedemo.Account;
import org.springframework.stereotype.Component;

;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;

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
