package com.platonus.student.dao.impl;

import com.platonus.student.dao.StudentDao;
import com.platonus.student.dto.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
@Slf4j
public class StudentDaoImpl implements StudentDao {

    private final DataSource dataSource;

    @Override
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            String sql = "SELECT * FROM student";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Student student = new Student();
                    student.setId(resultSet.getLong("id"));
                    student.setFirstName(resultSet.getString("first_name"));
                    student.setLastName(resultSet.getString("last_name"));
                    if (Objects.equals(0, resultSet.getLong("grade"))) {
                        student.setGrade(null);
                    } else {
                        student.setGrade(resultSet.getLong("grade"));
                    }
                    students.add(student);
                }
            }
        } catch (SQLException e) {
            log.error("Cannot get all students " + e.getMessage());
        }
        return students;
    }

    @Override
    public Student create(Student student) {
        try (Connection connection = dataSource.getConnection()) {
            String sql = "INSERT INTO student (first_name, last_name, grade) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, student.getFirstName());
                preparedStatement.setString(2, student.getLastName());
                preparedStatement.setLong(3, student.getGrade());
                preparedStatement.executeUpdate();
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    student.setId(generatedKeys.getLong(1));
                }
            }
        } catch (SQLException e) {
            log.error("Cannot create user " + e.getMessage());
        }
        return student;
    }

    @Override
    public void deleteGrade(Long id) {
        try (Connection connection = dataSource.getConnection()) {
            String sql = "UPDATE student SET grade=null WHERE id =?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, id);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            log.error("Cannot delete student by id " + id);
        }
    }

    @Override
    public Student findById(Long id) {
        Student student = null;
        try (Connection connection = dataSource.getConnection()) {
            String sql = "SELECT * FROM student WHERE id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    student = new Student();
                    student.setId(resultSet.getLong("id"));
                    student.setFirstName(resultSet.getString("first_name"));
                    student.setLastName(resultSet.getString("last_name"));
                    student.setGrade(resultSet.getLong("grade"));
                }
            }
        } catch (SQLException e) {
            log.error("Cannot find by id " + id);
        }
        return student;
    }

    @Override
    public void update(Long studentId, Long grade) {
        try (Connection connection = dataSource.getConnection()) {
            String sql = "UPDATE student SET  grade=? WHERE id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, grade);
                preparedStatement.setLong(2, studentId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            log.error("Cannot update student by id " + studentId);
        }
    }

}
