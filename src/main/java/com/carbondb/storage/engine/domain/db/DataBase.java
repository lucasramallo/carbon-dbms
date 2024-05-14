package com.carbondb.storage.engine.domain.db;

import com.carbondb.storage.engine.domain.table.Table;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.UUID;

public class DataBase {
    private String name;
    private HashMap<UUID, Table> tables;
    private Integer numberOfTables;
    private Float size;
    private Integer numberOfRecords;
    private String Location;
    private LocalDate createdAt;
}
