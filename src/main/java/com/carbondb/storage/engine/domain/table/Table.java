package com.carbondb.storage.engine.domain.table;

import com.carbondb.storage.engine.domain.tuple.Tuple;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class Table {
    private HashMap<UUID, Tuple> tuples;
    private Tuple primaryKey;

    public Table() {
        this.tuples = new HashMap<>();
    }

    public void addTuple(Tuple tuple) {
        UUID tupleId = UUID.randomUUID();
        tuples.put(tupleId, tuple);

        if(tuple.getIsPK()) {
            this.primaryKey = tuples.get(tupleId);
        }
    }

    @Override
    public String toString() {
        return "Table {\n" +
                "   tuples = " + tuples + "\n" +
                '}';
    }
}