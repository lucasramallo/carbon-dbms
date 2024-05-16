package com.carbondb.storage.engine.domain.table;

import com.carbondb.storage.engine.domain.column.Field;
import com.carbondb.storage.engine.domain.types.Type;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class Table {
    private String name;
    private ArrayList<Field> fields;
    private HashMap<Field, ArrayList<Field>> records;

    public Table(String name) {
        this.name = name;
        this.fields = new ArrayList();
        this.records = new HashMap<>();
    }

    /**
     *  fields: these are the fields that are created as soon as the table is created.
     *  records: these are new fields that are created to create a record from the fields already defined.
     */

    public void addRecord(HashMap<String, String> data) {
        ArrayList<Field> listOfRecordsWithoutPk = new ArrayList<>();
        ArrayList<Object> PK = new ArrayList<>();

        fields.forEach(keyField -> {
            Type type = keyField.getType().createNewKeyFieldType(); // cria um novo tipo da keyField para o FieldValue
            String keyFieldValue = data.remove(keyField.getName()); // pega o valor recebido correspondente a key field

            if(keyField.cannotBeNullable() && keyFieldValue == null) { // Exception caso o calor seja null e a key field for notNull
                throw new RuntimeException("Value " + keyField.getName() + " cannot be null");
            }

            type.setValue(keyFieldValue);
            Field newField = new Field<>(keyField.getName(), type);

            if(newField.getName().equals("id")) {
                /**
                    if the newField is the record id, it is added to the ArrayList PK
                    to be retrieved and serve as the key of the hashmap records.
                 */
                PK.add(newField);
                return;
            }

            listOfRecordsWithoutPk.add(newField);
        });

        records.put((Field) PK.get(0), listOfRecordsWithoutPk);
    }

    //TODO: GARANTIR QUE A PK SEMPRE FIQUE NA POSIÇÃO 0
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