package com.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.DataBaseOperations;
import com.database.DbConnection;
import com.database.UserRegistrationDb;
import com.pojo.UserRegistration;

/**
 * Servlet implementation class DataStoring
 */
@WebServlet("/DataStoring")
public class DataStoring extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataStoring() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		String	 mrname=request.getParameter("mrname");
		String	 address=request.getParameter("address");
		String	 userid=request.getParameter("userid");
		String	 email=request.getParameter("email");
		String	 desigantion=request.getParameter("designation");
		String	 imei2=request.getParameter("imei2");
		String	 groups=request.getParameter("groups");
		String	 fname=request.getParameter("fname");
		String	 proof=request.getParameter("proof");
		String	 password=request.getParameter("password");
		String	 mobile=request.getParameter("mobile");
		String	 imei1=	request.getParameter("imei1");
		String	 superid=request.getParameter("superid");
		String   division=request.getParameter("division");
		
		System.out.println("desigantion= "+request.getParameter("designation"));
		
		System.out.println(mrname);
		System.out.println(address);
		System.out.println(userid);
		System.out.println(email);
		System.out.println(desigantion);
		System.out.println(imei2);
		System.out.println(groups);
		System.out.println(fname);
		System.out.println(proof);
		System.out.println(password);
		System.out.println(mobile);
		System.out.println(imei1);
		System.out.println(superid);
		System.out.println(division);

		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		DbConnection dbc=new DbConnection();
		int METER_READER_UID=0;
		
		DataBaseOperations dbo=new DataBaseOperations();
		
		UserRegistration ur=new UserRegistration();
		ur.setMrname(mrname);
		ur.setAddress(address);
		ur.setUserid(userid);
		ur.setEmail(email);
		ur.setDesigantion(desigantion);
		ur.setImei2(imei2);
		ur.setGroups(groups);
		ur.setFname(fname);
		ur.setProof(proof);
		ur.setPassword(password);
		ur.setMobile(mobile);
		ur.setImei1(imei1);
		ur.setSuperid(superid);
		ur.setDccode(division);

		System.out.println("mrname= "+ur.getMrname());

		UserRegistrationDb urb=new UserRegistrationDb();

		if(urb.MRstore(ur)==true){
			System.out.println("stored success");
			response.sendRedirect("Disign2/MrList.jsp");
//			out.print("<b><font color='green'>stored success</font></b>");
		}else{
			System.out.println("not stored");
			response.sendRedirect("Disign2/MeterReaderRegistration.jsp");

//			out.print("<b><font color='red'>not stored</font></b>");
		}
		
		
/*		//data store CSPDCL_LOGIN --start
		
			METER_READER_UID=0;
			try {
				con=dbc.getConnObject2();
			    rs=dbo.exicuteQueryReesultSet("select max(ID) from CSPDCL_LOGIN", con, rs, ps);
			
			while(rs.next()) {
				
				METER_READER_UID=(rs.getInt("MAX(ID)")+1);
				
			}
			
			}catch (Exception e) {
					e.printStackTrace();
			}finally {
				try {
				rs.close();
				}catch (Exception e) {}
				try {ps.close();}catch (Exception e) {}
				try {con.close();}catch (Exception e) {}
			
			}
					String Query2="insert into CSPDCL_LOGIN(ID,USER_NAME,PASSWORD,EMAIL,MOBILE_NUM,DESIGNATION_CODE,IMEI_1,IMEI_2,METER_READER_UID,SUPER_ID)"
							+ "                values('"+METER_READER_UID+"','"+userid+"','"+password+"','"+email+"','"+mobile+"','"+desigantion+"','"+imei1+"','"+imei2+"','"+METER_READER_UID+"','"+superid+"')";
					
					System.out.println("Query2= "+Query2);
					int data_meter_reader2=0;
					try {
						con=dbc.getConnObject2();
					     data_meter_reader2=dbo.exicuteQuery(Query2, con);
					
					}catch (Exception e) {
							e.printStackTrace();
					}finally {
						try {
							con.commit();
						}catch (Exception e) {
						
						}
						
						try {rs.close();}catch (Exception e) {}
						try {ps.close();}catch (Exception e) {}
						try {con.close();}catch (Exception e) {}
					}
					
					//data store CSPDCL_LOGIN --end
		
		
		
		
		
		//CSPDCL_METER_READERS
		
		
		try {
			con=dbc.getConnObject2();
		    rs=dbo.exicuteQueryReesultSet("select max(METER_READER_UID) from CSPDCL_METER_READERS", con, rs, ps);
		
		while(rs.next()) {
			METER_READER_UID=(rs.getInt("MAX(METER_READER_UID)")+1);
		}
		
		
		}catch (Exception e) {
				e.printStackTrace();
		}finally {
			try {
			rs.close();
			}catch (Exception e) {}
			try {ps.close();}catch (Exception e) {}
			try {con.close();}catch (Exception e) {}
		}
		
		//data store CSPDCL_METER_READERS --start
				
		String Query="insert into CSPDCL_METER_READERS(METER_READER_UID,METER_READER_NAME,METER_READER_FATHER_NAME,METER_READER_ADDRESS) "
				+ "values('"+METER_READER_UID+"','"+mrname+"','"+fname+"','"+address+"')";
		System.out.println("Query2= "+Query);

		
		int data_meter_reader=0;
		try {
			con=dbc.getConnObject2();
		     data_meter_reader=dbo.exicuteQuery(Query, con);
		
		}catch (Exception e) {
				e.printStackTrace();
		}finally {
			try {
			rs.close();
			}catch (Exception e) {}
			try {ps.close();}catch (Exception e) {}
			try {con.close();}catch (Exception e) {}
		}
		
		//data store CSPDCL_METER_READERS --end

					
		*/		
		

	}

}
