/**
 * 
 */
package com.cita.petra.locators;

import java.util.Hashtable;

/**
 * @author T_KhanamS
 *
 */
public class ClientLocators 
{

	

	@SuppressWarnings("serial")
	public final static Hashtable<String, String> clientxpathLookup = new Hashtable<String, String>()
	{
		{
			put("service",".//table[@id='CS']//tr//td//a//img[@id='services_24x24']");
			put("nclient",".//table[@id='mnuBar1']//tr//td[1]//ul//img[@src='/_imgs/ico_16_2_d.gif']");
			put("qas",".//table[@id='mnuBar1']//tr/td[1]//ul//li[6]//a//img[@id='ico_18_126']");
			put("fname",".//*[@id='firstname']");
			put("lname",".//*[@id='lastname']");
			put("dob",".//*[@id='cab_dateofbirth']//input[@id='DateInput']");
			put("profiletab",".//*[@id='tab2Tab']");
			put("ethnicorigin",".//*[@id='cab_ethnicorigin']");
			put("healthproblems",".//*[@id='cab_disabilityhealthproblems']");
			put("gendercode",".//*[@id='gendercode']");
			put("fcriteria",".//*[@id='quickFindContainer']//td[1]//input[@id='findCriteria']");
			put("qfind",".//*[@id='quickFindContainer']//td[2]//img[@src='/_imgs/qfind.gif']");
			put("grid",".//*[@id='gridBodyTable']//tr//td[5]");
			put("logout",".//table[@id='mnuBar1']//tr//td[1]//ul//li[7]//a//img[@src='/_imgs/LogOut.gif']");
			put("sdescription",".//div[@id='tab0']//table[@class='stdTable']//tr[1]//td//table//tr[3]//td[2]//input[@id='cab_shortdescription']");
			put("gorigin",".//*[@id='cab_gatewayorigin']");
			put("aicpOne",".//*[@id='cab_aicpart1id_ledit']");
			put("aicpTwo",".//*[@id='cab_aicpart2id']");
			put("nstep",".//div[@id='tab0']//table[@class='stdTable']//tr[2]//td//table//tr[3]//td[2]//select[@id='cab_nextstep']");
			put("befstatus",".//div[@id='tab0']//table[@class='stdTable']//tr[4]//td//table//tr[3]//td[2]//select[@id='cab_befcreationstatus']");
			put("notes",".//ul[@id='crmTabBar']//li[@id='tab1Tab']");
			put("notesdesc",".//div[@id='tab1']//table[@class='stdTable']//tr[1]//td//table//tr[3]//td[2]//textarea[@id='cab_newinformation']");
			put("qaslookup","C:\\Eclipse\\Selenium\\sikuli\\Qaslookup.png");
			put("pcardmany","C:\\Eclipse\\Selenium\\sikuli\\Postcardmany.png");
			put("selectpng","C:\\Eclipse\\Selenium\\sikuli\\Select.png");
			put("pcard","C:\\Eclipse\\Selenium\\sikuli\\postcard.png");
			put("accept","C:\\Eclipse\\Selenium\\sikuli\\Accept.png");
		}
	};
	

	

}
