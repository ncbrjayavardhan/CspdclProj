<%@page import="com.database.DbConnection"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.database.DataBaseOperations"%>
<%@page import="com.database.DataOutputPojo"%>
<%@page import="com.database.OutputSingleRecordGettion"%>
<%@page import="com.vaibhu.image.audit.ImageAuditList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.vaibhu.image.audit.FolderPdfToImagesStored"%>
<%@page import="java.io.File"%>
<%@page import="com.vaibhu.image.audit.CopyFIle2"%>
<%
System.out.println("i am in ImageAuditChecking");

/* String source=request.getParameter("source");
String out2=request.getParameter("out"); */
//System.out.println("out2= "+out2); 
int loop=Integer.parseInt(request.getParameter("loop"));
int event=Integer.parseInt(request.getParameter("event"));

System.out.println("event= "+event);
System.out.println("loop= "+loop);
 String filepath=getServletContext().getRealPath("");
 ImageAuditList ff=new ImageAuditList();
  List li=new ArrayList();
  
  
  
  
 /*delete files from folder start  */
 FolderPdfToImagesStored pdi=new FolderPdfToImagesStored();
 //pdi.DeleteFilesForFolder2(new File(filepath+"\\images"));
 
 //System.out.println("filepath= "+filepath+"\\images"); 
 /*delete files from folder end  */
 
 //li=ff.listFilesForFolder2(new File(source),filepath+"/images/");
 // li=ff.listFilesForFolder(new File(source),filepath+"/images/");
 
  li=ff.ImagePathsList((String)session.getAttribute("username"));
	// System.out.println("li= "+li); 
	
	
	 String value_old=li.get(loop).toString();
     loop++;
	
     System.out.println("loop= "+loop);
     System.out.println("li size= "+li.size());
	if(li.size()<loop || li.size()==loop){
		
	
		
		System.out.println("i am in loop");
		
		
		
		 String name_old=new File(value_old).getName();
		  
//String Query="UPDATE CSPDCL_OUTPUT SET CHEKING_STATUS = '"+event+"'  where  IMAGE_PATH='"+value_old+"' and  BP_NUMBER='"+new File(value_old).getName().substring(0, name.lastIndexOf("."))+"'";
  String Query="UPDATE CSPDCL_OUTPUT SET CHEKING_STATUS = '"+event+"'  where  IMAGE_PATH='"+value_old+"' and  BP_NUMBER='"+name_old.substring(0, name_old.lastIndexOf(".")).substring(0, name_old.lastIndexOf("_"))+"'";

	  System.out.println("Query= "+Query);
	 DataBaseOperations dbo=new DataBaseOperations();
	 DbConnection db=new DbConnection();
	 Connection con=null;
	 int nn= 0;
	 try{
	  con=db.getConnObject2();
	  nn= dbo.exicuteQuery(Query, con);
	 }catch(Exception ee){
		 
	 }finally{
		 try{
			 if(con!=null)
				 con.close();
		 }catch(Exception eee){
			 
		 }
	 }
	
	System.out.println("nn= "+nn);
	
	if(nn>0)
		 out.print("<h3> Value Updated</h3>");
		
		
		
		
		
		
		
		out.print("<h2>Completed</h2>");
		
		
	}else{
		System.out.println("i am in loop end");

	 String value=li.get(loop).toString();
	 String name=new File(value).getName();
	 
	 //System.out.println(filepath+"/images/");
	 
	/*  image  creatio start*/
	/* 
	ConvertPDFPagesToImages cpt=new ConvertPDFPagesToImages();
	cpt.convertPdftoImage(value, filepath+"/images/");
	Thread.sleep(10); */
	
	
	     CopyFIle2 cp=new CopyFIle2();
	   /* cp.CopyFIle22(value,path+"/"+change_name+".pdf"); */
	  	 /* cp.CopyFIle22(value,"C:/Users/VIIPL02/Desktop/1/"+change_name+".pdf"); */
	  	 cp.CopyFIle_NonameChange(value,filepath+"/Disign2/images/"+name);
	  	 
		/*  image  creatio end*/
	 
	//System.out.println("value="+value);
	 //System.out.println("File Name="+new File(value).getName());
	 
	 String bp_number=null;
	  if (name.indexOf(".") > 0)
		  bp_number = name.substring(0, name.lastIndexOf(".")); 
	  
	  if (name.indexOf(".") > 0)
		  bp_number = bp_number.substring(0, bp_number.lastIndexOf("_")); 
	  
	  OutputSingleRecordGettion osr=new OutputSingleRecordGettion();
	  DataOutputPojo op=osr.singlerecord(bp_number);
	  
	  
	  
		 String name_old=new File(value_old).getName();
  
 //String Query="UPDATE CSPDCL_OUTPUT SET CHEKING_STATUS = '"+event+"'  where  IMAGE_PATH='"+value_old+"' and  BP_NUMBER='"+new File(value_old).getName().substring(0, name.lastIndexOf("."))+"'";
   String Query="UPDATE CSPDCL_OUTPUT SET CHEKING_STATUS = '"+event+"'  where  IMAGE_PATH='"+value_old+"' and  BP_NUMBER='"+name_old.substring(0, name_old.lastIndexOf(".")).substring(0, name_old.lastIndexOf("_"))+"'";

	  System.out.println("Query= "+Query);
	 DataBaseOperations dbo=new DataBaseOperations();
	 DbConnection db=new DbConnection();
	 Connection con=null;
	 int nn= 0;
	 try{
	  con=db.getConnObject2();
	  nn= dbo.exicuteQuery(Query, con);
	 }catch(Exception ee){
		 
	 }finally{
		 try{
			 if(con!=null)
				 con.close();
		 }catch(Exception eee){
			 
		 }
	 }
	
	System.out.println("nn= "+nn);
	
	if(nn>0)
		 out.print("<h3> Value Updated</h3>");
	
	

	 /* out.print("<input type='hidden' name='out' value='"+out2+"' id='out'/>"); */
	 out.print("<input type='hidden' name='loop' value="+(loop)+" id='loop'/>");
	/*  out.print("<input type='hidden' name='source' value='"+source+"' id='source'/>"); */
	 /* out.print("<input type='hidden' name='type' value='"+source+"' id='type'/>"); */

	 out.print("<input type='hidden' name='file' value='"+new File(value).getName()+"' id='file'/>");
	 //out.print("<embed src='images/"+name+".pdf' height='1200' width='800'/> <br><br><br>");
	out.print("<center>");
	 out.print("<img src='images/"+name+"' height='250' width='300' >");  
	 out.print("<br>");
	 out.print("<table border='2'>");
	 out.print("<tr>");
	 out.print("<td>BP NUMBER</td>");
	 out.print("<td>MRU</td>");
	 out.print("<td>CLOSE READING</td>");                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
	 out.print("<td>BILLED UNIT</td>");
	 out.print("<td>TOTAL DUE</td>");
	 out.print("</tr>");
	 
	 out.print("<tr>");
	 out.print("<td>"+op.getBP_NUMBER()+"</td>");
	 out.print("<td>"+op.getMRU()+"</td>");
	 out.print("<td>"+op.getPRES_READ_KWH()+"</td>");
	 out.print("<td>"+op.getUNIT_BILLED()+"</td>");
	 out.print("<td>"+op.getTOTAL_BILL()+"</td>");

	 out.print("</tr>");
	 out.print("</table>");
	 out.print("</center>");
	 /*  out.print("<img src='images/image.png' height='1000' width='1000' ><br>"); */
	/*  out.print(" Present file:- "+new File(value).getName());
	 out.print("<br>"); */
/* 	 out.print("<h2>Type :<input type='text' name='type' id='type' required='required' onkeypress='sendInfo(event)'/></h2>"); 
 */
	 
	 try{
	
}catch(Exception e){
	
}
 
	}
	
	 //System.out.println("out2= "+out2);  
	 System.out.println("loading completed");
%>