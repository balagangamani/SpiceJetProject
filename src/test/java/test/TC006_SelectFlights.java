package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.ProjectSpecificationMethod;
import pages.BookingOneWayFlightPage;
import pages.SelectFlightsPage;

public class TC006_SelectFlights extends ProjectSpecificationMethod {

	@BeforeTest
	public void setup() {
		testName = "TC006_SelectFlights";
		testDescription = "Select Departure Flight";
		testCategory = "Regression";
		testAuthor = "Bala Gangamani";

	}

	@Test(priority = 6)
	public void tc_06_selectFlights() throws Exception {

		// Perform flight search and booking
		BookingOneWayFlightPage flightbook = new BookingOneWayFlightPage(driver);
		flightbook.bookOneWayFlight("Chennai");
		SelectFlightsPage flightsel = new SelectFlightsPage(driver);
		flightsel.selectDepartureFlight();

		SoftAssert softAssert = new SoftAssert();

		softAssert.assertAll();

	}
}
