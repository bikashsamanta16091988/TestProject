package utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browsers 
{
public static WebDriver driver;
	
	public static void chromeBrowser() 
	  {
		  WebDriverManager.chromedriver().setup();
		  ChromeOptions options = new ChromeOptions();
		  options.addArguments("--disable-notifications");
		  driver = new ChromeDriver(options);
		  driver.navigate().to(Constant.url2);
		  driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
	  }
	
	public static void firefoxBrowser() 
	  {
		  WebDriverManager.firefoxdriver().setup();
		  FirefoxOptions options = new FirefoxOptions();
		  options.addArguments("--disable-notifications");
		  driver = new FirefoxDriver();
		  driver.navigate().to(Constant.url1);
		  driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
	  }
}
