
package com.database;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//import org.apache.log4j.nt.NTEventLogAppender;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*import org.apache.log4j.PropertyConfigurator;
*/

public class DbConnection implements ServletContextListener
{
	Connection condb=null;
	Statement stmt=null;
	java.util.Properties dbproperties = null;

	Connection con=null;
	PreparedStatement ps=null,ps1=null,ps2=null,ps3=null;
	String divison=null;
	String roll=null;
	String div=null;
	String dbuser=null;
	String dbpwd=null;
	String areacode="";
	String EMP_TYPE=null,query=null,query1=null,query2=null,query3=null,query4=null,query5="",query6="",query7="",query8="",query9="";
	ResultSet rs=null,count=null,count_billable=null,count_billed=null;
	ResultSet rst=null;
	int total_consumers=0,total_consumers_billable=0,total_consumers_billed=0;
	
	
	

	
	String DriverClass="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:orcl";
//	String url="jdbc:oracle:thin:@localhost:1521:xe";

//	String url="jdbc:oracle:thin:@localhost:1521:server";
//	String url="jdbc:oracle:thin:@124.123.41.255:1521:orcl";

//	String username="agrabo";
//	String password="agrabo";
//	String username2="raipurbo1";
//	String password2="raipurbo1";
	
	String username2="CSPDCL";
	String password2="CSPDCL";

	public void contextDestroyed(ServletContextEvent sce)
	{

		try {
			if(condb != null) condb.close();  
		} catch (SQLException e) { e.printStackTrace(); }	
	}	

