package rs.perica.demo.rest;


import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.perica.demo.entity.Student;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    // define @PostConstruct to load data.. only once called
    @PostConstruct
    public void loadData()
    {
        theStudents = new ArrayList<>();

        theStudents.add(new Student("Petar", "Kolic"));
        theStudents.add(new Student("Rade", "Martinovic"));
        theStudents.add(new Student("Valentino", "Rossi"));

    }


    @GetMapping("/students")
    public List<Student> getStudents() {


        return theStudents;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId)
    {
        if(studentId >= theStudents.size() || studentId < 0)
        {
            throw new StudentNotFoundException("Student id not found - " + studentId );
        }
            return theStudents.get(studentId);
    }

    // koje exceptione ovo hvata

}
