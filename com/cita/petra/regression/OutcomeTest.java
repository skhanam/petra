package com.cita.petra.regression;

import java.io.IOException;
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
import com.cita.petra.datalocators.OutcomeData;
import com.cita.petra.locators.OutcomeLocators;
import com.cita.petra.pageObject.OutcomePage;

public class OutcomeTest 
{
	final static Logger logger = Logger.getLogger("com.cita.petra.regression.OutcomeTest");
	public static Screen screen;
	public static WebDriver driver;
	public static String url = "http://cabuwbcrm01/uat/loader.aspx"; 
	
	
				@BeforeClass
				public static void setUp()
				{
					System.setProperty("webdriver.ie.driver", "C:\\Eclipse\\Selenium\\IEDriverServer.exe");
					screen = new Screen();
					driver = new InternetExplorerDriver();
					driver.get(url);
					try {
						
						Runtime.getRuntime().exec("C:\\Eclipse\\Selenium\\Autentication.exe");
					} catch (IOException e) 
					{
						e.printStackTrace();
					}
				
				}	
				
				
				@Test
				public void testOutCome() throws InterruptedException,FindFailed
				{
						Thread.sleep(3000);
						WebElement  continuebtn = driver.findElement(By.id("btnOk"));
						logger.info("Contents of : "+continuebtn);
						continuebtn.click();
						Thread.sleep(3000);
						driver.switchTo().frame("nav");
						WebElement  service = driver.findElement(By.xpath(OutcomeLocators.xpathLookup.get("service")));
						service.click();
						Thread.sleep(3000);
						driver.switchTo().defaultContent();
						driver.switchTo().frame("nav");
						driver.switchTo().frame("CSFrame");
						WebElement enquiry = driver.findElement(By.xpath(OutcomeLocators.xpathLookup.get("enquiry")));
						enquiry.click();
						Thread.sleep(2000);
						String getDefaultWin = driver.getWindowHandle();
					    logger.info("Default Window is : "+getDefaultWin);
						driver.switchTo().window(getDefaultWin);
						driver.switchTo().frame("stage");
						WebElement searchClient = driver.findElement(By.xpath(OutcomeLocators.xpathLookup.get("searchclient")));
						searchClient.sendKeys("autolname");
					    WebElement gatewayFinder = driver.findElement(By.xpath(OutcomeLocators.xpathLookup.get("gatewayfinder")));
					    gatewayFinder.click();
					    Thread.sleep(3000);
					    logger.info("Default Window is : "+getDefaultWin);
					    List<WebElement> getrowCount = driver.findElements(By.xpath(OutcomeLocators.xpathLookup.get("rowcount")));
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
					    Thread.sleep(2000);
					    aicCode(driver);
					    
					}
					
					
					
