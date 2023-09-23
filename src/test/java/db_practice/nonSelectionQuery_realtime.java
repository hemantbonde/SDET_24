package db_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class nonSelectionQuery_realtime {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		Connection con=null;
	try {
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "root");
		
		Statement stat = con.createStatement();
		int res = stat.executeUpdate("insert into student values (104,'ram','sr','sr@gmail.com')");
		if(res==1) {
			System.out.println("Student added to table");
		}
		}
		catch(Exception e)
		{
			System.err.println("Student is not added to table");
		}
		finally {
			con.close();
			System.out.println("------------close connection------------");
		}
		

	}

}
