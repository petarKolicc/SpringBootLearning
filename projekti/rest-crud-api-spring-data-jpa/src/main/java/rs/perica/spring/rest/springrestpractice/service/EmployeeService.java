package rs.perica.spring.rest.springrestpractice.service;

import rs.perica.spring.rest.springrestpractice.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int id);


    Employee save(Employee employee);

    void deleteById(int id);

}
