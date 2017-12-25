package com.luv2code.springdemoannotations;

import org.springframework.beans.factory.annotation.Value;

public class SwimmingCoach implements Coach {

    private FortuneService fortuneService;
    @Value("${foo.email}")
    private String email;

    @Value("${foo.team}")
    private String team;

    public SwimmingCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public String getDailyWorkout() {

        return "Practice your swimming";
    }

    public String getDailyFortune() {

        return fortuneService.getFortune();
    }

    public String getEmail() {
        return email;
    }

    public String getTeam() {
        return team;
    }
}
