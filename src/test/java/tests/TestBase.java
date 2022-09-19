package tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase {
	public static WebDriver driver;

	@BeforeSuite
	@Parameters({ "browser" })
	public void startDriver(@Optional("chrome") String browserName) {
		String _baseUrl = "https://arielkiell.wixsite.com/interview";

		if (browserName.equalsIgnoreCase("chrome")) {
			String _chromeDriverPath = System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", _chromeDriverPath);
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			String _firfoxDriverPath = System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", _firfoxDriverPath);
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("ie")) {
			String _firfoxDriverPath = System.getProperty("user.dir") + "\\Drivers\\IEDriverServer.exe";
			System.setProperty("webdriver.ie.driver", _firfoxDriverPath);
			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.navigate().to(_baseUrl);
	}
	
	
	@AfterMethod
	public void takeScreenShot(ITestResult result) throws IOException {
			//Create reference of take screenshot
			TakesScreenshot ts = (TakesScreenshot) driver;
			
			File source = ts.getScreenshotAs(OutputType.FILE);	
			
			FileUtils.copyFile(source, new File("./Screenshots/" + result.getName()+".png"));
			
	}

	@AfterSuite
	public void stopDriver() {
		driver.quit();
	}
}
