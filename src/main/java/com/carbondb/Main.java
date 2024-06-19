package com.carbondb;

import com.carbondb.storage.engine.domain.table.Table;
import com.carbondb.storage.engine.domain.column.Field;
import com.carbondb.storage.engine.domain.types.VarcharType;
import com.carbondb.storage.engine.domain.util.PrintTable;
import com.carbondb.storage.engine.fileManagement.pages.Cliente;
import com.carbondb.storage.engine.fileManagement.pages.PageManager;

import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;


public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        Table table = new Table("Users");

//        Field<VarcharType> field = new Field("id", new VarcharType());
//        Field<VarcharType> field2 = new Field("name", new VarcharType());
//        Field<VarcharType> field3 = new Field("age", new VarcharType());
//        field.primaryKey();
//        field2.setNotNull(true);
//
//        table.addColumn(field);
//        table.addColumn(field2);
//        table.addColumn(field3);
//
//        HashMap<String, String> data = new HashMap<>();
//
//        data.put("name", "Lucas");
//        data.put("id", "61h3-2hd3-ej34-37ej");
//        data.put("age", "19");
//
//        HashMap<String, String> data2 = new HashMap<>();
//
//        data2.put("name", "Maria");
//        data2.put("id", "6e45-4h53-lo94-hr63");
//        data2.put("age", "18");
//
//        HashMap<String, String> data3 = new HashMap<>();
//
//        data3.put("name", "Julia");
//        data3.put("id", "gh4y-h6gf-fr67-hmhd");
//        data3.put("age", "22");
//
//        table.addRecord(data);
//        table.addRecord(data2);
//        table.addRecord(data3);
//
//        System.out.println(table.getRecords());
//
//        PrintTable printTable = new PrintTable("Users");
//        printTable.addColumn(table.getFields());
//        printTable.addRow(table.getRecords());
//
//        System.out.println(printTable);


//        Cliente cliente = new Cliente(UUID.randomUUID(), "Lucas", 19);
//        Cliente cliente3 = new Cliente(UUID.randomUUID(), "Maria", 19);
//        PageManager manager = new PageManager("../data-base-management-system/src/main/java/com/carbondb/storage/engine/fileManagement/pages.");
//        manager.adicionarCliente(cliente);
//        manager.adicionarCliente(cliente3);
//        UUID id = cliente.getUuid();



        PageManager manager = new PageManager("../data-base-management-system/src/main/java/com/carbondb/storage/engine/fileManagement/pages");
        Table table = new Table("Users", manager);

        Field<VarcharType> field = new Field("name", new VarcharType());
        Field<VarcharType> field2 = new Field("age", new VarcharType());
        table.addColumn(field);
        table.addColumn(field2);

        HashMap<String, String> data = new HashMap<>();
        data.put("name", "Lucas");
        data.put("age", "19");

        table.addRecord(data);

        manager.print();
    }
}