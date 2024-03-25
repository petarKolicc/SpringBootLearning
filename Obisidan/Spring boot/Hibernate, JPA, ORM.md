![[Pasted image 20240121154550.png]]

ORM - Hibernate 


Mapiranje


![[Pasted image 20240121155229.png]]

JPA - Jakarta Persistence API, ovo je samo interfejs a neko od mogucih implementacija su Hibernate, EclipseLink, lako moze da se menja implementacija preko konfiguracije ovde

JPA - je flexibilniji jer imas samo JPA sloj nad bazom jer kodiras nas API pozivom

Hibernate je defaultna implementacija JPA

Na osnovu konfiguracije Spring Boot automatski pravi binove:
DataSource, EntityManager, ...


Dependency

MySQLDriver
Spring

```
// pom.xml

<dependency>  
   <groupId>com.mysql</groupId>  
   <artifactId>mysql-connector-j</artifactId>  
</dependency>  
<dependency>  
   <groupId>org.springframework.boot</groupId>  
   <artifactId>spring-boot-starter-data-jpa</artifactId>  
</dependency>
```

```
// glavni deo aplikacije gde postoji main klasa i odakle
// se sve pokrece

    @Bean  
    // kod koji se izvrsava posto su svi Spring Beanovi ucitani  
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {  
  
        // ovo je lamba funkcija sto je ekvivalent arrow funkcija  
        // u js, radi pocevsi od java 8        return runner -> {  
//            createStudent(studentDAO);  
              createMultipleStudents(studentDAO);  
        };  
    }
```

# Entity
 
Entity class mora biti anotirana sa @Entity

Mora imati public ili protected bez argumenata konstruktor, sme da ima druge konstruktore
Moramo napraviti 


# Mapiranje klase ka tabeli u bazi


![[Pasted image 20240121183422.png]]

# Mapiranje polja ka kolonama u bazi




![[Pasted image 20240121183015.png]]

@Column - je opciono ali visoko preporucljiva anotacija, inace je ime polja

@Table - je opciono ali visoko preporucljiva anotacija inace je ime klase


# Primary Key Azuriranje


![[Pasted image 20240121183644.png]]
Razlicite strategije

![[Pasted image 20240121183729.png]]

GenerationType.IDENTITY - auto inkrement
GenerationType.AUTO
GenerationType.SEQUENCE
GenerationType.TABLE


// konekcija ka bazi
```
// application.properties


spring.datasource.url=jdbc:mysql://localhost:3306/student_tracker  
spring.datasource.username=springstudent  
spring.datasource.password=springstudent
```




// mapiranje tabele sa kolonama za klasu sa poljima
```
// entity/Student.java

package com.example.drugiProjekat.drugiprojekat.entity;

import jakarta.persistence.*;

@Entity
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    public Student() {

    }

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

```


# DAO


![[Pasted image 20240121200348.png]]
// primer za tabelu studenta


JPA Entity Manager - treba mu data source (connect string), oba se prave automatski od strane
Spring Boot-a na osnovu application.properties fajla i mi onda mozemo da injectujemo JPA Entity Manager u Student DAO


```
//StudentDao.java

public interface StudentDAO {
	
	void save(Student theStudent);
}



// StudentDAOImpl.java


@Repository
public class StudentDAOImpl implements StudentDAO {
	private EntityManager entityManager;

	// ovde radimo injection
	@Autowired
	public StudentDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntitymanager;
	}

	// implementacija save metode koja cuva nove polje u tabeli
	@Override
	@Transactional
	public void save(Student theStudent) {
		entityManager.persist(theStudent);
	}
}


```

@Transactional - automatski zapocinje i zavrsava transakciju unutar JPA koda. Nema potrebe da to cinis explicitno


@Repository - pod @Comoponenta
// prevodi JDBC exceptione

![[Pasted image 20240121201152.png]]




