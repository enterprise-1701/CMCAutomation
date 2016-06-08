package automationFramework.DAO;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

import automationFramework.Utilities.Global;

import com.mongodb.DB;

public class MongoAutomation {
	
	public static void main(String args[]){
		
		try{
			
			MongoClient mongo = new MongoClient(Global.MONGO, 27017);
			DB db = mongo.getDB(Global.DB);
			System.out.println("Mongo Connection Success!");
			DBCollection table = db.getCollection(Global.COLLECTION);
			
			boolean auth = db.authenticate("testuser", "password".toCharArray());
			
			if(auth){
				System.out.println("DB Authentication success");
		
				BasicDBObject searchQuery = new BasicDBObject();
				searchQuery.put("name", "rocky");
			
				DBCursor cursor = table.find(searchQuery);
				while(cursor.hasNext()){
				System.out.println(cursor.next());
					}
				}
			else{
				System.out.println("DB Authentication failed");
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	

}
