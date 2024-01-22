package com.example.drugiProjekat.drugiprojekat.config;

import com.example.drugiProjekat.drugiprojekat.Coach;
import com.example.drugiProjekat.drugiprojekat.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class SportConfig {
    @Bean
    // bean id= ime metode swimCoach - isto kao @Component("swimCoach")
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
