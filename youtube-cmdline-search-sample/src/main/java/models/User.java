package models;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class User {
	String id;
	String name;
	String email;
	String created_at;
	static Connection con=Sqldb.getConnection();
 static Statement stmt=null;
	
	           
	
	public static List<User> all() throws SQLException {
		
		String sql="select * from users";
		stmt = (Statement) con.createStatement();
		 ResultSet rs= ((java.sql.Statement) stmt).executeQuery(sql);
	     
			return (List<User>) rs;
		
		
	}
	
	public static User find(String id) throws SQLException {
		String sql="select * from users where id='123'";
	              stmt = (Statement) con.createStatement();
	              ResultSet rs= ((java.sql.Statement) stmt).executeQuery(sql);
		     
		return (User) rs;
		
	}

}
