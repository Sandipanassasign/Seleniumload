package sandipanacademy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import sandipanacademy.AbstractComponents.AbstractComponents;

public class RegisterPage extends AbstractComponents {
	
	public WebDriver driver;
	
	
	public RegisterPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(css="#firstName")
	WebElement firstName;
	@FindBy(css="#lastName")
	WebElement lastName;
	@FindBy(css="#userEmail")
	WebElement email;
	@FindBy(css="#userMobile")
	WebElement userMobile;
	@FindBy(tagName="select")
	WebElement occupationDrpDown;
	@FindBy(css="input[value='Male']")
	WebElement gender;
	
	@FindBy(xpath="//input[@id='userPassword']")
	WebElement userPassword;
	@FindBy(css="#confirmPassword")
	WebElement confirmPassword;
	
	@FindBy(css="input[type='checkbox']")
	WebElement consentChckBox;
	@FindBy(css="#login")
	WebElement registerBtn;
	
	@FindBy(css=".headcolor")
	WebElement accountsucessMsg;
	
	
	
	
	public void registerFillUp(String emailid) {
		
		firstName.sendKeys("Test");
		lastName.sendKeys("User");
		email.sendKeys(emailid);
		userMobile.sendKeys("9062456753");
		Select Occupationdrpdown= new Select(occupationDrpDown);
		Occupationdrpdown.selectByIndex(3);
		gender.click();
		userPassword.sendKeys("@Sandy123");
		confirmPassword.sendKeys("@Sandy123");
		consentChckBox.click();
		
		
	}
	
	public void registerBtnClick() {
		
		registerBtn.click();
	}
	
	public String registerSuccess() {
		
	String msg=	accountsucessMsg.getText();
		return msg;
		
	}
	
	
	
	

}
