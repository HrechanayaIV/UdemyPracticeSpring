package com.luv2code.hb_03_one_to_many;

import com.luv2code.hb_03_one_to_many.entity.Course;
import com.luv2code.hb_03_one_to_many.entity.Instructor;
import com.luv2code.hb_03_one_to_many.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateICoursesDemo {
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
            //create a transaction
            session.beginTransaction();

            //get the instructor from db
            int theId = 1;
            Instructor instructor = session.get(Instructor.class, theId);

            //create some courses
            Course course1 = new Course("Air Guitar MasterClass");
            Course course2 = new Course("The Pinball MasterClass");

            //add courses to instructor
            instructor.add(course1);
            instructor.add(course2);

            //save the courses
            session.save(course1);
            session.save(course2);

            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        }finally {
            session.close();

            factory.close();
        }
    }
}
