package com.vidoo.helpers;

import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Date;

import com.mongodb.*;
import com.vidoo.cloudoe.models.User;

public class MongoDB {

	static String url = "mongodb://71c7ae74-ac0b-4aae-b569-defc917d8a97:937cd06a-e6c1-4091-bf2c-29b7bb18fb4f@192.155.243.56:10163/db";
	static String username = "71c7ae74-ac0b-4aae-b569-defc917d8a97";
	static String password = "937cd06a-e6c1-4091-bf2c-29b7bb18fb4f";
	static String database = "db";
	static int port = 10163;
	static String host = "192.155.243.56";

	public static String getServiceURI() {
		return url;
	}
	
	public static DB getDB() throws UnknownHostException {
		String connURL = getServiceURI();
		MongoCredential credential = MongoCredential.createMongoCRCredential(username, database, password.toCharArray());
		
		MongoClient mongo = new MongoClient(new ServerAddress(host, port), Arrays.asList(credential));
//		MongoClient mongoC = new MongoClient(new MongoClientURI(connURL));
        DB db = mongo.getDB("db");
        return db;
	}
	
	public static void main(String []argsStrings) {
		System.out.println("Hello");
		
		DB db = null;
		try {
			db = MongoDB.getDB();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DBCollection table = db.getCollection(User.table);
		
		BasicDBObject document = new BasicDBObject();
        document.put("username", "Pradyumna Doddala");
        document.put("password", "12345");
        document.put("created_at", new Date());
        WriteResult result = table.insert(document);
        
		System.out.println(result);
	}
}
