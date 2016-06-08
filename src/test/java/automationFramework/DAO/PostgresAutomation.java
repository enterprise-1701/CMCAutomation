package automationFramework.DAO;


import automationFramework.Utilities.Global;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PostgresAutomation {
	
	public static void main(String args[]){
		
		try{
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection(Global.POSTGRESDB, Global.DBUSER, Global.DBPASS);
			System.out.println("PostgresDB connection success!");
			Statement statement = connection.createStatement();
			ResultSet results = statement.executeQuery("SELECT * FROM cms_main.contact where contact_id = 3");
			System.out.println(results);
			
		  while(results.next()){
			  String name = results.getString("first_name");
			  System.out.println("name is : " + name);
		  }
		    
		  connection.close();
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	
	}
}
