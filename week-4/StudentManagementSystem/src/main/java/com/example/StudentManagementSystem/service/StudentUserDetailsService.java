package com.example.StudentManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.StudentManagementSystem.entity.Student;
import com.example.StudentManagementSystem.repository.StudentRepository;

@Service
public class StudentUserDetailsService implements UserDetailsService {

    @Autowired
    private StudentRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Student student = repository.findByName(username);

        if(student == null){
            throw new UsernameNotFoundException("User not found");
        }

        return new StudentUserDetails(student);
    }
}