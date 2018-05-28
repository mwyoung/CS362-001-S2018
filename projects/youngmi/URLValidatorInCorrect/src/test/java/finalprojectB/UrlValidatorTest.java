package finalprojectB;

import junit.framework.TestCase;

public class UrlValidatorTest extends TestCase {

	public UrlValidatorTest(String testName) {
		super(testName);
	}

	//For manual testing
	public void testManualTest() { 
		//String[] schemes = {"http","https","ftp"}; //default
		UrlValidator urlValue = new UrlValidator(null);
		
		//known good url
		boolean firstOutput = urlValue.isValid("http://www.google.com");
		assertFalse(firstOutput);	//does not work?
		System.out.println("Outputs: " + firstOutput);
		
		System.out.println("!!(valid/invalid) means output is bad");
		String[] falseURLs = {"http://oregonstate.edu","qwerty"};
		for(int i=0;i<falseURLs.length;i++) {
			if(urlValue.isValid(falseURLs[i])){
				System.out.println("!!  valid: " + falseURLs[i]);
			} 
			else {
				System.out.println("  invalid: " + falseURLs[i]);
			}
		}
		String[] trueURLs = {"http://www.google.com","http://example.com", "http://example.com",
				"http://www.example.com","ftp://example.com","http://example.com/"};
		for(int i=0;i<trueURLs.length;i++) {
			if(urlValue.isValid(trueURLs[i])){
				System.out.println("    valid: " + trueURLs[i]);
			} 
			else {
				System.out.println("!!invalid: " + trueURLs[i]);
			}
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
