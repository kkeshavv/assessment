package com.example.StudentManagementSystem.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.StudentManagementSystem.entity.Student;
import com.example.StudentManagementSystem.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository repository;
    private final PasswordEncoder encoder;

    public StudentService(StudentRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

//    @PreAuthorize("hasRole('ADMIN')")
    public Student createStudent(Student student) {

        String encodedPassword = encoder.encode(student.getPassword());
        student.setPassword(encodedPassword);

        return repository.save(student);
    }

    @Cacheable(value = "students", key = "#id")
//    @PostAuthorize("returnObject.name == authentication.name")
    public Student findStudentById(int id) {

        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student Not Found"));
    }

    @PreAuthorize("hasRole('ADMIN')")
    public Page<Student> findAllStudents(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @PreAuthorize("hasRole('ADMIN')")
    public Student updateStudent(int id, Student student) {

        Student s = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student Not Found"));

        s.setName(student.getName());
        s.setEmail(student.getEmail());
        s.setCourse(student.getCourse());
        s.setMarks(student.getMarks());

        return repository.save(s);
    }

    @PreAuthorize("hasRole('ADMIN')")
    public String deleteStudent(int id) {
        repository.deleteById(id);
        return "Student Deleted";
    }
}