package com.htc.ReadExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Read {
	
		Workbook workbook;
		Sheet loginData;
		Sheet sheet;
		
		public Excel_Read(String excelfilePath) 
		{
			try 
			{
			File file = new File(excelfilePath);
			System.out.println("The file exists"+file.exists());
			FileInputStream fis = new FileInputStream(file);
			workbook = new XSSFWorkbook(fis);
			}
			catch(Exception e) 
			{
			System.out.println(e.getMessage());
			}
		}

		public Object[][] getRecords(String sheetName)
		{
			loginData =workbook.getSheet(sheetName);
			System.out.println(loginData.toString());
			
			int totalNoofRows=loginData.getLastRowNum();
			
			Object[][] records=new Object[totalNoofRows][loginData.getRow(1).getLastCellNum()];
			
			for(int row=0;row<loginData.getLastRowNum();row++)
				{
					for(int col=0;col<loginData.getRow(row+1).getLastCellNum();col++)
					{
						records[row][col]=loginData.getRow(row+1).getCell(col).getStringCellValue();
					}
				}
				return records;
		}
		
		
}
