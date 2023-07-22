package sandipanacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import sandipanacademy.AbstractComponents.AbstractComponents;

public class MyOrderPage extends AbstractComponents {
	
	public boolean isProductPresent=false;
	public WebDriver driver;
	
	public MyOrderPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	By allProductsNames=By.xpath("//tbody/tr/td[2]");
	
	
	public boolean validateProduct(String product1) {	
		
		
		
		List<WebElement> productNames=driver.findElements(allProductsNames);
		
		boolean isProductPresent=productNames.stream().anyMatch(s->s.getText().equalsIgnoreCase(product1));
		
		/*
		for(WebElement product: productNames  ) 
		{
			
			if(product.getText().equalsIgnoreCase(addedProduct))
			{
				
				System.out.println("Match found zaara");
				isProductPresent=true;
			}
			
		}*/  return isProductPresent;
	}
	
	
	
	
	

}
