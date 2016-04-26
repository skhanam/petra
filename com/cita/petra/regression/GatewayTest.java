/**
 * 
 */
package com.cita.petra.regression;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.net.UrlChecker.TimeoutException;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import com.cita.petra.common.Datagenerator;
import com.cita.petra.common.Utility;
import com.cita.petra.locators.GatewayLocators;
import com.cita.petra.pageObject.GatewayPage;

/**
 * @author T_khanams
 *
 */
public class GatewayTest 
{
		final static Logger logger = Logger.getLogger("com.cita.petra.regression.GatewayTest");
		public static WebDriver driver;
		public static Screen screen;
		
		
		
		
	
		
		@BeforeClass
		public static void setUp()
		{
			System.setProperty("webdriver.ie.driver", "C:\\Eclipse\\Selenium\\IEDriverServer.exe");
			screen = new Screen();
			driver = new InternetExplorerDriver();
			driver.get("http://cabuwbcrm01/uat/loader.aspx");
			try {
				
				Runtime.getRuntime().exec("C:\\Eclipse\\Selenium\\Autentication.exe");
			} catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		
		@Test
		public void testCreateGateway() throws InterruptedException, TimeoutException, FindFailed
		{	
			Thread.sleep(3000);
			WebElement  continuebtn = driver.findElement(By.id("btnOk"));
			logger.info("Contents of : "+continuebtn);
			continuebtn.click();
			Thread.sleep(3000);
			driver.switchTo().frame("nav");
			WebElement  service = driver.findElement(By.xpath(GatewayLocators.xpathLookup.get("service")));
			service.click();
			Thread.sleep(3000);
			String getDefaultWin = driver.getWindowHandle();
		    logger.info("Default Window is : "+getDefaultWin);
			driver.switchTo().window(getDefaultWin);
			driver.switchTo().frame("stage");
			WebElement searchClient = driver.findElement(By.xpath(GatewayLocators.xpathLookup.get("searchclient")));
			searchClient.sendKeys("autolname");
			WebElement clientFinder = driver.findElement(By.xpath(GatewayLocators.xpathLookup.get("clientfinder")));
		    clientFinder.click();
		    Thread.sleep(1000);
		    List<WebElement> getrowCount = driver.findElements(By.xpath(GatewayLocators.xpathLookup.get("rowcount")));
		    int getsizerow = getrowCount.size();
		    logger.info("Results of row on Gateway Page  : "+getrowCount.size());
		    int getarandom = Datagenerator.getRandomNumber(getsizerow);
		    if(getarandom == 0){
		    	getarandom++;
		    }
		    logger.info("Random of row count : " + getarandom);
		    WebElement clientdetails = driver.findElement(By.xpath(".//table[@id='gridBodyTable']//tr["+getarandom+"]//td[5]"));
		    Utility.getClient(driver,clientdetails);
		    Thread.sleep(2000);
		    String getDefWin = driver.getWindowHandle();
		    logger.info("Default Window is : "+getDefWin);
		    Set<String> getAllNewWindows = driver.getWindowHandles();
		    logger.info("Print all windows : " + getAllNewWindows);
		    int hasmorenewwin = getAllNewWindows.size();
		    logger.info("Count of windows : "+hasmorenewwin);
				    if(hasmorenewwin > 0)
				    {
				    	String getClientExisting = (String) getAllNewWindows.toArray()[1];
				    	logger.info("This is Existing Client Window  : "+getClientExisting);
				    	driver.switchTo().window(getClientExisting);
				    	logger.info("Get the title of existing client : " + driver.getTitle());
				    	Thread.sleep(1000);
				    	if(driver.getTitle().startsWith("Client"))
				    	{
				    		assertTrue(true);
				    	}
				    	Thread.sleep(3000);
				    	GatewayPage.createGateway(driver);
				    	String getDefaultWindows = driver.getWindowHandle();
					    logger.info("Default Window is : "+getDefaultWindows);
					    Set<String> getAllNewWin = driver.getWindowHandles();
					    logger.info("Print all windows  : " + getAllNewWin);
					    int hasmorenewwindows = getAllNewWin.size();
					    logger.info("Count of windows : "+hasmorenewwindows);
							    if(hasmorenewwindows > 0)
							    {
							    	String getNewGateway = (String) getAllNewWin.toArray()[2];
							    	logger.info("This is new Gateway Window  : "+getNewGateway);
							    	driver.switchTo().window(getNewGateway);
							    	String getTitleOne = driver.getTitle();
							    	if(getTitleOne.startsWith("Gateway"))
							    	{
							    		Thread.sleep(2000);
							    		GatewayPage.gatewayDetails(driver);
								    	logger.info("Get the title of Gateway First attempt : " + getTitleOne);
							    	}else
							    	{
							    		driver.switchTo().window((String)getAllNewWin.toArray()[1]);
							    		logger.info("Get the title of Gateway Second attempt : " + driver.getTitle());
							    		GatewayPage.gatewayDetails(driver);
							    	}
							    	
							    	
							    	
							    }
							    driver.switchTo().window(getClientExisting);
							    Utility.saveNClose(driver);
							    Thread.sleep(1000);
							    driver.switchTo().window(getDefaultWin);
							    driver.switchTo().frame("menuBar");
							    WebElement logout = driver.findElement(By.xpath(GatewayLocators.xpathLookup.get("logout")));
							    logout.click();
							    Alert logoutok = driver.switchTo().alert(); 
							    logoutok.accept();
				    }
		}
				    
					
					
}
