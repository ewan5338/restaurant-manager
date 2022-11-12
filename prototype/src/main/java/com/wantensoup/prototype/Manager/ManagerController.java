package com.wantensoup.prototype.Manager;

/**
 * Last Updated: 11/10/2022
 * Class Purpose: Contains all the mappings to display all manager HTML pages.
 * @author Kristin Cattell
 */
import com.wantensoup.prototype.Employee.Employee;
import com.wantensoup.prototype.Employee.EmployeeService;
import com.wantensoup.prototype.Schedule.Schedule;
import com.wantensoup.prototype.Schedule.ScheduleService;
import com.wantensoup.prototype.User.User;
import com.wantensoup.prototype.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String updateEmployee(@PathVariable(value = "id") long _id, Model _model) {
        Employee employee = employeeService.getEmployeeById(_id);
        _model.addAttribute("employee", employee);
        return "manager/update_employee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long _id) {
        this.employeeService.deleteEmployeeById(_id);
        this.scheduleService.deleteScheduleById(_id);
        this.userService.deleteUserById(_id);
        return "redirect:/manager/employees";
    }

    @GetMapping("/manager/schedules")
    public String viewModifySchedules(Model _model) {
        _model.addAttribute("listSchedules", scheduleService.getAllSchedules());
        return "schedule/schedules";
    }
    
     @GetMapping("/updateSchedule/{id}")
    public String updateSchedule(@PathVariable(value = "id") long _id, Model _model) {
        Schedule schedule = scheduleService.getScheduleById(_id);
        _model.addAttribute("schedule", schedule);
        return "schedule/update_schedules";
    }
    
    @PostMapping("/saveSchedule")
    public String saveSchedule(@ModelAttribute("schedule") Schedule _schedule) {
        scheduleService.saveSchedule(_schedule);
        return "redirect:/manager/schedules";
    }

    @GetMapping("/manager/order")
    public String makeOrders() {
        return "manager/order";
    }

    @GetMapping("/manager/orderconfirm")
    public String orderConfirmed() {
        return "manager/order_confirm";
    }

    @GetMapping("/manager/menu")
    public String viewMenuManager() {
        return "manager/manager_menu";
    }

    @GetMapping("/manager/managemenu")
    public String manageMenu() {
        return "manager/edit_menu";
    }

    @GetMapping("/manager/editbox")
    public String editBox() {
        return "manager/edit_box";
    }

}
