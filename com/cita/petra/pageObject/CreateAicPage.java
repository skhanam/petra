/**
 * 
 */
package com.cita.petra.pageObject;

import java.util.Set;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import com.cita.petra.common.Utility;
import com.cita.petra.datalocators.AicData;
import com.cita.petra.locators.AicLocators;

/**
 * @author T_KhanamS
 *
 */
public class CreateAicPage {
	
	final static Logger logger = Logger.getLogger("com.cita.petra.regression.CreateAicPage");
	public static Screen screen;
	public static WebDriver driver;
	public static long TIME_OUT = 1500;
	
	public static void aicCode(WebDriver driver) throws InterruptedException,FindFailed
	{
		
		aiccodeclick();
		Thread.sleep(TIME_OUT);
	}
	
	
	public static void aiccodeclick() throws FindFailed, InterruptedException
	{
		screen = new Screen();
		screen.click(AicLocators.enquirySearchLookup.get("aicpng"), 100);
		Thread.sleep(TIME_OUT);
		screen.click(AicLocators.enquirySearchLookup.get("aicpng"), 10);
		Thread.sleep(TIME_OUT);
		screen.click(AicLocators.enquirySearchLookup.get("newaicpng"),100);
		Thread.sleep(TIME_OUT);
		Set<String> getEWindows = driver.getWindowHandles();
	    logger.info("Print all windows : " + getEWindows);
	    int hasmoreewin = getEWindows.size();
	    logger.info("Count of windows : "+hasmoreewin);
			    if(hasmoreewin > 0)
			    {
			    	String getAICScreen = (String) getEWindows.toArray()[2];
			    	logger.info("Moving to Existing Enquiry Window  : "+getAICScreen);
			    	driver.switchTo().window(getAICScreen);
			    	logger.info("Get the AIC title  : " + driver.getTitle());
			    	driver.switchTo().activeElement().sendKeys(Keys.TAB);
			    	WebElement aicOne = driver.findElement(By.xpath(AicLocators.enquirySearchLookup.get("aicone")));
			    	aicOne.sendKeys("Employment");
			    	aicOne.sendKeys(Keys.TAB);
			    	WebElement aicTwo = driver.findElement(By.xpath(AicLocators.enquirySearchLookup.get("aictwo")));
			    	logger.info("WebElement Id of aicpart2 : " + aicTwo);
			    	aicTwo.click();
			    	aicTwo.click();
			    	Thread.sleep(2000);
			    	screen.exists(AicLocators.enquirySearchLookup.get("aicparttwopng"),10);
					Thread.sleep(TIME_OUT);
					screen.click(AicLocators.enquirySearchLookup.get("aicparttwook"),10);
				    Thread.sleep(TIME_OUT);
				    WebElement aicthree = driver.findElement(By.xpath(AicLocators.enquirySearchLookup.get("aicthree")));
				    aicthree.click();
				    screen.exists(AicLocators.enquirySearchLookup.get("aicthreepng"),10);
					Thread.sleep(TIME_OUT);
					screen.click(AicLocators.enquirySearchLookup.get("okpng"),100);
				    Thread.sleep(TIME_OUT);
				    WebElement savenclose = driver.findElement(By.xpath(AicLocators.enquirySearchLookup.get("saveNclose")));
				    Thread.sleep(TIME_OUT);
				    savenclose.click();
				    savenclose.click();
				    Thread.sleep(TIME_OUT);
				    driver.quit();
//				    activityNew(driver);
			    }
			   
	}
	
	
	public static void newAic() throws FindFailed,InterruptedException
	{
		screen.click(AicLocators.enquirySearchLookup.get("newaicpng"),100);
		Thread.sleep(1000);
//		screen.click("C:\\Eclipse\\Selenium\\sikuli\\newaic.png",10);
		
	}
	
	
	
