package com.codegravity.springboot.projectdemo.service;

import com.codegravity.springboot.projectdemo.entity.Employee;
import com.codegravity.springboot.projectdemo.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee findById(int id){
        Optional<Employee> theEmployee = employeeRepo.findById(id);
        if (theEmployee.isPresent()){
            return theEmployee.get();
        }
        else {
            throw new RuntimeException("The employee id : "+ id +" do not exist");
        }
    }

    public List<Employee> findAllEmployee(){
        return employeeRepo.findAll();
    }

    public Employee createEmployee(Employee newEmployee){
        return employeeRepo.save(newEmployee);
    }

    public String deleteEmployeeById(int id){
        Optional<Employee> theEmployee = employeeRepo.findById(id);
        if (theEmployee.isPresent()){
            employeeRepo.deleteById(id);
            return "Successfully Deleted Employee with id "+id;
        }
        else {
            return "The employee id : "+ id +" do not exist";
        }
    }

    public Employee updateEmployeeById( Employee newEmployee){
        Optional<Employee> theEmployee = employeeRepo.findById(newEmployee.getEmployeeId());
        if (theEmployee.isPresent()){
            employeeRepo.save(newEmployee);
            return newEmployee;
        }
        else {
            throw new RuntimeException("The employee id : "+ newEmployee.getEmployeeId() +" do not exist");
        }
    }

}
