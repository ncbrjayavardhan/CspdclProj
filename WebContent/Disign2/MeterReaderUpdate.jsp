<%@page import="com.pojo.UserIdPojo"%>
<%@page import="com.database.UserListGetting"%>
<%@page import="java.util.List"%>
<%@page import="com.database.DivisionsList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>Meter Reader Registration</title>

		<meta name="description" content="overview &amp; stats" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

		<!-- bootstrap & fontawesome -->
		<link rel="stylesheet" href="assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="assets/font-awesome/4.5.0/css/font-awesome.min.css" />

		<!-- page specific plugin styles -->

		<!-- text fonts -->
		<link rel="stylesheet" href="assets/css/fonts.googleapis.com.css" />

		<!-- ace styles -->
		<link rel="stylesheet" href="assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />

		<!--[if lte IE 9]>
			<link rel="stylesheet" href="assets/css/ace-part2.min.css" class="ace-main-stylesheet" />
		<![endif]-->
		<link rel="stylesheet" href="assets/css/ace-skins.min.css" />
		<link rel="stylesheet" href="assets/css/ace-rtl.min.css" />

		<!--[if lte IE 9]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->

		<!-- inline styles related to this page -->

		<!-- ace settings handler -->
		<script src="assets/js/ace-extra.min.js"></script>

		<!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

		<!--[if lte IE 8]>
		<script src="assets/js/html5shiv.min.js"></script>
		<script src="assets/js/respond.min.js"></script>
		<![endif]-->

			<style>
  #progress_bar {
    margin: 10px 0;
    padding: 3px;
    border: 1px solid #000;
    font-size: 14px;
    clear: both;
    opacity: 0;
    -moz-transition: opacity 1s linear;
    -o-transition: opacity 1s linear;
    -webkit-transition: opacity 1s linear;
  }
  #progress_bar.loading {
    opacity: 1.0;
  }
  #progress_bar .percent {
    background-color: #99ccff;
    height: auto;
    width: 0;
  }
