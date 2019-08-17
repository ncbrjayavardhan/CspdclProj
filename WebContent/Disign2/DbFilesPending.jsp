<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@page import="com.sqldb.FileListFolder"%>
<%
FileListFolder fileListFolder=new FileListFolder();
List<String> li= fileListFolder.listAllFiles(new File("C:/CSPDCL/db Files"));


for(String path : li){
	out.print(path);
	out.print("<br>");

}

%>