package com.luv2code.hibernatedemo;

import com.luv2code.hibernatedemo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();
        try {
            //create 3 student object
            System.out.println("Creating 3 student object");
            Student tempStudent1 = new Student("Inna", "Hrechana", "bla1@gmail.com");
            Student tempStudent2 = new Student("Pasha", "Kozachek", "bla2@gmail,.com");
            Student tempStudent3 = new Student("Katja", "Stasenko", "bla3@gmail,.com");
            //start a transaction
            session.beginTransaction();
            //save the student object
            System.out.println("Saving the students");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);
            //commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        }finally {
            factory.close();
        }
    }
}
