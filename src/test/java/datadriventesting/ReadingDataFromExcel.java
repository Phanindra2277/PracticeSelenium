package datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//Excel File--> Workbook--> Sheet--> Rows---> Cell.
public class ReadingDataFromExcel {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\data\\data.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		
		int totalrows=sheet.getLastRowNum();
		int totalcell=sheet.getRow(0).getLastCellNum();
		
		//System.out.println(totalrows+" "+totalcell);
		
		for(int r=0;r<=totalrows;r++) {
			XSSFRow row=sheet.getRow(r);
			
			for(int c=0;c<totalcell;c++) {
				XSSFCell cell=row.getCell(c);
				System.out.print(cell.toString()+"\t");
				
			}
			System.out.println();
		}
		workbook.close();
		file.close();
		

	}

}
