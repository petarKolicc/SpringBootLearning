package com.example.drugiProjekat.drugiprojekat;

import org.springframework.stereotype.Component;

@Component("footballCoach")
public class FootballCoach implements  Coach {

    @Override
    public String getDailyWorkout()
    {
        return "Practice fast bowling for 15000minutes";
    }
}