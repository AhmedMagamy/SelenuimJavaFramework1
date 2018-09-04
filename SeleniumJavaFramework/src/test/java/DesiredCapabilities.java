import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DesiredCapabilities {


	public static void main(String[] args) {

		String projPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projPath+"\\drivers\\chromedriver\\chromedriver.exe");
		//WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver() ; 

	}
}
