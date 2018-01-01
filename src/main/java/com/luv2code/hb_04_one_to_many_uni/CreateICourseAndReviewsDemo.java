package com.luv2code.hb_04_one_to_many_uni;

import com.luv2code.hb_04_one_to_many_uni.entity.Course;
import com.luv2code.hb_04_one_to_many_uni.entity.Instructor;
import com.luv2code.hb_04_one_to_many_uni.entity.InstructorDetail;
import com.luv2code.hb_04_one_to_many_uni.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateICourseAndReviewsDemo {
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

           //create a course
            Course tempCourse = new Course("Pacman - How to score one Million Points");

            //add some reviews
            tempCourse.addReview(new Review("Create course love it!"));
            tempCourse.addReview(new Review("Create course job well done!"));
            tempCourse.addReview(new Review("What a dumb course, you are an idiot!"));

            //save the course and leverage the cascade all
            System.out.println("Saving the course");
            System.out.println(tempCourse);
            System.out.println(tempCourse.getReviews());

            session.save(tempCourse);

            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        }finally {
            session.close();

            factory.close();
        }
    }
}
