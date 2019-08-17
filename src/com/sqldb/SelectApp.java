package com.sqldb;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
/**
 *
 * @author sqlitetutorial.net
 */
public class SelectApp {
 
    /**
     * Connect to the test.db database
     * @return the Connection object
     */
    private Connection connect() {
        // SQLite connection string
//        String url = "jdbc:sqlite:C://sqlite/db/test.db";
      String url = "jdbc:sqlite:D:/CSPDCL/mobile db files/DMP_09052019_125413(0).db";

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
 
    
    /**
     * select all rows in the warehouses table
     */
    public void selectAll(){
    	
    	System.out.println("start");
//        String sql = "SELECT id, name, capacity FROM warehouses";
        String sql = "SELECT * FROM SBMTOPC";
//        String sql = "SELECT * FROM PCTOSBM";

        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                /*System.out.println(rs.getString("SBM_NO") +  "\t" + 
                                   rs.getString("BP_Number") + "\t" +
                                   rs.getString("Pres_Read_KWH"));
                */
                System.out.println(rs.getString("BP_Number"));
                
                
                
                
            }
        } catch (SQLException e) {
//            System.out.println(e.getMessage());
        	e.printStackTrace();
        }
        
    	System.out.println("end");

    }
    
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SelectApp app = new SelectApp();
        app.selectAll();
    }
 
}