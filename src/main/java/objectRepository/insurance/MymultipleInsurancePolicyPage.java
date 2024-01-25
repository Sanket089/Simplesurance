package objectRepository.insurance;

import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MymultipleInsurancePolicyPage {

	WebDriver driver;

	@FindBy(xpath = "//span[contains(text(),'Import')]")
	WebElement importoptionheader;

	@FindBy(xpath = "//span[contains(text(),'Select or drop CSV file here')]")
	WebElement uploadFile;

	@FindBy(xpath = "//input[@id='login_password']")
	WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement submit;

	@FindBy(xpath = "//span[contains(text(),'New')]")
	WebElement New;

	public MymultipleInsurancePolicyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement importOptionHeaderPath() {
		return importoptionheader;
	}

	public void uploadfileOptionPath() {

		File f = new File("CSV/testdata.csv");
		String absolute = f.getAbsolutePath();
		System.out.println("Original  path: " + f.getPath());
		System.out.println("Absolute  path: " + absolute);

		WebElement fileInput = driver.findElement(By.cssSelector("input[type='file']"));
		fileInput.sendKeys(absolute);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Screenshot();
	}

	public void submitPath() {

		WebElement webElement = driver.findElement(By.xpath("//button[@type='submit']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", webElement);
		// return submit;
	}

	public void Screenshot() {

		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String relativePath = "target/MultipleInsurance/screenshot_" + timestamp + ".png";
		File destinationFile = new File(System.getProperty("user.dir"), relativePath);
		System.out.println("Relative path for screenshot" + destinationFile);
		screenshotFile.renameTo(destinationFile);

	}
}
