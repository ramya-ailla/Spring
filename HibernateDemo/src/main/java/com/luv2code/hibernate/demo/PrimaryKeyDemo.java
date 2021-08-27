package com.luv2code.hibernate.demo;

import com.luv2code.hybernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {
        SessionFactory factory= new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();
        try{
            //Create 3 Student objects
            System.out.println("Creating 3 new Student Object");
            Student student1 = new Student("Ginny","Weisley","ginnyweisley@gmail.com");
            Student student2 = new Student("Draco","Malfoy","dracomalfoy@gmail.com");
            Student student3 = new Student("James","Potter","jamespotter@gmail.com");

            //start a transaction
            session.beginTransaction();

            //save the student object
            System.out.println("Saving the students...");
            session.save(student1);
            session.save(student2);
            session.save(student3);

            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!...");
        }
        finally {
            factory.close();
        }
    }
}
