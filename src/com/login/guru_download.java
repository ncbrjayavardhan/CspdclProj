package com.login;
 
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.excelFile.CSPDCL_OUTPUTT_EXCEL;
 
/**
 * Servlet implementation class guru_download
 */
@WebServlet("/ExcelDownalod")
public class guru_download extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		
		System.out.println(" i am in excel download servlet");
		
		
		
		String discome=request.getParameter("discome");
		String division=request.getParameter("mru");
		String circle=request.getParameter("circle");
		String subdivision=request.getParameter("bmonth");

		String group=request.getParameter("group");
		String from=request.getParameter("from");
		String to=request.getParameter("to");

		System.out.println(discome);
		System.out.println(division);
		System.out.println(circle);
		System.out.println(subdivision);
		System.out.println(group);
		System.out.println(from);
		System.out.println(to);
		
//		String Query="select * from cspdcl_output";

		String Query="select MRU,BP_NUMBER,CUR_MTR_STS,Pres_Read_KWH,UNIT_BILLED,PRES_READ_KW_RMD,CUR_PF from cspdcl_output where BILL_DATE between to_date('"+from+"','yyyy-MM-dd')  and to_date('"+to+"','yyyy-MM-dd') and MRU='"+division+"'";
//		String Query="select MRU,BP_NUMBER,CUR_MTR_STS,Pres_Read_KWH,UNIT_BILLED,PRES_READ_KW_RMD,CUR_PF from cspdcl_output where SERVER_TIME between to_date('"+from+"','yyyy-MM-dd')  and to_date('"+to+"','yyyy-MM-dd') and MRU='"+division+"'";

		System.out.println("excel download= "+Query);
		
		CSPDCL_OUTPUTT_EXCEL coe=new CSPDCL_OUTPUTT_EXCEL();
		//coe.excelGeneration(); // full data acceses
		coe.excelGeneration2(Query);   // data acceses with conditions
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PrintWriter out = response.getWriter();
		String gurufile = "output.xlsx";
		String gurupath = "c:\\";
		response.setContentType("APPLICATION/OCTET-STREAM");
		response.setHeader("Content-Disposition", "attachment; filename=\""
				+ division+"_"+from+"_"+to+"_output.xlsx" + "\"");
 
		FileInputStream fileInputStream = new FileInputStream(gurupath
				+ gurufile);
 
		int i;
		while ((i = fileInputStream.read()) != -1) {
			out.write(i);
		}
		fileInputStream.close();
		out.close();
	}
 
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
 
}