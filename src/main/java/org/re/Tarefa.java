package org.re;

import java.io.Serializable;

public class Tarefa implements Serializable {
    private static final long serialVersionUID = 1L;
    private String titulo;
    private boolean concluida;

    public Tarefa(String titulo) {
        this.titulo = titulo;
        this.concluida = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    public void alternarStatus() {
        this.concluida = !this.concluida;
    }

    @Override
    public String toString() {
        return (concluida ? "[X] " : "[ ] ") + titulo;
    }
}