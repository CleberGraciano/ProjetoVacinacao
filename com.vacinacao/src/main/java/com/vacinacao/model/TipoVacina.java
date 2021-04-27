package com.vacinacao.model;

import java.io.Serializable;
import java.util.Objects;

public class TipoVacina implements Serializable {


	private static final long serialVersionUID = 1L;

	private int id;

    private String nomeVacina;

    public TipoVacina(int id, String nomeVacina) {
        this.id = id;
        this.nomeVacina = nomeVacina;
    }

    public TipoVacina() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeVacina() {
        return nomeVacina;
    }

    public void setNomeVacina(String nomeVacina) {
        this.nomeVacina = nomeVacina;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoVacina that = (TipoVacina) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "TipoVacina{" +
                "id=" + id +
                ", nomeVacina='" + nomeVacina + '\'' +
                '}';
    }
}
