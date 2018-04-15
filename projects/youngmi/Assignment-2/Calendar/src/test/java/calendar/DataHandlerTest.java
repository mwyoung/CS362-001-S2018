
/** A JUnit test class to test the class DataHandler. */


package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import calendar.DataHandler;

import java.util.GregorianCalendar;
import java.util.LinkedList;


public class DataHandlerTest{

	@Test(timeout = 4000)
	public void test00()	throws Throwable	{
		DataHandler dhfile = new DataHandler();
		int sDay = 9;
		int sMonth = 4;
		int sYear = 2018;
		Appt appt0 = new Appt(15, 30, sDay, sMonth, sYear, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		boolean output = dhfile.saveAppt(appt0);
		assertTrue("No AutoSave", output);
		
		Appt appt1 = new Appt(-1, 30, sDay, sMonth, sYear, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		output = dhfile.saveAppt(appt1);
		assertFalse("No AutoSave2", output);
	}
	@Test(timeout = 4000)
	public void test01()	throws Throwable	{
		DataHandler dhfile = new DataHandler();
		Appt appt1 = new Appt(15, 30, 9, 4, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		boolean output = dhfile.saveAppt(appt1);
		assertTrue("No AutoSave3", output);
		output = dhfile.deleteAppt(appt1);
		assertTrue("No AutoSave4", output);
	}

}
