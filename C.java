package methods;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class C {
	public Map<String, String> putIntoHashmap(String filePath) throws IOException 
	 {
	     FileInputStream inputStream = new FileInputStream(filePath);
	     XSSFWorkbook workbook= new XSSFWorkbook(inputStream);
	     XSSFSheet firstSheet = workbook.getSheetAt(0);
	     
	     Iterator<Row> rowiterator = firstSheet.iterator();
	     
	     HashMap<String,String> map= new HashMap<String, String>();
	     XSSFCell key= null;
	     XSSFCell value= null;
	     
    int noOfColumns = firstSheet.getRow(0).getPhysicalNumberOfCells();
    int rowTotal = firstSheet.getLastRowNum();
    
    //System.out.println(noOfColumns+" rowTotal   : "+rowTotal);
    
    
    for (int col = 0; col <= noOfColumns; col++){
    	 for (int raw = 0; raw <= rowTotal; raw++){
    	    

    		 
    		// System.out.println(firstSheet.getRow(col).getCell(raw));
    		 key = firstSheet.getRow(raw).getCell(col);
    				 //.getStringCellValue();
    		// System.out.println(firstSheet.getRow(col+1).getCell(raw));
    		 value = firstSheet.getRow(raw+1).getCell(col);
    				 //.getStringCellValue();
    		 //map.put
    		 System.out.println(key.getStringCellValue()+"  "+ value.getStringCellValue()); 
    	    }
    	
    }
    
    


  
  return map;
 
	 }
	
	
	
	public static void main(String[] args) throws IOException 
    {
		C rd = new C();
		Map<String, String> data = rd.putIntoHashmap("C:\\Users\\User\\eclipse-workspace\\PageOmodel\\datasheet\\File.xlsx");
		System.out.println(data.get("1dfdf"));
    }
}
