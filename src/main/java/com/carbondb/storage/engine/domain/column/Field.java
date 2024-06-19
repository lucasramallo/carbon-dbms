package com.carbondb.storage.engine.domain.column;

import com.carbondb.storage.engine.domain.types.Type;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class Field<T> implements Serializable {
    private String name;

    private Type<T> type;

    private Boolean isPK;

    private Boolean notNull;

    public Field(String name, Type<T> type) {
        this.name = name;
        this.type = type;
        this.isPK = false;
        this.notNull = false;
    }

    public Object getValue() {
        return type.getValue();
    }

    public String getTypeName() {
        return type.getName();
    }

    public void primaryKey() {
        setIsPK(true);
    }

    public boolean cannotBeNullable() {
        return this.notNull;
    }

    @Override
    public String toString() {
        return "Tuple{" +
                "name = '" + name + '\'' +
                ", type = " + type +
                '}';
    }
}
