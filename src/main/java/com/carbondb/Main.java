package com.carbondb;

import com.carbondb.storage.engine.domain.table.Table;
import com.carbondb.storage.engine.domain.tuple.Tuple;
import com.carbondb.storage.engine.domain.types.VarcharType;


public class Main {
    public static void main(String[] args) {
        Table table = new Table();
        Tuple tuple = new Tuple("name", new VarcharType("Lucas"));

        table.addTuple(tuple);

        System.out.println(table.toString());
        System.out.println(tuple.getType().getValue());
    }
}