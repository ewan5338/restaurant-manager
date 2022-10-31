package com.wantensoup.prototype.Home;

import com.wantensoup.prototype.GetDateAPI.GetDateAPI;
import java.io.IOException;
import java.net.URISyntaxException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Kristin Cattell
 */
@Controller
public class HomeController extends GetDateAPI{
    @GetMapping("")
    public String viewHomePage(Model model) throws URISyntaxException, IOException, InterruptedException {
        model.addAttribute("dateAPI", parseAPI());
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
