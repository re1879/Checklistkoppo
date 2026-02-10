package org.re;

import java.io.IOException;
import java.util.Collection;

public interface SistemaChecklist {
    public void adicionarTarefa(String titulo);
    public Collection<Tarefa> listarTarefas();
    public void removerTarefa(String titulo) throws TarefaInexistenteException;
    public void alternarStatusTarefa(String titulo) throws TarefaInexistenteException;
    public void salvarDados() throws IOException;
    public void recuperarDados() throws IOException, ClassNotFoundException;
}