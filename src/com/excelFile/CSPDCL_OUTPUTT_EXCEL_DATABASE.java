package com.excelFile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.database.DbConnection;

public class CSPDCL_OUTPUTT_EXCEL_DATABASE {
	

	public String[][] CSPDCL_EXCEL_DATA() {
	
	Connection conn2 = null;
	PreparedStatement ps4 = null,ps41 = null,ps42 = null,ps5 = null;
	ResultSet rss = null,rss1 = null,rss2 = null;

	String[][] shades = null;
	int rows=0;
	int columns=0;
	try{
		
		System.out.println("satrt");
		
		DbConnection db=new DbConnection();
		 conn2 = db.getConnObject2();
		 ps4 = conn2.prepareStatement("select * from CSPDCL_OUTPUT");
		 ps5 = conn2.prepareStatement("select * from CSPDCL_OUTPUT");

		 rss = ps4.executeQuery();
		 rss2 = ps5.executeQuery();
		 int j=1;
		 try {
			while(rss2.next()){
				j++;
			}
		 }catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rss2!=null)
					rss2.close();
			}catch (Exception e) {}
			try {
				if(ps5!=null)
					ps5.close();
			}catch (Exception e) {}
		}
			
			
		/* ps41 = conn2.prepareStatement("select count(*) from VAIBHU_REDERS_MONTHLY_BILLS");
		 rss1 = ps41.executeQuery();
		 while (rss1.next())
			 rows=rss1.getInt("count(*)");
		 
		 
		 ps42 = conn2.prepareStatement("select count(*)  from user_tab_columns where table_name='VAIBHU_REDERS_MONTHLY_BILLS'");
		 rss2 = ps42.executeQuery();
		 while (rss2.next())
			 columns=rss2.getInt("count(*)");*/
		 
		 
