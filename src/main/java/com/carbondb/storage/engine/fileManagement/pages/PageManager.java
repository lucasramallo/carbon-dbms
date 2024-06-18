package com.carbondb.storage.engine.fileManagement.pages;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PageManager {
    private List<Page> paginas;
    private String diretorioBase;

    public PageManager(String diretorioBase) {
        this.paginas = new ArrayList<>();
        this.diretorioBase = diretorioBase;
        carregarPaginas();
    }

    public void adicionarCliente(Cliente cliente) throws IOException {
        UUID uuid = cliente.getUuid();
        for (Page pagina : paginas) {
            if (pagina.adicionarRegistro(uuid, cliente, diretorioBase + "/pagina_" + paginas.indexOf(pagina) + ".dat")) {
                pagina.salvarParaArquivo(diretorioBase + "/pagina_" + paginas.indexOf(pagina) + ".dat");
                return;
            }
        }
        // Se todas as páginas estiverem cheias, cria uma nova página
        Page novaPagina = new Page();
        novaPagina.adicionarRegistro(uuid, cliente);
        paginas.add(novaPagina);
        novaPagina.salvarParaArquivo(diretorioBase + "/pagina_" + (paginas.size() - 1) + ".dat");
    }

    public Cliente buscarCliente(UUID uuid) throws IOException, ClassNotFoundException {
        for (Page pagina : paginas) {
            Cliente cliente = pagina.buscarRegistro(uuid);
            if (cliente != null) {
                return cliente;
            }
        }
        return null;
    }

    public void print() {
        paginas.forEach(page -> page.print());
    }

    private void carregarPaginas() {
        File diretorio = new File(diretorioBase);
        File[] arquivos = diretorio.listFiles((dir, name) -> name.startsWith("pagina_") && name.endsWith(".dat"));
        if (arquivos != null) {
            for (File arquivo : arquivos) {
                try {
                    Page pagina = Page.carregarDeArquivo(arquivo.getAbsolutePath());
                    paginas.add(pagina);
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
