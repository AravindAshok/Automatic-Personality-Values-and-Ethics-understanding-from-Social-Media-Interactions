import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFCell;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.io.*;
import java.util.*;


public class pvq {

    @SuppressWarnings("unchecked")
    
    
    public static void main(String[] args) throws Exception {
        //
        // An excel file name. You can create a file name with a full path
        // information.
        //
        String filename = "/home/syamkumar/Desktop/Assignment_Quotes_M-Turk.xls";

        //
        // Create an ArrayList to store the data read from excel sheet.
        //
        List sheetData = new ArrayList();

        FileInputStream fis = null;
        try {
            //
            // Create a FileInputStream that will be use to read the excel file.
            //
            fis = new FileInputStream(filename);

            //
            // Create an excel workbook from the file system.
            //
            HSSFWorkbook workbook = new HSSFWorkbook(fis);
            //
            // Get the first sheet on the workbook.
            //
            HSSFSheet sheet = workbook.getSheetAt(0);

            //
            // When we have a sheet object in hand we can iterator on each
            // sheet's rows and on each row's cells. We store the data read
            // on an ArrayList so that we can printed the content of the excel
            // to the console.
            //
            Iterator rows = sheet.rowIterator();
            while (rows.hasNext()) {
                HSSFRow row = (HSSFRow) rows.next();
                Iterator cells = row.cellIterator();

                List data = new ArrayList();
                while (cells.hasNext()) {
                    HSSFCell cell = (HSSFCell) cells.next();
                    data.add(cell);
                }

                sheetData.add(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                fis.close();
            }
        }

        showExelData(sheetData);
    }
  
    
    private static void showExelData(List sheetData) {
        //
        int[][] pvq_ans_val = new int[860][40];

        // Iterates the data and print it out to the console.
        //
    	System.out.println("sheetData:");
    	System.out.println(sheetData.size());
    	/*
        for (int i = 0; i < sheetData.size(); i++) {
            List list = (List) sheetData.get(i);
            for (int j = 10; j < list.size(); j++) {
            	
                HSSFCell cell = (HSSFCell) list.get(j);
                System.out.print(cell.getRichStringCellValue().getString());
                
                if (j < list.size() - 1) {
                    System.out.print(", ");
                }
                                                   }
                 System.out.println("");
             }*/
      int col;
      String comment;
        for (int i = 1; i < sheetData.size(); i++) {
            List list	 = (List) sheetData.get(i);
            for (int j = 11; j < list.size(); j++) {
            	
            	//System.out.println(j);
            	
                HSSFCell cell = (HSSFCell) list.get(j);
                comment = cell.getRichStringCellValue().getString().trim();

                col=j-11;
                if(comment.equals("Like me"))
                {
                	pvq_ans_val[i][col]=5;
                }
                if(comment.equals("Not Like me at all"))
                {
                	pvq_ans_val[i][col]=1;
                }
                if(comment.equals("Some-what like me"))
                {
                	pvq_ans_val[i][col]=4;
                }
                if(comment.equals("A little like me"))
                {
                	pvq_ans_val[i][col]=3;
                }
                if(comment.equals("Very much like me"))
                {
                	pvq_ans_val[i][col]=6;
                }
                if(comment.equals("Not Like me"))
                {
                	pvq_ans_val[i][col]=2;
                }
                if(comment.equals(null))
                {
                	pvq_ans_val[i][col]=3;
                }
                
                //System.out.print(comment);
                
                if (j < list.size() - 1) {
                    //System.out.print(", ");
                }
                                                   }
                 //System.out.println("");
             }
        
        for (int s = 1; s < sheetData.size(); s++) {
            for (int p = 0; p <40; p++) {
            	System.out.println(pvq_ans_val[s][p]);
            }
            System.out.println('\n');
        }
        
        
    	
             }//showExelData method  closing
     
}//pvq class close
