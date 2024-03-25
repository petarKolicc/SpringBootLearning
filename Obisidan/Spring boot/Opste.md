

http://start.spring.io
skine i jarove ali i server

java -jar mojjar.jar
// pokretanje iz komande linije
// opet za pakovanje mora i najlakse mvnw package

git clone https://github.com/darbyluv2code/spring-boot-3-spring-6-hibernate-for-beginner
// kloniranje projekta



Maven ce sve sam da skida samo mu kazem sta mi treba


netstat -ano | find "8080"
// vidi koji proces koristi pa posle u task manageru nadji taj proces i ubi ga


www.spring.io
// dokumentacija springa


![[Pasted image 20240115153720.png]]



![[Pasted image 20240115162147.png]]




java - src code
resources - properties fajl
webapp - jsp, web config

test/java - junit fajlovi

target -> izgenerisano 


mvnw - maven wrapper i mvnw.cmd, ako nemam verziju na kompu skinuce je maven


mvnw clean compile test
// .sh  za linux, .cmd - windows

Ako imam odgovarajucu verziju mavena mogu se obrisati ova dva fajla

# application.properties


// prazan na pocetku dodaju se pojedinosti npr na kom portu da slusa i ovo je lokalna stvar kao .env u nodu
resources/application.properties
a.b=miki maus


```
// od sad ide localhost:8080/moja-ruta/endpoint1
server.servlet.context-path=/moja-ruta
```


```
// application.properties
a.b=miki maus

.java

import org.springframework.beans.factory.annotation.Value;

// citamo vrednost a.b sto je miki maus
@Value("${a.b}")
private String teamName;
// injekcija

```

# Logovanje
```
// application.properties

logging.level.org.springframework=DEBUG
logging.level.org.hibernate=TRACE
logging.level.com.lub2code=INFO

logging.file.name=my-crazy-stuff.log
logging.file.path=c:/myapps/demo

```


```
// menjanje porta
server.port=8080

// lokacija aplikacije
server.servlet.context-path=/my-silly-app

// 
server.servlet.session.timeout=15m
// tajmaout sesije


```


// iz static foldera ucitavanje statickih podataka HTML, CSS, JS, img, etc...


ne koristi 

src/main/webapp ako pravis jar, bice ignorisano ako se pravi jar


templates/
standardni templejti


test/.../
// za unit testove


Spring boot starters - skupina dependcija koja je grupisana i testirana zajedno od strane Spring Development tima
Nema potrebe staviti verziju jer nasledjuje iz starter parenta najnoviji ali da bude kompatibilno 

View -> Tool Windows -> Maven Projects -> Dependencies


Spring Boot Starter Parent - pocetak default koja java, koji maven...



# Spring Boot Dev Tools
// automatski azurira sve posto se izmeni src code i restart 

```
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-devtools</artifactId>
</dependency>

InteliJ -> Preferences -> Compiler -> Build project automatically
Intelij -> Preferences -> Advanced Settings -> Allow auto-make to start even if developer application is currently running
```

mora i u podesavanjima
File->Setting –> Build, Execution, Deployment –> Compiler–>Build project automatically is selected.

# Spring Boot Actuator
```
Spring Boot Actuator

// pom xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-actuator</artifactId>
</dependency>

// application.properties

// ako hocemo samo nesto da expose
managment.endpoints.web.exposure.include=health,info
// ako necemo
management.endpoints.web.exposure.exclude=info

// informacije za info
// en
managment.info.env.enabled=true

// ako hocemo sve da exposujemo
management.endpoints.web.exposure.include=*  
management.info.env.enabled=true  

// Info mora biti popunjen
info.app.name=My Super Cool App
info.app.description=A crazy and fun app, yoohoo!
info.app.version=1.0.0

managment.endpoints.web.base-path=/actuator
// ime patha za health, info prefix

```

```

http://localhost:8080/actuator/health
pokazuje health 
```
![[Pasted image 20240118154449.png]]


# Security

```
pom.xml
<dependency>
	<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-security</artifactId>
<dependency>

// resources/application.properties

// postavljanje user i pass
spring.security.user.name=petar
spring.security.password=petar


```



# Terminal

java -jar mycoolapp.jar  === ./mvnw spring-boot:run
// pokretanje aplikacije i dizanje na embedovan server(Tomcat)

```
./mvnw pakcage && ./mvnw spring-boot:run
```

# Bean

Spring container - default pravi singleton, sve dependency injection
ce biti deo istog bean

Postoje i drugi scopovi



## Zivotni vek Bean Scope

![[Pasted image 20240121133541.png]]


Default singleton - samo se jedan objekat pravi beana
mozemo da explicitno da menjamo

postoje

singleton
prototype
request 
session 
global-session

# @PostConstruct i @PreDestroy
// logika

@PostConstruct - posto se napravi bean

@PreDestroy - pre nego se unisti beam


