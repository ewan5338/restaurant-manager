package com.wantensoup.prototype.Table;

/**
 * Last Updated: 11/01/2022
 * Class Purpose: Implements the functionality of RestTable objects.
 * @author Atsoupe Bessou Kpeglo
 */
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TableServiceImpl implements TableService{
    
    @Autowired
    private TableRepository tableRepository;

    @Override
    public List<RestTables> getAllTables() {
        return tableRepository.findAll();
    }

    @Override
    public void saveTable(RestTables table) {
        this.tableRepository.save(table);
    }
    
    @Override
    public RestTables getTableById(Integer number) {
        Optional<RestTables> optional = tableRepository.findById(number);
        RestTables table = null;
        
         if (optional.isPresent()) {
            table = optional.get();
        } else {
            throw new RuntimeException("Item not found for table number: " + number);
        }
         return table;
    }

    @Override
    public void deleteTableByNumber(Integer number) {
        
    }
    
}