</style>




	</head>

	<body class="no-skin" onload="javascript:yesnoCheck();">
		<div id="navbar" class="navbar navbar-default          ace-save-state">
			<div class="navbar-container ace-save-state" id="navbar-container">
				<button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar">
					<span class="sr-only">Toggle sidebar</span>

					<span class="icon-bar"></span>

					<span class="icon-bar"></span>

					<span class="icon-bar"></span>
				</button>

				<div class="navbar-header pull-left">
					<a href="#" class="navbar-brand">
						<small>
							<i class="fa fa-leaf"></i>
							CSPDCL BILLING
						</small>
					</a>
				</div>

				<div class="navbar-buttons navbar-header pull-right" role="navigation">
					<ul class="nav ace-nav">


						<li class="light-blue dropdown-modal">
							<a data-toggle="dropdown" href="#" class="dropdown-toggle">
								<!-- <img class="nav-user-photo" src="assets/images/avatars/user.jpg" alt="Jason's Photo" />
								<span class="user-info">
									<small>Welcome,</small>
									Jason
								</span> -->

								<i class="ace-icon fa fa-caret-down"></i>
							</a>

							<ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
								<li>
									<a href="#">
										<i class="ace-icon fa fa-cog"></i>
										Settings
									</a>
								</li>

								<li>
									<a href="profile.html">
										<i class="ace-icon fa fa-user"></i>
										Profile
									</a>
								</li>

								<li class="divider"></li>

								<li>
									<a href="/CspdclDashBoard">
										<i class="ace-icon fa fa-power-off"></i>
										Logout
									</a>
								</li>
							</ul>
						</li>
					
					
					</ul>
				</div>
			</div><!-- /.navbar-container -->
		</div>

		<div class="main-container ace-save-state" id="main-container">
			<script type="text/javascript">
				try{ace.settings.loadState('main-container')}catch(e){}
			</script>

			<div id="sidebar" class="sidebar                  responsive                    ace-save-state">
				<script type="text/javascript">
					try{ace.settings.loadState('sidebar')}catch(e){}
				</script>

				<div class="sidebar-shortcuts" id="sidebar-shortcuts">
					<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
						<button class="btn btn-success">
							<i class="ace-icon fa fa-signal"></i>
						</button>

						<button class="btn btn-info">
							<i class="ace-icon fa fa-pencil"></i>
						</button>

						<button class="btn btn-warning">
							<i class="ace-icon fa fa-users"></i>
						</button>

						<button class="btn btn-danger">
							<i class="ace-icon fa fa-cogs"></i>
						</button>
					</div>

					<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
						<span class="btn btn-success"></span>

						<span class="btn btn-info"></span>

						<span class="btn btn-warning"></span>

						<span class="btn btn-danger"></span>
					</div>
				</div><!-- /.sidebar-shortcuts -->

				<ul class="nav nav-list">
					<li class="active">
						<a href="DashBoard.jsp">
							<i class="menu-icon fa fa-tachometer"></i>
							<span class="menu-text"> Dashboard </span>
						</a>

						<b class="arrow"></b>
					</li>

				<li class="">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-desktop"></i>
							<span class="menu-text">
								Reports
							</span>

							<b class="arrow fa fa-angle-down"></b>
						</a>

						<b class="arrow"></b>

						<ul class="submenu">
							

							<li class="">
								<a href="#">
									<i class="menu-icon fa fa-caret-right"></i>
									DashBoard
								</a>

								<b class="arrow"></b>
							</li>

							<li class="">
								<a href="DataList.jsp">
									<i class="menu-icon fa fa-caret-right"></i>
									Consumer Search
								</a>

								<b class="arrow"></b>
							</li>
					<%if(!"D".equals(session.getAttribute("AUTH_CODE"))){ %>
							<li class="">
								<a href="DataLoading.jsp">
									<i class="menu-icon fa fa-caret-right"></i>
									Input Data Loading
								</a>

								<b class="arrow"></b>
							</li>
							
							
							
							<li class="">
								<a href="DataOutputUpload.jsp" >
									<i class="menu-icon fa fa-caret-right"></i>
									Data Upload
								</a>

								<b class="arrow"></b>
							</li>
							
							<li class="">
								<a href="TotalUploadedData_show.jsp">
									<i class="menu-icon fa fa-caret-right"></i>
									Uploaded Data Showing
								</a>

								<b class="arrow"></b>
							</li>
							
							<li class="">
								<a href="DepartmentFormat.jsp">
									<i class="menu-icon fa fa-caret-right"></i>
									Department Format
								</a>

								<b class="arrow"></b>
							</li>
							
<li class="">
								<a href="MeterReaderRegistration.jsp">
									<i class="menu-icon fa fa-caret-right"></i>
									Meter Reader Entry
								</a>

								<b class="arrow"></b>
							</li>
							
							<li class="">
								<a href="ImagesAudit.jsp">
									<i class="menu-icon fa fa-caret-right"></i>
									Image Audit
								</a>

								<b class="arrow"></b>
							</li>

                                <li class="">
								<a href="MrList.jsp">
									<i class="menu-icon fa fa-caret-right"></i>
									Meter Readers List
								</a>

								<b class="arrow"></b>
							</li>

							
						</ul>
					</li>
					
				</ul><!-- /.nav-list -->
<%} %>
				<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
					<i id="sidebar-toggle-icon" class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
				</div>
			</div>

			<div class="main-content">
				<div class="main-content-inner">
					<div class="breadcrumbs ace-save-state" id="breadcrumbs">
						<ul class="breadcrumb">
							<li>
								<i class="ace-icon fa fa-home home-icon"></i>
								<a href="#">Home</a>
							</li>
							<li class="active">Dashboard</li>
						</ul><!-- /.breadcrumb -->

						<div class="nav-search" id="nav-search">
							<form class="form-search">
								<span class="input-icon">
									<input type="text" placeholder="Search ..." class="nav-search-input" id="nav-search-input" autocomplete="off" />
									<i class="ace-icon fa fa-search nav-search-icon"></i>
								</span>
							</form>
						</div><!-- /.nav-search -->
					</div>

					<div class="page-content">
						<div class="ace-settings-container" id="ace-settings-container">
							<div class="btn btn-app btn-xs btn-warning ace-settings-btn" id="ace-settings-btn">
								<i class="ace-icon fa fa-cog bigger-130"></i>
							</div>

							<div class="ace-settings-box clearfix" id="ace-settings-box">
								<div class="pull-left width-50">
									<div class="ace-settings-item">
										<div class="pull-left">
											<select id="skin-colorpicker" class="hide">
												<option data-skin="no-skin" value="#438EB9">#438EB9</option>
												<option data-skin="skin-1" value="#222A2D">#222A2D</option>
												<option data-skin="skin-2" value="#C6487E">#C6487E</option>
												<option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
											</select>
										</div>
										<span>&nbsp; Choose Skin</span>
									</div>

									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2 ace-save-state" id="ace-settings-navbar" autocomplete="off" />
										<label class="lbl" for="ace-settings-navbar"> Fixed Navbar</label>
									</div>

									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2 ace-save-state" id="ace-settings-sidebar" autocomplete="off" />
										<label class="lbl" for="ace-settings-sidebar"> Fixed Sidebar</label>
									</div>

									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2 ace-save-state" id="ace-settings-breadcrumbs" autocomplete="off" />
										<label class="lbl" for="ace-settings-breadcrumbs"> Fixed Breadcrumbs</label>
									</div>

									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-rtl" autocomplete="off" />
										<label class="lbl" for="ace-settings-rtl"> Right To Left (rtl)</label>
									</div>

									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2 ace-save-state" id="ace-settings-add-container" autocomplete="off" />
										<label class="lbl" for="ace-settings-add-container">
											Inside
											<b>.container</b>
										</label>
									</div>
								</div><!-- /.pull-left -->

								<div class="pull-left width-50">
									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-hover" autocomplete="off" />
										<label class="lbl" for="ace-settings-hover"> Submenu on Hover</label>
									</div>

									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-compact" autocomplete="off" />
										<label class="lbl" for="ace-settings-compact"> Compact Sidebar</label>
									</div>

									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-highlight" autocomplete="off" />
										<label class="lbl" for="ace-settings-highlight"> Alt. Active Item</label>
									</div>
								</div><!-- /.pull-left -->
							</div><!-- /.ace-settings-box -->
						</div><!-- /.ace-settings-container -->

						<div class="page-header">
							<h1>
								Dashboard
								<small>
									<i class="ace-icon fa fa-angle-double-right"></i>
									overview &amp; stats
								</small>
							</h1>
						</div><!-- /.page-header -->

						
