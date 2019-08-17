<%@page import="java.sql.Connection"%>
<%@page import="com.database.DbConnection"%>
<%@page import="cspdcl.input.DataStroringAutomatically"%>
<%

System.out.println("check date saving ");

String checkdate=request.getParameter("checkdate");
String cashdate=request.getParameter("cashdate");
String group=request.getParameter("group");
String division=request.getParameter("division");
System.out.println("checkdate= "+checkdate);
System.out.println("cashdate= "+cashdate);
System.out.println("group= "+group);
System.out.println("division= "+division);

int updated=0;
Connection con=null;
String Query="";
      if((checkdate==null || checkdate.equalsIgnoreCase("null") || checkdate.equalsIgnoreCase("")) && (cashdate!=null || !cashdate.equalsIgnoreCase("null") || !cashdate.equalsIgnoreCase("")))
     Query="update cspdcl_input2 set CASH_DUE_DATE=to_date('"+cashdate+"','yyyy-MM-dd') where SUBSTR(MRU,7,2)='"+group+"' and SUBSTR(MRU,3,2)='"+division+"'";
else if((cashdate==null || cashdate.equalsIgnoreCase("null")|| cashdate.equalsIgnoreCase(""))&& (checkdate!=null || !checkdate.equalsIgnoreCase("null") || !checkdate.equalsIgnoreCase("")))
     Query="update cspdcl_input2 set CHEQUE_DUE_DATE=to_date('"+checkdate+"','yyyy-MM-dd') where SUBSTR(MRU,7,2)='"+group+"' and SUBSTR(MRU,3,2)='"+division+"'";
else  if((cashdate!=null || !cashdate.equalsIgnoreCase("null") || !cashdate.equalsIgnoreCase("")) && (checkdate!=null || !checkdate.equalsIgnoreCase("null") || !checkdate.equalsIgnoreCase("")))
     Query="update cspdcl_input2 set CASH_DUE_DATE=to_date('"+cashdate+"','yyyy-MM-dd'),CHEQUE_DUE_DATE=to_date('"+checkdate+"','yyyy-MM-dd') where SUBSTR(MRU,7,2)='"+group+"' and SUBSTR(MRU,3,2)='"+division+"'";
 
 
 /* if((checkdate==null) && (cashdate!=null)){
     Query="update cspdcl_input2 set CASH_DUE_DATE=to_date('"+cashdate+"','yyyy-MM-dd') where SUBSTR(MRU,7,2)='"+group+"' and SUBSTR(MRU,3,2)='"+division+"'";
 }if((cashdate==null)&& (checkdate!=null)){
     Query="update cspdcl_input2 set CHEQUE_DUE_DATE=to_date('"+checkdate+"','yyyy-MM-dd') where SUBSTR(MRU,7,2)='"+group+"' and SUBSTR(MRU,3,2)='"+division+"'";
 } if((cashdate!=null) && (checkdate!=null)){
     Query="update cspdcl_input2 set CASH_DUE_DATE=to_date('"+cashdate+"','yyyy-MM-dd'),CHEQUE_DUE_DATE=to_date('"+checkdate+"','yyyy-MM-dd') where SUBSTR(MRU,7,2)='"+group+"' and SUBSTR(MRU,3,2)='"+division+"'";
 } */
 
System.out.println("date store Query= "+Query);
 if((cashdate!=null || !cashdate.equalsIgnoreCase("null")) && (checkdate!=null || !checkdate.equalsIgnoreCase("null")))
 {
try{
DbConnection db=new DbConnection();
con=db.getConnObject2();
DataStroringAutomatically dsa=new DataStroringAutomatically();
updated=dsa.exicuteQuery(Query, con);

}catch(Exception e){
	e.printStackTrace();
}finally{
	try{
		if(con!=null)
		con.close();
	}catch(Exception e){
	
	}
}
 }
if(updated>0)
out.print("<b><font color='green'>"+updated+" records updated</font></b>");
else
	out.print("<b><font color='red'>not updated</font></b>");

%>