package com.hibernateOneToManyBiMappings.demo;

import com.hibernateOneToManyBiMappings.entities.Course;
import com.hibernateOneToManyBiMappings.entities.Instructor;
import com.hibernateOneToManyBiMappings.entities.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorCoursesDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory= new Configuration()
                                .configure("hibernateOneToManyBiMapping.cfg.xml")
                                .addAnnotatedClass(Instructor.class)
                                .addAnnotatedClass(InstructorDetail.class)
                                .addAnnotatedClass(Course.class)
                                .buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();
        try{

            //start a transaction
            session.beginTransaction();

            //get instructor from the database
            int theId = 1;
            Instructor instructor = session.get(Instructor.class,theId);
            System.out.println(instructor);

            //get course for the instructor
            System.out.println("Courses: "+instructor.getCourses());



            //commit transaction
            session.getTransaction().commit();
            System.out.println("Done!...");
        }
        finally {
            factory.close();
        }
    }
}
