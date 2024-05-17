package com.carbondb.storage.engine.domain.types;

public interface Type<T> {
    public T getValue();
    public void setValue(String value);

    /**
     * @return Creates and returns a new empty instance of Type of the same type as the field.
     */
    public VarcharType createNewKeyFieldType();
    public String getName();
}
