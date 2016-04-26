/**
 * 
 */
package com.cita.petra.pageObject;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import com.cita.petra.common.Utility;
import com.cita.petra.locators.OutcomeLocators;

/**
 * @author T_KhanamS
 *
 */
public class OutcomePage {
			
				final static Logger logger = Logger.getLogger("com.cita.petra.regression.OutcomePage");
				public static Screen screen; 
	
				public static void saveNCloseTask(WebDriver driver)
				{
					WebElement subject = driver.findElement(By.xpath(".//form[@name='crmForm']//tr[3]//div[1]//table[@class='stdTable']//tr[1]//tbody//tr[1]//input[@id='subject']"));
		    		subject.sendKeys("Auto Regression Task create");
		    		Utility.saveNClose(driver);
		    		driver.quit();
		        }
		
				
				public static void outcomeCheck(WebDriver driver) throws InterruptedException
				{
							WebElement chkOutcome = driver.findElement(By.xpath(OutcomeLocators.xpathLookup.get("outcome")));
							chkOutcome.click();
							Thread.sleep(1000);
							chkOutcome.click();
				}
				
				
				
				public static void newAic() throws FindFailed,InterruptedException
				{
					screen = new Screen();
					screen.click(OutcomeLocators.xpathLookup.get("newaicpng"),100);
					Thread.sleep(1000);

					
				}
			
				
				
				public static void outcomeDetails(WebDriver driver) throws FindFailed, InterruptedException
				{
							Screen screen;
							WebElement outcomeAchieved = driver.findElement(By.xpath(".//*[@id='cab_howtheoutcomewasachieved']"));
							Select selectoutcomeAchieved = new Select(outcomeAchieved);
							selectoutcomeAchieved.selectByValue("3");
							WebElement outcomeType = driver.findElement(By.xpath(".//*[@id='cab_typeofoutcome']"));
							Select outcomeTypeSelect = new Select(outcomeType);
							outcomeTypeSelect.selectByValue("1");
							WebElement coreOutcome = driver.findElement(By.xpath(".//table[@class='stdTable']//tr[5]//table//tr//td[@id='cab_coreoutcomeid_d']//tr//td[2]//img[@id='cab_coreoutcomeid']"));
							coreOutcome.click();
							screen = new Screen();
							screen.exists("C:\\Eclipse\\Selenium\\sikuli\\outcome.png");
							Thread.sleep(1000);
							screen.click("C:\\Eclipse\\Selenium\\sikuli\\OK.png");
							
				}
			
	
	
}
