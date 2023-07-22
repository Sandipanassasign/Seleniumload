package sandipanacademy.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import sandipanacademy.pageobjects.LandingPage;

public class BaseTest_withSelGridSupport {
	
	public WebDriver driver;
	public LandingPage landingpage;
	public WebDriver initializeDriver() throws IOException 
	{
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--incognito","start-maximized","--remote-allow-origins=");
		

		DesiredCapabilities caps=new DesiredCapabilities();
		caps.acceptInsecureCerts();
		caps.setBrowserName("chrome");
		caps.setCapability(ChromeOptions.CAPABILITY, options);
		
		
		RemoteWebDriver driver=new RemoteWebDriver(new URL("http://192.168.1.13:4444"),caps);
		
		
		
		
		/*
		Properties prop=new Properties();
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\sandipanacademy\\resources\\GlobalData.properties");
		prop.load(fis);
		
		String getBrowser = System.getProperty("browser")!= null ? System.getProperty("browser") : prop.getProperty("browser");
		//String getBrowser = prop.getProperty("browser");
		
		if(getBrowser.equalsIgnoreCase("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito","start-maximized","--remote-allow-origins=*");
		driver=new ChromeDriver(options);
		
		} 
			
			if(getBrowser.equalsIgnoreCase("chromeheadless"))
		{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		driver=new ChromeDriver(options);
		driver. manage(). window(). setSize(new Dimension(1920, 1080));
		
		}
		else if (getBrowser.equalsIgnoreCase("firefox"))
			
			
		{
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--incognito","start-maximized");
			 driver=new FirefoxDriver(options);
			
		}	else if (getBrowser.equalsIgnoreCase("edge"))
			
			
		{
			WebDriverManager.edgedriver().setup();
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--incognito","start-maximized");
			driver=new EdgeDriver(options);
		}
		
		
		*/
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	
	
	public List<HashMap<String,String>> convertJsontoMap(String filepath) throws IOException {
			
			
			String data= FileUtils.readFileToString(new File(filepath),StandardCharsets.UTF_8);
			
			ObjectMapper mapper=new ObjectMapper();
			
			List<HashMap<String, String>> userData= mapper.readValue(data, new TypeReference<List<HashMap<String, String>>>() {
			});
			
			
			return userData;
			
		}
	
	public String getScreenshot(String testcaseName,WebDriver driver) throws IOException {
		
		TakesScreenshot screenshot=  (TakesScreenshot)driver;
		File sourceFile= screenshot.getScreenshotAs(OutputType.FILE);
		File outFile=new File(System.getProperty("user.dir")+"//screenhots//"+testcaseName+".png");
		FileUtils.copyFile(sourceFile, outFile);
		return System.getProperty("user.dir")+"//screenhots//"+testcaseName+".png";
	}
	

	
	
	
	@BeforeMethod (alwaysRun = true)
	public LandingPage launchUrl() throws IOException
	{
		driver= initializeDriver();
		landingpage=new LandingPage(driver);
		
		landingpage.goTOURL();
		
		return landingpage;
		
	}
	
	@AfterMethod (alwaysRun = true)
	public void closeDriver()
	{
		
		driver.quit();
		
	}

}
