package methods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Se {
	static int ii =0;
	public static void main(String[] args) 
    {
        try
        {
            FileInputStream file = new FileInputStream(new File("C:\\Users\\User\\eclipse-workspace\\PageOmodel\\datasheet\\File.xlsx"));
 
            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);
 
            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);
 
            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            
            while (rowIterator.hasNext()) 
            {
                Row row = rowIterator.next();
               
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();
               
                System.out.println(row.cellIterator());
                
                
                while (cellIterator.hasNext()) 
                {
                	
                	//System.out.println(row.getCell(ii).getStringCellValue());
                	
                    Cell cell = cellIterator.next();
                      
                    }
                System.out.println("-------");
                }
                
                file.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

}
