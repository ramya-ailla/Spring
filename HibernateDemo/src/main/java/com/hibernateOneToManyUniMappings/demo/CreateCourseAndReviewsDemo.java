package com.hibernateOneToManyUniMappings.demo;



import com.hibernateOneToManyUniMappings.entities.Course;
import com.hibernateOneToManyUniMappings.entities.Instructor;
import com.hibernateOneToManyUniMappings.entities.InstructorDetail;
import com.hibernateOneToManyUniMappings.entities.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndReviewsDemo {
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

            //create a course
            Course tempCourse = new Course("Pacman - How to Score One Million Points");
            //add some reviews to the course
            tempCourse.addReview(new Review("Great course ... loved it!"));
            tempCourse.addReview(new Review("Cool Course, job well done!"));
            tempCourse.addReview(new Review("What a dumb course; you are an idiot!"));
            //save the course....leverage the cascade.all
            System.out.println("Saving the Course...");
            System.out.println(tempCourse);
            System.out.println(tempCourse.getReviews());

            session.save(tempCourse);
            //commit transaction
            session.getTransaction().commit();
            System.out.println("Done!...");
        }
        finally {
            factory.close();
        }
    }
}
