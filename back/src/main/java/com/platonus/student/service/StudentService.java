package com.platonus.student.service;

import com.platonus.student.dto.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    Student create(Student student);

    void updateGrade(Long studentId, Long grade);

    void deleteGrade(Long studentId);

    Student findById(Long id);


}
