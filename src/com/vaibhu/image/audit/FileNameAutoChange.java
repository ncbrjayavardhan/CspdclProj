package com.vaibhu.image.audit;

import java.io.File;
import java.io.IOException;


public class FileNameAutoChange {

	public String Name_series(String path) {
		//System.out.println("first= "+path);
		
		     File f = new File(path);
	         boolean ext_stat=f.exists();

	        
  	         
  	       while(ext_stat) {
  	         
  	    	 int index1= path.lastIndexOf("_(");
  	         int index2= path.lastIndexOf(")");
  	         if(index1!=-1 && index2!=-1) {
  	         
  	  String rig_val="";
		 for(int k=2;k<(index2-index1);k++)
  		     rig_val=rig_val+path.charAt(index1+k)+"";
		 
		     //System.out.println(rig_val);
			 path=path.replace("_("+rig_val+")","_("+(Integer.parseInt(rig_val)+1)+")");
			 rig_val=""+(Integer.parseInt(rig_val)+1);
			 //System.out.println(path);
			
			
	
		 
		
//		 //System.out.println( path.replace("_("+(path.charAt((path.lastIndexOf("(")+1)))+")","_("+((Integer.parseInt((path.charAt((path.lastIndexOf("(")+1)))+"" ))+1)+")"));
  	         }else {
  	        	 try {
  	        	 String delimiter = "\\.";
	   		     String[] temp;
	   		     temp = path.split(delimiter);
	   		     String name=temp[0];
	   		     String extension=temp[1];
	   		  path=name+"_(1)"+"."+extension;
  	        	 }catch (Exception e) {
  	        		e.printStackTrace();
				}
  	         }
  	         
  	         
  	         
  	       f = new File(path);
	          ext_stat=f.exists();
  	         
  	   	}
  	    
  	         
  	         
  			//System.out.println("end= "+path);

		//System.out.println("completed");
		return path;
		}
	
	public static void main(String args[]) {
		FileNameAutoChange fnc=new FileNameAutoChange();
		fnc.Name_series("C:\\Users\\VIIPL02\\Desktop\\hii\\kk.jpg");
	}
	
}
