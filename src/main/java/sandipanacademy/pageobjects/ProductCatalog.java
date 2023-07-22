package sandipanacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sandipanacademy.AbstractComponents.AbstractComponents;

public class ProductCatalog extends AbstractComponents {

	WebDriver driver;

	public ProductCatalog(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@class='card-body'] /h5 /b")
	List<WebElement> allProducts;
	
	
	
	
	By Productlst=By.xpath("//div[@class='card-body']");
	By addtoCart= By.xpath("//div[@class='card-body'] /h5 /b /parent::h5/parent::div/button[2]");
	By addtoCart2=By.xpath("//div[3]//div[1]//div[1]//button[2]");
	By toastMessage=By.cssSelector("#toast-container");
	By spinnerMessage=By.cssSelector("ngx-spinner");
	
	
	public List<WebElement> productList() {
		
		waitForElementsToVisisble(Productlst);
		return allProducts;
		
	}
	
	public WebElement getProductByName(String product1) 
	{
		
		WebElement intendedProduct1= allProducts.stream().filter(s->s.getText().equalsIgnoreCase(product1)).findFirst().orElse(null);
		
		return intendedProduct1;
		
	}
	
	
	public void addProductToCart(String product1)
	{
			
		WebElement ProductSelected1=getProductByName(product1);
		ProductSelected1.findElement(addtoCart).click();
			
	}
	
	public void addProductToCart1(String product1)
	{
		
		WebElement ProductSelected1=getProductByName(product1);
		ProductSelected1.findElement(addtoCart2).click();
		waitForElementsToVisisble(toastMessage);
		waitForElementsToInvisible(spinnerMessage);
		
		
	}
	
	
	
	
	
	
}
