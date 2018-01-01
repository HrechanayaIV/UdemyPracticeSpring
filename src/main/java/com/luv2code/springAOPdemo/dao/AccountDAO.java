package com.luv2code.springAOPdemo.dao;

import com.luv2code.springAOPdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO{

    public void addAccount2(Account account, boolean vipFlag){
        System.out.println(getClass()+ ": doing my DB work : adding na account");
    }
    public void addNonAccount(){
        System.out.println("Method without parameter");
    }
}
