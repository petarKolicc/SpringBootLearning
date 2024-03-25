
Factory method
![[Pasted image 20240119130257.png]]


Injekcija dependencija za dati objekat


Dve vrste 

- Constructor Injection - kada imamo neophodne dependencije
- Setter Injection - opcioni dependency (aplikacija ima podrazumevane ako nisu dostavljene)


# AutoWiring


AutoWiring - spring trazi ime klase koju matchuje (klasu ili interfejs) i injektira automatski

Constructor Injection - required dependency
Setter Injection - opcioni dependency

Spring skenira i trazi @Components, Spring Bean(Component) je obicna javina klasa o kojoj Spring vodi racuna

Ako neki implementira to sto treba on ih sam injektira

```
// ne treba da navodimo nigde klasu coach


@Autowired  
public DemoController(@Qualifier("swimCoach") Coach theCoach)  
{  
    myCoach = theCoach;  
}

# Constructor Injection

  @Autowired  
    public DemoController(@Qualifier("swimCoach") Coach theCoach)  
    {  
        myCoach = theCoach;  
    }  
  
  
    @GetMapping("/dailyworkout")  
    public String getDailyWorkout() {  
        return myCoach.getDailyWorkout();  
    }

```

// markira kao spring bean
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
```

@Autowired
// ovo preko set metode ali ne mora setCoach moze bilo koja metoda spring ce znati da injektira
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


koristice primary ako @Qualifier nije dat, primary je podrazumevani ako postoje vise implementacija istog interfejsa
i on da spring zna sta ciniti
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