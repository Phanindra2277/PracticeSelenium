package checkBoxesAndRadioBtn;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Checkboxes {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//without using select class
		WebDriver driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/");
		driver.manage().window().maximize();
		
		/*driver.findElement(By.xpath("//select[@id='country-list']")).click();
		
		List<WebElement> countrylist=driver.findElements(By.xpath("//select[@id='country-list']//option"));
		
		for (WebElement opt:countrylist) {
			//System.out.println(opt.getText());
			if (opt.getText().equals("India")) {
				opt.click();
			}
		}
		
		driver.findElement(By.xpath("//select[@name='state']")).click();
		
		List<WebElement> statelist=driver.findElements(By.xpath("//select[@name='state']//option"));
		
		System.out.println(statelist.size());
		for (WebElement opt:statelist) {
			System.out.println(opt.getText());
			if(opt.getText().equals("Andhra Pradesh")) {
				opt.click();
			}
		}*/
		
		
		
		//using with select class
		
		WebElement country=driver.findElement(By.xpath("//select[@id='country-list']"));		
		
		Select countryopt=new Select(country);
		List<WebElement> opt=countryopt.getOptions();
		System.out.println(opt.size());
		countryopt.selectByVisibleText("India");
		
		WebElement state=driver.findElement(By.xpath("//select[@name='state']"));
		
		Select stateopt=new Select(state);
		List<WebElement> opts=stateopt.getOptions();
		System.out.println(opts.size());
		
		stateopt.selectByVisibleText("Andhra Pradesh");
		
		Thread.sleep(3000);
		driver.quit();

	}

}
