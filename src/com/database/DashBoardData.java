package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.pojo.DashBoardPojo;

public class DashBoardData {

	
	
	



public List DisconnectedconsumerDataTable_divisionwise() {
	
	Connection con=null;
	PreparedStatement ps1=null;
	ResultSet count=null;
	Map<String,String> mp=new HashMap<>();
	List<DashBoardPojo> li=new ArrayList<>();
	DbConnection db=new DbConnection();
	con=db.getConnObject2();
//	String Query = "SELECT distinct SUBSTR(MRU,3,2) as group_code,count(MRU) as total_count from CSPDCL_INPUT2  group by MRU";
	String Query = "SELECT distinct SUBSTR(MRU,3,2) as group_code,SUBSTR(MRU,5,2) as DCCODE,count(MRU) as total_count from CSPDCL_OUTPUT  group by MRU";

	DashBoardPojo dsp=new DashBoardPojo();
	
	DataBaseOperations dbs=new DataBaseOperations();
	
	try {
		ps1 = con.prepareStatement(Query);
		count=ps1.executeQuery();
		while(count.next()){
			DashBoardPojo dp=new DashBoardPojo();
			
			
			String group_code=count.getString("GROUP_CODE");
			dp.setGROUP_CODE(group_code);
			dp.setDCCODE((String)count.getString("DCCODE"));
			dp.setTOTAL_COUNT(count.getString("TOTAL_COUNT"));
			

			Connection con2=null;
			PreparedStatement ps2=null;
			ResultSet rs2=null;
			String input_count="";
			
			try {
				DbConnection db2=new DbConnection();
				con2=db.getConnObject2();
				
				String Query2="select count(*) from cspdcl_input2 where SUBSTR(MRU,3,2)='"+group_code+"'";
				System.out.println("Query2= "+Query2);
				rs2=dbs.exicuteQueryReesultSet(Query2, con2, rs2, ps2);
				while (rs2.next()) {
					input_count=rs2.getString("count(*)");
					
					dp.setINPUT_COUNT(input_count);
					
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {if(rs2!=null)
					rs2.close();
				}catch(Exception e) {}
				
				try {if(ps2!=null)
					ps2.close();
				}catch(Exception e) {}
				try {if(con2!=null)
					con2.close();
				}catch(Exception e) {}
				
				
			}
			
			
			 
			
			
			li.add(dp);
			
		//	System.out.println(li);
			
		}
		
	}catch (Exception e) {
		e.printStackTrace();
	}finally {
		try {if(count!=null)
			count.close();
		}catch(Exception e) {}
		
		try {if(ps1!=null)
			ps1.close();
		}catch(Exception e) {}
		try {if(con!=null)
			con.close();
		}catch(Exception e) {}
		
		
	}
	return li;
}










public List DisconnectedconsumerDataTable_divisionwise2(String user_id) {
	
	Connection con=null;
	PreparedStatement ps1=null;
	ResultSet count=null;
	Map<String,String> mp=new HashMap<>();
	List<DashBoardPojo> li=new ArrayList<>();
	DbConnection db=new DbConnection();
	con=db.getConnObject2();
//	String Query = "SELECT distinct SUBSTR(MRU,3,2) as group_code,count(MRU) as total_count from CSPDCL_INPUT2  group by MRU";
//	String Query = "SELECT distinct SUBSTR(MRU,3,2) as group_code,count(MRU) as total_count from CSPDCL_OUTPUT  group by MRU";
	String Query ="SELECT  DC_CODE,SUB_DC_CODE from CSPDCL_WEB_USER_PERMISSIONS where USER_NAME='"+user_id+"'";
	DashBoardPojo dsp=new DashBoardPojo();
	
	DataBaseOperations dbs=new DataBaseOperations();
	
	try {
		ps1 = con.prepareStatement(Query);
		count=ps1.executeQuery();
		while(count.next()){
			DashBoardPojo dp=new DashBoardPojo();
			
			
			String group_code=count.getString("DC_CODE");
			dp.setGROUP_CODE(group_code);
			String subDivCode=count.getString("SUB_DC_CODE");
			dp.setDCCODE(subDivCode);
			/*dp.setTOTAL_COUNT(count.getString("TOTAL_COUNT"));*/
			

			Connection con2=null;
			PreparedStatement ps2=null;
			ResultSet rs2=null;
			String input_count="";
			
			try {
				DbConnection db2=new DbConnection();
				con2=db.getConnObject2();
				
				//select count(*) from cspdcl_input2 where SUBSTR(MRU,3,2)='46' and substr(mru,5,2)='02'
				String Query2="select count(*) from cspdcl_input2 where SUBSTR(MRU,3,2)='"+group_code+"'"+ "and substr(mru,5,2)='"+ subDivCode+"'";
				System.out.println("Query2= "+Query2);
				rs2=dbs.exicuteQueryReesultSet(Query2, con2, rs2, ps2);
				while (rs2.next()) {
					input_count=rs2.getString("count(*)");
					
					dp.setINPUT_COUNT(input_count);
					
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {if(rs2!=null)
					rs2.close();
				}catch(Exception e) {}
				
				try {if(ps2!=null)
					ps2.close();
				}catch(Exception e) {}
				try {if(con2!=null)
					con2.close();
				}catch(Exception e) {}
				
				
			}
			
			try {
				DbConnection db2=new DbConnection();
				con2=db.getConnObject2();
				
				String Query2="select count(*) from cspdcl_OUTPUT where SUBSTR(MRU,3,2)='"+group_code+"'";
				System.out.println("Query2= "+Query2);
				rs2=dbs.exicuteQueryReesultSet(Query2, con2, rs2, ps2);
				while (rs2.next()) {
					
					dp.setTOTAL_COUNT(rs2.getString("count(*)"));
					
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {if(rs2!=null)
					rs2.close();
				}catch(Exception e) {}
				
				try {if(ps2!=null)
					ps2.close();
				}catch(Exception e) {}
				try {if(con2!=null)
					con2.close();
				}catch(Exception e) {}
				
				
			}
			
			
			
			li.add(dp);
			
		//	System.out.println(li);
			
		}
		
	}catch (Exception e) {
		e.printStackTrace();
	}finally {
		try {if(count!=null)
			count.close();
		}catch(Exception e) {}
		
		try {if(ps1!=null)
			ps1.close();
		}catch(Exception e) {}
		try {if(con!=null)
			con.close();
		}catch(Exception e) {}
		
		
	}
	return li;
}




}
