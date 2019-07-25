package com.traveltripper.perfMonitoringApp.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class TestDbProperty implements DbProperty {

	private String driver;
	private String url;
	private String username;
	private String password;

	Connection con;

	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		InputStream io = this.getClass().getClassLoader().getResourceAsStream("DbProps/TT-QADb.properties");

		// System.out.println("io obj = "+io);

		Properties prop = new Properties();
		try {

			prop.load(io);

			driver = prop.getProperty("Dname");
			url = prop.getProperty("URL");
			username = prop.getProperty("Uname");
			password = prop.getProperty("password");

			ConnectionManager connectionManager = new ConnectionManager();
			connectionManager.setDriverName(driver);
			connectionManager.setUrl(url);
			connectionManager.setUsername(username);
			connectionManager.setPassword(password);

			// System.out.println("helo in DevDbProperty");

			con = connectionManager.getConnection();

			// System.out.println("Con = "+con);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return con;
	}

}
