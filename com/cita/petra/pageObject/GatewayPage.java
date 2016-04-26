/**
 * 
 */
package com.cita.petra.pageObject;

import static org.junit.Assert.assertTrue;

import java.util.Set;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.net.UrlChecker.TimeoutException;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import com.cita.petra.common.Utility;
import com.cita.petra.datalocators.GatewayData;
import com.cita.petra.locators.GatewayLocators;

/**
 * @author T_KhanamS
 *
 */
public class GatewayPage {

	final static Logger logger = Logger.getLogger("com.cita.petra.regression.GatewayPage");
	public static Screen screen;
	
	public static void searchGateway(WebDriver driver) throws InterruptedException
	{
				Set<String> getWindowsbeforesearch = driver.getWindowHandles();
				logger.info("Get All Windows : " + getWindowsbeforesearch);
				logger.info("Count of windows before gateway details  : " + getWindowsbeforesearch.size());
//				int countWinSize = getWindowsbeforesearch.size();
				if(getWindowsbeforesearch.size() > 0)
				{
						String clientGatewayList = (String)getWindowsbeforesearch.toArray()[2];
						driver.switchTo().window(clientGatewayList);
						driver.manage().window().maximize();
				}
				
//				driver.switchTo().frame("cab_contact_cab_gatewayFrame");
				WebElement clientdetails = driver.findElement(By.xpath(GatewayLocators.xpathLookup.get("clientdetails")));
			    Utility.getClient(driver,clientdetails);
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
					    	Thread.sleep(1000);
					    	if(driver.getTitle().startsWith("Client"))
					    	{
					    		assertTrue(true);
					    	}
					    }	
	}
	
	public static void createGateway(WebDriver driver) throws TimeoutException, InterruptedException
	{	
		 WebElement Gateway = driver.findElement(By.xpath(GatewayLocators.xpathLookup.get("gateway")));
		 Gateway.click();
		 Thread.sleep(2000);
		 driver.switchTo().frame("cab_contact_cab_gatewayFrame");
		 WebElement newGateway = driver.findElement(By.xpath(GatewayLocators.xpathLookup.get("newgateway")));
		 newGateway.click();
		 Thread.sleep(2000);
	}
	
	public static String getGatewayNumber(WebDriver driver)
	{
				WebElement getGateway = driver.findElement(By.xpath(GatewayLocators.xpathLookup.get("getgateway")));
				String getGatewayNo = getGateway.getAttribute("value");
				logger.info("Gateway Number is : " + getGatewayNo);
				return getGatewayNo;
	}
	
	public static void gatewayDetails(WebDriver driver) throws TimeoutException,InterruptedException, FindFailed
	{
			Thread.sleep(2000);
			WebElement shortDecs = driver.findElement(By.xpath(GatewayLocators.xpathLookup.get("shortdesc")));
			shortDecs.sendKeys(GatewayData.dataLookup.get("shortdecs"));
			WebElement gatewayChannel = driver.findElement(By.xpath(GatewayLocators.xpathLookup.get("gatewaychanel")));
			Select selectchannel = new Select(gatewayChannel);
			selectchannel.selectByValue("3");
			WebElement aicpartOne = driver.findElement(By.xpath(GatewayLocators.xpathLookup.get("aicone")));
			aicpartOne.sendKeys(GatewayData.dataLookup.get("aicone"));
			WebElement aicpartTwo = driver.findElement(By.xpath(GatewayLocators.xpathLookup.get("aictwo")));
			aicpartTwo.click();
			aicpartTwo.click();
			Utility.getClient(driver, aicpartTwo);
			Thread.sleep(2000);
			aicpart2();
			WebElement nextStep = driver.findElement(By.xpath(GatewayLocators.xpathLookup.get("nextstep")));
			Select selnextStep = new Select(nextStep);
			selnextStep.selectByValue("5");
			WebElement bef = driver.findElement(By.xpath(GatewayLocators.xpathLookup.get("bef")));
			Select befstatus = new Select(bef);
			befstatus.selectByValue("3");
			WebElement notestab = driver.findElement(By.xpath(GatewayLocators.xpathLookup.get("notestab")));
			notestab.click();
			WebElement notesdesc = driver.findElement(By.xpath(GatewayLocators.xpathLookup.get("notesdesc")));
			notesdesc.sendKeys(GatewayData.dataLookup.get("notesdecs"));
			Utility.save(driver);
			Thread.sleep(1000);
			getGatewayNumber(driver);
			Thread.sleep(2000);
			Utility.saveNClose(driver);
	}
	

	public static void aicpart2() throws InterruptedException, FindFailed
	{
			   screen = new Screen();
		   	   screen.exists(GatewayLocators.xpathLookup.get("lookup"), 10);
			   Thread.sleep(10);
			   screen.click(GatewayLocators.xpathLookup.get("okaic"),0);
		
	}
	

	
	
	
}
