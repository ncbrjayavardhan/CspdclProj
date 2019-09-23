package cspdcl.input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.database.DataBaseUtil;
//import com.cspdcl.db.DataBaseConnection;
//import com.cspdcl.db.DataStroringAutomatically;
import com.database.DbConnection;
import com.pojo.CheckingPojo;

public class CSPDCL_INPUT_READING {
	
	 public static void main(String[] args) throws IOException
	  { 
	  // We need to provide file path as the parameter: 
	  // double backquote is to avoid compiler interpret words 
	  // like \test as \t (ie. as a escape sequence) 
	  File file = new File("C:\\Users\\VIIPL02\\Downloads\\54481830 - Copy.TXT"); 
	  
	  BufferedReader br = new BufferedReader(new FileReader(file)); 
	  
	  Set set=new HashSet<>();
	  String st; 
	  int loop=0;
	  
	  Connection con=null;
	  DbConnection db=new DbConnection();
		 con=db.getConnObject2();
		 
	  while ((st = br.readLine()) != null) {
//	    System.out.println(st); 	 
	  String[] parts = st.split("\\|");
	  
	  set.add(parts.length);
	  
//	  System.out.println(++loop);
	  
	  /*        String	BP_Number	=parts[0];
			  String	MRU	=parts[1];
			  String	Legacy_Number_Old_Service	=parts[2];
			  String	Consumer_Index_Number	=parts[3];
			  String	Name_of_Consumer	=parts[4];
			  String	Address1	=parts[5];
			  String	Address2	=parts[6];
			  String	Address3	=parts[7];
			  String	Mobile_No	=parts[8];
			  String	Nature_of_Supply_PT	=parts[9];
			  String	Purpose	=parts[10];
			  String	Tariff_Code	=parts[11];
			  String	rate_category_for_analogic_use	=parts[12];
			  String	Duty_Code	=parts[13];
			  String	LPF_Flag	=parts[14];
			  String	RMD_Flag	=parts[15];
			  String	Cess_IP	=parts[16];w
			  String	Rebate_FC	=parts[17];
			  String	Rebate_Type	=parts[18];
			  String	Meter_Rent	=parts[19];
			  String	Meter_Phase	=parts[20];
			  String	KWH_MF_For_Reading	=parts[21];
			  String	Contract_Load	=parts[22];
			  String	Measurement_Load_Code	=parts[23];
			  String	LT_Capacitor_Code_for_Low_Power	=parts[24];
			  String	Welder_Capacitor_Code_for_Low	=parts[25];
			  String	Average_Unit_for_Defective	=parts[26];
			  String	Average_MD	=parts[27];
			  String	Average_PF	=parts[28];
			  String	Meter_Status	=parts[29];
			  String	PFL_COUNTER	=parts[30];
			  String	Average_Amount	=parts[31];
			  String	Amount_from_the_operand_DL_AMNT	=parts[32];
			  String	Bill_Month	=parts[33];
			  String	Bill_Year	=parts[34];
			  String	Route_Seq_No	=parts[35];
			  String	Meter_Make_and_No	=parts[36];
			  String	SD_Held	=parts[37];
			  String	Previous_Arrears	=parts[38];
			  String	Sucharge_Arrears	=parts[39];
			  String	SD_Arrear	=parts[40];
			  String	Additional_Security_Raised	=parts[41];
			  String	SD_Interest	=parts[42];
			  String	Manual_Demand_Misc_Charges	=parts[43];
			  String	Meter_Reading_Previous_KWH	=parts[44];
			  String	Initial_Reading	=parts[45];
			  String	Final_Reading_Informative	=parts[46];
			  String	Old_Meter_Consumption	=parts[47];
			  String	Consumer_Status	=parts[48];
			  String	Cheque_Accept_Status	=parts[49];
			  String	Last_Payment_Date	=parts[50];
			  String	Posting_Date	=parts[51];
			  String	Office_Phone	=parts[52];
			  String	VCA_Rate	=parts[53];
			  String	Last_Meter_Reading_Date	=parts[54];
			  String	Officers_Incharge	=parts[55];
			  String	Date_of_Tarrif_Change	=parts[56];
			  String	Zone_Code	=parts[57];
			  String	SBM_No	=parts[58];
			  String	Vendor_Code	=parts[59];
			  String	Reader_Name	=parts[60];
			  String	Shedule_MRD	=parts[61];
			  String	State_Govt_Rebate__Consupmtion_Capping	=parts[62];
			  String	State_Govt_Rebate_Measurement_Code	=parts[63];*/
	  
	  String Query="INSERT INTO CSPDCL_INPUT2(BP_NUMBER,MRU,LEGACY_NUMBER_OLD_SERVICE,CONSUMER_INDEX_NUMBER,NAME_OF_CONSUMER,ADDRESS1,ADDRESS2,ADDRESS3,MOBILE_NO,NATURE_OF_SUPPLY_PT,PURPOSE,TARIFF_CODE,RATE_CATEGORY_FOR_ANALOGIC_USE,DUTY_CODE,LPF_FLAG,RMD_FLAG,CESS_IP,REBATE_FC,REBATE_TYPE,METER_RENT,METER_PHASE,KWH_MF,CONTRACT_LOAD,MEASUREMENT_LOAD_CODE,LT_CAPACITOR_CODE,WELDER_CAPACITOR_CODE,AVERAGE_UNIT_FOR_DEFECTIVE,AVERAGE_MD,AVERAGE_PF,METER_STATUS,PFL_COUNTER,AVERAGE_AMOUNT,DL_AMNT,BILL_MONTH,BILL_YEAR,ROUTE_SEQ_NO,METER_MAKE_AND_NO,SD_HELD,PREVIOUS_ARREARS,SUCHARGE_ARREARS,SD_ARREAR,ADDITIONAL_SECURITY_RAISED,SD_INTEREST,MANUAL_DEMAND_MISC_CHARGES,METER_READING_PREVIOUS_KWH,INITIAL_READING,FINAL_READING_INFORMATIVE,OLD_METER_CONSUMPTION,CONSUMER_STATUS,CHEQUE_ACCEPT_STATUS,LAST_PAYMENT_DATE,POSTING_DATE,OFFICE_PHONE,VCA_RATE,LAST_METER_READING_DATE,OFFICERS_INCHARGE,DATE_OF_TARRIF_CHANGE,ZONE_CODE,SBM_NO,VENDOR_CODE,READER_NAME,SHEDULE_MRD,GOVT_REBATE__CONSU_CAPPING,GOVT_REBATE_MEASUR_CODE) "
	  		+ "VALUES('"+parts[0]+"','"+parts[1]+"','"+parts[2]+"','"+parts[3]+"','"+parts[4]+"','"+parts[5]+"','"+parts[6]+"','"+parts[7]+"','"+parts[8]+"','"+parts[9]+"','"+parts[10]+"','"+parts[11]+"','"+parts[12]+"','"+parts[13]+"','"+parts[14]+"','"+parts[15]+"','"+parts[16]+"','"+parts[17]+"','"+parts[18]+"','"+parts[19]+"','"+parts[20]+"','"+parts[21]+"','"+parts[22]+"','"+parts[23]+"','"+parts[24]+"','"+parts[25]+"','"+parts[26]+"','"+parts[27]+"','"+parts[28]+"','"+parts[29]+"','"+parts[30]+"','"+parts[31]+"','"+parts[32]+"','"+parts[33]+"','"+parts[34]+"','"+parts[35]+"','"+parts[36]+"','"+parts[37]+"','"+parts[38]+"','"+parts[39]+"','"+parts[40]+"','"+parts[41]+"','"+parts[42]+"','"+parts[43]+"','"+parts[44]+"','"+parts[45]+"','"+parts[46]+"','"+parts[47]+"','"+parts[48]+"','"+parts[49]+"','"+parts[50]+"','"+parts[51]+"','"+parts[52]+"','"+parts[53]+"','"+parts[54]+"','"+parts[55]+"','"+parts[56]+"','"+parts[57]+"','"+parts[58]+"','"+parts[59]+"','"+parts[60]+"','"+parts[61]+"','"+parts[62]+"','"+parts[63]+"')";
	  
	  try {
			
		
		DataStroringAutomatically da=new DataStroringAutomatically();
		int store_data=	da.exicuteQuery(Query, con);
//		System.out.println("store_data= "+store_data);
			 }catch(Exception e) {
				 System.out.println(parts[0]+" "+e.getMessage());
			 }finally {
				
				/* try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
			 }
	  
	  
	  try {
		 if(loop%100==0) {
			 
			 if(con!=null)
			 con.close();
			 
		    con=db.getConnObject2();
		    
		    try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		 }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	  
	  }
	  
	  System.out.println(set);
	  
	  } 
	 private boolean checkParts(String[] parts) {
		 boolean isMatched=true;
		 if(parts.length!=65) {
			  isMatched=false;
		  }
		return isMatched;
	 }
	 boolean isOnceExecuted=false;
	 private boolean checkBPNumberInDb(String bpNumber,String billMonth) {
		 boolean isMatched=false;
		 if(isOnceExecuted)
			 	return isMatched;
		 Connection connection=null;
		 if(bpNumber != null) {
			 try {
				connection=DataBaseUtil.getConnection();
			} catch (InterruptedException e2) {
				System.out.println("Unable to create the connection");
			}
			 String Query= "select BP_NUMBER from CSPDCL_INPUT2 where BP_NUMBER= '"+bpNumber+"' and "+"BILL_MONTH='"+billMonth+"'";;
			 ResultSet rs=new DataStroringAutomatically().exicuteQueryReesultSet(Query, connection);
			 try {
				 if(rs !=null) {
					while(rs.next()) {
						isMatched=true;
						break;
					 }
				 }
			} catch (SQLException e) {
				isMatched= false;
				if(connection !=null) {
					try {
						connection.close();
					} catch (SQLException e1) {
					}
				}
				if(rs !=null) {
					try {
						rs.close();
					} catch (SQLException e1) {
					}
				}
			}
			 isOnceExecuted=true;
		  }
		return isMatched;
	 }
	 private void commitData(List<String> Queries) {

		  Connection connection=null;
		  Statement statement = null;
		  try {
			  connection= DataBaseUtil.getConnection();
			  connection.setAutoCommit(true);
			  statement=connection.createStatement();
			 for(String query:Queries) {
				 statement.addBatch(query);
			 }
			 int[] recordsUpdated=statement.executeBatch();
			 if(recordsUpdated.length == 0) {
				 System.out.println("not commited");
			 }
			 statement.clearBatch();
			 Queries=new ArrayList();
		  }catch(Exception e) {
			  System.out.println("Error in executing Queries:"+Queries );
			  if(connection != null) {
				  try {
					connection.close();
				} catch (SQLException e1) {
				}
			  }
			  if(statement != null) {
				  try {
					  statement.close();
				} catch (SQLException e1) {
				}
			  }
		  }
	  
	 }
	 
	 public List InputdataLoading(BufferedReader br) {
		 List<Object> returnData=new ArrayList<Object>();
		 List<String> Queries=new ArrayList<String>();

		 String errorLineNumbers=" ";
		 Integer fileDataYear = null;
		 Integer fileDataMonth=null;
		  Calendar now = Calendar.getInstance();
		  Integer calendarYear=now.get(Calendar.YEAR);
		  Integer caledarMonth=(now.get(Calendar.MONTH) + 1);
		  String st; 
		  int line_count=0;
		  try {
		  while ((st = br.readLine()) != null ) {
			  String[] parts = st.split("\\|");
			  boolean isMatchedLength=checkParts(parts);
			  if(checkBPNumberInDb(parts[0],parts[33])){
				  returnData.add(line_count);
				  returnData.add("Data present in DB");
				  break;
			  }
			  if(isMatchedLength) {
			   fileDataYear=Integer.valueOf(parts[34]);
			   fileDataMonth=Integer.valueOf(parts[33]);
			  }
			 
			  if(isMatchedLength && (calendarYear.equals(fileDataYear) &&(caledarMonth.equals(fileDataMonth) ||fileDataMonth.equals(caledarMonth-2)||fileDataMonth.equals(caledarMonth-1) ))) {
				  String Query=null;
				  
				  String METER_RENT=parts[19];
				  String SD_HELD=parts[37];
				  
				  String PREVIOUS_ARREARS=parts[38];
				  String SUCHARGE_ARREARS=parts[39];
				  String SD_ARREAR=parts[40];
				  String ADDITIONAL_SECURITY_RAISED=parts[41];
				  //33,34
				  String SD_INTEREST=parts[42];
				  String MANUAL_DEMAND_MISC_CHARGES=parts[43];
				  
				  if(SD_HELD.contains("-")) {
					  SD_HELD=SD_HELD.substring(0, (SD_HELD.length()-1));
					  parts[37]="-"+SD_HELD;	  
				  }
				  
				  if(PREVIOUS_ARREARS.contains("-")) {
					  PREVIOUS_ARREARS=PREVIOUS_ARREARS.substring(0, (PREVIOUS_ARREARS.length()-1));
					  parts[38]="-"+PREVIOUS_ARREARS;	  
				  }
				  
				  if(SUCHARGE_ARREARS.contains("-")) {
					  SUCHARGE_ARREARS=SUCHARGE_ARREARS.substring(0, (SUCHARGE_ARREARS.length()-1));
					  parts[39]="-"+SUCHARGE_ARREARS;	  
				  }
				  
				  if(SD_ARREAR.contains("-")) {
					  SD_ARREAR=SD_ARREAR.substring(0, (SD_ARREAR.length()-1));
					  parts[40]="-"+SD_ARREAR;	  
				  }
				  
				  if(ADDITIONAL_SECURITY_RAISED.contains("-")) {
					  ADDITIONAL_SECURITY_RAISED=ADDITIONAL_SECURITY_RAISED.substring(0, (ADDITIONAL_SECURITY_RAISED.length()-1));
					  parts[41]="-"+ADDITIONAL_SECURITY_RAISED;	  
				  }
				  
				  if(SD_INTEREST.contains("-")) {
					  SD_INTEREST=SD_INTEREST.substring(0, (SD_INTEREST.length()-1));
					  parts[42]="-"+SD_INTEREST;	  
				  }
				  
				  
				  if(MANUAL_DEMAND_MISC_CHARGES.contains("-")) {
					  MANUAL_DEMAND_MISC_CHARGES=MANUAL_DEMAND_MISC_CHARGES.substring(0, (MANUAL_DEMAND_MISC_CHARGES.length()-1));
					  parts[43]="-"+MANUAL_DEMAND_MISC_CHARGES;	  
				  }
				  
				  if(METER_RENT.contains("-")) {
					  METER_RENT=METER_RENT.substring(0, (METER_RENT.length()-1));
					  parts[19]="-"+METER_RENT;	  
				  }
				  
				  if(parts.length==63) {
					   Query="INSERT INTO CSPDCL_INPUT2(BP_NUMBER,MRU,LEGACY_NUMBER_OLD_SERVICE,CONSUMER_INDEX_NUMBER,NAME_OF_CONSUMER,ADDRESS1,ADDRESS2,ADDRESS3,MOBILE_NO,NATURE_OF_SUPPLY_PT,PURPOSE,TARIFF_CODE,RATE_CATEGORY_FOR_ANALOGIC_USE,DUTY_CODE,LPF_FLAG,RMD_FLAG,CESS_IP,REBATE_FC,REBATE_TYPE,METER_RENT,METER_PHASE,KWH_MF,CONTRACT_LOAD,MEASUREMENT_LOAD_CODE,LT_CAPACITOR_CODE,WELDER_CAPACITOR_CODE,AVERAGE_UNIT_FOR_DEFECTIVE,AVERAGE_MD,AVERAGE_PF,METER_STATUS,PFL_COUNTER,AVERAGE_AMOUNT,DL_AMNT,BILL_MONTH,BILL_YEAR,ROUTE_SEQ_NO,METER_MAKE_AND_NO,SD_HELD,PREVIOUS_ARREARS,SUCHARGE_ARREARS,SD_ARREAR,ADDITIONAL_SECURITY_RAISED,SD_INTEREST,MANUAL_DEMAND_MISC_CHARGES,METER_READING_PREVIOUS_KWH,INITIAL_READING,FINAL_READING_INFORMATIVE,OLD_METER_CONSUMPTION,CONSUMER_STATUS,CHEQUE_ACCEPT_STATUS,LAST_PAYMENT_DATE,POSTING_DATE,OFFICE_PHONE,VCA_RATE,LAST_METER_READING_DATE,OFFICERS_INCHARGE,DATE_OF_TARRIF_CHANGE,ZONE_CODE,SBM_NO,VENDOR_CODE,READER_NAME,SHEDULE_MRD,GOVT_REBATE__CONSU_CAPPING,GOVT_REBATE_MEASUR_CODE) "
						  		+ "VALUES('"+parts[0]+"','"+parts[1]+"','"+parts[2]+"','"+parts[3]+"','"+parts[4]+"','"+parts[5]+"','"+parts[6]+"','"+parts[7]+"','"+parts[8]+"','"+parts[9]+"','"+parts[10]+"','"+parts[11]+"','"+parts[12]+"','"+parts[13]+"','"+parts[14]+"','"+parts[15]+"','"+parts[16]+"','"+parts[17]+"','"+parts[18]+"','"+parts[19]+"','"+parts[20]+"','"+parts[21]+"','"+parts[22]+"','"+parts[23]+"','"+parts[24]+"','"+parts[25]+"','"+parts[26]+"','"+parts[27]+"','"+parts[28]+"','"+parts[29]+"','"+parts[30]+"','"+parts[31]+"','"+parts[32]+"','"+parts[33]+"','"+parts[34]+"','"+parts[35]+"','"+parts[36]+"','"+parts[37]+"','"+parts[38]+"','"+parts[39]+"','"+parts[40]+"','"+parts[41]+"','"+parts[42]+"','"+parts[43]+"','"+parts[44]+"','"+parts[45]+"','"+parts[46]+"','"+parts[47]+"','"+parts[48]+"','"+parts[49]+"','"+parts[50]+"','"+parts[51]+"','"+parts[52]+"','"+parts[53]+"','"+parts[54]+"','"+parts[55]+"','"+parts[56]+"','"+parts[57]+"','"+parts[58]+"','"+parts[59]+"','"+parts[60]+"','"+parts[61]+"','"+parts[62]+"','0')";
				  }else {
				  
				   Query="INSERT INTO CSPDCL_INPUT2(BP_NUMBER,MRU,LEGACY_NUMBER_OLD_SERVICE,CONSUMER_INDEX_NUMBER,NAME_OF_CONSUMER,ADDRESS1,ADDRESS2,ADDRESS3,MOBILE_NO,NATURE_OF_SUPPLY_PT,PURPOSE,TARIFF_CODE,RATE_CATEGORY_FOR_ANALOGIC_USE,DUTY_CODE,LPF_FLAG,RMD_FLAG,CESS_IP,REBATE_FC,REBATE_TYPE,METER_RENT,METER_PHASE,KWH_MF,CONTRACT_LOAD,MEASUREMENT_LOAD_CODE,LT_CAPACITOR_CODE,WELDER_CAPACITOR_CODE,AVERAGE_UNIT_FOR_DEFECTIVE,AVERAGE_MD,AVERAGE_PF,METER_STATUS,PFL_COUNTER,AVERAGE_AMOUNT,DL_AMNT,BILL_MONTH,BILL_YEAR,ROUTE_SEQ_NO,METER_MAKE_AND_NO,SD_HELD,PREVIOUS_ARREARS,SUCHARGE_ARREARS,SD_ARREAR,ADDITIONAL_SECURITY_RAISED,SD_INTEREST,MANUAL_DEMAND_MISC_CHARGES,METER_READING_PREVIOUS_KWH,INITIAL_READING,FINAL_READING_INFORMATIVE,OLD_METER_CONSUMPTION,CONSUMER_STATUS,CHEQUE_ACCEPT_STATUS,LAST_PAYMENT_DATE,POSTING_DATE,OFFICE_PHONE,VCA_RATE,LAST_METER_READING_DATE,OFFICERS_INCHARGE,DATE_OF_TARRIF_CHANGE,ZONE_CODE,SBM_NO,VENDOR_CODE,READER_NAME,SHEDULE_MRD,GOVT_REBATE__CONSU_CAPPING,GOVT_REBATE_MEASUR_CODE) "
				  		+ "VALUES('"+parts[0]+"','"+parts[1]+"','"+parts[2]+"','"+parts[3]+"','"+parts[4]+"','"+parts[5]+"','"+parts[6]+"','"+parts[7]+"','"+parts[8]+"','"+parts[9]+"','"+parts[10]+"','"+parts[11]+"','"+parts[12]+"','"+parts[13]+"','"+parts[14]+"','"+parts[15]+"','"+parts[16]+"','"+parts[17]+"','"+parts[18]+"','"+parts[19]+"','"+parts[20]+"','"+parts[21]+"','"+parts[22]+"','"+parts[23]+"','"+parts[24]+"','"+parts[25]+"','"+parts[26]+"','"+parts[27]+"','"+parts[28]+"','"+parts[29]+"','"+parts[30]+"','"+parts[31]+"','"+parts[32]+"','"+parts[33]+"','"+parts[34]+"','"+parts[35]+"','"+parts[36]+"','"+parts[37]+"','"+parts[38]+"','"+parts[39]+"','"+parts[40]+"','"+parts[41]+"','"+parts[42]+"','"+parts[43]+"','"+parts[44]+"','"+parts[45]+"','"+parts[46]+"','"+parts[47]+"','"+parts[48]+"','"+parts[49]+"','"+parts[50]+"','"+parts[51]+"','"+parts[52]+"','"+parts[53]+"','"+parts[54]+"','"+parts[55]+"','"+parts[56]+"','"+parts[57]+"','"+parts[58]+"','"+parts[59]+"','"+parts[60]+"','"+parts[61]+"','"+parts[62]+"','"+parts[63]+"')";
				  }
				  Queries.add(Query);
				  if(Queries.size() == 50) {
					  commitData(Queries);
				  }
				  line_count++;
			  }else {
				  line_count++;
				  int count=line_count;
				  errorLineNumbers=errorLineNumbers+" "+count+",";
				  System.out.println("We are not proceesing the line"+st+", as we have recievd the incorrect date please check the  month in record.");
			  }
			}
		  if(Queries.size() > 0) {
			  commitData(Queries);
		  }
		}catch (Exception e) {
				e.printStackTrace();
		}
		
		  
	 if(returnData.size() == 0) {
		  returnData.add(line_count);
		  if(errorLineNumbers.trim().length() >0) {
			  returnData.add("Please check the data ,Error in line numbers "+errorLineNumbers.substring(0,errorLineNumbers.lastIndexOf(",")));
		 }
	 }
	return returnData;
		 
	}
	 
	 public String InputdataLoadingWithOwlFileOnce(BufferedReader br,BufferedReader br2) {
		 

		 System.out.println(br+"    _   "+br2);
		 Set set=new HashSet<>();		
		  String st; 
		  int loop=0;
		  
		  Connection con=null;
		  DbConnection db=new DbConnection();
		  int line_count=0;
//		  BufferedReader br2=new BufferedReader(br);

//		   br2=br;
		  String outpu_return="";
		  try {
			 con=db.getConnObject2();
			 
			 while ((st = br.readLine()) != null) {

				  String[] parts = st.split("\\|");
				  
				  set.add(parts.length);
				  
				  if(parts.length!=65) {
					  System.out.println("length="+parts.length);
					  outpu_return= "error in "+loop;
				 // return outpu_return;
				  }
				  
			 }
			 try {
			
			 }catch(Exception e) {
				 e.printStackTrace();
			 }
			 if(set.size()==1 && set.contains(65) ) {
				 
				 System.out.println("  i am in if");
			 
		  while ((st = br2.readLine()) != null) {
			  
			  System.out.println(" i am in second while loop");
//		    System.out.println(st); 	 
		  String[] parts = st.split("\\|");
		  
		  set.add(parts.length);
		  
		  System.out.println(++loop);
		  
		  /*        String	BP_Number	=parts[0];
				  String	MRU	=parts[1];
				  String	Legacy_Number_Old_Service	=parts[2];
				  String	Consumer_Index_Number	=parts[3];
				  String	Name_of_Consumer	=parts[4];
				  String	Address1	=parts[5];
				  String	Address2	=parts[6];
				  String	Address3	=parts[7];
				  String	Mobile_No	=parts[8];
				  String	Nature_of_Supply_PT	=parts[9];
				  String	Purpose	=parts[10];
				  String	Tariff_Code	=parts[11];
				  String	rate_category_for_analogic_use	=parts[12];
				  String	Duty_Code	=parts[13];
				  String	LPF_Flag	=parts[14];
				  String	RMD_Flag	=parts[15];
				  String	Cess_IP	=parts[16];w
				  String	Rebate_FC	=parts[17];
				  String	Rebate_Type	=parts[18];
				  String	Meter_Rent	=parts[19];
				  String	Meter_Phase	=parts[20];
				  String	KWH_MF_For_Reading	=parts[21];
				  String	Contract_Load	=parts[22];
				  String	Measurement_Load_Code	=parts[23];
				  String	LT_Capacitor_Code_for_Low_Power	=parts[24];
				  String	Welder_Capacitor_Code_for_Low	=parts[25];
				  String	Average_Unit_for_Defective	=parts[26];
				  String	Average_MD	=parts[27];
				  String	Average_PF	=parts[28];
				  String	Meter_Status	=parts[29];
				  String	PFL_COUNTER	=parts[30];
				  String	Average_Amount	=parts[31];
				  String	Amount_from_the_operand_DL_AMNT	=parts[32];
				  String	Bill_Month	=parts[33];
				  String	Bill_Year	=parts[34];
				  String	Route_Seq_No	=parts[35];
				  String	Meter_Make_and_No	=parts[36];
				  String	SD_Held	=parts[37];
				  String	Previous_Arrears	=parts[38];
				  String	Sucharge_Arrears	=parts[39];
				  String	SD_Arrear	=parts[40];
				  String	Additional_Security_Raised	=parts[41];
				  String	SD_Interest	=parts[42];
				  String	Manual_Demand_Misc_Charges	=parts[43];
				  String	Meter_Reading_Previous_KWH	=parts[44];
				  String	Initial_Reading	=parts[45];
				  String	Final_Reading_Informative	=parts[46];
				  String	Old_Meter_Consumption	=parts[47];
				  String	Consumer_Status	=parts[48];
				  String	Cheque_Accept_Status	=parts[49];
				  String	Last_Payment_Date	=parts[50];
				  String	Posting_Date	=parts[51];
				  String	Office_Phone	=parts[52];
				  String	VCA_Rate	=parts[53];
				  String	Last_Meter_Reading_Date	=parts[54];
				  String	Officers_Incharge	=parts[55];
				  String	Date_of_Tarrif_Change	=parts[56];
				  String	Zone_Code	=parts[57];
				  String	SBM_No	=parts[58];
				  String	Vendor_Code	=parts[59];
				  String	Reader_Name	=parts[60];
				  String	Shedule_MRD	=parts[61];
				  String	State_Govt_Rebate__Consupmtion_Capping	=parts[62];
				  String	State_Govt_Rebate_Measurement_Code	=parts[63];*/
		  
		  
		 /* DbConnection db2=new DbConnection();
		  
		  String satus_Query="select * from cspdcl_input2 where BP_NUMBER='"+parts[0]+"'";
		  System.out.println("satus_Query= "+satus_Query);
		 boolean ststus = db2.status(satus_Query);
		 
		  
		  if(ststus==true) {
		  */
		  
		  String Query=null;
		  System.out.println("length="+parts.length);
		  
		  
		  String METER_RENT=parts[19];
		  String SD_HELD=parts[37];
		  
		  String PREVIOUS_ARREARS=parts[38];
		  String SUCHARGE_ARREARS=parts[39];
		  String SD_ARREAR=parts[40];
		  String ADDITIONAL_SECURITY_RAISED=parts[41];
		  String SD_INTEREST=parts[42];
		  String MANUAL_DEMAND_MISC_CHARGES=parts[43];
		  
		  if(SD_HELD.contains("-")) {
			  SD_HELD=SD_HELD.substring(0, (SD_HELD.length()-1));
			  parts[37]="-"+SD_HELD;	  
		  }
		  
		  if(PREVIOUS_ARREARS.contains("-")) {
			  PREVIOUS_ARREARS=PREVIOUS_ARREARS.substring(0, (PREVIOUS_ARREARS.length()-1));
			  parts[38]="-"+PREVIOUS_ARREARS;	  
		  }
		  
		  if(SUCHARGE_ARREARS.contains("-")) {
			  SUCHARGE_ARREARS=SUCHARGE_ARREARS.substring(0, (SUCHARGE_ARREARS.length()-1));
			  parts[39]="-"+SUCHARGE_ARREARS;	  
		  }
		  
		  if(SD_ARREAR.contains("-")) {
			  SD_ARREAR=SD_ARREAR.substring(0, (SD_ARREAR.length()-1));
			  parts[40]="-"+SD_ARREAR;	  
		  }
		  
		  if(ADDITIONAL_SECURITY_RAISED.contains("-")) {
			  ADDITIONAL_SECURITY_RAISED=ADDITIONAL_SECURITY_RAISED.substring(0, (ADDITIONAL_SECURITY_RAISED.length()-1));
			  parts[41]="-"+ADDITIONAL_SECURITY_RAISED;	  
		  }
		  
		  if(SD_INTEREST.contains("-")) {
			  SD_INTEREST=SD_INTEREST.substring(0, (SD_INTEREST.length()-1));
			  parts[42]="-"+SD_INTEREST;	  
		  }
		  
		  
		  if(MANUAL_DEMAND_MISC_CHARGES.contains("-")) {
			  MANUAL_DEMAND_MISC_CHARGES=MANUAL_DEMAND_MISC_CHARGES.substring(0, (MANUAL_DEMAND_MISC_CHARGES.length()-1));
			  parts[43]="-"+MANUAL_DEMAND_MISC_CHARGES;	  
		  }
		  
		  if(METER_RENT.contains("-")) {
			  METER_RENT=METER_RENT.substring(0, (METER_RENT.length()-1));
			  parts[19]="-"+METER_RENT;	  
		  }
		  
		  if(parts.length==65) {
			 
			  
			  Query="INSERT INTO CSPDCL_INPUT2(BP_NUMBER,MRU,LEGACY_NUMBER_OLD_SERVICE,CONSUMER_INDEX_NUMBER,NAME_OF_CONSUMER,ADDRESS1,ADDRESS2,ADDRESS3,MOBILE_NO,NATURE_OF_SUPPLY_PT,PURPOSE,TARIFF_CODE,RATE_CATEGORY_FOR_ANALOGIC_USE,DUTY_CODE,LPF_FLAG,RMD_FLAG,CESS_IP,REBATE_FC,REBATE_TYPE,METER_RENT,METER_PHASE,KWH_MF,CONTRACT_LOAD,MEASUREMENT_LOAD_CODE,LT_CAPACITOR_CODE,WELDER_CAPACITOR_CODE,AVERAGE_UNIT_FOR_DEFECTIVE,AVERAGE_MD,AVERAGE_PF,METER_STATUS,PFL_COUNTER,AVERAGE_AMOUNT,DL_AMNT,BILL_MONTH,BILL_YEAR,ROUTE_SEQ_NO,METER_MAKE_AND_NO,SD_HELD,PREVIOUS_ARREARS,SUCHARGE_ARREARS,SD_ARREAR,ADDITIONAL_SECURITY_RAISED,SD_INTEREST,MANUAL_DEMAND_MISC_CHARGES,METER_READING_PREVIOUS_KWH,INITIAL_READING,FINAL_READING_INFORMATIVE,OLD_METER_CONSUMPTION,CONSUMER_STATUS,CHEQUE_ACCEPT_STATUS,LAST_PAYMENT_DATE,POSTING_DATE,OFFICE_PHONE,VCA_RATE,LAST_METER_READING_DATE,OFFICERS_INCHARGE,DATE_OF_TARRIF_CHANGE,ZONE_CODE,SBM_NO,VENDOR_CODE,READER_NAME,SHEDULE_MRD,GOVT_REBATE__CONSU_CAPPING,GOVT_REBATE_MEASUR_CODE) "
				  		+ "VALUES('"+parts[0]+"','"+parts[1]+"','"+parts[2]+"','"+parts[3]+"','"+parts[4]+"','"+parts[5]+"','"+parts[6]+"','"+parts[7]+"','"+parts[8]+"','"+parts[9]+"','"+parts[10]+"','"+parts[11]+"','"+parts[12]+"','"+parts[13]+"','"+parts[14]+"','"+parts[15]+"','"+parts[16]+"','"+parts[17]+"','"+parts[18]+"','"+parts[19]+"','"+parts[20]+"','"+parts[21]+"','"+parts[22]+"','"+parts[23]+"','"+parts[24]+"','"+parts[25]+"','"+parts[26]+"','"+parts[27]+"','"+parts[28]+"','"+parts[29]+"','"+parts[30]+"','"+parts[31]+"','"+parts[32]+"','"+parts[33]+"','"+parts[34]+"','"+parts[35]+"','"+parts[36]+"','"+parts[37]+"','"+parts[38]+"','"+parts[39]+"','"+parts[40]+"','"+parts[41]+"','"+parts[42]+"','"+parts[43]+"','"+parts[44]+"','"+parts[45]+"','"+parts[46]+"','"+parts[47]+"','"+parts[48]+"','"+parts[49]+"','"+parts[50]+"','"+parts[51]+"','"+parts[52]+"','"+parts[53]+"','"+parts[54]+"','"+parts[55]+"','"+parts[56]+"','"+parts[57]+"','"+parts[58]+"','"+parts[59]+"','"+parts[60]+"','"+parts[61]+"','"+parts[62]+"','"+parts[63]+"')";
				  
			   /*Query="INSERT INTO CSPDCL_INPUT2(BP_NUMBER,MRU,LEGACY_NUMBER_OLD_SERVICE,CONSUMER_INDEX_NUMBER,NAME_OF_CONSUMER,ADDRESS1,ADDRESS2,ADDRESS3,MOBILE_NO,NATURE_OF_SUPPLY_PT,PURPOSE,TARIFF_CODE,RATE_CATEGORY_FOR_ANALOGIC_USE,DUTY_CODE,LPF_FLAG,RMD_FLAG,CESS_IP,REBATE_FC,REBATE_TYPE,METER_RENT,METER_PHASE,KWH_MF,CONTRACT_LOAD,MEASUREMENT_LOAD_CODE,LT_CAPACITOR_CODE,WELDER_CAPACITOR_CODE,AVERAGE_UNIT_FOR_DEFECTIVE,AVERAGE_MD,AVERAGE_PF,METER_STATUS,PFL_COUNTER,AVERAGE_AMOUNT,DL_AMNT,BILL_MONTH,BILL_YEAR,ROUTE_SEQ_NO,METER_MAKE_AND_NO,SD_HELD,PREVIOUS_ARREARS,SUCHARGE_ARREARS,SD_ARREAR,ADDITIONAL_SECURITY_RAISED,SD_INTEREST,MANUAL_DEMAND_MISC_CHARGES,METER_READING_PREVIOUS_KWH,INITIAL_READING,FINAL_READING_INFORMATIVE,OLD_METER_CONSUMPTION,CONSUMER_STATUS,CHEQUE_ACCEPT_STATUS,LAST_PAYMENT_DATE,POSTING_DATE,OFFICE_PHONE,VCA_RATE,LAST_METER_READING_DATE,OFFICERS_INCHARGE,DATE_OF_TARRIF_CHANGE,ZONE_CODE,SBM_NO,VENDOR_CODE,READER_NAME,SHEDULE_MRD,GOVT_REBATE__CONSU_CAPPING,GOVT_REBATE_MEASUR_CODE) "
				  		+ "VALUES('"+parts[0]+"','"+parts[1]+"','"+parts[2]+"','"+parts[3]+"','"+parts[4]+"','"+parts[5]+"','"+parts[6]+"','"+parts[7]+"','"+parts[8]+"','"+parts[9]+"','"+parts[10]+"','"+parts[11]+"','"+parts[12]+"','"+parts[13]+"','"+parts[14]+"','"+parts[15]+"','"+parts[16]+"','"+parts[17]+"','"+parts[18]+"','"+parts[19]+"','"+parts[20]+"','"+parts[21]+"','"+parts[22]+"','"+parts[23]+"','"+parts[24]+"','"+parts[25]+"','"+parts[26]+"','"+parts[27]+"','"+parts[28]+"','"+parts[29]+"','"+parts[30]+"','"+parts[31]+"','"+parts[32]+"','"+parts[33]+"','"+parts[34]+"','"+parts[35]+"','"+parts[36]+"','"+parts[37]+"','"+parts[38]+"','"+parts[39]+"','"+parts[40]+"','"+parts[41]+"','"+parts[42]+"','"+parts[43]+"','"+parts[44]+"','"+parts[45]+"','"+parts[46]+"','"+parts[47]+"','"+parts[48]+"','"+parts[49]+"','"+parts[50]+"','"+parts[51]+"','"+parts[52]+"','"+parts[53]+"','"+parts[54]+"','"+parts[55]+"','"+parts[56]+"','"+parts[57]+"','"+parts[58]+"','"+parts[59]+"','"+parts[60]+"','"+parts[61]+"','"+parts[62]+"','0')";
				  */
			  
		  }else {
		  
		   /*Query="INSERT INTO CSPDCL_INPUT2(BP_NUMBER,MRU,LEGACY_NUMBER_OLD_SERVICE,CONSUMER_INDEX_NUMBER,NAME_OF_CONSUMER,ADDRESS1,ADDRESS2,ADDRESS3,MOBILE_NO,NATURE_OF_SUPPLY_PT,PURPOSE,TARIFF_CODE,RATE_CATEGORY_FOR_ANALOGIC_USE,DUTY_CODE,LPF_FLAG,RMD_FLAG,CESS_IP,REBATE_FC,REBATE_TYPE,METER_RENT,METER_PHASE,KWH_MF,CONTRACT_LOAD,MEASUREMENT_LOAD_CODE,LT_CAPACITOR_CODE,WELDER_CAPACITOR_CODE,AVERAGE_UNIT_FOR_DEFECTIVE,AVERAGE_MD,AVERAGE_PF,METER_STATUS,PFL_COUNTER,AVERAGE_AMOUNT,DL_AMNT,BILL_MONTH,BILL_YEAR,ROUTE_SEQ_NO,METER_MAKE_AND_NO,SD_HELD,PREVIOUS_ARREARS,SUCHARGE_ARREARS,SD_ARREAR,ADDITIONAL_SECURITY_RAISED,SD_INTEREST,MANUAL_DEMAND_MISC_CHARGES,METER_READING_PREVIOUS_KWH,INITIAL_READING,FINAL_READING_INFORMATIVE,OLD_METER_CONSUMPTION,CONSUMER_STATUS,CHEQUE_ACCEPT_STATUS,LAST_PAYMENT_DATE,POSTING_DATE,OFFICE_PHONE,VCA_RATE,LAST_METER_READING_DATE,OFFICERS_INCHARGE,DATE_OF_TARRIF_CHANGE,ZONE_CODE,SBM_NO,VENDOR_CODE,READER_NAME,SHEDULE_MRD,GOVT_REBATE__CONSU_CAPPING,GOVT_REBATE_MEASUR_CODE) "
		  		+ "VALUES('"+parts[0]+"','"+parts[1]+"','"+parts[2]+"','"+parts[3]+"','"+parts[4]+"','"+parts[5]+"','"+parts[6]+"','"+parts[7]+"','"+parts[8]+"','"+parts[9]+"','"+parts[10]+"','"+parts[11]+"','"+parts[12]+"','"+parts[13]+"','"+parts[14]+"','"+parts[15]+"','"+parts[16]+"','"+parts[17]+"','"+parts[18]+"','"+parts[19]+"','"+parts[20]+"','"+parts[21]+"','"+parts[22]+"','"+parts[23]+"','"+parts[24]+"','"+parts[25]+"','"+parts[26]+"','"+parts[27]+"','"+parts[28]+"','"+parts[29]+"','"+parts[30]+"','"+parts[31]+"','"+parts[32]+"','"+parts[33]+"','"+parts[34]+"','"+parts[35]+"','"+parts[36]+"','"+parts[37]+"','"+parts[38]+"','"+parts[39]+"','"+parts[40]+"','"+parts[41]+"','"+parts[42]+"','"+parts[43]+"','"+parts[44]+"','"+parts[45]+"','"+parts[46]+"','"+parts[47]+"','"+parts[48]+"','"+parts[49]+"','"+parts[50]+"','"+parts[51]+"','"+parts[52]+"','"+parts[53]+"','"+parts[54]+"','"+parts[55]+"','"+parts[56]+"','"+parts[57]+"','"+parts[58]+"','"+parts[59]+"','"+parts[60]+"','"+parts[61]+"','"+parts[62]+"','"+parts[63]+"')";
		  */
			  System.out.println("i am in else case ="+parts.length);
			 try {
				 con.rollback();
			 }catch (Exception e) {
				e.printStackTrace();
			}
		   return outpu_return;
		  }
		  
		  try {
				
			
			DataStroringAutomatically da=new DataStroringAutomatically();
			int store_data=	da.exicuteQuery(Query, con);
			System.out.println("store_data= "+store_data);
				 }catch(Exception e) {
//					 System.out.println(parts[0]+" "+e.getMessage());
					 e.printStackTrace();
				 }finally {
					
					/* try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}*/
				 }
		  
		  
		  try {
			 if(loop%100==0) {
				 con.commit();
				 if(con!=null)
				 con.close();
				 
			    con=db.getConnObject2();
			    
			    try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			 }
			 try {
			 con.commit();
			 }catch (Exception e) {
				
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		  
		  
		  
		  line_count++;
		  /*}else {
			  System.out.println(parts[0]+"= already updated");
			  Thread.sleep(10);
		  }*/
		  
		  outpu_return="successfully inserted rows = "+line_count; 
		  }
		  
		  }
		  
		  }catch (Exception e) {
			e.printStackTrace();
		}
		  
		  System.out.println(set);
//		return line_count;
		 return outpu_return;
	 
	 
	 }
	 
	 
	 
	 public CheckingPojo InputdataLoadingCheking(BufferedReader br) {
		 
		 System.out.println(br);
		 Set set=new HashSet<>();		
		  String st; 
		  int loop=0;
		  
		  Connection con=null;
		  DbConnection db=new DbConnection();
		  int line_count=0;
		  boolean returnValue=false;
//		  BufferedReader br2=new BufferedReader(br);

//		   br2=br;
		  String outpu_return="";
		  
		  CheckingPojo cp=new CheckingPojo();
		  
		  try {
			 con=db.getConnObject2();
			 
			 while ((st = br.readLine()) != null) {

				  String[] parts = st.split("\\|");
				  
				  set.add(parts.length);
				  
				  if(parts.length!=65) {
					  System.out.println("length="+parts.length);
					  cp.setMessage( "error in line"+line_count+" data:"+st);
					  cp.setStatus(false);
				 // return outpu_return;
				  }
				  
			 }
			 
			 if(set.size()==1 && set.contains(65) ) 
				 		cp.setStatus(true);
				 
				 
	 }catch (Exception e) {
		 e.printStackTrace();
		// TODO: handle exception
	}
		return cp;

	
	 

}
	 
}
