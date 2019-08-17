package com.sqldb;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import org.json.JSONArray;
import org.json.JSONObject;
//import org.json.simple.JSONArray;

import com.database.DbConnection;
import com.database.FileNameAutoChange;
import com.database.JavaCreateDirectoryExample;

import SqlDbFileToJson.ReadJSONExample;
import cspdcl.input.DataStroringAutomatically;

public class CsvFileToDataBase {

	String username2 = "CSPDCL";
	String password2 = "CSPDCL";
	String DriverClass = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	Connection con = null;

	public void CsvFileToDataBaseReading(String path) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(path));
			String line = reader.readLine();
			while (line != null) {
				System.out.println(line);
				line = reader.readLine();

				// database storing --start

				try {
					Class.forName(DriverClass);

					con = DriverManager.getConnection(url, username2, password2);

				} catch (Exception e) {
					e.printStackTrace();
				}

				// database storing --end
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void CsvFileToDataBaseReading2(String path) {

		try {

			ReadJSONExample readJSONExample = new ReadJSONExample();
			JSONArray upload_jsonarray = new JSONArray(readJSONExample.FileToJsonArray(path).toString());

			for (int i = 0; i < upload_jsonarray.length(); i++) {

				try {
					System.out.println("LOOP =" + i);
					String upload_jsonarray2 = upload_jsonarray.get(i).toString();
					JSONObject jsonObj3 = null;
					jsonObj3 = new JSONObject(upload_jsonarray2);

					String Addl_Security_Raised = jsonObj3.get("Addl_Security_Raised").toString();
					String BILL_NO = jsonObj3.get("BILL_NO").toString();
					String BP_Number = jsonObj3.get("BP_Number").toString();
					String Bank_Name = jsonObj3.get("Bank_Name").toString();
					String Bill_Amount_After_Due_Date = jsonObj3.get("Bill_Amount_After_Due_Date").toString();
					String Bill_Date = jsonObj3.get("Bill_Date").toString();
					String Bill_Generation_Status = jsonObj3.get("Bill_Generation_Status").toString();
					String Bill_Net_within_due_date = jsonObj3.get("Bill_Net_within_due_date").toString();
					String Bill_Time = jsonObj3.get("Bill_Time").toString();
					String Bill_issue_date = jsonObj3.get("Bill_issue_date").toString();
					String Cash_Due_Date = jsonObj3.get("Cash_Due_Date").toString();
					String Cess = jsonObj3.get("Cess").toString();
					String Cheque_Due_Date = jsonObj3.get("Cheque_Due_Date").toString();
					String Chq_Amt = jsonObj3.get("Chq_Amt").toString();
					String Chq_Number = jsonObj3.get("Chq_Number").toString();
					String Chq_date = jsonObj3.get("Chq_date").toString();
					String Cons_Mob_No = jsonObj3.get("Cons_Mob_No").toString();
					String Credit_DLAmt = jsonObj3.get("Credit_DLAmt").toString();
					String Cur_Bill_Month = jsonObj3.get("Cur_Bill_Month").toString();
					String Cur_Bill_Year = jsonObj3.get("Cur_Bill_Year").toString();
					String Cur_Mtr_Sts = jsonObj3.get("Cur_Mtr_Sts").toString();
					String Cur_PF = jsonObj3.get("Cur_PF").toString();
					String Distribution_Code = jsonObj3.get("Distribution_Code").toString();
					String Duty = jsonObj3.get("Duty").toString();
					String EC = jsonObj3.get("EC").toString();
					String Event_log_number = jsonObj3.get("Event_log_number").toString();
					String FC = jsonObj3.get("FC").toString();
					String LTCS_Charge = jsonObj3.get("LTCS_Charge").toString();
					String Latitude = jsonObj3.get("Latitude").toString();
					String Longitude = jsonObj3.get("Longitude").toString();
					String Low_PF_Penality_Incentive = jsonObj3.get("Low_PF_Penality_Incentive").toString();
					String MF = jsonObj3.get("MF").toString();
					String MRU = jsonObj3.get("MRU").toString();
					String Manual_Demand = jsonObj3.get("Manual_Demand").toString();
					String Meter_Reader_Name = jsonObj3.get("Meter_Reader_Name").toString();
					String Meter_Reading_Unit = jsonObj3.get("Meter_Reading_Unit").toString();
					String Meter_Rent = jsonObj3.get("Meter_Rent").toString();
					String Misc_flag_mark = jsonObj3.get("Misc_flag_mark").toString();
					String Office_Incharge = jsonObj3.get("Office_Incharge").toString();
					String Online_Flag_number = jsonObj3.get("Online_Flag_number").toString();
					String Penality_FC = jsonObj3.get("Penality_FC").toString();
					String Penalty_20_Addl_Chg = jsonObj3.get("Penalty_20_Addl_Chg").toString();
					String Penalty_EC = jsonObj3.get("Penalty_EC").toString();
					String Pole_Number = jsonObj3.get("Pole_Number").toString();
					String Posting_Date = jsonObj3.get("Posting_Date").toString();
					String Pres_Read_KWH = jsonObj3.get("Pres_Read_KWH").toString();
					String Pres_Read_KW_RMD = jsonObj3.get("Pres_Read_KW_RMD").toString();
					String Prev_Arrears = jsonObj3.get("Prev_Arrears").toString();
					String Prev_Read = jsonObj3.get("Prev_Read").toString();
					// String Rdg_Img=jsonObj3.get("Rdg_Img").toString ();
					String Rebate_EC = jsonObj3.get("Rebate_EC").toString();
					String Rebate_FC = jsonObj3.get("Rebate_FC").toString();
					String Rebate_other = jsonObj3.get("Rebate_other").toString();
					String Remarks = jsonObj3.get("Remarks").toString();
					String Round_Off_amount = jsonObj3.get("Round_Off_amount").toString();
					String Route_Seq_No = jsonObj3.get("Route_Seq_No").toString();
					String SBM_NO = jsonObj3.get("SBM_NO").toString();
					String SBM_Sw_Ver = jsonObj3.get("SBM_Sw_Ver").toString();
					String SD_Arrear = jsonObj3.get("SD_Arrear").toString();
					String SD_Interest = jsonObj3.get("SD_Interest").toString();
					String Surcharge = jsonObj3.get("Surcharge").toString();
					String Surcharge_Arrears = jsonObj3.get("Surcharge_Arrears").toString();
					String Total_Bill = jsonObj3.get("Total_Bill").toString();
					String Unit_Billed = jsonObj3.get("Unit_Billed").toString();
					String VCA_Charge = jsonObj3.get("VCA_Charge").toString();
					String Vendor_code = jsonObj3.get("Vendor_code").toString();
					String WTCS_Surcharge = jsonObj3.get("WTCS_Surcharge").toString();
					String Zone_Name = jsonObj3.get("Zone_Name").toString();

					Bill_Date = Bill_Date.replace(".", "/");

					// System.out.println("bill_date= "+Bill_Date);
					// String startDate="01-02-2013";
					SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
					java.util.Date date = sdf1.parse(Bill_Date);
					java.sql.Date billdate_sql = new java.sql.Date(date.getTime());

					// System.out.println("date= "+date.getTime());

					String Query = "INSERT INTO CSPDCL_OUTPUT (ADDL_SECURITY_RAISED,\r\n" + "BILL_NO,\r\n"
							+ "BP_NUMBER,\r\n" + "BANK_NAME,\r\n" + "BILL_AMOUNT_AFTER_DUE_DATE,\r\n" + "BILL_DATE,\r\n"
							+ "BILL_GENERATION_STATUS,\r\n" + "BILL_NET_WITHIN_DUE_DATE,\r\n" + "BILL_TIME,\r\n"
							+ "BILL_ISSUE_DATE,\r\n" +
							// "CASH_DUE_DATE,\r\n" +
							"CESS,\r\n" +
							// "CHEQUE_DUE_DATE,\r\n" +
							"CHQ_AMT,\r\n" + "CHQ_NUMBER,\r\n" +
							// "CHQ_DATE,\r\n" +
							"CONS_MOB_NO,\r\n" + "CREDIT_DLAMT,\r\n" + "CUR_BILL_MONTH,\r\n" + "CUR_BILL_YEAR,\r\n"
							+ "CUR_MTR_STS,\r\n" + "CUR_PF,\r\n" + "DISTRIBUTION_CODE,\r\n" + "DUTY,\r\n" + "EC,\r\n"
							+ "EVENT_LOG_NUMBER,\r\n" + "FC,\r\n" + "LTCS_CHARGE,\r\n"
							+ "LOW_PF_PENALITY_INCENTIVE,\r\n" + "MF,\r\n" + "MANUAL_DEMAND,\r\n"
							+ "METER_READER_NAME,\r\n" + "METER_RENT,\r\n" + "MISC_FLAG_MARK,\r\n"
							+ "OFFICE_INCHARGE,\r\n" + "ONLINE_FLAG_NUMBER,\r\n" + "PENALITY_FC,\r\n"
							+ "PENALTY_20_ADDL_CHG,\r\n" + "PENALTY_EC,\r\n" + "POLE_NUMBER,\r\n" + "POSTING_DATE,\r\n"
							+ "PRES_READ_KW_RMD,\r\n" + "PREV_ARREARS,\r\n" + "PREV_READ,\r\n" + "REBATE_EC,\r\n"
							+ "REBATE_FC,\r\n" + "REBATE_OTHER,\r\n" + "ROUND_OFF_AMOUNT,\r\n" + "ROUTE_SEQ_NO,\r\n"
							+ "SBM_NO,\r\n" + "SBM_SW_VER,\r\n" + "SD_ARREAR,\r\n" + "SD_INTEREST,\r\n"
							+ "SURCHARGE,\r\n" + "SURCHARGE_ARREARS,\r\n" + "TOTAL_BILL,\r\n" + "UNIT_BILLED,\r\n"
							+ "VCA_CHARGE,\r\n" + "VENDOR_CODE,\r\n" + "WTCS_SURCHARGE,\r\n"
							+ "ZONE_NAME,MRU,LATTITUDE,LONGITUDE,PRES_READ_KWH,METER_READING_UNIT,REMARKS,SERVER_TIME)  VALUES('"
							+ Addl_Security_Raised + "','" + BILL_NO + "','" + BP_Number + "','" + Bank_Name + "','"
							+ Bill_Amount_After_Due_Date + "'," + "to_date('" + Bill_Date + "','dd/MM/yyyy'),'"
							+ Bill_Generation_Status + "','" + Bill_Net_within_due_date + "','" + Bill_Time + "','"
							+ Bill_issue_date + "','" +
							// "to_date('"+Cash_Due_Date+"','dd/MM/yyyy)"+
							Cess + "','" +
							// "to_date('"+Cheque_Due_Date+"','dd/MM/yyyy)"+
							Chq_Amt + "','" + Chq_Number + "','" +
							// Chq_date+"','"+
							Cons_Mob_No + "','" + Credit_DLAmt + "','" + Cur_Bill_Month + "','" + Cur_Bill_Year + "','"
							+ Cur_Mtr_Sts + "','" + Cur_PF + "','" + Distribution_Code + "','" + Duty + "','" + EC
							+ "','" + Event_log_number + "','" + FC + "','" + LTCS_Charge + "','"
							+ Low_PF_Penality_Incentive + "','" + MF + "','" + Manual_Demand + "','" + Meter_Reader_Name
							+ "','" + Meter_Rent + "','" + Misc_flag_mark + "','" + Office_Incharge + "','"
							+ Online_Flag_number + "','" + Penality_FC + "','" + Penalty_20_Addl_Chg + "','"
							+ Penalty_EC + "','" + Pole_Number + "','" + Posting_Date + "','" + Pres_Read_KW_RMD + "','"
							+ Prev_Arrears + "','" + Prev_Read + "','" + Rebate_EC + "','" + Rebate_FC + "','"
							+ Rebate_other + "','" + Round_Off_amount + "','" + Route_Seq_No + "','" + SBM_NO + "','"
							+ SBM_Sw_Ver + "','" + SD_Arrear + "','" + SD_Interest + "','" + Surcharge + "','"
							+ Surcharge_Arrears + "','" + Total_Bill + "','" + Unit_Billed + "','" + VCA_Charge + "','"
							+ Vendor_code + "','" + WTCS_Surcharge + "','" + Zone_Name + "','" + MRU + "','" + Latitude
							+ "','" + Longitude + "','" + Pres_Read_KWH + "','" + Meter_Reading_Unit + "','" + Remarks
							+ "',sysdate)";

				//	System.out.println(Query);

					
					
					
					
					//database storing --start
			//	synchronized (this) {
					
				
					Thread.sleep(10);
					 PreparedStatement ps = null;
			    	try{	
			    		con=null;
						Class.forName(DriverClass);
						
						con = DriverManager.getConnection(url,username2,password2);
						 
						System.out.println("connect= "+con);
						
						  ps = con.prepareStatement(Query);
						 int kk = ps.executeUpdate();
						 System.out.println("store= "+kk);
				    	
						}catch(Exception e)
						{
							e.printStackTrace();
						}finally {
							try {
							if(con!=null)
								con.close();
							}catch (Exception e) {
								e.printStackTrace();
							}
						}
			    	
		    		con=null;

			    	/*DataStroringAutomatically db =new DataStroringAutomatically();
			    	db.exicuteQuery(Query, con);*/
			    	Thread.sleep(200);
			    	
		//		}
				
					//database storing --end
					
					
					
					
					
					
					System.out.println("****************************");
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

//    	return "OK";

	}

	public static void main(String args[]) {
		CsvFileToDataBase csvfile = new CsvFileToDataBase();
		csvfile.CsvFileToDataBaseReading2("D:\\dbcsvfile.json");
//    	
//    	ReadJSONExample js=new ReadJSONExample();
//    	js.FileToJsonArray("D:\\dbcsvfile.json");
	}

}
