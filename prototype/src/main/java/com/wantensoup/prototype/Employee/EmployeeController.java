package com.wantensoup.prototype.Employee;

/**
 * Last Updated: 11/09/2022 Class Purpose: Contains all the mappings to display
 * all employee HTML pages.
 *
 * @author Atsoupe Bessou Kpeglo
 */
import com.wantensoup.prototype.Table.RestTables;
import com.wantensoup.prototype.Table.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/employee/manage_tables")
    public String manageTables(Model model) {
        model.addAttribute("listTables", tableService.getAllTables());
        return "employee/restTables";
    }

    @GetMapping("/tableStatusUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        //get employee from the service
        RestTables table = tableService.getTableById(id);
        model.addAttribute("table", table);
        return "employee/restTable_update";
    }

    @PostMapping("/saveTable")
    public String saveTableStatus(@ModelAttribute("table") RestTables _table) {
        tableService.saveTable(_table);
        return "redirect:/employee/manage_tables";
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
