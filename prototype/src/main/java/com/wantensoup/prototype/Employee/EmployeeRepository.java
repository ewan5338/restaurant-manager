package com.wantensoup.prototype.Employee;

/**
 * Last Updated: 11/01/2022 
 * Class Purpose: Allows access to the data in the "Employee" table in the 
 * database.
 * @author Atsoupe Bessou Kpeglo
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    public Employee findByUsername(String _username);
    
}
