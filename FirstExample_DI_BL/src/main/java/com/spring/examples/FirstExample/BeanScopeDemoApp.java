package com.spring.examples.FirstExample;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {
    public static void main(String[] args) {
        //load the spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope_applicationContext.xml");

        //retrieve the beans
        ICoach coach = context.getBean("myCoach",ICoach.class);
        ICoach alphaCoach = context.getBean("myCoach",ICoach.class);
        // check if they are the same
        boolean result  = (coach == alphaCoach);
        System.out.println(result);
        System.out.println("Memory Location of coach :"+coach);
        System.out.println("Memory Location of alphaCoach :"+alphaCoach);
    }
}
