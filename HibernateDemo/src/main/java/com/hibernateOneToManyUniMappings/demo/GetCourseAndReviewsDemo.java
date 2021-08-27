package com.hibernateOneToManyUniMappings.demo;



import com.hibernateOneToManyUniMappings.entities.Course;
import com.hibernateOneToManyUniMappings.entities.Instructor;
import com.hibernateOneToManyUniMappings.entities.InstructorDetail;
import com.hibernateOneToManyUniMappings.entities.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCourseAndReviewsDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory= new Configuration()
                                .configure("hibernateOneToManyUniMapping.cfg.xml")
                                .addAnnotatedClass(Instructor.class)
                                .addAnnotatedClass(InstructorDetail.class)
                                .addAnnotatedClass(Course.class)
                                .addAnnotatedClass(Review.class)
                                .buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();
        try{

            //start a transaction
            session.beginTransaction();

            //get the course
            int theId =10;
            Course tempCourse = session.get(Course.class,theId);

            //print the course
            System.out.println(tempCourse);
            //print the course reviews
            System.out.println(tempCourse.getReviews());

            //commit transaction
            session.getTransaction().commit();
            System.out.println("Done!...");
        }
        finally {
            factory.close();
        }
    }
}
