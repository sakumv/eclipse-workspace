import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//import com.sun.rowset.internal.Row;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.NumberToTextConverter;

public class dataDrivenTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		

	}
	public ArrayList<String> getData(String testcaseName, String sheetname) throws IOException 
	{
		
		//Array list to hold list of data and return it to test
		ArrayList<String> arrstr = new ArrayList<String>();
		//Excel -->File -->Sheet --> Row -->Column
		FileInputStream fis = new FileInputStream("C://Users//sakuj//eclipse-workspace//ExcelDataDriven//exceldatadriven.xlsx");
		//Excel
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		//Sheet
		int num = workbook.getNumberOfSheets();
		for (int i =0 ; i < num; i++)
		{
			System.out.println("inside for loop");
			System.out.println(workbook.getSheetName(i));
			if (workbook.getSheetName(i).equalsIgnoreCase(sheetname))
			{
				System.out.println("inside for if");
				//Selected Sheet 
				XSSFSheet sheet = workbook.getSheetAt(i);
				//Get the row of particular column
				
				Iterator<Row> row = sheet.iterator();
				Row firstrow = row.next();
				
				//Row
				Iterator<Cell> col = firstrow.cellIterator();
				int k =0;
				int clmn =0;
				while(col.hasNext())
				{
					//System.out.println("inside while loop");
					Cell val = col.next();
					//column
					if (val.getStringCellValue().equalsIgnoreCase("Testcases"))
					{
						clmn = k;
						System.out.println(clmn);
						break;
					}
					k++;
				}//while
				
				//column reading
				while (row.hasNext())
				{
					Row r = row.next();
					if (r.getCell(clmn).getStringCellValue().equalsIgnoreCase(testcaseName))
					{
						//read the data in that row
						System.out.println(r.getCell(clmn).getStringCellValue());
						Iterator<Cell> targetcol = r.cellIterator();
						while(targetcol.hasNext())
						{
							//Check the value whether it is String or numeric
							Cell tc =  targetcol.next();
							String dataval = "";
							if (tc.getCellType()== CellType.STRING)
								dataval = tc.getStringCellValue();
							else
								dataval = NumberToTextConverter.toText(tc.getNumericCellValue()) ;
							System.out.println(dataval);
							arrstr.add(dataval);
						}
						
					}
				}//while
				break;
			}//if condition for correct sheet
			
			
		}//for loop
		return arrstr;
	}//method getData
	
	
}
