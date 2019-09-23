<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>

<%-- <base href="${pageContext.request.contextPath}"> --%>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Dashboard - MyProfile</title>
    
	<!-- Bootstrap Core CSS -->
    <link href="./Dashboard - MyProfile_files/bootstrap.min.css" rel="stylesheet">
    <!-- animation CSS -->
    <link href="./Dashboard - MyProfile_files/animate.css" rel="stylesheet">
    <!-- Menu CSS -->
    <link href="./Dashboard - MyProfile_files/sidebar-nav.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="./Dashboard - MyProfile_files/style.css" rel="stylesheet">
	<link href="./Dashboard - MyProfile_files/cartstyle.css" rel="stylesheet">
    <!-- color CSS -->
    <link href="./Dashboard - MyProfile_files/blue.css" id="theme" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
    <script async="" src="./Dashboard - MyProfile_files/analytics.js.download"></script><script>
        (function (i, s, o, g, r, a, m) {
            i['GoogleAnalyticsObject'] = r;
            i[r] = i[r] || function () {
                (i[r].q = i[r].q || []).push(arguments)
            }, i[r].l = 1 * new Date();
            a = s.createElement(o), m = s.getElementsByTagName(o)[0];
            a.async = 1;
            a.src = g;
            m.parentNode.insertBefore(a, m)
        })(window, document, 'script', 'https://www.google-analytics.com/analytics.js', 'ga');
        ga('create', 'UA-19175540-9', 'auto');
        ga('send', 'pageview');
    </script>
	<style>
		.navbar-top-links {
			margin-right: 20px;
			margin-top: 20px;
		}
		ul.smedia {
			list-style-type: none;
			display: block;
			padding: 0px;
		}
		ul.smedia li {
			display: inline-block;
			margin-right: 10px;
		}
		#mysup {
			top: -15px
		}
		#mysup .label {
			letter-spacing: 0.05em;
			border-radius: 60px;
			padding: 4px 8px 3px;
			font-weight: bold;
		}
		#mysup .label-success {
			background-color: #004274;
		}
		.form-material .form-control {
			background-image: linear-gradient(#9675ce, #9675ce), linear-gradient(rgba(120, 130, 140, 1), rgba(120, 130, 140, 1));
		}
		.product-img{text-align:center;position:relative}.product-img img{max-width:200px}.product-img .pro-img-overlay{position:absolute;width:100%;height:100%;top:0;left:0;display:none;background:rgba(255,255,255,.8)}.product-img .pro-img-overlay a{box-shadow:0 0 10px rgba(0,0,0,.1);height:40px;width:40px;display:inline-block;border-radius:100%;-webkit-border-radius:100%;-o-border-radius:100%;text-align:center;padding:0px 0;color:#fff;margin:30% 5px}.product-img .pro-img-overlay a:hover{background:#4c5667!important}.product-img:hover .pro-img-overlay{display:block}
		
		
		
		
	</style>
	
	<script>  
var request;  
function sendInfo()  
{  

var discome=document.datatable.discome.value;  
var division=document.datatable.division.value;  
var circle=document.datatable.circle.value;  
var subdivision=document.datatable.subdivision.value;  
var url="Billing Data Date Update_code.jsp?discome="+discome+"&division="+division+"&circle="+circle+"&subdivision="+subdivision;  
  
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
document.getElementById('tabledisplay').innerHTML=val;  
}  
}  
  
</script>  
	
	
</head>

<body>


<!-- sai java code--start -->


    <!-- Preloader -->
    <div class="preloader" style="display: none;">
        <div class="cssload-speeding-wheel"></div>
    </div>
    <div id="wrapper">
        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top m-b-0">
            <div class="navbar-header"> <a class="navbar-toggle hidden-sm hidden-md hidden-lg " href="javascript:void(0)" data-toggle="collapse" data-target=".navbar-collapse"><i class="ti-menu"></i></a>
                <div class="top-left-part"></div>
                <ul class="nav navbar-top-links navbar-left hidden-xs">
                    <li><a class="logo" href="file:///C:/Users/VIIPL02/Downloads/18-4-18/dashboard/index.html"><b><img src="./Dashboard - MyProfile_files/vaibhu background.jpg" alt="home" style="width: 96px;margin-left: 600px;"></b></a></li>
                    
                </ul>
                <ul class="nav navbar-top-links navbar-right pull-right">
                    <li class="dropdown"> <a class="dropdown-toggle waves-effect waves-light" data-toggle="dropdown" href="file:///C:/Users/VIIPL02/Downloads/18-4-18/dashboard/myprofile.html#"><i class="icon-envelope"></i>
                    <div class="notify"><span class="heartbit"></span><span class="point"></span></div>
                    </a>
                        <ul class="dropdown-menu mailbox animated bounceInDown">
                            <li>
                                <div class="drop-title">You have 4 new messages</div>
                            </li>
                            <li>
                                <div class="message-center">
                                    <a href="file:///C:/Users/VIIPL02/Downloads/18-4-18/dashboard/inbox.html">
                                        <div class="user-img"> <img src="./Dashboard - MyProfile_files/pawandeep.jpg" alt="user" class="img-circle"> <span class="profile-status online pull-right"></span> </div>
                                        <div class="mail-contnet">
                                            <h5>Pavan kumar</h5> <span class="mail-desc">Just see the my admin!</span> <span class="time">9:30 AM</span> </div>
                                    </a>
                                    <a href="file:///C:/Users/VIIPL02/Downloads/18-4-18/dashboard/inbox.html">
                                        <div class="user-img"> <img src="./Dashboard - MyProfile_files/sonu.jpg" alt="user" class="img-circle"> <span class="profile-status busy pull-right"></span> </div>
                                        <div class="mail-contnet">
                                            <h5>Sonu Nigam</h5> <span class="mail-desc">I've sung a song! See you at</span> <span class="time">9:10 AM</span> </div>
                                    </a>
                                    <a href="file:///C:/Users/VIIPL02/Downloads/18-4-18/dashboard/inbox.html">
                                        <div class="user-img"> <img src="./Dashboard - MyProfile_files/arijit.jpg" alt="user" class="img-circle"> <span class="profile-status away pull-right"></span> </div>
                                        <div class="mail-contnet">
                                            <h5>Arijit Sinh</h5> <span class="mail-desc">I am a singer!</span> <span class="time">9:08 AM</span> </div>
                                    </a>
                                    <a href="file:///C:/Users/VIIPL02/Downloads/18-4-18/dashboard/inbox.html">
                                        <div class="user-img"> <img src="./Dashboard - MyProfile_files/pawandeep.jpg" alt="user" class="img-circle"> <span class="profile-status offline pull-right"></span> </div>
                                        <div class="mail-contnet">
                                            <h5>Pavan kumar</h5> <span class="mail-desc">Just see the my admin!</span> <span class="time">9:02 AM</span> </div>
                                    </a>
                                </div>
                            </li>
                            <li>
                                <a class="text-center" href="file:///C:/Users/VIIPL02/Downloads/18-4-18/dashboard/inbox.html"> <strong>See all notifications</strong> <i class="fa fa-angle-right"></i> </a>
                            </li>
                        </ul>
                        <!-- /.dropdown-messages -->
                    </li>
                    <!-- /.dropdown -->
					<li class="dropdown in"> <a class="dropdown-toggle waves-effect waves-light" data-toggle="dropdown" href="file:///C:/Users/VIIPL02/Downloads/18-4-18/dashboard/myprofile.html#"><i class="ti-shopping-cart"></i>
              <div class="notify"><span class="heartbit"></span><span class="point"></span></div>
            </a>
                        
                        <ul class="dropdown-menu dropdown-cart dropdown-tasks animated slideInUp">
                            <a href="file:///C:/Users/VIIPL02/Downloads/18-4-18/dashboard/myprofile.html#">
							<li>
                                <div class="cart-img"><img src="./Dashboard - MyProfile_files/booksimg1.jpg"></div>
                                <div class="cart-content">
                                    <h5>Package Name1</h5><small>$153</small></div>
                            </li>
							</a>
                            <li class="divider"></li>
							<a href="file:///C:/Users/VIIPL02/Downloads/18-4-18/dashboard/myprofile.html#">
                            <li>
                                <div class="cart-img"><img src="./Dashboard - MyProfile_files/booksimg1.jpg"></div>
                                <div class="cart-content">
                                    <h5>Package Name2</h5><small>$153</small></div>
                            </li>
							</a>
                            <li class="divider"></li>
                            <a href="file:///C:/Users/VIIPL02/Downloads/18-4-18/dashboard/myprofile.html" class="active">
							<li>
                                <div class="cart-img"><img src="./Dashboard - MyProfile_files/booksimg1.jpg"></div>
                                <div class="cart-content">
                                    <h5>Package Name3</h5><small>$153</small></div>
                            </li>
							</a>
                            <li class="divider"></li>
                            <li>
                                <a class="text-center" href="file:///C:/Users/VIIPL02/Downloads/18-4-18/dashboard/checkoutpage.html"> <strong>Checkout</strong> <i class="fa fa-angle-right"></i> </a>
                            </li>
                        </ul>
                        <!-- /.dropdown-tasks -->
                    </li>
                    
                    <li class="dropdown">
                        <a class="dropdown-toggle profile-pic" data-toggle="dropdown" href="file:///C:/Users/VIIPL02/Downloads/18-4-18/dashboard/myprofile.html#"> <i class="ti-settings"></i></a>
                        <ul class="dropdown-menu dropdown-user animated flipInY">                            
                            <li><a href="file:///C:/Users/VIIPL02/Downloads/18-4-18/dashboard/login.html"><i class="fa fa-power-off"></i>  Logout</a></li>
                        </ul>
                        <!-- /.dropdown-user -->
                    </li>
                   
                </ul>
            </div>
            <!-- /.navbar-header -->
            <!-- /.navbar-top-links -->
            <!-- /.navbar-static-side -->
        </nav>
       <!-- Left navbar-header -->
        <div class="navbar-default sidebar" role="navigation">
            <div class="slimScrollDiv" style="position: relative; overflow: hidden; width: auto; height: 100%;"><div class="sidebar-nav navbar-collapse slimscrollsidebar" style="overflow: hidden; width: auto; height: 100%;">
			
                <ul class="nav in" id="side-menu">
                
                
                   <li> <a href="javascript:void(0);" class="waves-effect"><i class="fa fa-bars p-r-10"></i> <span class="hide-menu"> Billing <span class="fa arrow"></span></span></a>
                        <ul class="nav nav-second-level collapse">
                        
                             <form name="submitForm" method="POST" action="/VaibhuManagementSystem/EditProfileServlet">
                              <input type="hidden" name="page" value="ProfileViewing.jsp">
                            <li> <a href="javascript:document.submitForm.submit();"><i class="fa fa-print p-r-10"></i>Dash Board</a></li>
                           </form>
                           
                           <form name="submitForm2" method="POST" action="/VaibhuManagementSystem/EditProfileServlet">
                           <input type="hidden" name="page" value="EditProfile.jsp">
                            <li> <a href="javascript:document.submitForm2.submit();"><i class="fa fa-laptop p-r-10"></i>Edit Profile</a></li>
                            </form>
                        </ul>
                    </li>
                     
                        <!-- <ul class="nav nav-second-level collapse">
                            <li> <a href="file:///C:/Users/VIIPL02/Downloads/18-4-18/dashboard/instructions.html"><i class="fa fa-building-o p-r-10"></i>Under Graduate</a> </li>
                            <li> <a href="file:///C:/Users/VIIPL02/Downloads/18-4-18/dashboard/instructions.html"><i class="fa fa-building p-r-10"></i>Post Graduate</a> </li>
                            <li> <a href="file:///C:/Users/VIIPL02/Downloads/18-4-18/dashboard/instructions.html"><i class="fa fa-users p-r-10"></i>MBA</a> </li>
                            <li> <a href="file:///C:/Users/VIIPL02/Downloads/18-4-18/dashboard/instructions.html"><i class="fa fa-euro p-r-10"></i>German Language</a> </li>
                        </ul>
                    </li>
                    <li> <a href="file:///C:/Users/VIIPL02/Downloads/18-4-18/dashboard/insurance.html" class="waves-effect"><i class="fa fa-plus p-r-10"></i> <span class="hide-menu"> Insurence </span></a></li>
					<li> <a href="file:///C:/Users/VIIPL02/Downloads/18-4-18/dashboard/bankaccount.html" class="waves-effect"><i class="fa fa-bank p-r-10"></i> <span class="hide-menu"> Bank Account </span></a></li>
					
                    <li><a href="file:///C:/Users/VIIPL02/Downloads/18-4-18/dashboard/instructions.html" class="waves-effect"><i class="fa fa-edit p-r-10"></i> <span class="hide-menu">Job Application</span></a></li> -->
					
					
					<li> <a href="javascript:void(0);" class="waves-effect"><i class="fa fa-bars p-r-10"></i> <span class="hide-menu"> Employee Management <span class="fa arrow"></span></span></a>
                        <ul class="nav nav-second-level collapse">
                        
                        <!-- my code start -->
                        
                        
                            <li> 
                            <form name="submitForm3" method="POST" action="/VaibhuManagementSystem/EditProfileServlet">
                            <input type="hidden" name="page" value="EmployeeList.jsp">
                            <a href="javascript:document.submitForm3.submit()"><i class="fa fa-print p-r-10"></i>Employees List</a>
                             </form>
                            </li>
                         
                          
                           <!-- my code end -->
                           
                            <li>
                            <form name="submitForm4" method="POST" action="/VaibhuManagementSystem/EditProfileServlet">
                            <input type="hidden" name="page" value="AddingNewEmployee.jsp">
                             <a href="javascript:document.submitForm4.submit()" ><i class="fa fa-laptop p-r-10"></i>Adding New Employee</a>
                             </form>
                             </li>
                      
                        </ul>
                    </li>
                    
                    <li> <a href="javascript:void(0);" class="waves-effect"><i class="fa fa-bars p-r-10"></i> <span class="hide-menu"> Assert Management <span class="fa arrow"></span></span></a>
                        <ul class="nav nav-second-level collapse">
                            <li> 
                             <form name="submitForm5" method="POST" action="/VaibhuManagementSystem/EditProfileServlet">
                            <input type="hidden" name="page" value="AssertEntry.jsp">
                            <a href="javascript:document.submitForm5.submit()"><i class="fa fa-print p-r-10"></i>Fixed Asserts</a>
                            </form>
                            </li>
                            
                            <li> 
                             <form name="submitForm6" method="POST" action="/VaibhuManagementSystem/EditProfileServlet">
                            <input type="hidden" name="page" value="Stock.jsp">
                            <a href="javascript:document.submitForm6.submit()"><i class="fa fa-laptop p-r-10"></i>Stock</a>
                            </form>
                            </li>
                        </ul>
                    </li>
                    
                    
                     <li> <a href="javascript:void(0);" class="waves-effect"><i class="fa fa-bars p-r-10"></i> <span class="hide-menu"> Accounts Management <span class="fa arrow"></span></span></a>
                        <ul class="nav nav-second-level collapse">
                            <li> 
                            <form name="submitForm7" method="POST" action="/VaibhuManagementSystem/EditProfileServlet">
                            <input type="hidden" name="page" value="AdvanceEntry.jsp">
                            <a href="javascript:document.submitForm7.submit()"><i class="fa fa-print p-r-10"></i>Advance Entry</a>
                            </form>
                            </li>
                            
                            <li> 
                            <form name="submitForm8" method="POST" action="/VaibhuManagementSystem/EditProfileServlet">
                            <input type="hidden" name="page" value="Salary_Information.jsp">
                            <a href="javascript:document.submitForm8.submit()"><i class="fa fa-laptop p-r-10"></i>Monthly salary Entry</a>
                            </form>
                            </li>
                            <li> 
                             <form name="submitForm9" method="POST" action="/VaibhuManagementSystem/EditProfileServlet">
                            <input type="hidden" name="page" value="ExpensiveEntry.jsp">
                            <a href="javascript:document.submitForm9.submit()"><i class="fa fa-laptop p-r-10"></i>Expensives Entry</a>
                           </form>
                            </li>
                                <li> <a href="file:///C:/Users/VIIPL02/Downloads/18-4-18/dashboard/websitedesigning.html"><i class="fa fa-laptop p-r-10"></i>Reports</a></li>                   
                        </ul>
                    </li>
                    
                    <li> <a href="javascript:void(0);" class="waves-effect"><i class="fa fa-bars p-r-10"></i> <span class="hide-menu"> Billing Performencess <span class="fa arrow"></span></span></a>
                        <ul class="nav nav-second-level collapse">
                            <li> <a href="DailyBillingEntry.jsp"><i class="fa fa-print p-r-10"></i>Daily Billing Entry</a></li>
                            <li> <a href="file:///C:/Users/VIIPL02/Downloads/18-4-18/dashboard/websitedesigning.html"><i class="fa fa-laptop p-r-10"></i>Billing performence</a></li>
                            <li> <a href="file:///C:/Users/VIIPL02/Downloads/18-4-18/dashboard/websitedesigning.html"><i class="fa fa-laptop p-r-10"></i>Billing reports</a></li>
                                                   
                        </ul>
                    </li>
                    
					<li><a href="file:///C:/Users/VIIPL02/Downloads/18-4-18/dashboard/applicationstatus.html" class="waves-effect"><i class="fa fa-bar-chart-o p-r-10"></i> <span class="hide-menu">Application Status</span></a></li>
					
                </ul>
                
            </div><div class="slimScrollBar" style="background: rgb(220, 220, 220); width: 5px; position: absolute; top: 0px; opacity: 0.4; display: none; border-radius: 7px; z-index: 99; right: 1px; height: 790px;"></div><div class="slimScrollRail" style="width: 5px; height: 100%; position: absolute; top: 0px; display: none; border-radius: 7px; background: rgb(51, 51, 51); opacity: 0.2; z-index: 90; right: 1px;"></div></div>
        </div>
        <!-- Left navbar-header end -->
        <!-- Page Content -->
        <div id="page-wrapper" style="min-height: 523px;">
            <div class="container-fluid">
                <br>
                
                
             
                <div class="white-box"> 
					
                    <ul class="nav customtab nav-tabs" role="tablist">
						<li role="presentation" class="active"><a href="file:///C:/Users/VIIPL02/Downloads/18-4-18/dashboard/myprofile.html#personaldata" aria-controls="personaldata" role="tab" data-toggle="tab" aria-expanded="true"><span class=""><i class="ti-user"></i></span><span class=""> Data updation</span></a></li>
						
<!-- 						 <li role="presentation" class=""><a href="file:///C:/Users/VIIPL02/Downloads/18-4-18/dashboard/myprofile.html#contactdata" aria-controls="contactdata" role="tab" data-toggle="tab" aria-expanded="false"><span class=""><i class="ti-location-pin"></i></span> <span class="">Employee Automatic Adding</span></a></li>
 -->						
						<!--<li role="presentation"><a href="file:///C:/Users/VIIPL02/Downloads/18-4-18/dashboard/myprofile.html#legitimationdata" aria-controls="legitimationdata" role="tab" data-toggle="tab" aria-expanded="false"><span class=""><i class="ti-files"></i></span> <span class="">Legitimation Data</span></a></li>
						
						<li role="presentation" class=""><a href="file:///C:/Users/VIIPL02/Downloads/18-4-18/dashboard/myprofile.html#addressdata" aria-controls="addressdata" role="tab" data-toggle="tab" aria-expanded="false"><span class=""><i class="ti-map-alt"></i></span> <span class="">Address Data</span></a></li> -->
				
					</ul>
					<!-- Tab panes -->
					<div class="tab-content">
 						<div role="tabpanel" class="tab-pane fade active in" id="personaldata">	
 							
 							<form name="datatable">
  						<div class="col-md-6">
 						<div class="form-group">
                                        <label class="col-sm-12" for="cob">Discome</label>
                                        <div class="col-sm-12">
                                            <select class="form-control" id="cob" name="discome">
                                                <option>CSPDCL</option>
                                                
                                                
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-12" for="cob">Division</label>
                                        <div class="col-sm-12">
                                            <select class="form-control" id="cob" name="division">
                                                <option>division1</option>
                                                <option>division2</option>
                                                
                                            </select>
                                        </div>
                                    </div>
                                    
                                   <center>           
                        <button type="submit" class="btn btn-info waves-effect waves-light m-r-10" onClick="sendInfo()">View</button>
                              </center>    
                                    
                                    
                            </div>    
                                
                                <div class="col-md-5 pull-right">
                                    <div class="form-group">
                                        <label class="col-sm-12" for="cob">Circle</label>
                                        <div class="col-sm-12">
                                            <select class="form-control" id="cob" name="circle">
                                                <option>Kavardha</option>
                                                <option>kanker</option>
                                                
                                                
                                            </select>
                                        </div>
                                    </div>
                                    
                                    
                                    <div class="form-group">
                                        <label class="col-sm-12" for="cob">Sub Division</label>
                                        <div class="col-sm-12">
                                            <select class="form-control" id="cob" name="subdivision">
                                                <option>sub-division1</option>
                                                <option>sub-division2</option>
                                                <!-- <option>USA</option>
                                                <option>Australia</option>
                                                <option>Malaysia</option> -->
                                                
                                            </select>
                                        </div>
                                    </div>
                        <center>           
                        <button type="submit" class="btn btn-info waves-effect waves-light m-r-10">Save</button>
                        </center>  
                                    </div>
                          </form>
                          
                          
							</div>
							<div class="clearfix"></div>
							
							<!-- caontact data start -->
								
						
						
							<!-- caontact data end -->
							
							
							
						 </div> 
					</div> 
					
					<span id="tabledisplay"> </span>  
					
					 <div class="white-box">
					 <h1>table data display</h1>	 		 
					 </div>
					
                </div>
					
            </div>
        </div>
                <!-- /.container-fluid -->
                <footer class="footer text-center"> 2018 @ vaibhu infratech idia pvt Ltd</footer>
    </div>
            <!-- /#page-wrapper -->
        <!-- /#wrapper -->
        <!-- jQuery -->
        <!-- jQuery -->
    <script src="./Dashboard - MyProfile_files/jquery.min.js.download"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="./Dashboard - MyProfile_files/bootstrap.min.js.download"></script>
    <!-- Menu Plugin JavaScript -->
    <script src="./Dashboard - MyProfile_files/sidebar-nav.min.js.download"></script>
    <!--slimscroll JavaScript -->
    <script src="./Dashboard - MyProfile_files/jquery.slimscroll.js.download"></script>
    <!--Wave Effects -->
    <script src="./Dashboard - MyProfile_files/waves.js.download"></script>
	<script src="./Dashboard - MyProfile_files/bootstrap-datepicker.min.js.download"></script>
        <script type="text/javascript">
        // Date Picker
        jQuery('.mydatepicker').datepicker();
        </script>
    <!-- Custom Theme JavaScript -->
    <script src="./Dashboard - MyProfile_files/custom.min.js.download"></script>
    <!--Style Switcher -->
<script src="./Dashboard - MyProfile_files/jQuery.style.switcher.js.download"></script>
	<script>
		$("#upfile1").click(function () {
			$("#file1").trigger('click');
		});
	</script>
	
</body></html>