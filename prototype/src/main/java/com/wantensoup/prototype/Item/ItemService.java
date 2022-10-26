/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.wantensoup.prototype.Item;

import java.util.List;

/**
 *
 * @author garca
 */
public interface ItemService {
    List<Item> getAllItems();
    
    void saveItem(Item item);
    
    Item getItemById(long ID);
    
    void deleteItemById(long ID);
}
