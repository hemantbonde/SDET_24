package db_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SelectQueryrealtime {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		Connection con=null;
		try {
		Driver drvref=new Driver();
		DriverManager.registerDriver(drvref);
		con= DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "root");
		System.out.println("connection established");
		Statement stat = con.createStatement();
		ResultSet res = stat.executeQuery("select * from student where regno=105");
		if(res.next()==false)
		System.err.println("Student is not found");
		}
		catch(Exception e) {
		System.out.println("Student is found in table");
		}
		finally {
			con.close();
			System.out.println("----connection close-----");
		}
		
		
		

	}

}
