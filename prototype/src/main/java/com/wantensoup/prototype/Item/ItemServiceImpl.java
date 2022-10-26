/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wantensoup.prototype.Item;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author garca
 */

@Service
public class ItemServiceImpl implements ItemService{
    
    @Autowired
    private ItemRepository itemRepository;
    
    @Override
    public List<Item> getAllItems() {
       return itemRepository.findAll();
    }

    @Override
    public void saveItem(Item item) {
        this.itemRepository.save(item);
    }

    @Override
    public Item getItemById(long id) {
        Optional<Item> optional = itemRepository.findById(id);
        Item item = null;
        if(optional.isPresent()) {
            item = optional.get();
        } else {
            throw new RuntimeException("Item not found for id: " + id);
        }
        return item;
    }

    @Override
    public void deleteItemById(long ID) {
        this.itemRepository.deleteById(ID);
    }
    
}
