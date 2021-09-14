package methods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Base {

	public static String ExcelSheetName = "C:\\Users\\User\\eclipse-workspace\\PageOmodel\\datasheet\\File.xlsx";
	public static FileInputStream fis;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;

	public static void loadExcel() {

		System.out.println("Load Excel Sheet.........");
		File file = new File(ExcelSheetName);

		try {
			fis = new FileInputStream(file);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet("Sheet1");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Map<String, Map<String, String>> getDataMap() {
		if (sheet == null) {
			loadExcel();
		}

		Map<String, Map<String, String>> parentMap = new HashMap<String, Map<String, String>>();
		Map<String, String> childMap = new HashMap<String, String>();

		Iterator<Row> rowIterator = sheet.iterator();

		while (rowIterator.hasNext()) {

			Row row = rowIterator.next();
			childMap.put(row.getCell(0).getStringCellValue(), row.getCell(1).getStringCellValue());

		}

		parentMap.put("MASTERDATA", childMap);

		return parentMap;

	}

	public static String getValue(String key) {
		Map<String, String> mapValue = getDataMap().get("MASTERDATA");
		String retValue = mapValue.get(key);

		return retValue;
	}

	public static void main(String[] args) {
		System.out.println(getValue("aaa"));
	}

	
	  void aa(String filepath) throws IOException{
	  
	  //Path of the excel file
	//  "C:\\Users\\User\\eclipse-workspace\\PageOmodel\\datasheet\\File.xlsx"
	  FileInputStream fs = new FileInputStream(filepath); //Creating a workbook
	  
	  XSSFWorkbook workbook = new XSSFWorkbook(fs); 
	  XSSFSheet sheet = workbook.getSheetAt(0); 
	  Row row = sheet.getRow(0); 
	  Cell cell =row.getCell(0);
	  System.out.println(sheet.getRow(0).getCell(0)); //return
	// filepath;
	
	}
	 

}