					public void aicCode(WebDriver driver) throws InterruptedException,FindFailed
					{
						
						aiccodeclick();
						Thread.sleep(3000);
					}
					
					
					public void aiccodeclick() throws FindFailed, InterruptedException
					{
						screen.click(OutcomeLocators.xpathLookup.get("aic"), 10);
						Thread.sleep(1000);
//						screen.click("C:\\Eclipse\\Selenium\\sikuli\\AIC.png", 10);
						screen.click(OutcomeLocators.xpathLookup.get("aic"), 10);
						Thread.sleep(1000);
						screen.click(OutcomeLocators.xpathLookup.get("newaic"),100);
						Thread.sleep(1000);
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
							    	WebElement aicOne = driver.findElement(By.xpath(OutcomeLocators.xpathLookup.get("aicone")));
							    	if(!(aicOne.getText().isEmpty()))
							    	{
							    		logger.info("Here is the text " + aicOne.getText());
							    		WebElement aiconeLookup = driver.findElement(By.xpath(".//*[@id='cab_aicpart1id']"));
							    		aiconeLookup.click();
							    		Thread.sleep(2000);
							    		screen.exists(OutcomeLocators.xpathLookup.get("aiconepng"), 10);
							    		Thread.sleep(2000);
							    		screen.click(OutcomeLocators.xpathLookup.get("removepng"),10);
							    		Thread.sleep(1000);
							    	}
							    		aicOne.sendKeys(OutcomeData.dataLookup.get("aicone"));
							    		aicOne.sendKeys(Keys.TAB);
							    	    WebElement aicTwo = driver.findElement(By.xpath(OutcomeLocators.xpathLookup.get("aictwo")));
							    		logger.info("WebElement Id of aicpart2 : " + aicTwo);
							    		aicTwo.click();
							    		aicTwo.click();
							    		Thread.sleep(2000);
							    		screen.exists(OutcomeLocators.xpathLookup.get("aictwopng"), 10);
							    		Thread.sleep(2000);
							    		screen.click(OutcomeLocators.xpathLookup.get("aictwookpng"),10);
							    		Thread.sleep(1000);
							    		WebElement aicthree = driver.findElement(By.xpath(OutcomeLocators.xpathLookup.get("aicthree")));
							    		aicthree.click();
							    		screen.exists(OutcomeLocators.xpathLookup.get("aicthreepng"),10);
							    		Thread.sleep(1000);
							    		screen.click(OutcomeLocators.xpathLookup.get("aicthreeokpng"),100);
									    Thread.sleep(1000);
									    OutcomePage.outcomeCheck(driver);
									    WebElement save = driver.findElement(By.xpath(OutcomeLocators.xpathLookup.get("save")));
									    Thread.sleep(1000);
									    save.click();
									    OutcomePage.outcomeDetails(driver);
									    Utility.saveNClose(driver);
									    Thread.sleep(2000);
									    driver.quit();
							    	}
							    
							   
					}
					
			
					
					
					
					public void createAIC(WebDriver driver) throws FindFailed, InterruptedException
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
							    	WebElement aicOne = driver.findElement(By.xpath(OutcomeLocators.xpathLookup.get("aicone")));
							    	aicOne.sendKeys("Employment");
							    	aicOne.sendKeys(Keys.TAB);
							    	WebElement aicTwo = driver.findElement(By.xpath(OutcomeLocators.xpathLookup.get("aictwo")));
							    	logger.info("WebElement Id of aicpart2 : " + aicTwo);
							    	aicTwo.click();
							    	aicTwo.click();
							    	Thread.sleep(2000);
								    Utility.aicParttwo();
								    Thread.sleep(1000);
								    WebElement aicthree = driver.findElement(By.xpath(OutcomeLocators.xpathLookup.get("aicthree")));
								    aicthree.click();
								    Utility.aicPartthree();
								    Thread.sleep(1000);
								    WebElement savenclose = driver.findElement(By.xpath(OutcomeLocators.xpathLookup.get("saveNclose")));
								    savenclose.click();
								    Thread.sleep(2000);
							    }
						
					}
					
				
					
					public void activityNew(WebDriver driver) throws FindFailed, InterruptedException
					{ 
						try {
					
									/*String getDefWin = driver.getWindowHandle();
								    logger.info("Default Window is : "+getDefWin);
									driver.switchTo().window(getDefWin); */
									screen.click(OutcomeLocators.xpathLookup.get("activitiespng"),10);
									Thread.sleep(1000);
									screen.click(OutcomeLocators.xpathLookup.get("activitiespng"),10);
									Thread.sleep(1000);
									screen.click(OutcomeLocators.xpathLookup.get("newactivitiespng"), 10);
									Thread.sleep(1000);
									screen.click(OutcomeLocators.xpathLookup.get("newactivitiespng"), 10);
									Thread.sleep(1000);
									screen.find("C:\\Eclipse\\Selenium\\sikuli\\newactivity.png");
									Thread.sleep(1000);
									screen.click("C:\\Eclipse\\Selenium\\sikuli\\aicpart2ok.png");
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
										    		OutcomePage.saveNCloseTask(driver);
										    		
										    	}
										    	driver.switchTo().window((String) getTWindows.toArray()[1]);
										    	String getTitletwo = driver.getTitle();
										    	logger.info("Get the Title 2  : " + getTitletwo);
										    	if(getTitletwo.startsWith("Task"))
										    	{
										    		driver.switchTo().window((String) getTWindows.toArray()[1]);
										    		logger.info("Here you are second part of if ");
										    		OutcomePage.saveNCloseTask(driver);
										    	}
										    	driver.switchTo().window((String) getTWindows.toArray()[2]);
										    	String getTitlethree = driver.getTitle();
										    	logger.info("Get the Title 3  : " + getTitlethree);
										    	if(getTitlethree.startsWith("Task"))
										    	{
										    		driver.switchTo().window((String) getTWindows.toArray()[2]);
										    		logger.info("Here you are third part of if ");
										    		OutcomePage.saveNCloseTask(driver);
										    	}
										    	driver.quit();
										    }
						}catch(Exception exp)
						{
							exp.printStackTrace();
						}   
						
					}
					
					
					
				
				public static void tearDown()
				{
					if(!(driver.equals(null)))
					{
						 driver.quit();
					}
				} 
}
