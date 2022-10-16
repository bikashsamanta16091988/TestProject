package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utility.Browsers;

public class Bahrain_Page 
{
	public static String saudiArab = "//a[@class='header-btns-country hide-mobile']//img[@alt='sa']";
	
	public static String bh = "//li[@id='bh']/a";
	
	public static String bahrain = "//a[@class='header-btns-country hide-mobile']//img[@alt='bh']";
	
	public static String closePopup = "//span[@class='countryList-close']";
	
	public static String lite = "//*/text()[normalize-space(.)='Lite']/parent::*";
	
	public static String classic = "//*/text()[normalize-space(.)='Classic']/parent::*";
	
	public static String premium = "//*/text()[normalize-space(.)='Premium']/parent::*";
	
	public static String bahrainCurrency = "//section/div/div/div/div/span[2]";
	
	public static String saudiArabCurrency = "//section/div/div/div/div/span[2]";
	
	public static String priceOfBahrain = "//section/div/div/div/div/span[1]";
	
	public static String lite_text;
	
    public static String classic_text;
    
    public static String premium_text;
	
	public static void validateToBahrainSubscriptionType()
	{
		Browsers.driver.findElement(By.xpath(saudiArab)).click();
		Browsers.driver.findElement(By.xpath(bh)).click();
		  
		lite_text = Browsers.driver.findElement(By.xpath(lite)).getText();
		Assert.assertEquals(lite_text, "LITE");
		System.out.println("Bahrain- Successfully validated the "+lite_text+" subscription type");
		  
		classic_text = Browsers.driver.findElement(By.xpath(classic)).getText();
		Assert.assertEquals(classic_text, "CLASSIC");
		System.out.println("Bahrain- Successfully validated the "+classic_text+" subscription type");
		  
		premium_text = Browsers.driver.findElement(By.xpath(premium)).getText();
		Assert.assertEquals(premium_text, "PREMIUM");
		System.out.println("Bahrain- Successfully validated the "+premium_text+" subscription type");
	}
	
	public static void validateToCountryOfBahrain()
	{
		//Browsers.driver.findElement(By.xpath(saudiArab)).click();
		String pageTitle = Browsers.driver.getCurrentUrl();
		try
		{
			Assert.assertEquals(pageTitle, "https://subscribe.stctv.com/bh-en");
			if(pageTitle.contains("bh"))
			{
				System.out.println("Successfully validated Page Title:- "+pageTitle);
			}
		}
		 catch(Exception e)
		 {
			 System.out.println("Page is not validated "+e);
		 }
	}
	
	public static void validateToCurrencyOfBahrain()
	{
		List<WebElement> currency = Browsers.driver.findElements(By.xpath(bahrainCurrency));
		String currency1 = currency.get(0).getText();
		//System.out.println(currency.get(0).getText());
		try
		{
			Assert.assertEquals(currency1, "BHD");
			if(currency1.contains("BH"))
			{
				System.out.println("Successfully validated the currency of Bahrain:- "+currency1);
			}
		}
		 catch(Exception e)
		 {
			 System.out.println("Currency is not validated "+e);
		 }
	}
	
	public static void validateToPriceOfBahrain()
	{
		List<WebElement> currency = Browsers.driver.findElements(By.xpath(bahrainCurrency));
		List<WebElement> price = Browsers.driver.findElements(By.xpath(priceOfBahrain));
		
		String currency1 = currency.get(0).getText();
		String price2 = price.get(0).getText();
		String price3 = price.get(1).getText();
		String price6 = price.get(2).getText();
		
		
		try
		{
			Assert.assertEquals(price2, "2");
			if(currency1.contains("BHD") && lite_text.contains("LITE"))
			{
				System.out.println("Successfully validated the LITE subscription price is :- "+price2+" and currency is "+currency1);
			}
		}
		 catch(Exception e)
		 {
			 System.out.println("LITE subscription price is not validated "+e);
		 }
		
		try
		{
			Assert.assertEquals(price3, "3");
			if(currency1.contains("BHD") && classic_text.contains("CLASSIC"))
			{
				System.out.println("Successfully validated the CLASSIC subscription price is :- "+price3+" and currency is "+currency1);
			}
			
		}
		 catch(Exception e)
		 {
			 System.out.println("CLASSIC subscription price is not validated "+e);
		 }
		
		try
		{
			Assert.assertEquals(price6, "6");
			if(currency1.contains("BHD") && premium_text.contains("PREMIUM"))
			{
				System.out.println("Successfully validatee the PREMIUM subscription price is:- "+price6+" and currency is  "+currency1);
			}
			
		}
		 catch(Exception e)
		 {
			 System.out.println("PREMIUM subscription price is not validated "+e);
		 }
	}
	
}
