package finalprojectB;

import junit.framework.TestCase;

public class UrlValidatorTest extends TestCase {

	public UrlValidatorTest(String testName) {
		super(testName);
	}

	//For manual testing
	public void testManualTest() { 
		String[] schemes = {"http","https","ftp"};	
		UrlValidator urlValue = new UrlValidator(schemes);
		
		//two known false/true urls
		assertFalse(urlValue.isValid("qwerty:43")); 	//first false test
		assertFalse(urlValue.isValid("http://oregonstate.edu/")); //No EDU?
		if(urlValue.isValid("http://oregonstate.com")){System.out.println("valid");} 
		else { System.out.println("invalid");}	//testing
		
		try {
			if(urlValue.isValid("http://oregonstate.edu")){
				System.out.println("valid");} 
			else { System.out.println("invalid");}	//testing
		} catch(Exception e) { //all exceptions
			System.out.println("exception");
		}
		/*
		//IP addresses
		assertTrue(urlValue.isValid("http://example.org")); 
		assertTrue(urlValue.isValid("http://93.184.215.34"));
		//assertTrue(urlValue.isValid("https://93.184.215.34"));

		assertFalse(urlValue.isValid("ftp://93.184.215.34"));	//maybe?
		assertTrue(urlValue.isValid("http://93.184.216.34/"));	//example.org
		assertFalse(urlValue.isValid("http://93.184.216.34:80")); //!!Fails!!
		assertFalse(urlValue.isValid("http://93.184.215.34/example/")); //!!fails
		
		//assertTrue(urlValue.isValid("ftp://93.184.215.34/~example/"));
		
		//true URLs
		assertTrue(urlValue.isValid("ftp://example.com"));

		//False URLs
		assertFalse(urlValue.isValid(""));
		assertFalse(urlValue.isValid("example.org"));
*/
		//if(urlValue.isValid("http://oregonstate.com")){System.out.println("valid");} 
		//else { System.out.println("invalid");}	//testing
	}
	
	//First Partition testing	
	public void testYourFirstPartition(){
	 	
	}
	
	//Second Partition testing
	public void testYourSecondPartition(){ 	

	}
	//more partitions?
	
	//For programming based testing
	public void testIsValid(){
		

	}
}
