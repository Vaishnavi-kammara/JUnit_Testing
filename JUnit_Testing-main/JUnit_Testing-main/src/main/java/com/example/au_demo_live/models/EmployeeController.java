package com.example.au_demo_live.models;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeeService employeeService;

    @ExceptionHandler(EmployeeNotFound.class)
    public ResponseEntity processEmployeeNotFound(){
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable String id) throws Exception {
        return employeeService.getEmployee(id);
    }
}