package com.wantensoup.prototype.Table;

/**
 * Last Updated: 11/01/2022 
 * Class Purpose: Allows access to the data in the "tables" table in the 
 * database.
 * @author Atsoupe Bessou Kpeglo
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableRepository extends JpaRepository<RestTables, Integer>{
    
     public RestTables findByTableName(String _tableName);
     
}
