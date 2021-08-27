package com.hibernateEagerVSLazy.demo;

import com.hibernateEagerVSLazy.entities.Course;
import com.hibernateEagerVSLazy.entities.Instructor;
import com.hibernateEagerVSLazy.entities.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoinDemo {
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



            //Hibernate query with HQL

            int theId = 1;

            Query<Instructor> query = session.createQuery("Select i from Instructor i "+
                                                            "Join FETCH i.courses "+
                                                            "where i.id=:theInstructorId",Instructor.class);
            //set parameter on query
            query.setParameter("theInstructorId",theId);

            Instructor instructor = query.getSingleResult();


            //commit transaction
            session.getTransaction().commit();
            session.close();
            System.out.println("\n\n\nThe session is now closed...\n\n");

            System.out.println("Courses: "+instructor.getCourses());
            System.out.println("Done!...");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            factory.close();
        }
    }
}
