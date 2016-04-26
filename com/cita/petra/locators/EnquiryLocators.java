/**
 * 
 */
package com.cita.petra.locators;

import java.util.Hashtable;

/**
 * @author T_KhanamS
 *
 */
public class EnquiryLocators {
	
	@SuppressWarnings("serial")
	public final static Hashtable<String, String> enquiryXpathLookup = new Hashtable<String, String>()
	{
		{
			put("ok","btnOk");
			put("url","http://cabuwbcrm01/uat/loader.aspx");
			put("services",".//table[@id='CS']//tr//td//a//img[@id='services_24x24']");
			put("gateway",".//*[@id='cab_gateway']");
			put("findCriteria",".//*[@id='quickFindContainer']//td[1]//input[@id='findCriteria']");
			put("findGateway",".//*[@id='quickFindContainer']//td[2]//img[@src='/_imgs/qfind.gif']");
			put("getRows",".//table[@id='gridBodyTable']//tr");
			put("enquiry",".//ul[@id='crmNavBar']//li//ul//li[5]//a[@id='nav_cab_cab_gateway_incident']");
			put("newEnquiry",".//table[@id='mnuBar1']//td[1]//ul//li[@id='_MBlocAddRelatedToNonForm11210038GUID']");
			put("enquiryType",".//*[@id='casetypecode']");
			put("aic",".//ul[@id='crmNavBar']//li//ul//li[5]//a[@id='nav_cab_incident_cab_aic']");
			put("nEnquiry",".//table[@id='mnuBar1']//tr//td[1]//ul//li[@id='_MBlocAddRelatedToNonForm10060112GUID']");
			put("findCriteria",".//*[@id='quickFindContainer']//td[1]//input[@id='findCriteria']");
			put("qFind",".//*[@id='quickFindContainer']//td[2]//img[@src='/_imgs/qfind.gif']");
			put("gridTable",".//table[@id='gridBodyTable']//tr");
			put("workLevel",".//*[@id='cab_worklevel']");
		}
	};
	

}
