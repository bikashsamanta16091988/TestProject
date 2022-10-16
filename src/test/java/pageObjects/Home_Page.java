package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.Browsers;
import utility.Constant;

public class Home_Page
{
	public static String changeLanguageToEnglish = "//a[@id='changeLanguageButton']/span";
	
	public static void homePage()
	{
		 Browsers.driver.findElement(By.xpath(changeLanguageToEnglish)).click();
	}
}
