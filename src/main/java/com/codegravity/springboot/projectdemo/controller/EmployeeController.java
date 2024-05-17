package com.codegravity.springboot.projectdemo.controller;

import com.codegravity.springboot.projectdemo.entity.Employee;
import com.codegravity.springboot.projectdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployee() {
        return employeeService.findAllEmployee();
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable int id) {
        try {
            Employee employee = employeeService.findById(id);
            return ResponseEntity.ok(employee);

        }
        catch (Exception error){
            return ResponseEntity.status(404).body("Invalid Id. Please enter correctly.");
        }
    }

    @PostMapping("/employees")
    public Employee postEmployee(@RequestBody Employee newEmployee){
        return employeeService.createEmployee(newEmployee);
    }

    @PutMapping("/employees")
    public ResponseEntity<?> putEmployee(@RequestBody Employee newEmployee){
        try{
           Employee updatedEmployee =  employeeService.updateEmployeeById( newEmployee);
           return ResponseEntity.ok(updatedEmployee);
        }
        catch (Exception e){
            return ResponseEntity.status(404).body("Invalid Employee Id.");
        }


    }

    @DeleteMapping("/employees/{theId}")
    public String removeEmployeeById(@PathVariable int theId){
        return employeeService.deleteEmployeeById(theId);
    }

}