<!------------------------------page Contant start ------------------------------------------- -->					


<%
try{
String userid=(String)session.getAttribute("userid").toString();
		System.out.print("userid= "+userid);									
												
if(userid.equalsIgnoreCase("null") || userid==null){
	response.sendRedirect("/CspdclDashBoard");
	
}
	
}catch(Exception e){
	response.sendRedirect("/CspdclDashBoard");
}
%>

<%
/* session.getAttribute("username");
session.getAttribute("userid"); */

DivisionsList di=new DivisionsList();
List division=di.DivisionListGetting((String)session.getAttribute("username"));

System.out.println("i am in meteter reader update");
System.out.println(request.getParameter("id"));
UserListGetting ul=new UserListGetting();
List li=ul.UserDetailsWithMeter_id(request.getParameter("id"));
UserIdPojo ui=new UserIdPojo();
try{
 ui=(UserIdPojo)li.get(0);
}catch(Exception e){
	e.printStackTrace();
}

String groups=ul.MrGroupsGetting(request.getParameter("id"));
//String groups=ul.MrGroupsGetting("234sdf");



%>



<script>  
var request;  
function sendInfo()  
{  

/* var url="TotalUploadedData.jsp";  */ 
  var mrname=document.dataview.mrname.value;
  var address=document.dataview.address.value;
 var userid=document.dataview.userid.value;
 var email=document.dataview.email.value;
 var desigantion=document.dataview.designation.value;
 var imei2=document.dataview.imei2.value;
 var groups=document.dataview.groups.value;
 var fname=document.dataview.fname.value;
 var proof=document.dataview.proof.value;
 var password=document.dataview.password.value;
 var mobile=document.dataview.mobile.value;
 var imei1=document.dataview.imei1.value;
 var superid=document.dataview.superid.value; 
 var division=document.dataview.division.value;
 /* var url="MeterReaderRegistration_code.jsp?mrname="+mrname; */
 
  var url="MeterReaderUpdate_code.jsp?mrname="+mrname+"&address="+address+"&userid="+userid+"&email="+email+"&desigantion="+desigantion+"&imei2="+imei2+"&groups="+groups+"&fname="+fname+"&proof="+proof+"&password="+password+"&mobile="+mobile+"&imei1="+imei1+"&superid="+superid+"&division="+division;
 
 
if(window.XMLHttpRequest){  
request=new XMLHttpRequest();  
}  
else if(window.ActiveXObject){  
request=new ActiveXObject("Microsoft.XMLHTTP");  
}  
  
try  
{  
request.onreadystatechange=getInfo;  
request.open("GET",url,true);  
request.send();  
}  
catch(e)  
{  
alert("Unable to connect to server");  
}  
}  
  
