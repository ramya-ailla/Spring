package com.annotations.FirstPackage;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements ICoach{
    IFortuneService fortuneService ;
    @Value("${foo.email}")
    private  String email;

    @Value("${foo.team}")
    private String team;

    public String getEmail() {
        return email;
    }

    public String getTeam() {
        return team;
    }

    public SwimCoach(IFortuneService fortuneService){
        this.fortuneService=fortuneService;
    }
    @Override
    public String getDailyWorkout() {
        return "Swim 1000 meters as a warm-up";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
