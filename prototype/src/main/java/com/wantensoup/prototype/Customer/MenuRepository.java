/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.wantensoup.prototype.Customer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ewan
 */

@Repository
public interface MenuRepository extends JpaRepository<CustMenu, Long>{
    public CustMenu findByMenuName(String mealName);
}

//