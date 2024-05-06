
![[Pasted image 20240503143624.png]]
Request - to je url

header - metapodaci

messsage body - sadrzaj


![[Pasted image 20240503143757.png]]


![[Pasted image 20240503143910.png]]staa vracamo http-om



#Primer

```
// http://localhost:8080/api/students/0
// poziv

package rs.perica.demo.rest;


import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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


	// studentId mora biti isti kao studentId
	// ovde prosledjujemo get sa parametrom u urlu
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId)
    {
        return theStudents.get(studentId);
    }

}

```



Ne koristi ovo umesto toga za radnju samo stavi 
- GET(read)
- PUT(update)
- POST(create)
- DELETE
![[Pasted image 20240504204005.png]]

