package com.crm.comcast.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author Hemant
 *
 */
public class fileutilityexel {
	/**
	 * 
	 * @param Sheet
	 * @param row
	 * @param cell
	 * @return the value in the form of String
	 * @throws Throwable
	 */
	public String getexelData(String Sheet,int row,int cell) throws Throwable {
		FileInputStream fis=new FileInputStream("./data/testData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String val = wb.getSheet(Sheet).getRow(row).getCell(cell).getStringCellValue();
		
		
		FileOutputStream fos=new FileOutputStream("./data/testData.xlsx");
		wb.write(fos);
		wb.close();
		return val;
		
	}

}
