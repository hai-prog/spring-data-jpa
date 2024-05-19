package com.example.employeeDirectoryDemo.service;

import com.example.employeeDirectoryDemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int id);

    Employee AddAnEmployee(Employee employee);

    void deleteEmployee(int theId);
}
