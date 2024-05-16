package com.carbondb;

import com.carbondb.storage.engine.domain.table.Table;
import com.carbondb.storage.engine.domain.column.Column;
import com.carbondb.storage.engine.domain.types.VarcharType;
import com.carbondb.storage.engine.domain.util.PrintTable;


public class Main {
    public static void main(String[] args) {
        Table table = new Table("Users");
        Column<VarcharType> column = new Column("name", new VarcharType());
        Column<VarcharType> column2 = new Column("id", new VarcharType());

        column2.primaryKey();

        table.addTuple(column);
        table.addTuple(column2);
        column.addValue(new VarcharType("Lucas"));
        column.addValue(new VarcharType("Maria"));

        System.out.println(table.getPrimaryKey());

        System.out.println(table);

        PrintTable printTable = new PrintTable(table.getName());
        printTable.addColumn(table.getTuples());
        printTable.addRow(table.getTuples());

        System.out.println(printTable);
    }
}