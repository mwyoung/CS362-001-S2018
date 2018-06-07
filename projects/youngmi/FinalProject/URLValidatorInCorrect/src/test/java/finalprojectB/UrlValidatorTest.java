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
			String[] falseURLs = { "http://oregonstate.%edu", "qwerty", "://lkjfdsa;lkjfdsa","|||||||||",null};
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
		
		//test null
		//UrlValidator urlValue2 = UrlValidator.getInstance(); 
		assertFalse(urlValue.isValid(null));
		
		//try{}catch(Exception e){}
		//if(urlValue.isValid("http://oregonstate.com")){System.out.println("valid");} 
		//else { System.out.println("invalid");}	//testing
		//RegexValidator regValue = new RegexValidator("com");
		//UrlValidator urlValue = new UrlValidator(regValue,UrlValidator.ALLOW_ALL_SCHEMES);
	}
	public void testManualTest_default() {
		UrlValidator urlValue = new UrlValidator(null);
		assertTrue(urlValue.isValid("http://www.google.com")); //does not work
	}
	public void testManualTest_all() {
		UrlValidator urlValue = new UrlValidator(null,null,UrlValidator.ALLOW_ALL_SCHEMES);
		assertTrue(urlValue.isValid("http://www.google.com")); //does work
		assertFalse(urlValue.isValid(null));
		assertFalse(urlValue.isValid("    "));
		try {
			if(!urlValue.isValid("https://google.com")) { //does not work	
				System.out.println("error");
			}
		}catch (Exception e) {
			System.out.println("testManualTest_all error: " + e.getMessage());
		}
	}
	
