package com.spring.AOPdemo.dao;

import com.spring.AOPdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    public void addAccount(Account theAccount,boolean vipFlag){

        System.out.println(getClass() + ": Doing my DB WORK: Adding an Account");

    }
    public boolean doWork(){
        System.out.println(getClass() + " : doWork()");
        return false;
    }
}