Pun primer
```
//dao/StudentDAO.java

package com.example.drugiProjekat.drugiprojekat.dao;  
  
import com.example.drugiProjekat.drugiprojekat.entity.Student;  
  
public interface StudentDAO {  
  
    void save(Student theStudent);  

	Student findById(Integer id);
}



// dao/StudentDAOImpl.java


package com.example.drugiProjekat.drugiprojekat.dao;  
  
import com.example.drugiProjekat.drugiprojekat.entity.Student;  
import jakarta.persistence.EntityManager;  
import jakarta.transaction.Transactional;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Repository;  
  
// anotacija za repozitorije  
// podrzava skeniranje komponenti  
// podrska za JDBC exceptione ugradjuje se  
@Repository  
public class StudentDAOImpl implements StudentDAO {  
    private EntityManager entityManager;  
  
    // ovde radimo injection  
    @Autowired  
    public StudentDAOImpl(EntityManager theEntityManager) {  
        entityManager = theEntityManager;  
    }  
  
    // implementacija save metode koja cuva nove polje u tabeli  
    @Override  
    @Transactional (// ako nema modifikacije u bazi ovo nije potrebno)   
    public void save(Student theStudent) {  
        //cuvanje novog studenta u bazi  
        entityManager.persist(theStudent);  
    }

	// nema upita pa nema ni transactional
	@Override
	public Student findById(Integer id)
	{
		Student myStudent = entityManager.find(Student.class, id);
		return myStudent;
	}

}



// entity.java


package com.example.drugiProjekat.drugiprojekat.entity;  
  
import jakarta.persistence.*;  
  
@Entity  
@Table(name="student")  
public class Student {  
    @Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    @Column(name="id")  
    private int id;  
  
    @Column(name="first_name")  
    private String firstName;  
  
    @Column(name="last_name")  
    private String lastName;  
  
    @Column(name="email")  
    private String email;  
  
    public Student() {  
  
    }  
  
    public Student(String firstName, String lastName, String email) {  
        this.firstName = firstName;  
        this.lastName = lastName;  
        this.email = email;  
    }  
  
    public int getId() {  
        return id;  
    }  
  
    public void setId(int id) {  
        this.id = id;  
    }  
  
    public String getFirstName() {  
        return firstName;  
    }  
  
    public void setFirstName(String firstName) {  
        this.firstName = firstName;  
    }  
  
    public String getLastName() {  
        return lastName;  
    }  
  
    public void setLastName(String lastName) {  
        this.lastName = lastName;  
    }  
  
    public String getEmail() {  
        return email;  
    }  
  
    public void setEmail(String email) {  
        this.email = email;  
    }  
  
    @Override  
    public String toString() {  
        return "Student{" +  
                "id=" + id +  
                ", firstName='" + firstName + '\'' +  
                ", lastName='" + lastName + '\'' +  
                ", email='" + email + '\'' +  
                '}';  
    }  
}


// CrudemoApplication.java

package com.example.drugiProjekat.drugiprojekat;  
  
import com.example.drugiProjekat.drugiprojekat.dao.StudentDAO;  
import com.example.drugiProjekat.drugiprojekat.entity.Student;  
import org.springframework.boot.CommandLineRunner;  
import org.springframework.boot.SpringApplication;  
import org.springframework.boot.autoconfigure.SpringBootApplication;  
import org.springframework.context.annotation.Bean;  
  
@SpringBootApplication  
public class CruddemoApplication {  
  
    public static void main(String[] args) {  
        SpringApplication.run(CruddemoApplication.class, args);  
    }  
  
    @Bean  
    // kod koji se izvrsava posto su svi Spring Beanovi ucitani  
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {  
  
        // ovo je lamba funkcija sto je ekvivalent arrow funkcija  
        // u js, radi pocevsi od java 8        return runner -> {  
            createStudent(studentDAO);  
        };  
    }  
  
    private void createStudent(StudentDAO studentDAO) {  
        Student tempStudent = new Student("Pavle", "Delic", "pavle@gmail.com");  
        studentDAO.save(tempStudent);  
    }  
  
}


```



Student myStudent = entityManager.find(Student.class, 1);
// trazi iz tabele student id "1"




# JPA Query Language (JPQL)


Query langugae for retrieving objects


