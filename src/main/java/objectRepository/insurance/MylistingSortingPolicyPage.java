package objectRepository.insurance;

import static variables.insurance.UserVariables.EMAIL;
import java.util.Date;
import static variables.insurance.UserVariables.POLICY_NUMBER;

import java.io.File;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.OutputType;

//import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import java.text.SimpleDateFormat;

public class MylistingSortingPolicyPage {

	WebDriver driver;
	@FindBy(xpath = "//span[contains(text(),'List')]")
	WebElement listoptionheader;

	@FindBy(xpath = "//label[contains(text(),'Search for...')]")
	WebElement searchfield;

	@FindBy(xpath = "//li[@data-value='policy_number']")
	WebElement policynumber;

	@FindBy(xpath = "//li[@data-value='email']")
	WebElement email;

	@FindBy(xpath = "//li[@data-value='date_start']")
	WebElement newerthan;

	@FindBy(xpath = "//li[@data-value='date_end']")
	WebElement olderthan;

	@FindBy(xpath = "//input[@type='text']")
	WebElement searchinputenter;

	@FindBy(xpath = "//input[@type='email']")
	WebElement emailinputenter;

	public MylistingSortingPolicyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement listOptionHeaderPath() {
		return listoptionheader;
	}

	public void SearchField() {

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		Actions actions = new Actions(driver);
		try {
			actions.click(searchfield).perform();

		} catch (StaleElementReferenceException e) {
			actions.click(searchfield).perform();

		}

	}

	public WebElement Policy_Number() {
		return policynumber;
		
	}

	public void SearchInput() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(searchinputenter));
		searchinputenter.sendKeys(POLICY_NUMBER);
		EnterKey();
		Screenshot();
		
	}

	public void Email() {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(email)).click();
		wait.until(ExpectedConditions.elementToBeClickable(emailinputenter));
		emailinputenter.sendKeys(EMAIL);
		emailinputenter.sendKeys(Keys.RETURN);
		Screenshot();
	}

	public void NewSort() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(newerthan)).click();

		WebElement date = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='date']")));
		date.click();
		Screenshot();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		WebElement hiddenElement = (WebElement) ((JavascriptExecutor) driver)
				.executeScript("return document.querySelector(\"[data-testid='ClearIcon']\");");

		if (hiddenElement != null) {
			hiddenElement.click();
		} else {
			System.out.println("Hidden element not found.");
		}

		
	}

	public void OldSort() {

		olderthan.click();
		Screenshot();
		WebElement hiddenElement = (WebElement) ((JavascriptExecutor) driver)
				.executeScript("return document.querySelector(\"[data-testid='ClearIcon']\");");

		if (hiddenElement != null) {
			hiddenElement.click();
		} else {
			System.out.println("Hidden element not found.");
		}

	}

	public void EnterKey() {
		WebElement input = driver.findElement(By.xpath("//input[@id=':rp:']"));
		input.sendKeys(Keys.RETURN);

	}

	public void Screenshot() {

		 File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

	        // Generate a timestamp for uniqueness
	        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

	        // Specify the relative path for the screenshot with a unique name
	        String relativePath = "target/ListingSorting/screenshot_" + timestamp + ".png";
	        File destinationFile = new File(System.getProperty("user.dir"), relativePath);
	        System.out.println("Relative path for screenshot"+destinationFile);
	        // Save the screenshot to the specified location
	        screenshotFile.renameTo(destinationFile);
		
	}

	public void cancelbtn() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		WebElement hiddenElement = (WebElement) ((JavascriptExecutor) driver)
				.executeScript("return document.querySelector(\"[data-testid='CancelIcon']\");");

		if (hiddenElement != null) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			hiddenElement.click();

		} else {
			System.out.println("Hidden element not found.");
		}

	}

}
