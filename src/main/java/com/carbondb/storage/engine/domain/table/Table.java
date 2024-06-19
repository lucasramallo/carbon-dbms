package com.carbondb.storage.engine.domain.table;

import com.carbondb.storage.engine.domain.column.Field;
import com.carbondb.storage.engine.domain.types.Type;
import com.carbondb.storage.engine.fileManagement.pages.PageManager;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
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
    private HashMap<Integer, ArrayList<Field>> records;

    private PageManager pageManager;

    /**
     Estrutura de um Registro

     ID: Identificador único (UUID, chave primária, etc.).
     Nome da Tabela: String que representa o nome da tabela.
     Carimbo de Tempo: Data e hora de criação ou modificação.
     Versão: Número da versão do registro.
     Campos de Dados:
     Campo 1: Valor do campo 1
     Campo 2: Valor do campo 2
     ...
     Campo N: Valor do campo N
     Referências de Índice: Posições ou ponteiros para entradas de índices.
     Ponteiros para Dados Adicionais: Ponteiros para outras páginas ou arquivos que contêm partes do registro (se necessário).
     */

    public Table(String name, PageManager pageManager) {
        this.name = name;
        this.fields = new ArrayList<>();
        this.records = new HashMap<>();
        this.pageManager = pageManager;
    }

    /**
     * @param data - Is a hashmap that have been contains:
     *             1. String as the key with the same name as the field;
     *             2. String with the field value to be added;
     */
    public void addRecord(HashMap<String, String> data) throws IOException {
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

        records.put(1, listOfRecordsWithoutPk);

        HashMap<Integer, ArrayList<Field>> recordToSave = new HashMap<>();
        recordToSave.put(1, listOfRecordsWithoutPk);

        save(recordToSave);
    }

    public void addColumn(Field field) {
        fields.add(field);
    }

    public void save(HashMap<Integer, ArrayList<Field>> recordToSave) throws IOException {
        pageManager.adicionarCliente(recordToSave);
    }

    @Override
    public String toString() {
        return "Table {\n" +
                "   tuples = " + fields + "\n" +
                '}';
    }
}