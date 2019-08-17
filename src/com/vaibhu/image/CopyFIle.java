package com.vaibhu.image;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CopyFIle {
	
	boolean status=false;
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	CopyFIle(){
		
	}

	public CopyFIle(String source, String destination) {
		 File f=null;
            try {
            	
            	
            	DeleteFileJava df=new DeleteFileJava();
            	df.DeleteFile(destination);
            	
            	/*FileNameAutoChange  fa=new FileNameAutoChange();
            	destination=fa.Name_series(destination);*/
            	
                Path sourceDirectory = Paths.get(source);
                Path targetDirectory = Paths.get(destination);
              //copy source to target using Files Class
    	      //System.out.println(destination);
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
        
        
}catch (java.nio.file.FileAlreadyExistsException e) {

try {
DeleteFileJava df=new DeleteFileJava();
df.DeleteFile(destination);
CopyFIle cpf=new CopyFIle(source,destination);

}catch (Exception ee) {
	ee.printStackTrace();
}
}catch (Exception e) {
	e.printStackTrace();
}finally {
	
	
}

    }
	
	public static void main(String args[]) {
		//System.out.println("start");
		/*CopyFIle copyFIle=new CopyFIle("C:\\Users\\VIIPL02\\Desktop\\kk.jpg","C:\\Users\\VIIPL02\\Desktop\\hii\\kk.jpg");
		//System.out.println(copyFIle.isStatus());*/
		
		/*
		String naormal="hiii_(k).jpg";
		//System.out.println(naormal.replaceAll("(.)", "2."));
		//System.out.println(naormal.lastIndexOf("."));
		//System.out.println(naormal.replaceAll("_(1)", "2"));
		//System.out.println(naormal.replaceAll("(1)", "(2)"));
		//System.out.println(naormal.replaceAll("(1)", "(3)"));
		//System.out.println(naormal.charAt(5));
		
		//System.out.println(naormal.replaceAll("(2)",((Integer.parseInt((naormal.charAt((naormal.lastIndexOf("(")+1)))+"" ))+1)+""));
		//System.out.println((naormal.charAt((naormal.lastIndexOf("(")+1)))+"" );
		
		//System.out.println(naormal.replaceAll("("+(naormal.charAt((naormal.lastIndexOf("(")+1)))+")",((Integer.parseInt((naormal.charAt((naormal.lastIndexOf("(")+1)))+"" ))+1)+""));
*/
		String destination = "C:\\Users\\VIIPL02\\Desktop\\hii\\kk_(1).jpg";
		//System.out.println(destination);
		 int index1= destination.lastIndexOf("_(");
   	  int index2= destination.lastIndexOf(")");
   	  String rig_val="";
		 for(int k=2;k<(index2-index1);k++)
   		  rig_val=rig_val+destination.charAt(index1+k)+"";
		 
		 
		 //System.out.println(rig_val);
		for(int i=0;i<10000000;i++) {
//		destination= destination.replace("_("+(destination.charAt((destination.lastIndexOf("(")+1)))+")","_("+((Integer.parseInt((destination.charAt((destination.lastIndexOf("(")+1)))+"" ))+1)+")").replace("_("+(destination.charAt((destination.lastIndexOf("(")+1)))+")","_("+((Integer.parseInt((destination.charAt((destination.lastIndexOf("(")+1)))+"" ))+1)+")");
			
		
			destination=destination.replace("_("+rig_val+")","_("+(Integer.parseInt(rig_val)+1)+")");
			rig_val=""+(Integer.parseInt(rig_val)+1);
			//System.out.println(destination);
		}
//		 //System.out.println( destination.replace("_("+(destination.charAt((destination.lastIndexOf("(")+1)))+")","_("+((Integer.parseInt((destination.charAt((destination.lastIndexOf("(")+1)))+"" ))+1)+")"));

		//System.out.println("completed");
	}
}