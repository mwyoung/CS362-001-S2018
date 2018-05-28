package finalprojectB;

import junit.framework.TestCase;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!

public class UrlValidatorTest extends TestCase {

	public UrlValidatorTest(String testName) {
		super(testName);
	}

	//For manual testing
	public void testManualTest() { 
		String[] schemes = {"http","https","ftp"};
		UrlValidator urlValue = new UrlValidator(schemes, UrlValidator.ALLOW_ALL_SCHEMES);
		assertFalse(urlValue.isValid("qwerty:43")); 	//first false test
		assertTrue(urlValue.isValid("http://oregonstate.edu/"));
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
