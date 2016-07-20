package automationFramework.DAO;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automationFramework.Utilities.Global;
import automationFramework.Utilities.Logging;

public class PostgresAutomation {
	
	static WebDriver driver;
	static String browser;
	private static Logger Log = Logger.getLogger(Logger.class.getName());
	Connection connection;

	@BeforeMethod
	public void setUp() throws InterruptedException {

		Logging.setLogConsole();
		Logging.setLogFile();
		
	}
	
	@Test
	public void dbConnect(){
		try{
			Class.forName("org.postgresql.Driver");
			Enumeration<Driver> drivers = DriverManager.getDrivers();
			connection = DriverManager.getConnection(Global.POSTGRESDB, Global.POSTGRESUSER, Global.POSTGRESPASS);
			Log.info("PostgresDB connection success!");
			
			}catch(Exception e){
			Log.error("Not able to connect to postgresDB");
			}	
		}
	
	
	@Test
	public boolean dbFindCustomer(String userEmail){
		
		boolean recordFound = false;
		
		try{
			
			Statement statement = connection.createStatement();
			ResultSet results = statement.executeQuery("SELECT * FROM cms_main.contact where email ='" + userEmail + "'");
			while(results.next()){
			  String ID = results.getString("contact_id");
			  Log.info("contact id in the database: " + ID);
			  recordFound = true;
			}
			
			}catch(Exception e){
			Log.error("Not able to retrieve record from postgresDB");
			}
		
			return recordFound;	
		}
	

	@Test
	public void dbDisconnect(){
		try {
			connection.close();
			Log.info("PostgresDB disconnected");
		} catch (SQLException e) {
			Log.error("Not able to disconnect from postgresDB");
		}
		
	}
	
}
