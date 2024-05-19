package com.example.employeeDirectoryDemo.dao;

import com.example.employeeDirectoryDemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
