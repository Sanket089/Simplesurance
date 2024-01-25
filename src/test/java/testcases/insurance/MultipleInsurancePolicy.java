package testcases.insurance;

import static variables.insurance.UserVariables.USER_EMAIL;
import static variables.insurance.UserVariables.USER_PASSWORD;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import objectRepository.insurance.MymultipleInsurancePolicyPage;
import objectRepository.insurance.MysingleInsurancePolicyPage;

public class MultipleInsurancePolicy {

	@Test
	public void MultipleInsurance() {

		BrowserSetting bs = new BrowserSetting();

		WebDriver driver = bs.BrowserSettings();

		logIn(driver);
		importFile(driver);
		
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
	
	private void importFile(WebDriver driver) {
		
		MymultipleInsurancePolicyPage mip =new MymultipleInsurancePolicyPage(driver);
		mip.importOptionHeaderPath().click();
		mip.uploadfileOptionPath();
		
		
	}
	
}