package com.wantensoup.prototype.Item;

/**
 * Last Updated: 10/31/2022 
 * Class Purpose: Allows access to the data in the "items" table in the database.
 * @author Kristin Cattell
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    public Item findByItemName(String _itemName);
    
}
