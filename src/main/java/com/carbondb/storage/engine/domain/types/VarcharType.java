package com.carbondb.storage.engine.domain.types;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class VarcharType implements Type {
    private String value;

    public VarcharType(String value) {
        if(value.getBytes().length > 8000) {
            throw new IllegalArgumentException("VARCHAR EXCEPTION: Data size exceeds 8000 bytes");
        }

        this.value = value;
    }

    @Override
    public String getValue()
    {
        return value;
    }
}
