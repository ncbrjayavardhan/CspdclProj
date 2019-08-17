package com.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataGettingPojo 
{
	String error_msg="";
	String gr_cd="";
	
	String unit_kwh="";
	String fix_chg="";
	String ec="";
	String ed="";
	String tot_net="";
	String tot_grs="";
	String prv_yr_arr="";
	String cur_yr_arr="";
	String bill_dt="";
	String due_dt="";
	String cur_intres="";
	String reg_ch="";
	String bill_time="";
	String today="";
	String scno="";
	String bookno="";
	String rowno="";
	String prstreading;
	String Opreading;
	
	String LATITUDE="";
	String LONGITUDE="";
	String sload="",curload="";
	
	
	
	 HashMap<String,String> map=null;
	 ArrayList<String> li=null;
	 
	 
	 
	 
	 public String getError_msg() {
			return error_msg;
		}
		public void setError_msg(String error_msg) {
			this.error_msg = error_msg;
		}
		public void setMap(HashMap<String, String> map) {
			this.map = map;
		}
	
	
	public HashMap<String, String> getMap() {
		return map;
	}
	public void setMap(Map<String, String> mp) {
		this.map = (HashMap<String, String>) mp;
	}
	public ArrayList<String> getLi() {
		return li;
	}
	public void setLi(ArrayList<String> li) {
		this.li = li;
	}
	public String getGr_cd() {
		return gr_cd;
	}
	public void setGr_cd(String gr_cd) {
		this.gr_cd = gr_cd;
	}
	public String getUnit_kwh() {
		return unit_kwh;
	}
	public void setUnit_kwh(String unit_kwh) {
		this.unit_kwh = unit_kwh;
	}
	public String getFix_chg() {
		return fix_chg;
	}
	public void setFix_chg(String fix_chg) {
		this.fix_chg = fix_chg;
	}
	public String getEc() {
		return ec;
	}
	public void setEc(String ec) {
		this.ec = ec;
	}
	public String getEd() {
		return ed;
	}
	public void setEd(String ed) {
		this.ed = ed;
	}
	public String getTot_net() {
		return tot_net;
	}
	public void setTot_net(String tot_net) {
		this.tot_net = tot_net;
	}
	public String getTot_grs() {
		return tot_grs;
	}
	public void setTot_grs(String tot_grs) {
		this.tot_grs = tot_grs;
	}
	public String getPrv_yr_arr() {
		return prv_yr_arr;
	}
	public void setPrv_yr_arr(String prv_yr_arr) {
		this.prv_yr_arr = prv_yr_arr;
	}
	public String getCur_yr_arr() {
		return cur_yr_arr;
	}
	public void setCur_yr_arr(String cur_yr_arr) {
		this.cur_yr_arr = cur_yr_arr;
	}
	public String getBill_dt() {
		return bill_dt;
	}
	public void setBill_dt(String bill_dt) {
		this.bill_dt = bill_dt;
	}
	public String getDue_dt() {
		return due_dt;
	}
	public void setDue_dt(String due_dt) {
		this.due_dt = due_dt;
	}
	public String getCur_intres() {
		return cur_intres;
	}
	public void setCur_intres(String cur_intres) {
		this.cur_intres = cur_intres;
	}
	public String getReg_ch() {
		return reg_ch;
	}
	public void setReg_ch(String reg_ch) {
		this.reg_ch = reg_ch;
	}
	public String getBill_time() {
		return bill_time;
	}
	public void setBill_time(String bill_time) {
		this.bill_time = bill_time;
	}
	public String getToday() {
		return today;
	}
	public void setToday(String today) {
		this.today = today;
	}
	public String getScno() {
		return scno;
	}
	public void setScno(String scno) {
		this.scno = scno;
	}
	public String getBookno() {
		return bookno;
	}
	public void setBookno(String bookno) {
		this.bookno = bookno;
	}
	public String getRowno() {
		return rowno;
	}
	public void setRowno(String rowno) {
		this.rowno = rowno;
	}
	public String getPrstreading() {
		return prstreading;
	}
	public void setPrstreading(String prstreading) {
		this.prstreading = prstreading;
	}
	public String getOpreading() {
		return Opreading;
	}
	public void setOpreading(String opreading) {
		Opreading = opreading;
	}
	public String getLATITUDE() {
		return LATITUDE;
	}
	public void setLATITUDE(String lATITUDE) {
		LATITUDE = lATITUDE;
	}
	public String getLONGITUDE() {
		return LONGITUDE;
	}
	public void setLONGITUDE(String lONGITUDE) {
		LONGITUDE = lONGITUDE;
	}
	public String getSload() {
		return sload;
	}
	public void setSload(String sload) {
		this.sload = sload;
	}
	public String getCurload() {
		return curload;
	}
	public void setCurload(String curload) {
		this.curload = curload;
	}
	
	
	
}