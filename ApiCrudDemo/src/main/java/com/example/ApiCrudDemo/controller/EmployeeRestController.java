package com.example.ApiCrudDemo.controller;

import com.example.ApiCrudDemo.entity.Employee;
import com.example.ApiCrudDemo.services.EmployeeServices;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeServices employeeServices;

    public EmployeeRestController(EmployeeServices employeeServices) {
        this.employeeServices = employeeServices;
    }

    @GetMapping("/employees")
    public List<Employee> employeeList (){
        return employeeServices.findAll();
    }
    @GetMapping("/employees/{id}")
    public Employee findById(@PathVariable int id) {
        Employee employee = employeeServices.findById(id);
        if (employee == null) {
            throw new RuntimeException("Employee with id: " + id + " not found");
        }
        return employee;
    }
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        employee.setId(0);
        Employee employee1 = employeeServices.save(employee);
        return employee1;
    }
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        Employee employee1 = employeeServices.save(employee);
        return employee1;
    }
    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        Employee employee = employeeServices.findById(id);
        if(employee == null){
            throw new RuntimeException("Employee id: "+id+" Not Found ");
        }
        employeeServices.deleteById(id);
        return "Employee with id " + id+ " Deleted";
    }
}
