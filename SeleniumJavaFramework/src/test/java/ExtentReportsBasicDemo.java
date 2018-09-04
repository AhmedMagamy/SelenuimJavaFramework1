import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsBasicDemo {
	
	public static void main(String[] args) {
		
		//start reporters
		 ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentreport.html");
		 
		 // create ExtentReports and attach reporter(s)
	        ExtentReports extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
		 
	     // creates a toggle for the given test, adds all log events under it    
	        ExtentTest test1 = extent.createTest("Google Search test ", "add text and click enter ");
		
		// we will use test1 variable to make all log statments 
	        String projPath = System.getProperty("user.dir");
	        System.setProperty("webdriver.chrome.driver", projPath+"\\drivers\\chromedriver\\chromedriver.exe");
			//WebDriver driver = new FirefoxDriver();
			WebDriver driver = new ChromeDriver() ; 
			
			
			// here we will add extent reports functions 
			test1.log(Status.INFO, "starting test case");
			
			driver.get("https://www.google.com.eg/");
			test1.pass("navigated to google.com");
			driver.findElement(By.name("q")).sendKeys("hi");
			test1.pass("entered text in textbox");
			driver.findElement(By.name("btnk")).sendKeys(Keys.RETURN);
			test1.pass("enter button is pressed");
			driver.close();
			test1.pass("browser is closed");
			test1.info("test cmopleted");
			// calling flush writes everything to the log file
	        extent.flush();
			
		
	}

}
