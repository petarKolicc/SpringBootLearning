

http://start.spring.io
skine i jarove ali i server

java -jar mojjar.jar
// pokretanje iz komande linije

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

### application.properties


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

#### Logovanje
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



### Spring Boot Dev Tools
// automatski azurira sve posto se izmeni src code i restart 

```
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-devtools</artifactId>
</dependency>

InteliJ -> Preferences -> Compiler -> Build project automatically
Intelij -> Preferences -> Advanced Settings -> Allow auto-make to start even if developer application is currently running
```


### Spring Boot Actuator
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


#### Security

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



### Terminal

java -jar mycoolapp.jar
// pokretanje aplikacije i dizanje na embedovan server(Tomcat)





#
Spring container
	- Pravi i upravlja objektima (Inversion of Control)
	- Inject object's dependencies (Dependency Injection)