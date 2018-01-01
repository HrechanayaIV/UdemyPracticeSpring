package com.luv2code.springdemoAOPpointcutdeclaration.dao;

import com.luv2code.springdemoAOPpointcutdeclaration.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    public void addAccount2(Account account, boolean vipFlag){
        System.out.println(getClass()+ ": doing my DB work : adding na account");
    }
    public void addNonAccount(){
        System.out.println("Method without parameter");
    }
    public boolean doWork(){
        System.out.println(getClass() + " doWork()");
        return false;
    }
}
