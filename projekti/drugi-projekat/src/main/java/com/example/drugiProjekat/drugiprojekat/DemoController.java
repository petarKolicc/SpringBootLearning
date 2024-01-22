package com.example.drugiProjekat.drugiprojekat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController
{
    private Coach myCoach;

    // govori springu da injectuje dependency
    // inace je opciono kada imamo samo 1 konstruktor
    @Autowired
    public DemoController(@Qualifier("swimCoach") Coach theCoach)
    {
        myCoach = theCoach;
    }


//    @Autowired
//    public void setCoach(@Qualifier("FootballCoach") Coach theCoach)
//    {
//        myCoach = theCoach;
//    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
