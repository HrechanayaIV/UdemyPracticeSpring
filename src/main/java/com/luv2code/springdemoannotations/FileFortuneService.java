package com.luv2code.springdemoannotations;


import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@Component
public class FileFortuneService implements FortuneService {

    private String fileName = "C:/SpringAndHibernateUdamy/Fortune.txt";
    private List<String> fortunes;
    private Random myRandom = new Random();

    public FileFortuneService() {
        System.out.println(">>>inside the default constructor");
    }

    @PostConstruct
    private void loadTheFortunesFile() {
        System.out.println(">>>inside loadTheFortunesFile() method");

        File theFile = new File(fileName);

        System.out.println("Reading fortunes from file: " + theFile);
        System.out.println("File exists: " + theFile.exists());

        // initialize array list
        fortunes = new ArrayList<String>();

        // read fortunes from file
        try (BufferedReader br = new BufferedReader(
                new FileReader(theFile))) {

            String tempLine;

            while ((tempLine = br.readLine()) != null) {
                fortunes.add(tempLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getFortune() {
        int index = myRandom.nextInt(fortunes.size());

        String tempFortune = fortunes.get(index);

        return tempFortune;
    }
}