	public void contextInitialized(ServletContextEvent sce)
	{
		String errMsg="";
		try {
			//log4j configuration
			ServletContext ctx=sce.getServletContext();
	        
			//database configuration	
			String propPath=ctx.getRealPath("/properties/database.properties");  			
			dbproperties = new java.util.Properties () ;
			dbproperties.load(new java.io.FileInputStream(propPath));
			String url="jdbc:oracle:thin:@"+dbproperties.getProperty("ipaddress").trim()+":1521:"+dbproperties.getProperty("servicename").trim();
			String user=dbproperties.getProperty("username").trim();
			String password=dbproperties.getProperty("password").trim();				 			
			java.sql.DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver()) ;
			condb = DriverManager.getConnection(url, user, password);
			ctx.setAttribute("MyConnection",condb);
		} catch (Exception e) 
		{	 
			errMsg="Err:- "+e.getMessage();
			e.printStackTrace(); 
		}
		finally
		{
			if(!( (errMsg == null) || (errMsg.trim().equals("")) ))
			{
				System.out.println("****Error:- DataBase Connection(ConnectionListener class): "+errMsg);

			}
		}
	}
	
	public Connection getConnObject()
	{
		
		try{
			Class.forName(DriverClass);
			
			con = DriverManager.getConnection(url,username,password);
			 
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		return con;
	}
	
	
	public Connection getConnObject2()
	{
		
		try{
			Class.forName(DriverClass);
			
			con = DriverManager.getConnection(url,username2,password2);
			 
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		return con;
	}
	
	
	public boolean status(String Quary)
	{
		

		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null; 
		boolean status =false;
		try{
			//int rowno1=Integer.parseInt(rowno)
		
		
		String scno=null;
		String book=null;
		
		/*DbConnection db1=new DbConnection();
		//DataBase db=new DataBase();
	    conn=db1.getConnObject();*/
		
		try{
			Class.forName(DriverClass);
			
			conn = DriverManager.getConnection(url,username2,password2);
			 
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		
		
		
	    ps = conn.prepareStatement(Quary);
	    rs = ps.executeQuery();
	    status = rs.next();
	    

	}catch(Exception e)
	{
		System.out.println(e);
	} finally
    {
  	  if (conn != null) {
  	        try
  	        {conn.commit();
  	        	 if (rs != null)
  	  	        	rs.close();
  	      }catch(Exception e){e.printStackTrace();} 
  	        try
  	        {if (ps != null)
  	  	        	ps.close();
  	      }catch(Exception e){e.printStackTrace();}
  	      try{	
  	        if (conn != null){
  	        	conn.commit();
  	          conn.close();
  	           	        
  	        }
  	       
  	        }catch(Exception e){
  	        	e.printStackTrace();
  	        }
  	  }
  }
		return status;
}
	
	public DataGettingPojo BillingTableData(String name,ArrayList<String> li1){
		
		String option=null;
		String Areacode=null;
		ArrayList<String> li=null;
		HashMap<String,String> mp=null;
		
		//system.out.println("Db Emp_Type="+name);
		
		DataGettingPojo dgp=new DataGettingPojo();
		
		try{  
			
			li=new ArrayList<String>();
			
			mp=new HashMap<String,String>();
			
			li=li1;
		
			DbConnection dbc=new DbConnection();
			con=dbc.getConnObject();
			

			/*
			 * 1.query= billed consumers
			 * 2.query2=Total consumers in medica
			 * 3.qury3=below 4 load Billed consumers
			 * 4.qury4=load 4 to 10 billed consumers
			 * 5.quary5= load above 10 billed consumers
			 * 6.quary6=Unmeterd consumers
			 * 7.quary7=Billable Consumers
			 * 8.quary8=meterd consumers
			 * 
			 * */
			
			/* area code KW = method KW
			 * area code AR = method AR
			 * area code EP = method ET
			 * area code FB = method FW
			 */
			
			
			
			
			String AR_query=null;
			String AR_query3=null;
			String AR_query4=null;
			String AR_query2=null;
			String AR_query5=null;
			String AR_query6=null;
			String AR_query7=null;
			String AR_query8=null;
			String AR_query9=null;
			String AR_query10=null;
			String AR_query11=null;
			String AR_query12=null;
			String AR_query13=null;
			
			
			
			
			int AR_unMeterd=0;
			int AR_Billabe=0;
			int AR_meterd=0;
			int AR_Billed_consumers=0;
			int AR_total_consumers=0;
			int AR_0to4=0;
			int AR_4to10=0;
			int AR_10abve=0;
			int AR_0to4_total=0;
			int AR_4to10_total=0;
			int AR_10abve_total=0;
			int AR_meterd_billed=0;
			int AR_unmeter_billed=0;
		
			
			
			
			
		
				
				
				String AreaName=null;
				int listSize=li.size();
				
				//system.out.println("List size="+listSize);
				
				for(int i=0;i<listSize;i++){
					
					
					Areacode=li.get(i);
					
					
					 ps1 = con.prepareStatement("select DIVISION_NAME from division_details where DIVISION_ID='"+Areacode+"'");
					count=ps1.executeQuery();
					while(count.next()){
						AreaName=count.getString("DIVISION_NAME"); 
						
						//system.out.println("AreaName= "+AreaName);
					}
					
					if(count!=null)
						count.close();
					if(ps1!=null)
						ps1.close();

			//sbmtopc_agra
				
				AR_query = "select  count(*)as total_consumers from sbmtopc_android where areacode='"+Areacode+"'";									//* total billed consumers in one area code wise
				AR_query3="select count(*)as total_consumers from sbmtopc_android where sload<=4 and areacode='"+Areacode+"'";						//* billed consumers below load 4
				AR_query4="select count(*)as total_consumers from sbmtopc_android where sload>4 and sload <=10 and areacode='"+Areacode+"'";		//* billed consumers load 4< to >=10
				AR_query5="select count(*)as total_consumers from sbmtopc_android where sload>10 and areacode='"+Areacode+"'";						//*billed consumers above load 10
				AR_query12="select count(*)as total_consumers from sbmtopc_android where (BILL_BASE='1' or BILL_BASE='01') and areacode='"+Areacode+"'"; 		// meterd billed consumer 
				AR_query13="select count(*)as total_consumers from sbmtopc_android where (BILL_BASE!='1' and BILL_BASE!='01') and areacode='"+Areacode+"'";	//unmeterd  billed consumers

				//medical_agra
				AR_query2="select count(*)as total_consumers from medical_agra where areacode='"+Areacode+"'";												//* total consumers from medical table areacode wise
				AR_query6="select count(*)as total_consumers from medical_agra where MNO='DR1111' and REC_STATUS='B' and areacode='"+Areacode+"'";			//total billable unmeterd consumers from medical 
				AR_query7="select count(*)as total_consumers from medical_agra where REC_STATUS='B' and areacode='"+Areacode+"'";							//total billable consumers from table
				AR_query8="select count(*)as total_consumers from medical_agra where MNO!='DR1111' and REC_STATUS='B' and areacode='"+Areacode+"'";			//total billable meterd consumers from medical 
				AR_query9="select count(*)as total_consumers from medical_agra where load<=4 and REC_STATUS='B' and areacode='"+Areacode+"'";				//total billable consumers below load 4 from medical
				AR_query10="select count(*)as total_consumers from medical_agra where load>4 and load<=10 and REC_STATUS='B' and areacode='"+Areacode+"'";	//* total billable consumers load 4< to >=10 from medical
				AR_query11="select count(*)as total_consumers from medical_agra where load>10 and REC_STATUS='B' and areacode='"+Areacode+"'";				//*total billable consumers above load 10 from medical
				
				
				//new code--start
				
				//Ar values
				//Division AR ----- start
				ps1 = con.prepareStatement(AR_query);
				count=ps1.executeQuery();
				while(count.next()){
					AR_Billed_consumers=count.getInt("total_consumers"); 
				}
				
				if(count!=null)
					count.close();
				if(ps1!=null)
					ps1.close();
				
				ps1 = con.prepareStatement(AR_query2);
				count=ps1.executeQuery();
				while(count.next()){
					AR_total_consumers=count.getInt("total_consumers");
				}
				
				if(count!=null)
					count.close();
				if(ps1!=null)
					ps1.close();
				
				ps1 = con.prepareStatement(AR_query3);
				count=ps1.executeQuery();
				while(count.next()){
					AR_0to4=count.getInt("total_consumers");
				}
				
				if(count!=null)
					count.close();
				if(ps1!=null)
					ps1.close();
				
				ps1 = con.prepareStatement(AR_query4);
				count=ps1.executeQuery();
				while(count.next()){
					AR_4to10=count.getInt("total_consumers");
				}
				
				if(count!=null)
					count.close();
				if(ps1!=null)
					ps1.close();
				
				ps1 = con.prepareStatement(AR_query5);
				count=ps1.executeQuery();
				while(count.next()){
					AR_10abve=count.getInt("total_consumers");
				}
				
				if(count!=null)
					count.close();
				if(ps1!=null)
					ps1.close();
				
				ps1 = con.prepareStatement(AR_query6);
				count=ps1.executeQuery();
				while(count.next()){
					AR_unMeterd=count.getInt("total_consumers");
				}
				
				if(count!=null)
					count.close();
				if(ps1!=null)
					ps1.close();
				
				ps1 = con.prepareStatement(AR_query7);
				count=ps1.executeQuery();
				while(count.next()){
					AR_Billabe=count.getInt("total_consumers");
				}
				
				if(count!=null)
					count.close();
				if(ps1!=null)
					ps1.close();
				
				ps1 = con.prepareStatement(AR_query8);
				count=ps1.executeQuery();
				while(count.next()){
					AR_meterd=count.getInt("total_consumers");
				}
				
				if(count!=null)
					count.close();
				if(ps1!=null)
					ps1.close();
				
				ps1 = con.prepareStatement(AR_query9);
				count=ps1.executeQuery();
				while(count.next()){
					AR_0to4_total=count.getInt("total_consumers");
				}
				
				if(count!=null)
					count.close();
				if(ps1!=null)
					ps1.close();
				
				ps1 = con.prepareStatement(AR_query10);
				count=ps1.executeQuery();
				while(count.next()){
					AR_4to10_total=count.getInt("total_consumers");
				}
				
				if(count!=null)
					count.close();
				if(ps1!=null)
					ps1.close();
				
				ps1 = con.prepareStatement(AR_query11);
				count=ps1.executeQuery();
				while(count.next()){
					AR_10abve_total=count.getInt("total_consumers");
				}
				
				if(count!=null)
					count.close();
				if(ps1!=null)
					ps1.close();
				ps1 = con.prepareStatement(AR_query12);
				count=ps1.executeQuery();
				while(count.next()){
					AR_meterd_billed=count.getInt("total_consumers");
				}
				
				if(count!=null)
					count.close();
				if(ps1!=null)
					ps1.close();
				ps1 = con.prepareStatement(AR_query13);
				count=ps1.executeQuery();
				while(count.next()){
					AR_unmeter_billed=count.getInt("total_consumers");
				}
				
		
				
				if(count!=null)
					count.close();
				if(ps1!=null)
					ps1.close();
				//Division AR ----- end
				
				float AR_meterd_percentage=((Float.parseFloat(""+AR_meterd_billed))*100)/(Float.parseFloat(""+AR_total_consumers));
				float AR_Unmeterd_percentage=((Float.parseFloat(""+AR_unmeter_billed))*100)/(Float.parseFloat(""+AR_total_consumers));
				float AR__0to4_percentage=((Float.parseFloat(""+AR_0to4))*100)/(Float.parseFloat(""+AR_0to4_total));
				if(Float.isNaN(AR__0to4_percentage)){
					AR__0to4_percentage=0;
				}else{
					AR__0to4_percentage=Math.round(AR__0to4_percentage*100/100);
				}
				float AR__4to10_percentage=((Float.parseFloat(""+AR_4to10))*100)/(Float.parseFloat(""+AR_4to10_total));
				if(Float.isNaN(AR__4to10_percentage)){
					AR__4to10_percentage=0;
				}else{
					AR__4to10_percentage=Math.round(AR__4to10_percentage*100/100);
				}
				float AR__10above_percentage=((Float.parseFloat(""+AR_10abve))*100)/(Float.parseFloat(""+AR_10abve_total));
				if(Float.isNaN(AR__10above_percentage)){
					AR__10above_percentage=0;
				}else{
					AR__10above_percentage=Math.round(AR__10above_percentage*100/100);
				}
				
				//system.out.println(Areacode+"="+AR_meterd_percentage+","+AR_Unmeterd_percentage+","+AR__0to4_percentage+","+AR__4to10_percentage+","+AR__10above_percentage+"");
				mp.put("name", name);
				mp.put(Areacode+"_areaName",AreaName);
				mp.put(Areacode+"_0to4", ""+AR_0to4);
				mp.put(Areacode+"_4to10",""+AR_4to10);
				mp.put(Areacode+"_10abve",""+AR_10abve);
				mp.put(Areacode+"_Billabe",""+AR_Billabe);
				mp.put(Areacode+"_Billed_consumers",""+AR_Billed_consumers);
				mp.put(Areacode+"_meterd",""+AR_meterd);
				mp.put(Areacode+"_total_consumers",""+AR_total_consumers);
				mp.put(Areacode+"_unMeterd",""+AR_unMeterd);
				mp.put(Areacode+"__0to4_percentage",""+AR__0to4_percentage);
				mp.put(Areacode+"__4to10_percentage",""+AR__4to10_percentage);
				mp.put(Areacode+"__10above_percentage",""+AR__10above_percentage);
				mp.put(Areacode+"_meterd_percentage",""+AR_meterd_percentage);
				mp.put(Areacode+"_Unmeterd_percentage",""+AR_Unmeterd_percentage);
				mp.put(Areacode+"_0to4_total",""+AR_0to4_total);
				mp.put(Areacode+"_4to10_total",""+AR_4to10_total);
				mp.put(Areacode+"_10abve_total",""+AR_10abve_total);
				mp.put(Areacode+"_meterd_billed",""+AR_meterd_billed);
				mp.put(Areacode+"_unmeter_billed",""+AR_unmeter_billed);
				
				
				
				//system.out.println("AreaName="+AreaName+"AR_0to4="+AR_0to4+"AR_4to10="+AR_4to10+"AR_10abve="+AR_10abve+"AR_Billabe="+AR_Billabe+"AR_Billed_consumers="+AR_Billed_consumers+"AR_meterd="+AR_meterd+"AR_total_consumers="+AR_total_consumers+"AR_unMeterd="+AR_unMeterd+"AR__0to4_percentage="+AR__0to4_percentage+"AR__4to10_percentage="+AR__4to10_percentage+"AR__10above_percentage="+AR__10above_percentage+"AR_meterd_percentage="+AR_meterd_percentage+"AR_Unmeterd_percentage="+AR_Unmeterd_percentage+"AR_0to4_total="+AR_0to4_total+"AR_4to10_total="+AR_4to10_total+"AR_10abve_total="+AR_10abve_total+"AR_meterd_billed="+AR_meterd_billed+"AR_unmeter_billed="+AR_unmeter_billed);
				
				
				 AR_unMeterd=0;
				 AR_Billabe=0;
				 AR_meterd=0;
				 AR_Billed_consumers=0;
				 AR_total_consumers=0;
				 AR_0to4=0;
				 AR_4to10=0;
				 AR_10abve=0;
				 AR_0to4_total=0;
				 AR_4to10_total=0;
				 AR_10abve_total=0;
				 AR_meterd_billed=0;
				 AR_unmeter_billed=0;
				
				//new code--- end
				
			}
				dgp.setMap(mp);
				dgp.setLi(li);
				
			//Division AR ----- end
			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
			if(con!=null)
				con.close();
			if(count!=null)
				count.close();
			if(ps1!=null)
				ps1.close();
			}
			catch(Exception e){
				
			}
				
			
		}
		return dgp;
		
	}
	

	public DataGettingPojo MeterReadersLiveList(ArrayList<String> li1){
		
		//variables
		
		HashMap<String,String> mp=null;
		DataGettingPojo dgp2=new DataGettingPojo();
		
		//get the today date--start
	    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    Date date = new Date();
	    String todaydate = dateFormat.format(date);
	    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
	    
	    
	    //System.out.println("sqlDate= "+todaydate);
		//get the today date--end
	    
	    
	    int listSize=li1.size();
		
		//system.out.println("List size="+listSize);
		mp=new HashMap<String,String>();

		
		for(int i=0;i<listSize;i++){
			
			
			String Areacode=li1.get(i);

//			String mac_id=null;
//			String max_bill_num=null;
//			String total_bills=null;
//			String bill_time=null;
//			String meter_reader_name=null;
		
		
		Connection conn2=null;
		PreparedStatement ps=null,ps1=null,ps2=null;
		ResultSet rs = null,rs1=null,rs2=null;
		
		//System.out.println("area code= "+Areacode);
		
		try{
		DbConnection dbc=new DbConnection();
		conn2=dbc.getConnObject();
		
		String queary="select distinct mac_id,count(*),max(bill_no) from sbmtopc_android  where bill_dt=to_date('18/01/2017','dd/mm/yyyy')  and areacode=? group by mac_id";
		String Query2="select BILL_TIME from sbmtopc_android where mac_id=? and BILL_NO=?";
		String Query3="SELECT NAME FROM METER_READER_DETAILS WHERE ? IN(IMEI_1, IMEI_2);";
		
			ps=conn2.prepareStatement("select distinct mac_id,count(*),max(bill_no) from sbmtopc_android  where bill_dt=to_date('"+todaydate+"','dd/mm/yyyy')  and areacode=? group by mac_id");
			ps.setString(1, Areacode);
			rs=ps.executeQuery();
			
			int j=1;
		while(rs.next()){
			
			String mac_id=null;
			String max_bill_num=null;
			String total_bills=null;
			String bill_time=null;
			String meter_reader_name=null;
		
			
			mac_id=rs.getString("mac_id");
			max_bill_num=rs.getString("max(bill_no)");
			total_bills=rs.getString("count(*)");
			
			
			ps1=conn2.prepareStatement("select BILL_TIME from sbmtopc_android where mac_id=? and BILL_NO=?");
			ps1.setString(1, mac_id);
			ps1.setString(2, max_bill_num);
			rs1=ps1.executeQuery();
			
			while(rs1.next()){
				bill_time=rs1.getString("BILL_TIME");
			}
			
			ps2=conn2.prepareStatement("SELECT NAME FROM METER_READER_DETAILS WHERE ? IN(IMEI_1, IMEI_2)");
			ps2.setString(1, mac_id);
			rs2=ps2.executeQuery();
			
			while(rs2.next()){
				meter_reader_name=rs2.getString("name");
			}
			
			//null deletion--start
			
			if(mac_id==null)
				mac_id="-";
			if(max_bill_num==null)
				max_bill_num="-";
			if(total_bills==null)
				total_bills="-";
			if(bill_time==null)
				bill_time="-";
			if(meter_reader_name==null)
				meter_reader_name="-";
			//null deletion--end
			//set the values in to map
			mp.put(Areacode+"mac_id"+j, mac_id);
			mp.put(Areacode+"max_bill_num"+j, max_bill_num);
			mp.put(Areacode+"total_bills"+j, total_bills);
			mp.put(Areacode+"bill_time"+j, bill_time);
			mp.put(Areacode+"meter_reader_name"+j, meter_reader_name);
			mp.put(Areacode+"count_value", ""+j);
			
			
		//System.out.println("mac_id="+mac_id+" max_bill_num= "+max_bill_num+" total_bills="+total_bills+"bill_time= "+bill_time+" name="+meter_reader_name);
			j++;
		}
		
		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(conn2!=null)
					conn2.close();
				if(rs!=null)
					rs.close();
				if(rs1!=null)
					rs1.close();
				if(rs2!=null)
					rs2.close();
				if(ps!=null)
					ps.close();
				if(ps1!=null)
					ps1.close();
				if(ps2!=null)
					ps2.close();
			}catch(Exception ne){
				
			}
		}
		
		
		
		
	}//for loop close
		dgp2.setMap(mp);
		
		//System.out.println("Readers live status="+mp);
		
		return dgp2;
	
	}
	

	@SuppressWarnings("null")
	public String[][] salaryCalculation(){
		
		
		Connection conn2 = null;
		PreparedStatement ps4 = null,ps41 = null,ps42 = null;
		ResultSet rss = null,rss1 = null,rss2 = null;
	
		String[][] shades = null;
		int rows=0;
		int columns=0;
		try{
			
			System.out.println("satrt");
			
			DbConnection db=new DbConnection();
			 conn2 = db.getConnObject();
			 ps4 = conn2.prepareStatement("select * from VAIBHU_REDERS_MONTHLY_BILLS");
			 rss = ps4.executeQuery();
			 
			 ps41 = conn2.prepareStatement("select count(*) from VAIBHU_REDERS_MONTHLY_BILLS");
			 rss1 = ps41.executeQuery();
			 while (rss1.next())
				 rows=rss1.getInt("count(*)");
			 
			 
			 ps42 = conn2.prepareStatement("select count(*)  from user_tab_columns where table_name='VAIBHU_REDERS_MONTHLY_BILLS'");
			 rss2 = ps42.executeQuery();
			 while (rss2.next())
				 columns=rss2.getInt("count(*)");
			 
			 
			shades = new String[rows+1][23];


			
			
			//calculate the no.of days in a month
			
			int iYear = 2017;
			int iMonth = Calendar.DECEMBER; // 1 (months begin with 0)
			int iDay = 1;

			// Create a calendar object and set year and month
			Calendar mycal = new GregorianCalendar(iYear, iMonth, iDay);

			// Get the number of days in that month
			int daysInMonth = mycal.getActualMaximum(Calendar.DAY_OF_MONTH); // 28
			
			
			System.out.println("no.of days in moth= "+daysInMonth);
			
			
			
			
			//siing the values to array of string
			shades[0][0]="SL No";	
			shades[0][1]="Name of the Employee";
		    shades[0][2]="Name as per Bank";
		    shades[0][3]="Division";
            shades[0][4]="Designation";
			shades[0][5]="Month Days";
			shades[0][6]="No of Days Present";
	      	shades[0][7]="Basic	";
			shades[0][8]="V.D.A	";
			shades[0][9]="Earning / Gross salary";
			shades[0][10]="TDS";
			shades[0][11]="PF(12% Basic)";
			shades[0][12]="PT";
			shades[0][13]="ESI";
			shades[0][14]="ESI";
			shades[0][15]="PF(8.33% Basic)";	
			shades[0][16]="PF (Diff of 12%-8.33%)";
			shades[0][17]="PF (0.65% Basic)";
			shades[0][18]="PF (0.5% Basic)";
			shades[0][19]="PF (0.01% Basic)";
			shades[0][20]="Advances";
			shades[0][21]="Total Deduct";
			shades[0][22]="Net Salary";
			
			
			
			
			
			
			
			
			
			
			
			
			
			int i=1;
			while(rss.next()){
				String EMP_NAME=rss.getString("EMP_NAME");
				String DIVISION=rss.getString("DIVISION");
				String DESIGNATION=rss.getString("DESIGNATION");
				String BILL_QTY=rss.getString("BILL_QTY");
				String RATE=rss.getString("RATE");
				
				
				
				//salary calculations
				int UP_act_basic=6325;
				int UP_act_vda=	1816;	
				//as per up act per day amount calculation
				int UP_act_basic_day=UP_act_basic/daysInMonth;
				int UP_act_vda_day=	UP_act_vda/daysInMonth;
				
				//System.out.println("RATE= "+RATE);
				int Gross_salary=Integer.parseInt(BILL_QTY)*Integer.parseInt(RATE.trim());
				
				int Emp_working_days=Gross_salary/(UP_act_basic_day+UP_act_vda_day);
				
				int base_salary  =Emp_working_days*UP_act_basic_day;
				int vda          =Gross_salary-base_salary;
				
				
				
				//testing--start
				/*if(Gross_salary==(base_salary+vda))
					System.out.println("true");
				else
					System.out.println("false gross="+(Gross_salary-base_salary-vda));
			*/
				
				
				if(vda==(Emp_working_days*UP_act_basic))
					System.out.println("");
				else
					System.out.println("vda diff ="+(vda-(Emp_working_days*UP_act_vda_day)));
				//testing--end
				
				//employee share
				double pf1=0;
				double esi1=0,esi2=0;
				double pf2 = 0,pf3 = 0,pf4 = 0,pf5 = 0,pf6 = 0;
				int advances=0;
				double total_deductions=0;
				
				double pt=0;
				
				if(base_salary>15000)
					pf1=1800;
				else
				    pf1=Math.round(((base_salary*12)/100));
				
				//-----------------------------------------------------
				
				if(base_salary<15000)
					esi1=Math.round(((Gross_salary*1.75)/100));
				//employee share end
				
				
				//employer share
			
				if(base_salary>15000)
					pf2=1250;
				else
					pf2=Math.round(((base_salary*8.33)/100));
				
				//-----------------------------------------------------	
				
				 pf3=(int) (pf1-pf2);
	//-----------------------------------------------------
				if(base_salary>15000)
					pf4=98;
				else
				 pf4=Math.round(((base_salary*0.65)/100));
	//-----------------------------------------------------
				if(base_salary>15000)
					pf5=75;
				else
				 pf5=Math.round(((base_salary*0.50)/100));
	//-----------------------------------------------------
				if(base_salary>15000)
					pf1=0;
				else
				 pf6=Math.round(((base_salary*0.01)/100));
				
	//-----------------------------------------------------
				esi2=Math.round(((Gross_salary*4.75)/100));
	//-----------------------------------------------------
				if(Gross_salary>15000 && Gross_salary < 20000)
					pt=150;
				if(Gross_salary > 20000)
					pt=200;
				total_deductions=pf1+esi1+advances+pt;
				
				double net_salary = Gross_salary-total_deductions;
				
				/*shades[i][0]=EMP_NAME;
				shades[i][1]=DIVISION;
				shades[i][2]=DESIGNATION;
				shades[i][3]=BILL_QTY;
				shades[i][4]=RATE;*/
				
				
				shades[i][0]=i+"";	
				shades[i][1]=EMP_NAME;
			    shades[i][2]="Name as per Bank";
			    shades[i][3]=DIVISION;
	            shades[i][4]=DESIGNATION;
				shades[i][5]=daysInMonth+"";
				shades[i][6]=Emp_working_days+"";
		      	shades[i][7]=base_salary+"";
				shades[i][8]=vda+"";
				shades[i][9]=Gross_salary+"";
				shades[i][10]="TDS";
				shades[i][11]=pf1+"";
				shades[i][12]=pt+"";
				shades[i][13]=esi1+"";
				shades[i][14]=esi2+"";
				shades[i][15]=pf2+"";	
				shades[i][16]=pf3+"";
				shades[i][17]=pf4+"";
				shades[i][18]=pf5+"";
				shades[i][19]=pf6+"";
				shades[i][20]=advances+"";
				shades[i][21]=total_deductions+"";
				shades[i][22]=net_salary+"";
				
				
				i++;
			}
			
			
		
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				
				
				
			}catch(Exception e){
				
			}
		}
		
		System.out.println("shades= "+shades);
		
		return shades;
		
	}
	
	
}//class
