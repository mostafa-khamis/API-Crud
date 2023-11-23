package com.example.ApiCrudDemo.services;

import com.example.ApiCrudDemo.entity.Employee;

import java.util.List;

public interface EmployeeServices {
    List<Employee> findAll();
    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);
}
