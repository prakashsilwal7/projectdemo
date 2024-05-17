package com.codegravity.springboot.projectdemo.repository;

import com.codegravity.springboot.projectdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Integer > {
    //no need to write any method as we are using JPA

}
