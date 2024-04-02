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
    @Transactional
    public void save(Student theStudent) {
        //cuvanje novog studenta u bazi
        entityManager.persist(theStudent);
    }

    public Student findById(Integer id)
    {
        return entityManager.find(Student.class, id);
    }
}