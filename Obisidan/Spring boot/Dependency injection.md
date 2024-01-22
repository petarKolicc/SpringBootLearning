
Factory method
![[Pasted image 20240119130257.png]]


Injekcija dependencija za dati objekat


Dve vrste 

- Constructor Injection - kada imamo neophodne dependencije
- Setter Injection - opcioni dependency (aplikacija ima podrazumevane ako nisu dostavljene)


# AutoWiring




Constructor Injection - required dependency
Setter Injection - opcioni dependency


# Constructor Injection

```
@Component("FootballCoach")  
public class FootballCoach implements  Coach {  
  
    @Override  
    public String getDailyWorkout()  
    {  
        return "Practice fast bowling for 15000minutes";  
    }  
}

@Autowired  
public void setCoach(@Qualifier("FootballCoach") Coach theCoach)  
{  
    myCoach = theCoach;  
}

```

# Setter injection

```
@Component("FootballCoach")  
public class FootballCoach implements  Coach {  
  
    @Override  
    public String getDailyWorkout()  
    {  
        return "Practice fast bowling for 15000minutes";  
    }  
}

@Autowired
public void setCoach(Coach theCoach)
{
	myCoach = theCoach;
}

@GetMapping("/dailyworkout")
public String getDailyWorkout(){
	return myCoach.getDailyWorkout();
}
```


# Primary


koristice primary ako @Qualifier nije dat
```
@Primary  
@Component("TennisCoach")  
public class TennisCoach implements  Coach {  
  
    @Override  
    public String getDailyWorkout()  
    {  
        return "Practice fast bowling for 15minutes";  
    }  
}


@Autowired  
public void setCoach(Coach theCoach)  
{  
    myCoach = theCoach;  
}

```