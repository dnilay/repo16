package com.example.employeedemodocker.service;

import com.example.employeedemodocker.model.Employee;

import java.util.List;

public interface EmployeeService {

    public Employee createEmployee(Employee employee);
    public List<Employee> displayAllEmployees();
}
