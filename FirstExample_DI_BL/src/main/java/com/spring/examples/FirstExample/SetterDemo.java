package com.spring.examples.FirstExample;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemo {
    public static void main(String[] args) {
        //load the spring configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //retrieve the bean from spring container
        CricketCoach coach = context.getBean("cricketCoach",CricketCoach.class);
        //call methods on the bean
        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());
        coach.displayCoachInfo();
        //close the context
        context.close();
    }
}
