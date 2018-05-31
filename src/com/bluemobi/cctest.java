/**
 * 
 */
package com.bluemobi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.apache.commons.io.FileUtils;
/**
 * @author caiwh
 * Title:cctest.java
 */
public class cctest {
	 public static void main(String[] args){
		 String file = "c:/Users/caiwh/Desktop/model.db";
		 //String file = "e:/model.db";
		 Connection c = null;
		    Statement stmt = null;
		    try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite://"+file);
		      c.setAutoCommit(false);
		      System.out.println("Opened database successfully");

		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM provice;" );
		      while ( rs.next() ) {
		         int id = rs.getInt("id");
		         String  proviceId = rs.getString("provice_id");
		         String provicName  = rs.getString("provic_name");
		         System.out.println( "ID = " + id );
		         System.out.println( "proviceId = " + proviceId );
		         System.out.println( "provicName = " + provicName );
		      }
		      rs.close();
		      stmt.close();
		      c.close();
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
		    System.out.println("Operation done successfully");
	    }
}
