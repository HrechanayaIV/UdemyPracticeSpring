package com.luv2code.springAOPdemo;

import com.luv2code.springAOPdemo.dao.AccountDAO;
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
        //do it again
        System.out.println("\n let`s call again!");

        theAccountDAO.addNonAccount();

        //close the context
        context.close();
    }
}
