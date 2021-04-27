package com.vacinacao.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Contato implements Serializable {

private static final long serialVersionUID = 1L;

private int id;
 private String nome;
 private int idade;
 private Date dataCadastro;

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

 public int getIdade() {
  return idade;
 }

 public void setIdade(int idade) {
  this.idade = idade;
 }

 public Date getDataCadastro() {
  return dataCadastro;
 }

 public void setDataCadastro(Date dataCadastro) {
  this.dataCadastro = dataCadastro;
 }

 @Override
 public boolean equals(Object o) {
  if (this == o) return true;
  if (o == null || getClass() != o.getClass()) return false;
  Contato contato = (Contato) o;
  return id == contato.id;
 }

 @Override
 public int hashCode() {
  return Objects.hash(id);
 }

 @Override
 public String toString() {
  return "Contato{" +
          "id=" + id +
          ", nome='" + nome + '\'' +
          ", idade=" + idade +
          ", dataCadastro=" + dataCadastro +
          '}';
 }
}