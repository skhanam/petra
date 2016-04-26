/**
 * 
 */
package com.cita.petra.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.logging.Logger;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.NotFoundException;

/**
 * @author T_KhanamS
 *
 */
public class Datagenerator {
	
					public static final Logger logger = Logger.getLogger("com.cita.petra.common.Datagenerator");
					
					/*
					 *  This method generates a random string
					 *  @throws IllegalAccessException
					 *  @return randomString
					 * 
					 */
					@SuppressWarnings("static-access")
					public static String getRandomString() throws IllegalAccessException
					{
						 RandomStringUtils  generateString = new RandomStringUtils();
						 String randomString = generateString.randomAlphanumeric(6);
						 logger.info("Random number Generated : "+randomString);
						 return randomString;
					}
					
	
					/*
					 *   This method is used to generate a randomNumber
					 *   accepts a positive integer
					 *   @param someNumber
					 *   @throws  
					 *   @return randomNumber
					 */
					
					public static int getRandomNumber(int someNumber)
					{
						Random randomNo = new Random();
						int randomNumber = randomNo.nextInt(someNumber);
						return randomNumber;
					}
					
					
					/*
					 *  Generates a dynamic date
					 *  @param
					 *  @return Date
					 *  @throws NotFoundException
					 */
					public static String getDate() throws NotFoundException
					{
						DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
						Calendar date = new GregorianCalendar();
						logger.info("Date is  : " + format.format(date.getTime()));
						Random rand = new Random();
						int numberofDays = rand.nextInt(200);
						logger.info("Number of Days : " +numberofDays);
						date.add(Calendar.YEAR,-numberofDays);
						logger.info("Here is the date in past : "+format.format(date.getTime()));
						String newDate = format.format(date.getTime());
						logger.info("New Date is : "+newDate);
						return newDate;
					}
}
