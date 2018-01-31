package com.kaishengit.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import com.kaishengit.exception.DataAccessException;

public class DbHelp {

	private static Connection getConnection() {
		return ConnectionManager.getConnection();
	}

	/**
	 *  执行insert update delete操作
	 * 
	 * @param sql  执行sql
	 * @param params
	 *            参数
	 */
	public static void update(String sql, Object... params) 
		throws DataAccessException{

		QueryRunner runner = new QueryRunner(ConnectionManager.getDataSource());
		try {
			runner.update(sql, params);
		} catch (SQLException e) {
			throw new DataAccessException("ִ执行" + sql + "异常");
		}
		
		

	}

	public static <T> T query(String sql, ResultSetHandler<T> rsh,Object... params) 
		throws DataAccessException{
		QueryRunner runner = new QueryRunner(ConnectionManager.getDataSource());
		try {
			T t = runner.query(sql, rsh, params);
			return t;
		} catch (SQLException e) {
			throw new DataAccessException("ִ执行" + sql + "异常");
		}
	}
	
	
	
	private static void close(Connection conn) {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
