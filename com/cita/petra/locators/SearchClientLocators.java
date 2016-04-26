/**
 * 
 */
package com.cita.petra.locators;

import java.util.Hashtable;

/**
 * @author T_KhanamS
 *
 */
public class SearchClientLocators {
	
				@SuppressWarnings("serial")
				public
				final static Hashtable<String,String> clientXpathlookup = new Hashtable<String,String>()
				{
					{
						put("ok","btnOk");
						put("service",".//table[@id='CS']//tr//td//a//img[@id='services_24x24']");
						put("find",".//*[@id='quickFindContainer']//td[1]//input[@id='findCriteria']");
						put("search",".//*[@id='quickFindContainer']//td[2]//img[@src='/_imgs/qfind.gif']");
						put("client",".//*[@id='gridBodyTable']//tr//td[5]");
						put("logoff",".//table[@id='mnuBar1']//tr//td[1]//ul//li[7]//a//img[@src='/_imgs/LogOut.gif']");
					}
				};

}
