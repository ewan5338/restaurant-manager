package com.wantensoup.prototype.Employee;

/**
 * Last Updated: 10/18/2022 Class Purpose: Defines the functionality of employee
 * objects.
 * @author Atsoupe Bessou Kpeglo
 */
import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    Employee getEmployeeById(long ID);

    void deleteEmployeeById(long ID);
    
}
