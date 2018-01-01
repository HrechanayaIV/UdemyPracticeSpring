package com.luv2code.springAOPdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    //@Before("execution(public void addAccount())")
    //any return type and any method which start with add
    //@Before("execution(* add*())")
    //method with parameter Account
    //@Before("execution(* add*(com.luv2code.springAOPdemo.Account))")
    //method with parameter Account and some parameters
    //@Before("execution(* add*(com.luv2code.springAOPdemo.Account,..))")
    //method witout any parameter
     //@Before("execution(* add*())")
    //any return type, any class, any method, any parameters in package com.luv2code.springAOPdemo.dao
    @Before("execution(* com.luv2code.springAOPdemo.dao.*.*(..))")
    // @Before("execution(public void com.luv2code.springAOPdemo.dao.AccountDAO.addAccount())")
    public void beforeAddAccountAdvice(){
        System.out.println("\n======>>Executing @Before advice an addAccount()");
    }
}
