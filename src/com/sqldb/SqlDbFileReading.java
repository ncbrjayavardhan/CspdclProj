package com.sqldb;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import com.database.DbConnection;
import com.database.FileNameAutoChange;
import com.database.JavaCreateDirectoryExample;
import com.sms.SmsGateWay;

import cspdcl.input.DataStroringAutomatically;

/*import com.cspdcl.db.DataBaseConnection;
import com.cspdcl.db.DataStroringAutomatically;
import com.cspdcl.db.DbConnection;
import com.image.Base64ToImageConversion;
import com.image.FileNameAutoChange;
import com.image.JavaCreateDirectoryExample;
import com.image.WriteToFileExample1;
import com.sms.SmsGateWay;
*/
public class SqlDbFileReading {

	/**
	 * Connect to the test.db database
	 * 
	 * @return the Connection object
	 */
	private Connection connect(String path) {
		// SQLite connection string
//        String url = "jdbc:sqlite:C://sqlite/db/test.db";
//      String url = "jdbc:sqlite:D:/CSPDCL/mobile db files/DMP_09052019_125413(0).db";

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(path);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	/**
	 * select all rows in the warehouses table
	 */
	public void selectAll(String path) {

		System.out.println("start");
//        String sql = "SELECT id, name, capacity FROM warehouses";
		String sql = "SELECT * FROM SBMTOPC";
//        String sql = "SELECT * FROM PCTOSBM";
		System.out.println("PATH= " + path);

		Connection con = null;

		try (Connection conn = this.connect(path);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			int k = 0;
			// loop through the result set
			DbConnection db = new DbConnection();
			DbConnection db2 = new DbConnection();

			int loop = 0;
			while (rs.next()) {

				System.out.println("row no= " + (++k));

				// new code start

				try {

					String Addl_Security_Raised = rs.getString("Addl_Security_Raised").toString();
					String BILL_NO = rs.getString("BILL_NO").toString();
					String BP_Number = rs.getString("BP_Number").toString();
					String Bank_Name = rs.getString("Bank_Name").toString();
					String Bill_Amount_After_Due_Date = rs.getString("Bill_Amount_After_Due_Date").toString();
					String Bill_Date = rs.getString("Bill_Date").toString();
					String Bill_Generation_Status = rs.getString("Bill_Generation_Status").toString();
					String Bill_Net_within_due_date = rs.getString("Bill_Net_within_due_date").toString();
					String Bill_Time = rs.getString("Bill_Time").toString();
					String Bill_issue_date = rs.getString("Bill_issue_date").toString();
					String Cash_Due_Date = rs.getString("Cash_Due_Date").toString();
					String Cess = rs.getString("Cess").toString();
					String Cheque_Due_Date = rs.getString("Cheque_Due_Date").toString();
					String Chq_Amt = rs.getString("Chq_Amt").toString();
					String Chq_Number = rs.getString("Chq_Number").toString();
					String Chq_date = rs.getString("Chq_date").toString();
					String Cons_Mob_No = rs.getString("Cons_Mob_No").toString();
					String Credit_DLAmt = rs.getString("Credit_DLAmt").toString();
					String Cur_Bill_Month = rs.getString("Cur_Bill_Month").toString();
					String Cur_Bill_Year = rs.getString("Cur_Bill_Year").toString();
					String Cur_Mtr_Sts = rs.getString("Cur_Mtr_Sts").toString();
					String Cur_PF = rs.getString("Cur_PF").toString();
					String Distribution_Code = rs.getString("Distribution_Code").toString();
					String Duty = rs.getString("Duty").toString();
					String EC = rs.getString("EC").toString();
					String Event_log_number = rs.getString("Event_log_number").toString();
					String FC = rs.getString("FC").toString();
					String LTCS_Charge = rs.getString("LTCS_Charge").toString();
					String Latitude = rs.getString("Latitude").toString();
					String Longitude = rs.getString("Longitude").toString();
					String Low_PF_Penality_Incentive = rs.getString("Low_PF_Penality_Incentive").toString();
					String MF = rs.getString("MF").toString();
					String MRU = rs.getString("MRU").toString();
					String Manual_Demand = rs.getString("Manual_Demand").toString();
					String Meter_Reader_Name = rs.getString("Meter_Reader_Name").toString();
					String Meter_Reading_Unit = rs.getString("Meter_Reading_Unit").toString();
					String Meter_Rent = rs.getString("Meter_Rent").toString();
					String Misc_flag_mark = rs.getString("Misc_flag_mark").toString();
					String Office_Incharge = rs.getString("Office_Incharge").toString();
					String Online_Flag_number = rs.getString("Online_Flag_number").toString();
					String Penality_FC = rs.getString("Penality_FC").toString();
					String Penalty_20_Addl_Chg = rs.getString("Penalty_20_Addl_Chg").toString();
					String Penalty_EC = rs.getString("Penalty_EC").toString();
					String Pole_Number = rs.getString("Pole_Number").toString();
					String Posting_Date = rs.getString("Posting_Date").toString();
					String Pres_Read_KWH = rs.getString("Pres_Read_KWH").toString();
					String Pres_Read_KW_RMD = rs.getString("Pres_Read_KW_RMD").toString();
					String Prev_Arrears = rs.getString("Prev_Arrears").toString();
					String Prev_Read = rs.getString("Prev_Read").toString();
//			 String  Rdg_Img=rs.getString("Rdg_Img").toString  ();
					String Rebate_EC = rs.getString("Rebate_EC").toString();
					String Rebate_FC = rs.getString("Rebate_FC").toString();
					String Rebate_other = rs.getString("Rebate_other").toString();
					String Remarks = rs.getString("Remarks").toString();
					String Round_Off_amount = rs.getString("Round_Off_amount").toString();
					String Route_Seq_No = rs.getString("Route_Seq_No").toString();
					String SBM_NO = rs.getString("SBM_NO").toString();
					String SBM_Sw_Ver = rs.getString("SBM_Sw_Ver").toString();
					String SD_Arrear = rs.getString("SD_Arrear").toString();
					String SD_Interest = rs.getString("SD_Interest").toString();
					String Surcharge = rs.getString("Surcharge").toString();
					String Surcharge_Arrears = rs.getString("Surcharge_Arrears").toString();
					String Total_Bill = rs.getString("Total_Bill").toString();
					String Unit_Billed = rs.getString("Unit_Billed").toString();
					String VCA_Charge = rs.getString("VCA_Charge").toString();
					String Vendor_code = rs.getString("Vendor_code").toString();
					String WTCS_Surcharge = rs.getString("WTCS_Surcharge").toString();
					String Zone_Name = rs.getString("Zone_Name").toString();

					Bill_Date = Bill_Date.replace(".", "/");

					System.out.println("bill_date= " + Bill_Date);
					System.out.println("BP_Number= " + BP_Number);

					// String startDate="01-02-2013";
					SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
					java.util.Date date = sdf1.parse(Bill_Date);
					java.sql.Date billdate_sql = new java.sql.Date(date.getTime());

					System.out.println("date= " + date.getTime());

					String satus_Query = "select * from CSPDCL_OUTPUT where BP_NUMBER='" + BP_Number + "'";
//			  String satus_Query="select * from CSPDCL_OUTPUT where BP_NUMBER='"+BP_Number+"'  and BILL_DATE BETWEEN trunc (sysdate, 'mm')  AND SYSDATE";
					System.out.println("satus_Query= " + satus_Query);

					Thread.sleep(10);

					boolean ststus = db2.status(satus_Query);
					System.out.println("satus = " + ststus);

					Thread.sleep(10);

					if (ststus == false) {

						/* image data storing start */
						JavaCreateDirectoryExample jcd = new JavaCreateDirectoryExample();

						try {
							jcd.FolderCreation("c:/CSPDCL_IMAGES");
						} catch (Exception ee) {
							System.out.println("JavaCreateDirectoryExample= " + ee.getMessage());
						}

						String textfile_path = "c:/CSPDCL_IMAGES/" + BP_Number + ".txt";
						String image_path = "c:/CSPDCL_IMAGES/" + BP_Number + ".jpg";

						try {
							FileNameAutoChange fnc = new FileNameAutoChange();
							textfile_path = fnc.Name_series(textfile_path);
							image_path = fnc.Name_series(image_path);
						} catch (Exception ee) {
							System.out.println("FileNameAutoChange= " + ee.getMessage());
						}

						/*
						 * try { Base64ToImageConversion bi=new Base64ToImageConversion();
						 * bi.Base64Image(Rdg_Img,image_path); }catch(Exception ee) {
						 * System.out.println("Base64ToImageConversion= "+ee.getMessage()); }
						 */

						/*
						 * try { WriteToFileExample1 wf=new WriteToFileExample1();
						 * wf.TextfileWriting(Rdg_Img, textfile_path); }catch(Exception ee) {
						 * System.out.println("WriteToFileExample1= "+ee.getMessage()); }
						 */
						/* image data storing end */

						String Query = "INSERT INTO CSPDCL_OUTPUT (ADDL_SECURITY_RAISED,\r\n" + "BILL_NO,\r\n"
								+ "BP_NUMBER,\r\n" + "BANK_NAME,\r\n" + "BILL_AMOUNT_AFTER_DUE_DATE,\r\n"
								+ "BILL_DATE,\r\n" + "BILL_GENERATION_STATUS,\r\n" + "BILL_NET_WITHIN_DUE_DATE,\r\n"
								+ "BILL_TIME,\r\n" + "BILL_ISSUE_DATE,\r\n" +
								// "CASH_DUE_DATE,\r\n" +
								"CESS,\r\n" +
								// "CHEQUE_DUE_DATE,\r\n" +
								"CHQ_AMT,\r\n" + "CHQ_NUMBER,\r\n" +
								// "CHQ_DATE,\r\n" +
								"CONS_MOB_NO,\r\n" + "CREDIT_DLAMT,\r\n" + "CUR_BILL_MONTH,\r\n" + "CUR_BILL_YEAR,\r\n"
								+ "CUR_MTR_STS,\r\n" + "CUR_PF,\r\n" + "DISTRIBUTION_CODE,\r\n" + "DUTY,\r\n"
								+ "EC,\r\n" + "EVENT_LOG_NUMBER,\r\n" + "FC,\r\n" + "LTCS_CHARGE,\r\n"
								+ "LOW_PF_PENALITY_INCENTIVE,\r\n" + "MF,\r\n" + "MANUAL_DEMAND,\r\n"
								+ "METER_READER_NAME,\r\n" + "METER_RENT,\r\n" + "MISC_FLAG_MARK,\r\n"
								+ "OFFICE_INCHARGE,\r\n" + "ONLINE_FLAG_NUMBER,\r\n" + "PENALITY_FC,\r\n"
								+ "PENALTY_20_ADDL_CHG,\r\n" + "PENALTY_EC,\r\n" + "POLE_NUMBER,\r\n"
								+ "POSTING_DATE,\r\n" + "PRES_READ_KW_RMD,\r\n" + "PREV_ARREARS,\r\n" + "PREV_READ,\r\n"
								+ "REBATE_EC,\r\n" + "REBATE_FC,\r\n" + "REBATE_OTHER,\r\n" + "ROUND_OFF_AMOUNT,\r\n"
								+ "ROUTE_SEQ_NO,\r\n" + "SBM_NO,\r\n" + "SBM_SW_VER,\r\n" + "SD_ARREAR,\r\n"
								+ "SD_INTEREST,\r\n" + "SURCHARGE,\r\n" + "SURCHARGE_ARREARS,\r\n" + "TOTAL_BILL,\r\n"
								+ "UNIT_BILLED,\r\n" + "VCA_CHARGE,\r\n" + "VENDOR_CODE,\r\n" + "WTCS_SURCHARGE,\r\n"
								+ "ZONE_NAME,MRU,LATTITUDE,LONGITUDE,PRES_READ_KWH,METER_READING_UNIT,REMARKS,"
								+ "SERVER_TIME)  VALUES('" + Addl_Security_Raised + "','" + BILL_NO + "','" + BP_Number
								+ "','" + Bank_Name + "','" + Bill_Amount_After_Due_Date + "'," + "to_date('"
								+ Bill_Date + "','dd/MM/yyyy'),'" + Bill_Generation_Status + "','"
								+ Bill_Net_within_due_date + "','" + Bill_Time + "','" + Bill_issue_date + "','" +
								// "to_date('"+Cash_Due_Date+"','dd/MM/yyyy)"+
								Cess + "','" +
								// "to_date('"+Cheque_Due_Date+"','dd/MM/yyyy)"+
								Chq_Amt + "','" + Chq_Number + "','" +
								// Chq_date+"','"+
								Cons_Mob_No + "','" + Credit_DLAmt + "','" + Cur_Bill_Month + "','" + Cur_Bill_Year
								+ "','" + Cur_Mtr_Sts + "','" + Cur_PF + "','" + Distribution_Code + "','" + Duty
								+ "','" + EC + "','" + Event_log_number + "','" + FC + "','" + LTCS_Charge + "','"
								+ Low_PF_Penality_Incentive + "','" + MF + "','" + Manual_Demand + "','"
								+ Meter_Reader_Name + "','" + Meter_Rent + "','" + Misc_flag_mark + "','"
								+ Office_Incharge + "','" + Online_Flag_number + "','" + Penality_FC + "','"
								+ Penalty_20_Addl_Chg + "','" + Penalty_EC + "','" + Pole_Number + "','" + Posting_Date
								+ "','" + Pres_Read_KW_RMD + "','" + Prev_Arrears + "','" + Prev_Read + "','"
								+ Rebate_EC + "','" + Rebate_FC + "','" + Rebate_other + "','" + Round_Off_amount
								+ "','" + Route_Seq_No + "','" + SBM_NO + "','" + SBM_Sw_Ver + "','" + SD_Arrear + "','"
								+ SD_Interest + "','" + Surcharge + "','" + Surcharge_Arrears + "','" + Total_Bill
								+ "','" + Unit_Billed + "','" + VCA_Charge + "','" + Vendor_code + "','"
								+ WTCS_Surcharge + "','" + Zone_Name + "','" + MRU + "','" + Latitude + "','"
								+ Longitude + "','" + Pres_Read_KWH + "','" + Meter_Reading_Unit + "','" + Remarks
								+ "',sysdate)";

						System.out.println(Query);
						try {
							Thread.sleep(40);
							if ((loop == 0) || (loop % 20) == 0) {
								System.out.println(" i am in connection loop");
								if (con != null)
									con.close();

								Thread.sleep(10);
								con = db.getConnObject2();
								Thread.sleep(10);

							}
							System.out.println("Connection=" + con);

							DataStroringAutomatically da = new DataStroringAutomatically();
							int store_data = da.exicuteQuery(Query, con);
							System.out.println("store_data= " + store_data);

							/*
							 * if(store_data>0) { SmsGateWay s=new SmsGateWay();
							 * s.sendSms("Dear Customer BP="+BP_Number+", Your Bill Amount= "
							 * +Bill_Net_within_due_date,Cons_Mob_No);
							 * 
							 * } try { SmsGateWay s=new SmsGateWay();
							 * s.sendSms("Dear Customer BP="+BP_Number+", Your Bill Amount= "
							 * +Bill_Net_within_due_date,Cons_Mob_No);
							 * 
							 * }catch (Exception ee) { ee.printStackTrace(); }
							 */

						} catch (Exception e) {
							System.out.println(BP_Number + " " + e.getMessage());
						} finally {

							/*
							 * try { if(con!=null) con.close();
							 * 
							 * Thread.sleep(10); }catch (Exception e) {}
							 */
						}

						/*
						 * System.out.println("Addl_Security_Raised"+Addl_Security_Raised);
						 * System.out.println("BILL_NO"+BILL_NO);
						 * System.out.println("BP_Number"+BP_Number);
						 * System.out.println("Bank_Name"+Bank_Name);
						 * System.out.println("Bill_Amount_After_Due_Date"+Bill_Amount_After_Due_Date);
						 * System.out.println("Bill_Date"+Bill_Date);
						 * System.out.println("Bill_Generation_Status"+Bill_Generation_Status);
						 * System.out.println("Bill_Net_within_due_date"+Bill_Net_within_due_date);
						 * System.out.println("Bill_Time"+Bill_Time);
						 * System.out.println("Bill_issue_date"+Bill_issue_date);
						 * System.out.println("Cash_Due_Date"+Cash_Due_Date);
						 * System.out.println("Cess"+Cess);
						 * System.out.println("Cheque_Due_Date"+Cheque_Due_Date);
						 * System.out.println("Chq_Amt"+Chq_Amt);
						 * System.out.println("Chq_Number"+Chq_Number);
						 * System.out.println("Chq_date"+Chq_date);
						 * System.out.println("Cons_Mob_No"+Cons_Mob_No);
						 * System.out.println("Credit_DLAmt"+Credit_DLAmt);
						 * System.out.println("Cur_Bill_Month"+Cur_Bill_Month);
						 * System.out.println("Cur_Bill_Year"+Cur_Bill_Year);
						 * System.out.println("Cur_Mtr_Sts"+Cur_Mtr_Sts);
						 * System.out.println("Cur_PF"+Cur_PF);
						 * System.out.println("Distribution_Code"+Distribution_Code);
						 * System.out.println("Duty"+Duty); System.out.println("EC"+EC);
						 * System.out.println("Event_log_number"+Event_log_number);
						 * System.out.println("FC"+FC); System.out.println("LTCS_Charge"+LTCS_Charge);
						 * System.out.println("Low_PF_Penality_Incentive"+Low_PF_Penality_Incentive);
						 * System.out.println("MF"+MF);
						 * System.out.println("Manual_Demand"+Manual_Demand);
						 * System.out.println("Meter_Reader_Name"+Meter_Reader_Name);
						 * System.out.println("Meter_Rent"+Meter_Rent);
						 * System.out.println("Misc_flag_mark"+Misc_flag_mark);
						 * System.out.println("Office_Incharge"+Office_Incharge);
						 * System.out.println("Online_Flag_number"+Online_Flag_number);
						 * System.out.println("Penality_FC"+Penality_FC);
						 * System.out.println("Penalty_20_Addl_Chg"+Penalty_20_Addl_Chg);
						 * System.out.println("Penalty_EC"+Penalty_EC);
						 * System.out.println("Pole_Number"+Pole_Number);
						 * System.out.println("Posting_Date"+Posting_Date);
						 * System.out.println("Pres_Read_KW_RMD"+Pres_Read_KW_RMD);
						 * System.out.println("Prev_Arrears"+Prev_Arrears);
						 * System.out.println("Prev_Read"+Prev_Read);
						 * System.out.println("Rebate_EC"+Rebate_EC);
						 * System.out.println("Rebate_FC"+Rebate_FC);
						 * System.out.println("Rebate_other"+Rebate_other);
						 * System.out.println("Round_Off_amount"+Round_Off_amount);
						 * System.out.println("Route_Seq_No"+Route_Seq_No);
						 * System.out.println("SBM_NO"+SBM_NO);
						 * System.out.println("SBM_Sw_Ver"+SBM_Sw_Ver);
						 * System.out.println("SD_Arrear"+SD_Arrear);
						 * System.out.println("SD_Interest"+SD_Interest);
						 * System.out.println("Surcharge"+Surcharge);
						 * System.out.println("Surcharge_Arrears"+Surcharge_Arrears);
						 * System.out.println("Total_Bill"+Total_Bill);
						 * System.out.println("Unit_Billed"+Unit_Billed);
						 * System.out.println("VCA_Charge"+VCA_Charge);
						 * System.out.println("Vendor_code"+Vendor_code);
						 * System.out.println("WTCS_Surcharge"+WTCS_Surcharge);
						 * System.out.println("Zone_Name"+Zone_Name);
						 */

					} else {
						System.out.println(BP_Number + " = already uploaded");

					}
					System.out.println("****************************");
				} catch (Exception e) {
					e.printStackTrace();
				}

				// new code end

				loop++;

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
		SqlDbFileReading app = new SqlDbFileReading();
//        app.selectAll("jdbc:sqlite:D:/CSPDCL/mobile db files/DMP_09052019_125413(0).db");
		app.selectAll("jdbc:sqlite:C:\\Users\\admin\\Downloads\\DMP_04062019_124505.db");

	}

}
