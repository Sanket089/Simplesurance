package testcases.insurance;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebdriverSettings {
	
	public WebDriver driverSettings() {
//		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe File PATH");
		
	/*
		 File f = new File("Webdriver"); // for MacOS
		    File chromeDriver = new File(f,"chromedriver"); // for MacOS
		    System.setProperty("webdriver.chrome.driver",chromeDriver.getAbsolutePath());
		    System.out.println("absolutePath:-"+chromeDriver.getAbsolutePath());
		    WebDriver driver = new ChromeDriver();
		
		    */
		
		 File f = new File("Webdriver"); // Assuming GeckoDriver is in the "Webdriver" directory
	        File geckoDriver = new File(f, "geckodriver"); // Assuming the GeckoDriver executable is named "geckodriver"

	        // Set the system property for GeckoDriver
	        System.setProperty("webdriver.gecko.driver", geckoDriver.getAbsolutePath());
	        System.out.println("absolutePath: " + geckoDriver.getAbsolutePath());

	        // Initialize FirefoxDriver
	        WebDriver driver = new FirefoxDriver();
	        return driver;
	}

}
