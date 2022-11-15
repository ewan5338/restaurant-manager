package com.wantensoup.prototype.Customer;

/**
 * Last Updated: 11/14/2022 
 * Class Purpose: Contains all the mappings to display all customer HTML pages. 
 * Also contains methods to utilize security and menu ordering functions.
 * @author Ewan Allen
 */
import com.wantensoup.prototype.Menu.Menu;
import com.wantensoup.prototype.Menu.MenuService;
import com.wantensoup.prototype.OrderFromMenu.OrderMenu;
import com.wantensoup.prototype.OrderFromMenu.OrderMenuService;
import com.wantensoup.prototype.Table.RestTables;
import com.wantensoup.prototype.Table.TableService;
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
public class CustomerController {
    
    @Autowired
    private MenuService menuService;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private OrderMenuService orderMenuService;
    
    @Autowired
    private TableService tableService;
    
    @GetMapping("/customer/home")
    public String viewCustomerDashboard() {
        return "customer/customerDash";
    }
    
    @GetMapping("/customer/placeorder")
    public String showOrders(Model _model, @AuthenticationPrincipal Authentication _auth) {
        _auth = SecurityContextHolder.getContext().getAuthentication();
        String name = _auth.getName();
        Integer tableId = null;
        List<User> list = userService.getAllUsers();
        
        for (User user : list) {
            if (user.getUsername().equals(name)) {
                tableId = user.getId();
            }
        }
        
        _model.addAttribute("listItems", menuService.getAllMenuItems());
        _model.addAttribute("cartItems", orderMenuService.getAllItems());
        _model.addAttribute("tableId", tableId);
        return "customer/place_order";
    }
    
    @GetMapping("/addNewOrderFromMenu/{name}")
    public String addNewOrderFromMenu(@PathVariable(value = "name") Integer name, Model _model, @AuthenticationPrincipal Authentication _auth) {
        _auth = SecurityContextHolder.getContext().getAuthentication();
        String tableName = _auth.getName();
        Integer tableId = null;
        String menuName = null;
        double menuPrice = 0;
        List<User> list = userService.getAllUsers();
        List<Menu> itemList = menuService.getAllMenuItems();
        
        for (User user : list) {
            if (user.getUsername().equals(tableName)) {
                tableId = user.getId();
            }
        }
        
        for (Menu menu : itemList) {
            if (menu.getId().equals(name)) {
                menuName = menu.getMenuItem();
                menuPrice = menu.getPrice();
            }
        }
        
        OrderMenu itemOrder = new OrderMenu();
        itemOrder.setTableId(tableId);
        itemOrder.setTableName(tableName);
        itemOrder.setItemId(name);
        itemOrder.setItemName(menuName);
        itemOrder.setQuantity(1);
        itemOrder.setTotal((float) menuPrice);
        itemOrder.setStatus("Ordering");
        orderMenuService.saveItem(itemOrder);
        return "redirect:/customer/placeorder";
    }
    
    @GetMapping("/updateOrderFromMenu/{id}")
    public String updateOrderFromMenu(@PathVariable(value = "id") Integer _id, Model _model) {
        OrderMenu item = orderMenuService.getItemById(_id);
        _model.addAttribute("item", item);
        return "customer/update_quantity";
    }
    
    @PostMapping("/saveOrderFromMenu")
    public String saveNewOrderFromMenu(@ModelAttribute("item") OrderMenu _item) {
        orderMenuService.saveItem(_item);
        return "redirect:/customer/placeorder";
    }
    
    @GetMapping("/deleteOrderFromMenu/{id}")
    public String deleteOrderFromMenu(@PathVariable(value = "id") Integer _id) {
        orderMenuService.deleteItemById(_id);
        return "redirect:/customer/placeorder";
    }
    
    @GetMapping("/customer/orderconfirm")
    public String confirmMenuOrder(@AuthenticationPrincipal Authentication _auth) {
        _auth = SecurityContextHolder.getContext().getAuthentication();
        String tableName = _auth.getName();
        List<OrderMenu> cartItems = orderMenuService.getAllItems();
        List<RestTables> allTables = tableService.getAllTables();
        
        for (OrderMenu items : cartItems) {
            if (items.getStatus().equals("Ordering") && items.getTableName().equals(tableName)) {
                items.setStatus("Ordered");
                orderMenuService.saveItem(items);
            }
        }
        
        for (RestTables table : allTables) {
            if (table.getTableName().equals(tableName)) {
                table.setTableStatus("Ordered");
                tableService.saveTable(table);
            }
        }
        
        return "customer/order_confirm";
    }
    
    @GetMapping("/customer/callservice")
    public String callService(@AuthenticationPrincipal Authentication _auth) {
       _auth = SecurityContextHolder.getContext().getAuthentication();
       String tableName = _auth.getName();
       
       List<RestTables> list = tableService.getAllTables();
        
        for (RestTables table : list) {
            if (table.getTableName().equals(tableName)) {
                table.setCalls("Needs help");
                tableService.saveTable(table);
            }
        }

        return "customer/call_service";
    }
    
    @GetMapping("/customer/payorder")
    public String viewPayOrder(Model _model, Model _model2, Model _model3, @AuthenticationPrincipal Authentication _auth) {
        _auth = SecurityContextHolder.getContext().getAuthentication();
        String tableName = _auth.getName();
        Integer tableId = null;
        float total = 0;
        List<User> list = userService.getAllUsers();
        List<OrderMenu> list2 = orderMenuService.getAllItems();
        
        for (User user : list) {
            if (user.getUsername().equals(tableName)) {
                tableId = user.getId();
            }
        }
        
        for (OrderMenu menu : list2) {
            if (menu.getTableId().equals(tableId) && menu.getStatus().equals("Ordered")) {
                total = total + (menu.getTotal() * menu.getQuantity());
            }
        }
        
        _model.addAttribute("orders", orderMenuService.getAllItems());
        _model2.addAttribute("tableId", tableId);
        _model3.addAttribute("total", total);
        return "customer/pay_order";
    }
    
    @GetMapping("/customer/withcash")
    public String payWithCash(@AuthenticationPrincipal Authentication _auth) {
        _auth = SecurityContextHolder.getContext().getAuthentication();
        String tableName = _auth.getName();
        List<RestTables> allTables = tableService.getAllTables();
        
        for (RestTables table : allTables) {
            if (table.getTableName().equals(tableName)) {
                table.setTableStatus("Attempting to pay with cash");
                tableService.saveTable(table);
            }
        }
        
        return "customer/withcash";
    }
    
    @GetMapping("/customer/withcard")
    public String payWithCard(@AuthenticationPrincipal Authentication _auth) {
        _auth = SecurityContextHolder.getContext().getAuthentication();
        String tableName = _auth.getName();
        List<RestTables> allTables = tableService.getAllTables();
        
        for (RestTables table : allTables) {
            if (table.getTableName().equals(tableName)) {
                table.setTableStatus("Paid");
                tableService.saveTable(table);
            }
        }
        
        return "customer/withcard";
    }
    
    @GetMapping("/customer/menu")
    public String viewMenu(Model _model) {
        _model.addAttribute("listMenuItems", menuService.getAllMenuItems());
        return "customer/menu";
    }
    
}
