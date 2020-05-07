package excel_reader;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.*;

public class ExcelData {
	
	private FileInputStream fi;
	private Workbook wb;
	private Sheet sh;
	
	public ExcelData()
	{
		try
		{
		fi = new FileInputStream("Data.xlsx");
		wb = WorkbookFactory.create(fi);
		sh= wb.getSheet("Sheet1"); 
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

	@DataProvider(name="ExcelData")
	public Object[][] method2()
	{
		int nour = sh.getPhysicalNumberOfRows();  
		System.out.println("No. of used rows = "+nour);
		int nouc = sh.getRow(0).getLastCellNum(); 
		System.out.println("No. of used columns = "+nouc);
		Object[][] data = new Object[nour-1][nouc]; // 2D array
		for(int i=1; i<nour; i++)
		{
			Row row = sh.getRow(i);
			for(int j=0;j<nouc;j++)
			{
				Cell cell = row.getCell(j);
				String value;
				DataFormatter format = new DataFormatter();
				value = format.formatCellValue(cell);
				data[i-1][j]=value; // 1st row in excel to 0th row in array
			}
		}
		try
		{
		fi.close();
		wb.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return data;
	}
}