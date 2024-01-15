
```

	<parent>
		<groupId>org.springframework.boot</groupId> <!-- ime kompanije, grupe, u obrnutom redosledu -->
		<artifactId>spring-boot-starter-parent</artifactId> <!-- ime projekta -->
		<version>3.2.1</version> <!-- verzija projekta -->
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.luv2
```


### Spring
```

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


// kolekcija dependecija
```
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
```


###package

// pokretanje pakovanje i runovanje
./mvnw package
./mvnw spring-boot:run


