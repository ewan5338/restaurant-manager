package com.wantensoup.prototype.Item;

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
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public void saveItem(Item _item) {
        this.itemRepository.save(_item);
    }

    @Override
    public Item getItemById(long _id) {
        Optional<Item> optional = itemRepository.findById(_id);
        Item item = null;

        //Checks to see if an item is present within the "items" table.
        if (optional.isPresent()) {
            item = optional.get();
        } else {
            throw new RuntimeException("Item not found for id: " + _id);
        }

        return item;
    }

    @Override
    public void deleteItemById(long _id) {
        this.itemRepository.deleteById(_id);
    }

}
