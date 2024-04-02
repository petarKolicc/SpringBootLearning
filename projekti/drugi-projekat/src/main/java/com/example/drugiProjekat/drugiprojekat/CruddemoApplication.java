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
//              createMultipleStudents(s/tudentDAO);

            readStudent(studentDAO);
        };
    }

    private void readStudent(StudentDAO studentDAO)
    {
        Student myStudent = studentDAO.findById(2);

        System.out.println("Found student" + myStudent);
    }

    private void createMultipleStudents(StudentDAO studentDAO) {

        Student tempStudent1 = new Student("Mitar", "Miric", "mitar.miric@gmail.com");
        Student tempStudent2 = new Student("Rade", "Martionvic", "rade.martinovic@gmail.com");
        Student tempStudent3 = new Student("Petar", "Kolic", "petar.kolic@gmail.com");

        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);

    }

    private void createStudent(StudentDAO studentDAO) {
        Student tempStudent = new Student("Pavle", "Delic", "pavle@gmail.com");
        studentDAO.save(tempStudent);
    }

}
