package com.cita.petra.regression;

import java.awt.AWTException;

import java.awt.Robot;
import java.io.IOException;
import java.util.Set;
import java.util.logging.Logger;
import com.cita.petra.common.Utility;
import com.cita.petra.datalocators.DaysheetData;
import com.cita.petra.locators.DaysheetLocators;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.HasInputDevices;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Mouse;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.seleniumemulation.GetAllWindowNames;
import org.openqa.selenium.internal.seleniumemulation.JavascriptLibrary;
import org.openqa.selenium.security.Credentials;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import com.opera.core.systems.scope.protos.ExecProtos.ActionList.Action;
import com.steadystate.css.parser.Locatable;

@SuppressWarnings("unused")
public class DaysheetTest 
{
		public static WebDriver driver;
		public static Screen screen;
		static Logger logger = Logger.getLogger("com.cita.petra.regression.DaysheetTest");
		
		@BeforeClass
		public static void setUp() 
		{
			
				System.setProperty("webdriver.ie.driver", "C:\\Eclipse\\Selenium\\IEDriverServer.exe");
				screen = new Screen();
				
		}
	
	
	
	
		@Test
		public void launchtest() 
		{	
					WebDriver driver = new InternetExplorerDriver();
					logger.info("After Runtime");
					driver.get("http://cabuwbcrm01/uat/loader.aspx");
					try {
								
						Runtime.getRuntime().exec("C:\\Eclipse\\Selenium\\Autentication.exe");
					} catch (IOException e) {
						e.printStackTrace();
					}
					try {
									Thread.sleep(3000);
									logger.info("You are here ... ");
									WebElement  continuebtn = driver.findElement(By.id("btnOk"));
									logger.info("Contents of : "+continuebtn);
									continuebtn.click();
									Thread.sleep(3000);
									driver.switchTo().frame("nav");
									WebElement  service = driver.findElement(By.xpath(DaysheetLocators.daysheetxpathLookup.get("service")));
									service.click();
									driver.switchTo().defaultContent();
									driver.switchTo().frame("nav");
									driver.switchTo().frame("CSFrame");
									WebElement getDaysheet = driver.findElement(By.xpath(DaysheetLocators.daysheetxpathLookup.get("daysheet")));
								    getDaysheet.click();
								    driver.switchTo().defaultContent();
								    String getDefaultWin = driver.getWindowHandle();
								    logger.info("Default Window is : "+getDefaultWin);
								    Thread.sleep(500);
								    driver.switchTo().frame("stage");
								    WebElement newDaysheet = driver.findElement(By.xpath(DaysheetLocators.daysheetxpathLookup.get("newdaysheet")));
								    newDaysheet.click();
								    Set<String> getAllWindows = driver.getWindowHandles();
								    logger.info("Print all windows : " + getAllWindows);
								    int hasmorewin = getAllWindows.size();
								    logger.info("Count of windows : "+hasmorewin);
								    if(hasmorewin > 0)
								    {
								    	String getdaysheetNew = (String) getAllWindows.toArray()[1];
								    	driver.switchTo().window(getdaysheetNew);
								    	logger.info("Get the title  : " + driver.getTitle());
								    	Thread.sleep(2000);
								    	WebElement editQty = driver.findElement(By.xpath(DaysheetLocators.daysheetxpathLookup.get("quantity")));
									    editQty.clear();
									    editQty.sendKeys(DaysheetData.daysheetDataLookup.get("quantity"));
									    WebElement contactChannel = driver.findElement(By.xpath(DaysheetLocators.daysheetxpathLookup.get("channel")));
									    Select contactchannel = new Select(contactChannel);
									    contactchannel.selectByValue("3");
									    driver.switchTo().activeElement().sendKeys(Keys.TAB);
									    WebElement mainProblemEdit = driver.findElement(By.xpath(DaysheetLocators.daysheetxpathLookup.get("mainproblem")));
									    mainProblemEdit.clear();
									    mainProblemEdit.sendKeys(DaysheetData.daysheetDataLookup.get("mainproblem"));
									    driver.switchTo().activeElement().sendKeys(Keys.TAB);
									    WebElement workLevel = driver.findElement(By.xpath(DaysheetLocators.daysheetxpathLookup.get("worklevel")));
									    Select worklevel = new Select(workLevel);
									    worklevel.selectByValue("7");
									    driver.switchTo().activeElement().sendKeys(Keys.TAB);
									    WebElement signposted = driver.findElement(By.xpath(DaysheetLocators.daysheetxpathLookup.get("signpost")));
									    signposted.sendKeys(DaysheetData.daysheetDataLookup.get("signpost"));
									    driver.switchTo().activeElement().sendKeys(Keys.TAB);
									    Thread.sleep(1000);
									    WebElement signposteddetails = driver.findElement(By.xpath(DaysheetLocators.daysheetxpathLookup.get("signpostdetail")));
									    signposteddetails.click();
									    Thread.sleep(1000);
									    Utility.popUp();
									    WebElement savenclose = driver.findElement(By.xpath(DaysheetLocators.daysheetxpathLookup.get("saveNclose")));
									    savenclose.click();
									    Thread.sleep(2000);
									    driver.switchTo().window(getDefaultWin);
									    driver.switchTo().frame("menuBar");
									    WebElement logout = driver.findElement(By.xpath(DaysheetLocators.daysheetxpathLookup.get("logout")));
									    logout.click();
									    Alert logoutok = driver.switchTo().alert();
									    logoutok.accept(); 
								    }
								} catch (InterruptedException e) 
						{
							e.printStackTrace();
						} catch (FindFailed e) 
						{
							e.printStackTrace();
						}
				}

				public void tabImplement() throws InterruptedException
				{
					 WebElement mainProblemArea = driver.findElement(By.xpath(".//*[@id='cab_mainproblemareaid']"));
					    mainProblemArea.click();
					    Thread.sleep(2000);
					    Utility.tab(driver);
					    Utility.tab(driver);
					    Utility.tab(driver);
					    Utility.tab(driver);
					    Utility.tab(driver);
					    Thread.sleep(2000);
					    Utility.switchelement(driver);
					    logger.info("Enter 1");
					    Utility.switchelement(driver);
					    logger.info("Enter 2");
					    Utility.switchelement(driver);
					    logger.info("Enter 3");
					
				}
	
	
	
	
				public void mouse()
				{
					Locatable hoverItem = (Locatable) driver.findElement(By.xpath("//somexpath")); 
					Mouse mouse = ((HasInputDevices) driver).getMouse(); 
				}
				
				public void actions(){
					
					WebElement myElement =driver.findElement(By.xpath("//foo"));
					Actions builder = new Actions(driver);
					builder.moveToElement(myElement).build().perform();
				}
	
				
				public void calljs()
				{
						JavascriptLibrary jsLib = new JavascriptLibrary(); 
						WebElement tryagain =
						driver.findElement(By.xpath(".//*[@id='cab_signposteddetailsid']"));
			//			ele.sendKeys("nothing to send");
						jsLib.callEmbeddedHtmlUtils(driver, "fireevent",tryagain, "onclick");
					
				}
				
				
				@AfterClass
				public static void tearDown()
				{
					logger.info("Cleaning up !!!! ");
					if(!(driver.equals(null)))
						{
								driver.close();
						}
			//		 new Actions(driver).sendKeys(driver.findElement(By.tagName("html")), Keys.CONTROL).
			//			sendKeys(driver.findElement(By.tagName("html")),Keys.NUMPAD2).build().perform();
				}				    

	
}


