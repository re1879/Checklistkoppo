package org.re;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ChecklistGUI extends JFrame {
    private ChecklistManager manager;
    private DefaultListModel<Tarefa> listModel;
    private JList<Tarefa> listTarefas;
    private JTextField txtTitulo;

    public ChecklistGUI() {
        manager = new ChecklistManager();
        listModel = new DefaultListModel<>();

        setTitle("Checklist de Tarefas Diárias");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel Superior (Input)
        JPanel panelInput = new JPanel(new FlowLayout());
        txtTitulo = new JTextField(20);
        JButton btnAdicionar = new JButton("Adicionar");

        panelInput.add(new JLabel("Tarefa:"));
        panelInput.add(txtTitulo);
        panelInput.add(btnAdicionar);

        // Lista Central
        listTarefas = new JList<>(listModel);
        add(new JScrollPane(listTarefas), BorderLayout.CENTER);
        add(panelInput, BorderLayout.NORTH);

        // Painel Inferior (Botoes de Ação)
        JPanel panelBotoes = new JPanel(new FlowLayout());
        JButton btnConcluir = new JButton("Concluir/Reabrir");
        JButton btnRemover = new JButton("Remover");
        JButton btnSalvar = new JButton("Salvar Dados");
        JButton btnCarregar = new JButton("Carregar Dados");

        panelBotoes.add(btnConcluir);
        panelBotoes.add(btnRemover);
        panelBotoes.add(btnSalvar);
        panelBotoes.add(btnCarregar);
        add(panelBotoes, BorderLayout.SOUTH);

        // Ações
        btnAdicionar.addActionListener(e -> {
            String titulo = txtTitulo.getText();
            if (!titulo.isEmpty()) {
                manager.adicionarTarefa(titulo);
                atualizarLista();
                txtTitulo.setText("");
            }
        });

        btnConcluir.addActionListener(e -> {
            Tarefa selecionada = listTarefas.getSelectedValue();
            if (selecionada != null) {
                try {
                    manager.alternarStatusTarefa(selecionada.getTitulo());
                    atualizarLista();
                    listTarefas.repaint();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
            }
        });

        btnRemover.addActionListener(e -> {
            Tarefa selecionada = listTarefas.getSelectedValue();
            if (selecionada != null) {
                try {
                    manager.removerTarefa(selecionada.getTitulo());
                    atualizarLista();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
            }
        });

        btnSalvar.addActionListener(e -> {
            try {
                manager.salvarDados();
                JOptionPane.showMessageDialog(this, "Dados salvos com sucesso!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Erro ao salvar: " + ex.getMessage());
            }
        });

        btnCarregar.addActionListener(e -> {
            try {
                manager.recuperarDados();
                atualizarLista();
                JOptionPane.showMessageDialog(this, "Dados carregados!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao carregar (talvez o arquivo não exista ainda).");
            }
        });
    }

    private void atualizarLista() {
        listModel.clear();
        for (Tarefa t : manager.listarTarefas()) {
            listModel.addElement(t);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ChecklistGUI().setVisible(true);
        });
    }
}