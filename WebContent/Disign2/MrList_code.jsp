<%@page import="com.pojo.UserIdPojo"%>
<%@page import="java.util.List"%>
<%@page import="com.database.UserListGetting"%>
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


System.out.println(" i am in MrList ");
UserListGetting ur=new UserListGetting();
List li=ur.UserDetailsLike(number,(String)session.getAttribute("username"));
%>


<%
out.print("<table id='myTable5'>");
out.print("<tr class='header'>");
out.print("<th style='width:30%;'>USER_NAME</th>");
out.print(" <th style='width:40%;'>EMAIL</th>");
out.print("<th style='width:60%;'>Contact No</th>");
out.print("</tr>");
                            

%>        
<%for(int i=0;i<li.size();i++){ 
  UserIdPojo op=new UserIdPojo();
  op=(UserIdPojo)li.get(i);          
  
 // System.out.println("User name= "+op.getUSER_NAME());
%>
				
<%
out.print("<tr>");
out.print("<td>"+op.getUSER_NAME()+"</td>");
out.print("<td>"+op.getEMAIL()+"</td>");
out.print("<td>"+op.getMOBILE_NUM()+"</td>");
out.print("<td>");
out.print("<form name='submitForm' method='get' action='MeterReaderUpdate.jsp'>");
out.print("<input type='hidden' name='id' value='"+op.getID()+"'>");
out.print("<button type='submit' class='btn btn-success waves-effect waves-light m-r-10'>View</button>");
out.print("</form>");
out.print(" <td>");
out.print("</tr>");

} 
out.print("</table>");

%>




