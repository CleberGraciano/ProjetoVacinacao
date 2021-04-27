package com.vacinacao.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.vacinacao.factory.ConnectionPostgressFactory;
import com.vacinacao.model.Contato;


 
public class ContatoDAO {

 ConnectionPostgressFactory conPost = new ConnectionPostgressFactory();
 


 public ContatoDAO() throws IOException {
 }

 public void save(Contato contato) {

  /*
   * Isso � uma sql comum, os ? s�o os par�metros que n�s vamos adicionar
   * na base de dados
   */

  String sql = "INSERT INTO contatos(nome,idade,dataCadastro)" +
          " VALUES(?,?,?)";

  Connection conn = null;
  PreparedStatement pstm = null;


  try {
   //Cria uma conex�o com o banco
   conn = conPost.createConnectionToPostgress();

   //Cria um PreparedStatment, classe usada para executar a query
   pstm = conn.prepareStatement(sql);

   //Adiciona o valor do primeiro par�metro da sql
   pstm.setString(1, contato.getNome());
   //Adicionar o valor do segundo par�metro da sql
   pstm.setInt(2, contato.getIdade());
   //Adiciona o valor do terceiro par�metro da sql
   pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));

   //Executa a sql para inser��o dos dados
   pstm.execute();

  } catch (Exception e) {

   e.printStackTrace();
  } finally {

   //Fecha as conex�es

   try {
    if (pstm != null) {

     pstm.close();
    }

    if (conn != null) {
     conn.close();
    }

   } catch (Exception e) {

    e.printStackTrace();
   }
  }
 }

 public void removeById(int id) {

  String sql = "DELETE FROM contatos WHERE id = ?";

  Connection conn = null;
  PreparedStatement pstm = null;

  try {
   conn = conPost.createConnectionToPostgress();

   pstm = conn.prepareStatement(sql);

   pstm.setInt(1, id);

   pstm.execute();

  } catch (Exception e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  } finally {

   try {
    if (pstm != null) {

     pstm.close();
    }

    if (conn != null) {
     conn.close();
    }

   } catch (Exception e) {

    e.printStackTrace();
   }
  }
 }

 public void update(Contato contato) {

  String sql = "UPDATE contatos SET nome = ?, idade = ?, dataCadastro = ?" +
          " WHERE id = ?";

  Connection conn = null;
  PreparedStatement pstm = null;

  try {
   //Cria uma conex�o com o banco
   conn = conPost.createConnectionToPostgress();

   //Cria um PreparedStatment, classe usada para executar a query
   pstm = conn.prepareStatement(sql);

   //Adiciona o valor do primeiro par�metro da sql
   pstm.setString(1, contato.getNome());
   //Adicionar o valor do segundo par�metro da sql
   pstm.setInt(2, contato.getIdade());
   //Adiciona o valor do terceiro par�metro da sql
   pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));

   pstm.setInt(4, contato.getId());

   //Executa a sql para inser��o dos dados
   pstm.execute();

  } catch (Exception e) {

   e.printStackTrace();
  } finally {

   //Fecha as conex�es

   try {
    if (pstm != null) {

     pstm.close();
    }

    if (conn != null) {
     conn.close();
    }

   } catch (Exception e) {

    e.printStackTrace();
   }
  }
 }


 public Contato getByNome(String nomes) {

  Contato contato = new Contato();
  String sql = "SELECT * FROM contatos WHERE nome = ?";

  Connection conn = null;
  PreparedStatement pstm = null;
  ResultSet rset = null;

  try {
   conn = conPost.createConnectionToPostgress();

   pstm = conn.prepareStatement(sql);

   pstm.setString(1, nomes);

   rset = pstm.executeQuery();

   if (rset.next()) {

    //Recupera o id do banco e atribui ele ao objeto
    contato.setId(rset.getInt("id"));

    //Recupera o nome do banco e atribui ele ao objeto
    contato.setNome(rset.getString("nome"));

    //Recupera a idade do banco e atribui ele ao objeto
    contato.setIdade(rset.getInt("idade"));

    //Recupera a data do banco e atribui ela ao objeto
    contato.setDataCadastro(rset.getDate("datacadastro"));
   }

  } catch (Exception e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  } finally {

   try {
    if (pstm != null) {

     pstm.close();
    }

    if (conn != null) {
     conn.close();
    }

   } catch (Exception e) {

    e.printStackTrace();
   }
  }
  return contato;
 }






 
 public List<Contato> getContatos(){
 
 String sql = "SELECT * FROM contatos";
 
 List<Contato> contatos = new ArrayList<Contato>();
 
 Connection conn = null;
 PreparedStatement pstm = null;
 //Classe que vai recuperar os dados do banco de dados
 ResultSet rset = null;
 
 try {
 conn = conPost.createConnectionToPostgress();
 
 pstm = conn.prepareStatement(sql);
 
 rset = pstm.executeQuery();
 
 //Enquanto existir dados no banco de dados, fa�a
 while(rset.next()){
 
 Contato contato = new Contato();
 
 //Recupera o id do banco e atribui ele ao objeto
 contato.setId(rset.getInt("id"));
 
 //Recupera o nome do banco e atribui ele ao objeto
 contato.setNome(rset.getString("nome"));
 
 //Recupera a idade do banco e atribui ele ao objeto
 contato.setIdade(rset.getInt("idade"));
 
 //Recupera a data do banco e atribui ela ao objeto
 contato.setDataCadastro(rset.getDate("dataCadastro"));
 
 //Adiciono o contato recuperado, a lista de contatos
 contatos.add(contato);
 }
 } catch (Exception e) {
 
 e.printStackTrace();
 }finally{
 
 try{
 
 if(rset != null){
 
 rset.close();
 }
 
 if(pstm != null){
 
 pstm.close();
 }
 
 if(conn != null){
 conn.close();
 }
 
 }catch(Exception e){
 
 e.printStackTrace();
 }
 }
 
 return contatos;
 }
}