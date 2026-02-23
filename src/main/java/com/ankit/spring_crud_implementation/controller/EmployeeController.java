package com.ankit.spring_crud_implementation.controller;

import com.ankit.spring_crud_implementation.model.Employee;
import com.ankit.spring_crud_implementation.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    @Cacheable(cacheNames = "Employee")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping
    @CachePut(cacheNames = "Employee",key = "#result")
    public List<Employee> createEmployees(@RequestBody List<Employee> employees) {
        return employeeService.createEmployees(employees);
    }

    @PatchMapping("/{id}")
    @CachePut(cacheNames = "Employee",key = "#id")
    public Employee updateEmployee(@RequestBody Employee employee, @PathVariable Long id) {
        return employeeService.updateEmployee(employee, id);
    }

    @DeleteMapping("{id}")
    @CacheEvict(cacheNames = "Employee",key = "#id")
    public String deleteEmployee(@PathVariable Long id) {
        return employeeService.deleteEmployee(id);
    }

    @DeleteMapping
    @CacheEvict(cacheNames = "Employee",allEntries = true)
    public String deleteAllEmployees() {
        return employeeService.deleteAllEmployees();
    }

}
