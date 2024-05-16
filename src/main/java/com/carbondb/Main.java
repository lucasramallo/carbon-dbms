package com.carbondb;

import com.carbondb.storage.engine.domain.table.Table;
import com.carbondb.storage.engine.domain.column.Field;
import com.carbondb.storage.engine.domain.types.VarcharType;

import java.util.HashMap;


public class Main {
    public static void main(String[] args) {
        Table table = new Table("Users");
        Field<VarcharType> field = new Field("id", new VarcharType());
        Field<VarcharType> field2 = new Field("name", new VarcharType());
        Field<VarcharType> field3 = new Field("age", new VarcharType());
        field.primaryKey();
        field2.setNotNull(true);

        table.addColumn(field);
        table.addColumn(field2);
        table.addColumn(field3);

        HashMap<String, String> data = new HashMap<>();

        data.put("id", "61h3-2hd3-ej34-37ej");
        data.put("age", "19");

        table.addRecord(data);

        System.out.println(table.getRecords());
    }
}