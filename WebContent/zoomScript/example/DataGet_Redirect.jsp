<%@page import="com.database.DataGettingPojo, com.vaibhu.image.ImageGetting,com.database.DbConnection,com.vaibhu.image.ImageResizer,com.database.DataGettingRedirect"%>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
      <%-- base href="<%=basePath%>"> --%>
  
    <title>DataGet_Redirect</title>
  <link rel="stylesheet" type="text/css" href="../../css/UPPCLStyle.css"/>
  
<!-- footer -->
<style type="text/css">
.footer {
   position: fixed;
   left: 0;
   bottom: 0;
   width: 100%;
   height: 50;
   background-color: #0b0b0b;
   color: white;
   text-align: center;
}
h1{

margin-top: 0;
}
</style>
<!-- footer end -->


<!--  style sheet for zooming start-->
 <link rel="stylesheet" href="css/normalize.css" />
    <link rel="stylesheet" href="css/foundation.css" />
    <link rel="stylesheet" href="css/demo.css" />
    <script src="js/vendor/modernizr.js"></script>
    <script src="js/vendor/jquery.js"></script>
  <!-- xzoom plugin here -->
  <script type="text/javascript" src="../dist/xzoom.min.js"></script>
  <link rel="stylesheet" type="text/css" href="css/xzoom.css" media="all" /> 
  <!-- hammer plugin here -->
  <script type="text/javascript" src="hammer.js/1.0.5/jquery.hammer.min.js"></script>  
  
  <link type="text/css" rel="stylesheet" media="all" href="fancybox/source/jquery.fancybox.css" />
  <link type="text/css" rel="stylesheet" media="all" href="magnific-popup/css/magnific-popup.css" />
  <script type="text/javascript" src="fancybox/source/jquery.fancybox.js"></script>
  <script type="text/javascript" src="magnific-popup/js/magnific-popup.js"></script>    
  
<!--  style sheet for zooming end-->

</head>
 
  <body>
 <%@ include file="../../header.html" %>  
  
  
  
 <!--  <div class="MainContainer"> -->
  <div class="navbar">
<ul id="menu bar">
  <li><a href="../../ConsumerSearch.jsp" style="padding-left:10px;padding-right:10px;">Home</a></li>

  <li style="float:right;"><a href="../../logout.jsp">LOGOUT</a></li> 
</ul>
</div>
   
      
   <%String date=null; 
   String roll1="";
   String filepath=null;
 
   ImageGetting ig=new ImageGetting();

   try{
 filepath=getServletContext().getRealPath("");
   }catch(Exception e){
	   System.out.println(e);
   }

   
   %> 
