/** A JUnit test class to test the class ApptTest. */

package calendar;

import org.junit.*;
import static org.junit.Assert.*;
import calendar.Appt;
//import calendar.CalendarUtil;

public class ApptTest {
	//test CalendarUtil
	@Test(timeout = 4000)
	public void test_CU() throws Throwable {
		int days = CalendarUtil.NumDaysInMonth(2018, 0);
		assertEquals("Jan", 31, days);
		days = CalendarUtil.NumDaysInMonth(2018, 1);
		assertEquals("Feb", 28, days);
		days = CalendarUtil.NumDaysInMonth(2016, 1);
		assertEquals("Feb_l", 29, days);
		days = CalendarUtil.NumDaysInMonth(2016, 2);
		assertEquals("Feb_l", 31, days);
		days = CalendarUtil.NumDaysInMonth(2018, 11);
		assertEquals("Dec", 31, days);
		
		boolean leap = CalendarUtil.IsLeapYear(2018);
		assertFalse("l 2018", leap);
		leap = CalendarUtil.IsLeapYear(2016);
		assertTrue("l 2016", leap);
		leap = CalendarUtil.IsLeapYear(2000);
		assertTrue("l 2000", leap);
		leap = CalendarUtil.IsLeapYear(1900);
		assertFalse("l 1900", leap);
	}
	
