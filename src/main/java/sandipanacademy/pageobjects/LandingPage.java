package sandipanacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sandipanacademy.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {

	public WebDriver driver;
	public RegisterPage register;
	
	
	
	public LandingPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	

	@FindBy(css = "#userEmail")
	WebElement userEmail;

	@FindBy(css = "#userPassword")
	WebElement password;

	@FindBy(css = "#login")
	WebElement loginbtn;
	
	@FindBy(css="a[class='text-reset']")
	WebElement registerBtn;
	
	@FindBy(css="[class*='toast-bottom-right toast-container']")
	WebElement errorMsg;
	
	
	public ProductCatalog loginAction(String username,String Password ) 
	{		
		userEmail.sendKeys(username);
		password.sendKeys(Password);
		loginbtn.click();
		
		ProductCatalog products=new ProductCatalog(driver);
		return products;
	}
	
	public String getErrorMsg() {
		
		
		waitForElementsToVisisblewebelement(errorMsg);
		return errorMsg.getText();
		
	}
	
	public RegisterPage gotoRegister() {
		
		registerBtn.click();
		RegisterPage register=new RegisterPage(driver);
		return register;
	}
	
	
	public void goTOURL() 
	{
		
		driver.get("https://rahulshettyacademy.com/client/");
	}
	
	

}
