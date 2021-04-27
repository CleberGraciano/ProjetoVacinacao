package com.vacinacao.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class Vacinacao implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;

    private Cidadao cidadao;
    private CentroVacinacao centroVacinacao;
    private TipoVacina tipoVacina;
    private LocalDateTime dataVacinacao;
    private String codigoEfeito;
    private String codigoVacinacao;

    public Vacinacao(int id, Cidadao cidadao, CentroVacinacao centroVacinacao, TipoVacina tipoVacina, LocalDateTime dataVacinacao, String codigoEfeito, String codigoVacinacao) {
        this.id = id;
        this.cidadao = cidadao;
        this.centroVacinacao = centroVacinacao;
        this.tipoVacina = tipoVacina;
        this.dataVacinacao = dataVacinacao;
        this.codigoEfeito = codigoEfeito;
        this.codigoVacinacao = codigoVacinacao;
    }

    public Vacinacao() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cidadao getCidadao() {
        return cidadao;
    }

    public void setCidadao(Cidadao cidadao) {
        this.cidadao = cidadao;
    }

    public CentroVacinacao getCentroVacinacao() {
        return centroVacinacao;
    }

    public void setCentroVacinacao(CentroVacinacao centroVacinacao) {
        this.centroVacinacao = centroVacinacao;
    }

    public TipoVacina getTipoVacina() {
        return tipoVacina;
    }

    public void setTipoVacina(TipoVacina tipoVacina) {
        this.tipoVacina = tipoVacina;
    }

    public LocalDateTime getDataVacinacao() {
        return dataVacinacao;
    }

    public void setDataVacinacao(LocalDateTime dataVacinacao) {
        this.dataVacinacao = dataVacinacao;
    }

    public String getCodigoEfeito() {
        return codigoEfeito;
    }

    public void setCodigoEfeito(String codigoEfeito) {
        this.codigoEfeito = codigoEfeito;
    }

    public String getCodigoVacinacao() {
        return codigoVacinacao;
    }

    public void setCodigoVacinacao(String codigoVacinacao) {
        this.codigoVacinacao = codigoVacinacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vacinacao vacinacao = (Vacinacao) o;
        return id == vacinacao.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Vacinacao{" +
                "id=" + id +
                ", cidadao=" + cidadao +
                ", centroVacinacao=" + centroVacinacao +
                ", tipoVacina=" + tipoVacina +
                ", dataVacinacao=" + dataVacinacao +
                ", codigoEfeito='" + codigoEfeito + '\'' +
                ", codigoVacinacao='" + codigoVacinacao + '\'' +
                '}';
    }
}
