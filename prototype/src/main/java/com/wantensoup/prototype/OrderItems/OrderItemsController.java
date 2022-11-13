package com.wantensoup.prototype.OrderItems;

import com.wantensoup.prototype.Employee.Employee;
import com.wantensoup.prototype.Employee.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author garca
 */
@Controller
public class OrderItemsController {
    
    @Autowired
    private OrderItemsService orderItemsService;
    
    @Autowired
    private EmployeeService employeeService;
    
    @GetMapping("/manager/cart")
    public String showOrders(Model _model, @AuthenticationPrincipal Authentication auth) {
        auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Integer managerId = null;
        List<Employee> list = employeeService.getAllEmployees();
        
        for (Employee employee : list) {
            if(employee.getUsername().equals(name)) {
                managerId = employee.getId();
            }
        }
        
        List<OrderItems> cartItems = orderItemsService.getAllItems();
        _model.addAttribute("cartItems", cartItems);
        _model.addAttribute("managerId", managerId);
        return "orderItems/cart";
    }
}
