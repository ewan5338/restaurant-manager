/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wantensoup.prototype.Manager;

import com.wantensoup.prototype.Employee.Employee;
import com.wantensoup.prototype.Employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author garca
 */
@Controller
public class ManagerController {
    
    @Autowired
    private EmployeeService employeeService;
    
    @GetMapping("/manager/home")
    public String viewManagerHomePage() {
        return "manager/managerhome";
    }
    
    @GetMapping("/manager/employees")
    public String viewEmployeeList(Model model) {
        model.addAttribute("listEmployees", employeeService.getAllEmployees());
        return "manager/manage_employees";
    }

    @GetMapping("/manager/addNewEmployee")
    public String addNewEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "manager/add_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveNewEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/manager/employees";
    }
    
    @GetMapping("/updateEmployee/{id}")
    public String updateEmployee(@PathVariable(value = "id") long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "manager/update_employee";
    }
    
    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id) {
        this.employeeService.deleteEmployeeById(id);
        return "redirect:/manager/employees";
    }
    
    @GetMapping("/manager/schedules")
    public String viewModifySchedules() {
        return "manager/modify_schedules";
    }
    
    @GetMapping("/manager/order")
    public String makeOrders() {
        return "manager/order";
    }
    
    @GetMapping("/manager/orderconfirm")
    public String orderConfirmed() {
        return "manager/order_confirm";
    }
    
    @GetMapping("/manager/menu")
    public String viewMenuManager() {
        return "manager/manager_menu";
    }
    
    @GetMapping("/manager/managemenu")
    public String manageMenu() {
        return "manager/edit_menu";
    }
    
    @GetMapping("/manager/editbox")
    public String editBox() {
        return "manager/edit_box";
    }
  
}
