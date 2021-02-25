package Project.ProjectShwapno;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class shwapno {
	
	public static WebDriver driver;
	public static String URl = "https://www.shwapno.com/";
	public static String State = "Dhaka";
	public static String City = "Adabor";
	public static WebElement element;
	
	@Test
	public static void chooseLocation() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\DELL\\eclipse-workspace\\ProjectShwapno\\chromedriver.exe");
		driver = new ChromeDriver();
		
		//code for navigating to the URl & maximizing browser
		driver.get(URl);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		// selecting from dropdown using select class
		
		Select state = new Select(driver.findElement(By.xpath("//select[@id='state']")));
		state.selectByVisibleText(State);
		
		Select city = new Select(driver.findElement(By.xpath("//select[@id='city']")));
		city.selectByVisibleText(City);
		
		driver.findElement(By.xpath("//input[@id='btnFindStore']")).click();
		
		driver.close();
		driver.quit();
		
	}
}
