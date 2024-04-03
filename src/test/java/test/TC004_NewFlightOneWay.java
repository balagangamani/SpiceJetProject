package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.ProjectSpecificationMethod;
import pages.BookingOneWayFlightPage;

public class TC004_NewFlightOneWay extends ProjectSpecificationMethod {

	@DataProvider(name = "cityDataProvider")
	public Object[][] createData() {
		return new Object[][] { { "Chennai" },

		};
	}

	@BeforeTest
	public void setup() {
		testName = "TC004_NewFlightOneWay";
		testDescription = "Booking a new one-way flight in the SpiceJet application";
		testCategory = "Regression";
		testAuthor = "Bala Gangamani";
		// sheetName = "OneWayFlight";
	}

	@Test(dataProvider = "cityDataProvider", priority = 4)
	public void tc_04_bookOneWayFlight(String city) throws Exception {

		// Perform flight search and booking
		BookingOneWayFlightPage flightbook = new BookingOneWayFlightPage(driver);
		flightbook.bookOneWayFlight(city);

		// Verify booking success
		SoftAssert softAssert = new SoftAssert();

		softAssert.assertAll();
	}
}
