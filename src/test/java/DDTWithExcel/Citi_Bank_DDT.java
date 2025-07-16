package DDTWithExcel;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Citi_Bank_DDT {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		//Intilazieing the web driver
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		String filePath=System.getProperty("user.dir")+"\\data\\caldata2.xlsx"; //Getting the file Path
		
		int rows=ExcelUtils.getRowCount(filePath,"Sheet1");  //getting row count from the excel utils file
		System.out.println(rows);
		
		for (int r=1;r<=rows;r++) {
			//System.out.println(r);
			
			String depAmt=ExcelUtils.getCellData(filePath, "Sheet1", r, 0);
			String noMonth=ExcelUtils.getCellData(filePath, "Sheet1", r, 1);
			String interestRate=ExcelUtils.getCellData(filePath, "Sheet1", r, 2);
			String compounding=ExcelUtils.getCellData(filePath, "Sheet1", r, 3);
			String expTotal=ExcelUtils.getCellData(filePath, "Sheet1", r, 4);
			String result=ExcelUtils.getCellData(filePath, "Sheet1", r, 6);
					
					
					
			WebElement intialDepAmt=driver.findElement(By.xpath("//input[@id='mat-input-0']"));
			intialDepAmt.clear();
			intialDepAmt.sendKeys(depAmt);
			
			WebElement cd_Months=driver.findElement(By.xpath("//input[@id='mat-input-1']"));
			cd_Months.clear();
			cd_Months.sendKeys(noMonth);
			
			WebElement rateOfInterest=driver.findElement(By.xpath("//input[@id='mat-input-2']"));
			rateOfInterest.clear();
			rateOfInterest.sendKeys(interestRate);
			
			driver.findElement(By.xpath("//mat-select[@id='mat-select-0']")).click();
			
			List<WebElement> options=driver.findElements(By.xpath("//div[@id='mat-select-0-panel']//mat-option"));
			
			for(WebElement opt:options) {
				if(opt.getText().equals(compounding)) {
					opt.click();
				}
			}
			
			
			
			driver.findElement(By.xpath("//button[@id='CIT-chart-submit']")).click();
			
			//Validation
			
			String actTotal=driver.findElement(By.xpath("//span[@id='displayTotalValue']")).getText();
			
			if(expTotal.equals(actTotal)) {
				System.out.println("TestPassed");
				ExcelUtils.setCellData(filePath, "Sheet1", r, 6, "Passed");
				ExcelUtils.fillGreenColor(filePath, "Sheet1", r, 6);
			}else {
				System.out.println("TestFailed");
				ExcelUtils.setCellData(filePath, "Sheet1", r, 6, "Failed");
				ExcelUtils.fillRedColor(filePath, "Sheet1", r, 6);
			}
				
		
		}
		
		Thread.sleep(3000);
		driver.close();
		
		

	}

}
