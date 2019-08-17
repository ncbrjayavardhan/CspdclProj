package com.database;
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
     String return_message="";

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
                    	InputStream inputstream2 = item.getInputStream();

                    	BufferedReader bfReader = new BufferedReader(new InputStreamReader(inputstream));
                    	BufferedReader bfReader2 = new BufferedReader(new InputStreamReader(inputstream2));

//                    	System.out.println(bfReader2+"_"+ bfReader);
                    	CSPDCL_INPUT_READING cir=new CSPDCL_INPUT_READING();
//                    	 updated_data=cir.InputdataLoading(bfReader);
                    	 cp=cir.InputdataLoadingCheking(bfReader);
                     	System.out.println("message = "+cp.getMessage());
                    	return_message=cp.getMessage();

                    	if(cp.isStatus()==true) {
//                    	 updated_data=cir.InputdataLoadingWithOwlFileOnce(bfReader,new BufferedReader(bfReader) );
//                            System.out.println("data checked");

                    		int	 updated_data2=cir.InputdataLoading(bfReader2);
//                       System.out.println("updated_data2= "+updated_data2);
//                       cp.setMessage(""+updated_data2);
                       return_message=""+updated_data2;
                    	}else {
//                            response.sendRedirect("Disign2/DataLoading.jsp?data="+cp.getMessage());

                    	}
                    	
                    	try {
                    	System.out.println("updated_data= "+updated_data);

                        String name = new File(item.getName()).getName();
                        FileNameAutoChange fnc=new FileNameAutoChange();
                        String new_file_name=fnc.Name_series(UPLOAD_DIRECTORY + File.separator + name);
//                        item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
                        item.write( new File(new_file_name));
                    	}catch (Exception ee) {
                    			ee.printStackTrace();
                    	}
                    
                    }
                }
           
               //File uploaded successfully
//               request.setAttribute("message", "File Uploaded Successfully");
            } catch (Exception ex) {
//               request.setAttribute("message", "File Upload Failed due to " + ex);
//                response.sendRedirect("Disign2/DataLoading.jsp?data="+cp.getMessage());
                ex.printStackTrace();
            
            }          
         
        }else{
            request.setAttribute("message",
                                 "Sorry this Servlet only handles file upload request");
        }
        
        
       /* //System.out.println("data loading start");
		FluentGridCsvToFluentGridMaster fcv=new FluentGridCsvToFluentGridMaster();
		File f=new File("C:/uploads/not updated");
		DisconnectionPojo dp=new DisconnectionPojo();
		dp=fcv.CsvToMaster_jAGADHEESH(f);
		//System.out.println("data loading end");
        */
//        response.setAttribute("data", updated_data);
//        response.setIntHeader("data", updated_data);
     
         response.sendRedirect("Disign2/DataLoading.jsp?data="+return_message);
//        response.sendRedirect("Disign2/DataLoading.jsp");

//        request.setAttribute("data", updated_data);
//        request.getRequestDispatcher("Disign2/DataLoading.jsp").forward(request, response);
        
/*        request.getRequestDispatcher("/Disign2/DataLoading.jsp").forward(request, response);
*/        
        
     
    }
  
}