/////////////////////////////////////////////////////////////////////////
	//First Partition testing - Schemes
	public void testPartition1(){
		System.out.println("Starting first partition test, default schemes");
		//String[] schemes = {"http","https","ftp"}; //default
		UrlValidator urlValue = new UrlValidator(null);
		try {
			String[] trueURLs = { "http://www.google.com", "http://example.com", "http://example.com/",
					"http://www.example.com", "ftp://example.com", "https://example.com/" };
			for (int i = 0; i < trueURLs.length; i++) {
				if (urlValue.isValid(trueURLs[i])) {
					System.out.println("    valid: " + trueURLs[i]);
				} else {
					System.out.println("!!invalid: " + trueURLs[i]);
				}
				//assertTrue(trueURLs[i],urlValue.isValid(trueURLs[i]));
			} 
		} catch (Exception e) {
			System.out.println("TrueURL error: " + e.getMessage());
		}

		System.out.println("Starting first partition test, default schemes false");
		try {
			String[] falseURLs = {"http:www.example.com", "htp://example.com", "http//example.com",
					"http://www.example.", "ftp://example.com.", "http://example./"};
			for (int i = 0; i < falseURLs.length; i++) {
				if (urlValue.isValid(falseURLs[i])) {
					System.out.println("    valid: " + falseURLs[i]);
				} else {
					System.out.println("!!invalid: " + falseURLs[i]);
				}
			} 
		} catch (Exception e) {
			System.out.println("TrueURL error: " + e.getMessage());
		}
	}
	public void testPartition1_all(){
		System.out.println("Starting first partition test, all schemes");
		//String[] schemes = {"http","https","ftp"}; //default
		UrlValidator urlValue = new UrlValidator(null,null,UrlValidator.ALLOW_ALL_SCHEMES);
		try {
			String[] trueURLs = {"http://www.google.com", "http://example.com", "http://example.com",
					"http://www.example.com", "http://example.com/"};
			for (int i = 0; i < trueURLs.length; i++) {
				if (urlValue.isValid(trueURLs[i])) {
					System.out.println("    valid: " + trueURLs[i]);
				} else {
					System.out.println("!!invalid: " + trueURLs[i]);
				}
			} 
		} catch (Exception e) {
			System.out.println("TrueURL error: " + e.getMessage());
		}
	}
	public void testPartition1_all_other(){
		System.out.println("Starting first partition test, https/ftp");
		UrlValidator urlValue = new UrlValidator(null,null,UrlValidator.ALLOW_ALL_SCHEMES);
		try {
			String[] trueURLs = {"https://example.com", "https://www.example.com","https://www.example.com/",
					"ftp://example.com", "ftp://www.example.com","ftp://www.example.com/" };
			for (int i = 0; i < trueURLs.length; i++) {
				if (urlValue.isValid(trueURLs[i])) {
					System.out.println("    valid: " + trueURLs[i]);
				} else {
					System.out.println("!!invalid: " + trueURLs[i]);
				}
			} 
		} catch (Exception e) {
			System.out.println("TrueURL error: " + e.getMessage());
		}
	}
	
	//Second Partition testing - IP schemes
	public void testPartition2() {
		System.out.println("Starting second partition IP test, default schemes");
		// String[] schemes = {"http","https","ftp"}; //default
		UrlValidator urlValue = new UrlValidator(null);
		try {
			String[] trueURLs = { "http://0.0.0.0", "http://0.0.0.0", "http://0.0.0.0:0", "http://0.0.0.0:65535",
					"ftp://0.0.0.0:0", "ftp://255.com/t123" };
			for (int i = 0; i < trueURLs.length; i++) {
				if (urlValue.isValid(trueURLs[i])) {
					System.out.println("    valid IP: " + trueURLs[i]);
				} else {
					System.out.println("!!invalid IP: " + trueURLs[i]);
				}
			}
		} catch (Exception e) {
			System.out.println("TrueURL IP error: " + e.getMessage());
		}
		
		System.out.println("Starting second partition IP test, default schemes false");
		try {
			String[] falseURLs = { "http:0.0.0.0:0", "htp://0.0.0.0:0", "http//0.0.0.0:0", "http://0.0.0.0:0.",
					"ftp://0.0.0.0:0", "http://0.0.0.0./" };
			for (int i = 0; i < falseURLs.length; i++) {
				if (urlValue.isValid(falseURLs[i])) {
					System.out.println("    valid IP: " + falseURLs[i]);
				} else {
					System.out.println("!!invalid IP: " + falseURLs[i]);
				}
			}
		} catch (Exception e) {
			System.out.println("TrueURL IP error: " + e.getMessage());
		}
	}
	public void testPartition2_all() {
		System.out.println("Starting second partition IP test, all schemes");
		// String[] schemes = {"http","https","ftp"}; //default
		UrlValidator urlValue = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
		try {
			String[] trueURLs = { "http://255.255.255.255/$23", "http://255.255.255.255:0",
					"http://255.255.255.255?action=edit&mode=up", "http://0.0.0.0:80/test1/file?action=view",
					"http://255.com/t123"};
			for (int i = 0; i < trueURLs.length; i++) {
				if (urlValue.isValid(trueURLs[i])) {
					System.out.println("    valid IP: " + trueURLs[i]);
				} else {
					System.out.println("!!invalid IP: " + trueURLs[i]);
				}
			}
		} catch (Exception e) {
			System.out.println("TrueURL IP error: " + e.getMessage());
		}
	}
	public void testPartition2_all_other(){
		System.out.println("Starting second partition test IP, https/ftp");
		UrlValidator urlValue = new UrlValidator(null,null,UrlValidator.ALLOW_ALL_SCHEMES);
		try {
			String[] trueURLs = {"https://0.0.0.0:80/test1/file?action=view","https://0.0.0.0:65535/test1?action=edit&mode=up", 
					"https://255.255.255.255:65535/$23", "ftp://0.0.0.0:80/test1/file?action=view",
					"ftp://0.0.0.0:65535/test1?action=edit&mode=up", "ftp://255.255.255.255:65535/$23" };
			for (int i = 0; i < trueURLs.length; i++) {
				if (urlValue.isValid(trueURLs[i])) {
					System.out.println("    valid: " + trueURLs[i]);
				} else {
					System.out.println("!!invalid: " + trueURLs[i]);
				}
			} 
		} catch (Exception e) {
			System.out.println("TrueURL error: " + e.getMessage());
		}
	}
	
	//Third Partition testing - URL domains
	public void testPartition3(){
		System.out.println("Starting third partition test URL - domains");
		String[] schemes = {"http","https"}; //default
		UrlValidator urlValue = new UrlValidator(schemes);
		try {
			String[] trueURLs = { "http://www.google.com", "https://example.com", "http://example.com",
					"http://www.example.com", "https://example.com/", "http://example.com:80"};
			for (int i = 0; i < trueURLs.length; i++) {
				if (urlValue.isValid(trueURLs[i])) {
					System.out.println("    valid: " + trueURLs[i]);
				} else {
					System.out.println("!!invalid: " + trueURLs[i]);
				}
			} 
		} catch (Exception e) {
			System.out.println("TrueURL error: " + e.getMessage());
		}
		
		System.out.println("Starting third partition test false");
		try {
			String[] falseURLs = { "http:www.example.com", "htp://example.com", "http//example.com",
					"https//example.com","http://www.example.", "https://example.", "http://example./",
					"http://www.example.com:-123", "http://www.example.com:67890"};
			for (int i = 0; i < falseURLs.length; i++) {
				if (urlValue.isValid(falseURLs[i])) {
					System.out.println("!!  valid: " + falseURLs[i]);
				} else {
					System.out.println("  invalid: " + falseURLs[i]);
				}
			} 
		} catch (Exception e) {
			System.out.println("FalseURL error: " + e.getMessage());
		}
		assertFalse(urlValue.isValid("ftp://example.com")); //is false
	}
	
	//fourth partition testing - IP domains
	public void testPartition4(){
		System.out.println("Starting fourth partition IP test - domains");
		String[] schemes = {"http","https"}; //default
		UrlValidator urlValue = new UrlValidator(schemes);
		try {
			String[] trueURLs = { "http://0.0.0.0:80", "http://0.0.0.0:65535/t123", "http://255.255.255.255:80/$23",
					"http://255.com:80/test1", "http://255.com" };
			for (int i = 0; i < trueURLs.length; i++) {
				if (urlValue.isValid(trueURLs[i])) {
					System.out.println("    valid IP: " + trueURLs[i]);
				} else {
					System.out.println("!!invalid IP: " + trueURLs[i]);
				}
			} 
		} catch (Exception e) {
			System.out.println("TrueURL IP error: " + e.getMessage());
		}

		System.out.println("Starting fourth partition IP test false");
		try {
			String[] falseURLs = { "http:0.0.0.0:80.com", "htp://0.0.0.0:80", "http//0.0.0.0.com",
					"https//0.0.0.0:80","http://0.0.0.0:80.", "https://0.0.0.0.", "http://0.0.0.0./" };
			for (int i = 0; i < falseURLs.length; i++) {
				if (urlValue.isValid(falseURLs[i])) {
					System.out.println("    valid IP: " + falseURLs[i]);
				} else {
					System.out.println("!!invalid IP: " + falseURLs[i]);
				}
			} 
		} catch (Exception e) {
			System.out.println("TrueURL IP error: " + e.getMessage());
		}
	}
	
	//fifth Partition testing - URL paths and fragments
	public void testPartition5(){
		System.out.println("Starting fifth partition test URL test - path fragments");
		String[] schemes = {"http","https"}; //default
		UrlValidator urlValue = new UrlValidator(schemes);
		try {
			String[] trueURLs = { "http://www.example.com/", "http://example.com:80", 
					"http://example.com/123", "http://www.example.com/abc/", 
					"http://example.com/abc/test?do=view","http://example.com?do=view",
					"http://example.com/fdlkjfads"};
			for (int i = 0; i < trueURLs.length; i++) {
				if (urlValue.isValid(trueURLs[i])) {
					System.out.println("    valid: " + trueURLs[i]);
				} else {
					System.out.println("!!invalid: " + trueURLs[i]);
				}
			} 
		} catch (Exception e) {
			System.out.println("TrueURL error: " + e.getMessage());
		}

		System.out.println("Starting fifth partition test false");
		try {
			String[] falseURLs = { "http//www.example.com/", "http://example.com:", 
					"http://.com/123", "http://.example.com/abc/", 
					"http://example.com/abc/?do=view  ","http://example.com ?do=view",
					"http://example.com/fdlkjfads;;"};
			for (int i = 0; i < falseURLs.length; i++) {
				if (urlValue.isValid(falseURLs[i])) {
					System.out.println("!!  valid: " + falseURLs[i]);
				} else {
					System.out.println("  invalid: " + falseURLs[i]);
				}
			} 
		} catch (Exception e) {
			System.out.println("falseURL error: " + e.getMessage());
		}
	}	
	
	//sixth Partition testing - URL paths and fragments
	public void testPartition6(){
		System.out.println("Starting sixth partition IP test - path fragments");
		String[] schemes = {"http","https"}; //default
		UrlValidator urlValue = new UrlValidator(schemes);
		try {
			String[] trueURLs = { "http://0.0.0.0:80/$23", "http://0.0.0.0:80", 
					"http://0.0.0.0:65535/$23?action=edit&mode=up", "http://0.0.0.0/t123?action=view", 
					"http://255.255.255.255/$23","http://255.255.255.255/test1/file?action=edit&mode=up",
					"http://255.com:80/test1?action=view"};
			for (int i = 0; i < trueURLs.length; i++) {
				if (urlValue.isValid(trueURLs[i])) {
					System.out.println("    valid IP: " + trueURLs[i]);
				} else {
					System.out.println("!!invalid IP: " + trueURLs[i]);
				}
			} 
		} catch (Exception e) {
			System.out.println("TrueURL IP error: " + e.getMessage());
		}

		System.out.println("Starting sixth partition IP test false");
		try {
			String[] falseURLs = { "http//0.0.0.0/", "http://0.0.0.0.com:", 
					"http://.com/123", "http://.0.0.0.0.com/abc/", 
					"http://255.255.255.255.com/abc/?do=view  ","http://0.0.0.0?do=view",
					"http://255.255.255.255.com/fdlkjfads"};
			for (int i = 0; i < falseURLs.length; i++) {
				if (urlValue.isValid(falseURLs[i])) {
					System.out.println("    valid IP: " + falseURLs[i]);
				} else {
					System.out.println("!!invalid IP: " + falseURLs[i]);
				}
			} 
		} catch (Exception e) {
			System.out.println("TrueURL IP error: " + e.getMessage());
		}
	}

