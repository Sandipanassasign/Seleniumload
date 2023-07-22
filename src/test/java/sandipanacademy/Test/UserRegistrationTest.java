package sandipanacademy.Test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import sandipanacademy.TestComponents.BaseTest;
import sandipanacademy.pageobjects.RegisterPage;

public class UserRegistrationTest extends BaseTest{
	
	
	@Test(dataProvider = "getEmailData")
	public void registerUser(String email) {
		
		
		landingpage.gotoRegister();
		RegisterPage register=new RegisterPage(driver);
		
		register.registerFillUp(email);
		register.registerBtnClick();
		
		System.out.println(driver.getCurrentUrl());
		
		System.out.println(driver.findElement(By.cssSelector(".headcolor")).getText());
		
	}
	
	
	
	
	
	
	@DataProvider
	public Object[][] getEmailData() {
		
		return new Object[][] {{"Testuser104@yopmail.com"},{"Testuser105@yopmail.com"},{"Testuser106@yopmail.com"}};
	}

}
