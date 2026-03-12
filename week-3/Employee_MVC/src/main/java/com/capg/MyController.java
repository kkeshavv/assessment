package com.capg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

    @Autowired
    private EmployeeDao dao;

    @RequestMapping("/form")
    public String homepage() {
        return "form";
    }
    
    @PostMapping("/submitForm2")
    public String saveEmployee(@ModelAttribute Employee emp) {

        dao.save(emp);
        return "success";
    }
}