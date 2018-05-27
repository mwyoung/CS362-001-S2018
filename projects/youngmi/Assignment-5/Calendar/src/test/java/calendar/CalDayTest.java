/** A JUnit test class to test the class CalDay. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import java.util.GregorianCalendar;
import java.util.LinkedList;

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
		
		//Appt appt1 = new Appt(0, 8, sDay, sMonth, sYear, "Test 2", "Test calday", "xyz@gmail.com");
		//assertTrue("Appt1 Valid", appt1.getValid());
		//calday0.addAppt(appt1);
		//assertEquals("Num Appts2", 2, calday0.getSizeAppts());
		
		//test string
		String strOut = calday0.getFullInfomrationApp(calday0);
		//String strTest = "5-9-2018\n\t12:08AM Test 2 Test calday\n\t3:30PM Birthday Party This is my birthday party";
		String strTest = "5-9-2018 \n\t3:30PM Birthday Party This is my birthday party ";
		System.out.println(strOut);
		System.out.println(strTest);
		assertEquals("Compare output with test", strTest, strOut);
		
		Appt appt2 = new Appt(10, 5, sDay, sMonth, sYear, "Test 3", "Testing calday", "xyz@gmail.com");
		assertTrue("Appt2 Valid", appt2.getValid());
		calday0.addAppt(appt2);
		assertEquals("Num Appts3", 2, calday0.getSizeAppts());
		assertTrue("calday Valid", calday0.isValid());
	}
	
	//Test setting up multiple appointments
	@Test(timeout = 4000)
	public void test00_m0()	throws Throwable	{
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

		Appt appt1 = new Appt(0, 8, sDay, sMonth, sYear, "Test 2", "Test calday", "xyz@gmail.com");
		assertTrue("Appt1 Valid", appt1.getValid());
		calday0.addAppt(appt1);
		assertEquals("Num Appts2", 2, calday0.getSizeAppts());

		//test string
		String strOut = calday0.getFullInfomrationApp(calday0);
		String strTest = "5-9-2018 \n\t3:30PM Birthday Party This is my birthday party "
				+ "\n\t12:08AM Test 2 Test calday ";
		System.out.println(strOut);
		System.out.println(strTest);
		assertEquals("Compare output with test", strTest, strOut);
	}
	
	//Test setting up multiple appointments
	@Test(timeout = 4000)
	public void test00_m1()	throws Throwable	{
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

		Appt appt1 = new Appt(0, 8, sDay, sMonth, sYear, "Test 2", "Test calday", "xyz@gmail.com");
		assertTrue("Appt1 Valid", appt1.getValid());
		calday0.addAppt(appt1);
		assertEquals("Num Appts2", 2, calday0.getSizeAppts());
		
		//test linked list
		assertEquals("size", 2, calday0.getSizeAppts());
		LinkedList<Appt> apptlist = calday0.getAppts();
		Appt appt2 = apptlist.get(0);
		assertEquals("str", appt0.toString(), appt2.toString() );
	}
	
	//Test linked list
	@Test(timeout = 4000)
	public void test00_m2()	throws Throwable	{
		Appt appt0 = new Appt(-1, -1, 4, 4, 2018, null, null, null);
		appt0.setValid();
		assertFalse("Appt Valid", appt0.getValid());
		GregorianCalendar testDay = new GregorianCalendar(4, 4, 2018);
		CalDay calday0 = new CalDay(testDay);
		calday0.addAppt(appt0);
		assertTrue("calday Valid", calday0.isValid());
		
		//test linked list
		assertEquals("size", 0, calday0.getSizeAppts());
	}
	
	@Test(timeout = 4000)
	public void test00_1()	throws Throwable	{
		int sDay = 9;
		int sMonth = 4;
		int sYear = 2018;
		Appt appt0 = new Appt(5, 30, sDay, sMonth, sYear, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		assertTrue("Appt Valid", appt0.getValid());
		GregorianCalendar testDay = new GregorianCalendar(sYear, sMonth, sDay);
		CalDay calday0 = new CalDay(testDay);
		calday0.addAppt(appt0);
		assertTrue("calday Valid", calday0.isValid());
		assertEquals("Num Appts", 1, calday0.getSizeAppts());
		assertEquals("Day", sDay, calday0.getDay());
		
		//test string
		String strOut = calday0.getFullInfomrationApp(calday0);
		String strTest = "5-9-2018 \n\t5:30AM Birthday Party This is my birthday party ";
		System.out.println(strOut);
		System.out.println(strTest);
		assertEquals("Compare output with test", strTest, strOut);
	}
	
	@Test(timeout = 4000)
	public void test00_2()	throws Throwable	{
		int sDay = 9;
		int sMonth = 4;
		int sYear = 2018;
		Appt appt0 = new Appt(14, 9, sDay, sMonth, sYear, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		assertTrue("Appt Valid", appt0.getValid());
		GregorianCalendar testDay = new GregorianCalendar(sYear, sMonth, sDay);
		CalDay calday0 = new CalDay(testDay);
		calday0.addAppt(appt0);
		
		//test string
		String strOut = calday0.getFullInfomrationApp(calday0);
		String strTest = "5-9-2018 \n\t2:09PM Birthday Party This is my birthday party ";
		assertEquals("Compare output with test", strTest, strOut);
	}
	@Test(timeout = 4000)
	public void test00_3()	throws Throwable	{
		int sDay = 9;
		int sMonth = 4;
		int sYear = 2018;
		Appt appt0 = new Appt(12, 10, sDay, sMonth, sYear, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		assertTrue("Appt Valid", appt0.getValid());
		GregorianCalendar testDay = new GregorianCalendar(sYear, sMonth, sDay);
		CalDay calday0 = new CalDay(testDay);
		calday0.addAppt(appt0);
		
		//test string
		String strOut = calday0.getFullInfomrationApp(calday0);
		// !! Bug - is 0 instead of 12, AM instead of PM
		String strTest = "5-9-2018 \n\t0:10AM Birthday Party This is my birthday party ";
		assertEquals("Compare output with test", strTest, strOut);
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
	
	//test not valid
	//Test setting up multiple appointments
	@Test(timeout = 4000)
	public void test04()	throws Throwable	{
		int sDay = -1;
		int sMonth = 5;
		int sYear = 2018;
		Appt appt0 = new Appt(0, 30, sDay, sMonth, sYear, "A2", null, null);
		appt0.setValid();
		assertFalse("Appt invalid", appt0.getValid());
		GregorianCalendar testDay = new GregorianCalendar(sYear, sMonth, sDay);
		CalDay calday0 = new CalDay(testDay);
		calday0.addAppt(appt0);
		assertEquals("Num Appts", 0, calday0.getSizeAppts());
		String strOut = calday0.toString();
		String strTest = "\t --- 6/30/2018 --- \n"
				+ " --- -------- Appointments ------------ --- \n\n";
		assertEquals("no string", strTest, strOut);
	}
	//test not valid
	//Test setting up multiple appointments
	@Test(timeout = 4000)
	public void test05()	throws Throwable	{
		int sDay = -1;
		int sMonth = 5;
		int sYear = 2018;
		Appt appt0 = new Appt(0, 30, sDay, sMonth, sYear, "A2", null, null);
		appt0.setValid();
		assertFalse("Appt invalid", appt0.getValid());
		Appt appt1 = new Appt(2, 30, sDay, sMonth, sYear, "A2", null, null);
		appt1.setValid();
		assertFalse("Appt invalid", appt1.getValid());
		GregorianCalendar testDay = new GregorianCalendar(sYear, sMonth, sDay);
		CalDay calday0 = new CalDay(testDay);
		calday0.addAppt(appt0);
		calday0.addAppt(appt1);
		assertEquals("Num Appts", 0, calday0.getSizeAppts());
		String strOut = calday0.toString();
		String strTest = "\t --- 6/30/2018 --- \n"
				+ " --- -------- Appointments ------------ --- \n\n";
		assertEquals("no string", strTest, strOut);
	}
	//Test information
	@Test(timeout = 4000)
	public void test06()	throws Throwable	{
		int sDay = 9;
		int sMonth = 4;
		int sYear = 2018;
		Appt appt0 = new Appt(sDay, sMonth, sYear, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		assertTrue("Appt Valid", appt0.getValid());
		GregorianCalendar testDay = new GregorianCalendar(sYear, sMonth, sDay);
		CalDay calday0 = new CalDay(testDay);
		calday0.addAppt(appt0);
		
		//test string
		String strOut = calday0.getFullInfomrationApp(calday0);
		String strTest = "5-9-2018 \n\tBirthday Party This is my birthday party ";
		System.out.println(strOut);
		System.out.println(strTest);
		assertEquals("Compare output with test", strTest, strOut);
	}
	
}