/////////////////////////////////////////////////////////////////////
	//For programming based testing
	public void testIsValid(){
		System.out.println("\n" + "Starting programming based test");
		String[] schemes = {"http","https","ftp","HTTP","HTTPS"}; //default
		UrlValidator urlValue = new UrlValidator(schemes);
		UrlValidator urlValueAll = new UrlValidator(null,null,UrlValidator.ALLOW_ALL_SCHEMES);
		
		//store values
		String[] URLs = {"http://","https://","","ftp://", "HTTP://","HTTPS://", //valid
				"htp://","http:","http//","://","l;kjafds;","htt:p//", "file://","",null,"^#||","  "}; //invalid
		int URLs_valid = 5; //Number of valid URLs
		String[] Domain = {"www.example.com", "example.com", "EXAMPLE.com","google.com", "test.com","0.0.0.0", "192.168.1.1",
				"example.",".example.com","0.0.0.","0.0.0.0.","","432.234.432.234","1..3.4","1.2.a.b","a.b.c.d","1.#.3.4","",
				"www.example.comwww.example.com",null,"  ",";fdsa;fdsa;","t.e.s.t.url."};
		int Domain_valid = 7;
		String[] Port = {"",":80",":65200",
				":ds",":84a",":---",null,"  ",":67890",":-1"};
		int Port_valid = 3;
		String[] Path = {"","/example","/example/","/file/path","/",
				"...","/....../fdsalkj","//","/../","/..",null,"  "};
		int Path_valid = 5;
		String[] End = {"","?do=thing",
				"?  ?", "^^^^","||","{}",null,"  "};
		int End_valid = 2;
		boolean validOutput;
		int correct = 0;
		int true_invalid = 0;
		int incorrect = 0;
		
		//loop through all strings
		for(int i=0; i<URLs.length-1;i++) {
			for(int j=0; j<Domain.length-1;j++) {
				for(int k=0; k<Port.length-1;k++) {
					for(int l=0; l<Path.length-1;l++) {
						for(int m=0; m<End.length-1;m++) {
							//build string
							String fullURL = URLs[i] + Domain[j] + Port[k] + Path[l] + End[m];
							//check if valid
							if((i<URLs_valid)&&(j<Domain_valid)&&(k<Port_valid)&&(l<Path_valid)&&(m<End_valid)) {
								validOutput = true;
							}
							else {
								validOutput = false;
							}
							
							try {
								// test if valid
								if (urlValue.isValid(fullURL)) {
									if (validOutput) {
										++correct; // good to go
									} else {
										System.out.println("!!invalid: " + fullURL);
										++incorrect;
									}
								} else {
									if (validOutput) {
										System.out.println("Wrong invalid: " + fullURL);
										++incorrect;
										if(i<1) {	//try all schemes
											if(urlValueAll.isValid(fullURL)) {
												System.out.println("\tScheme error");
											}
										}
									} else { // is supposed to be invalid
										++true_invalid; // correct
									}
								}
							} catch (Exception e) {	//in case of errors, catch output
								System.out.println("Exception " + e + " with " + fullURL);
							}
						}
					}
				}
			}
		}
		//get results
		int total = (URLs.length)*(Domain.length)*(Port.length)*(Path.length)*(End.length);
		System.out.println("Correct: " + correct + " True Invalid: " + true_invalid + 
				" Incorrect: " + incorrect + " Total: " + total);
	}	
}