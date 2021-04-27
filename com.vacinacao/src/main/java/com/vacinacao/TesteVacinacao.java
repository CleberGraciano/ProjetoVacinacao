package com.vacinacao;

import java.io.IOException;
import java.util.Date;

import com.vacinacao.dao.ContatoDAO;

import com.vacinacao.model.Contato;

public class TesteVacinacao {

	public static void main(String args[]) throws IOException {
		 
		 ContatoDAO contatoDAO = new ContatoDAO();
		 
	
		 
		 //Cria um contato e salva no banco
		 Contato contato = new Contato();
		 contato.setNome("Jose");
		 contato.setIdade(30);
		 contato.setDataCadastro(new Date());
		
		 
//		 contatoDAO.save(contato);
		 
		 //Atualiza o contato com id = 1 com os dados do objeto contato1
		 Contato contato1 = new Contato();
		 contato1.setId(1);
		 contato1.setNome("Pedro");
		 contato1.setIdade(28);
		 contato1.setDataCadastro(new Date());
		 
		

//		contatoDAO.save(contato1);

//		 contatoDAO.update(contato1);
		 
		 //Remove o contato com id = 1
		 
		contatoDAO.removeById(1);
		 
		 //Lista todos os contatos do banco de dados
		 
		 for(Contato c : contatoDAO.getContatos()){
		 
		 System.out.println("NOME: " + c.getNome());
		 }
		 }
		}