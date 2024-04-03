package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.ProjectSpecificationMethod;
import pages.HomePage;

public class TC007_ValidateFieldsOnBookingPage extends ProjectSpecificationMethod {

	@BeforeTest
	public void setup() {
		testName = "TC007_ValidateFieldsOnBookingPage";
		testDescription = "Validating fields on Booking page";
		testCategory = "Regression";
		testAuthor = "Bala Gangamani";

	}

	@Test(priority = 7)
	public void tc_07_validateFields() {
		HomePage hp = new HomePage(driver);
		hp.goToCheckIn();
		hp.goToFlightstatus();
		hp.goTomanageBooking();
		hp.flights();

		SoftAssert softAssert = new SoftAssert();

		softAssert.assertAll();

	}

}
