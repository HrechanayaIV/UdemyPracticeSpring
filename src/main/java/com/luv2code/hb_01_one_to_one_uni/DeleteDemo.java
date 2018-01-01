package com.luv2code.hb_01_one_to_one_uni;

import com.luv2code.hb_01_one_to_one_uni.entity.Instructor;
import com.luv2code.hb_01_one_to_one_uni.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();
        try {

            //create a transaction
            session.beginTransaction();

            //get instructor by primary key / id
            int theId = 1;
            Instructor tempInstructor = session.get(Instructor.class, theId);

            System.out.println("Found instructor: " + tempInstructor);

            //delete the instructor
            if(tempInstructor != null){
                System.out.println("Deleting : " + tempInstructor);
                //Note: will also delete associated "details" object
                //because od CascadeType.ALL
                session.delete(tempInstructor);
            }
            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        }finally {
            factory.close();
        }
    }
}
