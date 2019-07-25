package com.traveltripper.perfMonitoringApp.db;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	private static String url;
	private static String driverName;
	private static String username;
	private static String password;
	private static Connection con;
	private static String urlstring;

	public static Connection getConnection() {
		try {
			Class.forName(driverName);
			try {

				// System.out.println("url = "+url+":: drivername = "+driverName+":: username =
				// "+username+":: password = "+password);

				con = DriverManager.getConnection(url, username, password);
			} catch (SQLException ex) {
				// log an exception. fro example:
				System.out.println("Failed to create the database connection.");
			}
		} catch (ClassNotFoundException ex) {
			// log an exception. for example:
			System.out.println("Driver not found.");
		}
		return con;
	}

	public static String getUrl() {
		return url;
	}

	public static void setUrl(String url) {
		ConnectionManager.url = url;
	}

	public static String getDriverName() {
		return driverName;
	}

	public static void setDriverName(String driverName) {
		ConnectionManager.driverName = driverName;
	}

	public static String getUsername() {
		return username;
	}

	public static void setUsername(String username) {
		ConnectionManager.username = username;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		ConnectionManager.password = password;
	}

	public static Connection getCon() {
		return con;
	}

	public static void setCon(Connection con) {
		ConnectionManager.con = con;
	}

	public static String getUrlstring() {
		return urlstring;
	}

	public static void setUrlstring(String urlstring) {
		ConnectionManager.urlstring = urlstring;
	}

}