package rs.perica.spring.rest.springrestpractice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.perica.spring.rest.springrestpractice.entity.Employee;


// entity type ,primary key <Employee, Integer>
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


}
