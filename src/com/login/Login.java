package com.login;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.database.DbConnection;



@WebServlet({"/Login"})

public class Login extends HttpServlet {

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
		HttpSession session=request.getSession(false);
		if(session!=null)
			session.invalidate();
		}catch(Exception e){
			
		}
		
		response.sendRedirect("/CspdclDashBoard");
	
	}
	
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name=request.getParameter("username");
		String pwd=request.getParameter("password");
		
		System.out.println("name="+name+"  pass="+pwd);
		
		String sessionexp="Session Expired";
		Connection con=null;
		PreparedStatement ps=null,ps1=null,ps2=null,ps3=null;
		String div=null;
		String areacode="";
		ResultSet rs=null;
		ResultSet rst=null;
		HttpSession session=null;
		ArrayList<String> li=null;
		
		 session=request.getSession(true);
		 System.out.println("session object= "+session);
		
		try{
			
			
//			javax.servlet.ServletContext ctx=getServletContext();
//			con=(Connection)ctx.getAttribute("MyConnection");
			
			DbConnection db1=new DbConnection();
			con=db1.getConnObject2();
			//Select * from VAIBHU_LOGIN where USER_NAME=? and password=? 
			 ps=con.prepareStatement ("Select * from CSPDCL_WEB_USERS where USER_NAME=? and PASSWORD=? ");
			
			 
			 ps.setString(1,name);
			 ps.setString(2,pwd);
			 rs=ps.executeQuery();
			 ps1=con.prepareStatement("Select AUTHENTICATION_CODE from CSPDCL_WEB_AUTHENTICATION where USER_NAME=?");
			 ps1.setString(1,name);
			 rst=ps1.executeQuery();
			 boolean login=false;
			while(rs.next()){
				login=true;
				System.out.println("SUCCESESSFULLY LOGINNED");
				session.setAttribute("session1", "1234");
				session.setAttribute("userid", rs.getString("USER_ID"));
				session.setAttribute("username", name);
				while(rst.next()) {
					session.setAttribute("AUTH_CODE", rst.getObject("AUTHENTICATION_CODE"));
				}

				/*response.sendRedirect("DashBoard.jsp");*/
				/*response.sendRedirect("Disign2/TotalUploadedData_show.jsp");*/
				response.sendRedirect("Disign2/DashBoard.jsp");
				
			}
			
			if(!login){
				response.sendRedirect("/CspdclDashBoard/");
			}
			
			//Area codes calculation
			
			if(login==true){
			
			String delimiter = "\\,";
    		String[] temp;
    		temp = areacode.split(delimiter);
    		int tempLength= temp.length;
    		li=new ArrayList<String>();
    		
    		for(int i=0;i<tempLength;i++){
    			
    			String Acode = (temp[i]);
    			li.add(Acode.trim());
    			
    		
    			
    		}
    		
    	
			//getting the value object--start
		//	System.out.println("login Emp_type "+EMP_TYPE);
			
//			DataGettingPojo dgp=new DataGettingPojo();
//			DataGettingPojo dgp2=new DataGettingPojo();
//
//			DbConnection db=new DbConnection();
			
//			 dgp = db.BillingTableData(name,li);
//			 dgp2 =db.MeterReadersLiveList(li);
//			
			
			//getting the value object--end
			
			session=request.getSession(true);
			session.setAttribute("div", div);
			session.setAttribute("username", name);
			session.setAttribute("sessionexp", sessionexp);
			
			
			
//			session.setAttribute("EMP_TYPE", EMP_TYPE);
//			session.setAttribute("total", total_consumers);
//			session.setAttribute("total_billable", total_consumers_billable);
//			session.setAttribute("total_billed", total_consumers_billed);
			
			System.out.println(" i am in before re directing");
		
//				RequestDispatcher rd=getServletContext().getRequestDispatcher("/Home.jsp");	
			
			
//				RequestDispatcher rd=getServletContext().getRequestDispatcher("/FinalWebPages/BillingPercentage.jsp");	
				
//				request.setAttribute("list", li);
//				request.setAttribute("id", "1234");
//				request.setAttribute("emp_type", ""+EMP_TYPE);
				

//				rd.forward(request,response);
			//response.sendRedirect("/MeterInstallationWeb/Home.jsp");

			}		
				
				
				
				
		}catch(java.lang.IllegalStateException e){
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
			if(rs!=null)
				rs.close();
				if(ps!=null)
					ps.close();
					if(out!=null)
						out.close();
						if(rst!=null)
							rst.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		}

}
