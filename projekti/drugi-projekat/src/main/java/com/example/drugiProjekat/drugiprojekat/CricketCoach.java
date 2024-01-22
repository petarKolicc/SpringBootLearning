package com.example.drugiProjekat.drugiprojekat;

import org.springframework.stereotype.Component;

@Component("CricketCoach")
public class CricketCoach implements  Coach {

    @Override
    public String getDailyWorkout()
    {
        return "Practice fast bowling for 15minutes";
    }
}
