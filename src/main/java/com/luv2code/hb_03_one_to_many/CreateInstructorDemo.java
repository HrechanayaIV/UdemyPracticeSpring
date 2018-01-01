package com.luv2code.hb_03_one_to_many;

import com.luv2code.hb_03_one_to_many.entity.Course;
import com.luv2code.hb_03_one_to_many.entity.Instructor;
import com.luv2code.hb_03_one_to_many.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();
        try {
            //create the objects
            Instructor tempInstructor =
                    new Instructor("Susan","Public","susan@gmail.com");
            InstructorDetail theInstructorDetail =
                    new InstructorDetail("http://youtube.com",
                            "Game!!");

            //associate the objects
            tempInstructor.setInstructorDetail(theInstructorDetail);

            //create a transaction
            session.beginTransaction();

            //save the instructor
            //Note: this will Also save the details object
            //because of CascadeType.ALL
            System.out.println("Saving instructor: " + tempInstructor);
            session.save(tempInstructor);

            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        }finally {
            session.close();

            factory.close();
        }
    }
}
