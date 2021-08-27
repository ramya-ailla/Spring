package com.luv2code.hibernate.demo;

import com.luv2code.hybernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();
        try {
            int studentId = 1000;

            //start a transaction
            session.beginTransaction();
            System.out.println("Getting the Student whose id is " + studentId);
            Student s = session.get(Student.class, studentId);
            System.out.println(s);
            System.out.println("Deleting the Student");
            session.delete(s);
            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!...");

            ///new Deletions
            Session session1 = factory.getCurrentSession();
            session1.beginTransaction();
            //deleting Student whose id= 3
            System.out.println("deleting Student whose id= 3");
            session1.createQuery("delete from Student s where s.id=3")
                    .executeUpdate();
            session1.getTransaction().commit();
            System.out.println("Done!...");

        } finally {
            factory.close();
        }
    }
}
