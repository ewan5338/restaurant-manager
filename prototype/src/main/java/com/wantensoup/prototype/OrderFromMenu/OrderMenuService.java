package com.wantensoup.prototype.OrderFromMenu;

/**
 * Last Updated: 11/13/2022 
 * Class Purpose: Defines the functionality of OrderMenu objects.
 * @author Ewan Allen, Kristin Cattell
 */
import java.util.List;

public interface OrderMenuService {

    List<OrderMenu> getAllItems();

    void saveItem(OrderMenu _item);

    OrderMenu getItemById(Integer _id);

    void deleteItemById(Integer _id);
    
}
