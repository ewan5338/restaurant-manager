package com.wantensoup.prototype.Customer;

/**
 * Last Updated: 10/18/2022 
 * Class Purpose: Contains all the mappings to display all customer HTML pages.
 * @author Ewan Allen
 */
import com.wantensoup.prototype.Menu.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {
    
    @Autowired
    private MenuService menuService;
    
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
    public String viewMenu(Model _model) {
        _model.addAttribute("listMenuItems", menuService.getAllMenuItems());
        return "customer/menu";
    }
    
}
