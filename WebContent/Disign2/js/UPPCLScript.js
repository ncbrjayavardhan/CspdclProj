$(document).ready(function () {
    $("#btnLogin").click(function(){
		var uname=$("#txtUsername").val().trim();
		var pwd = $("#txtPassword").val().trim();
		if(uname==''|| pwd=='')
		{
			alert("Please Enter Username | Password");
			$("#txtUsername").val('');
			$("#txtPassword").val('');
			return false;
		}
		else if(uname=='devi' && pwd=='devi')
		{
			window.location.href = "submit.html";
		}
		else{
			alert("Please Enter Valid Username | Password");
		}
	});
	$("#btnSendmsg").click(function(){
		var requestText=$("#tarea").val().trim();
		if(requestText=='')
		{
			alert("Please Enter Requsted Information");
			$("#tarea").val('');
			return false;
		}
		else{
			alert("Successfully Submited, Thank you.");
			$("#tarea").val('');
		}
	});
});