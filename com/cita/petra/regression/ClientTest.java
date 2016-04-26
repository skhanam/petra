/**
 * 
 */
package com.cita.petra.regression;

import static org.junit.Assert.*;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Set;
import java.util.logging.Logger;
import org.junit.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.net.UrlChecker.TimeoutException;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import com.cita.petra.common.Utility;
import com.cita.petra.common.Datagenerator;
import com.cita.petra.datalocators.ClientData;
import com.cita.petra.locators.ClientLocators;
import com.cita.petra.pageObject.ClientPage;

/**
 * @author T_khanamS
 *
 */
public class ClientTest
{
		final static Logger logger = Logger.getLogger("com.cita.petra.regression.ClientTest");
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
		public void testClient() throws TimeoutException, InterruptedException, FindFailed, IllegalAccessException
		{
			
			
			try {
							Thread.sleep(3000);
							WebElement  continuebtn = driver.findElement(By.id("btnOk"));
							logger.info("Contents of : "+continuebtn);
							continuebtn.click();
							Thread.sleep(3000);
							driver.switchTo().frame("nav");
							WebElement  service = driver.findElement(By.xpath(ClientLocators.clientxpathLookup.get("service")));
							service.click();
							Thread.sleep(3000);
							driver.switchTo().defaultContent();
							driver.switchTo().frame("stage");
							WebElement newClient = driver.findElement(By.xpath(ClientLocators.clientxpathLookup.get("nclient")));
							newClient.click();
							Thread.sleep(3000);
							String getDefaultWin = driver.getWindowHandle();
						    logger.info("Default Window is : "+getDefaultWin);
							Set<String> getAllWindows = driver.getWindowHandles();
						    logger.info("Print all windows : " + getAllWindows);
						    int hasmorewin = getAllWindows.size();
						    logger.info("Count of windows : "+hasmorewin);
						    if(hasmorewin > 0)
						    {
						    	String getClientNew = (String) getAllWindows.toArray()[1];
						    	driver.switchTo().window(getClientNew);
						    	logger.info("Get the title of New Client Window : " + driver.getTitle());
						    	Thread.sleep(3000);
						    	// QAS Look up
						    	WebElement QASLookup = driver.findElement(By.xpath(ClientLocators.clientxpathLookup.get("qas")));
						    	QASLookup.click();
						    	Thread.sleep(2000);
						    	try {
									ClientPage.select(driver,ClientData.clientDatalookup.get("postcode"));
								} catch (FindFailed e) {
									e.printStackTrace();
								}
						    	WebElement fname = driver.findElement(By.xpath(ClientLocators.clientxpathLookup.get("fname")));
						    	fname.clear(); 
						    	long dynanumber = System.currentTimeMillis();
						    	logger.info("Dynamic number : " + dynanumber);
						    	fname.sendKeys(Datagenerator.getRandomString());
						    	WebElement lname = driver.findElement(By.xpath(ClientLocators.clientxpathLookup.get("lname")));
						    	lname.clear();
						    	lname.sendKeys("autolname"+Datagenerator.getRandomString());
						    	WebElement dob = driver.findElement(By.xpath(ClientLocators.clientxpathLookup.get("dob")));
						    	dob.clear();
						    	dob.sendKeys(Datagenerator.getDate());
						    	dob.sendKeys(Keys.TAB);
						    	WebElement profileTab = driver.findElement(By.xpath(ClientLocators.clientxpathLookup.get("profiletab")));
						    	profileTab.click();
						    	WebElement ethnicOrigin = driver.findElement(By.xpath(ClientLocators.clientxpathLookup.get("ethnicorigin")));
						    	Select ethnicvalue = new Select(ethnicOrigin);
						    	ethnicvalue.selectByValue("2");
						    	WebElement dishproblems = driver.findElement(By.xpath(ClientLocators.clientxpathLookup.get("healthproblems")));
						    	Select dishprobvalue = new Select(dishproblems);
						    	dishprobvalue.selectByValue("3");
						    	WebElement gender = driver.findElement(By.xpath(ClientLocators.clientxpathLookup.get("gendercode")));
						    	Select gendervalue = new Select(gender);
						    	gendervalue.selectByValue("2");
						    	ClientPage.save(driver);
//						    	String clientNumber = getClientNumber(driver);
						    	ClientData.clientDatalookup.put("clientNo",ClientPage.getClientNumber(driver));
//						    	datalookup.put(clientNo, clientNumber);
						    	logger.info("Client Number within Test : " + ClientData.clientDatalookup.get("clientNo"));
						    	ClientPage.saveNClose(driver);
						    	Thread.sleep(2000);
							    driver.switchTo().window(getDefaultWin);
							    driver.switchTo().frame("stage");
							    WebElement searchClient = driver.findElement(By.xpath(ClientLocators.clientxpathLookup.get("fcriteria")));
							    searchClient.sendKeys(ClientData.clientDatalookup.get("clientNo"));
							    WebElement clientFinder = driver.findElement(By.xpath(ClientLocators.clientxpathLookup.get("qfind")));
							    clientFinder.click();
							    Thread.sleep(1000);
						    	WebElement clientdetails = driver.findElement(By.xpath(ClientLocators.clientxpathLookup.get("grid")));
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
									    	logger.info("This is new Client Window  : "+getClientExisting);
									    	driver.switchTo().window(getClientExisting);
									    	logger.info("Get the title of existing client : " + driver.getTitle());
									    	Thread.sleep(1000);
									    	if(driver.getTitle().startsWith("Client"))
									    	{
									    		assertTrue(true);
									    	}
									    	createGateway(driver);
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
												    	logger.info("Get the title of Gateway : " + driver.getTitle());
												    	Thread.sleep(2000);
												    	gatewayDetails(driver);
												    	
										    		}
												    driver.switchTo().window(getClientExisting);
												    Thread.sleep(1000);
												    ClientPage.saveNClose(driver);
												    searchGateway(driver);
												    Enquiries(driver);
							    		}	
									    	Thread.sleep(1000);
										    driver.switchTo().window(getDefaultWin);
										    driver.switchTo().frame("menuBar");
										    WebElement logout = driver.findElement(By.xpath(ClientLocators.clientxpathLookup.get("logout")));
										    logout.click();
										    Alert logoutok = driver.switchTo().alert(); 
										    logoutok.accept();
			//						    	driver.switchTo().defaultContent();
			//						    	searchClient(driver,getClientNumber(driver));
							}
				}catch(NoSuchElementException ex) 
				{
								ex.printStackTrace();
				}
			
		}
		
		public void gatewayDetails(WebDriver driver) throws TimeoutException,InterruptedException, FindFailed
		{
				Thread.sleep(1000);
				WebElement shortDecs = driver.findElement(By.xpath(ClientLocators.clientxpathLookup.get("sdescription")));
				shortDecs.sendKeys("Autoregression Gateway create");
				WebElement gatewayChannel = driver.findElement(By.xpath(ClientLocators.clientxpathLookup.get("gorigin")));
				Select selectchannel = new Select(gatewayChannel);
				selectchannel.selectByValue("3");
				WebElement aicpart1 = driver.findElement(By.xpath(ClientLocators.clientxpathLookup.get("aicpOne")));
				aicpart1.sendKeys(ClientData.clientDatalookup.get("aicOne"));
				WebElement aicpart2 = driver.findElement(By.xpath(ClientLocators.clientxpathLookup.get("aicpTwo")));
				aicpart2.click();
				aicpart2.click();
				Thread.sleep(2000);
				ClientPage.aicpart2();
				WebElement nextStep = driver.findElement(By.xpath(ClientLocators.clientxpathLookup.get("nstep")));
				Select selnextStep = new Select(nextStep);
				selnextStep.selectByValue("5");
				WebElement bef = driver.findElement(By.xpath(ClientLocators.clientxpathLookup.get("befstatus")));
				Select befstatus = new Select(bef);
				befstatus.selectByValue("3");
				WebElement notestab = driver.findElement(By.xpath(ClientLocators.clientxpathLookup.get("notes")));
				notestab.click();
				WebElement notesdesc = driver.findElement(By.xpath(ClientLocators.clientxpathLookup.get("notesdesc")));
				notesdesc.sendKeys(ClientData.clientDatalookup.get("notesdesc"));
				Utility.save(driver);
				Thread.sleep(1000);
				getGatewayNumber(driver);
				Thread.sleep(2000);
				Utility.saveNClose(driver);
		}
		
		
		public void createGateway(WebDriver driver) throws TimeoutException, InterruptedException
		{	
			 WebElement Gateway = driver.findElement(By.xpath(".//*[@id='nav_cab_contact_cab_gateway']"));
			 Gateway.click();
			 Thread.sleep(2000);
			 driver.switchTo().frame("cab_contact_cab_gatewayFrame");
			 WebElement newGateway = driver.findElement(By.xpath(".//table[@id='mnuBar1']//tr//td[1]//ul//li[@id='_MBlocAddRelatedToNonForm100382GUID']"));
			 newGateway.click();
			 Thread.sleep(2000);
		}
		
		
		
		public void addressManual(WebDriver driver)
		{	
		    /*	WebElement addrLinel = driver.findElement(By.xpath(".//*[@id='address1_line1']"));
	    	addrLinel.sendKeys("Marie-Stopes Centre 1b Raleigh Gardens");
	    	WebElement addrCity = driver.findElement(By.xpath(".//*[@id='address1_city']"));
	    	addrCity.sendKeys("LONDON");
	    	WebElement addrPostcode = driver.findElement(By.xpath(".//*[@id='address1_postalcode']"));
	    	addrPostcode.sendKeys("SW2 1AB"); */
		} 
		
		
		public static String getGatewayNumber(WebDriver driver)
		{
					WebElement getGateway = driver.findElement(By.xpath("//div[@id='tab1']//table[@class='stdTable']//tr[2]//td//table//tr[3]//td[2]//input[@id='cab_name']"));
					String getGatewayNo = getGateway.getAttribute("value");
					logger.info("Gateway Number is : " + getGatewayNo);
					return getGatewayNo;
		}
		
		public void searchGateway(WebDriver driver) throws InterruptedException
		{
					
					driver.switchTo().frame("cab_contact_cab_gatewayFrame");
					WebElement clientdetails = driver.findElement(By.xpath(".//*[@id='gridBodyTable']//tr//td[10]"));
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
		
		
		public void Enquiries(WebDriver driver) throws InterruptedException
		{
					
					WebElement enquiry = driver.findElement(By.xpath(".//ul[@id='crmNavBar']li//ul//li[5]//a[@id='nav_cab_cab_gateway_incident']"));
					enquiry.click();
					Thread.sleep(1000);
					driver.switchTo().frame("cab_cab_gateway_incidentFrame");
					WebElement newenquiry = driver.findElement(By.xpath(".//table[@id='mnuBar1']//td[1]//ul//li[@id='_MBlocAddRelatedToNonForm11210038GUID']"));
					newenquiry.click();
					String getDefWin = driver.getWindowHandle();
				    logger.info("Default Window is : "+getDefWin);
				    Set<String> getNewWindows = driver.getWindowHandles();
				    logger.info("Print all windows : " + getNewWindows);
				    int hasmorenewwin = getNewWindows.size();
				    logger.info("Count of windows : "+hasmorenewwin);
						    if(hasmorenewwin > 0)
						    {
						    	String getNewEnquiry = (String) getNewWindows.toArray()[4];
						    	logger.info("This is new Enquiry Window  : "+getNewEnquiry);
						    	driver.switchTo().window(getNewEnquiry);
						    	logger.info("Get the title of New Enquiry : " + driver.getTitle());
						    	Thread.sleep(1000);
						    	if(driver.getTitle().startsWith("Enquiry"))
						    	{
						    		assertTrue(true);
						    	}
						    }
					
		} 
		
	/*	
		@AfterClass
		public static void tearDown()
		{
			try {
				
				Runtime.getRuntime().exec("C:\\Eclipse\\Selenium\\cancel.exe");
			} catch (IOException e) 
			{
				e.printStackTrace();
			}
			if(driver != null)
			{
				driver.quit();
			}
			
		}  */
		
		
		
}
