package login;
import java.text.*;
import java.util.*;
import java.sql.*;

public class UserDAO 	
{
   static Connection con = null;
   static ResultSet rs = null;  
	

   public static UserBean login(UserBean bean) {
	
      //preparing some objects for connection 
      Statement stmt = null;    
	
      String username = bean.getUsername();    
      String password = bean.getPassword();   
	    
      String searchQuery =
            "select * from user where username='"
                     + username
                     + "' AND password='"
                     + password
                     + "'";
	    
   // "System.out.println" prints in the console; Normally used to trace the process
   System.out.println("Your user name is " + username);          
   System.out.println("Your password is " + password);
   System.out.println("Query: "+searchQuery);
	    
   try 
   {
	   Class.forName("com.mysql.jdbc.Driver").newInstance();  
		con = DriverManager.getConnection(  	
		"jdbc:mysql://localhost:3306/mydb","root","lesinh");    
		stmt = con.createStatement();  
		rs=stmt.executeQuery(searchQuery);
		
   		boolean more = rs.next();
   		// if user does not exist set the isValid variable to false
   		if (!more) 
   		{
   			System.out.println("Sorry, you are not a registered user! Please sign up first");
   			bean.setValid(false);
   		}	 
	        
   		//if user exists set the isValid variable to true
   		else if (more) 
   		{
   			String firstName = rs.getString("FirstName");
	     	
   			System.out.println("Welcome " + firstName);
   			bean.setValid(true);
   		}
   } 
	catch(Exception e) {
		System.out.println(e);
	}         
     
   //some exception handling
   finally 
   {
      if (rs != null)	{
         try {
            rs.close();
         } catch (Exception e) {}
            rs = null;
         }
	
      if (stmt != null) {
         try {
            stmt.close();
         } catch (Exception e) {}
            stmt = null;
         }
	
      if (con != null) {
         try {
            con.close();
         } catch (Exception e) {
         }

         con = null;
      }
   }

   return bean;
	
   }	
}
