package com.example.employeedemodocker.controller;

import com.example.employeedemodocker.model.Employee;
import com.example.employeedemodocker.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @PostMapping("/create")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee)
    {
        employee.setEmployeeId(UUID.randomUUID().toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createEmployee(employee));
    }
    @GetMapping("/list")
    public ResponseEntity<List<Employee>> displayEmployees()
    {
        return ResponseEntity.ok(employeeService.displayAllEmployees());
    }
}
