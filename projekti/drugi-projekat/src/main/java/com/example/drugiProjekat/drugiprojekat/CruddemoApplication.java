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
        // u js, radi pocevsi od java 8
        return runner -> {
//            createStudent(studentDAO);
              createMultipleStudents(studentDAO);
        };
    }

    private void createMultipleStudents(StudentDAO studentDAO) {

    }

    private void createStudent(StudentDAO studentDAO) {
        Student tempStudent = new Student("Pavle", "Delic", "pavle@gmail.com");
        studentDAO.save(tempStudent);
    }

}
