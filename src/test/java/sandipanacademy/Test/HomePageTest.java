package sandipanacademy.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import sandipanacademy.TestComponents.BaseTest;
import sandipanacademy.pageobjects.CartPage;
import sandipanacademy.pageobjects.MyOrderPage;
import sandipanacademy.pageobjects.PaymentsPage;
import sandipanacademy.pageobjects.ProductCatalog;
import sandipanacademy.pageobjects.ThankYouPage;

public class HomePageTest extends BaseTest{
	
	
	

	@Test(dataProvider = "getData", groups = "DataDrivenTest")
	public void submitOrder(HashMap<String, String> input) throws IOException, InterruptedException
	{
		
	
		// TODO Auto-generated method stub
		
		
		
		
		//Landing page object :
		
		
		
		
		
		
		String product2="IPHONE 13 PRO";
		
		
		ProductCatalog products=landingpage.loginAction(input.get("email"), input.get("password"));
		
		//ProductCatalog page object :
		//ProductCatalog products=new ProductCatalog(driver);
		List<WebElement> productsAll= products.productList();
		
		products.addProductToCart(input.get("product1"));
		Thread.sleep(3000);
		products.addProductToCart1(input.get("product2"));
		CartPage cartpage=products.moveToCart();
		
		
		
		
		//CartPage page object :		
		//CartPage cartpage=new CartPage(driver);
		cartpage.getToastMessage();
		List<WebElement> cartProductsAll= cartpage.getAllCartProducts();
		
		boolean matchcount= cartpage.isProductAddedPresent(input.get("product1"));
		Assert.assertTrue(matchcount);
		
		cartpage.scrollWindow();
		Thread.sleep(2000);
		PaymentsPage paymentPage=cartpage.proceedToPayment();
		
		
		//PaymentsPage page object :
		//PaymentsPage paymentPage=new PaymentsPage(driver);
		paymentPage.personalInformationFillUp("4457 5874 6658 1854","352", "sandy B", "RahulSHettty");
		
		paymentPage.selectCountryDrpdown("US");
		Thread.sleep(2000);
		ThankYouPage thanku=paymentPage.Placeorder();
		
		
		//ThankYouPage page object :
		
		//ThankYouPage thanku=new ThankYouPage(driver);
		
		String Thankyou=thanku.compareText();
		Assert.assertEquals(Thankyou, "THANKYOU FOR THE ORDER.");
		
		
		
		
		}
	
	
	@Test(dependsOnMethods = {"submitOrder"},dataProvider = "getData")
	public void validateMyOrder(HashMap<String, String> input) {
		
		
		
		
		landingpage.loginAction(input.get("email"), input.get("password"));
		
		landingpage.moveToOrders();
		
		MyOrderPage order=new MyOrderPage(driver);
		
		order.validateProduct(input.get("product1"));
		
		Assert.assertTrue(order.validateProduct(input.get("product1")));
		
		
	}
		
		
	@DataProvider
	public Object[][] getData() throws IOException {
		
		
	
		List<HashMap<String, String>> data= convertJsontoMap(System.getProperty("user.dir")+"\\src\\test\\java\\sandipanacademy\\data\\getData.json");
		
		return new Object[][] {{data.get(0)},{data.get(1)},{data.get(2)}};
	}
	

	
	
	
	
//	//DataProvider using Hashmap
//	@DataProvider
//	public Object[][] getData() {
//		
//		HashMap<Object,Object> map=new HashMap<Object,Object>();
//	
//		map.put("email", "Testuser58@yopmail.com");
//		map.put("password", "@Sandy123");
//		map.put("product1", "ZARA COAT 3");
//		map.put("product2", "IPHONE 13 PRO");
//		
//		HashMap<Object,Object> map1=new HashMap<Object,Object>();
//		
//		map1.put("email", "Testuser59@yopmail.com");
//		map1.put("password", "@Sandy123");
//		map1.put("product1", "IPHONE 13 PRO");
//		map1.put("product2", "ZARA COAT 3");
//		
//		HashMap<Object,Object> map2=new HashMap<Object,Object>();
//		
//		map2.put("email", "Testuser60@yopmail.com");
//		map2.put("password", "@Sandy123");
//		map2.put("product1", "IPHONE 13 PRO");
//		map2.put("product2", "ZARA COAT 3");
//		
//		return new Object[][] {{map},{map1},{map2}};
//	}
	
	//DataProvider using Objects
//	@DataProvider
//	public Object[][] getData( ) {
//		
//		
//		return new Object[][] {{"testuser14@yopmail.com","@Sandy123","iphone 13 pro"},{"testuser17@yopmail.com","@Sandy123","ZARA COAT 3"}};
//	}
		
		

}

