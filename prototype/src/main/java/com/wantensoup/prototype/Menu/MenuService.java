package com.wantensoup.prototype.Menu;

/**
 * Last Updated: 10/18/2022 
 * Class Purpose: Defines the functionality of item objects.
 * @author Kristin Cattell
 */
import java.util.List;

public interface MenuService {

    List<Menu> getAllMenuItems();

    void saveMenuItem(Menu _item);

    Menu getMenuItemById(Integer _id);

    void deleteMenuItemById(Integer _id);
    
}
