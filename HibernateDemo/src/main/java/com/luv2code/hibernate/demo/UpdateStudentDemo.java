package com.luv2code.hibernate.demo;

import com.luv2code.hybernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory= new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Student.class)
                                .buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();
        try{
           int studentId= 1000;

            //start a transaction
            session.beginTransaction();
            System.out.println("Getting the Student whose id is "+studentId);
            Student s= session.get(Student.class,studentId);
            System.out.println(s);
            System.out.println("Updating the Student");
            s.setLastName("Warner");
            System.out.println(s);
            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!...");

            ///new Updates
            Session session1 = factory.getCurrentSession();
            session1.beginTransaction();
            //Updating ginny's email address as foo@gmail.com
            System.out.println("Updating ginny's email address as foo@gmail.com");
            session1.createQuery("update Student s set s.email= 'fooo@gmail.com' where s.firstName='Ginny'")
                    .executeUpdate();
            session1.getTransaction().commit();
            System.out.println("Done!...");

        }
        finally {
            factory.close();
        }
    }
}
