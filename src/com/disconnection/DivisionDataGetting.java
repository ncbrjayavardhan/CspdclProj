package com.disconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.database.DbConnection;

public class DivisionDataGetting {

	/*
	 * public List DisconnectedconsumerData(String Query ) {
	 * 
	 * Connection con=null; PreparedStatement ps1=null; ResultSet count=null;
	 * Map<String,String> mp=new HashMap<>(); List<BillingCountPojo> li=new
	 * ArrayList<>(); DbConnection db=new DbConnection(); con=db.getConnObject2();
	 * 
	 * BillingCountPojo dsp=null;
	 * 
	 * System.out.println("Query= "+Query); try { ps1 = con.prepareStatement(Query);
	 * count=ps1.executeQuery(); while(count.next()){
	 * 
	 * dsp=new BillingCountPojo(); mp.put("BOOK_CODE",
	 * count.getString("BOOK_CODE")); mp.put("scno", count.getString("scno"));
	 * mp.put("MTR_NUMBER", count.getString("MTR_NUMBER")); mp.put("ACCOUNTNO",
	 * count.getString("ACCOUNTNO")); mp.put("NAME", count.getString("NAME"));
	 * mp.put("DISCONNECTION_DATE", count.getString("DISCONNECTION_DATE"));
	 * mp.put("RESON1", count.getString("RESON1")); mp.put("RESON2",
	 * count.getString("RESON2")); mp.put("TOTPAYAMT",
	 * count.getString("TOTPAYAMT"));
	 * 
	 * li.add(count.getString("BOOK_CODE")); li.add(count.getString("scno"));
	 * li.add(count.getString("MTR_NUMBER")); li.add(count.getString("ACCOUNTNO"));
	 * li.add( count.getString("NAME"));
	 * li.add(count.getString("DISCONNECTION_DATE")); li.add(
	 * count.getString("RESON1")); li.add(count.getString("RESON2")); //
	 * li.add(count.getString("TOTPAYAMT"));
	 * 
	 * dsp.setScno((count.getString("SCNO")));
	 * dsp.setBOOK_CODE((count.getString("BOOK_CODE")));
	 * dsp.setMTR_NUMBER((count.getString("MTR_NUMBER")));
	 * dsp.setACCOUNTNO((count.getString("ACCOUNTNO")));
	 * dsp.setNAME((count.getString("NAME")));
	 * dsp.setADDRESS1((count.getString("ADDRESS1")));
	 * dsp.setADDRESS2((count.getString("ADDRESS2")));
	 * dsp.setLATITUDE((count.getString("LATITUDE")));
	 * dsp.setLONGITUDE((count.getString("LONGITUDE")));
	 * dsp.setDISCONNECTION_DATE((count.getString("DISCONNECTION_DATE")));
	 * dsp.setCATEGORY((count.getString("CATEGORY")));
	 * dsp.setMAX_DEMAND((count.getString("MAX_DEMAND")));
	 * dsp.setDISCONNECTION_READING((count.getString("DISCONNECTION_READING")));
	 * dsp.setRESON1((count.getString("RESON1")));
	 * dsp.setRESON2((count.getString("RESON2")));
	 * dsp.setRCDC_AMOUNT((count.getString("RCDC_AMOUNT")));
	 * dsp.setDIVISION_ID((count.getString("DIVISION_ID")));
	 * dsp.setSUBDIVISION((count.getString("SUBDIVISION")));
	 * dsp.setSERVER_DATE((count.getString("SERVER_DATE")));
	 * 
	 * System.out.println("li= "+li.size()); li.add(dsp);
	 * 
	 * }
	 * 
	 * }catch (Exception e) { e.printStackTrace(); }finally { try {if(count!=null)
	 * count.close(); }catch(Exception e) {}
	 * 
	 * try {if(ps1!=null) ps1.close(); }catch(Exception e) {} try {if(con!=null)
	 * con.close(); }catch(Exception e) {}
	 * 
	 * 
	 * } return li; }
	 */

	/*
	 * public static void main(String args[]) {
	 * 
	 * DivisionDataGetting dd = new DivisionDataGetting();
	 * dd.DisconnectedconsumerData("select *  from disconnection_android"); }
	 */
}
