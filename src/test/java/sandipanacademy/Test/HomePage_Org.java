package sandipanacademy.Test;

import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class HomePage_Org {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito","start-maximized");
		
		String emailid="testuser14@yopmail.com";
		WebDriver driver=new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client/");
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		/*
		driver.findElement(By.cssSelector("a[class='text-reset']")).click();
		
		driver.findElement(By.cssSelector("#firstName")).sendKeys("Test");
		driver.findElement(By.cssSelector("#lastName")).sendKeys("User");
		driver.findElement(By.cssSelector("#userEmail")).sendKeys(emailid);
		driver.findElement(By.cssSelector("#userMobile")).sendKeys("9062456753");
		
		WebElement Dropdown= driver.findElement(By.tagName("select"));
		
		Select Occupationdrpdown= new Select(Dropdown);
		
		
		
		
		Occupationdrpdown.selectByIndex(3);
		
		driver.findElement(By.cssSelector("input[value='Male']")).click();
		
		driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("@Sandy123");
		
		driver.findElement(By.cssSelector("#confirmPassword")).sendKeys("@Sandy123");
		driver.findElement(By.cssSelector("input[type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@id='login']")).click();
		
		
		driver.findElement(By.cssSelector("button[class='btn btn-primary']")).click();
		*/
		driver.findElement(By.cssSelector("#userEmail")).sendKeys(emailid);
		driver.findElement(By.cssSelector("#userPassword")).sendKeys("@Sandy123");
		
		driver.findElement(By.cssSelector("#login")).click();
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='card-body']")));
		
		List<WebElement> allProducts= driver.findElements(By.xpath("//div[@class='card-body'] /h5 /b"));
		
		String product1="ZARA COAT 3";
		String product2="IPHONE 13 PRO";
		
		WebElement intendedProduct1= allProducts.stream().filter(s->s.getText().equalsIgnoreCase(product1)).findFirst().orElse(null);
		
		intendedProduct1.findElement(By.xpath("//div[@class='card-body'] /h5 /b /parent::h5/parent::div/button[2]")).click();
		
		
		Thread.sleep(3000);
		
		WebElement intendedProduct2= allProducts.stream().filter(s->s.getText().equalsIgnoreCase(product2)).findAny().orElse(null);
		
		intendedProduct2.findElement(By.xpath("//div[3]//div[1]//div[1]//button[2]")).click();
		
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("ngx-spinner")));
		
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		
		System.out.println(driver.findElement(By.cssSelector("div[class='toast-bottom-right toast-container']")).getText());
		
		
		List<WebElement> cartProducts=driver.findElements(By.cssSelector(".cartSection h3"));
		
		boolean matchcount = cartProducts.stream().anyMatch(s->s.getText().equalsIgnoreCase(product1));
		
		Assert.assertTrue(matchcount);
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,800)");
		
		
		Thread.sleep(2000);
	
		

		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		driver.findElement(By.cssSelector("input[value='4542 9931 9292 2293']")).clear();
		driver.findElement(By.cssSelector("input[value='4542 9931 9292 2293']")).sendKeys("4457 5874 6658 1854");
		
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("874");
		
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("sandy B");
		driver.findElement(By.cssSelector("input[name='coupon']")).sendKeys("RahulSHettty");
		
		
		
		 Actions act=new Actions(driver);
		 
		 act.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")), "US").build().perform();
		 
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		 
		 driver.findElement(By.cssSelector("button[class*='a-item']:nth-of-type(5)")).click();
		
		 driver.findElement(By.cssSelector(".btnn.action__submit.ng-star-inserted")).click();

		
		}
		
		
		
}
