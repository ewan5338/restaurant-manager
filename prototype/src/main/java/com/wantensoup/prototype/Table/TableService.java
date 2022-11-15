package com.wantensoup.prototype.Table;

/**
 * Last Updated: 11/01/2022 
 * Class Purpose: Defines the functionality of RestTables objects.
 * @author Atsoupe Bessou Kpeglo
 */
import java.util.List;

public interface TableService {
    
    List<RestTables> getAllTables();
    
    void saveTable (RestTables table);
    
    RestTables getTableById(Integer id);
    
    void deleteTableByNumber(Integer number);
    
}
