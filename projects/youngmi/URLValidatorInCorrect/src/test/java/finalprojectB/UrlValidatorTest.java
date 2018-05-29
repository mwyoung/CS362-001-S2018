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
		
		//bad url
		assertFalse(urlValue.isValid(""));
		
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
		String[] trueIPs = {"http://93.184.215.34","https://93.184.215.34","ftp://93.184.215.34",
				"http://93.184.216.34/","http://93.184.216.34:80","http://93.184.215.34/example/",
				"ftp://93.184.215.34/~example/"};
		for(int i=0;i<trueIPs.length;i++) {
			if(urlValue.isValid(trueIPs[i])){
				System.out.println("    valid: " + trueIPs[i]);
			} 
			else {
				System.out.println("!!invalid: " + trueIPs[i]);
			}
		}

		//try{}catch(Exception e){}
		//if(urlValue.isValid("http://oregonstate.com")){System.out.println("valid");} 
		//else { System.out.println("invalid");}	//testing
	}
	public void testManualTest_crash() {
		UrlValidator urlValue = new UrlValidator(null);
		assertTrue(urlValue.isValid("http://www.google.com")); //does not work
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
