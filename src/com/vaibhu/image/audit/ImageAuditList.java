package com.vaibhu.image.audit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.database.DataBaseOperations;
import com.database.DbConnection;
import com.database.DivisionsList;

public class ImageAuditList {
	
	
	public List ImagePathsList(String userid) {
		DivisionsList di=new DivisionsList();
		List division=di.DivisionListGetting(userid);
		List<String> image_path=new ArrayList<>();

		String Query="";
		
		Query="select IMAGE_PATH,BP_NUMBER from CSPDCL_OUTPUT where ";
		
		Iterator<String> itr=division.listIterator();

		int i=0;
		
		while (itr.hasNext()) {
			
			if(i!=0)
				Query=Query+" or ";
			
			Query=Query+"SUBSTR(MRU,3,2)='"+itr.next()+"'";
			
			i++;
		}
		
		System.out.println("Query= "+Query);
		
		Connection con=null;
		ResultSet rs=null;
		PreparedStatement ps=null;
		DbConnection db=new DbConnection();
		try {
			
		con=db.getConnObject2();
		DataBaseOperations dbo=new DataBaseOperations();
		rs=dbo.exicuteQueryReesultSet(Query, con, rs, ps);
		
		while (rs.next()) {
			
			image_path.add(rs.getString("IMAGE_PATH"));
			
		}
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("image_path= "+image_path);
		
		return image_path;
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
