package com.wantensoup.prototype.OrderFromMenu;

/**
 * Last Updated: 10/18/2022 
 * Class Purpose: Defines the functionality of item objects.
 * @author Kristin Cattell
 */
import java.util.List;

public interface OrderMenuService {

    List<OrderMenu> getAllItems();

    void saveItem(OrderMenu _item);

    OrderMenu getItemById(Integer _id);

    void deleteItemById(Integer _id);
    
}
