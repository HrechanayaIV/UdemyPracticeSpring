package com.luv2code.hibernatedemo;

import com.luv2code.hibernatedemo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();
        try {
            //create a transaction
            session.beginTransaction();
            //query students
            List<Student> theStudents = session.createQuery("from Student").getResultList();
            //display the students
            displayTheStudents(theStudents);
            //query students : lastName = "Hrechana"
            theStudents = session.createQuery("from Student s where s.last_name='Hrechana'").getResultList();
            //display the students
            System.out.println("\n Students who have last name of Hrechana");
            displayTheStudents(theStudents);
            //query students where wmail LIKE '%gmail.com'
            theStudents = session.createQuery("from Student s where "
            + "s.email LIKE '%gmail.com'").getResultList();
            //
            System.out.println("\nStudents whose email ands with gmail.com");
            displayTheStudents(theStudents);
            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        }finally {
            factory.close();
        }
    }

    private static void displayTheStudents(List<Student> theStudents) {
        for(Student tempStudent : theStudents){
            System.out.println(tempStudent);
        }
    }
}
