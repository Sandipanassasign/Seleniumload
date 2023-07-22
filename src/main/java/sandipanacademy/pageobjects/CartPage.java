package sandipanacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import sandipanacademy.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents {

	WebDriver driver;

	public CartPage(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css="div[class='toast-bottom-right toast-container']")
	WebElement toastMsg;
	
	@FindBy(css = ".totalRow button")
	WebElement proceedToPaymentBtn;
	
	By cartProductList=By.cssSelector(".cartSection h3");
	
	
	
	public void getToastMessage()
	{
		String msg=toastMsg.getText();
		System.out.println(msg);
	}
	
	public List<WebElement> getAllCartProducts()
	{
		
		List<WebElement> allCartProducts=driver.findElements(cartProductList);
		return allCartProducts;
		
		
		
	}
	
	
	
	
	public boolean isProductAddedPresent(String product1) 
	{
		
		List<WebElement> allCartProducts = getAllCartProducts();
		boolean matchcount =allCartProducts.stream().anyMatch(s->s.getText().equalsIgnoreCase(product1));
		
		return matchcount;
		
		
	}
	
	public void scrollWindow()
	{
		
		AbstractComponents components=new AbstractComponents(driver);
		components.windowsScroll();
	}
	
	
	public PaymentsPage proceedToPayment()
	{
		
		proceedToPaymentBtn.click();
		PaymentsPage paymentPage=new PaymentsPage(driver);
		return paymentPage;
		
	}
	
	
	
}
