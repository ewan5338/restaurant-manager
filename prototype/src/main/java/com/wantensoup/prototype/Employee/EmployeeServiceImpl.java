package com.wantensoup.prototype.Employee;

/**
 * Last Updated: 10/18/2022 Class Purpose: Implements the functionality of
 * employee objects.
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
    public void saveEmployee(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> optional = employeeRepository.findById(id);
        Employee employee = null;

        if (optional.isPresent()) {
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
