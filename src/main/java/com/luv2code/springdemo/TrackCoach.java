package com.luv2code.springdemo;

public class TrackCoach implements Coach {
    private FortuneService fortuneService;

    public TrackCoach() {
    }

    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    //add an init-method
    public void doMyStartupStuff(){
        System.out.println("TrackCoach: inside method doMyStartupStuff");
    }
    //add a destroy-method
    public void doMyCleanupStuff(){
        System.out.println("TrackCoach: inside method doMyCleanupStuff");
    }

    public String getDailyWorkout() {
        return "Run a had 5k";
    }

    public String getDailyFortune() {
        return "Just do it: " + fortuneService.getFortune();
    }
}
