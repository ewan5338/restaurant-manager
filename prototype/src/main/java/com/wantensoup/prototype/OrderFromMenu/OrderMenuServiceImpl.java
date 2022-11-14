package com.wantensoup.prototype.OrderFromMenu;

/**
 * Last Updated: 11/01/2022
 * Class Purpose: Implements the functionality of item objects.
 * @author Kristin Cattell
 */
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class OrderMenuServiceImpl implements OrderMenuService {

    @Autowired
    private OrderMenuRepository itemRepository;

    @Override
    public List<OrderMenu> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public void saveItem(OrderMenu _item) {
        this.itemRepository.save(_item);
    }

    @Override
    public OrderMenu getItemById(Integer _id) {
        Optional<OrderMenu> optional = itemRepository.findById(_id);
        OrderMenu item = null;

        //Checks to see if an item is present within the "items" table.
        if (optional.isPresent()) {
            item = optional.get();
        } else {
            throw new RuntimeException("Item not found for id: " + _id);
        }

        return item;
    }

    @Override
    public void deleteItemById(Integer _id) {
        this.itemRepository.deleteById(_id);
    }

}
