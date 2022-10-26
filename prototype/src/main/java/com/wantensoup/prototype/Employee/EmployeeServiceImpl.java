/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wantensoup.prototype.Employee;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author garca
 */

@Service
public class EmployeeServiceImpl implements EmployeeService{
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Override
    public List<Employee> getAllEmployees() {
       return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> optional = employeeRepository.findById(id);
        Employee employee = null;
        if(optional.isPresent()) {
            employee = optional.get();
        } else {
            throw new RuntimeException("Employee not found for id: " + id);
        }
        return employee;
    }

    @Override
    public void deleteEmployeeById(long ID) {
        this.employeeRepository.deleteById(ID);
    }
    
}
