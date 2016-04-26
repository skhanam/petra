/**
 * 
 */
package com.cita.petra.regression;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import com.cita.petra.common.Datagenerator;
import com.cita.petra.common.Utility;
import com.cita.petra.locators.AicLocators;
import com.cita.petra.pageObject.CreateAicPage;

/**
 * @author T_khanamS
 *
 */
public class SearchEnquiresCreateAICTest 
{
	final static Logger logger = Logger.getLogger("com.cita.petra.regression.SearchEnquiresCreateAICTest");
	public static Screen screen;
	public static WebDriver driver;
	public static long TIME_OUT = 1500;
	
	
	
				
	
				@BeforeClass
				public static void setUp()
				{
					System.setProperty("webdriver.ie.driver", "C:\\Eclipse\\Selenium\\IEDriverServer.exe");
					screen = new Screen();
					driver = new InternetExplorerDriver();
					driver.get(AicLocators.enquirySearchLookup.get("url"));
					try {
							Runtime.getRuntime().exec("C:\\Eclipse\\Selenium\\Autentication.exe");
						
						} catch (IOException e) 
						{
							e.printStackTrace();
						}
				}	
	
				
				
				@Test
				public void testCreateAICEnquiry() throws InterruptedException,FindFailed
				{	
					Thread.sleep(TIME_OUT);
					WebElement  continuebtn = driver.findElement(By.id(AicLocators.enquirySearchLookup.get("ok")));
					logger.info("Contents of : "+continuebtn);
					continuebtn.click();
					Thread.sleep(TIME_OUT);
					driver.switchTo().frame("nav");
					WebElement  service = driver.findElement(By.xpath(AicLocators.enquirySearchLookup.get("services")));
					service.click();
					Thread.sleep(TIME_OUT);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("nav");
					driver.switchTo().frame("CSFrame");
					WebElement enquiry = driver.findElement(By.xpath(AicLocators.enquirySearchLookup.get("enquiry")));
					enquiry.click();
					Thread.sleep(TIME_OUT);
					String getDefaultWin = driver.getWindowHandle();
				    logger.info("Default Window is : "+getDefaultWin);
					driver.switchTo().window(getDefaultWin);
					driver.switchTo().frame("stage");
					WebElement searchClient = driver.findElement(By.xpath(AicLocators.enquirySearchLookup.get("findcriteria")));
					searchClient.sendKeys("autolname");
				    WebElement gatewayFinder = driver.findElement(By.xpath(AicLocators.enquirySearchLookup.get("qfind")));
				    gatewayFinder.click();
				    Thread.sleep(TIME_OUT);
				    logger.info("Default Window is : "+getDefaultWin);
				    List<WebElement> getrowCount = driver.findElements(By.xpath(AicLocators.enquirySearchLookup.get("rowCount")));
				    int getsizerow = getrowCount.size();
				    logger.info("Results of row on Enquiry Page  : "+getrowCount.size());
				    int getarandom = Datagenerator.getRandomNumber(getsizerow);
				    if(getarandom == 0)
				    {
				    	getarandom++;
				    }
				    logger.info("Random of row count : " + getarandom);
				    WebElement getEnquiry = driver.findElement(By.xpath(".//table[@id='gridBodyTable']//tr["+getarandom+"]//td[9]"));
				    Utility.getClient(driver, getEnquiry);
				    Thread.sleep(TIME_OUT);
				    CreateAicPage.aicCode(driver);
				    
				}
				
				
				
	
}
