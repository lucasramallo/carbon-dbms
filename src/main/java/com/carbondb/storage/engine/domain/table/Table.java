package com.carbondb.storage.engine.domain.table;

import com.carbondb.storage.engine.domain.tuple.Tuple;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.util.random.RandomGeneratorFactory;

@Getter
@Setter
public class Table {
    private HashMap<UUID, Tuple> tuples;

    public Table() {
        this.tuples = new HashMap<>();
    }

    public void addTuple(Tuple tuple) {
        tuples.put(UUID.randomUUID(), tuple);
        System.out.println();
    }

    @Override
    public String toString() {
        return "Table {\n" +
                "   tuples = " + tuples + "\n" +
                '}';
    }
}