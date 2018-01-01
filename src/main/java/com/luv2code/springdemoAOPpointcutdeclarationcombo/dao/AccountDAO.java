package com.luv2code.springdemoAOPpointcutdeclarationcombo.dao;

import com.luv2code.springdemoAOPpointcutdeclarationcombo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
    private String name;
    private String serviceCode;

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

    public String getName() {
        System.out.println(getClass() + " : getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + " : setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + " : geServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + " : setServiceCode()");
        this.serviceCode = serviceCode;
    }
}
