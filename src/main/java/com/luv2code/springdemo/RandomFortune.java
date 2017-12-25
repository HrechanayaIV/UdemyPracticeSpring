package com.luv2code.springdemo;

import java.util.Random;

public class RandomFortune implements FortuneService {
    public String getFortune() {
        Random random = new Random();
        return fortuneName[random.nextInt(fortuneName.length)];
    }

    String fortuneName[] = {"today is your happy day",
            "be careful today",
            "the best day for risk"};
}
