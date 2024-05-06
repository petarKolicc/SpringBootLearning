package com.example.drugiProjekat.drugiprojekat.dao;

import com.example.drugiProjekat.drugiprojekat.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    @Transactional
    public void save(Student theStudent) {
        //cuvanje novog studenta u bazi
        entityManager.persist(theStudent);
    }
    public List<Student> findAll()
    {
        // create query
        // student je ime klase ne ime u tabeli iako je to cesto i ime u tabeli, vec entity name i
        // entity fields
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM student", Student.class);


        // return results
        return theQuery.getResultList();

    }
    public Student findById(Integer id)
    {
        return entityManager.find(Student.class, id);
    }


    @Override
    public List<Student> findByLastName(String theLastName)
    {

        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:theData", Student.class);
        theQuery.setParameter("theData", theLastName);

        return theQuery.getResultList();
    }

    @Override
    @Transactional // update radimo
    public void update(Student theStudent)
    {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id)
    {
        Student theStudent = entityManager.find(Student.class, id);

        entityManager.remove(theStudent);
    }


    @Override
    @Transactional
    public int deleteAll()
    {
        int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();

        return numRowsDeleted;
    }
}