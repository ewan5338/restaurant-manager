package com.wantensoup.prototype.Manager;

/**
 * Last Updated: 11/11/2022
 * Class Purpose: Contains all the mappings to display all manager HTML pages.
 * @author Kristin Cattell
 */
import com.wantensoup.prototype.Employee.Employee;
import com.wantensoup.prototype.Employee.EmployeeService;
import com.wantensoup.prototype.Menu.Menu;
import com.wantensoup.prototype.Menu.MenuService;
import com.wantensoup.prototype.OrderItems.OrderItems;
import com.wantensoup.prototype.OrderItems.OrderItemsService;
import com.wantensoup.prototype.Schedule.Schedule;
import com.wantensoup.prototype.Schedule.ScheduleService;
import com.wantensoup.prototype.ScheduleDate.ScheduleDate;
import com.wantensoup.prototype.ScheduleDate.ScheduleDateService;
import com.wantensoup.prototype.User.User;
import com.wantensoup.prototype.User.UserService;
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
public class ManagerController {

    @Autowired
    private EmployeeService employeeService;
    
    @Autowired
    private ScheduleService scheduleService;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private ScheduleDateService scheduleDateService;
    
    @Autowired
    private MenuService menuService;
    
    @Autowired
    private OrderItemsService orderItemsService;

    @GetMapping("/manager/home")
    public String viewManagerHomePage() {
        return "manager/managerhome";
    }

    @GetMapping("/manager/employees")
    public String viewEmployeeList(Model _model) {
        _model.addAttribute("listEmployees", employeeService.getAllEmployees());
        return "manager/manage_employees";
    }

    @GetMapping("/manager/addNewEmployee")
    public String addNewEmployee(Model _model) {
        Employee employee = new Employee();
        _model.addAttribute("employee", employee);
        return "manager/add_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveNewEmployee(@ModelAttribute("employee") Employee _employee) {
        employeeService.saveEmployee(_employee);
        Schedule schedule = new Schedule();
        schedule.setId(_employee.getId());
        schedule.setEmployeeName(_employee.getFullName());
        scheduleService.saveSchedule(schedule);
        User user = new User();
        user.setId(_employee.getId());
        user.setUsername(_employee.getUsername());
        user.setPassword(_employee.getPassword());
        user.setRole(_employee.getRole());
        userService.saveUser(user);
        return "redirect:/manager/employees";
    }

    @GetMapping("/updateEmployee/{id}")
    public String updateEmployee(@PathVariable(value = "id") Integer _id, Model _model) {
        Employee employee = employeeService.getEmployeeById(_id);
        _model.addAttribute("employee", employee);
        return "manager/update_employee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") Integer _id) {
        this.employeeService.deleteEmployeeById(_id);
        this.scheduleService.deleteScheduleById(_id);
        this.userService.deleteUserById(_id);
        return "redirect:/manager/employees";
    }

    @GetMapping("/manager/schedules")
    public String viewModifySchedules(Model _model, Model _model2) {
        _model.addAttribute("listSchedules", scheduleService.getAllSchedules());
        _model2.addAttribute("listScheduleDate", scheduleDateService.getAllScheduleDates());
        return "schedule/schedules";
    }
    
    @GetMapping("/updateSchedule/{id}")
    public String updateSchedule(@PathVariable(value = "id") Integer _id, Model _model) {
        Schedule schedule = scheduleService.getScheduleById(_id);
        _model.addAttribute("schedule", schedule);
        return "schedule/update_schedules";
    }
    
    @PostMapping("/saveSchedule")
    public String saveSchedule(@ModelAttribute("schedule") Schedule _schedule) {
        scheduleService.saveSchedule(_schedule);
        return "redirect:/manager/schedules";
    }
    
    @GetMapping("/updateScheduleDate/{id}")
    public String updateScheduleDate(@PathVariable(value = "id") Integer _id, Model _model) {
        ScheduleDate schedule = scheduleDateService.getScheduleDateById(_id);
        _model.addAttribute("schedule", schedule);
        return "schedule/update_schedDate";
    }
    
    @PostMapping("/saveScheduleDate")
    public String saveScheduleDate(@ModelAttribute("schedule") ScheduleDate _schedule) {
        scheduleDateService.saveScheduleDate(_schedule);
        return "redirect:/manager/schedules";
    }

    @GetMapping("/manager/orderconfirm")
    public String orderConfirmed(@AuthenticationPrincipal Authentication auth) {
        auth = SecurityContextHolder.getContext().getAuthentication();
        String managerName = auth.getName();
        List<OrderItems> cartItems = orderItemsService.getAllItems();
        List<Employee> list = employeeService.getAllEmployees();
        
        for (Employee employee : list) {
            if(employee.getUsername().equals(managerName)) {
                managerName = employee.getFullName();
            }
        }
        
        for (OrderItems items : cartItems) {
            if(items.getStatus().equals("Ordering") && items.getManagerName().equals(managerName)) {
                items.setStatus("Ordered");
                orderItemsService.saveItem(items);
            }
        }
        
        return "manager/order_confirm";
    }

    @GetMapping("/manager/menu")
    public String viewMenuManager(Model _model) {
        _model.addAttribute("listMenuItems", menuService.getAllMenuItems());
        return "manager/manager_menu";
    }

    @GetMapping("/manager/managemenu")
    public String manageMenu(Model _model) {
        _model.addAttribute("listMenuItems", menuService.getAllMenuItems());
        return "menuItems/menu";
    }
    
    @GetMapping("/manager/addNewMenuItem")
    public String addNewMenuItem(Model _model) {
        Menu menu = new Menu();
        _model.addAttribute("menu", menu);
        return "menuItems/add_menuItem";
    }
    
    @GetMapping("/updateMenuItem/{id}")
    public String updateMenuItem(@PathVariable(value = "id") Integer _id, Model _model) {
        Menu menu = menuService.getMenuItemById(_id);
        _model.addAttribute("menu", menu);
        return "menuItems/update_menuItem";
    }
    
    @PostMapping("/saveMenuItem")
    public String saveMenuItem(@ModelAttribute("menu") Menu _menu) {
        menuService.saveMenuItem(_menu);
        return "redirect:/manager/managemenu";
    }
    
    @GetMapping("/deleteMenuItem/{id}")
    public String deleteMenuItem(@PathVariable(value = "id") Integer _id) {
        this.menuService.deleteMenuItemById(_id);
        return "redirect:/manager/managemenu";
    }

    @GetMapping("/manager/editbox")
    public String editBox() {
        return "manager/edit_box";
    }

}
