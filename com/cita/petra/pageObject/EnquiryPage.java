/**
 * 
 */
package com.cita.petra.pageObject;

import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.script.Screen;

import com.cita.petra.common.Datagenerator;
import com.cita.petra.common.Utility;
import com.cita.petra.locators.EnquiryLocators;

/**
 * @author T_KhanamS
 *
 */
public class EnquiryPage {
			
	final static Logger logger = Logger.getLogger("com.cita.petra.regression.EnquiryPage");
	public static Screen screen;
	public static WebDriver driver;
	public static long TIME_OUT = 3000;
	
	
	public static void Enquiries(WebDriver driver) throws InterruptedException
	{
				
				WebElement enquiry = driver.findElement(By.xpath(EnquiryLocators.enquiryXpathLookup.get("enquiry")));
				enquiry.click();
				Thread.sleep(TIME_OUT);
				driver.switchTo().frame("cab_cab_gateway_incidentFrame");
				WebElement newenquiry = driver.findElement(By.xpath(EnquiryLocators.enquiryXpathLookup.get("newEnquiry")));
				newenquiry.click();
				String getDefWin = driver.getWindowHandle();
			    logger.info("Default Window is : "+getDefWin);
			    Set<String> getNewWindows = driver.getWindowHandles();
			    logger.info("Print all windows : " + getNewWindows);
			    int hasmorenewwin = getNewWindows.size();
			    logger.info("Count of windows : "+hasmorenewwin);
					    if(hasmorenewwin > 0)
					    {
								    	String getNewEnquiry = (String) getNewWindows.toArray()[0];
								    	logger.info("Moving to New Enquiry Window  : "+getNewEnquiry);
								    	String getTitleOne = driver.getTitle();
								    	logger.info("Get the title 1 : " + getTitleOne );
								    	if(driver.getTitle().startsWith("Enquiry"))
								    	{
								    				Thread.sleep(TIME_OUT);
								    				enquiryDetails(driver);
								    		
								    	}
								    	driver.switchTo().window((String) getNewWindows.toArray()[1]);
								    	String getTitletwo = driver.getTitle();
								    	logger.info("Get the Title 2  : " + getTitletwo);
								    	if(getTitletwo.startsWith("Enquiry"))
								    	{
								    		Thread.sleep(TIME_OUT);
						    				enquiryDetails(driver);
								    	}
								    	driver.switchTo().window((String) getNewWindows.toArray()[2]);
								    	String getTitlethree = driver.getTitle();
								    	logger.info("Get the Title 2  : " + getTitlethree);
								    	if(getTitlethree.startsWith("Enquiry"))
								    	{
								    		Thread.sleep(TIME_OUT);
						    				enquiryDetails(driver);
								    	}
					    }	
}
	


	public static void enquiryDetails(WebDriver driver) throws InterruptedException
	{
				Thread.sleep(TIME_OUT);
    			WebElement eType = driver.findElement(By.xpath(EnquiryLocators.enquiryXpathLookup.get("enquiryType")));
	    		Select optionSelect = new Select(eType);
	    		optionSelect.selectByValue("3");
	    		WebElement wrkLevel = driver.findElement(By.xpath(EnquiryLocators.enquiryXpathLookup.get("workLevel")));
	    		Select optionwrkSelect = new Select(wrkLevel);
	    		optionwrkSelect.selectByValue("4");
	    		Utility.saveNClose(driver);
	    		Thread.sleep(TIME_OUT);
	    		Set<String> getNWindows = driver.getWindowHandles();
			    logger.info("Print all windows : " + getNWindows);
			    int hasmorenwin = getNWindows.size();
			    logger.info("Count of windows : "+hasmorenwin);
					    if(hasmorenwin > 0)
					    {
					    	String getExistingGateway = (String) getNWindows.toArray()[1];
					    	logger.info("Moving back to Gateway Window  : "+getExistingGateway);
					    	driver.switchTo().window(getExistingGateway);
					    	Utility.saveNClose(driver);
					    	String getonlyWindow = (String) getNWindows.toArray()[0];
					    	driver.switchTo().window(getonlyWindow);
//					    	searchEnquiry(driver);
					    }
		
	}

	
	public static void searchEnquiry(WebDriver driver) throws InterruptedException
	{
					driver.switchTo().frame("nav");
					driver.switchTo().frame("CSFrame");
					WebElement enquiry = driver.findElement(By.xpath(".//*[@id='nav_cases']"));
					enquiry.click();
					Thread.sleep(TIME_OUT);
					String getDefaultWin = driver.getWindowHandle();
				    logger.info("Default Window is : "+getDefaultWin);
					driver.switchTo().window(getDefaultWin);
					driver.switchTo().frame("stage");
					WebElement searchClient = driver.findElement(By.xpath(EnquiryLocators.enquiryXpathLookup.get("findCriteria")));
					searchClient.sendKeys("autolname");
				    WebElement gatewayFinder = driver.findElement(By.xpath(EnquiryLocators.enquiryXpathLookup.get("qFind")));
				    gatewayFinder.click();
				    Thread.sleep(TIME_OUT);
				    logger.info("Default Window is : "+getDefaultWin);
				    List<WebElement> getrowCount = driver.findElements(By.xpath(EnquiryLocators.enquiryXpathLookup.get("gridTable")));
				    int getsizerow = getrowCount.size();
				    logger.info("Results of row on Gateway Page  : "+getrowCount.size());
				    int getarandom = Datagenerator.getRandomNumber(getsizerow);
				    if(getarandom == 0)
				    {
				    	getarandom++;
				    }
				    logger.info("Random of row count : " + getarandom);
				    WebElement getEnquiry = driver.findElement(By.xpath(".//table[@id='gridBodyTable']//tr["+getarandom+"]//td[9]"));
				    Utility.getClient(driver, getEnquiry);
				    Thread.sleep(2000);
					
	}
	
	
	
	public static void aiccodeCreate(WebDriver driver) throws InterruptedException
	{
				Thread.sleep(TIME_OUT);
				Set<String> getEWindows = driver.getWindowHandles();
			    logger.info("Print all windows : " + getEWindows);
			    int hasmoreewin = getEWindows.size();
			    logger.info("Count of windows : "+hasmoreewin);
					    if(hasmoreewin > 0)
					    {
					    	String getExistingEnquiry = (String) getEWindows.toArray()[2];
					    	logger.info("Moving back to Enquiry Window  : "+getExistingEnquiry);
					    	Thread.sleep(1000);
					    	driver.switchTo().window(getExistingEnquiry);
					    	logger.info("Get the enquiry title  : " + driver.getTitle());
					    	driver.manage().window().maximize();
					    	WebElement aic = driver.findElement(By.xpath(EnquiryLocators.enquiryXpathLookup.get("aic")));
							aic.click();
							Thread.sleep(TIME_OUT);
					    }	
				
	}
	
	
	public static void newCreate()
	{
		driver.switchTo().frame("cab_incident_cab_aicFrame");
		WebElement newEnq = driver.findElement(By.xpath(EnquiryLocators.enquiryXpathLookup.get("nEnquiry")));
		newEnq.click();
	}
}
