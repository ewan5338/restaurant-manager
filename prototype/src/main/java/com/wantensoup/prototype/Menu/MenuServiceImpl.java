package com.wantensoup.prototype.Menu;

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
    public Menu getMenuItemById(long _id) {
        Optional<Menu> optional = menuRepository.findById(_id);
        Menu item = null;

        //Checks to see if an item is present within the "items" table.
        if (optional.isPresent()) {
            item = optional.get();
        } else {
            throw new RuntimeException("Menu item not found for id: " + _id);
        }

        return item;
    }

    @Override
    public void deleteMenuItemById(long _id) {
        this.menuRepository.deleteById(_id);
    }

}
