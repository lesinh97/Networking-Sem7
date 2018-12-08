package database;

import java.sql.*;

public class bridge {
	public static String username="";
	public static String password="";
	public static void main(String args[]){  
		try {  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/mydb","root","lesinh");    
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("select * from user");  
		while(rs.next()) {
			System.out.println(rs.getInt(0)+"  "+rs.getString(2)+"  "+rs.getString(3));
			username = rs.getString(1);
			password = rs.getString(2);
			con.close();
			}
		}
		catch(Exception e) {
			System.out.println(e);
			}  
		}  
	public String getUserName() {
		return username;
	}
	public String getPassword() {
		return password;
	}
}
