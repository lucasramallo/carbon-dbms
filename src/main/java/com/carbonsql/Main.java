package com.carbonsql;

import com.carbonsql.core.domain.table.Table;
import com.carbonsql.core.domain.tuple.Tuple;
import com.carbonsql.core.types.VarcharType;


public class Main {
    public static void main(String[] args) {
        Table table = new Table();
        Tuple tuple = new Tuple("name", new VarcharType("Lucas"));

        table.addTuple(tuple);

        System.out.println(table.getTuples().get(0).getValue());
        System.out.println(tuple.getType().getValue());
    }
}