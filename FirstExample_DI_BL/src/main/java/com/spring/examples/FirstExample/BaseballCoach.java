package com.spring.examples.FirstExample;

public class BaseballCoach implements ICoach{
    private IFortuneService fortuneService;
    public BaseballCoach(IFortuneService fortuneService){
        this.fortuneService=fortuneService;
    }
    @Override
    public String getDailyWorkout(){
        return "Practise pitching for 1 hr";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }


}
