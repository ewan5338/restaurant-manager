package com.wantensoup.prototype.Item;

import com.wantensoup.prototype.Item.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Kristin Cattell
 */

@Controller
public class ItemController {
    
    @Autowired
    private ItemService itemService;
    
    @GetMapping("/manager/produce")
    public String viewManageProduce(Model model) {
        model.addAttribute("listItems", itemService.getAllItems());
        return "manager/manage_produce";
    }
    
    @GetMapping("/manager/addNewItem")
    public String addNewItem(Model model) {
        Item item = new Item();
        model.addAttribute("item", item);
        return "manager/add_item";
    }

    @PostMapping("/saveItem")
    public String saveNewItem(@ModelAttribute("item") Item item) {
        itemService.saveItem(item);
        return "redirect:/manager/produce";
    }
    
    @GetMapping("/updateItem/{id}")
    public String updateItem(@PathVariable(value = "id") long id, Model model) {
        Item item = itemService.getItemById(id);
        model.addAttribute("item", item);
        return "manager/update_item";
    }
    
    @GetMapping("/deleteItem/{id}")
    public String deleteItem(@PathVariable(value = "id") long id) {
        this.itemService.deleteItemById(id);
        return "redirect:/manager/produce";
    }
}
