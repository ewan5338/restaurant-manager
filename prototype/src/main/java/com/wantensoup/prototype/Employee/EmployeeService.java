/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.wantensoup.prototype.Employee;

import java.util.List;

/**
 *
 * @author garca
 */
public interface EmployeeService {
    List<Employee> getAllEmployees();
    
    void saveEmployee(Employee employee);
    
    Employee getEmployeeById(long ID);
    
    void deleteEmployeeById(long ID);
}
