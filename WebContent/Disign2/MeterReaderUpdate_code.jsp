<%@page import="com.database.UserRegistrationDb"%>
<%@page import="com.pojo.UserRegistration"%>
<%
System.out.println("i am in  meter Reader updation");

/* String mrname=request.getParameter("mrname");

 */

/* System.out.println("mrname= "+mrname); */

UserRegistration ur=new UserRegistration();
ur.setMrname(request.getParameter("mrname"));
ur.setAddress(request.getParameter("address"));
ur.setUserid(request.getParameter("userid"));
ur.setEmail(request.getParameter("email"));
ur.setDesigantion(request.getParameter("desigantion"));
ur.setImei2(request.getParameter("imei2"));
ur.setGroups(request.getParameter("groups"));
ur.setFname(request.getParameter("fname"));
ur.setProof(request.getParameter("proof"));
ur.setPassword(request.getParameter("password"));
ur.setMobile(request.getParameter("mobile"));
ur.setImei1(request.getParameter("imei1"));
ur.setSuperid(request.getParameter("superid"));
ur.setDccode(request.getParameter("division"));

System.out.println("mrname= "+ur.getMrname());

UserRegistrationDb urb=new UserRegistrationDb();

if(urb.MeterReaderUpdate2(ur)==true){
	
	System.out.println("stored success");
	out.print("<b><font color='green'>stored success</font></b>");
}else{
	System.out.println("not stored");
	out.print("<b><font color='red'>not stored</font></b>");
}


%>