package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.ProjectSpecificationMethod;
import pages.HomePage;
import pages.LoginPage;

public class TC003_LoginWithEmail extends ProjectSpecificationMethod {

	@BeforeTest
	public void setup() {
		testName = "TC003_LoginWithEmail";
		testDescription = "Logging in to the SpiceJet application with email";
		testCategory = "Regression";
		testAuthor = "Bala Gangamani";
		sheetName = "Login";
	}

	@Test(dataProvider = "getFromExcel", priority = 3)
	public void tc_03_loginToSpiceJetApp(String email, String password) throws Exception {

		HomePage hp = new HomePage(driver);
		hp.goToLogin(); // You'll need to implement this method

		// Perform login
		LoginPage loginPage = new LoginPage(driver);
		loginPage.Login(email, password);

		SoftAssert softAssert = new SoftAssert();

		softAssert.assertAll();

	}
}
