package testsAutomation;

import org.testng.annotations.Test; 

import pageObjects.Bahrain_Page;
import pageObjects.Home_Page;
import pageObjects.Kuwait_Page;
import pageObjects.POM;
import pageObjects.SaudiArab_Page;
import utility.Browsers;
import utility.Constant;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SubscriptionPageValidation_TC 
{
	
  @Test(priority = 1, enabled = true)
  public void saudiArab() throws InterruptedException 
  {
	  Home_Page.homePage();
	  SaudiArab_Page.validateToSubscriptionType(); 
	  SaudiArab_Page.validateToCountryOfSA();
	  SaudiArab_Page.validateToCurrencyOfSA();
	  SaudiArab_Page.validateToPriceOfSA();
  }
  
  @Test (priority = 2, enabled = true)
  public void bahrain() throws InterruptedException 
  { 
	  Home_Page.homePage();
	  Bahrain_Page.validateToBahrainSubscriptionType();
	  Bahrain_Page.validateToCountryOfBahrain();
	  Bahrain_Page.validateToCurrencyOfBahrain();
	  Bahrain_Page.validateToPriceOfBahrain();
  }
  
  @Test (priority = 3, enabled = true)
  public void kuwait() throws InterruptedException 
  { 
	  Thread.sleep(3000);
	  Home_Page.homePage();
	  Kuwait_Page.validateToKuwaitSubscriptionType();
	  Kuwait_Page.validateToCountryOfKuwait();
	  Kuwait_Page.validateToCurrencyOfKuwait();
	  Kuwait_Page.validateToPriceOfKuwait();
  }
	 
  
  @BeforeMethod
  public void beforeMethod() 
  {
	  Browsers.chromeBrowser();
	  //Browsers.firefoxBrowser();
  }
  
  
  @AfterMethod
  public void tearDown() throws InterruptedException
  {
	  if (Browsers.driver != null) 
	  { 
		  Browsers.driver.quit(); 
	  }
		 
  }

}
