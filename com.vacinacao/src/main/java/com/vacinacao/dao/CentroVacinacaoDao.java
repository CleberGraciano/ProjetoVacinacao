package com.vacinacao.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.vacinacao.factory.ConnectionPostgressFactory;
import com.vacinacao.model.CentroVacinacao;

public class CentroVacinacaoDao {

	ConnectionPostgressFactory conPost = new ConnectionPostgressFactory();

	public CentroVacinacaoDao() throws IOException {
	}

	public void save(CentroVacinacao centroVacinacao) {

		String sql = "insert into centro_vacinacao (nome_centro_vacinacao) " + " VALUES(?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = conPost.createConnectionToPostgress();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, centroVacinacao.getNome());
			pstm.execute();

		} catch (Exception e) {
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

	public List<CentroVacinacao> getCentroVacinacao() {

		String sql = "SELECT * FROM centro_vacinacao";

		List<CentroVacinacao> centrosVacinacao = new ArrayList<CentroVacinacao>();

		Connection conn = null;
		PreparedStatement pstm = null;

		ResultSet rset = null;

		try {
			conn = conPost.createConnectionToPostgress();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {

				CentroVacinacao centroVacinacao = new CentroVacinacao();

				centroVacinacao.setId(rset.getInt("id_centro_vacinacao"));
				centroVacinacao.setNome(rset.getString("nome_centro_vacinacao"));
				centrosVacinacao.add(centroVacinacao);
			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			try {

				if (rset != null) {

					rset.close();
				}

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

		return centrosVacinacao;
	}

	public CentroVacinacao getByNome(String nome) {

		CentroVacinacao centroVacinacao = new CentroVacinacao();
		String sql = "SELECT * FROM centro_vacinacao WHERE nome_centro_vacinacao = ?";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = conPost.createConnectionToPostgress();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, nome);

			rset = pstm.executeQuery();

			if (rset.next()) {

				centroVacinacao.setId(rset.getInt("id_centro_vacinacao"));
				centroVacinacao.setNome(rset.getString("nome_centro_vacinacao"));
			}

		} catch (Exception e) {

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
		return centroVacinacao;
	}

}
