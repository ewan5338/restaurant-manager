/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wantensoup.prototype.Table;

import java.util.List;

/**
 *
 * @author Atsoupe Bessou Kpeglo
 */

public interface TableService {
    
    List<RestTables> getAllTables();
    
    void saveTable (RestTables table);
    
    RestTables getTableById(long id);
    
    void deleteTableByNumber(long number);
    
}
