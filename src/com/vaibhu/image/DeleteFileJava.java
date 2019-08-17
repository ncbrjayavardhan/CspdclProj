package com.vaibhu.image;

import java.io.File;

public class DeleteFileJava {

    /**
     * This class shows how to delete a File in Java
     * @param args
     */
    public void DeleteFile(String path) {
        //absolute file name with path
        File file = new File(path);
        if(file.delete()){
            System.out.println("File deleted");
        }else System.out.println("doesn't exist");
        
        //file name only
   /*     file = new File("file.txt");
        if(file.delete()){
            System.out.println("file.txt File deleted from Project root directory");
        }else System.out.println("File file.txt doesn't exist in the project root directory");
        
        //relative path
        file = new File("temp/file.txt");
        if(file.delete()){
            System.out.println("temp/file.txt File deleted from Project root directory");
        }else System.out.println("File temp/file.txt doesn't exist in the project root directory");
        
        //delete empty directory
        file = new File("temp");
        if(file.delete()){
            System.out.println("temp directory deleted from Project root directory");
        }else System.out.println("temp directory doesn't exist or not empty in the project root directory");
        
        //try to delete directory with files
        file = new File("/Users/pankaj/project");
        if(file.delete()){
            System.out.println("/Users/pankaj/project directory deleted from Project root directory");
        }else System.out.println("/Users/pankaj/project directory doesn't exist or not empty");
   */
    
    
    }
    
    public static void main(String args[]) {
    	DeleteFileJava df=new DeleteFileJava();
    	df.DeleteFile("");
		
	}

}
