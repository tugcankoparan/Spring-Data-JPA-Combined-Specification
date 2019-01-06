package com.tugcankoparan.example;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long>,
        JpaSpecificationExecutor<Employee> {
}