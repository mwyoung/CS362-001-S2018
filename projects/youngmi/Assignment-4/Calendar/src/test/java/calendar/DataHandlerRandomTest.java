package calendar;

import java.util.Calendar;
import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.GregorianCalendar;
import java.util.LinkedList;

/**
 * Random Test Generator for DataHandler class.
 */

public class DataHandlerRandomTest {
	//private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
		private static final long TestTimeout = 5*1000; //1000 = 1 second

		/**
		 * Return a randomly selected method to be tests !.
		 */
	    public static String RandomSelectMethod(Random random){
	    	// The list of the of methods to be tested in the Appt class
	        String[] methodArray = new String[] {"setTitle","setRecurrence"};

	        // get a random number between 0 (inclusive) and  methodArray.length (exclusive)
	    	int n = random.nextInt(methodArray.length);
	    	            
	        return methodArray[n] ; // return the method name 
	        }
		/**
		 * Return a randomly selected appointments to recur Weekly,Monthly, or Yearly !.
		 */
	    public static int RandomSelectRecur(Random random){
	    	// The list of the of setting appointments to recur Weekly,Monthly, or Yearly
	        int[] RecurArray = new int[] {Appt.RECUR_BY_WEEKLY,Appt.RECUR_BY_MONTHLY,Appt.RECUR_BY_YEARLY};

	        // get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
	    	int n = random.nextInt(RecurArray.length);
	        return RecurArray[n] ; //return the value of the appointments to recur 
	        }	
		/**
		 * Return a randomly selected appointments to recur forever or Never recur  !.
		 */
	    public static int RandomSelectRecurForEverNever(Random random){
	    	// The list of the of setting appointments to recur RECUR_NUMBER_FOREVER, or RECUR_NUMBER_NEVER
	        int[] RecurArray = new int[] {Appt.RECUR_NUMBER_FOREVER,Appt.RECUR_NUMBER_NEVER};

	        // get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
	    	int n = random.nextInt(RecurArray.length);
	        return RecurArray[n] ; //return appointments to recur forever or Never recur 
	        }	
		/**
		 * Generate Random Tests that tests DataHandler Class.
		 */
		 @Test
		  public void radnomtest()  throws Throwable  {

			 long startTime = Calendar.getInstance().getTimeInMillis();
			 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
			 int iteration = 0;
			 long oldElapsed = 0;
			 
			 System.out.println("Start testing...");
			 
			 try{ 
				for (iteration = 0; elapsed < TestTimeout; iteration++) {
					long randomseed =System.currentTimeMillis(); //10
					//System.out.println(" Seed:"+randomseed );
					Random random = new Random(randomseed);
					
					//random numbers
					int startHour=ValuesGenerator.getRandomIntBetween(random, 0, 34) - 6;
					int startMinute=ValuesGenerator.getRandomIntBetween(random, 0, 64) - 1;
					int startDay=ValuesGenerator.getRandomIntBetween(random, 0, 27);
					int startMonth=ValuesGenerator.getRandomIntBetween(random, 0, 11);
					int startYear=ValuesGenerator.getRandomIntBetween(random, 1, 2025);
					String title="Birthday Party";
					String description="This is my birthday party.";
					String emailAddress="xyz@gmail.com";

					//Construct a new Appointment object with the initial data	 
					Appt appt = new Appt(startHour, startMinute, startDay, startMonth, 
							startYear, title, description, emailAddress);

					appt.setValid();
					boolean ifValid = appt.getValid();
					boolean output;
					int saveFile=ValuesGenerator.getRandomIntBetween(random, 0, 200);
					DataHandler dhfile;
					GregorianCalendar day1 = new GregorianCalendar(startYear,startMonth,startDay);
			 		GregorianCalendar day2 = new GregorianCalendar(startYear,startMonth+1,startDay+1);
			 		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
			 		
					if(saveFile>=190) {
						dhfile = new DataHandler("calendar.xml",true);
					}
				/*	else if(saveFile==1) {
						dhfile = new DataHandler("badCal.xml",true);
						calDays = (LinkedList<CalDay>) dhfile.getApptRange(day1, day2);
						assertNull(calDays);
						continue;
					} */
					else if(saveFile==2) {
						dhfile = new DataHandler("calendar.xml",false);
						try {
							dhfile.getApptRange(day2, day1);
						}
						catch (DateOutOfRangeException e) {
							//do nothing
						}
						continue;
					}
					else {
						dhfile = new DataHandler("calendar.xml",false);
					}
					
					if(saveFile!=50) {
						output = dhfile.saveAppt(appt);
						if(ifValid==true) {
							assertTrue(output);
						}
						else {
							assertFalse(output);
						}
					}
					dhfile.deleteAppt(appt);
					
					dhfile.saveAppt(appt);
					int numAppts=ValuesGenerator.getRandomIntBetween(random, 1, 11);
					for(int i=0; i<numAppts; i++) {
						Appt appt1 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description, emailAddress);
						if((i%2)==0) {
							startHour=ValuesGenerator.getRandomIntBetween(random, 0, 11);
							startMinute=ValuesGenerator.getRandomIntBetween(random, 0, 59);
						}
						else {
							startHour=ValuesGenerator.getRandomIntBetween(random, 12, 23);
							startMinute=ValuesGenerator.getRandomIntBetween(random, 0, 59);
						}
						if(i==5) {
							startHour=ValuesGenerator.getRandomIntBetween(random, 0, 23);
							startMinute=ValuesGenerator.getRandomIntBetween(random, 0, 59);
							int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
							int []recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
							int recur=ApptRandomTest.RandomSelectRecur(random);
							int recurIncrement = ValuesGenerator.RandInt(random);
							int recurNumber = ApptRandomTest.RandomSelectRecurForEverNever(random);
							appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
						}
						appt1.setStartHour(startHour);
						appt1.setStartMinute(startMinute);
						appt1.setValid();
						dhfile.saveAppt(appt1);
					}
					calDays = (LinkedList<CalDay>) dhfile.getApptRange(day1,day2);
					Appt appt2 = new Appt(startHour, startMinute, startDay, startMonth, 
							startYear+1, title, description, emailAddress);
					appt2.setValid();
					dhfile.saveAppt(appt2);
					
					for(int i=0; i< calDays.size();i++) {
						LinkedList<Appt> apptlist = calDays.get(i).getAppts();
						for(int j=0; j < apptlist.size();j++){
							Appt apptOutput=apptlist.get(j);
							apptOutput.setValid();
							assertTrue(apptOutput.getValid());
						}
					}
					
					elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
					//if((iteration%1000000)==0 && iteration!=0 ) { System.out.println("test: " + iteration + ", elapsed time: " + elapsed + " of "+TestTimeout);}
					if(((elapsed%500)==0) && (iteration!=0) && (oldElapsed != elapsed)) { 
						System.out.println("test: " + iteration + ", elapsed time: " + elapsed + " of "+TestTimeout); 
						oldElapsed = elapsed;
					}  

				}
			}catch(NullPointerException e){
				
			}
		 
			 System.out.println("Done testing, " + iteration + " tests.");
		}

}
