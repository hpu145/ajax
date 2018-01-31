package com.kaishengit.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import com.kaishengit.exception.DataAccessException;

public class ConnectionManager {

	private static String DRIVER = "com.mysql.jdbc.Driver";
	private static String URL = "jdbc:mysql:///db_24";
	private static String USERNAME = "root";
	private static String PASSWORD = "rootroot";
	private static BasicDataSource datasource = new BasicDataSource();
	
	static {
//		Properties prop = new Properties();
//		try {
//			prop.load(ConnectionManager.class.getClassLoader().getResourceAsStream("config.properties"));
//			DRIVER = prop.getProperty("jdbc.driver");
//			URL = prop.getProperty("jdbc.url");
//			USERNAME = prop.getProperty("jdbc.username");
//			PASSWORD =  prop.getProperty("jdbc.password");
//		} catch (IOException e) {
//			throw new DataAccessException("数据库连接异常");
//		}
		
		
		datasource.setDriverClassName(DRIVER);
		datasource.setUrl(URL);
		datasource.setUsername(USERNAME);
		datasource.setPassword(PASSWORD);
		
		datasource.setInitialSize(5);
		datasource.setMaxIdle(20);
		datasource.setMinIdle(5);
		datasource.setMaxWaitMillis(3000);
	}
	
	
	/**
	 * 获取数据库连接池
	 * @return
	 */
	public static DataSource getDataSource(){
		return datasource;
	}
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = datasource.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			throw new DataAccessException("数据库连接异常");
		}
		return conn;
	}

}