	public static void createAIC(WebDriver driver) throws FindFailed, InterruptedException
	{
		Set<String> getEWindows = driver.getWindowHandles();
	    logger.info("Print all windows : " + getEWindows);
	    int hasmoreewin = getEWindows.size();
	    logger.info("Count of windows : "+hasmoreewin);
			    if(hasmoreewin > 0)
			    {
			    	String getAICScreen = (String) getEWindows.toArray()[2];
			    	logger.info("Moving to Existing Enquiry Window  : "+getAICScreen);
			    	driver.switchTo().window(getAICScreen);
			    	logger.info("Get the AIC title  : " + driver.getTitle());
			    	driver.switchTo().activeElement().sendKeys(Keys.TAB);
			    	WebElement aicOne = driver.findElement(By.xpath(AicLocators.enquirySearchLookup.get("aicone")));
			    	aicOne.sendKeys(AicData.enquirydataLookup.get("aicone"));
			    	aicOne.sendKeys(Keys.TAB);
			    	WebElement aicTwo = driver.findElement(By.xpath(AicLocators.enquirySearchLookup.get("aictwo")));
			    	logger.info("WebElement Id of aicpart2 : " + aicTwo);
			    	aicTwo.click();
			    	aicTwo.click();
			    	Thread.sleep(2000);
				    Utility.aicParttwo();
				    Thread.sleep(1000);
				    WebElement aicthree = driver.findElement(By.xpath(AicLocators.enquirySearchLookup.get("aicthree")));
				    aicthree.click();
				    Utility.aicPartthree();
				    Thread.sleep(1000);
				    WebElement savenclose = driver.findElement(By.xpath(AicLocators.enquirySearchLookup.get("saveNclose")));
				    savenclose.click();
				    Thread.sleep(2000);
				    
			    }
		
	}
	
	public static void activityNew(WebDriver driver) throws FindFailed, InterruptedException
	{ 
		try {
	
					/*String getDefWin = driver.getWindowHandle();
				    logger.info("Default Window is : "+getDefWin);
					driver.switchTo().window(getDefWin); */
					screen.click(AicLocators.enquirySearchLookup.get("activitiespng"),10);
					Thread.sleep(1000);
					screen.click(AicLocators.enquirySearchLookup.get("activitiespng"),10);
					Thread.sleep(1000);
					screen.click(AicLocators.enquirySearchLookup.get("newactivitiespng"), 10);
					Thread.sleep(1000);
					screen.click(AicLocators.enquirySearchLookup.get("newactivitiespng"), 10);
					Thread.sleep(1000);
					screen.find(AicLocators.enquirySearchLookup.get("newactivitypng"));
					Thread.sleep(1000);
					screen.click(AicLocators.enquirySearchLookup.get("aicparttwook"));
					Thread.sleep(1000);
					Set<String> getTWindows = driver.getWindowHandles();
				    logger.info("Print all windows : " + getTWindows);
				    int hasmoretwin = getTWindows.size();
				    logger.info("Count of windows : "+hasmoretwin);
						    if(hasmoretwin > 0)
						    {
						    	String getNewActivityTask = (String) getTWindows.toArray()[0];
						    	logger.info("Moving to Existing Enquiry Window  : "+getNewActivityTask);
						    	String getTitleOne = driver.getTitle();
						    	logger.info("Get the title 1 : " + getTitleOne );
						    	if(getTitleOne.startsWith("Task"))
						    	{
						    		driver.switchTo().window(getNewActivityTask);
						    		logger.info("Here you are first part of if ");
						    		saveNCloseTask(driver);
						    		
						    	}
						    	driver.switchTo().window((String) getTWindows.toArray()[1]);
						    	String getTitletwo = driver.getTitle();
						    	logger.info("Get the Title 2  : " + getTitletwo);
						    	if(getTitletwo.startsWith("Task"))
						    	{
						    		driver.switchTo().window((String) getTWindows.toArray()[1]);
						    		logger.info("Here you are second part of if ");
						    		saveNCloseTask(driver);
						    	}
						    	driver.switchTo().window((String) getTWindows.toArray()[2]);
						    	String getTitlethree = driver.getTitle();
						    	logger.info("Get the Title 3  : " + getTitlethree);
						    	if(getTitlethree.startsWith("Task"))
						    	{
						    		driver.switchTo().window((String) getTWindows.toArray()[2]);
						    		logger.info("Here you are third part of if ");
						    		saveNCloseTask(driver);
						    	}
						    	driver.quit();
						    }
		}catch(Exception exp)
		{
			exp.printStackTrace();
		}   
		
	}
	
	
	public static void saveNCloseTask(WebDriver driver)
	{
		WebElement subject = driver.findElement(By.xpath(AicLocators.enquirySearchLookup.get("task")));
		subject.sendKeys(AicData.enquirydataLookup.get("task"));
		Utility.saveNClose(driver);
		driver.quit();
    }

}
