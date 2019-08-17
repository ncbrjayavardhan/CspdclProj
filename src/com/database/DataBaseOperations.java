package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseOperations {
	
	public int exicuteQuery(String Qury, Connection con) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean status=false;
		int kk=0;
			
			 ps = con.prepareStatement(Qury);
			 kk = ps.executeUpdate();
				
			 try {
				 ps.close();
			 }catch(Exception e) {
				 
			 }
				
			return kk;
	}

	
public ResultSet exicuteQueryReesultSet(String Qury, Connection con,ResultSet rs,PreparedStatement ps) {
		
	
	
	int kk=0;
		try {
		 ps = con.prepareStatement(Qury);
		 rs = ps.executeQuery();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			/*try {
			if(ps!=null)
				ps.close();
			
		}catch(Exception ee) {
			
		}*/
		}
	return rs;
	}
}
