/**
 * 
 */
package com.cita.petra.datalocators;

import java.util.Hashtable;

/**
 * @author T_KhanamS
 *
 */
public class GatewayData {
	
				
	@SuppressWarnings("serial")
	public static final Hashtable<String, String> dataLookup = new Hashtable<String, String>(){
		{
			put("shortdecs","Autoregression Gateway create");
			put("notesdecs","Notes description Gateway");
			put("aicone","Debt");
		}
	};

}
