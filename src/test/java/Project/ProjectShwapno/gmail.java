package Project.ProjectShwapno;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class gmail {
	
	public static WebDriver driver;
	public static String URl = "https://gmail.com/";
	public static String email = "mh.hassann19@gmail.com";
	public static String pass = ";qwertyuio@$";
	public static WebElement element;
	
	@BeforeSuite
	public static void setBrowserEnv() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\eclipse-workspace\\TestNG_HomeWork\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("setBrowserEnv() method executed");
	}
	
	@BeforeTest
	public static void Login() throws InterruptedException{
		driver.get(URl);
		driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(email);
		driver.findElement(By.xpath("//button[.='Next']")).click();
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pass);
		driver.findElement(By.xpath("//button[.='Next']")).click();
		Thread.sleep(1000);
		
		System.out.println("Login() method executed");
	}
	
	@AfterTest
	public static void Logout() throws InterruptedException{
		driver.findElement(By.xpath("//img[@class='gb_Da gbii']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Sign out']")).click();
	}
	
	@AfterSuite
	public static void browserClose() throws InterruptedException{
		driver.close();
		driver.quit();
	}
	
	
}
