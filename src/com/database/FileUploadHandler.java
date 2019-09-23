package com.database;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.pojo.CheckingPojo;

import cspdcl.input.CSPDCL_INPUT_READING;

//import com.beans.DisconnectionPojo;

/**
 * Servlet to handle File upload request from Client
 * @author Javin Paul
 */
@WebServlet("/FileUploadHandler")
public class FileUploadHandler extends HttpServlet {
    private final String UPLOAD_DIRECTORY = "C:/uploads/not updated";
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     System.out.println("i am in FileUploadHandler");
        //process only if its multipart content
     String updated_data="";
     String new_file_name="";
     List returnData=new ArrayList();

     CheckingPojo cp=new CheckingPojo();
        if(ServletFileUpload.isMultipartContent(request)){
            try {
                List<FileItem> multiparts = new ServletFileUpload(
                                         new DiskFileItemFactory()).parseRequest(request);
              
                //create the directories--start
                JavaCreateDirectoryExample jd=new JavaCreateDirectoryExample();
              String uploads=  jd.FolderCreation("C:/uploads");
              String not_updated=  jd.FolderCreation("C:/uploads/not updated");
              String updated=  jd.FolderCreation("C:/uploads/updated");
              
              System.out.println("uploads= "+uploads+"not_updated= "+not_updated+"updated= "+updated);
                
              //create the directories--end
                for(FileItem item : multiparts){
                    if(!item.isFormField()){
                    	
                    	InputStream inputstream = item.getInputStream();
                    	BufferedReader bfReader = new BufferedReader(new InputStreamReader(inputstream));
                    	CSPDCL_INPUT_READING cir=new CSPDCL_INPUT_READING();
                    	 returnData=cir.InputdataLoading(bfReader);
                    	
                   	try {
	                       String name = new File(item.getName()).getName();
	                       FileNameAutoChange fnc=new FileNameAutoChange();
	                       new_file_name=fnc.Name_series(UPLOAD_DIRECTORY + File.separator + name);
	                       item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
	                       item.write( new File(new_file_name));
                    	}catch (Exception ee) {
                    			System.out.println("file not created in the directory:"+ new_file_name +ee.getMessage());
                    	}
                    
                    }
                }
           
            } catch (Exception ex) {
                ex.printStackTrace();
            
            }          
         
        }else{
            request.setAttribute("message",
                                 "Sorry this Servlet only handles file upload request");
        }
        if(returnData.size() >1) {
        	HttpSession session = request.getSession(false);
        	//save message in session
        	session.setAttribute("errMsg", returnData.get(1));
        	 response.sendRedirect("Disign2/DataLoading.jsp?data="+returnData.get(0));
        }else {
        	response.sendRedirect("Disign2/DataLoading.jsp?data="+returnData.get(0));
        	
        }
     
    }
  
}


