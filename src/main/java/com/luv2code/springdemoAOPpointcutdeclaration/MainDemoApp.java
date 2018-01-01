package com.luv2code.springdemoAOPpointcutdeclaration;

import com.luv2code.springdemoAOPpointcutdeclaration.dao.AccountDAO;
import com.luv2code.springdemoAOPpointcutdeclaration.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {
        //read Spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);
        //get the bean from the spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

        //call the business method
        theAccountDAO.addAccount2(new Account(), true);
        theAccountDAO.doWork();
        //do it again
        System.out.println("\n let`s call again!");

        theAccountDAO.addNonAccount();

        //close the context
        context.close();
    }
}
