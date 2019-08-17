package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OutputSingleRecordGettion {
	
	Connection con=null;
	ResultSet rs=null;
	PreparedStatement ps=null;

	public DataOutputPojo singlerecord(String BP_NUMBER) {
		
		DataBaseOperations dbo=new DataBaseOperations();
		DbConnection db=new DbConnection();
		DataOutputPojo op=new DataOutputPojo();
		try {
			
			String Query=" select * from cspdcl_output where BP_NUMBER='"+BP_NUMBER+"'";
			
			System.out.println("Query= "+Query);
			
		con=db.getConnObject2();
		rs=dbo.exicuteQueryReesultSet(Query, con, rs, ps);
	
		
		while(rs.next()) {
			op.setADDL_SECURITY_RAISED(rs.getString("ADDL_SECURITY_RAISED"));
			op.setAPP_VERSION(rs.getString("APP_VERSION"));
			op.setBANK_NAME(rs.getString("BANK_NAME"));
			op.setBILL_AMOUNT_AFTER_DUE_DATE(rs.getString("BILL_AMOUNT_AFTER_DUE_DATE"));
			op.setBILL_DATE(rs.getString("BILL_DATE"));
			op.setBILL_GENERATION_STATUS(rs.getString("BILL_GENERATION_STATUS"));
			op.setBILL_ISSUE_DATE(rs.getString("BILL_ISSUE_DATE"));
			op.setBILL_MONTH(rs.getString("BILL_MONTH"));
			op.setBILL_NET_WITHIN_DUE_DATE(rs.getString("BILL_NET_WITHIN_DUE_DATE"));
			op.setBILL_NO(rs.getString("BILL_NO"));
			op.setBILL_TIME(rs.getString("BILL_TIME"));
			op.setBP_NUMBER(rs.getString("BP_NUMBER"));
			op.setCASH_DUE_DATE(rs.getString("CASH_DUE_DATE"));
			op.setCESS(rs.getString("CESS"));
			op.setCHEQUE_DUE_DATE(rs.getString("CHEQUE_DUE_DATE"));
			op.setCHQ_AMT(rs.getString("CHQ_AMT"));
			op.setCHQ_DATE(rs.getString("CHQ_DATE"));
			op.setCHQ_NUMBER(rs.getString("CHQ_NUMBER"));
			op.setCONS_MOB_NO(rs.getString("CONS_MOB_NO"));
			op.setCREDIT_DLAMT(rs.getString("CREDIT_DLAMT"));
			op.setCUR_BILL_MONTH(rs.getString("CUR_BILL_MONTH"));
			op.setCUR_BILL_YEAR(rs.getString("CUR_BILL_YEAR"));
			op.setCUR_MTR_STS(rs.getString("CUR_MTR_STS"));
			op.setCUR_PF(rs.getString("CUR_PF"));
			op.setDISTRIBUTION_CODE(rs.getString("DISTRIBUTION_CODE"));
			op.setDUTY(rs.getString("DUTY"));
			op.setEC(rs.getString("EC"));
			op.setEVENT_LOG_NUMBER(rs.getString("EVENT_LOG_NUMBER"));
			op.setFC(rs.getString("FC"));
			op.setIMAGE_PATH(rs.getString("IMAGE_PATH"));
			op.setLATTITUDE(rs.getString("LATTITUDE"));
			op.setLONGITUDE(rs.getString("LONGITUDE"));
			op.setLOW_PF_PENALITY_INCENTIVE(rs.getString("LOW_PF_PENALITY_INCENTIVE"));
			op.setLTCS_CHARGE(rs.getString("LTCS_CHARGE"));
			op.setMANUAL_DEMAND(rs.getString("MANUAL_DEMAND"));
			op.setMETER_READER_NAME(rs.getString("METER_READER_NAME"));
			op.setMETER_READING_UNIT(rs.getString("METER_READING_UNIT"));
			op.setMETER_RENT(rs.getString("METER_RENT"));
			op.setMF(rs.getString("MF"));
			op.setMISC_FLAG_MARK(rs.getString("MISC_FLAG_MARK"));
			op.setMRU(rs.getString("MRU"));
			op.setOFFICE_INCHARGE(rs.getString("OFFICE_INCHARGE"));
			op.setONLINE_FLAG_NUMBER(rs.getString("ONLINE_FLAG_NUMBER"));
			op.setPENALITY_FC(rs.getString("PENALITY_FC"));
			op.setPENALTY_20_ADDL_CHG(rs.getString("PENALTY_20_ADDL_CHG"));
			op.setPENALTY_EC(rs.getString("PENALTY_EC"));
			op.setPOLE_NUMBER(rs.getString("POLE_NUMBER"));
			op.setPOSTING_DATE(rs.getString("POSTING_DATE"));
			op.setPRES_READ_KW_RMD(rs.getString("PRES_READ_KW_RMD"));
			op.setPRES_READ_KWH(rs.getString("PRES_READ_KWH"));
			op.setPREV_ARREARS(rs.getString("PREV_ARREARS"));
			op.setPREV_READ(rs.getString("PREV_READ"));
			op.setREADING_IMAGE(rs.getString("READING_IMAGE"));
			op.setREBATE_EC(rs.getString("REBATE_EC"));
			op.setREBATE_FC(rs.getString("REBATE_FC"));
			op.setREBATE_OTHER(rs.getString("REBATE_OTHER"));
			op.setREMARKS(rs.getString("REMARKS"));
			op.setROUND_OFF_AMOUNT(rs.getString("ROUND_OFF_AMOUNT"));
			op.setROUTE_SEQ_NO(rs.getString("ROUTE_SEQ_NO"));
			op.setSBM_NO(rs.getString("SBM_NO"));
			op.setSBM_SW_VER(rs.getString("SBM_SW_VER"));
			op.setSD_ARREAR(rs.getString("SD_ARREAR"));
			op.setSD_INTEREST(rs.getString("SD_INTEREST"));
			op.setSERVER_TIME(rs.getString("SERVER_TIME"));
			op.setSURCHARGE(rs.getString("SURCHARGE"));
			op.setSURCHARGE_ARREARS(rs.getString("SURCHARGE_ARREARS"));
			op.setTOTAL_BILL(rs.getString("TOTAL_BILL"));
			op.setUNIT_BILLED(rs.getString("UNIT_BILLED"));
			op.setVCA_CHARGE(rs.getString("VCA_CHARGE"));
			op.setVENDOR_CODE(rs.getString("VENDOR_CODE"));
			op.setWTCS_SURCHARGE(rs.getString("WTCS_SURCHARGE"));
			op.setZONE_NAME(rs.getString("ZONE_NAME"));
		}
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			
		}
		return op;
	}

}
