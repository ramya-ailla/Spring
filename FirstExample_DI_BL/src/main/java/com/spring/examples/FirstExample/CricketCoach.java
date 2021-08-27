package com.spring.examples.FirstExample;

public class CricketCoach implements ICoach{
    private IFortuneService fortuneService;
    private String coachEmail;
    private String team;

    public CricketCoach(){
        System.out.println("CricketCoach: inside no-arg constructor");
    }

    public void setCoachEmail(String coachEmail) {
        System.out.println("Inside CricketCoach class CoachEmail Setter method");
        this.coachEmail = coachEmail;
    }

    public void setTeam(String team) {
        System.out.println("Inside CricketCoach class team Setter method");
        this.team = team;
    }
    public void setFortuneService(IFortuneService fortuneService) {
        System.out.println("Inside CricketCoach class FortuneService Setter method");
        this.fortuneService = fortuneService;
    }


    @Override
    public String getDailyWorkout() {
        return "Practise Wicket Keeping for 15 mins a day";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
    public void displayCoachInfo(){
        System.out.println("Email - "+this.coachEmail);
        System.out.println("Team - "+this.team);
    }
}
