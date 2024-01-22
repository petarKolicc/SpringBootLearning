package com.example.drugiProjekat.drugiprojekat;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component("TennisCoach")
public class TennisCoach implements  Coach {

    @Override
    public String getDailyWorkout()
    {
        return "Practice fast bowling for 15minutes";
    }
}