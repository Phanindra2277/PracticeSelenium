package AlertsAndFrames;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		
		/*driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
		Alert myalert=driver.switchTo().alert();
		myalert.accept();*/
		
		/*driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
		Thread.sleep(3000);
		//driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();
		*/
		
		driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
		Alert myalert=driver.switchTo().alert();
		
		System.out.println(myalert.getText());
		myalert.sendKeys("Hello Prompt");
		
		myalert.accept();
		
		String validMessage=driver.findElement(By.xpath("//p[@id='result']")).getText();
		
		if (validMessage.contains("Hello Prompt")) {
			System.out.println("Test Passed");
		}else {
			System.out.println("Test Failed");
		}
		
		
		Thread.sleep(3000);
		driver.quit();
	}

}
