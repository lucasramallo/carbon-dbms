package com.carbondb;

import com.carbondb.storage.engine.domain.table.Table;
import com.carbondb.storage.engine.domain.tuple.Tuple;
import com.carbondb.storage.engine.domain.types.VarcharType;


public class Main {
    public static void main(String[] args) {
        Table table = new Table();
        Tuple tuple = new Tuple("name", new VarcharType("Lucas"));
        Tuple tuple2 = new Tuple("id", new VarcharType("75847367384"));

        tuple2.primaryKey();

        table.addTuple(tuple);
        table.addTuple(tuple2);

        System.out.println(table.getPrimaryKey());

        System.out.println(table.toString());
        System.out.println(tuple.getType().getValue());
    }
}