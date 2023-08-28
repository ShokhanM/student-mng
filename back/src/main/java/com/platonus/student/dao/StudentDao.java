package com.platonus.student.dao;

import com.platonus.student.dto.Student;

import java.util.List;

public interface StudentDao {

    List<Student> findAll();

    Student create(Student student);

    void deleteGrade(Long id);

    Student findById(Long id);

    void update(Long studentId, Long grade);

}
