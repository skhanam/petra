/**
 * 
 */
package com.cita.petra.locators;

import java.util.Hashtable;

/**
 * @author T_KhanamS
 *
 */
public class AicLocators {
			
	
				@SuppressWarnings("serial")
				public final static Hashtable<String ,String>  enquirySearchLookup  = new Hashtable<String, String>()
				{
					{
						 put("url","http://cabuwbcrm01/uat/loader.aspx");
						 put("ok","btnOk");
						 put("services",".//table[@id='CS']//tr//td//a//img[@id='services_24x24']");
						 put("enquiry",".//*[@id='nav_cases']");
						 put("findcriteria",".//*[@id='quickFindContainer']//td[1]//input[@id='findCriteria']");
						 put("qfind",".//*[@id='quickFindContainer']//td[2]//img[@src='/_imgs/qfind.gif']");
						 put("rowCount",".//table[@id='gridBodyTable']//tr");
						 put("saveNclose",".//*[@id='_MBcrmFormSaveAndClose']");
						 put("aicone",".//*[@id='cab_aicpart1id_ledit']");
						 put("aictwo",".//*[@id='cab_aicpart2id']");
						 put("aicthree",".//*[@id='cab_aicpart3id']");
						 put("aicpng","C:\\Eclipse\\Selenium\\sikuli\\AIC.png");
						 put("newaicpng","C:\\Eclipse\\Selenium\\sikuli\\newaic.png");
						 put("aicparttwopng","C:\\Eclipse\\Selenium\\sikuli\\aicPart2.png");
						 put("aicparttwook","C:\\Eclipse\\Selenium\\sikuli\\aicpart2ok.png");
						 put("aicthreepng","C:\\Eclipse\\Selenium\\sikuli\\aicpart3.png");
						 put("okpng","C:\\Eclipse\\Selenium\\sikuli\\OK.png");
						 put("saveNclose",".//*[@id='_MBcrmFormSaveAndClose']");
						 put("activitiespng","C:\\Eclipse\\Selenium\\sikuli\\activities.png");
						 put("newactivitiespng","C:\\Eclipse\\Selenium\\sikuli\\newactiviti.png");
						 put("newactivitypng","C:\\Eclipse\\Selenium\\sikuli\\newactivity.png");
						 put("task",".//form[@name='crmForm']//tr[3]//div[1]//table[@class='stdTable']//tr[1]//tbody//tr[1]//input[@id='subject']");
						
						
					}
				};
}
