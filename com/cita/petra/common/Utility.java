/**
 * 
 */
package com.cita.petra.common;

import java.io.IOException;

import java.util.logging.Logger;
import java.util.Hashtable;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;


/**
 * @author T_khanamS
 *
 */

/*
 *   This is a Utility class that has  
 *   most common methods for data creation
 *   I have moved to using Thread.Sleep to handle js executor or async as there is no enough 
 *   support from the development team 
 *   Which is not ideal but works well in our scenario
 */
public class Utility 
{
			public static Screen screen;
			public static WebDriver driver;
			public static final Logger logger = Logger.getLogger("com.cita.petra.common.Utility");
		
			/*
			 *  storing xpath & other values in Hashtable
			 *  for a centralised change in data 
			 */
			
			
			@SuppressWarnings("serial")
			public final static Hashtable<String, String> xpathLookup = new Hashtable<String, String>()
			{
				{
					  put("savebtn",".//table[@id='mnuBar1']//tr//td[1]//ul//li[@id='_MBcrmFormSave']");
					  put("saveandclosebtn",".//table[@id='mnuBar1']//tr//td[1]//ul//li[3]//img[@src='/_imgs/ico/16_saveClose.gif']");
					  put("imglookup","C:\\Eclipse\\Selenium\\sikuli\\LookupRecords.png");
					  put("imgok","C:\\Eclipse\\Selenium\\sikuli\\OK.png");
					  put("imgaictwo","C:\\Eclipse\\Selenium\\sikuli\\aicPart2.png");
					  put("imgaictwook","C:\\Eclipse\\Selenium\\sikuli\\aicpart2ok.png");
				
				}
			};
			
		
			
			/*
			 *  This method gets existing a client 
			 *  @param WebDriver
			 *  @param WebElement
			 *  @throws NoSuchElementException
			 */
			
			public static void getClient(WebDriver driver,WebElement element)  throws NoSuchElementException
			{
//				screen.doubleClick("C:\\Eclipse\\Selenium\\sikuli\\getclient.png",100);
				Actions  action = new Actions(driver);
			    action.doubleClick(element);
			    action.perform();
				
			}
			
			/*
			 *   Save any record 
			 *   @params WebDriver 
			 *   @throws NoSuchElementException
			 */
			
			public static void save(WebDriver driver) throws NoSuchElementException
			{
//				WebElement save = driver.findElement(By.xpath(".//table[@id='mnuBar1']//tr//td[1]//ul//li[2]//img[@src='/_imgs/ico/16_save.gif']"));
				WebElement save = driver.findElement(By.xpath(xpathLookup.get("savebtn")));
		    	save.click();
			} 
			
			/*
			 *   This method handles popUp
			 *   This method looks for an image in question
			 *   else throws the exception
			 *   When an image is found performs other action
			 *   @throws FindFailed
			 *   @throws InterruptedException	
			 *   @throws NoSuchElementException		
			 */
			
			
			public static void popUp() throws FindFailed, InterruptedException, NoSuchElementException
			{
				   Screen screen = new Screen();
				   screen.exists(xpathLookup.get("imglookup"), 10);
				   Thread.sleep(1000);
				   screen.click(xpathLookup.get("imgok"),0);
			}
			
			
			/*
			 *   This method handles LOV
			 *   This method looks for an image in question
			 *   else throws the exception
			 *   When an image is found performs other action
			 *   @throws FindFailed
			 *   @throws InterruptedException
			 *   @throws NoSuchElementException
			 */
			
			
			@SuppressWarnings("null")
			public static void aicParttwo() throws FindFailed , InterruptedException, NoSuchElementException
			{
				   Screen scrn = null;
//				   scrn.find("C:\\Eclipse\\Selenium\\sikuli\\aicPart2.png");
				   scrn.exists(xpathLookup.get("imgaictwo"), 2000);
				   Thread.sleep(10);
				   scrn.click(xpathLookup.get("imgaictwook"),10);
			}
			
			
			
			/*
			 *   This method handles LOV
			 *   This method looks for an image in question
			 *   else throws the exception
			 *   When an image is found performs other action
			 *	 @throws FindFailed 
			 *   @throws InterruptedException 
			 */
			
			public static void aicPartthree() throws FindFailed , InterruptedException
			{
				   screen.exists("C:\\Eclipse\\Selenium\\sikuli\\aicpart3.png",10);
				   Thread.sleep(10);
				   screen.click("C:\\Eclipse\\Selenium\\sikuli\\OK.png",10);
			}
			
			
			/*
			 *      This method handles SaveNClose
			 *      @param WebDriver 
			 *      @throws NoSuchElementException  
			 * 
			 */
			public static void saveNClose(WebDriver driver) throws NoSuchElementException
			{
				WebElement save = driver.findElement(By.xpath(xpathLookup.get("saveandclosebtn")));
		    	save.click();
			}
		
			
			
			
			
			/*
			 *   This method may be used to initialize 
			 *   As we deal with only IE browser 
			 *   Launch the IE 
			 *   pass the url
			 *   @throws 
			 *   @param
			 *   @return driver
			 */
			public static WebDriver initialize()
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
				return driver;
			}
			
			public static void tab(WebDriver driver){
				driver.switchTo().activeElement().sendKeys(Keys.TAB);
			}
			
			public static void switchelement(WebDriver driver){
				driver.switchTo().activeElement().sendKeys(Keys.ENTER);
			}
}
