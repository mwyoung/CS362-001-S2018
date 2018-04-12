/** A JUnit test class to test the class ApptTest. */

package calendar;

import org.junit.*;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalendarUtil;

public class ApptTest {

	@Test(timeout = 4000)
	public void test00() throws Throwable {
		Appt appt0 = new Appt(15, 30, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		String string0 = appt0.toString();
		assertEquals("Recur By", 2, appt0.getRecurBy());
		assertFalse("Is Recurring", appt0.isRecurring());
		assertEquals("Output string", "\t14/9/2018 at 3:30pm ,Birthday Party, This is my birthday party\n", string0);
		assertEquals("Recur Increment", 0, appt0.getRecurIncrement());
		appt0.setValid();
	}

	@Test(timeout = 4000)
	public void test01() throws Throwable {
		Appt appt0 = new Appt(15, 30, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		assertEquals("Min", 15, appt0.getStartMinute());
		assertEquals("Hour", 30, appt0.getStartHour());
		assertEquals("Day", 9, appt0.getStartDay());
		assertEquals("Month", 14, appt0.getStartMonth());
		assertEquals("Year", 2018, appt0.getStartYear());
		assertEquals("Title", "Birthday Party", appt0.getTitle());
		assertEquals("Desc", "This is my birthday party", appt0.getDescription());
		assertEquals("Email", "xyz@gmail.com", appt0.getEmailAddress());
		assertTrue("Time", appt0.hasTimeSet());
		assertTrue("True Occur", appt0.isOn(9, 14, 2018));
		assertFalse("False Occur 1", appt0.isOn(10, 14, 2018));
		assertFalse("False Occur 2", appt0.isOn(9, 15, 2018));
		assertFalse("False Occur 3", appt0.isOn(9, 14, 2019));
	}
	
}