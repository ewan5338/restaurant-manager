/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wantensoup.prototype.Table;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Atsoupe Bessou kpeglo
 */
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
    public RestTables getTableById(long number) {
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
    public void deleteTableByNumber(long number) {
        
    }
    
}
