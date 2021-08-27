package com.hibernateOneToManyBiMappings.demo;

import com.hibernateOneToManyBiMappings.entities.Course;
import com.hibernateOneToManyBiMappings.entities.Instructor;
import com.hibernateOneToManyBiMappings.entities.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesDemo {
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

            //create some courses
            Course tempCourse1= new Course("Air Guitar - The Ultimate Guide");
            Course tempCourse2 = new Course("The Pinball MasterClass");

            //add courses to instructor
            instructor.add(tempCourse1);
            instructor.add(tempCourse2);

            //save the courses
            session.save(tempCourse1);
            session.save(tempCourse2);
            //commit transaction
            session.getTransaction().commit();
            System.out.println("Done!...");
        }
        finally {
            factory.close();
        }
    }
}
