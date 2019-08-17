package com.excelFile;

import org.apache.poi.hssf.record.cf.PatternFormatting;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.xmlbeans.XmlException;

import com.database.DbConnection;
public class ApachePOIExcelWrite {

    private static final String FILE_NAME = "G:/MyFirstExcel.xlsx";

   
    
    public void excelGeneration(){

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Datatypes in Java");
        
        
      /* // sheet.addMergedRegion(new CellRangeAddress(rowFrom,rowTo,colFrom,colTo));
         sheet.addMergedRegion(new CellRangeAddress(1,1,1,22));
         sheet.addMergedRegion(new CellRangeAddress(2,2,5,6));
         sheet.addMergedRegion(new CellRangeAddress(2,2,7,9));
         sheet.addMergedRegion(new CellRangeAddress(2,2,10,13));
         sheet.addMergedRegion(new CellRangeAddress(2,2,14,19));*/
        
        /* //style setting start
   //-----------------------------------------------------------------------------------------      
          Font font = sheet.getWorkbook ().createFont ();
         font.setFontName ( "Arial" );
         Short x=18;
         font.setFontHeightInPoints(x);
         font.setBoldweight ( Font.BOLDWEIGHT_BOLD );
         font.setColor ( HSSFColor.BLACK.index );
       

          CellStyle style = sheet.getWorkbook ().createCellStyle ();
         style.setFont ( font );
         style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
         style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
         style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
         style.setBorderRight(HSSFCellStyle.BORDER_THIN);
         style.setBorderTop(HSSFCellStyle.BORDER_THIN);
         
  //-----------------------------------------------------------------------------------------
         Font font2 = sheet.getWorkbook ().createFont ();
         font2.setFontName ( "Arial" );
//         font2.setBoldweight ( Font.BOLDWEIGHT_BOLD );
         font2.setColor ( HSSFColor.BLACK.index );
         
         CellStyle style2 = sheet.getWorkbook ().createCellStyle ();
         style2.setFont ( font2 );
         style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
         style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
         style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
         style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
         style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
    //-----------------------------------------------------------------------------------------
       
       
         Font font3 = sheet.getWorkbook ().createFont ();
         font3.setFontName ( "Arial" );
         Short y=16;
         font3.setFontHeightInPoints(y);
         font3.setBoldweight ( Font.BOLDWEIGHT_BOLD );
         font3.setColor ( HSSFColor.DARK_BLUE.index );
        
         
         CellStyle style3 = sheet.getWorkbook ().createCellStyle ();
         style3.setFont ( font3 );
//         style3.setFillPattern ( PatternFormatting.BRICKS );
         style3.setFillBackgroundColor(y);
         style3.setAlignment(HSSFCellStyle.ALIGN_CENTER);
         style3.setBorderLeft(HSSFCellStyle.BORDER_THIN);
         style3.setBorderBottom(HSSFCellStyle.BORDER_THIN);
         style3.setBorderRight(HSSFCellStyle.BORDER_THIN);
         style3.setBorderTop(HSSFCellStyle.BORDER_THIN);
         
  //----------------------------------------------------------------------------------------- 
         
         
         Font font4 = sheet.getWorkbook ().createFont ();
         font4.setFontName ( "Arial" );
         Short l=12;
         font4.setFontHeightInPoints(y);
         font4.setBoldweight ( Font.BOLDWEIGHT_BOLD );
         font4.setColor ( HSSFColor.BROWN.index );
        
         
         CellStyle style4 = sheet.getWorkbook ().createCellStyle ();
         style4.setFont ( font4 );
//         style4.setFillPattern ( PatternFormatting.BRICKS );
         style4.setFillBackgroundColor(y);
         style4.setAlignment(HSSFCellStyle.ALIGN_CENTER);
         style4.setBorderLeft(HSSFCellStyle.BORDER_THIN);
         style4.setBorderBottom(HSSFCellStyle.BORDER_THIN);
         style4.setBorderRight(HSSFCellStyle.BORDER_THIN);
         style4.setBorderTop(HSSFCellStyle.BORDER_THIN);
         
  //----------------------------------------------------------------------------------------- 
         
         
         
         
         
         
         
         //  style.setFillPattern ( PatternFormatting.SOLID_FOREGROUND );
         
         // style setting end
*/         
         Row row = sheet.createRow(1);
         Cell cell = row.createCell(1);
              cell.setCellValue((String)  "Salary Details of KESCO December 2017");
//              cell.setCellStyle(style);
         
         for(int i=2;i<=22;i++){
         cell = row.createCell(i);
//         cell.setCellStyle(style);
         }
         
          row = sheet.createRow(2);
          
          for(int i=0;i<=4;i++){
          cell = row.createCell(i);
//          cell.setCellStyle(style3);
          }
          
          cell = row.createCell(5);
          cell.setCellValue((String)  "");
//          cell.setCellStyle(style3);
          
          cell = row.createCell(6);
//          cell.setCellStyle(style3);
         
          cell = row.createCell(7);
         cell.setCellValue((String)  "Salary");
//         cell.setCellStyle(style3);
         
         cell = row.createCell(8);
//         cell.setCellStyle(style3);
         
         cell = row.createCell(9);
//         cell.setCellStyle(style3);
         
         
          cell = row.createCell(10);
         cell.setCellValue((String)  "Employee Deductions");
//         cell.setCellStyle(style3);
         
         
         cell = row.createCell(11);
//         cell.setCellStyle(style3);
         
         cell = row.createCell(12);
//         cell.setCellStyle(style3);
         
         cell = row.createCell(13);
//         cell.setCellStyle(style3);
         
         cell = row.createCell(14);
        cell.setCellValue((String)  "Employer Contribution");
//        cell.setCellStyle(style3);
        
        
        for(int i=15;i<=22;i++){
            cell = row.createCell(i);
//            cell.setCellStyle(style3);
            }
        
        
        
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
        
        DbConnection db=new DbConnection();
       
        
      String[][] datatypes = db.salaryCalculation();
        
        int rowNum = 3;
        System.out.println("Creating excel");

      for (Object[] datatype : datatypes) {
             row = sheet.createRow(rowNum++);
            int colNum = 0;
            for (Object field : datatype) {
                 cell = row.createCell(colNum++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                    
//                    if(rowNum==4)
//                        cell.setCellStyle(style4);
//                        else
//                        	cell.setCellStyle(style2);
                    
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                    
                    /*if(rowNum==4)
                    cell.setCellStyle(style4);
                    else
                    	cell.setCellStyle(style2);*/
                    
                   
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
    	 
    	 ApachePOIExcelWrite ap=new ApachePOIExcelWrite();
    	 ap.excelGeneration();
     }
}