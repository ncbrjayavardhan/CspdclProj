package com.login;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.database.DataBaseOperations;
import com.database.DbConnection;
import com.vaibhu.image.CopyFIle;

/**
 * Servlet implementation class ImageDispalyServlet
 */
@WebServlet("/ImageDispalyServlet")
public class ImageDispalyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageDispalyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session=request.getSession(false);  
       
		String Bp_number=request.getParameter("id");
		System.out.println("BP_number = "+Bp_number);
		
		
		
		//delete the existing attributes
		try {
		session.removeAttribute("BP_NUMBER");
		session.removeAttribute("BILL_NET_WITHIN_DUE_DATE");
		session.removeAttribute("BILL_DATE");
		session.removeAttribute("UNIT_BILLED");
		session.removeAttribute("TOTAL_BILL");
		session.removeAttribute("PRES_READ_KWH");
		}catch (Exception e) {
			e.printStackTrace();
		}
		//delete existing attributes end
		
		
		
		
		String image_path=null;
		String BP_NUMBER=null;
		String BILL_NET_WITHIN_DUE_DATE=null;
		String  BILL_DATE=null;
		String  UNIT_BILLED=null;
		String TOTAL_BILL=null;
		String PRES_READ_KWH=null;
		
		
		Connection con=null;
		java.sql.ResultSet rs=null;
		PreparedStatement ps=null;
		DbConnection db=new DbConnection();
		
		try {
		 con=db.getConnObject2();
		 
		 DataBaseOperations dbs=new DataBaseOperations();
		 rs=dbs.exicuteQueryReesultSet("select * from cspdcl_output where BP_NUMBER='"+Bp_number+"'", con, rs, ps);
		 
		 while (rs.next()) {
			
			 image_path=rs.getString("IMAGE_PATH");
			 BP_NUMBER=rs.getString("BP_NUMBER");
			 BILL_NET_WITHIN_DUE_DATE=rs.getString("BILL_NET_WITHIN_DUE_DATE");
			 BILL_DATE=rs.getString("BILL_DATE");
			 UNIT_BILLED=rs.getString("UNIT_BILLED");
			 TOTAL_BILL=rs.getString("TOTAL_BILL");
			 PRES_READ_KWH=rs.getString("PRES_READ_KWH");
		}
		
		}catch(Exception e) {
			e.printStackTrace();
		
		}
		
		
		String relativeWebPath = "/Disign2/"+BP_NUMBER+".jpg";
		String absoluteDiskPath = getServletContext().getRealPath(relativeWebPath);
//		File file = new File(absoluteDiskPath, "imagetosave.jpg");
		System.out.println("absoluteDiskPath="+absoluteDiskPath);
		
		
		CopyFIle  cf=new CopyFIle(image_path,absoluteDiskPath);
		
		System.out.println("file copy status= "+cf.isStatus());
		
		
		session.setAttribute("BP_NUMBER", BP_NUMBER);
		session.setAttribute("BILL_NET_WITHIN_DUE_DATE", BILL_NET_WITHIN_DUE_DATE);
		session.setAttribute("BILL_DATE", BILL_DATE);
		session.setAttribute("UNIT_BILLED", UNIT_BILLED);
		session.setAttribute("TOTAL_BILL", TOTAL_BILL);
		session.setAttribute("PRES_READ_KWH", PRES_READ_KWH);
		
		
		
		response.sendRedirect("Disign2/ConsumerView.jsp");
		
		
		
		/*response.getWriter().append("Served at: ").append(request.getContextPath());*/
		
		
		/*RequestDispatcher rd=request.getRequestDispatcher("Disign2/ConsumerView.jsp");  
		request.setAttribute("BP_NUMBER", BP_NUMBER);
		request.setAttribute("BILL_NET_WITHIN_DUE_DATE", BILL_NET_WITHIN_DUE_DATE);
		request.setAttribute("BILL_DATE", BILL_DATE);
		request.setAttribute("UNIT_BILLED", UNIT_BILLED);
		request.setAttribute("TOTAL_BILL", TOTAL_BILL);
		request.setAttribute("PRES_READ_KWH", PRES_READ_KWH);
		rd.forward(request, response);//method may be include or forward  
*/	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
