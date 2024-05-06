
```

	<parent>
		<groupId>org.springframework.boot</groupId> <!-- ime kompanije, grupe, u obrnutom redosledu -->
		<artifactId>spring-boot-starter-parent</artifactId> <!-- ime projekta -->
		<version>3.2.1</version> <!-- verzija projekta -->
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.luv2
```


# Spring
```
f
// spring
<groupId>com.luv2code.springboot.demo</groupId>  
<artifactId>mycoolapi</artifactId>  
<version>0.0.1-SNAPSHOT</version>

```


Da bi dodali novi jar treba nam "groupId" i "artifactId", "verzija je opciona ali best practice"

GAV - Group ID, Artifact ID, Version

Kako naci 

idi na sajt spring.io, hibernate.org

// svi paketi se ovde nalaze
http://search.maven.org 


https://mvnrepository.com/repos/central
// ovde su svi paketi


// kolekcija dependecija
```
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
```


###package
# Start 
// pokretanje pakovanje i runovanje
./mvnw package && ./mvnw spring-boot:run
// ili samo mvn



mvn clean install -U
// mvn clean brise sve
// mvn install sve ponovo instalira i pakuje
// mvn install -U - ide na maven central repository i proverava ponovo jel sve tu



Preko mavena

// za pokretanje
// moze i samo "mvn" ako je vec instaliran
mvnw clean compile test