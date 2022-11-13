package com.wantensoup.prototype.OrderItems;

/**
 * Last Updated: 10/31/2022 
 * Class Purpose: Allows access to the data in the "items" table in the database.
 * @author Kristin Cattell
 */
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItems, Integer> {

    public List<OrderItems> findByItemName(String itemName);
    
}