function getInfo(){  
if(request.readyState==4){  
var val=request.responseText;  
document.getElementById('data2').innerHTML=val;  
}  
}  
  
</script>



							<span id="data2"> </span> 

                              <!-- <form name="dataview" class="form-material form-horizontal" action="/CspdclDashBoard/DataStoring" method="post"> -->
								<form name="dataview" id="dataview" class="form-material form-horizontal" method="post">
								<div class="col-md-6">
                                    <div class="form-group">
                                        <label class="col-md-12" for="title">Meter Reader Name</label>
                                        <div class="col-md-12">
                                            <input type="text" id="mrname" name="mrname" class="form-control" readonly value="<%=ui.getMETER_READER_NAME()%>"placeholder="name">
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <label class="col-md-12" for="surname">Meter Reader Address</label>
                                        <div class="col-md-12">
                                            <input type="text" id="address" name="address" class="form-control" readonly value="<%=ui.getMETER_READER_ADDRESS()%>"placeholder="address">
                                        </div>
                                    </div>
                                    
                                   
                                    
                                    <div class="form-group">
                                        <label class="col-md-12" for="surname">User Id</label>
                                        <div class="col-md-12">
                                            <input type="text" id="userid" name="userid" class="form-control" readonly value="<%=ui.getUSER_NAME()%>"placeholder="user id">
                                        </div>
                                    </div>
                                    
                                    
                                    
                                    
                                    <div class="form-group">
                                        <label class="col-md-12" for="email">Email</label>
                                       <div class="col-md-12">
                                            <input type="email" id="email" name="email" readonly value="<%=ui.getEMAIL() %>" class="form-control" placeholder="sample@gmail.com">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-12" for="cob">Designation</label>
                                        <div class="col-sm-12">
                                            <select class="form-control" id="designation" name="designation">
                                                <option readonly value="0">MR</option>
                                            </select>
                                        </div>
                                    </div>
                                                                    
                                    <div class="form-group">
                                        <label class="col-md-12" for="fname">IMEI 2</label>
                                        <div class="col-md-12">
                                            <input type="text" id="imei2" name="imei2"  value="<%=ui.getIMEI_2() %>" class="form-control" placeholder="imei2">
                                        </div>
                                    </div>  
                                    
                                    <div class="form-group">
                                        <label class="col-md-12" for="fname">GROUPS (write using ,(cama))</label>
                                       <div class="col-md-12">
                                            <input type="text" id="groups" name="groups" value="<%=groups%>" class="form-control" placeholder="groups for mr">
                                        </div>
                                    </div>  
                                                                        
                                    </div>
                                    
								
								
								
								
								
								
								<div class="col-md-5 pull-right">								
                                    <div class="form-group">
                                        <label class="col-md-12" for="fname">Meter Reader Father Name</label>
                                        <div class="col-md-12">
                                            <input type="text" id="fname" name="fname" readonly value="<%=ui.getMETER_READER_FATHER_NAME() %>" class="form-control" placeholder="father name">
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <label class="col-md-12" for="maidenname">Id Proof</label>
                                        <div class="col-md-12">
                                            <input type="file" id="proof" name="proof">
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <label class="col-md-12" for="surname">Password</label>
                                        <div class="col-md-12">
                                            <input type="password" id="password" name="password" class="form-control" readonly value=""placeholder="password">
                                        </div>
                                    </div>
                                    
                                    
                                    <div class="form-group">
                                        <label class="col-md-12" for="pob">Mobile Number</label>
                                        <div class="col-md-12">
                                            <input type="text" id="mobile" name="mobile" readonly value="<%=ui.getMOBILE_NUM() %>" class="form-control" placeholder="mobile no">
                                        </div>
                                    </div>                                    
                                    <div class="form-group">
                                        <label class="col-sm-12" for="mstatus">IMEI 1</label>
                                        <div class="col-md-12">
                                            <input type="text" id="imei1" name="imei1" class="form-control"  value="<%=ui.getIMEI_1()%>"placeholder="imei1">
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <label class="col-md-12" for="passportn">Superviser Id</label>
                                         <select class="form-control" id="superid" name="superid">
                                                <option readonly value="<%=session.getAttribute("userid") %>"><%=session.getAttribute("username") %></option>
                                            </select>
                                    </div>
                                    
                                    
                                    <div class="form-group">
                                        <label class="col-md-12" for="passportn">Division</label>
                                         <select class="form-control" id="division" name="division">
                                             
                                             <%  
                                             for(int i=0;i<division.size();i++){
                                             
                                             %>
                                                <option readonly value="<%=division.get(i) %>"><%=division.get(i) %></option>
                                                <%} %>
                                            
                                            </select>
                                    </div>
                                    
                                    <br> 
                                 <button type="button" class="btn btn-success waves-effect waves-light m-r-10" onclick="sendInfo()">SUBMIT</button>                              
                                     
                                 							
                                                                                                  
								</div>
								</form>
								