	//Test an appointment
	@Test(timeout = 4000)
	public void test00() throws Throwable {
		//hour, minute, day, month, year, title, desc, email
		Appt appt0 = new Appt(15, 30, 9, 4, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		appt0.setValid();
		assertTrue("is valid", appt0.getValid());
		String string0 = appt0.toString();
		//assertEquals("Recur By", 2, appt0.getRecurBy());
		assertFalse("Is Recurring", appt0.isRecurring());
		
		assertEquals("Output string", "\t4/4/2018 at 3:30pm ,Birthday Party, This is my birthday party\n", string0);
		assertEquals("Recur Increment", 0, appt0.getRecurIncrement());
		
	}
	
	@Test(timeout = 4000)
	public void test00_1() throws Throwable {
		//hour, minute, day, month, year, title, desc, email
		Appt appt5 = new Appt(15, 30, 4, 4, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		appt5.setValid();
		assertTrue("Valid", appt5.getValid());
		String string0 = appt5.toString();
		System.out.println(string0);
		assertEquals("Output string", "\t4/4/2018 at 3:30pm ,Birthday Party, This is my birthday party\n", string0);
	}
	
	@Test(timeout = 4000)
	public void test00_2() throws Throwable {
		//hour, minute, day, month, year, title, desc, email
		Appt appt0 = new Appt(00, 30, 4, 4, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		appt0.setValid();
		assertTrue("Valid", appt0.getValid());
	}
	
	 
	@Test(timeout = 4000)
	public void test01() throws Throwable {
		Appt appt1 = new Appt(15, 30, 9, 4, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		assertEquals("Min", 30, appt1.getStartMinute());
		assertEquals("Hour", 15, appt1.getStartHour());
		assertEquals("Day", 9, appt1.getStartDay());
		assertEquals("Month", 4, appt1.getStartMonth());
		assertEquals("Year", 2018, appt1.getStartYear());
		assertEquals("Title", "Birthday Party", appt1.getTitle());
		assertEquals("Desc", "This is my birthday party", appt1.getDescription());
		assertEquals("Email", "xyz@gmail.com", appt1.getEmailAddress());
		assertTrue("Time", appt1.hasTimeSet());
		assertTrue("True Occur", appt1.isOn(9, 4, 2018));
		assertFalse("False Occur 1", appt1.isOn(10, 14, 2018));
		assertFalse("False Occur 2", appt1.isOn(9, 15, 2018));
		assertFalse("False Occur 3", appt1.isOn(9, 14, 2019));
		appt1.setValid();
		assertTrue("Is Valid", appt1.getValid());
		assertFalse("No Recur", appt1.isRecurring());
	}
	//time at 0 hours
	@Test(timeout = 4000)
	public void test02() throws Throwable {
		//hour, minute, day, month, year, title, desc, email
		Appt appt2 = new Appt(0, 00, 10, 5, 2019, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		assertEquals("Min", 00, appt2.getStartMinute());
		assertEquals("Hour", 0, appt2.getStartHour());
		assertTrue("Time", appt2.hasTimeSet());
		assertTrue("True Occur", appt2.isOn(10, 5, 2019));
		appt2.setValid();
		assertTrue("Is Valid", appt2.getValid());
	}
	//time at 12 hours
	@Test(timeout = 4000)
	public void test03() throws Throwable {
		//hour, minute, day, month, year, title, desc, email
		Appt appt3 = new Appt(12, 01, 10, 5, 2019, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		assertEquals("Min", 01, appt3.getStartMinute());
		assertEquals("Hour", 12, appt3.getStartHour());
		assertTrue("Time", appt3.hasTimeSet());
		assertTrue("True Occur", appt3.isOn(10, 5, 2019));
		appt3.setValid();
		assertTrue("Is Valid", appt3.getValid());
	}
	//Time at 24 hours
	@Test(timeout = 4000)
	public void test04() throws Throwable {
		//hour, minute, day, month, year, title, desc, email
		Appt appt4 = new Appt(23, 01, 10, 5, 2019, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		assertEquals("Min", 01, appt4.getStartMinute());
		assertEquals("Hour", 23, appt4.getStartHour());
		assertTrue("Time", appt4.hasTimeSet());
		assertTrue("True Occur", appt4.isOn(10, 5, 2019));
		appt4.setValid();
		assertTrue("Is Valid", appt4.getValid());
	}
	
	//Day out of range
	@Test(timeout = 4000)
	public void test05() throws Throwable {
		//hour, minute, day, month, year, title, desc, email
		Appt appt5 = new Appt(9, 01, 32, 4, 2019, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		assertEquals("Day", 32, appt5.getStartDay());
		assertEquals("Month", 4, appt5.getStartMonth());
		assertTrue("Time", appt5.hasTimeSet());
		assertTrue("True Occur", appt5.isOn(32, 4, 2019));
		appt5.setValid();
		appt5.toString();
		assertFalse("Is Valid", appt5.getValid());
	}
	//Day out of range
	@Test(timeout = 4000)
	public void test05_0() throws Throwable {
		//hour, minute, day, month, year, title, desc, email
		Appt appt5 = new Appt(9, 01, 0, 4, 2019, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		appt5.setValid();
		assertFalse("Is Valid", appt5.getValid());
	}
	
	//string
	@Test(timeout = 4000)
	public void test06() throws Throwable {
		//hour, minute, day, month, year, title, desc, email
		Appt appt5 = new Appt(25, 65, 35, 14, -1, null, null, null);
		appt5.setValid();
		//String str = appt5.toString();
		assertFalse("Is Valid", appt5.getValid());
		//System.out.println(str);
	}
	
	//string
	@Test(timeout = 4000)
	public void test06_a() throws Throwable {
		//hour, minute, day, month, year, title, desc, email
		Appt appt5 = new Appt(15, 65, 5, 4, 2000, null, null, null);
		appt5.setValid();
		assertFalse("Is Valid", appt5.getValid());
		Appt appt6 = new Appt(15, -60, 5, 4, 2000, null, null, null);
		appt6.setValid();
		assertFalse("Is Valid", appt6.getValid());
	}
	
	//string
	@Test(timeout = 4000)
	public void test06_b() throws Throwable {
		// day, month, year, title, desc, email
		Appt appt0 = new Appt(35, 4, 2018, null, null, null);
		appt0.setValid();
		assertFalse("Valid", appt0.getValid());
		Appt appt1 = new Appt(-1, 4, 2018, null, null, null);
		appt1.setValid();
		assertFalse("Valid", appt1.getValid());
	}
	
	//No start time
	@Test(timeout = 4000)
	public void test06_c() throws Throwable {
		Appt appt0 = new Appt(5, -1, 2018, null, null, null);
		appt0.setValid();
		assertFalse("Valid", appt0.getValid());
		Appt appt1 = new Appt(5, 13, 2018, null, null, null);
		appt1.setValid();
		assertFalse("Valid", appt1.getValid());
	}
	
	//No start time
	@Test(timeout = 4000)
	public void test06_d() throws Throwable {
		Appt appt0 = new Appt(5, 4, -1, null, null, null);
		appt0.setValid();
		assertFalse("Valid", appt0.getValid());
	}
	
	//if valid
	@Test(timeout = 4000)
	public void test07() throws Throwable {
		//hour, minute, day, month, year, title, desc, email
		Appt appt0 = new Appt(9, 60, 15, 4, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		appt0.setValid();
		assertFalse("IV Minute", appt0.getValid());
		appt0.setStartMinute(-1);
		appt0.setValid();
		assertFalse("IV Minute 2", appt0.getValid());
		
		Appt appt1 = new Appt(25, 01, 15, 4, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		appt1.setValid();
		assertFalse("IV hour", appt1.getValid());
		appt1.setStartHour(-1);
		appt1.setValid();
		assertFalse("IV hour", appt1.getValid());
		
		Appt appt2 = new Appt(13, 01, 0, 2, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		appt2.setValid();
		assertFalse("IV day", appt2.getValid());
		
		Appt appt3 = new Appt(13, 01, 35, 2, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		appt3.setValid();
		assertFalse("IV day 2", appt3.getValid());
		
		Appt appt4 = new Appt(13, 01, 15, 13, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		appt4.setValid();
		assertFalse("IV month", appt4.getValid());
		appt4.setStartMonth(-1);
		appt4.setValid();
		assertFalse("IV month 2", appt4.getValid());
		
		Appt appt5 = new Appt(9, 01, 15, 4, -1, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		appt5.setValid();
		assertFalse("IV year", appt5.getValid());
		//String str = appt5.toString();
		//assertEquals("Str not valid", "\tThis appointment is not valid", str);
	}
	
	//No start time
	@Test(timeout = 4000)
	public void test08() throws Throwable {
		// day, month, year, title, desc, email
		Appt appt0 = new Appt(15, 4, 2018, null, null, null);
		appt0.setValid();
		assertFalse("No Start", appt0.getValid());
		assertFalse("No Time", appt0.hasTimeSet());
	}
	
	@Test(timeout = 4000)
	public void test01_r() throws Throwable {
		Appt appt0 = new Appt(15, 30, 9, 4, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		//test recurrence
		int[] recurDaysArr= {2};
		//days, by_, increment, number
		appt0.setRecurrence(recurDaysArr, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
		assertEquals("Recur Num", Appt.RECUR_NUMBER_FOREVER, appt0.getRecurNumber());
		assertEquals("Recur By", Appt.RECUR_BY_WEEKLY, appt0.getRecurBy());
		assertEquals("Recur Days", recurDaysArr, appt0.getRecurDays());
		assertEquals("Recur Inc", 2, appt0.getRecurIncrement());
		appt0.setValid();
		assertTrue("Recur Valid", appt0.getValid());
	}
	
	@Test(timeout = 4000)
	public void test02_r() throws Throwable {
		Appt appt0 = new Appt(15, 30, 9, 4, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		//test recurrence
		int[] recurDaysArr= {2};
		//days, by_, increment, number
		appt0.setRecurrence(recurDaysArr, Appt.RECUR_BY_MONTHLY, 2, 2);
		assertEquals("Recur Num", 2, appt0.getRecurNumber());
		assertEquals("Recur By", Appt.RECUR_BY_MONTHLY, appt0.getRecurBy());
		assertEquals("Recur Days", recurDaysArr, appt0.getRecurDays());
		appt0.setValid();
		assertTrue("Recur Valid", appt0.getValid());
	}
	
	@Test(timeout = 4000)
	public void test03_r() throws Throwable {
		Appt appt0 = new Appt(15, 30, 9, 4, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		//test recurrence
		int[] recurDaysArr= {2};
		//days, by_, increment, number
		appt0.setRecurrence(recurDaysArr, Appt.RECUR_BY_YEARLY, 2, 4);
		assertEquals("Recur Num", 4, appt0.getRecurNumber());
		assertEquals("Recur By", Appt.RECUR_BY_YEARLY, appt0.getRecurBy());
		assertEquals("Recur Days", recurDaysArr, appt0.getRecurDays());
		appt0.setValid();
		assertTrue("Recur Valid", appt0.getValid());
	}
	
	@Test(timeout = 4000)
	public void test04_r() throws Throwable {
		Appt appt0 = new Appt(15, 30, 9, 4, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		//test recurrence
		int[] recurDaysArr= null;
		//days, by_, increment, number
		appt0.setRecurrence(recurDaysArr, Appt.RECUR_BY_YEARLY, 2, 4);
		assertEquals("Recur Num", 4, appt0.getRecurNumber());
		}
}