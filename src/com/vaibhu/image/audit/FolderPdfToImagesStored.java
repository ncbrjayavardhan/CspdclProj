package com.vaibhu.image.audit;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

//import com.pdf.ConvertPDFPagesToImages;

public class FolderPdfToImagesStored {
	public List listFilesForFolder(final File folder,final String destfolder) {
		List<String> li=new ArrayList<String>();
		try {
		  
	    for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	            listFilesForFolder(fileEntry,destfolder);
	        } else {
	           // System.out.println(fileEntry.getName());
	            li.add(fileEntry.getAbsolutePath());
	        	//System.out.println("destfolder.getAbsolutePath()= "+destfolder);
	        	/*ConvertPDFPagesToImages pf=new ConvertPDFPagesToImages();
	        	pf.convertPdftoImage(fileEntry.getAbsolutePath(), destfolder);*/
	        	
	        	
	        }
	    }
		}catch (Exception e) {
			// TODO: handle exception
		}
		return li;
	}

	
	public List listFilesForFolder2(final File folder,final String destfolder) {
		List<String> li=new ArrayList<String>();
		try {
			
	    for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	        	listFilesForFolder2(fileEntry,destfolder);
	        } else {
	           // System.out.println(fileEntry.getName());
	            li.add(fileEntry.getAbsolutePath());
	        	//System.out.println("destfolder.getAbsolutePath()= "+destfolder);
	        	
	        	
	        }
	    }
		}catch (Exception e) {
			// TODO: handle exception
		}
		return li;
	}

	
	public String  DeleteFilesForFolder2(final File folder) {
		List<String> li=new ArrayList<String>();
		try {
			
	    for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	        	DeleteFilesForFolder2(fileEntry);
	        } else {
	           System.out.println(fileEntry.getName());
	        	try {
	        	boolean b=fileEntry.delete();
	        	if(b==true)
	        		System.out.println("deleted");
	        	else
	        		System.out.println("not deleted");
	        	
	        	
	        	}catch (Exception ee) {
					ee.printStackTrace();
				}
	        	
	        }
	    }
		}catch (Exception e) {
			// TODO: handle exception
		}
		return "Completed";
		
	}
	
	public static void main(String args[]) {
		FolderPdfToImagesStored ff=new FolderPdfToImagesStored();
		ff.listFilesForFolder2(new File("C:\\Users\\VIIPL02\\Desktop\\1\\10files"), "C:\\Users\\VIIPL02\\Desktop\\1\\otput\\");
		//ff.DeleteFilesForFolder2(new File("G:/Web Services WorkSpace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/PdfNameChangeOCR/images"));
	}
}
