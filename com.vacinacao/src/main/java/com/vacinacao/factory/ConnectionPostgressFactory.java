package com.vacinacao.factory;

import com.vacinacao.config.ConfigProps;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionPostgressFactory {

	ConfigProps prop = new ConfigProps();

	Properties props = prop.getProp();

	public ConnectionPostgressFactory() throws IOException {

	}

	public  Connection createConnectionToPostgress() throws Exception {

		Connection connection = DriverManager.getConnection(
				props.getProperty("prop.server.database"),
				props.getProperty("prop.server.username"),
				props.getProperty("prop.server.password"));

		return connection;
	}

	public  void main(String[] args) throws Exception {


		Connection con = createConnectionToPostgress();


		if (con != null) {
			System.out.println("Conex�o obtida com sucesso!" + con);
			con.close();
		}

	}
}