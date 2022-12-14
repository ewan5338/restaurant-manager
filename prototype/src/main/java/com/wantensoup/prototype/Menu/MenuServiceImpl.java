package com.wantensoup.prototype.Menu;

/**
 * Last Updated: 11/14/2022
 * Class Purpose: Implements the functionality of menu objects.
 * @author Kristin Cattell
 */
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Override
    public List<Menu> getAllMenuItems() {
        return menuRepository.findAll();
    }

    @Override
    public void saveMenuItem(Menu _menuItem) {
        this.menuRepository.save(_menuItem);
    }

    @Override
    public Menu getMenuItemById(Integer _id) {
        Optional<Menu> optional = menuRepository.findById(_id);
        Menu item = null;

        //Checks to see if a menu item is present within the "menu_items" table.
        if (optional.isPresent()) {
            item = optional.get();
        } else {
            throw new RuntimeException("Menu item not found for id: " + _id);
        }

        return item;
    }

    @Override
    public void deleteMenuItemById(Integer _id) {
        this.menuRepository.deleteById(_id);
    }

}
