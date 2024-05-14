package com.carbonsql.core.domain.table;

import com.carbonsql.core.domain.tuple.Tuple;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Table {
    private List<Tuple> tuples;

    public Table() {
        this.tuples = new ArrayList<>();
    }

    public void addTuple(Tuple tuple) {
        tuples.add(tuple);
    }
}
