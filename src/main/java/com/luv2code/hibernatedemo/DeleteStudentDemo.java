package com.luv2code.hibernatedemo;

import com.luv2code.hibernatedemo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {
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
            System.out.println("Delete student" + myStudent);
            //delete the student
            session.delete(myStudent);
           //commit the transaction
            session.getTransaction().commit();
            //new Code
            //delete the student id = 7
            session.createQuery("delete from Student where id=7").executeUpdate();
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
