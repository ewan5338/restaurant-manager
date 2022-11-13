package com.wantensoup.prototype.OrderItems;

import com.wantensoup.prototype.Employee.Employee;
import com.wantensoup.prototype.Employee.EmployeeService;
import com.wantensoup.prototype.Item.Item;
import com.wantensoup.prototype.Item.ItemService;
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
    
    @Autowired
    private ItemService itemService;
    
    @GetMapping("/manager/order")
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
        _model.addAttribute("listItems", itemService.getAllItems());
        _model.addAttribute("cartItems", cartItems);
        _model.addAttribute("managerId", managerId);
        return "orderItems/order";
    }
    
    @GetMapping("/addNewOrder/{name}")
    public String addNewOrder(@PathVariable(value = "name") Integer name, Model _model, @AuthenticationPrincipal Authentication auth) {
       auth = SecurityContextHolder.getContext().getAuthentication();
       String managerName = auth.getName();
       Integer managerId = null;
       String itemName = null;
       List<Employee> list = employeeService.getAllEmployees();
       List<Item> itemList = itemService.getAllItems();
        
        for (Employee employee : list) {
            if(employee.getUsername().equals(managerName)) {
                managerId = employee.getId();
                managerName = employee.getFullName();
            }
        }
        
        for(Item item : itemList) {
            if(item.getId().equals(name)) {
                itemName = item.getItemName();
            }
        }
        
        OrderItems itemOrder = new OrderItems();
        itemOrder.setManagerId(managerId);
        itemOrder.setManagerName(managerName);
        itemOrder.setItemId(name);
        itemOrder.setItemName(itemName);
        itemOrder.setQuantity(1);
        itemOrder.setStatus("Ordering");
        orderItemsService.saveItem(itemOrder);
        return "redirect:/manager/order";
    }
    
    @GetMapping("/updateOrder/{id}")
    public String updateItem(@PathVariable(value = "id") Integer _id, Model _model) {
        OrderItems item = orderItemsService.getItemById(_id);
        _model.addAttribute("item", item);
        return "orderItems/updateQuantity";
    }
    
    @PostMapping("/saveOrder")
    public String saveNewItem(@ModelAttribute("item") OrderItems _item) {
        orderItemsService.saveItem(_item);
        return "redirect:/manager/order";
    }
    
    @GetMapping("/deleteOrder/{id}")
    public String deleteItemFromList(@PathVariable(value = "id") Integer _id) {
        this.orderItemsService.deleteItemById(_id);
        return "redirect:/manager/order";
    }
    
    @GetMapping("/deletePlacedOrder/{id}")
    public String deleteItemFromOrderedList(@PathVariable(value = "id") Integer _id) {
        this.orderItemsService.deleteItemById(_id);
        return "redirect:/manager/placedorders";
    }
    
    @GetMapping("/manager/placedorders")
    public String viewPlacedOrders(Model _model) {
        _model.addAttribute("orders", orderItemsService.getAllItems());
        return "orderItems/placedOrders";
    }
}
