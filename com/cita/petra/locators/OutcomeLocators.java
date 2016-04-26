/**
 * 
 */
package com.cita.petra.locators;

import java.util.Hashtable;

/**
 * @author T_KhanamS
 *
 */
public class OutcomeLocators {
	
	
	@SuppressWarnings("serial")
	public static final Hashtable<String, String> xpathLookup = new Hashtable<String, String>()
	{
		{
			put("service",".//table[@id='CS']//tr//td//a//img[@id='services_24x24']");
			put("enquiry",".//*[@id='nav_cases']");
			put("searchclient",".//*[@id='quickFindContainer']//td[1]//input[@id='findCriteria']");
			put("gatewayfinder",".//*[@id='quickFindContainer']//td[2]//img[@src='/_imgs/qfind.gif']");
			put("rowcount",".//table[@id='gridBodyTable']//tr");
			put("aic","C:\\Eclipse\\Selenium\\sikuli\\AIC.png");
			put("newaic","C:\\Eclipse\\Selenium\\sikuli\\newaic.png");
			put("aicone",".//*[@id='cab_aicpart1id_ledit']"); 
			put("aiconepng","C:\\Eclipse\\Selenium\\sikuli\\aicone.png");
			put("removepng","C:\\Eclipse\\Selenium\\sikuli\\remove.png");
			put("aictwo",".//*[@id='cab_aicpart2id']");
			put("aictwopng","C:\\Eclipse\\Selenium\\sikuli\\aicPart2.png");
			put("aictwookpng","C:\\Eclipse\\Selenium\\sikuli\\aicpart2ok.png");
			put("aicthree",".//*[@id='cab_aicpart3id']");
			put("aicthreepng","C:\\Eclipse\\Selenium\\sikuli\\aicpart3.png");
			put("aicthreeokpng","C:\\Eclipse\\Selenium\\sikuli\\OK.png");
			put("save",".//*[@id='_MBcrmFormSave']");
			put("saveNclose",".//*[@id='_MBcrmFormSaveAndClose']");
			put("newaicpng","C:\\Eclipse\\Selenium\\sikuli\\newaic.png");
			put("outcome",".//*[@id='cab_outcomeready']");
			put("activitiespng","C:\\Eclipse\\Selenium\\sikuli\\activities.png");
			put("newactivitiespng","C:\\Eclipse\\Selenium\\sikuli\\newactiviti.png");
		}
	};
	

}
