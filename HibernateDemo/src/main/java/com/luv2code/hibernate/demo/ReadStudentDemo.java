package com.luv2code.hibernate.demo;

import com.luv2code.hybernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory= new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Student.class)
                                .buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();
        try{
            //Create the Student object
            System.out.println("Creating a new Student Object");
            Student student = new Student("Albus","Dumbledore","albus@gmail.com");

            //start a transaction
            session.beginTransaction();

            //save the student object
            System.out.println("Saving the student...");
            session.save(student);

            //commit the transaction
            session.getTransaction().commit();

            //Read from the Database
            //print the id(primary key)
            System.out.println("The ID Associated with the new Student is"+student.getId());

            //create a new Session and begin the transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            //get the student record associated with the ID(primary_key)
            System.out.println("Student details are: ");
            System.out.println(session.get(Student.class,student.getId()));

            //commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!...");
        }
        finally {
            factory.close();
        }
    }
}
