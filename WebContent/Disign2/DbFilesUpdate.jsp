<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@page import="com.sqldb.FileListFolder"%>
<%

System.out.println("i am in db files updatde");
FileListFolder fileListFolder=new FileListFolder();
List<String> li= fileListFolder.listAllFiles(new File("C:/CSPDCL/db Files Updated"));

List<String> li_pending= fileListFolder.listAllFiles(new File("C:/CSPDCL/db Files"));

List<String> li_error= fileListFolder.listAllFiles(new File("C:/CSPDCL/db Files error"));

out.print("Updated Files");
out.print("<br>");

out.print("-------------");
out.print("<br>");


for(String path : li){
	out.print(path);
	out.print("<br>");

}

out.print("<br>");
out.print("<br>");
out.print("<br>");

out.print("pending Files");
out.print("<br>");

out.print("-------------");
out.print("<br>");
out.print("<br>");


for(String path : li_pending){
	out.print(path);
	out.print("<br>");

}

out.print("<br>");
out.print("<br>");
out.print("<br>");

out.print("error Files");

out.print("-------------");
out.print("<br>");
out.print("<br>");

for(String path : li_error){
	out.print(path);
	out.print("<br>");

}

%>