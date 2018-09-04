import java.util.List ;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BrowserTest {
	
	public static void main(String[] args) {
		
		//get the project paht to genralize 
		String projPath = System.getProperty("user.dir");
		// geko driver for firefox 
		//System.setProperty("webdriver.gecko.driver", projPath+"\\drivers\\gekodriver\\geckodriver.exe");
		//for chromedriver 
		//start reporters
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentreport.html");
		 
		// create ExtentReports and attach reporter(s)
	       ExtentReports extent = new ExtentReports();
	       extent.attachReporter(htmlReporter);
		 
	     // creates a toggle for the given test, adds all log events under it    
	        ExtentTest test1 = extent.createTest("Google Search test ", "add text and click enter ");
		System.setProperty("webdriver.chrome.driver", projPath+"\\drivers\\chromedriver\\chromedriver.exe");
		//WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver() ; 
		
		test1.log(Status.INFO, "starting test case");
		// 1- go to google
		driver.get("https://www.google.com.eg/");
		test1.pass("navigated to google.com");
		driver.findElement(By.name("q")).sendKeys("hi");
		test1.pass("entered text in textbox");
		driver.close();
		test1.pass("browser is closed");
		test1.info("test cmopleted");
		// calling flush writes everything to the log file
        extent.flush();
		

        
        
        
		
	/*	List<WebElement> inputElements= driver.findElements(By.xpath("//input"));
		
		int x =inputElements.size();
		System.out.println(x);*/
		
		// quit will close all running drivers 
		//driver.quit();
	}

}
