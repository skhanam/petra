package com.cita.petra.regression;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Set;
import java.util.logging.Logger;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterClass;

import com.cita.petra.common.Utility;
import com.cita.petra.datalocators.SearchClientData;
import com.cita.petra.locators.SearchClientLocators;

public class SearchClientTest 
{
	final static Logger logger = Logger.getLogger("com.cita.petra.regression.ClientTest");
	public static Screen screen;
	public static WebDriver driver;
	public static long TIME_OUT = 3000;
	
	
			
			
				
				@BeforeClass
				public static void setUp()
				{
					System.setProperty("webdriver.ie.driver", "C:\\Eclipse\\Selenium\\IEDriverServer.exe");
					screen = new Screen();
					driver = new InternetExplorerDriver();
					logger.info("After Runtime");
					driver.get("http://cabuwbcrm01/uat/loader.aspx");
					try {
						
						Runtime.getRuntime().exec("C:\\Eclipse\\Selenium\\Autentication.exe");
					} catch (IOException e) 
					{
						e.printStackTrace();
					}
				}
	
	
				@Test
				public void testsearchClient() throws InterruptedException
				{	
								Thread.sleep(TIME_OUT);
								WebElement  continuebtn = driver.findElement(By.id(SearchClientLocators.clientXpathlookup.get("ok")));
								logger.info("Contents of : "+continuebtn);
								continuebtn.click();
								Thread.sleep(3000);
								driver.switchTo().frame("nav");
								WebElement  service = driver.findElement(By.xpath(SearchClientLocators.clientXpathlookup.get("service")));
								service.click();
								Thread.sleep(TIME_OUT);
								driver.switchTo().defaultContent();
								driver.switchTo().frame("stage");
								String getDefaultWin = driver.getWindowHandle();
								logger.info("Default Window is : "+getDefaultWin);
								Thread.sleep(TIME_OUT);
							    driver.switchTo().window(getDefaultWin);
							    driver.switchTo().frame("stage");
							    WebElement searchClient = driver.findElement(By.xpath(SearchClientLocators.clientXpathlookup.get("find")));
							    searchClient.sendKeys(SearchClientData.clientDatalookup.get("name"));
							    WebElement clientFinder = driver.findElement(By.xpath(SearchClientLocators.clientXpathlookup.get("search")));
							    clientFinder.click();
							    Thread.sleep(TIME_OUT);
							    WebElement clientdetails = driver.findElement(By.xpath(SearchClientLocators.clientXpathlookup.get("client")));
							    Utility.getClient(driver,clientdetails);
							    Thread.sleep(TIME_OUT);
							    Utility.getClient(driver,clientdetails);
									    Thread.sleep(TIME_OUT);
									    String getDefWin = driver.getWindowHandle();
									    logger.info("Default Window is : "+getDefWin);
									    Set<String> getAllNewWindows = driver.getWindowHandles();
									    logger.info("Print all windows : " + getAllNewWindows);
									    int hasmorenewwin = getAllNewWindows.size();
									    logger.info("Count of windows : "+hasmorenewwin);
											    if(hasmorenewwin > 0)
											    {
											    	String getClientExisting = (String) getAllNewWindows.toArray()[1];
											    	logger.info("This is new Client Window  : "+getClientExisting);
											    	driver.switchTo().window(getClientExisting);
											    	logger.info("Get the title of existing client : " + driver.getTitle());
											    	Thread.sleep(TIME_OUT);
											    	if(driver.getTitle().startsWith("Client"))
											    	{
											    		Utility.saveNClose(driver);
											    		assertTrue(true);
											    	}
											    }
											    driver.switchTo().window(getDefaultWin);
											    driver.switchTo().frame("menuBar");
											    WebElement logout = driver.findElement(By.xpath(SearchClientLocators.clientXpathlookup.get("logoff")));
											    logout.click();
											    Alert logoutok = driver.switchTo().alert();
											    logoutok.accept(); 
											    
				}
	
			@AfterClass
			public void tearDown()
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
