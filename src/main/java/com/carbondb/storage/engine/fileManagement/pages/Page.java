package com.carbondb.storage.engine.fileManagement.pages;

import com.carbondb.storage.engine.domain.column.Field;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Page implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final int LIMITE_TAMANHO = 4096; // Definindo um limite de tamanho para a página (em bytes)
    private ArrayList<HashMap<Integer, ArrayList<Field>>> registros;
    private int tamanhoAtual;

    public Page() {
        this.registros = new ArrayList<>();
        this.tamanhoAtual = 0;
    }

    public boolean adicionarRegistro(Integer id, HashMap<Integer, ArrayList<Field>> record, String path) {
        int tamanhoRegistro = calcularTamanhoRegistro(record);
        if (tamanhoAtual + tamanhoRegistro > LIMITE_TAMANHO) {
            return false;
        }
        read(path);
        registros.add(record);
        tamanhoAtual += tamanhoRegistro;
        return true;
    }

    public boolean adicionarRegistro(Integer id, HashMap<Integer, ArrayList<Field>> record) {
        int tamanhoRegistro = calcularTamanhoRegistro(record);
        if (tamanhoAtual + tamanhoRegistro > LIMITE_TAMANHO) {
            return false;
        }
        registros.add(record);
        tamanhoAtual += tamanhoRegistro;
        return true;
    }

    public void print() {
        registros.forEach(registro -> System.out.println(registro));
    }

//    public Cliente buscarRegistro(UUID uuid) {
//        return registros.get(uuid);
//    }

    private int calcularTamanhoRegistro(HashMap<Integer, ArrayList<Field>> record) {
        // Serializar o cliente e calcular o tamanho
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeObject(record);
            oos.flush();
            return baos.toByteArray().length;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static Page carregarDeArquivo(String nomeArquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            return (Page) ois.readObject();
        }
    }

    public void read(String path) {
        try {
            File arq = new File(path);
            if (arq.exists()) {
                ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(arq));
                // Assuming registros is a class member variable
                Page page = (Page) objInput.readObject();

                this.registros.addAll(page.registros);

                objInput.close();
            }
        } catch(IOException erro1) {
            System.out.printf("Erro: %s\n", erro1.getMessage());
        } catch(ClassNotFoundException erro2) {
            System.out.printf("Erro: %s\n", erro2.getMessage());
        }
    }


    public void salvarParaArquivo(String nomeArquivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            oos.writeObject(this);
        }
    }
}
