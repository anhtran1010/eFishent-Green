import com.mongodb.MongoClient;
import com.mongodb.client.*;

import java.util.Iterator;

import org.bson.Document;

import com.mongodb.*;

public class DbController2<DBObject> {
	MongoClientURI uri;
	MongoClient mongoClient;
	MongoDatabase database;
	MongoCollection<Document> collection;
	
	public DbController2() {
		uri = new MongoClientURI(
			    "mongodb://dbEfish:eFish%40CSBSJU19@cluster0-shard-00-00-klemt.mongodb.net:27017,cluster0-shard-00-01-klemt.mongodb.net:27017,cluster0-shard-00-02-klemt.mongodb.net:27017/test?ssl=true&replicaSet=Cluster0-shard-0&authSource=admin&retryWrites=true");

		mongoClient = new MongoClient(uri);
		database = mongoClient.getDatabase("eFishDB");
		collection = database.getCollection("controlVar");
	}
	
	public Document toDBObject(String key, String[] dataPoints) {
		return  new Document("_id", key)
				.append("Water Level", dataPoints[0])
				.append("Water Temperature", dataPoints[1])
				.append("pH Level", dataPoints[2])
				.append("Nitrate Level", dataPoints[3])
				.append("Oxygen Level", dataPoints[4])
				.append("Ammonia Level", dataPoints[5])
				.append("Light Intensity", dataPoints[6])
				.append("Air Temperature", dataPoints[7]);
	}
	
	public void insert(String key, String[] dataPoints) {
		//((DBCollection) collection).insert((com.mongodb.DBObject[]) this.toDBObject(key, dataPoints));
		collection.insertOne(this.toDBObject(key, dataPoints));
	}
	
	public Iterator<Document> get() {
		// Getting the iterable object 
		// code from https://www.tutorialspoint.com/mongodb/mongodb_java.htm
	      FindIterable<Document> iterDoc = collection.find(); 

	      // Getting the iterator 
	      Iterator<Document> it = iterDoc.iterator(); 
	      return it;
	}
	
}
