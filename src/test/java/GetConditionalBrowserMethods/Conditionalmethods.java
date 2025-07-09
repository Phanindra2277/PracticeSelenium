package GetConditionalBrowserMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Conditionalmethods {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/register");
		
		Boolean value=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed();
		System.out.println(value);
		
		System.out.println(driver.findElement(By.xpath("//input[@id='FirstName']")).isEnabled());
		
		System.out.println(driver.findElement(By.xpath("//input[@type='radio' and @id='gender-male']")).isSelected());
		
		WebElement female_Btn=driver.findElement(By.xpath("//input[@type='radio' and @id='gender-female']"));
		female_Btn.click();
		System.out.println(female_Btn.isSelected());
		
		driver.quit();
	}

}
