package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import base.ProjectSpecificationMethod;
import pages.HomePage;

public class TC001_NavigatingToSpiceJet extends ProjectSpecificationMethod {

	@BeforeTest
	public void setup() {
		testName = "TC001_NavigatingToSpiceJet";
		testDescription = "Navigating to the SpiceJet website";
		testCategory = "Regression";
		testAuthor = "Bala Gangamani";
	}

	@Test(priority = 1)
	public void tc_01_navigateToSpiceJetHomePage() throws Exception {
		HomePage hp = new HomePage(driver);
		hp.navigateToSpiceJet(); // Navigate to SpiceJet homepage

		SoftAssert softAssert = new SoftAssert();

		softAssert.assertAll();

	}
}
