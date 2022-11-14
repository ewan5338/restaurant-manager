package com.wantensoup.prototype.OrderFromMenu;

/**
 * Last Updated: 10/31/2022 
 * Class Purpose: Allows access to the data in the "items" table in the database.
 * @author Kristin Cattell
 */
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMenuRepository extends JpaRepository<OrderMenu, Integer> {

    public List<OrderMenu> findByItemName(String itemName);
    
}
