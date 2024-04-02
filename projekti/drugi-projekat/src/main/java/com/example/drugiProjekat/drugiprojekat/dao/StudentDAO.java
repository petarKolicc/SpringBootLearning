package com.example.drugiProjekat.drugiprojekat.dao;

import com.example.drugiProjekat.drugiprojekat.entity.Student;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);
}