<%--   <% try{ --%>
<!-- <!-- //  roll1=session.getAttribute("roll").toString(); 
 --><!-- // }catch(NullPointerException e){ -->
<%-- 	%> --%>
<!-- 	<h1>Session Expired</h1> -->
<%-- 	<% response.sendRedirect("/SbmtopcUploadDuplicate/SessionExpired.jsp"); --%>
<!-- // }
//%> -->
 <%
 System.out.println("String data");
 
 String scno=( request.getParameter("scno"));
 String bookno=( request.getParameter("bookno"));
 int rowno=Integer.parseInt(request.getParameter("rowno"));
 
 %>
 
 
 
    <center>
   <form action="../../Proceses.jsp" method="post" name="billrevision" name="scnobookno" onsubmit="return validateForm()">
    
   <table border="0" align="center">
   <div align="center"> 
   						
   						<h4>
   						<tr>
   						<td><b style="color:red;font-size: 20px;">BookNo:<input type="text" name='bookno' value='' maxlength="4"></b></td>
   						<td><b style="color: red;font-size: 20px;">Scno:<input type='text' name='scno' value='' maxlength="6" ></b></td>
   						
    					<br><br>
    					 </h4> 
    					 <input type="hidden" name="option" value="billrevision"> 
						<input type="hidden" name="option1" value="BrForNameChange">
						<input type="hidden" name="cardcode" value="CN">
 						<td><b><input type="submit" value="Submit" alt="Submit"  style="    width: 76px;
    height: 25px;
    color: aliceblue;
    font-size: 15px;
    margin-left: 10px;
    background: blue;
    border-radius: 12px;"/></b></td>
 						</tr>
    					 </div></table><br>
    					 <br></form>  </center>
     
  <%
  /* DataGettingPojo d1=(DataGettingPojo)request.getAttribute("cust");
  String scno=d1.getScno();
  String book=d1.getBookno();
  
  String Latitude=d1.getLATITUDE();
  String longitude=d1.getLONGITUDE();
   
  
  String Latitude1="";
  String longitude1="";
  
  if(Latitude!=null)
	  Latitude1=Latitude;
	  if(longitude!=null)
		  longitude1=longitude;
  
  int rowno=Integer.parseInt(d1.getRowno());
  */
//caheck the metred or not
  DbConnection db2=new DbConnection();
  boolean status=db2.status("select * from sbmtopc_android where BILL_BASE!='16' and scno='"+scno+"' and book='"+bookno+"'");
  
  String Rdg_ImgPath=null;
  String Md_ImgPath=null; 
  String Rdg_ImgPath_big=null;
  if(status==true){
	  
	  	ig.FileStoreInBlob(scno, bookno, filepath, "rdg", rowno);
	  	ig.FileStoreInBlob(scno, bookno, filepath, "md", rowno);
	  	Rdg_ImgPath="../../../SbmtopcUploadDuplicate/image.jpg";
	  	Md_ImgPath="../../../SbmtopcUploadDuplicate/MDimage.jpg";
	  	
	  	Rdg_ImgPath_big="../../../SbmtopcUploadDuplicate/image_big.jpg";
	  
  }else{
	  
	  Rdg_ImgPath="images/BlurImg2.JPG";
	  	Md_ImgPath="images/BlurImg2.JPG";
	  	Rdg_ImgPath_big="images/BlurImg2_big.jpg";
  }
  
  
  /* resizer image--start  */
  ImageResizer im=new ImageResizer();
            
   String val_img=  im.resize(filepath+"/image.jpg", filepath+"/image_big.jpg", 1024, 1024); 
  
  /* String val_img=  im.resize(Rdg_ImgPath, Rdg_ImgPath_big, 400, 400); */
  
 
  System.out.println(" image ="+val_img);
  
  System.out.println(" path ="+filepath);
   // im.resize("C:/Users/VIIPL02/Downloads/images/original/BlurImg2.JPG", "C:/Users/VIIPL02/Downloads/images/original/BlurImg2_big.JPG",1024, 786);
  /* resizer image --end */
  
  /*
  byte[] imgData=ig.getPhoto(scno,book,filepath,"rdg", rowno);
  byte[] MDimgData=ig.getPhoto(scno,book,filepath,"md", rowno);
  */
  
  
	


//System.out.println("scno="+scno+"  book=="+book+" file path=="+filepath); "../SbmtopcUploadDuplicate/image.jpg" "../SbmtopcUploadDuplicate/MDimage.jpg"
  
%>
 
 
<%

DataGettingPojo d1=new DataGettingPojo();
DataGettingRedirect dr=new DataGettingRedirect();
d1=dr.Dataget(scno, bookno, rowno);

System.out.println("object name="+d1);
%>
 
 

<b>
<font color="blue" size="4">Reading Image</font><!-- &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -->
 <!-- <font color="blue" size="4">Demand Image</font> --><br></b>
 <%-- <img src=<%=Rdg_ImgPath %> alt="Reading" height="120" width="140"> --%>
 
<!--      <img src="images/BlurImg2.JPG" alt="Reading" height="300px" width="300px">
 -->     
 
 
 <!-- <img src="images/BlurImg2.JPG" alt="Reading" height="300px" width="300px"> -->
  <section id="default" class="padding-top0">
    <div class="row">
      <!-- <div class="large-12 column"><h3>Default options</h3></div> -->
      <div class="large-5 column">
        <div class="xzoom-container">
         <div class="xzoom-container">
<!--        <img class="xzoom" id="xzoom-default" src="images/BlurImg2.JPG"  xoriginal="images/gallery/original/01_b_car.jpg" alt="Reading">
 -->       
            <img class="xzoom" id="xzoom-default" src=<%=Rdg_ImgPath %>  xoriginal=<%=Rdg_ImgPath_big %> alt="Reading">
 
 
 
      </div>        
      </div>
    </div>
    <div class="large-7 column"></div>
    </div>
    </section>
    
    
  <%--   
 
 <div class="xzoom-container">
       <img class="xzoom" id="xzoom-default" src=<%=filepath+"/BlurImg2.JPG" %> xoriginal=<%=filepath+"/BlurImg2.JPG" %> alt="Reading">

 </div>

 
  <img src=<%=Md_ImgPath %> alt="MD" height="120" width="140">
  
   --%>
   
   

 
 <!-- bgcolor="#FFFFCC" border="1" -->
<!-- <center style="    margin-bottom: 20px;"> -->
<table border="2"  align="center" bgcolor="#FFFFCC"  width="65%"  >
   
    
    
   <%--  <tr>
        <td><b>Book No/Scno</b></td>
        <td><b><%=book%>/<%=scno %></b></td>
    </tr> --%>
    <tr>
        <td><b>Book No/Scno</b></td>
        <td><b><%=bookno %>/<%=scno %></b></td>
    </tr>
    
    
     <tr>
        <td><b>Group</b></td>
        <td><b><%=d1.getGr_cd() %></b></td>
    </tr>
    
    <tr>
        <td><b>Billed Units</b></td>
        <td><b><%=d1.getUnit_kwh()%></b></td>
    </tr>
    <tr>
        <td><b>Bill Date/Bill Time</b></td>
        <td><b><%=d1.getBill_dt() %>/<%=d1.getBill_time() %></b></td>
    </tr>  
    
    <tr>
        <td><b>Total Grs</b></td>
        <td><b><%=d1.getTot_grs() %></b></td>
    </tr>                      
    <tr>
        <td><b>Total Net</b></td>
        <td><b><%=d1.getTot_net()%></b></td>
    </tr>
    
    <tr>
        <td><b>Close Reading</b></td>
        <td><b><%=d1.getPrstreading()%></b></td>
    </tr>
         <tr>
        <td><b>Opening Reading</b></td>
        <td><b><%=d1.getOpreading() %></b></td>
    </tr>   
    
     <%-- <tr>
        <td><b>Latitude/Longitude</b></td>
        <td><b>  <%=Latitude1 %> / <%=longitude1 %></b></td>
    </tr>  --%>
    
     <tr>
        <td><b>Sanction Load/Max Demand</b></td>
        <td><b><%=d1.getSload() %> / <%=d1.getCurload() %></b></td>
    </tr>              
</table> 

<!-- </center> -->
<!-- <div class="footer">
<ul id="footerLinks"><br>
 <li><p>&copy Copyright 2016 @ Vaibhu Infratech India Pvt Ltd</p><li>
 <li><img src="images/logon3.jpg" alt="logon"></li>
</div> -->
    <!-- </div>   --> 
    
   <script src="js/foundation.min.js"></script>
    <script src="js/setup.js"></script> 
    
</body>
</html>
    
    
    
    
  