package com.wantensoup.prototype.Menu;

/**
 * Last Updated: 11/14/2022
 * Class Purpose: Allows access to the data in the "menu_items" table in the 
 * database.
 * @author Kristin Cattell
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer>{
    
    public Menu findByMenuItem(String menuItem);
    
}