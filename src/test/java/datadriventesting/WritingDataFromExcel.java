package datadriventesting;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//Excel file-->Workbook-->sheet-->Rows--->cells

public class WritingDataFromExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileOutputStream file=new FileOutputStream(System.getProperty("user.dir")+"\\data\\writing.xlsx"); 
		
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("dynamic1");
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter no of Rows...");
		
		int rows=sc.nextInt();
		
		System.out.println("Enter no of cells...");
		
		int cell=sc.nextInt();
		
		for(int r=0;r<=rows;r++) {
			XSSFRow currentRow=sheet.createRow(r);
			for(int c=0;c<cell;c++) {
				XSSFCell currentCell=currentRow.createCell(c);
				currentCell.setCellValue(sc.next());
			}
			
		}
		
		
		workbook.write(file);
		workbook.close();
		file.close();

	}

}
