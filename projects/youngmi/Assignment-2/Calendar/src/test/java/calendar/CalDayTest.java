/** A JUnit test class to test the class CalDay. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import java.util.GregorianCalendar;

public class CalDayTest{
	
	//Test setting up multiple appointments
	@Test(timeout = 4000)
	public void test00()	throws Throwable	{
		int sDay = 9;
		int sMonth = 4;
		int sYear = 2018;
		Appt appt0 = new Appt(15, 30, sDay, sMonth, sYear, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		assertTrue("Appt Valid", appt0.getValid());
		GregorianCalendar testDay = new GregorianCalendar(sYear, sMonth, sDay);
		CalDay calday0 = new CalDay(testDay);
		calday0.addAppt(appt0);
		assertTrue("calday Valid", calday0.isValid());
		assertEquals("Num Appts", 1, calday0.getSizeAppts());
		assertEquals("Day", sDay, calday0.getDay());
		
		Appt appt1 = new Appt(10, 8, sDay, sMonth, sYear, "Test 2", "Test calday", "xyz@gmail.com");
		assertTrue("Appt1 Valid", appt1.getValid());
		calday0.addAppt(appt1);
		assertEquals("Num Appts2", 2, calday0.getSizeAppts());
		
		//test string
		String strOut = calday0.getFullInfomrationApp(calday0);
		String strTest = "5-9-2018\n\t10:08AM Test 2 Test calday\n\t3:30PM Birthday Party This is my birthday party";
		System.out.println(strOut);
		System.out.println(strTest);
		assertEquals("Compare output with test", strTest, strOut);
		
		Appt appt2 = new Appt(10, 5, sDay, sMonth, sYear, "Test 3", "Testing calday", "xyz@gmail.com");
		assertTrue("Appt2 Valid", appt2.getValid());
		calday0.addAppt(appt2);
		assertEquals("Num Appts3", 3, calday0.getSizeAppts());
		assertTrue("calday Valid", calday0.isValid());
		
	}
	
	//Test multiple appointments
	@Test(timeout = 4000)
	public void test01()	throws Throwable	{
		int sDay = 9;
		int sMonth = 4;
		int sYear = 2018;
		Appt appt0 = new Appt(15, 30, sDay, sMonth, sYear, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		assertTrue("Appt Valid", appt0.getValid());
		GregorianCalendar testDay = new GregorianCalendar(sYear, sMonth, sDay);
		CalDay calday0 = new CalDay(testDay);
		calday0.addAppt(appt0);
		assertTrue("calday Valid", calday0.isValid());
		assertEquals("Num Appts", 1, calday0.getSizeAppts());
		assertEquals("Day", sDay, calday0.getDay());
		
		Appt appt1 = new Appt(10, 8, sDay, sMonth, sYear, "Test 2", "Test calday", "xyz@gmail.com");
		assertTrue("Appt1 Valid", appt1.getValid());
		calday0.addAppt(appt1);
		assertEquals("Num Appts2", 2, calday0.getSizeAppts());
		
		Appt appt2 = new Appt(10, 5, sDay, sMonth, sYear, "Test 3", "Testing calday", "xyz@gmail.com");
		assertTrue("Appt2 Valid", appt2.getValid());
		calday0.addAppt(appt2);
		assertEquals("Num Appts3", 3, calday0.getSizeAppts());
		assertTrue("calday Valid", calday0.isValid());
	}
	
	//test blank
	@Test(timeout = 4000)
	public void test02()	throws Throwable	{
		CalDay constCD = new CalDay();
		assertFalse("Valid", constCD.isValid());
	}

	//test output
	@Test(timeout = 4000)
	public void test03()	throws Throwable	{
		int sDay = 9;
		int sMonth = 4;
		int sYear = 2018;
		Appt appt0 = new Appt(15, 30, sDay, sMonth, sYear, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		assertTrue("Appt Valid", appt0.getValid());
		GregorianCalendar testDay = new GregorianCalendar(sYear, sMonth, sDay);
		CalDay calday0 = new CalDay(testDay);
		calday0.addAppt(appt0);
		assertTrue("calday Valid", calday0.isValid());
		assertEquals("Num Appts", 1, calday0.getSizeAppts());
		assertEquals("Day", sDay, calday0.getDay());
		
		//test string
		String strOut = calday0.toString();
		String strTest = "\t --- 6/9/2018 --- \n"
				+ " --- -------- Appointments ------------ --- \n"
				+ "\t4/4/2018 at 3:30pm ,Birthday Party, This is my birthday party\n \n";
		System.out.println(strOut);
		System.out.println(strTest);
		assertEquals("toString", strTest, strOut);
	}
}
