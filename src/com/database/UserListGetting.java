package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pojo.UserIdPojo;

public class UserListGetting {



public List UserDetails(String SUPERVISOR_USER_NAME) {
	

Connection con=null;
ResultSet rs=null;
PreparedStatement ps=null;

ResultSet rs2=null;
PreparedStatement ps2=null;

System.out.println(" i am in UserDetails");

DataBaseOperations dbo=new DataBaseOperations();
DbConnection db=new DbConnection();

List<UserIdPojo> li=new ArrayList<UserIdPojo>();
con=db.getConnObject2();
String userid=null;
try {

String Query=" select * from CSPDCL_WEB_USERS where USER_NAME='"+SUPERVISOR_USER_NAME+"'";
rs=dbo.exicuteQueryReesultSet(Query, con, rs, ps);


while(rs.next()) {

userid=rs.getString("USER_ID");
}
}catch (Exception e) {
e.printStackTrace();
}finally {

}



try {

String Query=" select * from CSPDCL_LOGIN where SUPER_ID='"+userid+"'";
rs=dbo.exicuteQueryReesultSet(Query, con, rs, ps);


while(rs.next()) {
UserIdPojo ui=new UserIdPojo();
ui.setID(rs.getString("METER_READER_UID"));
ui.setUSER_NAME(rs.getString("USER_NAME"));
ui.setPASSWORD(rs.getString("PASSWORD"));
ui.setEMAIL(rs.getString("EMAIL"));
ui.setMOBILE_NUM(rs.getString("MOBILE_NUM"));
ui.setDESIGNATION_CODE(rs.getString("DESIGNATION_CODE"));
ui.setIMEI_1(rs.getString("IMEI_1"));
ui.setIMEI_2(rs.getString("IMEI_2"));
ui.setMETER_READER_UID(rs.getString("METER_READER_UID"));
ui.setSUPER_MOBILE(rs.getString("SUPER_MOBILE"));
ui.setSUPER_ID(rs.getString("SUPER_ID"));
li.add(ui);

}

}catch (Exception e) {
e.printStackTrace();
}

finally {
	try {
		if(rs!=null)
			rs.close();
	}catch(Exception e) {}

	try {
		if(ps!=null)
			ps.close();
	}catch(Exception e) {}

	try {
		if(con!=null)
			con.close();
	}catch(Exception e) {}
}
return li;
}

//////////////////////////////////////////////////////////////////////////////////////////////


public List<UserIdPojo> UserDetailsLike(String mr_userid, String SUPERVISOR_USER_NAME) {


Connection con=null;
ResultSet rs=null;
PreparedStatement ps=null;

ResultSet rs2=null;
PreparedStatement ps2=null;

System.out.println(" i am in UserDetails like");

DataBaseOperations dbo=new DataBaseOperations();
DbConnection db=new DbConnection();

List<UserIdPojo> li=new ArrayList<UserIdPojo>();

String userid2=null;
try {
	con=db.getConnObject2();

String Query=" select * from CSPDCL_WEB_USERS where USER_NAME='"+SUPERVISOR_USER_NAME+"'";
rs=dbo.exicuteQueryReesultSet(Query, con, rs, ps);


while(rs.next()) {

userid2=rs.getString("USER_ID");
}
}catch (Exception e) {
e.printStackTrace();
}finally {
try {
	if(rs!=null)
		rs.close();
}catch(Exception e) {}

try {
	if(ps!=null)
		ps.close();
}catch(Exception e) {}

try {
	if(con!=null)
		con.close();
}catch(Exception e) {}
}



try {
	con=db.getConnObject2();

String Query=" select * from CSPDCL_LOGIN where USER_NAME like '"+mr_userid+"%' and SUPER_ID='"+userid2+"'";

System.out.println("Query=  "+Query);

rs=dbo.exicuteQueryReesultSet(Query, con, rs, ps);


while(rs.next()) {
UserIdPojo ui=new UserIdPojo();
ui.setID(rs.getString("METER_READER_UID"));
ui.setUSER_NAME(rs.getString("USER_NAME"));
ui.setPASSWORD(rs.getString("PASSWORD"));
ui.setEMAIL(rs.getString("EMAIL"));
ui.setMOBILE_NUM(rs.getString("MOBILE_NUM"));
ui.setDESIGNATION_CODE(rs.getString("DESIGNATION_CODE"));
ui.setIMEI_1(rs.getString("IMEI_1"));
ui.setIMEI_2(rs.getString("IMEI_2"));
ui.setMETER_READER_UID(rs.getString("METER_READER_UID"));
ui.setSUPER_MOBILE(rs.getString("SUPER_MOBILE"));
ui.setSUPER_ID(rs.getString("SUPER_ID"));
li.add(ui);

}

}catch (Exception e) {
e.printStackTrace();
}

finally {
	try {
		if(rs!=null)
			rs.close();
	}catch(Exception e) {}

	try {
		if(ps!=null)
			ps.close();
	}catch(Exception e) {}

	try {
		if(con!=null)
			con.close();
	}catch(Exception e) {}
}
return li;
}



////////////////////////////////////////////////////////////////////////////////////////////////

public List UserDetailsWithMeter_id(String Meter_reader_uid) {


Connection con=null;
ResultSet rs=null;
PreparedStatement ps=null;

ResultSet rs2=null;
PreparedStatement ps2=null;

System.out.println(" i am in UserDetails");

DataBaseOperations dbo=new DataBaseOperations();
DbConnection db=new DbConnection();

List<UserIdPojo> li=new ArrayList<UserIdPojo>();
con=db.getConnObject2();
String userid=null;




try {

String Query="select A.EMAIL ,a.DESIGNATION_CODE , A.IMEI_1 ,A.IMEI_2  ,A.USER_NAME,A.METER_READER_UID,A.MOBILE_NUM,\r\n" + 
" b.METER_READER_ADDRESS,b.METER_READER_FATHER_NAME,b.METER_READER_NAME,b.METER_READER_UID\r\n" + 
"  from CSPDCL_LOGIN a inner join CSPDCL_METER_READERS b on A.METER_READER_UID='"+Meter_reader_uid+"' and b.METER_READER_UID='"+Meter_reader_uid+"'";

System.out.println(Query);
rs=dbo.exicuteQueryReesultSet(Query, con, rs, ps);


while(rs.next()) {
UserIdPojo ui=new UserIdPojo();
//ui.setID(rs.getString("ID"));
ui.setUSER_NAME(rs.getString("USER_NAME"));
//ui.setPASSWORD(rs.getString("PASSWORD"));
ui.setEMAIL(rs.getString("EMAIL"));
ui.setMOBILE_NUM(rs.getString("MOBILE_NUM"));
ui.setDESIGNATION_CODE(rs.getString("DESIGNATION_CODE"));
ui.setIMEI_1(rs.getString("IMEI_1"));
ui.setIMEI_2(rs.getString("IMEI_2"));
ui.setMETER_READER_UID(rs.getString("METER_READER_UID"));
//ui.setSUPER_MOBILE(rs.getString("SUPER_MOBILE"));
//ui.setSUPER_ID(rs.getString("SUPER_ID"));
//ui.setMETER_READER_UID(rs.getString("METER_READER_UID"));
ui.setMETER_READER_NAME(rs.getString("METER_READER_NAME"));
ui.setMETER_READER_FATHER_NAME(rs.getString("METER_READER_FATHER_NAME"));
ui.setMETER_READER_ADDRESS(rs.getString("METER_READER_ADDRESS"));

li.add(ui);

}

}catch (Exception e) {
e.printStackTrace();
}

finally {
try {
if(rs!=null)
rs.close();
}catch (Exception ee) {}
try {
if(ps!=null)
ps.close();
}catch (Exception ee) {}
try {
if(con!=null)
con.close();
}catch (Exception ee) {
// TODO: handle exception
}

}
return li;

}


public String MrGroupsGetting(String Meter_reader_id) {


System.out.println(" i am in UserDetails");


Connection con=null;
ResultSet rs=null;
PreparedStatement ps=null;

ResultSet rs2=null;
PreparedStatement ps2=null;

DataBaseOperations dbo=new DataBaseOperations();
DbConnection db=new DbConnection();

List<String> li=new ArrayList<>();
String userid=null;
String username=null;
String  gr_codes="";
try {

	con=db.getConnObject2();

String Query="select * from CSPDCL_LOGIN where METER_READER_UID='"+Meter_reader_id+"'";
System.out.println(Query);
rs2=dbo.exicuteQueryReesultSet(Query, con, rs2, ps2);

while(rs2.next()) {
	
UserIdPojo ui=new UserIdPojo();
//ui.setID(rs.getString("ID"));
username=rs2.getString("USER_NAME");


}

}catch(java.sql.SQLException e) {
	try {
	con.clearWarnings();
	}catch(Exception ee) {}
	
	try {
		con.close();
		}catch(Exception ee) {}
	e.printStackTrace();
}

catch (Exception e) {
e.printStackTrace();
}

finally {
try {
if(rs2!=null)
rs2.close();
}catch (Exception ee) {}

try {
if(ps2!=null)
ps2.close();
}catch (Exception ee) {}

try {
if(con!=null)
con.close();
}catch (Exception ee) {}

}


try {
	con=db.getConnObject2();

String Query="select * from CSPDCL_DATA_ALLOCATION where USER_NAME='"+username+"'";
System.out.println(Query);
rs=dbo.exicuteQueryReesultSet(Query, con, rs, ps);

while(rs.next()) {
	
UserIdPojo ui=new UserIdPojo();
//ui.setID(rs.getString("ID"));
gr_codes=rs.getString("GROUP_CODE")+","+gr_codes;


}

}catch (Exception e) {
e.printStackTrace();
}

finally {
try {
if(rs!=null)
rs.close();
if(ps!=null)
ps.close();
if(con!=null)
con.close();
}catch (Exception ee) {
// TODO: handle exception
}

}
return gr_codes;

}

}
