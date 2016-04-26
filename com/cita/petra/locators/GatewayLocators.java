/**
 * 
 */
package com.cita.petra.locators;

import java.util.Hashtable;

/**
 * @author T_KhanamS
 *
 */
public class GatewayLocators {
			
	
	@SuppressWarnings("serial")
	public static final Hashtable<String, String> xpathLookup = new Hashtable<String, String>(){
		{
			put("service",".//table[@id='CS']//tr//td//a//img[@id='services_24x24']");
			put("searchclient",".//*[@id='quickFindContainer']//td[1]//input[@id='findCriteria']");
			put("clientfinder",".//*[@id='quickFindContainer']//td[2]//img[@src='/_imgs/qfind.gif']");
			put("rowcount",".//table[@id='gridBodyTable']//tr");
			put("logout",".//table[@id='mnuBar1']//tr//td[1]//ul//li[7]//a//img[@src='/_imgs/LogOut.gif']");
			put("gateway",".//*[@id='nav_cab_contact_cab_gateway']");
			put("newgateway",".//table[@id='mnuBar1']//tr//td[1]//ul//li[@id='_MBlocAddRelatedToNonForm100382GUID']");
			put("lookup","C:\\Eclipse\\Selenium\\sikuli\\LookupRecords.png");
			put("okaic","C:\\Eclipse\\Selenium\\sikuli\\okaic.png");
			put("getgateway","//div[@id='tab1']//table[@class='stdTable']//tr[2]//td//table//tr[3]//td[2]//input[@id='cab_name']");
			put("shortdesc",".//div[@id='tab0']//table[@class='stdTable']//tr[1]//td//table//tr[3]//td[2]//input[@id='cab_shortdescription']");
			put("gatewaychanel",".//*[@id='cab_gatewayorigin']");
			put("aicone",".//*[@id='cab_aicpart1id_ledit']");
			put("aictwo",".//*[@id='cab_aicpart2id']");
			put("nextstep",".//div[@id='tab0']//table[@class='stdTable']//tr[2]//td//table//tr[3]//td[2]//select[@id='cab_nextstep']");
			put("bef",".//div[@id='tab0']//table[@class='stdTable']//tr[4]//td//table//tr[3]//td[2]//select[@id='cab_befcreationstatus']");
			put("notestab",".//ul[@id='crmTabBar']//li[@id='tab1Tab']");
			put("notesdesc",".//div[@id='tab1']//table[@class='stdTable']//tr[1]//td//table//tr[3]//td[2]//textarea[@id='cab_newinformation']");
			put("clientdetails",".//*[@id='gridBodyTable']//tr//td[10]");
		}
	};
}
