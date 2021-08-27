package com.annotations.FirstPackage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("tennisCoach")
//@Scope("prototype")
public class TennisCoach implements ICoach{
    @Autowired
    @Qualifier("randomFortuneService")
    private IFortuneService fortuneService;
    /*@Autowired
    TennisCoach(IFortuneService fortuneService){
        this.fortuneService = fortuneService;
    }*/
    public TennisCoach(){
        System.out.println(">> Tennis Coach: inside default constructor ");
    }
    /*
    @Autowired
    public void setFortuneService(IFortuneService fortuneService){
        this.fortuneService=fortuneService;
    }*/
    /*
    @Autowired
    public void doSomeCrazyStuff(IFortuneService fs){
        System.out.println(">> Tennis Coach: inside doSomeCrazyStuff ");
        fortuneService = fs;
    }*/
    @PostConstruct
    public void doMyDayStart(){
        System.out.println("Tennis Coach:inside doMyDailyStart");
    }
    @PreDestroy
    public void doMyDayEnd(){
        System.out.println("Tennis Coach: inside doMyDayEnd");
    }
    @Override
    public String getDailyWorkout() {
        return "Practise your Backhand Volley";
    }
    public String getDailyFortune(){
        return  fortuneService.getFortune();
    }
}
