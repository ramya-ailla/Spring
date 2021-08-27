package com.hibernateOneToManyBiMappings.demo;

import com.hibernateOneToManyBiMappings.entities.Course;
import com.hibernateOneToManyBiMappings.entities.Instructor;
import com.hibernateOneToManyBiMappings.entities.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseDemo {
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

            //get a course
            int theId = 10;
            Course tempCourse = session.get(Course.class,theId);

            //delete  course
            session.delete(tempCourse);



            //commit transaction
            session.getTransaction().commit();
            System.out.println("Done!...");
        }
        finally {
            factory.close();
        }
    }
}
