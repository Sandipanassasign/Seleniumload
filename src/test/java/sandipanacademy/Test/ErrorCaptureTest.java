package sandipanacademy.Test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.IRetryAnalyzer;
import org.testng.Assert;
import org.testng.annotations.Test;

import sandipanacademy.TestComponents.BaseTest;

public class ErrorCaptureTest extends BaseTest {
	
	@Test(groups = {"onlyerrorvalidation"}, dataProvider = "getData",retryAnalyzer = sandipanacademy.TestComponents.Retry.class)
	public void errorValidation(String emailid,String password) {
		
		
		
		
		
		
		landingpage.loginAction(emailid, password);
		Assert.assertEquals("Incorrect email or password.", landingpage.getErrorMsg());
		
		
		
	}
	
	@DataProvider
	public String[][] getData() {
		
		return new String[][] {{"baralsandipan17@yopmail.com","@Sandy123"},{"baralsandipan18@yopmail.com","@Sandy123"},
				{"baralsandipan100@yopmail.com","@Sandy123"}};
		 
		
		
	}
	
	
	

}
