
[[Hibernate, JPA, ORM, JPQL]] - po uzoru na ovo


Olaksanje JPA, pises samo interfejs on ti doda klasu


![[Pasted image 20240505161334.png]]

```
//service/EmployeeServiceImpl.java

package rs.perica.spring.rest.springrestpractice.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.perica.spring.rest.springrestpractice.dao.EmployeeRepository;
import rs.perica.spring.rest.springrestpractice.entity.Employee;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements  EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {

        this.employeeRepository = employeeRepository;
    }

    @Transactional
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Transactional
    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
        Employee employee = null;
        if(result.isPresent())
        {
            employee = result.get();
        }
        else{
            throw new RuntimeException("Did not find employee id");
        }

        return employee;
    }

    @Transactional
    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}

```



```
// dao/EmployeeRepository.java
// potrebno je za Spring Data JPA samo interfejs ostalo ce Spring da implementira

package rs.perica.spring.rest.springrestpractice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.perica.spring.rest.springrestpractice.entity.Employee;


// entity type ,primary key <Employee, Integer>
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


}

```