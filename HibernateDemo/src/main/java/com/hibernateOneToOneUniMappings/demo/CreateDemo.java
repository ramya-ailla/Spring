package com.hibernateOneToOneUniMappings.demo;

import com.hibernateOneToOneUniMappings.entities.Instructor;
import com.hibernateOneToOneUniMappings.entities.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory= new Configuration()
                                .configure("hibernateOneToOneMapping.cfg.xml")
                                .addAnnotatedClass(Instructor.class)
                                .addAnnotatedClass(InstructorDetail.class)
                                .buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();
        try{
            //create the objects
            /*Instructor tempInstructor = new Instructor("Chad","Darby","darby@luv2code.com");
            InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code.com/youtube","Luv 2 Code");*/
            Instructor tempInstructor = new Instructor("Madhu","Patil","Madhu@gmail.com");
            InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com","Guitar");
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
