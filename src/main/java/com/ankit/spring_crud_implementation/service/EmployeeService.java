package com.ankit.spring_crud_implementation.service;

import com.ankit.spring_crud_implementation.model.Employee;
import com.ankit.spring_crud_implementation.repository.EmployeeRepository;
import com.ankit.spring_crud_implementation.service.impl.EmployeeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements EmployeeImpl {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> createEmployeeList(List<Employee> employees) {
        return employeeRepository.saveAll(employees);
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee, Long id) {
        Employee emp = employeeRepository.findById(id).get();
        if (emp == null)
            throw new RuntimeException("Employee not found");

        if (employee.getName() != null)
            emp.setName(employee.getName());
        if (employee.getSalary() != null)
            emp.setSalary(employee.getSalary());
        if (employee.getEmail() != null)
            emp.setEmail(employee.getEmail());

        return employeeRepository.save(emp);
    }

    @Override
    public String deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
        return "Deleted Employee with id: " + id;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public String deleteAllEmployees() {
        employeeRepository.deleteAll();
        return "Deleted All Employees";
    }
}
