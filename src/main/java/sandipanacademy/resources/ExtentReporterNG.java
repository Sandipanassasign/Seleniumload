package sandipanacademy.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporterNG {
	
	ExtentReports extent;
	public static ExtentReports getExtentReport() {
		
		String path=System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		
		reporter.config().setDocumentTitle("Web Automation Selenium");
		reporter.config().enableOfflineMode(true);
		reporter.config().setReportName("Automation Report Selenium");
		reporter.config().setTheme(null);
		
		
		reporter.config().setCss("css-string");
		reporter.config().setEncoding("utf-8");
		reporter.config().setCss("js-string");
		reporter.config().setTheme(Theme.DARK);
	
		
		
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Sandipan B");
		
		
		return extent;
		
		
		
		
	
		
		
	}

}
