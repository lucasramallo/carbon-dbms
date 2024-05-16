package com.carbondb.storage.engine.domain.column;

import com.carbondb.storage.engine.domain.types.Type;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Column<T>{
    private String name;

    private Type<T> type;

    private Boolean isPK;

    private HashMap<UUID, Type<T>> values;

    public Column(String name, Type<T> type) {
        this.name = name;
        this.type = type;
        this.isPK = false;
        this.values = new HashMap<>();
    }

    public Object getValue() {
        return type.getValue();
    }

    public List getValuesList() {
        List valuesArray = new ArrayList<>();

        values.forEach((id, type) -> valuesArray.add(type.getValue()));

        return valuesArray;
    }

    public void primaryKey() {
        setIsPK(true);
    }

    public void addValue(Type type) {
        values.put(UUID.randomUUID(), type);
    }

    @Override
    public String toString() {
        return "Tuple{" +
                "name = '" + name + '\'' +
                ", type = " + type +
                '}';
    }
}
