package com.vaibhu.image.audit;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CopyFIle2 {
	
	
	
boolean status=false;
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void CopyFIle22(String source, String destination) {
 		 File f=null;
             try {
//            	 System.out.println("source= "+source);
//            	 System.out.println("destination= "+destination);
             	FileNameAutoChange  fa=new FileNameAutoChange();
             	destination=fa.Name_series(destination);
             	
                 Path sourceDirectory = Paths.get(source);
                 Path targetDirectory = Paths.get(destination);
               //copy source to target using Files Class
//     	      System.out.println(destination);
     	      targetDirectory = Paths.get(destination);
               Files.copy(sourceDirectory, targetDirectory);
         
           File tmpDir = new File(source);
            boolean del = tmpDir.exists();
         tmpDir = new File(destination);
         boolean ext_copy = tmpDir.exists();
         
         if(ext_copy==true) {
         	setStatus(true);
         }else {
    
         	setStatus(false);
         	
         }
         
         
 } catch (Exception e) {
 	e.printStackTrace();
 }finally {
 	
 	
 }

}
	
	
	public void CopyFIle_NonameChange(String source, String destination) {
		 File f=null;
            try {
//           	 System.out.println("source= "+source);
//           	 System.out.println("destination= "+destination);
            /*	FileNameAutoChange  fa=new FileNameAutoChange();
            	destination=fa.Name_series(destination);*/
            	
            	try {
            	 f=new File(destination);
            	 boolean dele=f.delete();
            	/* if(dele==true)
            		 System.out.println(f.getName()+"deleted");
            	 else
            		 System.out.println(f.getName()+"not deleted");*/
            	}catch(Exception ee) {
            		ee.printStackTrace();
            	}
            	 
                Path sourceDirectory = Paths.get(source);
                Path targetDirectory = Paths.get(destination);
              //copy source to target using Files Class
//    	      System.out.println(destination);
    	      targetDirectory = Paths.get(destination);
              Files.copy(sourceDirectory, targetDirectory);
        
          File tmpDir = new File(source);
           boolean del = tmpDir.exists();
        tmpDir = new File(destination);
        boolean ext_copy = tmpDir.exists();
        
        if(ext_copy==true) {
        	setStatus(true);
        }else {
   
        	setStatus(false);
        	
        }
        
        
} catch (Exception e) {
	e.printStackTrace();
}finally {
	
	
}

}
}