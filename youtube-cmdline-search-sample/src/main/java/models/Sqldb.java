package models;

import java.sql.*;




import models.User;

public class Sqldb {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.ibm.db2.jcc.DB2Driver";
	static final String DB_URL = "jdbc:db2://23.246.233.62:50000/I6509191";

	// Database credentials
	static final String USER = "rytiyrfv";
	static final String PASS = "nywg5ncjwksl";

	public static Connection getConnection()
	{
		Connection conn = null;
		Statement stmt = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
                     String id = null;
					ResultSet rs = (ResultSet) User.find(id);
					while(rs.next())
					{
						System.out.println("hello");
					}
			// STEP 6: Clean-up environment

			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try

		}
		return conn;
		
	User.all();	

	}
}
