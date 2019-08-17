package com.sqldb;

import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import com.database.DbConnection;
import com.database.FileNameAutoChange;
import com.database.JavaCreateDirectoryExample;

import cspdcl.input.DataStroringAutomatically;
//import com.mysema.util.ResultSetAdapter;

public class SqlDbFileToCsv {

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
		File dbCsvFile = null;
		FileWriter dbfilecsvWriter = null;

		try (Connection conn = this.connect(path);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			
			
			int k = 0;
			// loop through the result set
			DbConnection db = new DbConnection();
			DbConnection db2 = new DbConnection();
			try {
				dbCsvFile = new File("d://dbcsvfile.txt");
				dbfilecsvWriter = new FileWriter(dbCsvFile);
				dbfilecsvWriter.write(
						" Addl_Security_Raised,	BILL_NO,	BP_Number,	Bank_Name,	Bill_Amount_After_Due_Date,	Bill_Date,	Bill_Generation_Status,	Bill_Net_within_due_date,	Bill_Time,	Bill_issue_date,	Cash_Due_Date,	Cess,	Cheque_Due_Date,	Chq_Amt,	Chq_Number,	Chq_date,	Cons_Mob_No,	Credit_DLAmt,	Cur_Bill_Month,	Cur_Bill_Year,	Cur_Mtr_Sts,	Cur_PF,	Distribution_Code,	Duty,	EC,	Event_log_number,	FC,	LTCS_Charge,	Latitude,	Longitude,	Low_PF_Penality_Incentive,	MF,	MRU,	Manual_Demand,	Meter_Reader_Name,	Meter_Reading_Unit,	Meter_Rent,	Misc_flag_mark,	Office_Incharge,	Online_Flag_number,	Penality_FC,	Penalty_20_Addl_Chg,	Penalty_EC,	Pole_Number,	Posting_Date,	Pres_Read_KWH,	Pres_Read_KW_RMD,	Prev_Arrears,	Prev_Read");
				dbfilecsvWriter.write("\n");

			} catch (Exception e) {
				e.printStackTrace();
			}
			int loop = 0;
			while (rs.next()) {

				//System.out.println("row no= " + (++k));

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

					dbfilecsvWriter.write(Addl_Security_Raised + "," + BILL_NO + "," + BP_Number + "," + Bank_Name + ","
							+ Bill_Amount_After_Due_Date + "," + Bill_Date + "," + Bill_Generation_Status + ","
							+ Bill_Net_within_due_date + "," + Bill_Time + "," + Bill_issue_date + "," + Cash_Due_Date
							+ "," + Cess + "," + Cheque_Due_Date + "," + Chq_Amt + "," + Chq_Number + "," + Chq_date
							+ "," + Cons_Mob_No + "," + Credit_DLAmt + "," + Cur_Bill_Month + "," + Cur_Bill_Year + ","
							+ Cur_Mtr_Sts + "," + Cur_PF + "," + Distribution_Code + "," + Duty + "," + EC + ","
							+ Event_log_number + "," + FC + "," + LTCS_Charge + "," + Latitude + "," + Longitude + ","
							+ Low_PF_Penality_Incentive + "," + MF + "," + MRU + "," + Manual_Demand + ","
							+ Meter_Reader_Name + "," + Meter_Reading_Unit + "," + Meter_Rent + "," + Misc_flag_mark
							+ "," + Office_Incharge + "," + Online_Flag_number + "," + Penality_FC + ","
							+ Penalty_20_Addl_Chg + "," + Penalty_EC + "," + Pole_Number + "," + Posting_Date + ","
							+ Pres_Read_KWH + "," + Pres_Read_KW_RMD + "," + Prev_Arrears + "," + Prev_Read);

					dbfilecsvWriter.write("\n");
					System.out.println("****************************");
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
				}

				// new code end

				loop++;

			}

			try {

				if (dbfilecsvWriter != null) {
					dbfilecsvWriter.flush();
					dbfilecsvWriter.close();
					dbCsvFile.exists();

				}

			} catch (Exception e) {
				e.printStackTrace();
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
		SqlDbFileToCsv app = new SqlDbFileToCsv();
//        app.selectAll("jdbc:sqlite:D:/CSPDCL/mobile db files/DMP_09052019_125413(0).db");
		app.selectAll("jdbc:sqlite:C:\\Users\\admin\\Downloads\\DMP_04062019_124505.db");

	}

}
