package org.re;

import java.util.Collection;

public class TesteSimples {

    public static void main(String[] args) {
        System.out.println("=== Iniciando Testes do Sistema de Checklist ===");

        ChecklistManager sistema = new ChecklistManager();

        try {
            // 1. Teste de Cadastro
            System.out.print("Testando Cadastro... ");
            sistema.adicionarTarefa("Comprar leite");
            sistema.adicionarTarefa("Pagar conta de luz");

            if (sistema.contarTarefas() == 2) {
                System.out.println("[OK]");
            } else {
                System.out.println("[FALHOU]");
            }

            // 2. Teste de Pesquisa
            System.out.print("Testando Pesquisa... ");
            Collection<Tarefa> lista = sistema.listarTarefas();
            boolean achou = false;
            for (Tarefa t : lista) {
                if (t.getTitulo().equals("Comprar leite")) {
                    achou = true;
                    break;
                }
            }

            if (achou) {
                System.out.println("[OK]");
            } else {
                System.out.println("[FALHOU] - Tarefa não encontrada.");
            }

            // 3. Teste de Remoção
            System.out.print("Testando Remoção... ");
            sistema.removerTarefa("Comprar leite");

            if (sistema.contarTarefas() == 1) {
                System.out.println("[OK]");
            } else {
                System.out.println("[FALHOU] - Contagem errada após remoção.");
            }

        } catch (TarefaInexistenteException e) {
            System.out.println("\n[ERRO] Ocorreu uma exceção inesperada: " + e.getMessage());
        }

        System.out.println("\n=== Fim dos Testes ===");
    }
}