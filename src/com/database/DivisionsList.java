package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import com.pojo.DashBoardPojo;

public class DivisionsList {

	private Map<String,List<String>> subDivionCodeMap=new HashMap<>();
	//dccode,list
	//retruning first DCcode
	public List<String> getSubDivCode() {
		List<String> dcCode=subDivionCodeMap.get(subDivionCodeMap.keySet().toArray()[0]);
		return dcCode!= null?dcCode : new ArrayList();
	}
	
	public List getSubDivCode(String divisionCode) {
		return subDivionCodeMap.get(divisionCode);
	}
	public List getEmptyList(){
		return new ArrayList();
	}

	public List DivisionListGetting(String username) {
		

		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
	
		List<String> li=new ArrayList<>();
		DbConnection db=new DbConnection();
		String Query ="SELECT  distinct DC_CODE,SUB_DC_CODE from CSPDCL_WEB_USER_PERMISSIONS where USER_NAME='"+username+"'";

		try {
			
			
		   con=db.getConnObject2();
		   
		   DataBaseOperations dbo=new DataBaseOperations();
		  rs= dbo.exicuteQueryReesultSet(Query, con, rs, ps);
		   
		  while(rs.next()) {
			  String dcCode=rs.getString("DC_CODE");
			  String subDivCode=rs.getString("SUB_DC_CODE");
			  li.add(dcCode);
			  List subDivionList=new ArrayList<>();
			  if(subDivionCodeMap.containsKey(dcCode)){
				  subDivionCodeMap.get(dcCode).add(subDivCode); 
			  }
			  else{
				  subDivionList.add(subDivCode);
				  subDivionCodeMap.put(dcCode, subDivionList);
			  }
			  
			  
			  
		  }
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)
					rs.close();
			}catch(Exception e) {}
				
			try {
				if(ps!=null)
					ps.close();
			}catch(Exception e) {}
			try {
				if(con!=null)
					con.close();
			}catch(Exception e) {}
	
		}
		return li;
		
		
	}
	
public List MruListGetting(String divcode) {
		

		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		List<String> li=new ArrayList<>();
		DbConnection db=new DbConnection();
		String Query ="SELECT distinct MRU from CSPDCL_INPUT2 where SUBSTR(MRU,3,2)='"+divcode+"'";
		
		/*
		 * ListIterator<DashBoardPojo> itr=divcode.listIterator(); DashBoardPojo
		 * dp=null;
		 * 
		 * int i=0; while (itr.hasNext()) { dp=new DashBoardPojo(); dp=itr.next();
		 * 
		 * if(i>0) Query=Query+" or ";
		 * 
		 * try {
		 * 
		 * Query=Query+" SUBSTR(MRU,3,2)='"+dp.getGROUP_CODE()+"' ";
		 * 
		 * }catch (Exception e) { e.printStackTrace(); }finally {
		 * 
		 * }
		 * 
		 * i++;
		 * 
		 * }
		 */		
		
		
		System.out.println("Query= "+Query);
		
		try {
			
			
		   con=db.getConnObject2();
		   
		   DataBaseOperations dbo=new DataBaseOperations();
		  rs= dbo.exicuteQueryReesultSet(Query, con, rs, ps);
		   
		  while(rs.next()) {
			  
			  li.add(rs.getString("MRU"));
			  
		  }
		
		
		}catch (Exception e) {
			// TODO: handle exception
		}finally {

			try {
				if(rs!=null)
					rs.close();
			}catch(Exception e) {}
				
			try {
				if(ps!=null)
					ps.close();
			}catch(Exception e) {}
			try {
				if(con!=null)
					con.close();
			}catch(Exception e) {}
	
		
		}
		return li;
		
		
	}
	
}
