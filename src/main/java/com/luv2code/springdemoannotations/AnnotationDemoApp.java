package com.luv2code.springdemoannotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
    public static void main(String[] args) {
        //read spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("annotationApplicationContext.xml");

        //get the bean from spring container
        SwimCoach theCoach = context.getBean("swimCoach",SwimCoach.class);

        //call a method on the bean
        System.out.println(theCoach.getDailyWorkout());

        System.out.println(theCoach.getDailyFortune());

        /* only for swimCoach
        System.out.println(theCoach.getEmail());

        System.out.println(theCoach.getTeam());
        */
        //close the context
        context.close();
    }
}
