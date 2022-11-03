package com.wantensoup.prototype.Home;

/**
 * Last Updated: 11/01/2022
 * Class Purpose: Contains all the mappings to display the home page and the 
 * pages you can go to from the home page.
 * @author Kristin Cattell
 */
import com.wantensoup.prototype.GetDateAPI.GetDateAPI;
import java.io.IOException;
import java.net.URISyntaxException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController extends GetDateAPI {

    @GetMapping("")
    public String viewHomePage(Model _model) throws URISyntaxException, IOException, InterruptedException {
        //_model.addAttribute("dateAPI", parseAPI());
        return "index/index";
    }

    @GetMapping("/tableselect")
    public String viewCustomerHomePage() {
        return "customer/table_select";
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
