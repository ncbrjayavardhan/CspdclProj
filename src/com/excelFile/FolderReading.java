package com.excelFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

public class FolderReading {
	
	
	public void listFilesForFolder(final File folder) {
	
		
	    for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	            listFilesForFolder(fileEntry);
	        } else {
	        	
	        	//read the file data--start
	        	String path=fileEntry.getPath();
	        	
	        	//System.out.println("normal="+path);
	        	try {
	    			File file = new File(path);
	    			FileReader fileReader = new FileReader(file);
	    			BufferedReader bufferedReader = new BufferedReader(fileReader);
	    			StringBuffer stringBuffer = new StringBuffer();
	    			String line;
	    			while ((line = bufferedReader.readLine()) != null) {
	    			/*	stringBuffer.append(line);
	    				stringBuffer.append("\n");*/
	    				
	    				
	    	    		//string comparision --end		

	    				String delimiter = "\\ ";
	    	    		String[] temp;
	    	    		temp = line.split(delimiter);
	    	    		
	    	    		List li=new ArrayList<>();
	    		      
	    	    		for(int i =0; i < temp.length ; i++)
	    	    		{
	    	    			String value=temp[i];
	    	    		//	System.out.println(value);
	    	    			//un_authorized_access,Authorized
	    	    			
	    	    			
	    	    			
	    	    			
	    	    			if(value.equalsIgnoreCase("m_table_1{")){
	    	    				System.out.println(value);
	    	    				System.out.println("path= "+path);
	    	    				System.out.println("---------------------------------------");
	    	    			}
	    	    }
	    		//string comparision --end		
	    				
	    			}
	    			fileReader.close();
	    			//System.out.println("Contents of file:");
	    			/*System.out.println(stringBuffer.toString());*/
	    		} catch (IOException e) {
	    			e.printStackTrace();
	    		}
	        //read the file data end
	        	
	        	
	            //System.out.println(fileEntry.getName());
	        }
	    }
	    
		

	}
	
	
	public static void main(String args[]) {
		
		System.out.println("start");
		 File folder = new File("G:/TG School/keenthemes.com/metronic/preview/assets");
		 FolderReading fr=new FolderReading();
	     	fr.listFilesForFolder(folder);
	     	System.out.println("end");
	}

}
