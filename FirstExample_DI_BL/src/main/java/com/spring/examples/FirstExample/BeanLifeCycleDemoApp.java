package com.spring.examples.FirstExample;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {
    public static void main(String[] args) {
        //load the spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifeCycle_applicationContext.xml");

        //retrieve the beans
        ICoach coach = context.getBean("myCoach",ICoach.class);
        System.out.println(coach.getDailyWorkout());
        //close the context
        context.close();
    }
}
