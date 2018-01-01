package com.luv2code.hb_01_one_to_one_uni;

import com.luv2code.hb_01_one_to_one_uni.entity.Instructor;
import com.luv2code.hb_01_one_to_one_uni.entity.InstructorDetail;
import com.luv2code.hibernatedemo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
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
            //create the objects
            /**
            Instructor tempInstructor =
                    new Instructor("Chad","Darby","darby@gmail.com");
            InstructorDetail theInstructorDetail =
                    new InstructorDetail("http://www.luv2code.com/youtube",
                            "Luv 2 code!!");
             */
            Instructor tempInstructor =
                    new Instructor("Madhu","Patel","madhu@gmail.com");
            InstructorDetail theInstructorDetail =
                    new InstructorDetail("http://youtube.com",
                            "Guitar!!");

            //associate the objects
            tempInstructor.setInstructorDetail(theInstructorDetail);

            //create a transaction
            session.beginTransaction();

            //save the instructor
            //Note: this will Also save the details object
            //because of CascadeType.ALL
            System.out.println("Savind instructor: " + tempInstructor);
            session.save(tempInstructor);

            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        }finally {
            factory.close();
        }
    }
}
