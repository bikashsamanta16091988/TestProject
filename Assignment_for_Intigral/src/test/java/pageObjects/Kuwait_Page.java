package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utility.Browsers;

public class Kuwait_Page 
{
	public static String saudiArab = "//a[@class='header-btns-country hide-mobile']//img[@alt='sa']";
	
	public static String kw = "//li[@id='kw']/a";
	
	public static String kuwait = "//a[@class='header-btns-country hide-mobile']//img[@alt='kw']";
	
	public static String closePopup = "//span[@class='countryList-close']";
	
	public static String lite = "//*/text()[normalize-space(.)='Lite']/parent::*";
	
	public static String classic = "//*/text()[normalize-space(.)='Classic']/parent::*";
	
	public static String premium = "//*/text()[normalize-space(.)='Premium']/parent::*";
	
	public static String kuwaitCurrency = "//section/div/div/div/div/span[2]";
	
	public static String priceOfKuwait = "//section/div/div/div/div/span[1]";
	
	public static String lite_text;
	
    public static String classic_text;
    
    public static String premium_text;
	
	public static void validateToKuwaitSubscriptionType()
	{
		Browsers.driver.findElement(By.xpath(saudiArab)).click();
		Browsers.driver.findElement(By.xpath(kw)).click();
		
		lite_text = Browsers.driver.findElement(By.xpath(lite)).getText();
		Assert.assertEquals(lite_text, "LITE");
		System.out.println("Kuwait- Successfully validate the "+lite_text+" subscription type");
		  
		classic_text = Browsers.driver.findElement(By.xpath(classic)).getText();
		Assert.assertEquals(classic_text, "CLASSIC");
		System.out.println("Kuwait- Successfully validate the "+classic_text+" subscription type");
		  
		premium_text = Browsers.driver.findElement(By.xpath(premium)).getText();
		Assert.assertEquals(premium_text, "PREMIUM");
		System.out.println("Kuwait- Successfully validate the "+premium_text+" subscription type");
	}
	
	public static void validateToCountryOfKuwait()
	{
		//Browsers.driver.findElement(By.xpath(saudiArab)).click();
		String pageTitle = Browsers.driver.getCurrentUrl();
		try
		{
			Assert.assertEquals(pageTitle, "https://subscribe.stctv.com/kw-en");
			if(pageTitle.contains("kw"))
			{
				System.out.println("Successfully validated Page Title:- "+pageTitle);
			}
		}
		 catch(Exception e)
		 {
			 System.out.println("Page is not validated "+e);
		 }
	}
	
	public static void validateToCurrencyOfKuwait()
	{
		List<WebElement> currency = Browsers.driver.findElements(By.xpath(kuwaitCurrency));
		String currency1 = currency.get(0).getText();
		//System.out.println(currency.get(0).getText());
		try
		{
			Assert.assertEquals(currency1, "KWD");
			if(currency1.contains("KW"))
			{
				System.out.println("Successfully validated the currency of Kuwait:- "+currency1);
			}
		}
		 catch(Exception e)
		 {
			 System.out.println("Currency is not validated "+e);
		 }
	}
	
	public static void validateToPriceOfKuwait()
	{
		List<WebElement> currency = Browsers.driver.findElements(By.xpath(kuwaitCurrency));
		List<WebElement> price = Browsers.driver.findElements(By.xpath(priceOfKuwait));
		
		String currency1 = currency.get(0).getText();
		String price1_2 = price.get(0).getText();
		String price2_5 = price.get(1).getText();
		String price4_8 = price.get(2).getText();
		
		
		try
		{
			Assert.assertEquals(price1_2, "1.2");
			if(currency1.contains("KWD") && lite_text.contains("LITE"))
			{
				System.out.println("Successfully validated the LITE subscription price is :- "+price1_2+" and currency is "+currency1);
			}
		}
		 catch(Exception e)
		 {
			 System.out.println("LITE subscription price is not validated "+e);
		 }
		
		try
		{
			Assert.assertEquals(price2_5, "2.5");
			if(currency1.contains("KWD") && classic_text.contains("CLASSIC"))
			{
				System.out.println("Successfully validated the CLASSIC subscription price is :- "+price2_5+" and currency is "+currency1);
			}
			
		}
		 catch(Exception e)
		 {
			 System.out.println("CLASSIC subscription price is not validated "+e);
		 }
		
		try
		{
			Assert.assertEquals(price4_8, "4.8");
			if(currency1.contains("KWD") && premium_text.contains("PREMIUM"))
			{
				System.out.println("Successfully validatee the PREMIUM subscription price is:- "+price4_8+" and currency is  "+currency1);
			}
			
		}
		 catch(Exception e)
		 {
			 System.out.println("PREMIUM subscription price is not validated "+e);
		 }
	}
	
}
