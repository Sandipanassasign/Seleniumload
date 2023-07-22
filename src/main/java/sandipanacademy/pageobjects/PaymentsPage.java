package sandipanacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import sandipanacademy.AbstractComponents.AbstractComponents;

public class PaymentsPage extends AbstractComponents {

	WebDriver driver;

	public PaymentsPage(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "input[value='4542 9931 9292 2293']")
	WebElement ccNumber;
	@FindBy(xpath = "(//input[@type='text'])[2]")
	WebElement ccvNumber;
	@FindBy(xpath = "(//input[@type='text'])[3]")
	WebElement cardName;
	@FindBy(css = "input[name='coupon']")
	WebElement CouponCode;
	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement Country;
	@FindBy(css = "button[class*='a-item']:nth-of-type(5)")
	WebElement SelectedCountry;
	@FindBy(css = ".btnn.action__submit.ng-star-inserted")
	WebElement placeOrderButton;
	
	
	
	By selectedCountry= By.cssSelector(".ta-results");
	
	
	public void personalInformationFillUp(String CCnumber,String CVV,String name,String couponCode) 
	{
		
		ccNumber.clear();
		ccNumber.sendKeys(CCnumber);
		ccvNumber.sendKeys(CVV);
		cardName.sendKeys(name);
		CouponCode.sendKeys(couponCode);
		
		
	}
	
	public void selectCountryDrpdown(String Countryname)
	{
		
		
		 Actions act=new Actions(driver);
		 
		 act.sendKeys(Country, Countryname).build().perform();
		 
		 waitForElementsToVisisble(selectedCountry);
		 
		 SelectedCountry.click();
		
	}
	
	
	public ThankYouPage Placeorder()
	{
		placeOrderButton.click();
		
		 
		ThankYouPage thanku=new ThankYouPage(driver);
		return thanku;
		
		
	}
	
	
	
	
	
}
