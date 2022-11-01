package com.wantensoup.prototype.Employee;

/**
 * Last Updated: 11/01/2022
 * Class Purpose: Contains all the mappings to display all employee HTML pages.
 * @author Atsoupe Bessou Kpeglo
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {

    @GetMapping("/employee/home")
    public String viewEmployeeHomePage() {
        return "employee/employeehome";
    }

    @GetMapping("/employee/vieworders")
    public String viewCustomerOrders() {
        return "employee/view_orders";
    }

    @GetMapping("/employee/tables")
    public String manageTables() {
        return "employee/manage_tables";
    }

    @GetMapping("/employee/info")
    public String viewEmployeeInfo() {
        return "employee/view_info";
    }

    @GetMapping("/employee/menu")
    public String viewMenu() {
        return "employee/employee_menu";
    }

    @GetMapping("/employee/schedule")
    public String viewSchedule() {
        return "employee/employee_sched";
    }
    
}
