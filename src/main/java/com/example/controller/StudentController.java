package com.example.controller;

import com.example.entity.Student;
import com.example.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> findAll() {
        return studentService.getAllStudents();
    }

    @GetMapping(value = "withPagination")
    public List<Student> findWithPagination(@RequestParam final int pageNumber, @RequestParam final int pageSize) {
        return studentService.getWithPagination(pageNumber, pageSize);
    }

    @GetMapping(value = "allWithSorting")
    public List<Student> allWithSorting() {
        return studentService.allWithSorting();
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @GetMapping(value = "/{id}")
    public Student findById(@PathVariable("id") String id) {
        return studentService.findById(id);
    }

    @PutMapping
    public Student updateStudent(@RequestBody Student student) {
        return studentService.saveOrUpdateStudent(student);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteStudent(@PathVariable("id") String id) {
        studentService.deleteById(id);
    }

    @GetMapping(value = "/studentsByName/{name}")
    public List<Student> studentsByName(@PathVariable String name) {
        return studentService.getStudentsByName(name);
    }

    @GetMapping(value = "/byDepartmentName/{deptName}")
    public List<Student> studentsByDepartmentName(@PathVariable String deptName) {
        return studentService.byDepartmentName(deptName);
    }

    @GetMapping(value = "/bySubjectName/{subjectName}")
    public List<Student> studentsBySubjectName(@PathVariable String subjectName) {
        return studentService.bySubjectName(subjectName);
    }

    @GetMapping(value = "/studentsByNameAndEmail")
    public List<Student> studentsByNameAndEmail(@RequestParam String name, @RequestParam String email) {
        return studentService.getStudentsByNameAndEmail(name, email);
    }

    @GetMapping(value = "/emailLike")
    public List<Student> emailLike(@RequestParam String email) {
        return studentService.emailLike(email);
    }

    @GetMapping(value = "/studentsByNameOrEmail")
    public List<Student> studentsByNameOrEmail(@RequestParam String name, @RequestParam String email) {
        return studentService.getStudentsByNameOrEmail(name, email);
    }

}
