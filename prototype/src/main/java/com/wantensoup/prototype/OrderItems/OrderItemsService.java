package com.wantensoup.prototype.OrderItems;

/**
 * Last Updated: 11/14/2022 
 * Class Purpose: Defines the functionality of OrderItems objects.
 * @author Kristin Cattell
 */
import java.util.List;

public interface OrderItemsService {

    List<OrderItems> getAllItems();

    void saveItem(OrderItems _item);

    OrderItems getItemById(Integer _id);

    void deleteItemById(Integer _id);
    
}
