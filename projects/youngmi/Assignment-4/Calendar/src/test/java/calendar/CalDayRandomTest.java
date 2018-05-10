package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Calendar;
import java.util.Random;
import java.util.GregorianCalendar;

/**
 * Random Test Generator for CalDay class.
 */

public class CalDayRandomTest {

	// private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 secs */
	private static final long TestTimeout = 10 * 1000; // 1000 = 1 second
	//private static final int NUM_TESTS = 100;

	/**
	 * Return a randomly selected method to be tests !.
	 */
	public static String RandomSelectMethod(Random random) {
		// The list of the of methods to be tested in the Appt class
		String[] methodArray = new String[] { "setTitle", "setRecurrence" };

		// get a random number between 0 (inclusive) and methodArray.length (exclusive)
		int n = random.nextInt(methodArray.length);

		return methodArray[n]; // return the method name
	}

	/**
	 * Return a randomly selected appointments to recur Weekly,Monthly, or Yearly !.
	 */
	public static int RandomSelectRecur(Random random) {
		// The list of the of setting appointments to recur Weekly,Monthly, or Yearly
		int[] RecurArray = new int[] { Appt.RECUR_BY_WEEKLY, Appt.RECUR_BY_MONTHLY, Appt.RECUR_BY_YEARLY };

		// get a random number between 0 (inclusive) and RecurArray.length (exclusive)
		int n = random.nextInt(RecurArray.length);
		return RecurArray[n]; // return the value of the appointments to recur
	}

	/**
	 * Return a randomly selected appointments to recur forever or Never recur !.
	 */
	public static int RandomSelectRecurForEverNever(Random random) {
		// The list of the of setting appointments to recur RECUR_NUMBER_FOREVER, or
		// RECUR_NUMBER_NEVER
		int[] RecurArray = new int[] { Appt.RECUR_NUMBER_FOREVER, Appt.RECUR_NUMBER_NEVER };

		// get a random number between 0 (inclusive) and RecurArray.length (exclusive)
		int n = random.nextInt(RecurArray.length);
		return RecurArray[n]; // return appointments to recur forever or Never recur
	}

	/**
	 * Generate Random Tests that tests CalDay Class.
	 */
	@Test
	public void radnomtest() throws Throwable {

		long startTime = Calendar.getInstance().getTimeInMillis();
		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
		int iteration = 0;
		long oldElapsed = 0;

		System.out.println("Start testing...");

		try {
			for (iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed = System.currentTimeMillis(); // 10
				// System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);

				int startHour=ValuesGenerator.getRandomIntBetween(random, 0, 12);
				int startMinute=ValuesGenerator.getRandomIntBetween(random, 0, 60) - 5;
				int startDay=ValuesGenerator.getRandomIntBetween(random, 1, 28);
				int startMonth=ValuesGenerator.getRandomIntBetween(random, 0, 11);
				int startYear=ValuesGenerator.getRandomIntBetween(random, 1, 2025) - 1;
				String title = "Birthday Party";
				String description = "This is my birthday party.";
				String emailAddress = "xyz@gmail.com";

				// Construct a new Appointment object with the initial data
				Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description, emailAddress);

				GregorianCalendar testDay = new GregorianCalendar(startYear, startMonth, startDay);
				CalDay calday = new CalDay(testDay);
				appt.setValid();
				calday.addAppt(appt);
				assertTrue(calday.isValid());

				if(appt.getValid()) {
					assertEquals(1,calday.getSizeAppts());
					assertEquals(startDay, calday.getDay());
					assertEquals(startMonth+1, calday.getMonth());
					assertEquals(startYear, calday.getYear());
					
					int numAppts=ValuesGenerator.getRandomIntBetween(random, 1, 11)-1;
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
						appt1.setStartHour(startHour);
						appt1.setStartMinute(startMinute);
						appt1.setValid();
						calday.addAppt(appt1);
					}
					assertEquals(1+numAppts,calday.getSizeAppts());
				}
				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				// if((iteration%1000000)==0 && iteration!=0 ) { System.out.println("test: " +
				// iteration + ", elapsed time: " + elapsed + " of "+TestTimeout);}
				if (((elapsed % 500) == 0) && (iteration != 0) && (oldElapsed != elapsed)) {
					System.out.println("test: " + iteration + ", elapsed time: " + elapsed + " of " + TestTimeout);
					oldElapsed = elapsed;
				}

			}
		} catch (NullPointerException e) {

		}

		System.out.println("Done testing, " + iteration + " tests.");
	}

}
