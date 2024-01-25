package objectRepository.insurance;

import static variables.insurance.UserVariables.CARD_NUMBER;
import static variables.insurance.UserVariables.DIRECT_DEBIT_NUMBER;
import static variables.insurance.UserVariables.EXPIRY;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MysingleInsurancePolicyPage {

	WebDriver driver;

	@FindBy(xpath = "(//button[@type='button'])[1]")
	WebElement language;

	@FindBy(xpath = "//input[@id='login_username']")
	WebElement user_name;

	@FindBy(xpath = "//input[@id='login_password']")
	WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement submit;

	@FindBy(xpath = "//span[contains(text(),'New')]")
	WebElement New;

	@FindBy(xpath = "//input[@name='country-select']")
	WebElement Country;

	@FindBy(xpath = "//span[contains(text(),'Austria')]")
	WebElement Country_Selection;

	@FindBy(xpath = "//span[contains(text(),'Englisch')]")
	WebElement English;

	@FindBy(xpath = "//div[@id=\"country-select\"]")
	WebElement insurancecountrydd;

	@FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-item css-1wxaqej']//div//label")
	List<WebElement> namedd;

	@FindBy(xpath = "//input[@id=\"input-createCertificate_serialNumber\"]")
	WebElement serialnumber;

	@FindBy(xpath = "//input[@id=\"input-createCertificate_deviceName\"]")
	WebElement devicename;

	@FindBy(xpath = "//*[@id=\"input-createCertificate_orderNumber\"]")
	WebElement ordernumber;

	@FindBy(xpath = "//input[@value='male']")
	WebElement male;

	@FindBy(xpath = "//span[contains(text(),'Next')]")
	WebElement Next;

	@FindBy(xpath = "//*[@id=\"input-createCertificate_firstName\"]")
	WebElement firstname;

	@FindBy(xpath = "//*[@id=\"input-createCertificate_lastName\"]")
	WebElement lastname;

	@FindBy(xpath = "//*[@id=\"input-createCertificate_email\"]")
	WebElement email;

	@FindBy(xpath = "//*[@id=\"input-createCertificate_streetName\"]")
	WebElement streetname;

	@FindBy(xpath = "//*[@id=\"input-createCertificate_streetNumber\"]")
	WebElement housenumber;

	@FindBy(xpath = "//*[@id=\"input-createCertificate_zip\"]")
	WebElement postalcode;

	@FindBy(xpath = "//*[@id=\"input-createCertificate_city\"]")
	WebElement city;

	@FindBy(xpath = "//*[@id=\"input-createCertificate_country\"]")
	WebElement countrycode;

	@FindBy(xpath = "//div[@class='MuiFormControl-root css-13sljp9']//label//input")
	List<WebElement> checkboxes;

	@FindBy(xpath = "//span[contains(text(),'Create insurance')]")
	WebElement createinsurance;

	@FindBy(xpath = "//div[@class='MuiBox-root jss42 jss29']//p")
	WebElement cardselection;

	@FindBy(xpath = "//div[@class='MuiGrid-root jss21 MuiGrid-item MuiGrid-grid-xs-12']//button//span")
	WebElement continuetopaymentbtn;

	@FindBy(xpath = "//input[@name='cardnumber']")
	WebElement cardnumber;

	@FindBy(xpath = "//input[@placeholder='MM/JJ']")
	WebElement expiry;

	@FindBy(xpath = "//div[@class='MuiGrid-root jss97 MuiGrid-item MuiGrid-grid-xs-12']//button//span")
	WebElement orderbtn;

	@FindBy(xpath = "//iframe[@name='__privateStripeFrame4836']")
	WebElement frame;

	@FindBy(xpath = "(//span[@class='MuiTypography-root MuiFormControlLabel-label MuiTypography-body1']//div//div//p)[3]")
	WebElement sepadirectdebit;

	@FindBy(xpath = "(//input[@class='MuiInputBase-input MuiFilledInput-input'])[1]")
	WebElement sepadirectAccountname;

	@FindBy(xpath = "(//input[@class='MuiInputBase-input MuiFilledInput-input'])[2]")
	WebElement sepadirectEmail;

	@FindBy(xpath = "//span[@class='InputContainer']//input[@name='iban']")
	WebElement IBANnumber;

	@FindBy(xpath = "//input[@class='jss124']")
	WebElement IBANCheckbox;

	public MysingleInsurancePolicyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement usernameOptionPath() {
		return user_name;
	}

	public WebElement passwordOptionPath() {
		return password;
	}

	public void submitPath() {

		WebElement webElement = driver.findElement(By.xpath("//button[@type='submit']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", webElement);
		// return submit;
	}

	public WebElement NewPath() {
		return New;
	}

	public WebElement CountryPath() {
		return Country;
	}

	public WebElement Country_SelectionPath() {
		return Country_Selection;
	}

	public WebElement LanguageOptionPath() {
		return language;
	}

	public WebElement EnglishOptionPath() {
		return English;
	}

	public WebElement insuranceddPath() {
		return insurancecountrydd;
	}

	public WebElement CountryOptionddPath() {
		return Country_Selection;
	}

	public void Namedd() {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		for (WebElement container : namedd) {
			System.out.println("Drop down text:" + container.getText());
			String text = container.getText();
			System.out.println("text which is extracted from element:" + text);
			String xpathExpression = "//span[contains(text(),'" + text + "')]";

			WebElement ddselect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));

			Actions actions = new Actions(driver);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			actions.moveToElement(ddselect).click().perform();

			WebElement ul = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("(//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9'])[2]")));

			List<WebElement> options = ul.findElements(By.tagName("li"));

			if (!options.isEmpty()) {
				options.get(0).click();
			}
		}

	}

	public WebElement serialNumber() {
		return serialnumber;
	}

	public WebElement deviceName() {
		return devicename;
	}

	public WebElement orderNumber() {
		Screenshot();
		return ordernumber;
	}

	public WebElement next() {
		return Next;
	}

	public WebElement Gender() {
		return male;
	}

	public WebElement FirstName() {
		return firstname;
	}

	public WebElement LastName() {
		return lastname;
	}

	public WebElement Email() {
		return email;
	}

	public WebElement Streetname() {
		return streetname;
	}

	public WebElement Housenumber() {
		return housenumber;
	}

	public WebElement Postalcode() {
		return postalcode;
	}

	public WebElement Countrycode() {
		return countrycode;
	}

	public WebElement City() {
		Screenshot();
		return city;
	}

	public void checkboxSelection() {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)");
		for (WebElement checkbox : checkboxes) {
			checkbox.click();
		}

	}

	public WebElement Create_insurance() {
		return createinsurance;
	}

	public WebElement Card_selection() {
		return cardselection;
	}

	public WebElement Continue_to_Payment() {
		return continuetopaymentbtn;
	}

	public void Card_Number() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		WebElement frametitle = driver
				.findElement(By.xpath("//iframe[@title='Sicherer Eingaberahmen für Kartenzahlungen']"));
		driver.switchTo().frame(frametitle);

		cardnumber.sendKeys(CARD_NUMBER);

	}

	public WebElement Expiry() {
		return expiry;
	}

	public WebElement Orderbtn() {
		driver.switchTo().defaultContent();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		//Screenshot();
		return orderbtn;
	}

	public WebElement SEPA() {

		return sepadirectdebit;

	}

	public WebElement SEPAAccountName() {

		return sepadirectAccountname;

	}

	public WebElement SEPAEmail() {

		return sepadirectEmail;

	}

	public void SEPAIBANnumber() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		WebElement IBANframe = driver.findElement(By.xpath("//iframe[@title='Sicherer Eingaberahmen für IBAN']"));
		driver.switchTo().frame(IBANframe);
		IBANnumber.sendKeys(DIRECT_DEBIT_NUMBER);

	}

	public void SEPAIBANCheckbox() {
		driver.switchTo().defaultContent();

		WebDriverWait wait = new WebDriverWait(driver, 20);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//h2[contains(text(),'Hiermit bestätige ich das SEPA-Lastschriftmandat')]")));
		System.out.println("checkbox method");
		ele.click();

	}

	public void SEPAIBANproceedpayment() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement IBANproceedpayment1 = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/div[2]/button[1]")));
		System.out.println("proceed payment method");
		Screenshot();
		IBANproceedpayment1.click();

	}

	public void Screenshot() {

		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String relativePath = "target/SingleInsurance/screenshot_" + timestamp + ".png";
		File destinationFile = new File(System.getProperty("user.dir"), relativePath);
		System.out.println("Relative path for screenshot" + destinationFile);
		screenshotFile.renameTo(destinationFile);

	}
}
