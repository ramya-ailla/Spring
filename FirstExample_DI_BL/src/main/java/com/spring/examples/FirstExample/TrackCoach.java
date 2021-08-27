package com.spring.examples.FirstExample;

public class TrackCoach implements ICoach{
    private IFortuneService fortuneService;
    public TrackCoach(IFortuneService fortuneService){
        this.fortuneService = fortuneService;
        System.out.println("Inside the constructor");
    }
    @Override
    public String getDailyWorkout() {
        return "Practise running for 30 mins. ";
    }

    @Override
    public String getDailyFortune() {
        return "Just do it: "+fortuneService.getFortune();
    }
    //add init method
    public void doMyStartUpStuff(){
        System.out.println("Track Coach : inside doMyStartupStuff method");
    }
    public void doMyCleanUpStuff(){
        System.out.println("Track Coach : inside doMyCleanupStuff method");
    }
}