<!--                                      <button type="submit" class="btn btn-success waves-effect waves-light m-r-10" onclick="sendInfo()">SUBMIT</button>                              
 --> 										
								<!-- ------------ -->
								
								
								
<!------------------------------page Contant start ------------------------------------------- -->					
						
						
						
						
						
						
						
						
					</div><!-- /.page-content -->
				</div>
			</div><!-- /.main-content -->

			<div class="footer">
				<div class="footer-inner">
					<div class="footer-content">
						<span class="bigger-120">
							<span class="blue bolder">Vaibhu Infratech</span>
							Application &copy; 2018-2019
						</span>

						&nbsp; &nbsp;
						<span class="action-buttons">
							<a href="#">
								<i class="ace-icon fa fa-twitter-square light-blue bigger-150"></i>
							</a>

							<a href="#">
								<i class="ace-icon fa fa-facebook-square text-primary bigger-150"></i>
							</a>

							<a href="#">
								<i class="ace-icon fa fa-rss-square orange bigger-150"></i>
							</a>
						</span>
					</div>
				</div>
			</div>

			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
			</a>
		</div><!-- /.main-container -->

		<!-- basic scripts -->

		<!--[if !IE]> -->
		<script src="assets/js/jquery-2.1.4.min.js"></script>

		<!-- <![endif]-->

		<!--[if IE]>
