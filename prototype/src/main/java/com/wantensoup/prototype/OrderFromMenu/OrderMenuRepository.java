package com.wantensoup.prototype.OrderFromMenu;

/**
 * Last Updated: 11/13/2022 
 * Class Purpose: Allows access to the data in the "table_carts" table in the database.
 * @author Ewan Allen, Kristin Cattell
 */
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMenuRepository extends JpaRepository<OrderMenu, Integer> {

    public List<OrderMenu> findByItemName(String itemName);
    
}
