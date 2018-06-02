package calendar;

import java.util.Calendar;
import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Random Test Generator  for Appt class.
 * Using aburasa's ApptRandomTest starting code, slightly modified
 * SRC: https://github.com/aburasa/CS362-001-S2018/blob/master/projects/aburasa/Assignment-4/Calendar/src/test/java/calendar/ApptRandomTest.java 
 */

public class ApptRandomTest {
	//private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final long TestTimeout = 5 * 1000; //1000 = 1 second
	private static final int NUM_TESTS=100;

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
     * Generate Random Tests that tests Appt Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {

		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
		 int iteration = 0;
		 long oldElapsed = 0;
		 
		 System.out.println("Start testing Appt...");
		 
		 try{ 
			for (iteration = 0; elapsed < TestTimeout; iteration++) {
				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				//if((iteration%1000000)==0 && iteration!=0 ) { System.out.println("test: " + iteration + ", elapsed time: " + elapsed + " of "+TestTimeout);}
				if(((elapsed%500)==0) && (iteration!=0) && (oldElapsed != elapsed)) { 
					System.out.println("test: " + iteration + ", elapsed time: " + elapsed + " of "+TestTimeout); 
					oldElapsed = elapsed;
				}  
				
				long randomseed =System.currentTimeMillis(); //10
				//System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);
				
				//random numbers
				int startHour=ValuesGenerator.getRandomIntBetween(random, 0, 34) - 6;
				int startMinute=ValuesGenerator.getRandomIntBetween(random, 0, 64) - 1;
				int startDay=ValuesGenerator.getRandomIntBetween(random, 0, 36) -1;
				int startMonth=ValuesGenerator.getRandomIntBetween(random, 0, 14) -1;
				int startYear=ValuesGenerator.getRandomIntBetween(random, 1, 2025) - 5;
				String title="Birthday Party";
				String description="This is my birthday party.";
				String emailAddress="xyz@gmail.com";

				//Construct a new Appointment object with the initial data	 
				Appt appt = new Appt(startHour, startMinute, startDay, startMonth, 
						startYear, title, description, emailAddress);

				//check if equal
				assertEquals(startHour,appt.getStartHour());
				assertEquals(startMinute,appt.getStartMinute());
				assertEquals(startDay,appt.getStartDay());
				assertEquals(startMonth,appt.getStartMonth());
				assertEquals(startYear,appt.getStartYear());

				//will not work otherwise- setValid fails in CalUtil NumDaysInMonth
				if(startMonth<12){	
					appt.setValid(); //set valid
				}
				else if (startMonth>12 && startDay<28 && startDay>0 && startYear > 0){
					//System.out.println("Value: "+startDay+"."+startMonth+"."+startYear);
					appt.setValid(); //set valid
				}
				else { continue; } //not in this range, get new random numbers
				//if(!appt.getValid())continue; //check if not valid
				if(appt.getValid()){ //check if valid
					for (int i = 0; i < NUM_TESTS; i++) {
						//get random method to test
						String methodName = ApptRandomTest.RandomSelectMethod(random);
						if (methodName.equals("setTitle")){ //title test
							String newTitle=(String) ValuesGenerator.getString(random);
							appt.setTitle(newTitle);						   
						}
						else if (methodName.equals("setRecurrence")){ //recurrence test
							int nullOrNot=ValuesGenerator.getRandomIntBetween(random, 0, 30);
							int[] recurDays;
							if(nullOrNot!=0) { 
								int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
								recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
							}
							else { //if 0 -> then use a null value
								recurDays = null;  //test setRecurdays
							}
							//setup recurrence
							int recur=ApptRandomTest.RandomSelectRecur(random);
							int recurIncrement = ValuesGenerator.RandInt(random);
							int recurNumber = ApptRandomTest.RandomSelectRecurForEverNever(random);
							appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
							//test isOn - each number
							assertTrue(appt.isOn(startDay, startMonth, startYear));
							assertFalse(appt.isOn(startDay-1, startMonth, startYear));
							assertFalse(appt.isOn(startDay, startMonth-1, startYear));
							assertFalse(appt.isOn(startDay, startMonth, startYear-1));
						}				
					}
				}


			}
		}catch(NullPointerException e){
			
		}
	 
		 System.out.println("Done testing, " + iteration + " tests.");
	}

}
