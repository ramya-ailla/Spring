package com.hibernateOneToOneUniMappings.demo;

import com.hibernateOneToOneUniMappings.entities.Instructor;
import com.hibernateOneToOneUniMappings.entities.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {
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

            //get the instructor by Id
            int theId =1;
            Instructor tempInstructor = session.get(Instructor.class,theId);
            System.out.println("found Instructor : "+tempInstructor);

            //delete the instructors
            if(tempInstructor!=null){
                System.out.println("Deleting "+tempInstructor+"....");
                //will also delete the instructor details object
                session.delete(tempInstructor);
            }
            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!...");
        }
        finally {
            factory.close();
        }
    }
}
