package com.luv2code.hibernatedemo;

import com.luv2code.hibernatedemo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();
        try {
            //use the session object to save Java object
            System.out.println("Creating new student object");
            Student tempStudent = new Student("Anna", "Polujan", "AP@gmail,.com");
            //create a transaction
            session.beginTransaction();
            //save the student object
            System.out.println("Saving the student");
            System.out.println(tempStudent);
            session.save(tempStudent);
            //commit the transaction
            session.getTransaction().commit();
            //MY NEW CODE
            //find out the student`s id: primary key
            System.out.println("Saved student. Generated id: " + tempStudent.getId());
            //now get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();
            //retrieve student based on the id: primary key
            System.out.println("\nGetting student with id: " + tempStudent.getId());
            Student myStudent = session.get(Student.class, tempStudent.getId());
            System.out.println("Get complete: " + myStudent);
            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}