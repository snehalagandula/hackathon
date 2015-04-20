package com.vidoo.cloudoe.models;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;
import com.vidoo.helpers.MongoDB;

public class User {
	public static final String table = "users";
	
	public static String kId = "id";
	public static String kName = "name";
	public static String kPassword = "password";
	public static String kCreatedAt = "created_at";
	
	public String id;
	public String name;
	public String password;
	public String created_at;
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password
				+ ", created_at=" + created_at + "]";
	}

	public User(String id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.created_at = new Date().toString();
	}
	
	public User(DBObject object) {
		super();
		this.id = (String) object.get(kId);
		this.name = (String) object.get(kName);
		this.password = (String) object.get(kPassword);
		this.created_at = (String) object.get(kCreatedAt);
	}
	
	public static List<User> all() throws UnknownHostException {
		DB db = MongoDB.getDB();
		DBCollection table = db.getCollection(User.table);
		
		DBCursor cursor = table.find();
		ArrayList<User> elements = new ArrayList<User>();
		
		while(cursor.hasNext()) {
			DBObject object = cursor.next();
			User user = new User(object);
		    elements.add(user);
		}
		
		return elements;
	}
	
	public static WriteResult insert(User user) throws UnknownHostException {
		DB db = MongoDB.getDB();
		DBCollection table = db.getCollection(User.table);
		
		BasicDBObject document = new BasicDBObject();
		document.put(kId, user.id);
        document.put(kName, user.name);
        document.put(kPassword, user.password);
        document.put(kCreatedAt, new Date());
        return table.insert(document);
	}
}
