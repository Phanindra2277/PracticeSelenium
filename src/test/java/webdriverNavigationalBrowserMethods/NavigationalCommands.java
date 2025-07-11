package webdriverNavigationalBrowserMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationalCommands {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().to("https://testautomationpractice.blogspot.com");
		driver.manage().window().maximize();
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='text' and @id='Wikipedia1_wikipedia-search-input']")).sendKeys("testing");
		driver.findElement(By.xpath("//input[@type='submit' and @class='wikipedia-search-button']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[normalize-space()='Testing']")).click();
		Thread.sleep(3000);
		
		driver.navigate().refresh();
		Thread.sleep(3000);
		driver.quit();

	}

}
