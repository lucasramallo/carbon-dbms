package com.carbondb.storage.engine.domain.types;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class VarcharType implements Type<String> {
    private String value;
    private final String name = "Varchar";

    public VarcharType(String value) {
        if(value.getBytes().length > 8000) {
            throw new IllegalArgumentException("VARCHAR EXCEPTION: Data size exceeds 8000 bytes");
        }

        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }

    public VarcharType createNewKeyFieldType() {
        return new VarcharType();
    }

    @Override
    public String toString() {
        return "VarcharType{" +
                "value='" + value + '\'' +
                '}';
    }
}
