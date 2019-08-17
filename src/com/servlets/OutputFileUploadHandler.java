package com.servlets;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.database.FileNameAutoChange;
import com.database.JavaCreateDirectoryExample;
import com.sqldb.SqlDbFileReading;

import SqlDbFileToJson.SqlDbFileToJson;
import cspdcl.input.CSPDCL_INPUT_READING;

//import com.beans.DisconnectionPojo;

/**
 * Servlet to handle File upload request from Client
 * 
 * @author Javin Paul
 */
@WebServlet("/OutputFileUploadHandler")
public class OutputFileUploadHandler extends HttpServlet {
	private final String UPLOAD_DIRECTORY = "C:\\CSPDCL\\db Files\\";

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("i am in OutputFileUploadHandler");
		// process only if its multipart content
		int updated_data = 0;
		if (ServletFileUpload.isMultipartContent(request)) {
			try {
				List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);

				// create the directories--start
				JavaCreateDirectoryExample jd = new JavaCreateDirectoryExample();
				String uploads = jd.FolderCreation("C:\\CSPDCL");
				String not_updated = jd.FolderCreation("C:\\CSPDCL\\db Files");
				String updated = jd.FolderCreation("C:\\CSPDCL\\db Files");

				System.out.println("uploads= " + uploads + "not_updated= " + not_updated + "updated= " + updated);

				// create the directories--end
				for (FileItem item : multiparts) {
					if (!item.isFormField()) {

						/*
						 * InputStream inputstream = item.getInputStream(); BufferedReader bfReader =
						 * new BufferedReader(new InputStreamReader(inputstream)); CSPDCL_INPUT_READING
						 * cir=new CSPDCL_INPUT_READING(); updated_data=cir.InputdataLoading(bfReader);
						 * System.out.println("updated_data= "+updated_data);
						 */

						String name = new File(item.getName()).getName();
						FileNameAutoChange fnc = new FileNameAutoChange();
						String new_file_name = fnc.Name_series(UPLOAD_DIRECTORY + File.separator + name);
						System.out.println("new_file_name= " + new_file_name);
						// item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
						item.write(new File(new_file_name));

//						SqlDbFileToJson sqldb = new SqlDbFileToJson();
//						sqldb.selectAll("jdbc:sqlite:C:\\CSPDCL\\db Files\\DMP_09052019_125413(0)_(1).db");
//						System.out.println("db file upload completed");
					
					
					}
				}

				// File uploaded successfully
				request.setAttribute("message", "File Uploaded Successfully");
			} catch (Exception ex) {
				request.setAttribute("message", "File Upload Failed due to " + ex);
			}

		} else {
			request.setAttribute("message", "Sorry this Servlet only handles file upload request");
		}

		/*
		 * //System.out.println("data loading start"); FluentGridCsvToFluentGridMaster
		 * fcv=new FluentGridCsvToFluentGridMaster(); File f=new
		 * File("C:/uploads/not updated"); DisconnectionPojo dp=new DisconnectionPojo();
		 * dp=fcv.CsvToMaster_jAGADHEESH(f); //System.out.println("data loading end");
		 */
//        response.setAttribute("data", updated_data);
		response.setIntHeader("data", updated_data);
		response.sendRedirect("Disign2/DataOutputUpload.jsp");
		/*
		 * request.getRequestDispatcher("/Disign2/DataLoading.jsp").forward(request,
		 * response);
		 */

	}

}
