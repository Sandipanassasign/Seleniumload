package sandipanacademy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sandipanacademy.AbstractComponents.AbstractComponents;

public class ThankYouPage extends AbstractComponents {
	
	WebDriver driver;
	
	public ThankYouPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(css = ".hero-primary")
	WebElement thankYouText;
	
	
	public String compareText()
	{
		String Thankyou= thankYouText.getText();
		return Thankyou;
		
	}
	
	public void closeBrowser() {
		
		driver.quit();
	}
	
	

}
