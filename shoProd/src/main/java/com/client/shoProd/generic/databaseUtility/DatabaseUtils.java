package com.client.shoProd.generic.databaseUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtils {

Connection con;
	
	public void getDataBaseConnection() {
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects", "root@%", "root");
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	//close connection
	public void closeDataBaseConnection(){
		try{
			con.close();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	//execute select query
	public ResultSet executeQuery(String query) throws SQLException {
		ResultSet result=null;
		try {
		Statement stat = con.createStatement();
		result = stat.executeQuery(query);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	
	//update query
	public int updateQuery(String query) throws SQLException {
		int result=0;
		try {
		Statement stat = con.createStatement();
		result = stat.executeUpdate(query);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
}
