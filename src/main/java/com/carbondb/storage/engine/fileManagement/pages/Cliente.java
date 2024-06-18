package com.carbondb.storage.engine.fileManagement.pages;

import java.io.Serializable;
import java.util.UUID;

public class Cliente implements Serializable {
    private UUID uuid;
    private String nome;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    private int idade;

    public Cliente(UUID uuid, String nome, int idade) {
        this.uuid = uuid;
        this.nome = nome;
        this.idade = idade;
    }


}
