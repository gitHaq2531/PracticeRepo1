package com.client.shoProd.generic.javaUtility;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Javautils 
{
		//to get random number....
		public int getRandomValue(){
			Random random=new Random();
			int randomInt=random.nextInt(5000);
			return randomInt;
		}
		
		//to get timestamp....
		public String getCurrentTimeStamp() {
			String timeStamp=LocalDateTime.now().toString().replace(':', '-');
			return timeStamp;
		}
		
		//to get current date in format....
		public String getCurrentDateYYYYMMdd()
		{
			Date dateObj= new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd");
			String actDate=sdf.format(dateObj);
			return actDate;
		}
		
		//to get end date....
		public String getEndDateYYYYMMdd(int days)
		{
			Date dateObj=new Date();
			SimpleDateFormat simpleDate=new SimpleDateFormat("yyyy-MM-dd");	
			simpleDate.format(dateObj);

			Calendar cal=simpleDate.getCalendar();
			cal.add(Calendar.DAY_OF_MONTH, days);
			String endDate=simpleDate.format(cal.getTime());
			return endDate;
		}
}
