package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utility.Browsers;

public class SaudiArab_Page 
{
	public static String saudiArab = "//a[@class='header-btns-country hide-mobile']//img[@alt='sa']";
	
	public static String ksa = "//li[@id='sa']/a";
	
	public static String closePopup = "//span[@class='countryList-close']";
	
	public static String lite = "//*/text()[normalize-space(.)='Lite']/parent::*";
	
	public static String classic = "//*/text()[normalize-space(.)='Classic']/parent::*";
	
	public static String premium = "//*/text()[normalize-space(.)='Premium']/parent::*";
	
	public static String saudiArabCurrency = "//section/div/div/div/div/span[2]";
	
	public static String priceOfSA = "//section/div/div/div/div/span[1]";
	
	public static String lite_text;
	
    public static String classic_text;
    
    public static String premium_text;
	
	public static void validateToSubscriptionType()
	{
		//POM.changeLanguageToEnglish.click();
		//System.out.println(driver.getTitle());
		Browsers.driver.findElement(By.xpath(saudiArab)).click();
		
		lite_text = Browsers.driver.findElement(By.xpath(lite)).getText();
		Assert.assertEquals(lite_text, "LITE");
		System.out.println("Saudi Arab- Successfully validated the "+lite_text+" subscription type");
		  
		classic_text = Browsers.driver.findElement(By.xpath(classic)).getText();
		Assert.assertEquals(classic_text, "CLASSIC");
		System.out.println("Saudi Arab- Successfully validated the "+classic_text+" subscription type");
		  
		premium_text = Browsers.driver.findElement(By.xpath(premium)).getText();
		Assert.assertEquals(premium_text, "PREMIUM");
		System.out.println("Saudi Arab- Successfully validated the "+premium_text+" subscription type");  
	}
	
	public static void validateToCountryOfSA()
	{
		//Browsers.driver.findElement(By.xpath(saudiArab)).click();
		String pageTitle = Browsers.driver.getCurrentUrl();
		try
		{
			Assert.assertEquals(pageTitle, "https://subscribe.stctv.com/sa-en");
			if(pageTitle.contains("sa"))
			{
				System.out.println("Successfully validated Page Title:- "+pageTitle);
			}
		}
		 catch(Exception e)
		 {
			 System.out.println("Page is not validated "+e);
		 }
	}
	
	public static void validateToCurrencyOfSA()
	{
		List<WebElement> currency = Browsers.driver.findElements(By.xpath(saudiArabCurrency));
		String currency1 = currency.get(0).getText();
		//System.out.println(currency.get(0).getText());
		try
		{
			Assert.assertEquals(currency1, "SAR");
			if(currency1.contains("SA"))
			{
				System.out.println("Successfully validated the currency of Saudi Arab:- "+currency1);
			}
		}
		 catch(Exception e)
		 {
			 System.out.println("Currency is not validated "+e);
		 }
	}
	
	public static void validateToPriceOfSA()
	{
		List<WebElement> currency = Browsers.driver.findElements(By.xpath(saudiArabCurrency));
		List<WebElement> price = Browsers.driver.findElements(By.xpath(priceOfSA));
		
		String currency1 = currency.get(0).getText();
		String price15 = price.get(0).getText();
		String price25 = price.get(1).getText();
		String price60 = price.get(2).getText();
		
		
		try
		{
			Assert.assertEquals(price15, "15");
			if(currency1.contains("SA") && lite_text.contains("LITE"))
			{
				System.out.println("Successfully validated the LITE subscription price is :- "+price15+" and currency is "+currency1);
			}
		}
		 catch(Exception e)
		 {
			 System.out.println("LITE subscription price is not validated "+e);
		 }
		
		try
		{
			Assert.assertEquals(price25, "25");
			if(currency1.contains("SA") && classic_text.contains("CLASSIC"))
			{
				System.out.println("Successfully validated the CLASSIC subscription price is :- "+price25+" and currency is "+currency1);
			}
			
		}
		 catch(Exception e)
		 {
			 System.out.println("CLASSIC subscription price is not validated "+e);
		 }
		
		try
		{
			Assert.assertEquals(price60, "60");
			if(currency1.contains("SA") && premium_text.contains("PREMIUM"))
			{
				System.out.println("Successfully validatee the PREMIUM subscription price is:- "+price60+" and currency is  "+currency1);
			}
			
		}
		 catch(Exception e)
		 {
			 System.out.println("PREMIUM subscription price is not validated "+e);
		 }
	}

}
