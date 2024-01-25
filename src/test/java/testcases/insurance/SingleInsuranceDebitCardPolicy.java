package testcases.insurance;

import static variables.insurance.UserVariables.CARD_NUMBER;
import static variables.insurance.UserVariables.CITY;
import static variables.insurance.UserVariables.COUNTRY;
import static variables.insurance.UserVariables.DEVICE_NAME;
import static variables.insurance.UserVariables.DIRECT_DEBIT_NUMBER;
import static variables.insurance.UserVariables.EMAIL;
import static variables.insurance.UserVariables.EXPIRY;
import static variables.insurance.UserVariables.FIRST_NAME;
import static variables.insurance.UserVariables.HOUSE_NUMBER;
import static variables.insurance.UserVariables.LAST_NAME;
import static variables.insurance.UserVariables.ORDER_NUMBER;
import static variables.insurance.UserVariables.POSTAL_CODE;
import static variables.insurance.UserVariables.SERIAL_NUMBER;
import static variables.insurance.UserVariables.STREET;
import static variables.insurance.UserVariables.USER_EMAIL;
import static variables.insurance.UserVariables.USER_PASSWORD;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import objectRepository.insurance.MysingleInsurancePolicyPage;

public class SingleInsuranceDebitCardPolicy {

	@Test
	public void Insurance() {

		BrowserSetting bs = new BrowserSetting();

		WebDriver driver = bs.BrowserSettings();

		logIn(driver);
		singleInsuranceCard(driver);

		driver.close();

	}

	private void logIn(WebDriver driver) {
		// log in

		MysingleInsurancePolicyPage sip = new MysingleInsurancePolicyPage(driver);

		sip.LanguageOptionPath().click();
		sip.EnglishOptionPath().click();
		sip.usernameOptionPath().sendKeys(USER_EMAIL);
		sip.passwordOptionPath().sendKeys(USER_PASSWORD);
		sip.submitPath();

	}

	private void singleInsuranceCard(WebDriver driver) {
		MysingleInsurancePolicyPage sip = new MysingleInsurancePolicyPage(driver);
		sip.NewPath().click();
//			sip.CountryPath().click();
//			sip.Country_SelectionPath().click();

//			sip.insuranceddPath().click();
//			sip.CountryOptionddPath().click();
		sip.Namedd();
		sip.serialNumber().sendKeys(SERIAL_NUMBER);
		sip.deviceName().sendKeys(DEVICE_NAME);
		sip.orderNumber().sendKeys(ORDER_NUMBER);
		sip.next().click();
		sip.Gender().click();
		sip.FirstName().sendKeys(FIRST_NAME);
		sip.LastName().sendKeys(LAST_NAME);
		sip.Email().sendKeys(EMAIL);
		sip.Streetname().sendKeys(STREET);
		sip.Housenumber().sendKeys(HOUSE_NUMBER);
		sip.Postalcode().sendKeys(POSTAL_CODE);
		sip.Countrycode().sendKeys(COUNTRY);
		sip.City().sendKeys(CITY);
		sip.next().click();
		sip.checkboxSelection();
		sip.Create_insurance().click();
		sip.Card_selection().click();
		sip.Continue_to_Payment().click();
		sip.Card_Number();
		// sip.Frame();
		// sip.Card_Number().sendKeys(CARD_NUMBER);
		sip.Expiry().sendKeys(EXPIRY);
		sip.Orderbtn().click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		sip.Screenshot();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
