package com.example.app_disciplinas.model;

public class Disciplina {
    public String nome;
    public int periodo;
    public int dificuldade;

    public Disciplina(String nome, int periodo, int dificuldade) {
        this.nome = nome;
        this.periodo = periodo;
        this.dificuldade = dificuldade;
    }

    public String getNome() {
        return nome;
    }

    public int getPeriodo() {
        return periodo;
    }

    public int getDificuldade() {
        return dificuldade;
    }


}
