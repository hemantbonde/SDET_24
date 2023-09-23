package db_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleSelectQuery {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		//step1 : load /register driver for specific database
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		//step2 : connect to db
		//brwsr sreach mysql syntax for local and ip adress for company working
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "root");
		//step 3: create /issue sql statement
		Statement stat = con.createStatement();
		//step 4: execute the query
		// why resultset return typre bcaz store All table values
		ResultSet set = stat.executeQuery("select * from student where regno='104'");
		while(set.next()) {
			System.out.println(set.getInt(1)+"\t"+set.getString(2)+"\t"+set.getString(3)+"\t"+set.getString(4));
		}
		//verify
		//close connection
		con.close();
		

	}

}
