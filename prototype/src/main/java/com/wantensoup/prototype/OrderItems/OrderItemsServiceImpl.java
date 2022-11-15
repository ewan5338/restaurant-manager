package com.wantensoup.prototype.OrderItems;

/**
 * Last Updated: 11/14/2022
 * Class Purpose: Implements the functionality of OrderItems objects.
 * @author Kristin Cattell
 */
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class OrderItemsServiceImpl implements OrderItemsService {

    @Autowired
    private OrderItemsRepository itemRepository;

    @Override
    public List<OrderItems> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public void saveItem(OrderItems _item) {
        this.itemRepository.save(_item);
    }

    @Override
    public OrderItems getItemById(Integer _id) {
        Optional<OrderItems> optional = itemRepository.findById(_id);
        OrderItems item = null;

        //Checks to see if an item is present within the "items_cart" table.
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
