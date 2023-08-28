package com.platonus.student.controller;

import com.platonus.student.dto.Student;
import com.platonus.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(maxAge = 3600)
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/student")
public class StudentController {

    private final StudentService service;

    @GetMapping("/")
    public List<Student> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable("id") Long id){
        return service.findById(id);
    }

    @PostMapping("/")
    public Student createStudent(@RequestBody Student student){
        return service.create(student);
    }

    @PutMapping("/")
    public void updateGrade(@RequestBody Student student) {
        service.updateGrade(student.getId(), student.getGrade());
    }

    @DeleteMapping("/{id}")
    public void deleteGrade(@PathVariable("id") Long studentId) {
        service.deleteGrade(studentId);
    }


}
