package dataDriven1;



import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;


//import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteRegisterDataIntoExcel{
	
public static void WriteData(int rowNo, int cellNo, String input) throws IOException 
{
	//System.out.println("Row: "+rowNo +" Cell: "+ cellNo +" Data: "+ input);
	try
	{
	FileInputStream inputStream = new FileInputStream("/Users/rajusaru/Desktop/Selenium/DataDriven/Results.xlsx");
    XSSFWorkbook workbook = (XSSFWorkbook) WorkbookFactory.create(inputStream);
    XSSFSheet newsheet = workbook.getSheetAt(0);
    XSSFCell newcell = newsheet.getRow(rowNo).createCell(cellNo);
    newcell.setCellValue(input);
    FileOutputStream outputStream = new FileOutputStream("/Users/rajusaru/Desktop/Selenium/DataDriven/Results.xlsx");
    workbook.write(outputStream);
    inputStream.close();
    workbook.close();
    outputStream.close();
    
    System.out.println("Status Data had been written");
	
	}

	catch(Exception e)
	{
	System.out.println("I'm in write data catch block");
	}
	

}
}