package com.cita.petra.pageObject;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import com.cita.petra.datalocators.ClientData;
import com.cita.petra.locators.ClientLocators;

public class ClientPage 
{
					final static Logger logger = Logger.getLogger("com.cita.petra.regression.ClientPage");
					public static Screen screen; 
					
					public static void save(WebDriver driver)
					{
						WebElement save = driver.findElement(By.xpath(".//table[@id='mnuBar1']//tr//td[1]//ul//li[2]//img[@src='/_imgs/ico/16_save.gif']"));
				    	save.click();
					} 
	
					
					public static void saveNClose(WebDriver driver)
					{
						WebElement save = driver.findElement(By.xpath(".//table[@id='mnuBar1']//tr//td[1]//ul//li[3]//img[@src='/_imgs/ico/16_saveClose.gif']"));
				    	save.click();
					}
					
					
					public static void select(WebDriver driver,String postcode) throws FindFailed
					{
							screen = new Screen();
							screen.exists(ClientLocators.clientxpathLookup.get("qaslookup"), 100);
							screen.type(postcode);
							screen.click(ClientLocators.clientxpathLookup.get("pcardmany"),1000);
							screen.click(ClientLocators.clientxpathLookup.get("selectpng"),1000);
							screen.click(ClientLocators.clientxpathLookup.get("pcard"),1000);
							screen.click(ClientLocators.clientxpathLookup.get("accept"),1000);
							
					}
	
					public static void aicpart2() throws InterruptedException, FindFailed
					{
						   	   screen.exists("C:\\Eclipse\\Selenium\\sikuli\\LookupRecords.png", 10);
							   Thread.sleep(10);
							   screen.click("C:\\Eclipse\\Selenium\\sikuli\\okaic.png",0);
						
					}
					
					
					
					
					public static String  getClientNumber(WebDriver driver)
					{
						WebElement FurtherdetailsTab = driver.findElement(By.xpath(".//*[@id='tab3Tab']"));
				    	FurtherdetailsTab.click();	
				    	WebElement cnumber = driver.findElement(By.xpath(".//*[@id='cab_uniquebefreferencenumber']"));
				    	final String getcnumber = cnumber.getAttribute("value");
				    	logger.info("Client Number within method : "+getcnumber);
				    	return getcnumber;
					}
					
					
					public static void searchClient(WebDriver driver,String passCliNum)
					{
							driver.switchTo().frame("Content Area");
							WebElement searchCli = driver.findElement(By.xpath(".//*[@id='findCriteria']"));
							searchCli.sendKeys(passCliNum);
							
					}
}