```
@Component("TennisCoach")  
//ovde explicitno navodimo kog ce biti <mark>tipa</mark>
@Scope(ConfigurableBeanFacory.SCOPE_SINGLETON)
public class TennisCoach implements  Coach {  
  
    @Override  
    public String getDailyWorkout()  
    {  
        return "Practice fast bowling for 15minutes";  
    }

	 // anotacija posto se napravi
	 @PostConstruct
	 public void doMyStartupStuff()
	 {
		 // ovde deo koji ce se izvrsiti posto se napravi bean
	 }

	 // pri unistavanju, ne funkcionise za prototype anotaciju
	 @PreDestroy
	 public void doMyCleanupStuff() {
		 
	 }
}
```

## Prototype
- novi objekat za svaku injekciju
@Scope(ConfigurableBeanFacory.SCOPE_PROTOTYPE)



## 

```
  
@Component("TennisCoach")  
//ovde explicitno navodimo kog ce biti <mark>tipa</mark>
@Scope(ConfigurableBeanFacory.SCOPE_SINGLETON)
public class TennisCoach implements  Coach {  
  
    @Override  
    public String getDailyWorkout()  
    {  
        return "Practice fast bowling for 15minutes";  
    }  
}
```



# Inversion of Control Spring Bean


![[Pasted image 20240324091931.png]]

Spring container
	- Pravi i upravlja objektima (Inversion of Control)
	- Inject object's dependencies (Dependency Injection)
Objekat definise svoje dependencije bez da ih pravi. Ovaj posao je delegiran IoC kontejneru.

Cilj je da IoC kontejner pravi i odrzava sistem dependency klasa hoce li one biti deljene ili ne i sta treba

stavlja se anotacija

@Component - za dependency klasu



# Anotacije

## @Configuration

@SpringBootApplication - sastoji od sledecih anotacija
@EnableAutoConfiguration - podrska za auto konfiguraciju
@ComponentScan - Dozvoljava component scanning trenutnog paketa i rekurzivno 
skenira sub pakete
@Configuration - registruje dodatne benova sa @Bean ili da importuje druge konfiguracione klase

Iza scene pravi kontext aplikacije registruje binove i pocinje embedovan server


# Skeniranje  Scann

Po defaultu pocinje skeniranje od paketa kom pripada Spring Boot aplikacija potom skenira pod pakete rekurzivno

Spring boot nece gledati pakete van core paketa(i njegovih podpaketa)
Moze mu se ekplicitno reci sta da skenira


```
@SpringBootApplication(
	scanBasePackages = ("skeniraj.ovaj.paket.iako.je.van.defaultnog", "skeniraj.ovaj.paket.iako.je.van.defaultnog2")
)
public class SpringcoredemoApplication...
```



# Lazy Initialization


Prednosti, pravi objekte samo kad su potrebni i brze vreme starta
Mane - ako imas @RestController, ne prave se dok ih neko ne zatrazi inace se odmah prave

Na nivou komponente
```
@Lazy  
@Component("TennisCoach")  
public class TennisCoach implements  Coach {  
  
    @Override  
    public String getDailyWorkout()  
    {  
        return "Practice fast bowling for 15minutes";  
    }  
}

```

na globalnom nivou, svi binovi su lazy ukljucujuci i kontrolere
dok ne trebaju se ne ucitavaju
```
//application.properties

spring.main.lazy-initialization=true
```



# Third party integracija bean


Imas third party code koji ne mozes da modifikujes
Proglasis ga za @Bean(Metod klase) - postaje SpringBean i koristimo ga u drugim delovima aplikacije

Cilj je injectovanje unutar nase spring aplikacije

U slucaju da nema @Component



```
// config.SportConfig.java

package com.example.drugiProjekat.drugiprojekat.config;  
  
import com.example.drugiProjekat.drugiprojekat.Coach;  
import com.example.drugiProjekat.drugiprojekat.SwimCoach;  
import org.springframework.context.annotation.Bean;  
import org.springframework.context.annotation.Configuration;  
@Configuration  
public class SportConfig {  
    @Bean  
    // bean id= ime metode swimCoach - isto kao, ako se daje id onda ne gleda ime metode vec ovaj id kada bude radio injectovanje @Component("swimCoach")  
    // ako hocemo drugo stavili bismo @Bean("imeBeana") - sad je ovo
    public Coach swimCoach() {  
        return new SwimCoach();  
    }  
}








// SwimCoach.java

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



// DemoController.java


@RestController  
public class DemoController  
{  
    private Coach myCoach;  
  
    // govori springu da injectuje dependency  
    // inace je opciono kada imamo samo 1 konstruktor    @Autowired  
	// id je ovde ime metode
    public DemoController(@Qualifier("swimCoach") Coach theCoach)  
    {  
        myCoach = theCoach;  
    }


```



# male cake  
```
// application.properties


// gasenje spring boot bannera pri dizanju aplikacije
spring.main.banner-mode=off

// spustanje logger levela na minimum warning  
logging.level.root=warn %%


```