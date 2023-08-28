package com.platonus.student.service.impl;

import com.platonus.student.dao.StudentDao;
import com.platonus.student.dto.Student;
import com.platonus.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentDao studentDao;

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public Student create(Student student) {
        return studentDao.create(student);
    }

    @Override
    public void updateGrade(Long studentId, Long grade) {
        studentDao.update(studentId, grade);
    }

    @Override
    public void deleteGrade(Long studentId) {
        studentDao.deleteGrade(studentId);
    }

    @Override
    public Student findById(Long id) {
        return studentDao.findById(id);
    }
}
