package com.hibernateManyToManyMappings.demo;



import com.hibernateManyToManyMappings.entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeletePacManCourseDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory= new Configuration()
                                .configure("hibernateManyToManyMapping.cfg.xml")
                                .addAnnotatedClass(Instructor.class)
                                .addAnnotatedClass(InstructorDetail.class)
                                .addAnnotatedClass(Course.class)
                                .addAnnotatedClass(Review.class)
                                .addAnnotatedClass(Student.class)
                                .buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();
        try{

            //start a transaction
            session.beginTransaction();

            //get the PacMan course from the database
            int courseId = 10;
            Course pacManCourse = session.get(Course.class,courseId);

            //Delete the Course
            System.out.println("Deleting the Course: "+pacManCourse);

            session.delete(pacManCourse);


            //commit transaction
            session.getTransaction().commit();
            System.out.println("Done!...");
        }
        finally {
            factory.close();
        }
    }
}
