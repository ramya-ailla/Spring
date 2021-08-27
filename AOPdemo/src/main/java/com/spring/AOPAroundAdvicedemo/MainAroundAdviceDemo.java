package com.spring.AOPAroundAdvicedemo;

import com.spring.AOPAroundAdvicedemo.Service.TrafficFortuneService;
import com.spring.AOPAroundAdvicedemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.logging.Logger;

public class MainAroundAdviceDemo {
    private  static Logger myLogger =
            Logger.getLogger(MainAroundAdviceDemo.class.getName());

    public static void main(String[] args) {

        //read the spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        //get the bean from spring Container
        TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService",TrafficFortuneService.class);

       myLogger.info("\n Main Program: AroundAdviceDemo");

        myLogger.info("Calling getFortune");

        boolean tripwire = true;
        String data = null;
        try {
            data = trafficFortuneService.getFortune(tripwire);
        }catch (Exception e){
            myLogger.info("Exception Handled in Main Program");
        }

        myLogger.info("\n My Fortune is: "+data);

        myLogger.info("finished");

        //close the context
        context.close();
    }
}
