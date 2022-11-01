package com.wantensoup.prototype.Customer;

/**
 * Last Updated: 10/18/2022 Class Purpose: Contains all the mappings to display
 * all customer HTML pages.
 * @author Ewan Allen
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {

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
