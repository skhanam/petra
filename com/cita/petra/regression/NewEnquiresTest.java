package com.cita.petra.regression;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import java.util.Hashtable;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.script.Screen;

import com.cita.petra.common.Datagenerator;
import com.cita.petra.common.Utility;
import com.cita.petra.locators.EnquiryLocators;
import com.cita.petra.pageObject.EnquiryPage;

/**
 * @author T_khanamS
 *
 */


public class NewEnquiresTest 
{
		
		public static long TIME_OUT = 3000;
		final static Logger logger = Logger.getLogger("com.cita.petra.regression.NewEnquiresTest");
		public static Screen screen;
		public static WebDriver driver;
		
		
		
					@BeforeClass
					public static void setUp()
					{
						System.setProperty("webdriver.ie.driver", "C:\\Eclipse\\Selenium\\IEDriverServer.exe");
						screen = new Screen();
						driver = new InternetExplorerDriver();
						driver.get(EnquiryLocators.enquiryXpathLookup.get("url"));
						try 
						{
							Runtime.getRuntime().exec("C:\\Eclipse\\Selenium\\Autentication.exe");
						} catch (IOException e) 
						{
							e.printStackTrace();
						}
					
					}	
					
					
					@Test
					public void testCreateEnquiry() throws InterruptedException
					{	
						Thread.sleep(3000);
						WebElement  continuebtn = driver.findElement(By.id(EnquiryLocators.enquiryXpathLookup.get("ok")));
						logger.info("Contents of : "+continuebtn);
						continuebtn.click();
						Thread.sleep(3000);
						driver.switchTo().frame("nav");
						WebElement  service = driver.findElement(By.xpath(EnquiryLocators.enquiryXpathLookup.get("services")));
						service.click();
						Thread.sleep(3000);
						driver.switchTo().defaultContent();
						driver.switchTo().frame("nav");
						driver.switchTo().frame("CSFrame");
						WebElement gateway = driver.findElement(By.xpath(EnquiryLocators.enquiryXpathLookup.get("gateway")));
						gateway.click();
						Thread.sleep(2000);
						String getDefaultWin = driver.getWindowHandle();
					    logger.info("Default Window is : "+getDefaultWin);
						driver.switchTo().window(getDefaultWin);
						driver.switchTo().frame("stage");
						WebElement searchClient = driver.findElement(By.xpath(EnquiryLocators.enquiryXpathLookup.get("findCriteria")));
						searchClient.sendKeys("autolname");
					    WebElement gatewayFinder = driver.findElement(By.xpath(EnquiryLocators.enquiryXpathLookup.get("findGateway")));
					    gatewayFinder.click();
					    Thread.sleep(3000);
					    logger.info("Default Window is : "+getDefaultWin);
					    List<WebElement> getrowCount = driver.findElements(By.xpath(EnquiryLocators.enquiryXpathLookup.get("getRows")));
					    int getsizerow = getrowCount.size();
					    logger.info("Results of row on Gateway Page  : "+getrowCount.size());
					    int getarandom = Datagenerator.getRandomNumber(getsizerow);
					    if(getarandom == 0)
					    {
					    	getarandom++;
					    }
					    logger.info("Random of row count : " + getarandom);
					    WebElement getGateway = driver.findElement(By.xpath(".//table[@id='gridBodyTable']//tr["+getarandom+"]//td[9]"));
					    Utility.getClient(driver, getGateway);
					    Thread.sleep(2000);
						Set<String> getAllWindows = driver.getWindowHandles();
					    logger.info("Print all windows : " + getAllWindows);
					    int hasmorewin = getAllWindows.size();
					    logger.info("Count of windows : "+hasmorewin);
					    if(hasmorewin > 0)
					    {
					    	String getExistingGateway = (String) getAllWindows.toArray()[1];
					    	logger.info("This is Gateway Window  : "+getExistingGateway);
					    	driver.switchTo().window(getExistingGateway);
					    	Thread.sleep(1000);
					    	EnquiryPage.Enquiries(driver);
					    }
					}
					
					
					
					
			
	
					
				@AfterClass
				public static void tearDown()
					{
						try {
							
							Runtime.getRuntime().exec("C:\\Eclipse\\Selenium\\cancel.exe");
						} catch (IOException e) 
						{
							e.printStackTrace();
						}
						if(driver != null)
						{
							driver.quit();
						}
					} 
	

}

	
	

