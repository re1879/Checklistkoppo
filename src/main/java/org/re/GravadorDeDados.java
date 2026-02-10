package org.re;

import java.io.*;
import java.util.Map;

public class GravadorDeDados {

    public void salvar(Map<String, Tarefa> tarefas, String nomeArquivo) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            out.writeObject(tarefas);
        }
    }

    @SuppressWarnings("unchecked")
    public Map<String, Tarefa> recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            return (Map<String, Tarefa>) in.readObject();
        }
    }
}
