package com.wantensoup.prototype.Employee;

/**
 * Last Updated: 11/09/2022 Class Purpose: Contains all the mappings to display
 * all employee HTML pages.
 *
 * @author Atsoupe Bessou Kpeglo
 */
import com.wantensoup.prototype.Menu.MenuService;
import com.wantensoup.prototype.OrderFromMenu.OrderMenuService;
import com.wantensoup.prototype.Schedule.ScheduleService;
import com.wantensoup.prototype.ScheduleDate.ScheduleDateService;
import com.wantensoup.prototype.Table.RestTables;
import com.wantensoup.prototype.Table.TableService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
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
    
    @Autowired
    private MenuService menuService;
    
    @Autowired
    private EmployeeService employeeService;
    
    @Autowired
    private ScheduleService scheduleService;
    
    @Autowired
    private ScheduleDateService scheduleDateService;
    
    @Autowired
    private OrderMenuService orderMenuService;

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
    public String showFormForUpdate(@PathVariable(value = "id") Integer id, Model model) {
        RestTables table = tableService.getTableById(id);
        model.addAttribute("table", table);
        return "employee/restTable_update";
    }

    @PostMapping("/saveTable")
    public String saveTableStatus(@ModelAttribute("table") RestTables _table) {
        tableService.saveTable(_table);
        return "redirect:/employee/manage_tables";
    }

     @GetMapping("/tableCalls/{id}")
    public String showTableCalls(@PathVariable(value = "id") Integer id, Model model) {
        //get employee from the service
        model.addAttribute("table", orderMenuService.getAllItems());
        return "customer orders html here";
    }
    
    @GetMapping("/employee/info")
    public String viewEmployeeInfo(Model _model, Model _model2, @AuthenticationPrincipal Authentication auth) {
        auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Integer employeeId = null;
        List<Employee> list = employeeService.getAllEmployees();
        
        for (Employee employee : list) {
            if(employee.getUsername().equals(name)) {
                employeeId = employee.getId();
            }
        }
        
        _model.addAttribute("employeeInfo", employeeService.getAllEmployees());
        _model2.addAttribute("employeeId", employeeId);
        return "employee/view_info";
    }
    
    @GetMapping("/employee/menu")
    public String viewMenu(Model _model) {
        _model.addAttribute("listMenuItems", menuService.getAllMenuItems());
        return "employee/employee_menu";
    }

    @GetMapping("/employee/schedule")
    public String viewSchedule(Model _model, Model _model2, Model _model3, @AuthenticationPrincipal Authentication auth) {
        auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Integer employeeId = null;
        List<Employee> list = employeeService.getAllEmployees();
        
        for (Employee employee : list) {
            if(employee.getUsername().equals(name)) {
                employeeId = employee.getId();
            }
        }
        
        _model.addAttribute("employeeInfo", scheduleService.getAllSchedules());
        _model2.addAttribute("employeeId", employeeId);
        _model3.addAttribute("scheduleWeek", scheduleDateService.getScheduleDateById(1));
        return "employee/employee_sched";
    }
    
    

}
