package com.vacinacao;

import java.io.IOException;
import com.vacinacao.dao.CentroVacinacaoDao;
import com.vacinacao.model.CentroVacinacao;


public class TesteCentroVacinacao {

	public static void main(String args[]) throws IOException {
		 
		 CentroVacinacaoDao centroVacinacaoDao = new CentroVacinacaoDao();
		 

		 CentroVacinacao centroVacinacao = new CentroVacinacao();
		 centroVacinacao.setNome("LISBOA");
//		 centroVacinacaoDao.save(centroVacinacao);


//		 for(CentroVacinacao c : centroVacinacaoDao.getCentroVacinacao()){
//		 
//		 System.out.println("Nome Centro: " + c.getNome());
//		 }
		 
		 System.out.println("Nome Centro: " +centroVacinacaoDao.getByNome("PORTO"));
		 }
		}