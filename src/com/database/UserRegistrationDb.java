package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.pojo.UserRegistration;

import oracle.jdbc.proxy.annotation.Pre;

public class UserRegistrationDb {

	public boolean MeterReaderUpdate(UserRegistration ur) {
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		boolean status=false;
		DbConnection db=new DbConnection();
		
		String login_update_query="update CSPDCL_LOGIN set IMEI_1='"+ur.getImei1()+"', IMEI_2='"+ur.getImei2()+"' where USER_NAME='"+ur.getUserid()+"'";
		System.out.println("login_update_query= "+login_update_query);
		String mr_data_allocation_query="update CSPDCL_DATA_ALLOCATION set IMEI_1='"+ur.getImei1()+"', IMEI_2='"+ur.getImei2()+"' where USER_NAME='"+ur.getUserid()+"'";
		System.out.println("login_update_query= "+login_update_query);
		String checking_query="select * from CSPDCL_DATA_ALLOCATION WHERE  MONTH BETWEEN trunc (sysdate, 'mm')  AND SYSDATE";
		
		try {
			
		   con=db.getConnObject2();
		   DataBaseOperations dbo=new DataBaseOperations();
		  int update_login= dbo.exicuteQuery(login_update_query, con);
		  status=true;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
		
			try {
				
				if(con!=null)
					con.close();
				}catch (Exception e) {}
				
			
		}
		
		try {
			
			   con=db.getConnObject2();
			   DataBaseOperations dbo=new DataBaseOperations();
				  int update_mr= dbo.exicuteQuery(mr_data_allocation_query, con);
				  status=true;
				  
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					
					if(con!=null)
						con.close();
					}catch (Exception e) {}
					
				}
		
		
		if(ur.getGroups()!=null && !ur.getGroups().equalsIgnoreCase("null")) {
		try {
			
			
			String[] groups=ur.getGroups().split(",");
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			Date date = new Date();
			System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());

			for(int i=0;i<groups.length;i++) {
				String Checking_Query="select * from CSPDCL_DATA_ALLOCATION WHERE GROUP_CODE='"+groups[i]+"' and USER_NAME='"+ur.getUserid()+"' and  MONTH BETWEEN trunc (sysdate, 'mm')  AND SYSDATE";

					System.out.println("Checking_Query= "+Checking_Query);
				if(db.status(Checking_Query)==false) {
					
					   DataBaseOperations dbo=new DataBaseOperations();

			   con=db.getConnObject2();
			   
			   String query3="INSERT INTO CSPDCL_DATA_ALLOCATION(GROUP_CODE,MONTH,DC_CODE,USER_NAME) VALUES('"+groups[i]+"',to_date('"+dateFormat.format(date)+"','yyyy/MM/dd'),'"+ur.getDccode()+"','"+ur.getUserid()+"')";
				System.out.println("query3= "+query3);
			   
			   int insrt_rows3 = dbo.exicuteQuery(query3, con);
			
			try {
				con.commit();
			}catch(Exception ee) {
				ee.printStackTrace();
			}
				}
			
			}
		}catch (Exception e) {
			e.printStackTrace();
//			  status_message=false;
			  try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			  
			  e.printStackTrace();
			  
		}finally {
			try {
			if(rs!=null)
				rs.close();
			
			if(ps!=null)
				ps.close();
			
			if(con!=null)
				con.close();
			}catch (Exception e) {}
			
		}
		}
		return status;
		
		
		
	}
	
	
