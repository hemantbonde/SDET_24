package com.crm.comcast.genericutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;
/**
 * 
 * @author Hemant
 *
 */
public class DataBaseUtilities {
	Connection con;
	/**
	 * connects to the Database
	 * @throws Throwable
	 */
	public void connecttoDB() throws Throwable {
		
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
	    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "root");
	}
	/**
	 * Insert  Select Queary and execute Queary
	 * @param query
	 * @throws Throwable
	 */
	public void ExecuteSelectQuery( String query) throws Throwable {
		try {
		Statement stat = con.createStatement();
		ResultSet set = stat.executeQuery(query);
		//verify
		while(set.next()) {
			System.out.println(set.getInt(1)+"\t"+set.getString(2)+"\t"+set.getString(3)+"\t"+set.getString(4));
		}}
		catch(Exception s) {
			s.printStackTrace();
		}
	}
	
	public void ExecutenonSelectQuery( String nsquery) throws Throwable {
		try {
		Statement stat = con.createStatement();
		int res = stat.executeUpdate(nsquery);
		if(res==1) {
			System.out.println("Student added to table");
		}
		else {
			System.err.println("Student is not added to table");
		}}
		catch(Exception ns) {
			ns.printStackTrace();
		}
		}
	
	/**
	 * close Connection with database
	 * @throws Throwable
	 */
	public void CloseDb() throws Throwable {
		con.close();
	}

}
