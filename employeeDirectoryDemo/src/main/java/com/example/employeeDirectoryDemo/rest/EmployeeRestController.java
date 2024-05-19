package com.example.employeeDirectoryDemo.rest;

import com.example.employeeDirectoryDemo.entity.Employee;
import com.example.employeeDirectoryDemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    // inject employee service
    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }




    // expose "/employees" end point and return list of employees
    @GetMapping("/employees")
    public List<Employee> getListOfEmployees()
    {
        return employeeService.findAll();
    }

    // expose "/employee/id" endpoint to gat an employee by id
    @GetMapping("/employees/{employeeId}")

    public Employee getAnEmployee(@PathVariable int employeeId)
    {
        Employee employee = employeeService.findById(employeeId);

        if (employee == null)
        {
            throw new RuntimeException("The employee id not found -"+ employeeId);
        }
        return employee;
    }


   // expose "/employees" endpoint to add an employee
    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee theEmployee)
    {
        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        theEmployee.setId(0);

        Employee dpEmployee = employeeService.AddAnEmployee(theEmployee);

        return dpEmployee;
    }

    // expose "/employees" endpoint to add an employee
    @PutMapping ("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee)
    {

        Employee dpEmployee = employeeService.AddAnEmployee(theEmployee);

        return dpEmployee;
    }

    // expose "//employee/id" endpoint to delete an employee
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId)
    {
        Employee tmpEmployee = employeeService.findById(employeeId);

        // throw exception if null

        if(tmpEmployee== null)
        {
            throw  new RuntimeException("Employee id not found - "+ employeeId);
        }

        employeeService.deleteEmployee(employeeId);

        return "Deleted employee id - "+employeeId;
    }

}
