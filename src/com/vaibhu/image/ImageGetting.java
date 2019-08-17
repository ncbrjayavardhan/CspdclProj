package com.vaibhu.image;

import java.sql.*;
import java.io.*;
import java.util.*;

import com.database.DbConnection;

import oracle.jdbc.*;
import oracle.sql.*;

import org.apache.commons.codec.binary.Base64;


//extra data--end

public class ImageGetting
{

	Blob b=null;

	public Blob getB() {
		return b;
	}

	public void setB(Blob b) {
		this.b = b;
	}
	
	public Connection databaseConnection()
	{
		
		String driver="oracle.jdbc.driver.OracleDriver";
		
		//String url="jdbc:oracle:thin:@192.168.0.111:1521:orcl";
//		String url="jdbc:oracle:thin:@124.123.41.255:1521:orcl";
		  String url="jdbc:oracle:thin:@localhost:1521:orcl";
		  String uname="AGRABO";
		  String password="AGRABO";
		  Connection con=null;
		  Statement stmt=null;
		  ResultSet rs = null, rs2=null;
		  
		  //connection
		 
		  try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,uname,password); 
		} catch (ClassNotFoundException e) {
			 
			e.printStackTrace();
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
		return con;  
			  
		  
		
		
	}
	
	//extra data--start
	
	public static byte[] getPhoto (String scno, String book, String filepath, String imageType, int rowno)
		      
		  {
		Statement stmt=null;
		ResultSet rset=null;
		Connection conn1=null;
		byte[] imgData = null ;
		byte[] buff =null;
		InputStream in =null;
		OutputStream out1 =null;
		try{
		   ImageGetting g=new ImageGetting();
		  conn1=g.databaseConnection();
		    String req = "" ;
		    Blob img = null ;
		    
		     stmt = conn1.createStatement ();
		    
		    // Query
		    req = "Select * From sbmtopc_android  Where scno ='"+scno+"' and book='"+book+"'";
		    
		     rset  = stmt.executeQuery ( req ); 
		     
		     String DbColumn=null;
		     String imageName=null;
		    
		     if(imageType.equalsIgnoreCase("MD")){
		    	 //system.out.println("i am in MD");
		    	 DbColumn="md_image";
			     imageName="MDimage.jpg";
		     }
		     else if(imageType.equalsIgnoreCase("rdg")){
		    	 //system.out.println("i am in rdg");
		    	 DbColumn="rdg_image";
			     imageName="image.jpg";
		    	
		     }
		     int i=1;
		    while (rset.next ())
		    {
		    	//System.out.println("DbColumn="+DbColumn);
		    	
		    	 Blob img1= rset.getBlob(DbColumn);
		    	
		    	 if(rowno==i){
		      img = rset.getBlob(DbColumn);
		      if(img!=null)
		      imgData = img.getBytes(1,(int)img.length());
		    	 }
		      i++;
		    }   
		    
		    //wrie the image in to some path start
		    
		    
//		    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//		    InputStream input = classLoader.getResourceAsStream("image.jpg");

		    //delete the file
		    
		    ImageGetting ig=new ImageGetting();
		    ig.imageDelete(filepath,imageName);
		    
		 //   System.out.println("imageName="+imageName);
		    
		    if(img!=null){
		    	
		     in = img.getBinaryStream();
		     out1 = new FileOutputStream(filepath+"/"+imageName);
		     buff = new byte[4096];  // how much of the blob to read/write at a time
		    int len = 0;

		    while ((len = in.read(buff)) != -1) {
		        out1.write(buff, 0, len);
		    }
		    if(out1!=null)
		    out1.close();
		    //write the image in to some path end
		}
		    
		  //  System.out.println("img=="+img);
		    //System.out.println(imgData);
		    
		    
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally{
			try{
			if(rset!=null)
			rset.close();
			if(stmt!=null)
		    stmt.close();
			if(conn1!=null)
				conn1.close();
			
			
			}catch(Exception e){
				e.printStackTrace();
			}
			
			}
		return imgData ;
		  }
		  
	public void imageDelete(String filepath, String imagename){
		
		String path=filepath+"/"+imagename;
		//System.out.println("deleted path="+path);
		
		File f=new File(path);
		if(f.exists())
		{
			boolean k = f.delete();
			//System.out.println("delete status= "+k);
			//System.out.println("succsess fully deleted");
		}else{
			//System.out.println("file not there");
		}
		
		
	}
	

	public String FileStoreInBlob(String scno, String book, String filepath, String imageType, int rowno){
		
		String imageText="";
	//system.out.println("start");
	String uid=null;
	String DbColumn=null;
	String imageName=null;
	Connection condb=null;
	InputStream inputStream2 =null;
	PreparedStatement ps2 =null;
	ResultSet rs2=null;
	FileInputStream fis=null;
	FileOutputStream stream = null;
	OutputStream ops=null;
		try{ 
			
		DbConnection dbc=new DbConnection();
		 condb = dbc.getConnObject();
		

	     if(imageType.equalsIgnoreCase("MD")){
	    	 //system.out.println("i am in MD");
	    	 DbColumn="md_image";
		     imageName="MDimage.jpg";
	     }
	     else if(imageType.equalsIgnoreCase("rdg")){
	    	 //system.out.println("i am in rdg");
	    	 DbColumn="rdg_image";
		     imageName="image.jpg";
	    	
	     }
		
//		File f=new File("C:/Users/VIIPL02/Desktop/Rdg_"+uid+".txt");	
//		File f2=new File("C:/Users/VIIPL02/Desktop/md_"+uid+".txt");	
	//	
		//write the data into file
		
		
		
//		//write the data into file--end
	//	
//		FileReader fr =new FileReader(f);
		
//		InputStream inputStream = new FileInputStream(f);
//		 inputStream2 = new FileInputStream(f2);
	//
//		System.out.println("After inputStream");
	//
////		BufferedReader br =new BufferedReader(fr);
//		PreparedStatement ps =condb.prepareStatement("update sbmtopc_android set rdg_image=? where scno=? and book=?");
//		System.out.println("After ps");
	//
//		ps.setBlob(1, inputStream);
//		ps.setString(2, "315004");
//		ps.setString(3, "6010");
//		int rs = ps.executeUpdate();
	//	
//		System.out.println("rs= "+rs);
//		condb.commit();
//		System.out.println("After commit");

//		 ps2 =condb.prepareStatement("select * from sbmtopc_android where scno=? and book=?");
		/*ps2.setString(1, scno);
		ps2.setString(2, book);*/
		 ps2 =condb.prepareStatement("select * from sbmtopc_android");

		 rs2=ps2.executeQuery();
		int i=1;
		while(rs2.next()){
			
			//inputStream2=(InputStream) rs2.getBlob("rdg_image");
			Blob b=rs2.getBlob(DbColumn);
			
			
			 if(rowno==i){
			      if(b!=null)
				 inputStream2=b.getBinaryStream();
			    	 }
			      i++;

		}
// delete the loid records--start
		
		 ImageGetting ig=new ImageGetting();
		 	ig.imageDelete(filepath, "img.txt");
		    ig.imageDelete(filepath,imageName);
		
//delete the old records --end
		    
		 ops=new FileOutputStream(new File(filepath+"/img.txt"));
		byte[] bytes = new byte[1024];
		int read = 0;
		while ((read = inputStream2.read(bytes)) != -1) {
			ops.write(bytes, 0, read);
		}
		
		 fis=new FileInputStream(filepath+"/img.txt");
		Scanner s=new Scanner(fis);
		
		while(s.hasNext()){
			imageText=imageText+s.next();	
		}
		//image writing--start
				
					byte[] data1 = Base64.decodeBase64(imageText);
		         /*byte[] data1 = Base64.decodeBase64(arg0)*/
				 	try(OutputStream stream1 = new FileOutputStream(filepath+"/"+imageName)){
				 		 stream1.write(data1);
				 		 
				 		 if(stream1!=null)
				 			 stream1.close();
				 	}catch(Exception e){
				 		
				 	}
				   
				
				//system.out.println("Complted");
				
				
				
				
		       //image writing --end
		
		
	
		
		}catch(NullPointerException e){
			System.out.println(e);
		}
		catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
			if(condb!=null)
				condb.close();
			if(rs2!=null)
				rs2.close();
			if(fis!=null)
				fis.close();
			}catch(Exception e){
				
			}
		}
		return imageText;
	}
	
	
	
   public static void main(String args[]) {
	   ImageGetting img=new ImageGetting();
	   img.FileStoreInBlob("", "", "c:/", "MD", 1);
	   	
		
	}
	}
	
	//extra data --end
	
	
	
 
