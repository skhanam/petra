/**
 * 
 */
package com.cita.petra.datalocators;

import java.util.Hashtable;

/**
 * @author T_KhanamS
 *
 */
public class SearchClientData {

	@SuppressWarnings("serial")
	public static final Hashtable<String , String > searchDatalookup = new Hashtable<String,String>()
	{ 
		{
			put("postcode","E16 2NA");
		}	
	};
	
	
	

	
	@SuppressWarnings("serial")
	public static final Hashtable<String, String> clientDatalookup = new Hashtable<String,String>()
	{
		{
			put("name","autolname");
		}
	} ;
	
}
