package com.excelFile;

import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;









import com.database.DbConnection;




/*import org.apache.poi.xssf.usermodel.XSSFWorkbook;
*/
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;

import jxl.CellType;

public class ApachePOIExcelRead {

    private static final String FILE_NAME = "/tmp/MyFirstExcel.xlsx";

    public static void main(String[] args) {
    	ApachePOIExcelRead ap=new ApachePOIExcelRead();
    	//ap.ExcelRead4Duplicate();
    	//ap.dataDevoding();
    	
    	
    	DbConnection dbb=new DbConnection();
    	dbb.salaryCalculation();
    }

    	
    	 public	void ExcelRead1(){
    		 
    		 System.out.println(" ia min excel file read1");
    		 /*
        try {

            FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();

            while (iterator.hasNext()) {

                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();

                while (cellIterator.hasNext()) {

                    Cell currentCell = cellIterator.next();
                    //getCellTypeEnum shown as deprecated for version 3.15
                    //getCellTypeEnum ill be renamed to getCellType starting from version 4.0
                    if (currentCell.getCellTypeEnum() == CellType.STRING) {
                        System.out.print(currentCell.getStringCellValue() + "--");
                    } else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
                        System.out.print(currentCell.getNumericCellValue() + "--");
                    }

                }
                System.out.println();

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    */}
    
    
    
    
    
    private  void printCellValue(Cell cell) {
		 System.out.println(" i am in printCellValue");

    	
    	/*
        switch (cell.getCellType()) {
            case BOOLEAN:
                System.out.print(cell.getBooleanCellValue());
                break;
            case STRING:
                System.out.print(cell.getRichStringCellValue().getString());
                break;
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    System.out.print(cell.getDateCellValue());
                } else {
                    System.out.print(cell.getNumericCellValue());
                }
                break;
            case FORMULA:
                System.out.print(cell.getCellFormula());
                break;
            case BLANK:
                System.out.print("");
                break;
            default:
                System.out.print("");
        }

        System.out.print("\t");
    */}
    
    
    
