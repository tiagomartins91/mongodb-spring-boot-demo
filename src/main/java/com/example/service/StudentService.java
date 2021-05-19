package com.example.service;

import com.example.entity.Student;
import com.example.repository.DepartmentRepository;
import com.example.repository.StudentRepository;
import com.example.repository.SubjectRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final DepartmentRepository departmentRepository;
    private final SubjectRepository subjectRepository;

    private StudentService(StudentRepository studentRepository, DepartmentRepository departmentRepository, SubjectRepository subjectRepository) {
        this.studentRepository = studentRepository;
        this.departmentRepository = departmentRepository;
        this.subjectRepository = subjectRepository;
    }

    public Student createStudent(final Student student) {
        return studentRepository.save(student);
    }

    public Student createStudentWithRelations(final Student student) {
        if (student.getDepartment() != null) {
            departmentRepository.save(student.getDepartment());
        }

        if (student.getSubjects() != null && !student.getSubjects().isEmpty()) {
            subjectRepository.saveAll(student.getSubjects());
        }

        return studentRepository.save(student);
    }

    public Student findById(final String id) {
        return Optional.of(studentRepository.findById(id))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .orElse(null);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student saveOrUpdateStudent(final Student student) {
        return studentRepository.save(student);
    }

    public void deleteById(final String id) {
        studentRepository.deleteById(id);
    }

    public List<Student> findStudentsByName(final String name) {
        return studentRepository.findByName(name);
    }

    public List<Student> getStudentsByName(final String name) {
        return studentRepository.getByName(name);
    }

    public List<Student> getStudentsByNameAndEmail(final String name, final String email) {
        return studentRepository.findByNameAndEmail(name, email);
    }

    public List<Student> getStudentsByNameOrEmail(final String name, final String email) {
        return studentRepository.findByNameOrEmail(name, email);
    }

    public List<Student> getWithPagination(final int pageNumber, final int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);

        return studentRepository.findAll(pageable).getContent();
    }

    public List<Student> allWithSorting() {
        Sort sort = Sort.by(Sort.Direction.ASC, "name", "email");

        return studentRepository.findAll(sort);
    }

    public List<Student> byDepartmentName(final String deptName) {
        return studentRepository.findByDepartmentDepartmentName(deptName);
    }

    public List<Student> bySubjectName(final String subjectName) {
        return studentRepository.findBySubjectsSubjectName(subjectName);
    }

    public List<Student> emailLike(final String email) {
        return studentRepository.findByEmailIsLike(email);
    }

    public List<Student> nameStartsWith(final String name) {
        return studentRepository.findByNameStartsWith(name);
    }

    public List<Student> byDepartmentId(final String deptId) {
        return studentRepository.findByDepartmentId(deptId);
    }
}
