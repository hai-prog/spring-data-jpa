package com.example.employeeDirectoryDemo.service;

import com.example.employeeDirectoryDemo.dao.EmployeeRepository;
import com.example.employeeDirectoryDemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;


    // inject EmployeeDAO
   @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {

       Optional<Employee> result = employeeRepository.findById(id);

       Employee theEmployee = null;

       if(result.isPresent())
       {
           theEmployee= result.get();
       }

       else {
           throw new RuntimeException("The employee id not found -"+ id);
       }
       return theEmployee;
    }

    @Transactional
    @Override
    public Employee AddAnEmployee(Employee employee) {
      return   employeeRepository.save(employee);
    }

    @Transactional
    @Override
    public void deleteEmployee(int theId) {
        employeeRepository.deleteById(theId);
    }
}
