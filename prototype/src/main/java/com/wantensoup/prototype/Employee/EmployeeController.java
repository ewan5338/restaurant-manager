/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wantensoup.prototype.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author garca
 */

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
