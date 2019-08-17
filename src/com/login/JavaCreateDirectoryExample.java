package com.login;
import java.io.File;

// demonstrates how to create a directory in java
public class JavaCreateDirectoryExample
{
  public String FolderCreation(String Path)
  {
//    File dir = new File("/Users/al/tmp/TestDirectory");
    File dir = new File(Path);
String return_msg=null;
    if(dir.exists()) {
    	return_msg="Existed";
    }else {
    // attempt to create the directory here
    boolean successful = dir.mkdir();
    if (successful)
    {
      // creating the directory succeeded
    	return_msg="created";

//      System.out.println("directory was created successfully");
    }
    else
    {
      // creating the directory failed
    	return_msg="not created";
//      System.out.println("failed trying to create the directory");
    }
    }
    
	return return_msg;
  }
}