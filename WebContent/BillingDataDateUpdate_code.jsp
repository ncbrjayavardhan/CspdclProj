<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.database.DataBaseOperations"%>
<%@page import="com.database.DbConnection"%>
<%@page import="java.sql.Connection"%>
<%
System.out.println("i am in billinga data table update");

String discome=request.getParameter("discome");
String division=request.getParameter("mru");
String circle=request.getParameter("circle");
String subdivision=request.getParameter("bmonth");

String group=request.getParameter("group");


System.out.println(discome);
System.out.println(division);
System.out.println(circle);
System.out.println(subdivision);
System.out.println(group);
ResultSet rs=null;
Connection con=null;
PreparedStatement ps=null;
 try{


DbConnection dc=new DbConnection();
con=dc.getConnObject2();
DataBaseOperations dbo=new  DataBaseOperations();

/* String Query="SELECT distinct SUBSTR(MRU,3,2)as division,SUBSTR(MRU,7,2) as group_code,count(mru) from CSPDCL_INPUT2  group by mru";
 */
 //String Query="SELECT distinct SUBSTR(MRU,3,2)as division,SUBSTR(MRU,7,2) as group_code,CASH_DUE_DATE,CHEQUE_DUE_DATE,count(mru) from CSPDCL_output  group by mru,CASH_DUE_DATE,CHEQUE_DUE_DATE";
 String Query="";
 if(division!=null && !division.equalsIgnoreCase("null") && !division.equalsIgnoreCase(""))
  Query="SELECT distinct SUBSTR(MRU,3,2)as division,SUBSTR(MRU,7,2) as group_code,CASH_DUE_DATE,CHEQUE_DUE_DATE,count(mru) from CSPDCL_INPUT2 where mru='"+division+"' group by mru,CASH_DUE_DATE,CHEQUE_DUE_DATE";
 else
	  Query="SELECT distinct SUBSTR(MRU,3,2)as division,SUBSTR(MRU,7,2) as group_code,CASH_DUE_DATE,CHEQUE_DUE_DATE,count(mru) from CSPDCL_INPUT2 group by mru,CASH_DUE_DATE,CHEQUE_DUE_DATE";

 System.out.println(Query);
 rs=dbo.exicuteQueryReesultSet(Query, con, rs,ps);
}catch(Exception e){
	System.out.println(e.getMessage());
	
} 

/* out.print("hiii"); */

 out.print("<table border='1' width='100%'>");
 out.print("<form  id='ordertable2' name='ordertable2'>");
out.print("<tr><b>Cash&Check Date Update</b></tr>");
out.print("<tr>");
out.print("<td><b>Check All</b></td>");
out.print("<td><b>Location Code</b></td>");
out.print("<td><b>Group</b></td>");
out.print("<td><b>Count</b></td>");
out.print("<td><b>Bill Month</b></td>");
out.print("<td><b>Issue Date</b></td>");
out.print("<td><b>Check Date</b></td>");
out.print("<td><b>Cash Date</b></td>");
out.print("<td><b>Update</b></td>");
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
out.print("<td> <input type='checkbox'  name='group2' value='"+rs.getString("GROUP_CODE")+"' class='form-control'></td>");
out.print("<td>"+rs.getString("DIVISION")+"</td>");
out.print("<td>"+rs.getString("GROUP_CODE")+"</td>");
out.print("<td>"+rs.getString("COUNT(MRU)")+"</td>");
out.print("<td>fghfgh</td>");
out.print("<td>gjhgf</td>");
out.print("<td>"+rs.getString("CHEQUE_DUE_DATE")+"</td>");
out.print("<td>"+rs.getString("CASH_DUE_DATE")+"</td>");
out.print("<form action='DateUpdateServlet' method='post'>");
out.print("<input type='hidden' name='group' value='"+rs.getString("GROUP_CODE")+"'>");
out.print("<input type='hidden' name='areacode' value='"+rs.getString("DIVISION")+"'>");
/* out.print("<td> <button type='submit' class='btn btn-info waves-effect waves-light m-r-10' onClick='saveDates("+rs.getString("GROUP_CODE")+")'>Update</button></td>");
 */
 
 out.print("<td> <button type='submit' class='btn btn-info waves-effect waves-light m-r-10' onClick='saveDates("+rs.getString("GROUP_CODE")+","+rs.getString("DIVISION")+");'>Update</button></td>");
  
 out.print("</form>");
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