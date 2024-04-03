package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.ProjectSpecificationMethod;
import pages.BookingRoundTripPage;

public class TC005_NewFlightRoundTrip extends ProjectSpecificationMethod {

	@BeforeTest
	public void setup() {
		testName = "TC005_NewFlightRoundTrip";
		testDescription = "Booking a new round-trip flight in the SpiceJet application";
		testCategory = "Regression";
		testAuthor = "Bala Gangamani";
		sheetName = "RoundTrip";
	}

	@Test(dataProvider = "getFromExcel", priority = 5)
	public void tc_05_bookNewRoundTripFlight(String to, String depDate, String returnDate) throws Exception {

		// Perform round-trip flight search and booking
		BookingRoundTripPage flightBookingPage = new BookingRoundTripPage(driver);

		flightBookingPage.bookRoundTripFlight(to, depDate, returnDate); // Use actual data

		SoftAssert softAssert = new SoftAssert();

		softAssert.assertAll();
	}
}
