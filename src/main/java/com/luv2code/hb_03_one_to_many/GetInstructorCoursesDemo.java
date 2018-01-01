package com.luv2code.hb_03_one_to_many;

import com.luv2code.hb_03_one_to_many.entity.Course;
import com.luv2code.hb_03_one_to_many.entity.Instructor;
import com.luv2code.hb_03_one_to_many.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorCoursesDemo {
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

            System.out.println("Instructor: " + instructor);

            //get courses from instructor
            System.out.println("Courses: " + instructor.getCourses());

            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        }finally {
            session.close();

            factory.close();
        }
    }
}
