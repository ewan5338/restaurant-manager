package com.wantensoup.prototype.Employee;

/**
 * Last Updated: 11/01/2022
 * Class Purpose: Contains all the mappings to display all employee HTML pages.
 * @author Atsoupe Bessou Kpeglo
 */
import com.wantensoup.prototype.Table.RestTables;
import com.wantensoup.prototype.Table.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class EmployeeController {
    
    @Autowired
    private TableService tableService;

    @GetMapping("/employee/home")
    public String viewEmployeeHomePage() {
        return "employee/employeehome";
    }

    @GetMapping("/employee/vieworders")
    public String viewCustomerOrders() {
        return "employee/view_orders";
    }

    @GetMapping("/employee/tables")
    public String manageTables(Model model) {
        model.addAttribute("listTables", tableService.getAllTables());
        return "employee/manage_tables";
    }
    
    @GetMapping("employee/updateTable")
    public String updateTableStatus(@PathVariable (value = "number") long number, Model model) {
        RestTables table = tableService.getTableById(number);
        model.addAttribute("table", table);
        return "INSERT HTML HERE";
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
