<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.database.DataBaseOperations"%>
<%@page import="com.database.DbConnection"%>
<%@page import="java.sql.Connection"%>
<%
System.out.println("i am in DataList code ");

String from=request.getParameter("from");
String to=request.getParameter("to");
String count=request.getParameter("count");

String discome=request.getParameter("discome");
String division=request.getParameter("mru");
String circle=request.getParameter("circle");
String subdivision=request.getParameter("bmonth");


System.out.println(discome);
System.out.println(division);
System.out.println(circle);
System.out.println(subdivision);
System.out.println(from);
System.out.println(to);


String Query2="";


try{
	
	
	DateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd");
	DateFormat targetFormat = new SimpleDateFormat("dd-MMM-yyyy");
	Date  date= originalFormat.parse(from);
	String from_formattedDate = targetFormat.format(date); 
	
	Date  date2= originalFormat.parse(to);
	String to_formattedDate = targetFormat.format(date2); 
	
	
	System.out.println("formattedDate= "+to_formattedDate);
	
	
	//new query form for all --start
	
	if(division.equalsIgnoreCase("a") && circle.equalsIgnoreCase("a") )
		Query2="select BP_NUMBER,TOTAL_BILL,UNIT_BILLED,CUR_BILL_MONTH from cspdcl_output where BILL_DATE between to_date('"+from_formattedDate+"') and to_date('"+to_formattedDate+"')";
	else if(division.equalsIgnoreCase("a") && !circle.equalsIgnoreCase("a") )
		Query2="select BP_NUMBER,TOTAL_BILL,UNIT_BILLED,CUR_BILL_MONTH from cspdcl_output where BILL_DATE between to_date('"+from_formattedDate+"') and to_date('"+to_formattedDate+"') and SUBSTR(MRU,3,2)='"+circle+"'";
	else if(!division.equalsIgnoreCase("a") && circle.equalsIgnoreCase("a") )
		Query2="select BP_NUMBER,TOTAL_BILL,UNIT_BILLED,CUR_BILL_MONTH from cspdcl_output where BILL_DATE between to_date('"+from_formattedDate+"') and to_date('"+to_formattedDate+"')";
	else
		Query2="select BP_NUMBER,TOTAL_BILL,UNIT_BILLED,CUR_BILL_MONTH from cspdcl_output where BILL_DATE between to_date('"+from_formattedDate+"') and to_date('"+to_formattedDate+"') and MRU='"+division+"'";

	//new query form for all --start

//	Query2="select BP_NUMBER,TOTAL_BILL,UNIT_BILLED,CUR_BILL_MONTH from cspdcl_output where BILL_DATE between to_date('"+from_formattedDate+"') and to_date('"+to_formattedDate+"')";
//	Query2="select BP_NUMBER,TOTAL_BILL,UNIT_BILLED,CUR_BILL_MONTH from cspdcl_output where BILL_DATE between to_date('"+from_formattedDate+"') and to_date('"+to_formattedDate+"') and MRU='"+division+"'";

}catch(Exception e){
	//Query2="select BP_NUMBER,TOTAL_BILL,UNIT_BILLED,CUR_BILL_MONTH from cspdcl_output";
}


System.out.println(from);
System.out.println(to);
System.out.println(count);

System.out.println("Query2= "+Query2);







ResultSet rs=null;
Connection con=null;
PreparedStatement ps=null;
 try{


DbConnection dc=new DbConnection();
con=dc.getConnObject2();
DataBaseOperations dbo=new  DataBaseOperations();

/* String Query="SELECT distinct SUBSTR(MRU,3,2)as division,SUBSTR(MRU,7,2) as group_code,count(mru) from CSPDCL_INPUT2  group by mru";
 */
/*  String Query="SELECT distinct SUBSTR(MRU,3,2)as division,SUBSTR(MRU,7,2) as group_code,CASH_DUE_DATE,CHEQUE_DUE_DATE,count(mru) from CSPDCL_output  group by mru,CASH_DUE_DATE,CHEQUE_DUE_DATE";
 */
 rs=dbo.exicuteQueryReesultSet(Query2, con, rs,ps);
}catch(Exception e){
	System.out.println(e.getMessage());
	
} 

/* out.print("hiii"); */

 out.print("<table border='1' width='100%'> id='myTable'");
out.print("<tr><b>Cash&Check Date Update</b></tr>");
out.print("<tr>");
out.print("<td><b>BP NUMBER</b></td>");
out.print("<td><b>TOTAL BILL</b></td>");
out.print("<td><b>UNIT BILLED</b></td>");
out.print("<td><b>CUR BILL MONTH</b></td>");
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
out.print("<td>"+rs.getString("BP_NUMBER")+"</td>");
out.print("<td>"+rs.getString("TOTAL_BILL")+"</td>");
out.print("<td>"+rs.getString("UNIT_BILLED")+"</td>");
out.print("<td>"+rs.getString("CUR_BILL_MONTH")+"</td>");
out.print("<td><form name='submitForm' method='POST' action='/CspdclDashBoard/ImageDispalyServlet?id="+rs.getString("BP_NUMBER")+"'><input type='hidden' name='page' value='ProfileViewing.jsp'><button type='submit' class='btn btn-success waves-effect waves-light m-r-10'>View</button></form></td>");
out.print("</tr>");
	}
}catch(Exception e){
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