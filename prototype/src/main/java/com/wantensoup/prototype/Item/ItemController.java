package com.wantensoup.prototype.Item;

/**
 * Last Updated: 10/31/2022 
 * Class Purpose: Contains all the mappings to display all HTML pages related 
 * to managing the items.
 * @author Kristin Cattell
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/manager/produce")
    public String viewManageProduce(Model _model) {
        _model.addAttribute("listItems", itemService.getAllItems());
        return "manager/manage_produce";
    }

    @GetMapping("/manager/addNewItem")
    public String addNewItem(Model _model) {
        Item item = new Item();
        _model.addAttribute("item", item);
        return "manager/add_item";
    }

    @PostMapping("/saveItem")
    public String saveNewItem(@ModelAttribute("item") Item _item) {
        itemService.saveItem(_item);
        return "redirect:/manager/produce";
    }

    @GetMapping("/updateItem/{id}")
    public String updateItem(@PathVariable(value = "id") long _id, Model _model) {
        Item item = itemService.getItemById(_id);
        _model.addAttribute("item", item);
        return "manager/update_item";
    }

    @GetMapping("/deleteItem/{id}")
    public String deleteItem(@PathVariable(value = "id") long _id) {
        this.itemService.deleteItemById(_id);
        return "redirect:/manager/produce";
    }
    
}
