package com.luv2code.springdemoAOPpointcutdeclarationcombo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    //add pointcut
    @Pointcut("execution(* com.luv2code.springdemoAOPpointcutdeclarationcombo.dao.*.*(..))")
    private void forDaoPackage(){}

    //create pointcut for getter method
    @Pointcut("execution(* com.luv2code.springdemoAOPpointcutdeclarationcombo.dao.*.get*(..))")
    private void getter(){}

    //create pointcut for setter method
    @Pointcut("execution(* com.luv2code.springdemoAOPpointcutdeclarationcombo.dao.*.set*(..))")
    private  void setter(){}

    //create pointcut: include package exclude getter/setter
    @Pointcut("forDaoPackage()&&!(getter()||setter())")
    private void forDaoPackageNoGetterSetter(){}

    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(){
        System.out.println("\n======>>Executing @Before advice an addAccount()");
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void performApiAnalytics(){
        System.out.println("\n======>> Performing API analytics");
    }
}
