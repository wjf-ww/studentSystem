package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {

	private String dbUrl = "jdbc:mysql://localhost:3306/sys?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
	private String dbUser = "root";
	private String dbPassword = "root";
	private String jdbcName = "com.mysql.cj.jdbc.Driver";
	private Connection connection = null;
	public Connection getConnection(){
		try {
			Class.forName(jdbcName);
			connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
			System.out.println("数据库链接成功！");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("数据库链接失败！");
			e.printStackTrace();
		}
		return connection;
	}
	
	public void closeCon(){
		if(connection != null) {
			try {
				connection.close();
				System.out.println("数据库链接已关闭！");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public void close(ResultSet resultSet, PreparedStatement preparedStatement,Connection connection){
		try {
			if (resultSet != null) {
			resultSet.close();
			}
			if(preparedStatement != null ){
				preparedStatement.close();
			}
			if(connection != null ){
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}