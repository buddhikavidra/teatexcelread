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
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class A {
	static int noOfColumns = 0;
	static int rowTotal = 0;
	static String key = null;
	static String value = null;

	public static Map<String, String> putIntoHashmap(String filePath) throws IOException {
		FileInputStream inputStream = new FileInputStream(filePath);
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet firstSheet = workbook.getSheetAt(0);

		Iterator<Row> rowiterator = firstSheet.iterator();

		HashMap<String, String> map = new HashMap<String, String>();
		noOfColumns = firstSheet.getRow(0).getPhysicalNumberOfCells();
		rowTotal = firstSheet.getLastRowNum();

		/*
		 * while (rowiterator.hasNext()) {
		 * 
		 * Row nextRow = rowiterator.next(); Iterator<Cell> cellIterator =
		 * nextRow.cellIterator(); noOfColumns =
		 * firstSheet.getRow(0).getPhysicalNumberOfCells(); rowTotal =
		 * firstSheet.getLastRowNum();
		 * 
		 * System.out.println(noOfColumns); System.out.println(rowTotal);
		 * 
		 * 
		 * key = nextRow.getCell(0).getStringCellValue(); System.out.println(key); value
		 * = nextRow.getCell(0).getStringCellValue();
		 * 
		 * map.put(key, value);
		 * 
		 * }
		 */
		for (int iteratorraw = 0; iteratorraw < rowTotal; iteratorraw++) {
			System.out.println("0000");
			for (int iteratorColumns = 0; iteratorColumns <= noOfColumns; iteratorColumns++) {

				// System.out.println(firstSheet.getRow(iteratorraw).getCell(iteratorColumns));
				// //return
				// System.out.println(firstSheet.getRow(iteratorraw+1).getCell(iteratorColumns));

				try {
					key = firstSheet.getRow(0).getCell(iteratorColumns).getStringCellValue();
					value = firstSheet.getRow(iteratorraw + 1).getCell(iteratorColumns).getStringCellValue();
					//System.out.println(key + " : "+value);
				} catch (Exception e) {
					key = "null";
					value = "null";
				}
				map.put(key, value);
			}

		}
		System.out.println(map);
		return map;

	}

	// System.out.println(map);
	// return map;

	public static void main(String[] args) throws IOException {
		A rd = new A();
		Map<String, String> data = rd.putIntoHashmap("C:\\Users\\User\\eclipse-workspace\\PageOmodel\\datasheet\\File.xlsx");
		System.out.println(data.get("1dfdf"));
	}

}
