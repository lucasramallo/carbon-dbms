package com.carbondb.storage.engine.domain.table;

import com.carbondb.storage.engine.domain.column.Field;
import com.carbondb.storage.engine.domain.types.Type;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

/**
 *  fields: these are the fields that are created as soon as the table is created.
 *  records: these are new fields that are created to create a record from the fields already defined.
 */
@Getter
@Setter
public class Table {
    private String name;
    private ArrayList<Field> fields;
    private HashMap<Field, ArrayList<Field>> records;

    public Table(String name) {
        this.name = name;
        this.fields = new ArrayList<>();
        this.records = new HashMap<>();
    }

    /**
     * @param data - Is a hashmap that have been contains:
     *             1. String as the key with the same name as the field;
     *             2. String with the field value to be added;
     */
    public void addRecord(HashMap<String, String> data) {
        ArrayList<Field> listOfRecordsWithoutPk = new ArrayList<>();
        ArrayList<Object> PK = new ArrayList<>();

        fields.forEach(keyField -> {
            Type type = keyField.getType().createNewKeyFieldType();

            String value = data.remove(keyField.getName());

            if(keyField.cannotBeNullable() && value == null) {
                throw new RuntimeException("Value " + keyField.getName() + " cannot be null");
            }

            type.setValue(value);
            Field newField = new Field<>(keyField.getName(), type);

            /*
                 If the newField is the record id, it is added to the ArrayList PK
                 to be retrieved and serve as the key of the hashmap records.
             */
            if(newField.getName().equals("id")) {
                PK.add(newField);
                return;
            }

            listOfRecordsWithoutPk.add(newField);
        });

        records.put((Field) PK.get(0), listOfRecordsWithoutPk);
    }

    public void addColumn(Field field) {
        fields.add(field);
    }

    @Override
    public String toString() {
        return "Table {\n" +
                "   tuples = " + fields + "\n" +
                '}';
    }
}