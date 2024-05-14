package com.carbondb.storage.engine.domain.tuple;

import com.carbondb.storage.engine.domain.types.Type;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tuple {
    private String name;

    private Type type;

    public Tuple(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    public Object getValue() {
        return type.getValue();
    }

    @Override
    public String toString() {
        return "Tuple{" +
                "name = '" + name + '\'' +
                ", type = " + type +
                '}';
    }
}
