package com.example.drugiProjekat.drugiprojekat;

import com.example.drugiProjekat.drugiprojekat.dao.StudentDAO;
import com.example.drugiProjekat.drugiprojekat.dao.StudentDAOImpl;
import com.example.drugiProjekat.drugiprojekat.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    public void updateStudent(StudentDAO studentDAO) {

        int studentId = 2;


        Student myStudent = studentDAO.findById(studentId);

        myStudent.setFirstName("Scooby");


        studentDAO.update(myStudent);
    }

    private void deleteStudent(StudentDAO studentDAO)
    {
        int studentId = 3;
        studentDAO.delete(studentId);
    }

    public int deleteAllStudents(StudentDAO studentDAO)
    {
        int deletedStudents = studentDAO.deleteAll();

        return  deletedStudents;
    }

    @Bean
    // kod koji se izvrsava posto su svi Spring Beanovi ucitani
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

        // ovo je lamba funkcija sto je ekvivalent arrow funkcija
        // u js, radi pocevsi od java 8
        return runner -> {
//            createStudent(studentDAO);
              createMultipleStudents(studentDAO);

//            readStudent(studentDAO);
//            queryForStudents(studentDAO);
//            updateStudent(studentDAO);
//            deleteStudent(studentDAO);
//              deleteAllStudents(studentDAO);
        };
    }

    private void queryForStudents(StudentDAO studentDAO)
    {
        List<Student> theStudents = studentDAO.findAll();

        for(Student tempStudent : theStudents)
        {
            System.out.println(tempStudent);
        }
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
