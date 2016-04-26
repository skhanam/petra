/**
 * 
 */
package com.cita.petra.locators;

import java.util.Hashtable;

/**
 * @author T_KhanamS
 *
 */
public class DaysheetLocators 
{
	@SuppressWarnings("serial")
	public final static Hashtable<String, String> daysheetxpathLookup = new Hashtable<String, String>()
	{
		{
			put("service",".//table[@id='CS']//tr//td//a//img[@id='services_24x24']");
			put("daysheet",".//*[@id='cab_daysheet']");
			put("newdaysheet",".//*[@id='_MBopenObj10008']");
			put("quantity",".//*[@id='cab_quantity']");
			put("channel",".//*[@id='cab_contactchannel']");
			put("mainproblem",".//*[@id='cab_mainproblemareaid_ledit']");
			put("worklevel",".//*[@id='cab_worklevel']");
			put("signpost",".//*[@id='cab_signpostedtoid']");
			put("signpostdetail",".//*[@id='cab_signposteddetailsid']");
			put("saveNclose",".//*[@id='_MBcrmFormSaveAndClose']");
			put("logout",".//table[@id='mnuBar1']//tr//td[1]//ul//li[7]//a//img[@src='/_imgs/LogOut.gif']");
			
			
			
		}
	};
	
}
