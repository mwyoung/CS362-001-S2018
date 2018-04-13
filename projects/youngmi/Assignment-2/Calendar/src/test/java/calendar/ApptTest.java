/** A JUnit test class to test the class ApptTest. */

package calendar;

import org.junit.*;
import static org.junit.Assert.*;
import calendar.Appt;
//import calendar.CalendarUtil;

public class ApptTest {

	@Test(timeout = 4000)
	public void test00() throws Throwable {
		//hour, minute, day, month, year, title, desc, email
		Appt appt0 = new Appt(15, 30, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		String string0 = appt0.toString();
		assertEquals("Recur By", 2, appt0.getRecurBy());
		assertFalse("Is Recurring", appt0.isRecurring());
		assertEquals("Output string", "\t14/9/2018 at 3:30pm ,Birthday Party, This is my birthday party\n", string0);
		assertEquals("Recur Increment", 0, appt0.getRecurIncrement());
		appt0.setValid();
		assertFalse("Not valid", appt0.getValid());
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
		Appt appt5 = new Appt(9, 01, 31, 4, 2019, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		assertEquals("Day", 31, appt5.getStartDay());
		assertEquals("Month", 4, appt5.getStartMonth());
		assertTrue("Time", appt5.hasTimeSet());
		assertTrue("True Occur", appt5.isOn(31, 4, 2019));
		appt5.setValid();
		appt5.toString();
		assertFalse("Is Valid", appt5.getValid());
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
}