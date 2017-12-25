package com.luv2code.springdemo;

public class BaseballCoach implements Coach {

    private FortuneService fortuneService;

    public BaseballCoach(FortuneService theFortuneService) {
        this.fortuneService = theFortuneService;
    }

    public String getDailyWorkout(){
        return "spend 30 minutes to batting practice";
    }

    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
