/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wantensoup.prototype.Customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author garca
 */
@Controller
public class CustomerController {
    
    @GetMapping("/tableselect")
    public String viewManagerHomePage() {
        return "customer/table_select";
    }
    
    @GetMapping("/customer/home")
    public String viewCustomerDashboard() {
        return "customer/customerDash";
    }
    
    @GetMapping("/customer/placeorder")
    public String placeOrder() {
        return "customer/place_order";
    }
    
    @GetMapping("/customer/callservice")
    public String callService() {
        return "customer/call_service";
    }
    
    @GetMapping("/customer/payorder")
    public String payOrder() {
        return "customer/pay_order";
    }
    
    @GetMapping("/customer/withcash")
    public String payWithCash() {
        return "customer/withcash";
    }
    
    @GetMapping("/customer/withcard")
    public String payWithCard() {
        return "customer/withcard";
    }
    
    @GetMapping("/customer/menu")
    public String viewMenu() {
        return "customer/menu";
    }
}
