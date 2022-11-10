/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.wantensoup.prototype.Table;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Atsoupe Bessou Kpeglo
 */
@Repository
public interface TableRepository extends JpaRepository<RestTables, Long>{
    
     public RestTables findByTableName(String _tableName);
     
}
