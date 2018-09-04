import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsDemoWithTestNG {

	ExtentHtmlReporter htmlReporter ;
	ExtentReports extent ;
	WebDriver driver =null ;
	ExtentTest test1 ;
	//some thing should run once before tests 
	@BeforeSuite
	public void setUp()
	{

		String projPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projPath+"\\drivers\\chromedriver\\chromedriver.exe");
		//WebDriver driver = new FirefoxDriver();
		driver = new ChromeDriver() ;

		htmlReporter = new ExtentHtmlReporter("extent.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		test1 = extent.createTest("testNG") ;
		
		System.out.println("heeeey");

	}

	@Test
	public void test1() throws IOException
	{


		driver.get("https://www.google.com.eg/");
		test1.log(Status.INFO, "the website is opened");
		driver.findElement(By.name("q")).sendKeys("hi");
		test1.pass("entered text in textbox");
		driver.close();
		test1.pass("browser is closed");
		test1.info("test cmopleted");
		// log with snapshot
		test1.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());

		// test with snapshot
		test1.addScreenCaptureFromPath("screenshot.png");
	}

	@AfterSuite
	public void tearDown()
	{
		extent.flush();



	}























}
