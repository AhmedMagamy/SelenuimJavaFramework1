




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import utils.*;
public class DataDrivenLogin {
	
	
	static  ExcelUtils excel = null ;
	static  WebDriver driver =null  ;
	
	
	
	@BeforeSuite
	public void setUp() 
	{
		String projPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projPath+"\\drivers\\chromedriver\\chromedriver.exe");
		//WebDriver driver = new FirefoxDriver();
		driver = new ChromeDriver() ;
		excel=new ExcelUtils ("E:\\study\\java\\my java workspace\\Automation\\SeleniumJavaFramework\\Excel\\data.xlsx","Sheet2");
		
	}
	
	
	@Test
	public void testlogin()
	{
		
		String email = excel.getCellDataString(1,0);
		String password = excel.getCellDataString(1, 1);
		
		driver.get("https://zazzy.app/auth");
		driver.findElement(By.xpath("/html/body/div[2]/section/div/div[2]/div[1]/div/div/form/div[1]/div[1]/input")).sendKeys(email);
		driver.findElement(By.xpath("/html/body/div[2]/section/div/div[2]/div[1]/div/div/form/div[1]/div[1]/input")).sendKeys(password);
		
		
	}
	
	
	
	
	
	
	

}