<script src="assets/js/jquery-1.11.3.min.js"></script>
<![endif]-->
		<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script src="assets/js/bootstrap.min.js"></script>

		<!-- page specific plugin scripts -->

		<!--[if lte IE 8]>
		  <script src="assets/js/excanvas.min.js"></script>
		<![endif]-->
		<script src="assets/js/jquery-ui.custom.min.js"></script>
		<script src="assets/js/jquery.ui.touch-punch.min.js"></script>
		<script src="assets/js/jquery.easypiechart.min.js"></script>
		<script src="assets/js/jquery.sparkline.index.min.js"></script>
		<script src="assets/js/jquery.flot.min.js"></script>
		<script src="assets/js/jquery.flot.pie.min.js"></script>
		<script src="assets/js/jquery.flot.resize.min.js"></script>

		<!-- ace scripts -->
		<script src="assets/js/ace-elements.min.js"></script>
		<script src="assets/js/ace.min.js"></script>

		<!-- inline scripts related to this page -->
		<script type="text/javascript">
			jQuery(function($) {
				$('.easy-pie-chart.percentage').each(function(){
					var $box = $(this).closest('.infobox');
					var barColor = $(this).data('color') || (!$box.hasClass('infobox-dark') ? $box.css('color') : 'rgba(255,255,255,0.95)');
					var trackColor = barColor == 'rgba(255,255,255,0.95)' ? 'rgba(255,255,255,0.25)' : '#E2E2E2';
					var size = parseInt($(this).data('size')) || 50;
					$(this).easyPieChart({
						barColor: barColor,
						trackColor: trackColor,
						scaleColor: false,
						lineCap: 'butt',
						lineWidth: parseInt(size/10),
						animate: ace.vars['old_ie'] ? false : 1000,
						size: size
					});
				})
			
				$('.sparkline').each(function(){
					var $box = $(this).closest('.infobox');
					var barColor = !$box.hasClass('infobox-dark') ? $box.css('color') : '#FFF';
					$(this).sparkline('html',
									 {
										tagValuesAttribute:'data-values',
										type: 'bar',
										barColor: barColor ,
										chartRangeMin:$(this).data('min') || 0
									 });
				});
			
			
			  //flot chart resize plugin, somehow manipulates default browser resize event to optimize it!
			  //but sometimes it brings up errors with normal resize event handlers
			  $.resize.throttleWindow = false;
			
			  var placeholder = $('#piechart-placeholder').css({'width':'90%' , 'min-height':'150px'});
			  var data = [
				{ label: "social networks",  data: 38.7, color: "#68BC31"},
				{ label: "search engines",  data: 24.5, color: "#2091CF"},
				{ label: "ad campaigns",  data: 8.2, color: "#AF4E96"},
				{ label: "direct traffic",  data: 18.6, color: "#DA5430"},
				{ label: "other",  data: 10, color: "#FEE074"}
			  ]
			  function drawPieChart(placeholder, data, position) {
			 	  $.plot(placeholder, data, {
					series: {
						pie: {
							show: true,
							tilt:0.8,
							highlight: {
								opacity: 0.25
							},
							stroke: {
								color: '#fff',
								width: 2
							},
							startAngle: 2
						}
					},
					legend: {
						show: true,
						position: position || "ne", 
						labelBoxBorderColor: null,
						margin:[-30,15]
					}
					,
					grid: {
						hoverable: true,
						clickable: true
					}
				 })
			 }
			 drawPieChart(placeholder, data);
			
			 /**
			 we saved the drawing function and the data to redraw with different position later when switching to RTL mode dynamically
			 so that's not needed actually.
			 */
			 placeholder.data('chart', data);
			 placeholder.data('draw', drawPieChart);
			
			
			  //pie chart tooltip example
			  var $tooltip = $("<div class='tooltip top in'><div class='tooltip-inner'></div></div>").hide().appendTo('body');
			  var previousPoint = null;
			
			  placeholder.on('plothover', function (event, pos, item) {
				if(item) {
					if (previousPoint != item.seriesIndex) {
						previousPoint = item.seriesIndex;
						var tip = item.series['label'] + " : " + item.series['percent']+'%';
						$tooltip.show().children(0).text(tip);
					}
					$tooltip.css({top:pos.pageY + 10, left:pos.pageX + 10});
				} else {
					$tooltip.hide();
					previousPoint = null;
				}
				
			 });
			
				/////////////////////////////////////
				$(document).one('ajaxloadstart.page', function(e) {
					$tooltip.remove();
				});
			
			
			
			
				var d1 = [];
				for (var i = 0; i < Math.PI * 2; i += 0.5) {
					d1.push([i, Math.sin(i)]);
				}
			
				var d2 = [];
				for (var i = 0; i < Math.PI * 2; i += 0.5) {
					d2.push([i, Math.cos(i)]);
				}
			
				var d3 = [];
				for (var i = 0; i < Math.PI * 2; i += 0.2) {
					d3.push([i, Math.tan(i)]);
				}
				
			
				var sales_charts = $('#sales-charts').css({'width':'100%' , 'height':'220px'});
				$.plot("#sales-charts", [
					{ label: "Domains", data: d1 },
					{ label: "Hosting", data: d2 },
					{ label: "Services", data: d3 }
				], {
					hoverable: true,
					shadowSize: 0,
					series: {
						lines: { show: true },
						points: { show: true }
					},
					xaxis: {
						tickLength: 0
					},
					yaxis: {
						ticks: 10,
						min: -2,
						max: 2,
						tickDecimals: 3
					},
					grid: {
						backgroundColor: { colors: [ "#fff", "#fff" ] },
						borderWidth: 1,
						borderColor:'#555'
					}
				});
			
			
				$('#recent-box [data-rel="tooltip"]').tooltip({placement: tooltip_placement});
				function tooltip_placement(context, source) {
					var $source = $(source);
					var $parent = $source.closest('.tab-content')
					var off1 = $parent.offset();
					var w1 = $parent.width();
			
					var off2 = $source.offset();
					//var w2 = $source.width();
			
					if( parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2) ) return 'right';
					return 'left';
				}
			
			
				$('.dialogs,.comments').ace_scroll({
					size: 300
			    });
				
				
				//Android's default browser somehow is confused when tapping on label which will lead to dragging the task
				//so disable dragging when clicking on label
				var agent = navigator.userAgent.toLowerCase();
				if(ace.vars['touch'] && ace.vars['android']) {
				  $('#tasks').on('touchstart', function(e){
					var li = $(e.target).closest('#tasks li');
					if(li.length == 0)return;
					var label = li.find('label.inline').get(0);
					if(label == e.target || $.contains(label, e.target)) e.stopImmediatePropagation() ;
				  });
				}
			
				$('#tasks').sortable({
					opacity:0.8,
					revert:true,
					forceHelperSize:true,
					placeholder: 'draggable-placeholder',
					forcePlaceholderSize:true,
					tolerance:'pointer',
					stop: function( event, ui ) {
						//just for Chrome!!!! so that dropdowns on items don't appear below other items after being moved
						$(ui.item).css('z-index', 'auto');
					}
					}
				);
				$('#tasks').disableSelection();
				$('#tasks input:checkbox').removeAttr('checked').on('click', function(){
					if(this.checked) $(this).closest('li').addClass('selected');
					else $(this).closest('li').removeClass('selected');
				});
			
			
				//show the dropdowns on top or bottom depending on window height and menu position
				$('#task-tab .dropdown-hover').on('mouseenter', function(e) {
					var offset = $(this).offset();
			
					var $w = $(window)
					if (offset.top > $w.scrollTop() + $w.innerHeight() - 100) 
						$(this).addClass('dropup');
					else $(this).removeClass('dropup');
				});
			
			})
		</script>
	</body>
</html>
