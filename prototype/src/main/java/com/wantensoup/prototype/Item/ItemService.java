package com.wantensoup.prototype.Item;

/**
 * Last Updated: 10/18/2022 
 * Class Purpose: Defines the functionality of item objects.
 * @author Kristin Cattell
 */
import java.util.List;

public interface ItemService {

    List<Item> getAllItems();

    void saveItem(Item _item);

    Item getItemById(Integer _id);

    void deleteItemById(Integer _id);
    
}