public boolean MeterReaderUpdate2(UserRegistration ur) {  // groups delete AND adding
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		boolean status=false;
		DbConnection db=new DbConnection();
		
		String login_update_query="update CSPDCL_LOGIN set IMEI_1='"+ur.getImei1()+"', IMEI_2='"+ur.getImei2()+"' where USER_NAME='"+ur.getUserid()+"'";
		System.out.println("login_update_query= "+login_update_query);
		//String mr_data_allocation_query="update CSPDCL_DATA_ALLOCATION set IMEI_1='"+ur.getImei1()+"', IMEI_2='"+ur.getImei2()+"' where USER_NAME='"+ur.getUserid()+"'";
		System.out.println("login_update_query= "+login_update_query);
		String checking_query="select * from CSPDCL_DATA_ALLOCATION WHERE  MONTH BETWEEN trunc (sysdate, 'mm')  AND SYSDATE";
	
		try {
			
		   con=db.getConnObject2();
		   DataBaseOperations dbo=new DataBaseOperations();
		  int update_login= dbo.exicuteQuery(login_update_query, con);
		  status=true;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {

			try {
				
				if(con!=null)
					con.close();
				}catch (Exception e) {
					
				}finally {
					
					try {
						if(rs!=null)
							rs.close();
						
						if(ps!=null)
							ps.close();
						
						if(con!=null)
							con.close();
						}catch (Exception e) {}
						
				}
				
			
		}
		
		/*try {
			
			   con=db.getConnObject2();
			   DataBaseOperations dbo=new DataBaseOperations();
				  int update_mr= dbo.exicuteQuery(mr_data_allocation_query, con);
				  status=true;
				  
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					
					if(con!=null)
						con.close();
					}catch (Exception e) {}
					
				}
*/		
		
		if(ur.getGroups()!=null && !ur.getGroups().equalsIgnoreCase("null")) {
		try {
			
			
			String[] groups=ur.getGroups().split(",");
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			Date date = new Date();
			System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			
			
			String Checking_Query="delete from CSPDCL_DATA_ALLOCATION WHERE USER_NAME='"+ur.getUserid()+"' and  MONTH BETWEEN trunc (sysdate, 'mm')  AND SYSDATE";
			System.out.println("Checking_Query= "+Checking_Query);
	          db.status(Checking_Query);  // deleting the existing group of the user
		
			for(int i=0;i<groups.length;i++) {

					
					   DataBaseOperations dbo=new DataBaseOperations();

			   con=db.getConnObject2();
			   
			   String query3="INSERT INTO CSPDCL_DATA_ALLOCATION(GROUP_CODE,MONTH,DC_CODE,USER_NAME) VALUES('"+groups[i]+"',to_date('"+dateFormat.format(date)+"','yyyy/MM/dd'),'"+ur.getDccode()+"','"+ur.getUserid()+"')";
				System.out.println("query3= "+query3);
			   
			   int insrt_rows3 = dbo.exicuteQuery(query3, con);
			
			try {
				con.commit();
			}catch(Exception ee) {
				ee.printStackTrace();
			}
				
			
			}
		}catch (Exception e) {
			e.printStackTrace();
//			  status_message=false;
			  try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			  
			  e.printStackTrace();
			  
		}finally {
			try {
			if(rs!=null)
				rs.close();
			
			if(ps!=null)
				ps.close();
			
			if(con!=null)
				con.close();
			}catch (Exception e) {}
			
		}
		}
		return status;
		
		
		
	}
	
	
	 public synchronized boolean MRstore(UserRegistration ur) 
	    { 
		 DbConnection db=new DbConnection();
		 Connection con=null;
			PreparedStatement ps=null;
			ResultSet rs=null;
		 
			boolean status_message=false;
			try {
				
				
			   con=db.getConnObject2();
			   DataBaseOperations dbo=new DataBaseOperations();
			  rs= dbo.exicuteQueryReesultSet("select max(METER_READER_UID) as id from CSPDCL_METER_READERS", con, rs, ps);
			   
			  int insrt_rows=0,insrt_rows2=0;
			  while (rs.next()) {
				
				   String Query="INSERT INTO CSPDCL_METER_READERS(METER_READER_UID,METER_READER_NAME,METER_READER_FATHER_NAME,METER_READER_ADDRESS) VALUES("+(rs.getInt("id")+1)+",'"+ur.getMrname()+"','"+ur.getFname()+"','"+ur.getAddress()+"')";
				  
/*				   String Query="INSERT INTO CSPDCL_METER_READERS(METER_READER_UID,METER_READER_NAME,METER_READER_FATHER_NAME,METER_READER_ADDRESS) VALUES("+11+",'"+ur.getMrname()+"','"+ur.getFname()+"','"+ur.getAddress()+"')";
*/
				  System.out.println(Query);
				 insrt_rows=dbo.exicuteQuery(Query, con);
				
				if(insrt_rows>0) {
					   String Query2="INSERT INTO CSPDCL_LOGIN(USER_NAME,PASSWORD,EMAIL,MOBILE_NUM,DESIGNATION_CODE,IMEI_1,IMEI_2,METER_READER_UID,SUPER_ID) VALUES('"+ur.getUserid()+"','"+ur.getPassword()+"','"+ur.getEmail()+"','"+ur.getMobile()+"','"+ur.getDesigantion()+"','"+ur.getImei1()+"','"+ur.getImei2()+"','"+(rs.getInt("id")+1)+"','"+ur.getSuperid()+"')";
					   System.out.println(Query2);

					 insrt_rows2=dbo.exicuteQuery(Query2, con);

				}
			}
			
			  if(insrt_rows2>0 && insrt_rows>0) {
				  status_message=true;
				con.commit();  
			  }
			  
			
			}catch (Exception e) {
				
				  status_message=false;
				  try {
					con.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				  
				  e.printStackTrace();
				  
			}finally {
				try {
				if(rs!=null)
					rs.close();
				}catch (Exception e) {}
				try {
				if(ps!=null)
					ps.close();
				}catch (Exception e) {}
				try {
				if(con!=null)
					con.close();
				}catch (Exception e) {}
				
			}
			
			
			if(ur.getGroups()!=null && !ur.getGroups().equalsIgnoreCase("null")) {
			try {
				
				
				String[] groups=ur.getGroups().split(",");
				
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
				Date date = new Date();
				System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
				java.sql.Date sqlDate = new java.sql.Date(date.getTime());

				for(int i=0;i<groups.length;i++) {
				
					if(con.isClosed())
				   con=db.getConnObject2();
				   DataBaseOperations dbo=new DataBaseOperations();
				   
				   String query3="INSERT INTO CSPDCL_DATA_ALLOCATION(GROUP_CODE,MONTH,DC_CODE,USER_NAME) VALUES('"+groups[i]+"',to_date('"+dateFormat.format(date)+"','yyyy/MM/dd'),'"+ur.getDccode()+"','"+ur.getUserid()+"')";
					System.out.println("query3= "+query3);
				   
				   int insrt_rows3 = dbo.exicuteQuery(query3, con);
				
				
				
				}
			}catch (Exception e) {
				
				  status_message=false;
				  try {
					con.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				  
				  e.printStackTrace();
				  
			}finally {
				try {
				if(rs!=null)
					rs.close();
				}catch (Exception e) {}
				try {
				if(ps!=null)
					ps.close();
				}catch (Exception e) {}
				try {
				if(con!=null)
					con.close();
				}catch (Exception e) {}
				
			}
			}
			
			
			
			return status_message;
	    } 
	
	
}
