package testcases.insurance;

import static variables.insurance.UserVariables.POLICY_NUMBER;
import static variables.insurance.UserVariables.USER_EMAIL;
import static variables.insurance.UserVariables.USER_PASSWORD;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import objectRepository.insurance.MylistingSortingPolicyPage;
import objectRepository.insurance.MysingleInsurancePolicyPage;

public class listingSortingPolicyPage {

	@Test
	public void listingSortInsurance() {

		BrowserSetting bs = new BrowserSetting();

		WebDriver driver = bs.BrowserSettings();

		logIn(driver);
		listingsorting(driver);
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

	private void listingsorting(WebDriver driver) {

		MylistingSortingPolicyPage lsp = new MylistingSortingPolicyPage(driver);

		//lsp.listOptionHeaderPath().click();
		lsp.SearchField();
		lsp.Policy_Number().click();
		lsp.SearchInput();
		lsp.cancelbtn();
		lsp.SearchField();
		lsp.Email();
		lsp.cancelbtn();
		lsp.SearchField();
		lsp.NewSort();
		lsp.SearchField();
		lsp.OldSort();
	}

}
