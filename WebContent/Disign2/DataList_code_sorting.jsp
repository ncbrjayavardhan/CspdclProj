<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.database.DataBaseOperations"%>
<%@page import="com.database.DbConnection"%>
<%@page import="java.sql.Connection"%>
<%
System.out.println("i am in total upload data show");

String number=request.getParameter("number");
/* String group=request.getParameter("group");
String count=request.getParameter("count"); */
String Query2="";
if(number!=null && !number.equalsIgnoreCase(" ") && !number.equalsIgnoreCase(""))
 Query2="select * from cspdcl_output where BP_NUMBER like '"+number+"%'";
else
	 Query2="select * from cspdcl_output";




/* int condition_val=0;
if(loactioncode!=null && !loactioncode.equalsIgnoreCase(" ") && !loactioncode.equalsIgnoreCase(""))
	{
	Query2=Query2+"where SUBSTR(MRU,3,2) like '"+loactioncode+"%' ";
	condition_val++;
	}
if(group!=null && !group.equalsIgnoreCase(" ") && !group.equalsIgnoreCase(""))
	{
	if(condition_val==1){
		Query2=Query2+"and ";
	}
	else{
		Query2=Query2+"where ";
	}
	Query2=Query2+" SUBSTR(MRU,7,2) like '"+group+"%'";
	}
/* if(count!=null)
	Query2=Query2+"and COUNT(MRU) like '"+count+"%'"; */
	/* 
Query2=Query2+" group by mru,CASH_DUE_DATE,CHEQUE_DUE_DATE";

System.out.println(loactioncode);
System.out.println(group);
System.out.println(count);
 */
System.out.println("Query2= "+Query2);
if(Query2 == null) return;
ResultSet rs=null;
Connection con=null;
PreparedStatement ps=null;
 try{


DbConnection dc=new DbConnection();
con=dc.getConnObject2();
DataBaseOperations dbo=new  DataBaseOperations();

/* String Query="SELECT distinct SUBSTR(MRU,3,2)as division,SUBSTR(MRU,7,2) as group_code,count(mru) from CSPDCL_INPUT2  group by mru";
 */
 String Query="SELECT distinct SUBSTR(MRU,3,2)as division,SUBSTR(MRU,7,2) as group_code,CASH_DUE_DATE,CHEQUE_DUE_DATE,count(mru) from CSPDCL_output  group by mru,CASH_DUE_DATE,CHEQUE_DUE_DATE";
rs=dbo.exicuteQueryReesultSet(Query2, con, rs,ps);
}catch(Exception e){
	System.out.println(e.getMessage());
	
} 


/* out.print("hiii"); */
 out.print("<table border='1' width='100%' id='myTable'>");
out.print("<caption><b>VAIBHU Infra</b></caption>");
out.print("<tr bgcolor='#33BEFF'>");
out.print("<td><b>BP NUMBER</b></td>");
out.print("<td><b>CURRENT MTR READING</b></td>");
out.print("<td><b>UNIT CONSUMPTION</b></td>");
out.print("<td><b>MTR STATUS</b></td>");
out.print("<td><b>BILL MONTH </b></td>");
out.print("<td><b>View</b></td>");

out.print("</tr>");
/* out.print("<tr>");
out.print("<form id='ordertable' name='ordertable'>");
out.print("<td> <input type='checkbox' id='dob' name='dob' class='form-control' ></td>");
out.print("<td><input type='text' id='locationcode' name='locationcode' class='form-control' onchange='TableSort()'></td>");
out.print("<td><input type='text' id='group' name='group' class='form-control' onchange='TableSort()'></td>");
out.print("<td><input type='text' id='count' name='count' class='form-control' onchange='TableSort()'></td>");
out.print("<td><input type='date' id='dob' name='dob' class='form-control'></td>");
out.print("<td><input type='date' id='dob' name='dob' class='form-control'></td>");
out.print("<td><input type='date' id='dob' name='dob' class='form-control'></td>");
out.print("<td><input type='date' id='dob' name='dob' class='form-control'></td>");
out.print("</form>"); 
out.print("</tr>");  */

try{
	
while(rs.next()){
	
out.print("<tr>");
session.setAttribute("BP_NUMBER",rs.getString("BP_NUMBER"));
session.setAttribute("READING_IMAGE",rs.getString("READING_IMAGE"));

out.print("<td>"+rs.getString("BP_NUMBER")+"</td>");
out.print("<td>"+rs.getString("PRES_READ_KWH")+"</td>");
out.print("<td>"+rs.getString("UNIT_BILLED")+"</td>");
out.print("<td>"+rs.getString("CUR_MTR_STS")+"</td>");
out.print("<td>"+rs.getString("CUR_BILL_MONTH")+"</td>");
if(rs.getString("READING_IMAGE") == null){
	out.print("<td><form name='submitForm' method='POST' action='ConsumerView.jsp'><input type='hidden' name='page' value='ProfileViewing.jsp'><button type='submit' class='btn btn-success waves-effect waves-light m-r-10'>View</button></form></td>");
}else{
	out.print("<td><img src="+rs.getString("READING_IMAGE")+"/></td>");
}
//
out.print("</tr>");

	}
}catch(Exception e){
	e.printStackTrace();
	System.out.println(e.getMessage());
}finally{
	try{
	if(rs!=null)
		rs.close();
	if(con!=null)
		con.close();}catch(Exception ee){}
}

 out.print("</table>"); 
 


%>