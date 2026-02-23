package com.ankit.spring_crud_implementation.repository;

import com.ankit.spring_crud_implementation.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
