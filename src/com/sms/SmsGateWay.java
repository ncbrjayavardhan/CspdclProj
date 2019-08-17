package com.sms;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;



public class SmsGateWay {
	//public static SocketBeans sms=null;
	public String sendSms(String msg, String mobilenumber){
		
//		SocketBeans sb2=new SocketBeans();
		//System.out.println("Scno "+sb2.getScno());
		String postData="";
		String retval = "";
		//String msg1=msg;
		String delimeter="\\$";
		String scno=null,book=null,billdt=null,totgrs=null,mbleno=null;
		String[] temp;
		
//		temp = msg.split(delimeter);
//		for(int i=0;i<temp.length;i++){
//			scno=temp[0];
//			book=temp[1];
//			mbleno=temp[2];
//			billdt=temp[3];
//			totgrs=temp[4];
//		}
		
		
		//String message="Scno :"+scno+" Book No :"+book+" Bill Date :"+billdt+" Bill Amount :"+totgrs;
		//give all Parameters In String 
		String User ="viipl_dvvnl";
		String passwd = "viipl@1611";
		//String mobilenumber =msg;
		
		//String message="SCNO :"+scno+"BOOK NO :"+book+"Bill Date :"+billdt+"Tot Amt :"+totgrs;
		
		String sid = "SMSCountry";
		String mtype = "N";
		String DR = "Y";		
		
		
		try{
		postData += "User=" + URLEncoder.encode(User,"UTF-8") + "&passwd=" + passwd + "&mobilenumber=" + mobilenumber + "&message=" + URLEncoder.encode(msg,"UTF-8") + "&sid=" + sid + "&mtype=" + mtype + "&DR=" + DR;
		URL url = new URL("http://smscountry.com/SMSCwebservice_Bulk.aspx");
		HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();

		// If You Are Behind The Proxy Server Set IP And PORT else Comment Below 4 Lines
		//Properties sysProps = System.getProperties();
		//sysProps.put("proxySet", "true");
		//sysProps.put("proxyHost", "Proxy Ip");
		//sysProps.put("proxyPort", "PORT");

		urlconnection.setRequestMethod("POST");
		urlconnection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
		urlconnection.setDoOutput(true);
		OutputStreamWriter out = new OutputStreamWriter(urlconnection.getOutputStream());
		out.write(postData);
		out.close();
		BufferedReader in = new BufferedReader(	new InputStreamReader(urlconnection.getInputStream()));
		String decodedString;
		while ((decodedString = in.readLine()) != null) {
			retval += decodedString;
		}
		in.close();

		System.out.println(retval);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return msg;
		
		
	}
	
	public static void main(String args[]){
		SmsGateWay s=new SmsGateWay();
    	s.sendSms("hiii sample message","9492391366");
		
	}

}
