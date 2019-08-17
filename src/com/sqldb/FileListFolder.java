package com.sqldb;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileListFolder {
	
	public  List listAllFiles(File folder){
//        System.out.println("In listAllfiles(File) method");
        File[] fileNames = folder.listFiles();

        List<String> files=new ArrayList<>();
        
        for(File file : fileNames){
            // if directory call the same method again
            if(file.isDirectory()){
                listAllFiles(file);
            }else{
            	
            	
            	files.add(file.getName());
            } 
        }
		return files;
    }

}
