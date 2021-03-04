package projekt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcel {

	
	
	public static void test() throws FileNotFoundException {
	File excelFile = new File("Benutzerdaten.xlsx");
	FileInputStream fis = new FileInputStream(excelFile);
	
	
	XSSFWorkbook workbook = new XSSFWorkbook(fis);
	
	XSSFSheet sheet = workbook.getSheetAt("0");
	
	
	
	
	}
	
	
}
