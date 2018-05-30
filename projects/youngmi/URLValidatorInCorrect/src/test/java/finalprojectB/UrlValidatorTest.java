package finalprojectB;

import junit.framework.TestCase;

public class UrlValidatorTest extends TestCase {

	public UrlValidatorTest(String testName) {
		super(testName);
	}

	//For manual testing
	public void testManualTest(long initialVal) { 
		System.out.println("Starting manual tests");
		//String[] schemes = {"http","https","ftp"}; //default
		UrlValidator urlValue = new UrlValidator(null);
		//UrlValidator urlValue = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES);
		
		//known good url
		boolean firstOutput = urlValue.isValid("http://www.google.com");
		assertFalse(firstOutput);	//does not work?
		System.out.println("Known good output: " + firstOutput);
		
		//bad url
		assertFalse(urlValue.isValid(""));
		
		System.out.println("!!(valid/invalid) means output is bad\n");
		
		String[] falseURLs = {"http://oregonstate.edu","qwerty","://lkjfdsa;lkjfdsa"};
		int falseURLs_valid = 0;
		for(int i=0;i<falseURLs.length;i++) {
			if(urlValue.isValid(falseURLs[i])){
				System.out.println("!!  valid: " + falseURLs[i]);
			} 
			else {
				//System.out.println("  invalid: " + falseURLs[i]);
				falseURLs_valid = falseURLs_valid++;
			}
		}
		System.out.println("False URLs test: " + (falseURLs_valid/falseURLs.length) + "% (" + 
				falseURLs_valid + " of " + falseURLs.length + ")\n");
		
		String[] trueURLs = {"http://www.google.com","http://example.com", "http://example.com",
				"http://www.example.com","ftp://example.com","http://example.com/"};
		int trueURLs_valid = 0;
		for(int i=0;i<trueURLs.length;i++) {
			if(urlValue.isValid(trueURLs[i])){
				//System.out.println("    valid: " + trueURLs[i]);
				trueURLs_valid = trueURLs_valid++;
			} 
			else {
				System.out.println("!!invalid: " + trueURLs[i]);
			}
		}
		System.out.println("True URLs test: " + (trueURLs_valid/trueURLs.length) + "% (" + 
				trueURLs_valid + " of " + trueURLs.length + ")\n");
		
		String[] trueIPs = {"http://93.184.215.34","https://93.184.215.34","ftp://93.184.215.34",
				"http://93.184.216.34/","http://93.184.216.34:80","http://93.184.215.34/example/",
				"ftp://93.184.215.34/~example/"};
		int trueIPs_valid = 0;
		for(int i=0;i<trueIPs.length;i++) {
			if(urlValue.isValid(trueIPs[i])){
				//System.out.println("    valid: " + trueIPs[i]);
				trueIPs_valid = trueIPs_valid++;
			} 
			else {
				System.out.println("!!invalid: " + trueIPs[i]);
			}
		}
		System.out.println("True IPs test: " + (trueIPs_valid/trueIPs.length) + "% (" + 
				trueIPs_valid + " of " + trueIPs.length + ")\n");

		//try{}catch(Exception e){}
		//if(urlValue.isValid("http://oregonstate.com")){System.out.println("valid");} 
		//else { System.out.println("invalid");}	//testing
	}
	public void testManualTest_crash() {
		UrlValidator urlValue = new UrlValidator(null);
		assertTrue(urlValue.isValid("http://www.google.com")); //does not work
	}
	public void testManualTest_pass() {
		UrlValidator urlValue = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES);
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
