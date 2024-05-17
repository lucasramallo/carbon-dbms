package com.carbondb.storage.engine.domain.types;

public interface Type<T> {
    public T getValue();
    public void setValue(String value);
    public VarcharType createNewKeyFieldType();
    public String getName();
}
