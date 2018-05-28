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
		
		//known good url
		
		assertFalse(urlValue.isValid("http://www.google.com"));
		
		
		String[] falseURLs = {"http://oregonstate.edu","qwerty"};
		for(int i=0;i<falseURLs.length-1;i++) {
			if(urlValue.isValid(falseURLs[i])){
				System.out.println("valid: " + falseURLs[i]);
			} 
			else {
				System.out.println("invalid: " + falseURLs[i]);
			}	//testing
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
		//try{}catch(Exception e){}
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
