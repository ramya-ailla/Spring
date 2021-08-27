package com.hibernateOneToManyBiMappings.demo;

import com.hibernateOneToManyBiMappings.entities.Course;
import com.hibernateOneToManyBiMappings.entities.Instructor;
import com.hibernateOneToManyBiMappings.entities.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {
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
            //create the objects
           Instructor tempInstructor = new Instructor("Susan","Public","susanpublic@gmail.com");
           InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com","Video Games");

            //associate the objects
            tempInstructor.setInstructorDetail(tempInstructorDetail);
            //start a transaction
            session.beginTransaction();

            //save the instructor
            System.out.println("Saving the Instructor "+tempInstructor);
            session.save(tempInstructor);
            /*this will also save the instructor detail object because of CascadeType.ALL*/
            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!...");
        }
        finally {
            factory.close();
        }
    }
}
