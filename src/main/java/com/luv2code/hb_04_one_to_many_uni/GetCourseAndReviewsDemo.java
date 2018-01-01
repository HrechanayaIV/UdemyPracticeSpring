package com.luv2code.hb_04_one_to_many_uni;

import com.luv2code.hb_04_one_to_many_uni.entity.Course;
import com.luv2code.hb_04_one_to_many_uni.entity.Instructor;
import com.luv2code.hb_04_one_to_many_uni.entity.InstructorDetail;
import com.luv2code.hb_04_one_to_many_uni.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCourseAndReviewsDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();
        try {
            //start a transaction
            session.beginTransaction();

           //get the course
            int theId = 12;
            Course tempCourse = session.get(Course.class,theId);

            System.out.println("TempCourse : " + tempCourse);

            System.out.println(tempCourse.getReviews());
            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        }finally {
            session.close();

            factory.close();
        }
    }
}
