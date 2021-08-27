package com.luv2code.hibernate.demo;

import com.luv2code.hybernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory= new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Student.class)
                                .buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();
        try{
            //start a transaction
            session.beginTransaction();

            //query the students
            List students=session.createQuery("from Student s where s.lastName='Potter' and s.email like 'james%'").list();
            //display the students
            displayStudents(students);

            //Query the students whose lastName = "Potter" or firstName = "James"
            List student1=session.createQuery("from Student s where s.lastName='Potter' or firstName='Ron'").list();
            displayStudents(student1);

            student1=session.createQuery("from Student s where s.email like '%potter@%'").list();
            displayStudents(student1);
            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!...");
        }
        finally {
            factory.close();
        }
    }

    private static void displayStudents(List<Student> students) {
        for(Student s: students){
            System.out.println(s);
        }
    }
}