    public  void ExcelRead2() {
		 System.out.println(" i am in ExcelRead2");

        try {
        	
        	  FileInputStream excelFile = new FileInputStream(new File("G:/salarys.xlsx"));

/*          
 * G:/MyFirstExcel.xlsx
*/           
        	Workbook workbook = new XSSFWorkbook("G:/salarys.xlsx");
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();

            while (iterator.hasNext()) {

                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();

                while (cellIterator.hasNext()) {

                    Cell currentCell = cellIterator.next();
                    
                    
                    System.out.println("currentCell= "+currentCell);
                    //my code --start
                   int cell_type = currentCell.getCellType();
                   
                String value=   currentCell.getStringCellValue();
               
                   System.out.println("String value= "+value);
                   System.out.println("cell_type= "+cell_type);
                   System.out.println("hiii  ="+CellType.STRING_FORMULA);
                    //my code --end
                    
                    //getCellTypeEnum shown as deprecated for version 3.15
                    //getCellTypeEnum ill be renamed to getCellType starting from version 4.0
                  /*  if (currentCell.getCellType() == CellType.STRING) {
                        System.out.print(currentCell.getStringCellValue() + "--");
                    } else if (currentCell.getCellType() == CellType.NUMERIC) {
                        System.out.print(currentCell.getNumericCellValue() + "--");
                    }*/

                }
                System.out.println();

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    
    public  void ExcelRead3() {
		 System.out.println(" i am in ExcelRead3");

    	InputStream inp = null;
        try {
            inp = new FileInputStream("G:/KESCO Employees Salaries Dec-2017-F.xls");

            Workbook wb = WorkbookFactory.create(inp);
            Sheet sheet = wb.getSheetAt(0);
            Header header = sheet.getHeader();

            
            
            //new code start
            
            Iterator<Row> iterator = sheet.iterator();

            while (iterator.hasNext()) {

                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();

                while (cellIterator.hasNext()) {

                    Cell currentCell = cellIterator.next();
                    
                    
//                    System.out.println("currentCell= "+currentCell);
                    //my code --start
                   int cell_type = currentCell.getCellType();
                   
                String value=   currentCell.getStringCellValue();
               
//                   System.out.println("String value= "+value);
                System.out.println();
                System.out.println("********************************");
                System.out.println();
                   System.out.println("cell_type= "+cell_type);
                  
                  try{
                   System.out.println("getArrayFormulaRange value= "+currentCell.getArrayFormulaRange());
                  }catch(Exception e){}
                  try{
                   System.out.println("getStringCellValue value= "+currentCell.getStringCellValue());
                  }catch(Exception e){}
                  try{
                   System.out.println("getBooleanCellValue value= "+ currentCell.getBooleanCellValue());
                  }catch(Exception e){}
                  try{
                   System.out.println("getCachedFormulaResultType value= "+currentCell.getCachedFormulaResultType());
                  }catch(Exception e){}
                  try{
                   System.out.println("getCellComment value= "+ currentCell.getCellComment());
                  }catch(Exception e){}
                  try{
                   System.out.println("getCellFormula value= "+ currentCell.getCellFormula());
                  }catch(Exception e){}
                  try{
                   System.out.println("getCellStyle value= "+ currentCell.getCellStyle());
                  }catch(Exception e){}
                  try{
                   System.out.println("getCellType value= "+ currentCell.getCellType());
                  }catch(Exception e){}
                  try{
                   System.out.println("getClass value= "+ currentCell.getClass());
                  }catch(Exception e){}
                  try{
                   System.out.println("getDateCellValue value= "+ currentCell.getDateCellValue());
                  }catch(Exception e){}
                  try{
                   System.out.println("getCachedFormulaResultType value= "+ currentCell.getCachedFormulaResultType());
                  }catch(Exception e){}
                  try{
                   System.out.println("getErrorCellValue value= "+ currentCell.getErrorCellValue());
                  }catch(Exception e){}
                  try{
                   System.out.println("getHyperlink value= "+ currentCell.getHyperlink());
                  }catch(Exception e){}
                  try{
                   System.out.println("getNumericCellValue value= "+ currentCell.getNumericCellValue());
                  }catch(Exception e){}
                  try{
                   System.out.println("getRichStringCellValue value= "+ currentCell.getRichStringCellValue());
                  }catch(Exception e){}
                  

                   
                  /* if(cell_type==1){
                	 cell_value=  currentCell.getStringCellValue();
                   }else if(cell_type==2){
                	   
                	   cell_value=  currentCell.
                   }else if(cell_type==3){
                	   cell_value=  currentCell.getStringCellValue();
                   }else if(cell_type==4){
                	   cell_value=  currentCell.getStringCellValue();
                   }else if(cell_type==64){
                	   cell_value=  currentCell.getStringCellValue();
                   }else if(cell_type==1){
                	   
                   }*/
                   
                   
                   
                   
                   
                   
                   
                   
                    //my code --end
                    
                    //getCellTypeEnum shown as deprecated for version 3.15
                    //getCellTypeEnum ill be renamed to getCellType starting from version 4.0
                  /*  if (currentCell.getCellType() == CellType.STRING) {
                        System.out.print(currentCell.getStringCellValue() + "--");
                    } else if (currentCell.getCellType() == CellType.NUMERIC) {
                        System.out.print(currentCell.getNumericCellValue() + "--");
                    }*/

                }
                System.out.println();

            }
            
            
            //new code start
            
            
         /*   
            int rowsCount = sheet.getLastRowNum();
            System.out.println("Total Number of Rows: " + (rowsCount + 1));
            for (int i = 0; i <= rowsCount; i++) {
                Row row = sheet.getRow(i);
                int colCounts = row.getLastCellNum();
                System.out.println("Total Number of Cols: " + colCounts);
                for (int j = 0; j < colCounts; j++) {
                    Cell cell = row.getCell(j);
                    System.out.println("[" + i + "," + j + "]=" + cell.getStringCellValue());
                }
            }*/

        } catch (Exception ex) {
        	ex.printStackTrace();
//            java.util.logging.Logger.getLogger(FieldController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                inp.close();
            } catch (IOException ex) {
            	    ex.printStackTrace();
//                java.util.logging.Logger.getLogger(FieldController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        System.out.println("completed");
    	
    }
    
    
    
    public  void ExcelRead4() {
    	
		 System.out.println(" i am in ExcelRead4");

    	try{
//    	InputStream inp =getClass().getResourceAsStream("G:/KESCO Employees Salaries Dec-2017-F.xls");
    	
    		InputStream inp = new FileInputStream("G:/KESCO Employees Salaries Dec-2017-F.xls");
    	Workbook wb = WorkbookFactory.create(inp);
    	DataFormatter objDefaultFormat = new DataFormatter();
    	FormulaEvaluator objFormulaEvaluator = new HSSFFormulaEvaluator((HSSFWorkbook) wb);

    	Sheet sheet= wb.getSheetAt(1);
    	Iterator<Row> objIterator = sheet.rowIterator();

    	while(objIterator.hasNext()){

    	    Row row = objIterator.next();
    	    Cell cellValue = row.getCell(1);
    	    objFormulaEvaluator.evaluate(cellValue); // This will evaluate the cell, And any type of cell will return string value
    	    String cellValueStr = objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator);

    	    System.out.println("cellValueStr= "+cellValueStr);
    	    
    	}
    	
    	System.out.println("completed");
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
    
    
    
    public  void ExcelRead4Duplicate() {
    	
		 System.out.println(" i am in ExcelRead4Duplicate");

    	try{
//    	InputStream inp =getClass().getResourceAsStream("G:/KESCO Employees Salaries Dec-2017-F.xls");
    	
    		InputStream inp = new FileInputStream("G:/Salary Sheet.xls");
    	Workbook wb = WorkbookFactory.create(inp);
    	DataFormatter objDefaultFormat = new DataFormatter();
    	FormulaEvaluator objFormulaEvaluator = new HSSFFormulaEvaluator((HSSFWorkbook) wb);

    	Sheet sheet= wb.getSheetAt(0);
    	Iterator<Row> objIterator = sheet.rowIterator();
    	
    	
    	Iterator<Row> iterator = sheet.iterator();
    	
    	
    	ArrayList<String> list = new ArrayList<String>();
    	DbConnection db=new DbConnection();
         int Bills_Qty_total=0;
    	
    	int i=1;
    	  while (iterator.hasNext()) {
//System.out.println("row number= "+i);
              Row currentRow = iterator.next();
              Iterator<Cell> cellIterator = currentRow.iterator();
              Cell currentCell =null;
              
            String   SL_No=null;
            String   EMP_NAME=null;
            String	 Designation=null;	
            String   Division=null;
            int	 Bills_Qty=0;
            String   Rate=null;
            String   Total=null;
              
              
              int J=1;
              while (cellIterator.hasNext()) {
            	  currentCell =null;
                   currentCell = cellIterator.next();
                  
                   String cellValueStr = null;
                   double cellValueStr_int =0.0;
                  try{
                  objFormulaEvaluator.evaluate(currentCell);
            	     cellValueStr = objDefaultFormat.formatCellValue(currentCell,objFormulaEvaluator);
//            	    System.out.println("cellValueStr= "+cellValueStr);
            	    //data variation--start
            	    
            	    
            	    //data variation--end
                  }catch(Exception e){
                	  
                	 // System.out.println("cellValueStr= "+cellValueStr);
                	 
                	  cellValueStr_int = currentCell.getNumericCellValue();
                	//  System.out.println("cellValueStr_int= "+cellValueStr_int);
                	  
                	   //data variation--start
                	   //data variation--end
                  }
                  // This will evaluate the cell, And any type of cell will return string value
                  
               
               
                 if(J==1)
                	 SL_No=cellValueStr;
                 else if(J==2)
                	 	EMP_NAME=cellValueStr;
                	 else if(J==3)
                		 	Designation=cellValueStr;
                		 else if(J==4)
                			 	Division=cellValueStr;
                			 else if(J==5){
                				 try{
                	            	 if(cellValueStr==null){
                	            	 double d = 9.5;
                	            	 Long L = Math.round(cellValueStr_int);
                	            	  Bills_Qty = Integer.valueOf(L.intValue());
                	            	  
                	            	  
                	            	 }else{
                	            		 
                	            		 System.out.println("cellValueStr= "+cellValueStr);
                	            		 Bills_Qty=Integer.parseInt(cellValueStr);
                	            	 }
                	            	 
                	            	 Bills_Qty_total=Bills_Qty_total+Bills_Qty;
               	            	// System.out.println("Bills_Qty= "+Bills_Qty);
                			 }catch(Exception ee){
                				 Bills_Qty=0;
                			 }
                			 }
                			 else if(J==6)	           
                				 	Rate=cellValueStr;
                			 else if(J==7){
                	               Total=cellValueStr;
                			 }
                // System.out.println("Bills_Qty= "+Bills_Qty);
                  J++;
              }
              
              System.out.println(EMP_NAME+", "+Division+", "+Designation+","+Bills_Qty+", "+Rate+", "+Total);
              
         	try{
         		
         		String Query="INSERT INTO VAIBHU_REDERS_MONTHLY_BILLS (EMP_NAME, DIVISION, DESIGNATION,BILL_QTY,RATE,TOTAL)"
                        + "VALUES ('"+EMP_NAME+"', '"+Division+"', '"+Designation+"','"+Bills_Qty+"', '"+Rate+"', '"+Total+"')";
          
         		System.out.println(Query);
             
         		/*boolean status = db.status(Query);
         		System.out.println("status= "+status);*/
         		
         		
         		
         		//data insertion to databse--start
         		
         		
         		String DriverClass="oracle.jdbc.driver.OracleDriver";
         		String url="jdbc:oracle:thin:@localhost:1521:orcl";
         		String username="agrabo";
         		String password="agrabo";
        		

        		Connection conn=null;
        		PreparedStatement ps=null;
        		ResultSet rs=null; 
        		try{
        			//int rowno1=Integer.parseInt(rowno)
        		
        		
        		String scno=null;
        		String book=null;
        		
        		/*DbConnection db1=new DbConnection();
        		//DataBase db=new DataBase();
        	    conn=db1.getConnObject();*/
        		
        		try{
        			
        			Class.forName(DriverClass);
        			
        			conn = DriverManager.getConnection(url,username,password);
        			
        			
        			
        			}catch(Exception e)
        			{
        				e.printStackTrace();
        			}
        		
        		
        		
        	    ps = conn.prepareStatement(Query);
        	    int val = ps.executeUpdate();
        	   
        	    System.out.println("val= "+val);

        	}catch(Exception ee)
        	{
        		ee.printStackTrace();
        	} finally
            {
          	  if (conn != null) {
          	        try
          	        {
          	        	
          	        	conn.commit();
          	        	 if (rs != null)
          	  	        	rs.close();
          	        	if (ps != null)
          	  	        	ps.close();
          	        	
          	        if (conn != null){
          	        	
          	        	
          	        	conn.commit();
          	        
          	          conn.close();
          	       
          	           	        
          	        }
          	       
          	        }catch(Exception e){
          	        	e.printStackTrace();
          	        }
          	  }
          }

         		
         		// data insertion to data base --end
         		
         		}catch(Exception e){
				 e.printStackTrace();
         			}
              
          //    System.out.println("-------------------------------");
              i++;
    	  }
    	
    	  System.out.println("bills qty= "+Bills_Qty_total);

//    	while(objIterator.hasNext()){
//
//    	    Row row = objIterator.next();
//    	    Cell cellValue = row.getCell(1);
//    	    objFormulaEvaluator.evaluate(cellValue); // This will evaluate the cell, And any type of cell will return string value
//    	    String cellValueStr = objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator);
//
//    	    System.out.println("cellValueStr= "+cellValueStr);
//    	    
//    	}
    	
    	
    	
    	
    	
    	System.out.println("completed");
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
    
    
    public void dataDevoding(){
    	
    	// the line below
    	//\u000d System.out.println("hiii");
    	
    }
    
   
    
}