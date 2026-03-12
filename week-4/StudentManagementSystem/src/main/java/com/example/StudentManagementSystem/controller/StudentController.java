package com.example.StudentManagementSystem.controller;

import java.io.IOException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.StudentManagementSystem.entity.Student;
import com.example.StudentManagementSystem.service.StudentService;

@RestController
public class StudentController {
	
	private final StudentService service;

    public StudentController(StudentService service){
        this.service=service;
    }

    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student) {
        return service.createStudent(student);
    }

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable int id) {
        return service.findStudentById(id);
    }

    @GetMapping("/getall")
    public Page<Student> getAllStudents(Pageable pageable) {
        return service.findAllStudents(pageable);
    }

    @PutMapping("/update")
    public Student updateStudent(@RequestParam int id, @RequestBody Student student) {
        return service.updateStudent(id, student);
    }

    @DeleteMapping("/delete")
    public void deleteStudent(@RequestParam int id) {
    	service.deleteStudent(id);
    }
    
    @PostMapping("/uploadprofile/{id}")
    public String uploadProfile(@PathVariable int id, @RequestParam("file") MultipartFile file) throws IOException {

        Student s = service.findStudentById(id);
        s.setProfileImage(file.getBytes());
        service.updateStudent(id, s);

        return "Profile uploaded";
    }
    
    @PostMapping("/uploadassignment/{id}")
    public String uploadAssignment(@PathVariable int id, @RequestParam("file") MultipartFile file) throws IOException {

        Student s = service.findStudentById(id);
        s.setAssignmentFile(file.getBytes());
        service.updateStudent(id,s);

        return "Assignment uploaded";
    }
    
    @GetMapping("/downloadprofile/{id}")
    public ResponseEntity<byte[]> downloadProfile(@PathVariable int id){

        Student s = service.findStudentById(id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"profile.jpg\"")
                .header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
                .body(s.getProfileImage());
    }
    
    @GetMapping("/downloadassignment/{id}")
    public ResponseEntity<byte[]> downloadAssignment(@PathVariable int id){

        Student s = service.findStudentById(id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"assignment\"")
                .header(HttpHeaders.CONTENT_TYPE, "application/octet-stream")
                .body(s.getAssignmentFile());
    }
}