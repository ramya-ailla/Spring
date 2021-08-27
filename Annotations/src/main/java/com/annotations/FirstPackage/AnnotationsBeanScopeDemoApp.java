package com.annotations.FirstPackage;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationsBeanScopeDemoApp {
    public static void main(String[] args) {
        //read the spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //retrieving the bean from Spring container
        ICoach coach = context.getBean("tennisCoach",ICoach.class);

        ICoach alphaCoach = context.getBean("tennisCoach",ICoach.class);

        //check if they are same
        boolean result = (coach==alphaCoach);
        System.out.println(result);
        System.out.println(coach);
        System.out.println(alphaCoach);

        context.close();
    }
}
