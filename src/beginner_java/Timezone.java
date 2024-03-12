package beginner_java;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Timezone {
	public static void main (String [] args) {
		
		
		//Date Formatting - Import UTILITY Classes on line 1
		Date today = new Date();
		DateFormat df = new SimpleDateFormat("MM-dd-yyyy / hh:mm:ss a");
		df.setTimeZone(TimeZone.getTimeZone("UTC"));
		String UTC = df.format(today);
		
		//Now Print Date And Time of PST With Above Code and Formatting
		System.out.println("UTC TIMEZONE: ");
		System.out.println("===============");
		System.out.println("Current Date: " + today);
		System.out.println("Current Time: (UTC) " + UTC);
		System.out.println("-------------");
		System.out.println();
		
		//Formatting to PST TimeZone (Same Steps as Above but change to PST)
		df.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
		String PST = df.format(today);
		
		//Now Print Date And Time of PST With Above Code and Formatting
		System.out.println("PST TIMEZONE: ");
		System.out.println("===============");
		System.out.println("Current Date: " + today);
		System.out.println("Current Time: (PST) " + PST);
		System.out.println("-------------");
		
		//Adding how many seconds into the day		
		long millis = System.currentTimeMillis();
		System.out.println("\nSECONDS TODAY: ");
		System.out.println("===============");
		System.out.println("Current Milliseconds Today: " + millis);
		System.out.println("Current Seconds Today: " + millis / 1000);  
		System.out.println("--");
	}

}