//		shades = new String[rows+1][23];
//		 shades = new String[20][23];
		 shades = new String[j+2][23];


		
		
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
		//BP No	MTR Status	Current Meter Reading	Consumption	RMD	PF	DC CODE	GROUP

		shades[0][0]="BP No";	
		shades[0][1]="MTR Status";
	    shades[0][2]="Current Meter Reading";
	    shades[0][3]="Consumption";
        shades[0][4]="RMD";
		shades[0][5]="PF";
		shades[0][6]="DC CODE";
      	shades[0][7]="GROUP	";
      	
		/*shades[0][8]="V.D.A	";
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
		shades[0][22]="Net Salary";*/
		
		
		
		
		
		
		
		
		
		
    	/*shades[0][0]="BP No";	
		shades[0][1]="MTR Status";
	    shades[0][2]="Current Meter Reading";
	    shades[0][3]="Consumption";
        shades[0][4]="RMD";
		shades[0][5]="PF";
		shades[0][6]="DC CODE";
      	shades[0][7]="GROUP	";*/
		
		
		int i=1;
		while(rss.next()){
			
			String MRU=rss.getString("MRU");
			String BP_NUMBER=rss.getString("BP_NUMBER");
			String CUR_MTR_STS=rss.getString("CUR_MTR_STS");
			String Pres_Read_KWH=rss.getString("Pres_Read_KWH");
			String UNIT_BILLED=rss.getString("UNIT_BILLED");
			String PRES_READ_KW_RMD=rss.getString("PRES_READ_KW_RMD");
			String CUR_PF = rss.getString("CUR_PF");
			/*String DC_CODE = rss.getString("MRU");
			String GROUP  = rss.getString("MRU");*/
			String DC_CODE="";
				String GROUP  ="";
			if(MRU!=null) {
				try {
			 DC_CODE=MRU.substring(2, 4);
			 GROUP  = MRU.substring(6, 8);
				}catch (Exception e) {
					System.out.println("MRU= "+MRU+" "+e.getMessage());
				}
			}
			
			/*shades[i][0]=EMP_NAME;
			shades[i][1]=DIVISION;
			shades[i][2]=DESIGNATION;
			shades[i][3]=BILL_QTY;
			shades[i][4]=RATE;*/
			
			
			/*shades[i][0]=i+"";	*/
			shades[i][0]=BP_NUMBER;
		    shades[i][1]=CUR_MTR_STS;
		    shades[i][2]=Pres_Read_KWH;
            shades[i][3]=UNIT_BILLED;
			shades[i][4]=PRES_READ_KW_RMD;
			shades[i][5]=CUR_PF;
	      	shades[i][6]=DC_CODE;
			shades[i][7]=GROUP;
			/*shades[i][9]=Gross_salary+"";
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
			shades[i][22]=net_salary+"";*/
			
			
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

	public String[][] CSPDCL_EXCEL_DATA2(String Query) {
		
		Connection conn2 = null;
		PreparedStatement ps4 = null,ps41 = null,ps42 = null;
		ResultSet rss = null,rss1 = null,rss2 = null;

		String[][] shades = null;
		int rows=0;
		int columns=0;
		try{
			
			System.out.println("satrt");
			
			DbConnection db=new DbConnection();
			 conn2 = db.getConnObject2();
			 ps4 = conn2.prepareStatement(Query);
			 rss = ps4.executeQuery();
			 
			 PreparedStatement ps5 = conn2.prepareStatement(Query);

			 rss = ps4.executeQuery();
			 rss2 = ps5.executeQuery();
			 int j=1;
			 try {
				while(rss2.next()){
					j++;
				}
			 }catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(rss2!=null)
						rss2.close();
				}catch (Exception e) {}
				try {
					if(ps5!=null)
						ps5.close();
				}catch (Exception e) {}
			}
			 
			/* ps41 = conn2.prepareStatement("select count(*) from VAIBHU_REDERS_MONTHLY_BILLS");
			 rss1 = ps41.executeQuery();
			 while (rss1.next())
				 rows=rss1.getInt("count(*)");
			 
			 
			 ps42 = conn2.prepareStatement("select count(*)  from user_tab_columns where table_name='VAIBHU_REDERS_MONTHLY_BILLS'");
			 rss2 = ps42.executeQuery();
			 while (rss2.next())
				 columns=rss2.getInt("count(*)");*/
			 
			 
//			shades = new String[rows+1][23];
			 shades = new String[j+2][23];


			
			
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
			//BP No	MTR Status	Current Meter Reading	Consumption	RMD	PF	DC CODE	GROUP

			shades[0][0]="BP No";	
			shades[0][1]="MTR Status";
		    shades[0][2]="Current Meter Reading";
		    shades[0][3]="Consumption";
	        shades[0][4]="RMD";
			shades[0][5]="PF";
			shades[0][6]="DC CODE";
	      	shades[0][7]="GROUP	";
	      	
			/*shades[0][8]="V.D.A	";
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
			shades[0][22]="Net Salary";*/
			
			
			
			
			
			
			
			
			
			
	    	/*shades[0][0]="BP No";	
			shades[0][1]="MTR Status";
		    shades[0][2]="Current Meter Reading";
		    shades[0][3]="Consumption";
	        shades[0][4]="RMD";
			shades[0][5]="PF";
			shades[0][6]="DC CODE";
	      	shades[0][7]="GROUP	";*/
			
			
			int i=1;
			while(rss.next()){
				
				String MRU=rss.getString("MRU");
				String BP_NUMBER=rss.getString("BP_NUMBER");
				String CUR_MTR_STS=rss.getString("CUR_MTR_STS");
				String Pres_Read_KWH=rss.getString("Pres_Read_KWH");
				String UNIT_BILLED=rss.getString("UNIT_BILLED");
				String PRES_READ_KW_RMD=rss.getString("PRES_READ_KW_RMD");
				String CUR_PF = rss.getString("CUR_PF");
				/*String DC_CODE = rss.getString("MRU");
				String GROUP  = rss.getString("MRU");*/
				String DC_CODE="";
					String GROUP  ="";
				if(MRU!=null) {
					try {
				 DC_CODE=MRU.substring(2, 4);
				 GROUP  = MRU.substring(6, 8);
					}catch (Exception e) {
						System.out.println("MRU= "+MRU+" "+e.getMessage());
					}
				}
				
				/*shades[i][0]=EMP_NAME;
				shades[i][1]=DIVISION;
				shades[i][2]=DESIGNATION;
				shades[i][3]=BILL_QTY;
				shades[i][4]=RATE;*/
				
				
				/*shades[i][0]=i+"";	*/
				shades[i][0]=BP_NUMBER;
			    shades[i][1]=CUR_MTR_STS;
			    shades[i][2]=Pres_Read_KWH;
	            shades[i][3]=UNIT_BILLED;
				shades[i][4]=PRES_READ_KW_RMD;
				shades[i][5]=CUR_PF;
		      	shades[i][6]=DC_CODE;
				shades[i][7]=GROUP;
				/*shades[i][9]=Gross_salary+"";
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
				shades[i][22]=net_salary+"";*/
				
				
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


	
	
	public static void main(String args[]) {
		CSPDCL_OUTPUTT_EXCEL_DATABASE csp=new CSPDCL_OUTPUTT_EXCEL_DATABASE();
		csp.CSPDCL_EXCEL_DATA();
		
	}
}
