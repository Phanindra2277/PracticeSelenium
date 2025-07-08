package locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class All_Locator {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
		
		driver.findElement(By.id("input-firstname")).sendKeys("Rasool");
		
		driver.findElement(By.id("input-lastname")).sendKeys("Kahn");
		
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("Rasoolkahn123@gmail.com");
		
		driver.findElement(By.name("telephone")).sendKeys("1234567890");
		
		driver.findElement(By.className("form-control")).sendKeys("Rasool@123");
		
		driver.findElement(By.cssSelector("#input-confirm")).sendKeys("Rasool@123");
		
		driver.findElement(By.name("agree")).click();
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		
		
		Thread.sleep(3000);
		
		
		driver.close();

	}

}
