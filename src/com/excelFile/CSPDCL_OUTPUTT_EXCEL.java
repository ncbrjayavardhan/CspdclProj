package com.excelFile;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.database.DbConnection;

public class CSPDCL_OUTPUTT_EXCEL {

    private static final String FILE_NAME = "C:/output.xlsx";

   
    
    public void excelGeneration(){

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Datatypes in Java");
        
        
         Row row = sheet.createRow(1);
         Cell cell = row.createCell(1);
 
        
       /* Object[][] datatypes = {
                {"Datatype", "Type", "Size(in bytes)"},
                {"int", "Primitive", 2},
                {"float", "Primitive", 4},
                {"double", "Primitive", 8},
                {"char", "Primitive", 1},
                {"String", "Non-Primitive", "No fixed size"}
        };*/

        
        
      /*  Object[][] datatypes = {
                {"Name of the Employee",	"Name as per Bank",	"Division"	,"Designation"	,"Month Days",	"No of Days Present",	"Basic",	"V.D.A",	"Earning / Gross", "salary"	,"TDS",	"PF(12% Basic)"	,"PT"	,"ESI",	"ESI"	,"PF (8.33% Basic)"	,"PF (Diff of 12%-8.33%)",	"PF (0.65% Basic)"	,"PF (0.5% Basic)",	"PF (0.01% Basic)",	"Advances"	,"Total Deduct"	,"Net Salary"},
                {"int", "Primitive", 2},
                {"float", "Primitive", 4},
                {"double", "Primitive", 8},
                {"char", "Primitive", 1},
                {"String", "Non-Primitive", "No fixed size"}
        };*/
        
        /*DbConnection db=new DbConnection();*/
       
        CSPDCL_OUTPUTT_EXCEL_DATABASE co=new CSPDCL_OUTPUTT_EXCEL_DATABASE();
//      String[][] datatypes = db.salaryCalculation();
        String[][] datatypes = co.CSPDCL_EXCEL_DATA();

        System.out.println("length= "+datatypes.length);
        System.out.println("array= "+datatypes);

        int rowNum = 0;
        System.out.println("Creating excel");

      for (Object[] datatype : datatypes) {
             row = sheet.createRow(rowNum++);
            int colNum = 0;
            for (Object field : datatype) {
            	System.out.println(field);
                 cell = row.createCell(colNum++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                    
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                    
                   
                   
                }
            }
        }

        try {
            FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
            workbook.write(outputStream);
//            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Done");
    }
    
    
    public void excelGeneration2(String Query){

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Datatypes in Java");
        
        
         Row row = sheet.createRow(1);
         Cell cell = row.createCell(1);
 
        
       /* Object[][] datatypes = {
                {"Datatype", "Type", "Size(in bytes)"},
                {"int", "Primitive", 2},
                {"float", "Primitive", 4},
                {"double", "Primitive", 8},
                {"char", "Primitive", 1},
                {"String", "Non-Primitive", "No fixed size"}
        };*/

        
        
      /*  Object[][] datatypes = {
                {"Name of the Employee",	"Name as per Bank",	"Division"	,"Designation"	,"Month Days",	"No of Days Present",	"Basic",	"V.D.A",	"Earning / Gross", "salary"	,"TDS",	"PF(12% Basic)"	,"PT"	,"ESI",	"ESI"	,"PF (8.33% Basic)"	,"PF (Diff of 12%-8.33%)",	"PF (0.65% Basic)"	,"PF (0.5% Basic)",	"PF (0.01% Basic)",	"Advances"	,"Total Deduct"	,"Net Salary"},
                {"int", "Primitive", 2},
                {"float", "Primitive", 4},
                {"double", "Primitive", 8},
                {"char", "Primitive", 1},
                {"String", "Non-Primitive", "No fixed size"}
        };*/
        
        /*DbConnection db=new DbConnection();*/
       
        CSPDCL_OUTPUTT_EXCEL_DATABASE co=new CSPDCL_OUTPUTT_EXCEL_DATABASE();
//      String[][] datatypes = db.salaryCalculation();
        String[][] datatypes = co.CSPDCL_EXCEL_DATA2(Query);

        
        int rowNum = 0;
        System.out.println("Creating excel");

      for (Object[] datatype : datatypes) {
             row = sheet.createRow(rowNum++);
            int colNum = 0;
            for (Object field : datatype) {
                 cell = row.createCell(colNum++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                    
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                    
                   
                   
                }
            }
        }

        try {
            FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
            workbook.write(outputStream);
//            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Done");
    }

    
     public static void main(String[] args) {
    	 
    	 CSPDCL_OUTPUTT_EXCEL cs=new CSPDCL_OUTPUTT_EXCEL();
    	 cs.excelGeneration();
     }
}
