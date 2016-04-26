/**
 * 
 */
package com.cita.petra.regression;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import com.cita.petra.common.Datagenerator;
import com.cita.petra.common.Utility;

/**
 * @author T_khanamS
 *
 */
public class SearchEnquiresCreateTaskTest 
{
				
	final static Logger logger = Logger.getLogger("com.cita.petra.regression.SearchEnquiresCreateTaskTest");
	public static Screen screen;
	public static WebDriver driver;
	
	
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
				public void testCreateTaskEnquiry() throws InterruptedException,FindFailed
				{	
					Thread.sleep(3000);
					WebElement  continuebtn = driver.findElement(By.id("btnOk"));
					logger.info("Contents of : "+continuebtn);
					continuebtn.click();
					Thread.sleep(3000);
					driver.switchTo().frame("nav");
					WebElement  service = driver.findElement(By.xpath(".//table[@id='CS']//tr//td//a//img[@id='services_24x24']"));
					service.click();
					Thread.sleep(3000);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("nav");
					driver.switchTo().frame("CSFrame");
					WebElement enquiry = driver.findElement(By.xpath(".//*[@id='nav_cases']"));
					enquiry.click();
					Thread.sleep(2000);
					String getDefaultWin = driver.getWindowHandle();
				    logger.info("Default Window is : "+getDefaultWin);
					driver.switchTo().window(getDefaultWin);
					driver.switchTo().frame("stage");
					WebElement searchClient = driver.findElement(By.xpath(".//*[@id='quickFindContainer']//td[1]//input[@id='findCriteria']"));
					searchClient.sendKeys("autolname");
				    WebElement gatewayFinder = driver.findElement(By.xpath(".//*[@id='quickFindContainer']//td[2]//img[@src='/_imgs/qfind.gif']"));
				    gatewayFinder.click();
				    Thread.sleep(3000);
				    logger.info("Default Window is : "+getDefaultWin);
				    List<WebElement> getrowCount = driver.findElements(By.xpath(".//table[@id='gridBodyTable']//tr"));
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
				    activityNew(driver);
				}	
	
				

				
				
				public void activityNew(WebDriver driver) throws FindFailed, InterruptedException
				{ 
					try {
				
								String getDefWin = driver.getWindowHandle();
							    logger.info("Default Window is : "+getDefWin);
								driver.switchTo().window(getDefWin);
								screen.click("C:\\Eclipse\\Selenium\\sikuli\\activities.png",10);
								Thread.sleep(1000);
								screen.click("C:\\Eclipse\\Selenium\\sikuli\\activities.png",10);
								Thread.sleep(1000);
								screen.click("C:\\Eclipse\\Selenium\\sikuli\\newactiviti.png", 10);
								Thread.sleep(1000);
								screen.click("C:\\Eclipse\\Selenium\\sikuli\\newactiviti.png", 10);
								Thread.sleep(1000);
								screen.find("C:\\Eclipse\\Selenium\\sikuli\\newactivity.png");
								Thread.sleep(1000);
								screen.click("C:\\Eclipse\\Selenium\\sikuli\\aicpart2ok.png");
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
									    }
					}catch(Exception exp)
					{
						exp.printStackTrace();
					}   
					
				}
				
				
				public void saveNCloseTask(WebDriver driver)
				{
					WebElement subject = driver.findElement(By.xpath(".//form[@name='crmForm']//tr[3]//div[1]//table[@class='stdTable']//tr[1]//tbody//tr[1]//input[@id='subject']"));
		    		subject.sendKeys("Auto Regression Task create");
		    		Utility.saveNClose(driver);
		    		driver.quit();
		        }
				
				public void invokeJS(WebDriver driver)
				{
					JavascriptExecutor jse = (JavascriptExecutor) driver;
					jse.executeScript("if (crmForm.all.cab_enquiryclosurereasonid.DataValue != null && crmForm.all.cab_enquiryclosuredate.DataValue != null )"+ 
									  "{crmForm.all.cab_enquiryclosuresystemdate.ForceSubmit = true;"+
									  "crmForm.all.cab_enquiryclosuresystemdate.Disabled = false;"+
									  "var CurrentDate = new Date();"+
									  "var DateField =  crmForm.all.cab_enquiryclosuresystemdate;"+
									  "DateField.DataValue = CurrentDate ;}" +
									  ");");	
				}
				
				
				
}
