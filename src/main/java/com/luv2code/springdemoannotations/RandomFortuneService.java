package com.luv2code.springdemoannotations;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService {
    //create an array of strings
    private String[] data = {
            "Beware of the wolf in sheep`s clothing",
            "The journey is the reward",
            "Diligence is the mother of good luck"
    };

    //create a random number generator
    private Random myRandom = new Random();

    public String getFortune() {
    //pick a random string from the array
        int index = myRandom.nextInt(data.length);

        return data[index];
    }
}
