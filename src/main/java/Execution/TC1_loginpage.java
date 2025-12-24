package Execution;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Allpages.loginPage;

public class TC1_loginpage extends loginPage {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException 
	{
		
		String emailid = "";

		String password = "";

		String path = "D:\\test data.xlsx";
		
		FileInputStream fs = new FileInputStream(path);

		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		
		XSSFSheet sheet=	workbook.getSheet("test data");
		
		int rows = sheet.getLastRowNum();
		
		for(int i=1;i<=rows;i++)
		{
			emailid=	sheet.getRow(i).getCell(0).getStringCellValue();
			password=	sheet.getRow(i).getCell(1).getStringCellValue();
			browserInitzation();
			
			login(loginPage.getInputEmail(),loginPage.getinputpassword(),loginPage.getlogin(),emailid,password);
			
			int cellCount = sheet.getRow(i).getLastCellNum();
			
			XSSFCell cell = sheet.getRow(i).createCell(cellCount);
		String	getactualtitle="Welcome to home page";//driver.gettitle();
			
			if("Welcome to home pag".equals(getactualtitle))
			{
				cell.setCellValue("pass");
			}
			else
			{
			
			cell.setCellValue("fail");
			}
			browser_close();
			
		}
		fs.close();



		FileOutputStream fout = new FileOutputStream(path);
		
		workbook.write(fout);

		fout.close();
	
	}

}
