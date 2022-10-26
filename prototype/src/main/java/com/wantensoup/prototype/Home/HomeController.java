/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wantensoup.prototype.Home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author garca
 */
@Controller
public class HomeController {
    @GetMapping("")
    public String viewHomePage() {
        return "index/index";
    }
    
    @GetMapping("/manager/login")
    public String viewManagerLoginPage() {
        return "manager/managerlogin";
    }
    
    @GetMapping("/employee/login")
    public String viewEmployeeLoginPage() {
        return "employee/employeelogin";
    }
    
    @GetMapping("/forgotpass")
    public String forgotPass() {
        return "index/forgotpass";
    }
    
    @GetMapping("/menu")
    public String viewMenu() {
        return "index/menu";
    }
}
