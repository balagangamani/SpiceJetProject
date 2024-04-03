package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.ProjectSpecificationMethod;
import pages.HomePage;
import pages.SignUpPage;

public class TC002_SignUp extends ProjectSpecificationMethod {

	@BeforeTest
	public void setup() {
		testName = "TC002_SignUp";
		testDescription = "Signing up to the SpiceJet application";
		testCategory = "Regression";
		testAuthor = "Bala Gangamani";
		sheetName = "Signup1";
	}

	@Test(dataProvider = "getFromExcel", priority = 2)
	public void tc_02_signUpToSpiceJetApp(String title, String firstName, String lastName, String country, String dob,
			String mobile, String email, String password, String confirmPassword) throws Exception {

		// Assuming HomePage can navigate us to the sign-up page
		HomePage hp = new HomePage(driver);
		hp.goToSignup(); // You'll need to implement this method

		// Perform sign-up
		SignUpPage signUpPage = new SignUpPage(driver);
		signUpPage.SignUp(title, firstName, lastName, country, dob, mobile, email, password, confirmPassword);

		SoftAssert softAssert = new SoftAssert();

		softAssert.assertAll();

	}
}
