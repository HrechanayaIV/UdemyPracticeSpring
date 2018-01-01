package com.luv2code.springdemoAOPpointcutdeclarationcombo;

import com.luv2code.springdemoAOPpointcutdeclarationcombo.Account;
import com.luv2code.springdemoAOPpointcutdeclarationcombo.DemoConfig;
import com.luv2code.springdemoAOPpointcutdeclarationcombo.dao.AccountDAO;
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

        //call the account getter/setter method
        theAccountDAO.setServiceCode("foobar");
        theAccountDAO.setName("Silver");

        String name = theAccountDAO.getName();
        String code = theAccountDAO.getServiceCode();

        //close the context
        context.close();
    }
}
