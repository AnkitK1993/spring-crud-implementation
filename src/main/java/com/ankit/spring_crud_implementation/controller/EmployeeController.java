package com.ankit.spring_crud_implementation.controller;

import com.ankit.spring_crud_implementation.model.Employee;
import com.ankit.spring_crud_implementation.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/hi")
    public String hello() {
        return "Hello World";
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("{id}")
    @Cacheable(cacheNames = "Employee", key = "#id")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/all")
    @CachePut(cacheNames = "Employee", key = "#result")
    public List<Employee> createListOfEmployees(@RequestBody List<Employee> employees) {
        return employeeService.createEmployeeList(employees);
    }

    @PostMapping
    @CachePut(cacheNames = "Employee", key = "#result.id")
    public Employee createEmployee(@RequestBody Employee  employee) {
        return employeeService.createEmployee(employee);
    }

    @PutMapping("/{id}")
    @CachePut(cacheNames = "Employee", key = "#id")
    public Employee updateEmployee(@RequestBody Employee employee, @PathVariable Long id) {
        return employeeService.updateEmployee(employee, id);
    }

    @DeleteMapping("{id}")
    @CacheEvict(cacheNames = "Employee", key = "#id")
    public String deleteEmployee(@PathVariable Long id) {
        return employeeService.deleteEmployee(id);
    }

    @DeleteMapping
    @CacheEvict(cacheNames = "Employee", allEntries = true)
    public String deleteAllEmployees() {
        return employeeService.deleteAllEmployees();
    }

}
