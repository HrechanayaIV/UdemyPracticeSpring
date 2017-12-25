package com.luv2code.springdemoannotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//default bean id = tennisCoach
@Component
//@Scope("prototype")
public class TennisCoach implements Coach {
    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

    public TennisCoach() {
        System.out.println("inside default constructor");
    }

    //define my init method
    @PostConstruct
    public void doMyStartupStuff() {
        System.out.println("inside doMyStartupStuff() method");
    }

    //define my destroy method
    @PreDestroy
    public void doMyCleanupStuff() {
        System.out.println("inside doMyCleanupStuff() method");
    }
    /*
    //autowired some method
    @Autowired
    public void doSomeCrazyStuff(FortuneService theFortuneService) {
        System.out.println("inside doSomeCrazyStuff() service");
        this.fortuneService = theFortuneService;
    }
    */
    /*
    //define a setter method
    @Autowired
    public void setFortuneService(FortuneService theFortuneService) {
        System.out.println("inside setFortuneService() service");
        this.fortuneService = theFortuneService;
    }
    */

    /*

    @Autowired
    public TennisCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }
    */

    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
