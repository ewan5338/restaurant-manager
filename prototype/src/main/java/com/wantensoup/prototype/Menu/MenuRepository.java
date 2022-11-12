package com.wantensoup.prototype.Menu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ewan
 */

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long>{
    
    public Menu findByMenuItem(String menuItem);
    
}