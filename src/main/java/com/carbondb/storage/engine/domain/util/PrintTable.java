package com.carbondb.storage.engine.domain.util;

import com.carbondb.storage.engine.domain.column.Field;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class PrintTable {
    private String tableName;
    private List<List<Object>> columns;
    private List<List<Object>> rows;

    public PrintTable(String tableName) {
        this.tableName = tableName;
        this.columns = new ArrayList<>();
        this.rows = new ArrayList<>();
    }

    public void addColumn(ArrayList<Field> fields) {
        fields.forEach(field -> {
            ArrayList<Object> values = new ArrayList<>();

            values.add(field.getName());
            values.add(field.getTypeName());

            columns.add(values);
        });
    }

    public void addRow(HashMap<Field, ArrayList<Field>> hashMapcolumns) {
        hashMapcolumns.forEach((id, valuesList) -> {
            ArrayList<Object> values = new ArrayList<>();
            values.add(id.getValue());
            valuesList.forEach(field -> {
                values.add(field.getValue());
            });

            rows.add(values);
        });

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Table: ").append(tableName).append("\n");

        // Header row
        sb.append("┌");
        for (List<Object> column : columns) {
            sb.append("──────────────────────────────┬");
        }
        sb.deleteCharAt(sb.length() - 1); // Remove o último caractere "|"
        sb.append("┐\n");

        // Columns
        sb.append("│");
        for (List<Object> column : columns) {
            sb.append(String.format("%20s (%-5s)│", column.get(0), column.get(1)));
        }
        sb.append("\n");

        // Linha divisória
        sb.append("├");
        for (List<Object> column : columns) {
            for (int i = 0; i < 30; i++) {
                sb.append("─");
            }
            sb.append("┼");
        }
        sb.deleteCharAt(sb.length() - 1); // Remove o último caractere "|"
        sb.append("┤\n");

        // Dados das linhas
        for (List<Object> row : rows) {
            sb.append("│");
            for (Object cell : row) {
                sb.append(String.format("%30s│", cell.toString()));
            }
            sb.append("\n");
        }

        // Rodapé da tabela
        sb.append("└");
        for (List<Object> column : columns) {
            for (int i = 0; i < 30; i++) {
                sb.append("─");
            }
            sb.append("┴");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("┘\n");

        return sb.toString();
    }
}













//package com.carbondb.storage.engine.domain.util;
//
//import com.carbondb.storage.engine.domain.column.Field;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.UUID;
//
//public class PrintTable {
//    private String tableName;
//    private List<String> columns;
//    private List<List<Object>> rows;
//
//    public PrintTable(String tableName) {
//        this.tableName = tableName;
//        this.columns = new ArrayList<>();
//        this.rows = new ArrayList<>();
//    }
//
//    public void addColumn(ArrayList<Field> fields) {
//        fields.forEach(field -> columns.add(field.getName()));
//    }
//
//    public void addRow(HashMap<Field, ArrayList<Field>> hashMapcolumns) {
//        hashMapcolumns.forEach((id, valuesList) -> {
//            ArrayList<Object> values = new ArrayList<>();
//            values.add(id.getValue());
//            valuesList.forEach(field -> {
//                values.add(field.getValue());
//            });
//
//            rows.add(values);
//            System.out.println(values);
//        });
//
//        System.out.println("=>" + rows);
//    }
//
//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append("Table: ").append(tableName).append("\n");
//
//        // Header row
//        sb.append("┌");
//        for (String column : columns) {
//            sb.append("──────────────────────────────┬");
//        }
//        sb.deleteCharAt(sb.length() - 1); // Remove o último caractere "|"
//        sb.append("┐\n");
//
//        // Columns
//        sb.append("│");
//        for (String column : columns) {
//            sb.append(String.format("%30s│", column));
//        }
//        sb.append("\n");
//
//        // Linha divisória
//        sb.append("├");
//        for (String column : columns) {
//            for (int i = 0; i < 30; i++) {
//                sb.append("─");
//            }
//            sb.append("┼");
//        }
//        sb.deleteCharAt(sb.length() - 1); // Remove o último caractere "|"
//        sb.append("┤\n");
//
//        // Dados das linhas
//        for (List<Object> row : rows) {
//            sb.append("│");
//            for (Object cell : row) {
//                sb.append(String.format("%30s│", cell.toString()));
//            }
//            sb.append("\n");
//        }
//
//        // Rodapé da tabela
//        sb.append("└");
//        for (String column : columns) {
//            for (int i = 0; i < 30; i++) {
//                sb.append("─");
//            }
//            sb.append("┴");
//        }
//        sb.deleteCharAt(sb.length() - 1);
//        sb.append("┘\n");
//
//        return sb.toString();
//    }
//}
