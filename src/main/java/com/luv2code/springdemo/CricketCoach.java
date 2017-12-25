package com.luv2code.springdemo;

public class CricketCoach implements Coach {
    private String emailAddress;
    private String team;
    private FortuneService fortuneService;

    public CricketCoach() {
        System.out.println("CricketCoach : inside no-arg constructor");
    }

    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
        System.out.println("CricketCoach : inside setter method constructor");

    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        System.out.println("CricketCoach : inside setEmailAddress method ");
    }

    public void setTeam(String team) {
        this.team = team;
        System.out.println("CricketCoach : inside setTeam method ");
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getTeam() {
        return team;
    }

    public String getDailyWorkout() {
        return "practice fast bowling";
    }

    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
