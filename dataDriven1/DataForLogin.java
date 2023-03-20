package dataDriven1;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataForLogin {

	public static String data;
	public static String readData(int row, int col) throws IOException {
		
		try {
		FileInputStream file = new FileInputStream("/Users/rajusaru/Desktop/Selenium/DataDriven/Results.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		workbook.setForceFormulaRecalculation(true); // newly added
		XSSFFormulaEvaluator.evaluateAllFormulaCells(workbook);
		
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		XSSFCell cell = sheet.getRow(row).getCell(col);
		
		
		 data = cell.getStringCellValue();
		 
		
		 
		 file.close();
		 workbook.close();
		}
		catch(Exception e) {
			System.out.println("I'm in login Data Catch Block");
		}
		finally{
			System.out.println(data);
			
		}
		return data;
	}	
}
