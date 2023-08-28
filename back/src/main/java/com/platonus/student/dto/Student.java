package com.platonus.student.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {

    private Long id;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    private Long grade;

    public Student(String firstName, String lastName, Long grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }
}

