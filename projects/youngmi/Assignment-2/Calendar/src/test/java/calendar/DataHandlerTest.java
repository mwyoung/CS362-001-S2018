
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

	//test saving
	@Test(timeout = 4000)
	public void test00()	throws Throwable	{
		DataHandler dhfile = new DataHandler();
		Appt appt0 = new Appt(15, 30, 9, 4, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		boolean output = dhfile.saveAppt(appt0);
		assertTrue("saved", output);
		Appt appt1 = new Appt(5, 5, 4, 35, 2018, null, null, null);
		appt1.setValid();
		assertFalse("bad appt", appt1.getValid());
		output = dhfile.saveAppt(appt1);
		assertFalse("Saved bad appt", output);
	}
	
	//test deleting
	@Test(timeout = 4000)
	public void test01()	throws Throwable	{
		DataHandler dhfile = new DataHandler();
		Appt appt1 = new Appt(15, 30, 9, 4, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		boolean output = dhfile.saveAppt(appt1);
		assertTrue("save3", output);
		output = dhfile.deleteAppt(appt1);
		assertTrue("save4", output);
	}
	
	//test delete
	@Test(timeout = 4000)
	public void test02()	throws Throwable	{
		DataHandler dhfile = new DataHandler();
		Appt appt1 = new Appt(-1, -1, -1, -1, -1, null, null, null);
		appt1.setValid();
		boolean output = dhfile.saveAppt(appt1);
		output = dhfile.deleteAppt(appt1);
		assertFalse("No delete", output);
	}
	
	//test autosave
	@Test(timeout = 4000)
	public void test03()	throws Throwable	{
		DataHandler dhfile = new DataHandler("calendar2.xml",true);
		Appt appt1 = new Appt(15, 30, 9, 4, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		boolean output = dhfile.saveAppt(appt1);
		assertTrue("autosave", output);
		output = dhfile.deleteAppt(appt1);
		assertTrue("autosave", output);
	}
	
	//test no autosave
	@Test(timeout = 4000)
	public void test04()	throws Throwable	{
		DataHandler dhfile = new DataHandler("calendar2.xml",false);
		Appt appt1 = new Appt(15, 30, 9, 4, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		boolean output = dhfile.saveAppt(appt1);
		assertTrue("no autosave", output);
		output = dhfile.deleteAppt(appt1);
		assertTrue("no autosave", output);
	}
	
	//recur
	@Test(timeout = 4000)
	public void test00_r()	throws Throwable	{
		DataHandler dhfile = new DataHandler();
		Appt appt0 = new Appt(15, 30, 9, 4, 2018, "A2", "Appt2", "xyz@gmail.com");
		int[] recurDaysArr= {2};
		//days, by_, increment, number
		appt0.setRecurrence(recurDaysArr, Appt.RECUR_BY_MONTHLY, 2, 2);
		appt0.setValid();
		assertTrue("valid", appt0.getValid());
		boolean output = dhfile.saveAppt(appt0);
		assertTrue("Recur S", output);
	}
	
	//recur 2
	@Test(timeout = 4000)
	public void test01_r()	throws Throwable	{
		DataHandler dhfile = new DataHandler("calendar2.xml",true);
		Appt appt0 = new Appt(5, 30, 9, 4, 2018, "A2", "Appt2", "xyz@gmail.com");
		int[] recurDaysArr= {2};
		//days, by_, increment, number
		appt0.setRecurrence(recurDaysArr, Appt.RECUR_BY_WEEKLY, 2, 2); //Appt.RECUR_NUMBER_FOREVER);
		appt0.setValid();
		assertTrue("valid", appt0.getValid());
		dhfile.saveAppt(appt0);
		Appt appt1 = new Appt(5, 5, 5, 4, 2018, null, null, null);
		//days, by_, increment, number
		appt0.setRecurrence(null, Appt.RECUR_BY_MONTHLY, 2, 2); //Appt.RECUR_NUMBER_FOREVER);
		appt1.setValid();
		dhfile.saveAppt(appt1);
		assertTrue("valid", appt1.getValid());
		
		GregorianCalendar day1 = new GregorianCalendar(2018,3,4);
		GregorianCalendar day2 = new GregorianCalendar(2018,8,6);
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		calDays = (LinkedList<CalDay>) dhfile.getApptRange(day1,day2);
		LinkedList<Appt> apptlist = calDays.get(0).getAppts();
		System.out.println("Num appts r: "+apptlist.size());
		//Appt appt2 = apptlist.get(0);
		//String string0 = appt2.toString();
		//assertEquals("string","\t4/4/2018 at 3:30pm ,A2, Appt2\n", string0);
	}
	
	//recur yearly
	@Test(timeout = 4000)
	public void test02_r()	throws Throwable	{
		DataHandler dhfile = new DataHandler("calendar2.xml",true);
		Appt appt0 = new Appt(5, 30, 9, 4, 2018, "A2", "Appt2", "xyz@gmail.com");
		int[] recurDaysArr= {2};
		//days, by_, increment, number
		appt0.setRecurrence(recurDaysArr, Appt.RECUR_BY_YEARLY, 2, 2); //Appt.RECUR_NUMBER_FOREVER);
		appt0.setValid();
		assertTrue("valid", appt0.getValid());
		dhfile.saveAppt(appt0);
		
		GregorianCalendar day1 = new GregorianCalendar(2018,3,4);
		GregorianCalendar day2 = new GregorianCalendar(2019,5,6);
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		calDays = (LinkedList<CalDay>) dhfile.getApptRange(day1,day2);
		LinkedList<Appt> apptlist = calDays.get(0).getAppts();
		System.out.println("Num appts r: "+apptlist.size());
		//Appt appt2 = apptlist.get(0);
		//String string0 = appt2.toString();
		//assertEquals("string","\t4/4/2018 at 3:30pm ,A2, Appt2\n", string0);
	}
	
	//recur yearly
	@Test(timeout = 4000)
	public void test03_r()	throws Throwable	{
		DataHandler dhfile = new DataHandler("calendar2.xml",true);
		Appt appt0 = new Appt(5, 30, 9, 4, 2018, "A2", "Appt2", "xyz@gmail.com");
		//days, by_, increment, number
		appt0.setRecurrence(null, Appt.RECUR_BY_WEEKLY, 2, 2); //Appt.RECUR_NUMBER_FOREVER);
		appt0.setValid();
		assertTrue("valid", appt0.getValid());
		dhfile.saveAppt(appt0);
		
		GregorianCalendar day1 = new GregorianCalendar(2018,3,4);
		GregorianCalendar day2 = new GregorianCalendar(2019,5,6);
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		calDays = (LinkedList<CalDay>) dhfile.getApptRange(day1,day2);
		LinkedList<Appt> apptlist = calDays.get(0).getAppts();
		System.out.println("Num appts r: "+apptlist.size());
		//Appt appt2 = apptlist.get(0);
		//String string0 = appt2.toString();
		//assertEquals("string","\t4/4/2018 at 3:30pm ,A2, Appt2\n", string0);
	}
	
	//save 2
	@Test(timeout = 4000)
	public void test01_save()	throws Throwable	{
		DataHandler dhfile = new DataHandler();
		//hour, minute, day, month, year, title, desc, email
		Appt appt0 = new Appt(15, 30, 4, 4, 2018, "A2", "Appt2", "xyz@gmail.com");
		appt0.setValid();
		dhfile.saveAppt(appt0);
		assertTrue("valid", appt0.getValid());
		
		Appt appt1 = new Appt(5, 5, 5, 4, 2018, null, null, null);
		appt1.setValid();
		dhfile.saveAppt(appt1);
		assertTrue("valid", appt1.getValid());
		
		GregorianCalendar day1 = new GregorianCalendar(2018,3,4);
		GregorianCalendar day2 = new GregorianCalendar(2018,4,6);
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		calDays = (LinkedList<CalDay>) dhfile.getApptRange(day1,day2);
		LinkedList<Appt> apptlist = calDays.get(0).getAppts();
		System.out.println("Num appts: "+apptlist.size());
		Appt appt2 = apptlist.get(0);
		String string0 = appt2.toString();
		assertEquals("string","\t4/4/2018 at 3:30pm ,A2, Appt2\n", string0);
	}
	/*
	//test last before first - catch exception?
	//save 2
	@Test(timeout = 4000)
	public void test02_save()	throws Throwable	{
		DataHandler dhfile = new DataHandler();
		//hour, minute, day, month, year, title, desc, email
		Appt appt0 = new Appt(15, 30, 4, 4, 2018, "A2", "Appt2", "xyz@gmail.com");
		appt0.setValid();
		dhfile.saveAppt(appt0);
		assertTrue("valid", appt0.getValid());
		
		Appt appt1 = new Appt(5, 5, 5, 4, 2018, null, null, null);
		appt1.setValid();
		dhfile.saveAppt(appt1);
		assertTrue("valid", appt1.getValid());
		
		GregorianCalendar day1 = new GregorianCalendar(2018,3,4);
		GregorianCalendar day2 = new GregorianCalendar(2018,4,6);
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		calDays = (LinkedList<CalDay>) dhfile.getApptRange(day2,day1);
		LinkedList<Appt> apptlist = calDays.get(0).getAppts();
		assertEquals("nothing", 0, apptlist.size());
	}
	*/
	

}
