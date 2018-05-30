package finalprojectB;

import junit.framework.TestCase;

public class UrlValidatorTest extends TestCase {

	public UrlValidatorTest(String testName) {
		super(testName);
	}

	//For manual testing
	public void testManualTest() { 
		System.out.println("Starting manual tests");
		String[] schemes = {"http","https","ftp"}; //default
		UrlValidator urlValue = new UrlValidator(schemes);
		//UrlValidator urlValue = new UrlValidator(schemes,null,UrlValidator.ALLOW_ALL_SCHEMES);
		
		//known good url
		boolean firstOutput = urlValue.isValid("http://www.google.com");
		//assertTrue(firstOutput);	//does not work with null?
		System.out.println("Known good output: " + firstOutput);
		
		//bad url
		assertFalse(urlValue.isValid(""));
		
		System.out.println("!!(valid/invalid) means output is bad\n");
		int n_valid = 0;	//number of valid
		
		try {
			String[] falseURLs = { "http://oregonstate.%edu", "qwerty", "://lkjfdsa;lkjfdsa" };
			for (int i = 0; i < falseURLs.length; i++) {
				if (urlValue.isValid(falseURLs[i])) {
					System.out.println("!!  valid: " + falseURLs[i]);
				} else {
					System.out.println("  invalid: " + falseURLs[i]);
					++n_valid;
				}	
			}
			System.out.println("False URLs test: " + ((n_valid * 100) / falseURLs.length) + "% (" + n_valid + " of "
					+ falseURLs.length + ")\n");
		} catch (Exception e) {
			System.out.println("FalseURL error: " + e.getMessage());
		}
		
		try {
			String[] trueURLs = { "http://www.google.com", "http://example.com", "http://example.com",
					"http://www.example.com", "ftp://example.com", "http://example.com/" };
			n_valid = 0;
			for (int i = 0; i < trueURLs.length; i++) {
				if (urlValue.isValid(trueURLs[i])) {
					System.out.println("    valid: " + trueURLs[i]);
					++n_valid;
				} else {
					System.out.println("!!invalid: " + trueURLs[i]);
				}
			}
			System.out.println("True URLs test: " + ((n_valid * 1) / trueURLs.length) * 100 + "% (" + n_valid + " of "
					+ trueURLs.length + ")\n");
		} catch (Exception e) {
			System.out.println("TrueURL error: " + e.getMessage());
		}
		
		try {
			String[] trueIPs = { "http://93.184.215.34", "http://93.184.216.34/", "http://93.184.216.34:80",
					"http://93.184.215.34/example/", "http://93.184.215.34/~example/", "https://93.184.215.34",
					"ftp://93.184.215.34" };
			n_valid = 0;
			for (int i = 0; i < trueIPs.length; i++) {
				if (urlValue.isValid(trueIPs[i])) {
					System.out.println("    valid: " + trueIPs[i]);
					++n_valid;
				} else {
					System.out.println("!!invalid: " + trueIPs[i]);
				}
			}
			System.out.println("True IPs test: " + ((n_valid * 1) / trueIPs.length) * 100 + "% (" + n_valid + " of "
					+ trueIPs.length + ")\n");
		} catch (Exception e) {
			System.out.println("TrueURL error: " + e.getMessage());
		}
		
		//try{}catch(Exception e){}
		//if(urlValue.isValid("http://oregonstate.com")){System.out.println("valid");} 
		//else { System.out.println("invalid");}	//testing
	}
	public void testManualTest_crash() {
		UrlValidator urlValue = new UrlValidator(null);
		try {
		assertTrue(urlValue.isValid("http://www.google.com")); //does not work
		} catch (Exception e) {
			System.out.println("Crash error: " + e.getMessage());
		}
	}
	public void testManualTest_pass() {
		UrlValidator urlValue = new UrlValidator(null,null,UrlValidator.ALLOW_ALL_SCHEMES);
		assertTrue(urlValue.isValid("http://www.google.com")); //does work
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
