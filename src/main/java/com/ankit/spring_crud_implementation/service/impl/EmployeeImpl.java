package com.ankit.spring_crud_implementation.service.impl;

import com.ankit.spring_crud_implementation.model.Employee;

import java.util.List;

public interface EmployeeImpl {

    List<Employee> createEmployeeList(List<Employee> employee);

    Employee createEmployee(Employee employee);

    Employee updateEmployee(Employee employee, Long id);

    String deleteEmployee(Long id);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Long id);

    String deleteAllEmployees();
}
