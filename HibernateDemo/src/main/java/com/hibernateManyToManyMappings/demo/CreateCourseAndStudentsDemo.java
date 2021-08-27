package com.hibernateManyToManyMappings.demo;



import com.hibernateManyToManyMappings.entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndStudentsDemo {
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

            //create a course
            Course tempCourse = new Course("Pacman - How to Score One Million Points");

            //save the course....leverage the cascade.all
            System.out.println("Saving the Course...");
            session.save(tempCourse);
            System.out.println("Saved the Course: "+tempCourse);

            //create the students
                Student tempStudent1 = new Student("John","Doe","john@luv2code.com");
                Student tempStudent2 = new Student("Mary","Public","mary@luv2code.com");

            //add students to the course
            tempCourse.addStudent(tempStudent1);
            tempCourse.addStudent(tempStudent2);

            //save the students
            System.out.println("\n Saving Students...");
            session.save(tempStudent1);
            session.save(tempStudent2);
            System.out.println("Saved Students..."+tempStudent1+"\n"+tempStudent2+"\n");

            //commit transaction
            session.getTransaction().commit();
            System.out.println("Done!...");
        }
        finally {
            factory.close();
        }
    }
}
