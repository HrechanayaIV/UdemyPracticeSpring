package com.luv2code.hibernatedemo;

import com.luv2code.hibernatedemo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();
        try {
            int studentId = 6;
            session.beginTransaction();
            //retrieve student based on the id: primary key
            System.out.println("\nGetting student with id: " + studentId);
            Student myStudent = session.get(Student.class,studentId);
            System.out.println("Updating student");
            myStudent.setFirst_name("Scooby");
           //commit the transaction
            session.getTransaction().commit();
            //New CODE
            session = factory.getCurrentSession();
            session.beginTransaction();
            //update email for all students
            System.out.println("update email for all students");
            session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
            //commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
