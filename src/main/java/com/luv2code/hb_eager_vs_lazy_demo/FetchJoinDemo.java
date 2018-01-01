package com.luv2code.hb_eager_vs_lazy_demo;

import com.luv2code.hb_eager_vs_lazy_demo.entity.Course;
import com.luv2code.hb_eager_vs_lazy_demo.entity.Instructor;
import com.luv2code.hb_eager_vs_lazy_demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;

public class FetchJoinDemo {
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
            //option 2 : Hibernate query with HQL

            //get the instructor from db
            int theId = 1;
            Query<Instructor> query =
                    session.createQuery("select i from Instructor i " +
                                    "JOIN FETCH i.courses " +
                            "WHERE i.id=:theInstructorId",
                            Instructor.class);
            //set parameter on query
            query.setParameter("theInstructorId",theId);

            //execute query and get instructor
            Instructor instructor = query.getSingleResult();

            System.out.println("Instructor: " + instructor);

            //commit the transaction
            session.getTransaction().commit();
            //close the session
            session.close();
            System.out.println("\nThe session is now closed!\n");
            //get courses from instructor
            System.out.println("Courses: " + instructor.getCourses());

            System.out.println("Done!");
        }finally {
            session.close();

            factory.close();
        }
    }
}
