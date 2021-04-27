package com.vacinacao.model;

import java.io.Serializable;
import java.util.Objects;

public class Cidadao implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;

    private String nome;

    private String genero;

    private int idade;

    public Cidadao(int id, String nome, String genero, int idade) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.idade = idade;
    }


    public Cidadao(int id, String nome) {
        this.id = id;
        this.nome = nome;
      
    }


    public Cidadao() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cidadao cidadao = (Cidadao) o;
        return id == cidadao.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Cidadao{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", genero=" + genero +
                ", idade=" + idade +
                '}';
    }
}
