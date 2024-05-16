package com.carbondb.storage.engine.domain.table;

import com.carbondb.storage.engine.domain.column.Column;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class Table {
    private String name;
    private HashMap<UUID, Column> tuples;
    private Column primaryKey;

    public Table(String name) {
        this.name = name;
        this.tuples = new HashMap<>();
    }

    public void addTuple(Column column) {
        UUID tupleId = UUID.randomUUID();
        tuples.put(tupleId, column);

        if(column.getIsPK() && primaryKey == null) {
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