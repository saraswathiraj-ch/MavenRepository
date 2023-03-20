package dataDriven1;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataForLocators {
	public static String locatorData;
	public static String readLocatorData(int row, int col) throws IOException{
 
		try 
		{
		FileInputStream file = new FileInputStream("/Users/rajusaru/Desktop/Selenium/DataDriven/locators.xlsx");
		XSSFWorkbook excel = new XSSFWorkbook(file);
		XSSFSheet sheet = excel.getSheet("RegisterPageLocators");
		excel.setForceFormulaRecalculation(true); // newly added
		XSSFFormulaEvaluator.evaluateAllFormulaCells(excel);
		
		XSSFCell cell = sheet.getRow(row).getCell(col);
		locatorData = cell.getStringCellValue();
		
		file.close();
		excel.close();
		}
		catch(Exception e)
		{
			System.out.println("I'm in locators data catch block");
		}
		return locatorData;
}

}
