/** A JUnit test class to test the class CalDay. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import java.util.GregorianCalendar;

public class CalDayTest{

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
	  int sDay = 9;
	  int sMonth = 4;
	  int sYear = 2018;
	  Appt appt0 = new Appt(15, 30, sDay, sMonth, sYear, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
	  assertTrue("Appt Valid", appt0.getValid());
	  GregorianCalendar testDay = new GregorianCalendar(sYear, sMonth, sDay);
	  CalDay calDay0 = new CalDay(testDay);
	  calDay0.addAppt(appt0);
	  assertTrue("CalDay Valid", calDay0.isValid());
	  assertEquals("Num Appts", 1, calDay0.getSizeAppts());
	  assertEquals("Day", sDay, calDay0.getDay());
	  
	  Appt appt1 = new Appt(10, 8, sDay, sMonth, sYear, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
	  assertTrue("Appt1 Valid", appt1.getValid());
	  calDay0.addAppt(appt1);
	  assertEquals("Num Appts2", 2, calDay0.getSizeAppts());
	  
  }
  @Test(timeout = 4000)
  public void test01()  throws Throwable  {

  }

}
