package com.wantensoup.prototype.Employee;

/**
 * Last Updated: 11/01/2022
 * Class Purpose: Implements the functionality of employee objects.
 * @author Atsoupe Bessou Kpeglo
 */
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee _employee) {
        this.employeeRepository.save(_employee);
    }

    @Override
    public Employee getEmployeeById(Integer _id) {
        Optional<Employee> optional = employeeRepository.findById(_id);
        Employee employee = null;

        if (optional.isPresent()) {
            employee = optional.get();
        } else {
            throw new RuntimeException("Employee not found for id: " + _id);
        }

        return employee;
    }

    @Override
    public void deleteEmployeeById(Integer _id) {
        this.employeeRepository.deleteById(_id);
    }

}
