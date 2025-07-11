package webdriverNavigationalBrowserMethods;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@type='text' and @id='Wikipedia1_wikipedia-search-input']")).sendKeys("testing");
		driver.findElement(By.xpath("//input[@type='submit' and @class='wikipedia-search-button']")).click();
		Thread.sleep(3000);
		List<WebElement> searchElements=driver.findElements(By.xpath("//div[@class='wikipedia-search-results']//child::a"));
		
		
		
		for (int i=0; i<searchElements.size();i++) {
			searchElements.get(i).click();
		}
		
		Set<String> windowsId=driver.getWindowHandles();
		
		for (String windId:windowsId) {
			String tittle=driver.switchTo().window(windId).getTitle();
			System.out.println(tittle);
		}
		
		
		driver.quit();

	}

}
