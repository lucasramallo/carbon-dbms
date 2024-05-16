package com.carbondb.storage.engine.domain.util;

import com.carbondb.storage.engine.domain.column.Column;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class PrintTable {
    private String tableName;
    private List<String> columns;
    private List<List<Object>> rows;

    public PrintTable(String tableName) {
        this.tableName = tableName;
        this.columns = new ArrayList<>();
        this.rows = new ArrayList<>();
    }

    public void addColumn(HashMap<UUID, Column> hashMapcolumns) {
        hashMapcolumns.forEach((id, column) -> columns.add(column.getName()));
    }

    public void addRow(HashMap<UUID, Column> hashMapcolumns) {
        List values = new ArrayList<>();

        hashMapcolumns.forEach((id, column) -> rows.add(
                column.getValuesList()
        ));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Table: ").append(tableName).append("\n");

        // Header row
        sb.append("┌");
        for (String column : columns) {
            sb.append("────────────┬");
        }
        sb.deleteCharAt(sb.length() - 1); // Remove o último caractere "|"
        sb.append("┐\n");

        // Columns
        sb.append("│");
        for (String column : columns) {
            sb.append(String.format("%12s│", column));
        }
        sb.append("\n");

        // Linha divisória
        sb.append("├");
        for (String column : columns) {
            for (int i = 0; i < 12; i++) {
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
                sb.append(String.format("%12s│", cell.toString()));
            }
            sb.append("\n");
        }

        // Rodapé da tabela
        sb.append("└");
        for (String column : columns) {
            for (int i = 0; i < 12; i++) {
                sb.append("─");
            }
            sb.append("┴");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("┘\n");

        return sb.toString();
    }
}
