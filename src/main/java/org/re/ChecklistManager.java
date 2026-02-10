package org.re;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ChecklistManager implements SistemaChecklist {

    private Map<String, Tarefa> mapaTarefas;
    private GravadorDeDados gravador;
    private final String ARQUIVO_DADOS = "dados_checklist.dat";

    public ChecklistManager() {
        this.mapaTarefas = new HashMap<>();
        this.gravador = new GravadorDeDados();
    }

    @Override
    public void adicionarTarefa(String titulo) {
        if (!mapaTarefas.containsKey(titulo)) {
            mapaTarefas.put(titulo, new Tarefa(titulo));
        }
    }

    @Override
    public Collection<Tarefa> listarTarefas() {
        return mapaTarefas.values();
    }

    @Override
    public void removerTarefa(String titulo) throws TarefaInexistenteException {
        if (!mapaTarefas.containsKey(titulo)) {
            throw new TarefaInexistenteException("Tarefa não encontrada: " + titulo);
        }
        mapaTarefas.remove(titulo);
    }

    @Override
    public void alternarStatusTarefa(String titulo) throws TarefaInexistenteException {
        if (!mapaTarefas.containsKey(titulo)) {
            throw new TarefaInexistenteException("Tarefa não encontrada: " + titulo);
        }
        Tarefa t = mapaTarefas.get(titulo);
        t.alternarStatus();
    }

    @Override
    public void salvarDados() throws IOException {
        gravador.salvar(this.mapaTarefas, ARQUIVO_DADOS);
    }

    @Override
    public void recuperarDados() throws IOException, ClassNotFoundException {
        this.mapaTarefas = gravador.recuperar(ARQUIVO_DADOS);
    }

    // Método auxiliar para testes
    public int contarTarefas() {
        return mapaTarefas.size();
    }
}