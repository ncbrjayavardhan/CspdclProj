<%
String from=request.getParameter("from");
String to=request.getParameter("to");

System.out.println("from= "+from);
System.out.println("to= "+to);
String filename = "MyFirstExcel.xlsx";   
String filepath = "G:\\";   
response.setContentType("APPLICATION/OCTET-STREAM");   
response.setHeader("Content-Disposition","attachment; filename=\"" + filename + "\"");   

java.io.FileInputStream fileInputStream=new java.io.FileInputStream(filepath + filename);  
          
int i;   
while ((i=fileInputStream.read()) != -1) {  
  out.write(i);   
}   
fileInputStream.close();   
   

%>