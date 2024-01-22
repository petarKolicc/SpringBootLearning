package com.example.drugiProjekat.drugiprojekat;

import org.springframework.stereotype.Component;

// namerno nema @Component
public class SwimCoach implements  Coach {

    @Override
    public String getDailyWorkout()
    {
        return "Practice fast bowling for 15minutes";
    }
}
