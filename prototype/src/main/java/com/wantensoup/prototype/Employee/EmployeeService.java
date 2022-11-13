package com.wantensoup.prototype.Employee;

/**
 * Last Updated: 11/01/2022 
 * Class Purpose: Defines the functionality of employee objects.
 * @author Atsoupe Bessou Kpeglo
 */
import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    void saveEmployee(Employee _employee);

    Employee getEmployeeById(Integer _id);

    void deleteEmployeeById(Integer _id);
    
}
