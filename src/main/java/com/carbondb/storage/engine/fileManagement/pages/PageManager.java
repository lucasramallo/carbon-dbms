package com.carbondb.storage.engine.fileManagement.pages;

import com.carbondb.storage.engine.domain.column.Field;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class PageManager {
    private List<Page> pages;
    private String BASE_DIRECTORY;

    public PageManager(String diretorioBase) {
        this.pages = new ArrayList<>();
        this.BASE_DIRECTORY = diretorioBase;
        loadpages();
    }

    public void adicionarCliente(HashMap<Integer, ArrayList<Field>> record) throws IOException {
        int id = record.keySet().iterator().next();

        for (Page page : pages) {
            if (page.adicionarRegistro(id, record, BASE_DIRECTORY + "/page_" + pages.indexOf(page) + ".dat")) {
                page.salvarParaArquivo(BASE_DIRECTORY + "/page_" + pages.indexOf(page) + ".dat");
                return;
            }
        }
        // Se todas as páginas estiverem cheias, cria uma nova página
        Page newPage = new Page();
        newPage.adicionarRegistro(id, record);
        pages.add(newPage);
        newPage.salvarParaArquivo(BASE_DIRECTORY + "/page_" + (pages.size() - 1) + ".dat");
    }

//    public Cliente buscarCliente(UUID uuid) throws IOException, ClassNotFoundException {
//        for (Page page : pages) {
//            Cliente cliente = page.buscarRegistro(uuid);
//            if (cliente != null) {
//                return cliente;
//            }
//        }
//        return null;
//    }

    public void print() {
        pages.forEach(page -> page.print());
    }

    private void loadpages() {
        File diretorio = new File(BASE_DIRECTORY);
        File[] arquivos = diretorio.listFiles((dir, name) -> name.startsWith("page_") && name.endsWith(".dat"));
        if (arquivos != null) {
            for (File arquivo : arquivos) {
                try {
                    Page page = Page.carregarDeArquivo(arquivo.getAbsolutePath());
                    pages.add(page);
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
