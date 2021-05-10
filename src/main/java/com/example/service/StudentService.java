package com.example.service;

import com.example.entity.Student;
import com.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student findById(String id) {
        return Optional.of(studentRepository.findById(id))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .orElse(null);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student saveOrUpdateStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteById(String id) {
        studentRepository.deleteById(id);
    }
}
