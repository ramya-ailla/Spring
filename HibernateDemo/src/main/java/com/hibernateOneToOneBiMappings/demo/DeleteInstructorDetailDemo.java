package com.hibernateOneToOneBiMappings.demo;

import com.hibernateOneToOneBiMappings.entities.Instructor;
import com.hibernateOneToOneBiMappings.entities.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {
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
            //start a transaction
            session.beginTransaction();

            //get the instructor detail object
            int theId=3;
            //print the instructor detail
            InstructorDetail instructorDetail= session.get(InstructorDetail.class,theId);
            System.out.println("temp Instructor detail :"+instructorDetail);
            //print the associated instructor
            System.out.println("Associated Instructor :"+instructorDetail.getInstructor());
            //remove the associated object reference
            instructorDetail.getInstructor().setInstructorDetail(null);
            // deleting instructor detail
            session.delete(instructorDetail);
            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!...");
        }
        catch (Exception e){
            e.printStackTrace();

        }
        finally {
            session.close();
            factory.close();
        }
    }
}
