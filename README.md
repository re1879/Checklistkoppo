# Sistema de Checklist de Tarefas Diárias

Este repositório contém um mini sistema em Java para o gerenciamento de tarefas diárias. O projeto utiliza interface gráfica (Swing) e persistência de dados binária.

## 📝 Descrição
O sistema permite criar uma lista de tarefas, marcar como concluídas, remover itens e salvar tudo em um arquivo para não perder os dados ao fechar o programa.

## 🚀 Funcionalidades
- **Cadastro**: Adicionar tarefas.
- **Listagem**: Ver todas as tarefas.
- **Remoção**: Apagar tarefas.
- **Persistência**: Salvar e Carregar dados de arquivo.

## 📂 Estrutura do Projeto (Pasta src)
- `SistemaChecklist.java`: Interface do sistema.
- `ChecklistManager.java`: Classe principal (Lógica).
- `Tarefa.java`: Classe básica (Serializable).
- `GravadorDeDados.java`: Gravação de arquivos.
- `ChecklistGUI.java`: Interface Gráfica (Janela).
- `TesteSimples.java`: Classe para testar as funcionalidades via console.

## 🛠️ Tecnologias
- Java JDK 
- Java Swing 
- Java I/O 