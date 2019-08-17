<%@page import="com.database.DivisionsList"%>
<%@page import="java.util.List"%>
<%@page import="com.database.DashBoardData"%>
<%@page import="com.pojo.DashBoardPojo"%>
<%

System.out.println("i am in MRU Getting");

String div_id=request.getParameter("circle");

DivisionsList dl=new DivisionsList();
List li_mru=dl.MruListGetting(div_id);

out.print("<option>selet MRU</option>");
for(int i=0;i<li_mru.size();i++){

out.print("<option>"+li_mru.get(i)+"</option>");

}
out.print("<option>All</option>");

%>