package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificationMethod;

public class BookingRoundTripPage extends ProjectSpecificationMethod {

	// Assuming SpiceJet has radio buttons to select trip type
	@FindBy(xpath = "//div[text()='round trip']")
	WebElement roundTripRadioButton;

	@FindBy(xpath = "//input[@value='Select Destination']")
	WebElement arrivalCity;

	@FindBy(xpath = "//div[text()='Return Date']")
	WebElement returnDate; // This is only enabled for round trips

	@FindBy(xpath = "(//div[text()='11'])[1]")
	WebElement departureDate;

	@FindBy(xpath = "(//div[text()='14'])[2]")
	WebElement retDateElement;

	@FindBy(xpath = "//div[@data-testid='home-page-flight-cta']")
	WebElement searchFlightsButton;

	public BookingRoundTripPage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	public void bookRoundTripFlight(String to, String depDate, String returnDate) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(roundTripRadioButton)).click();
		arrivalCity.sendKeys(to);
		wait.until(ExpectedConditions.elementToBeClickable(departureDate)).click();
		wait.until(ExpectedConditions.elementToBeClickable(retDateElement)).click();

		wait.until(ExpectedConditions.elementToBeClickable(searchFlightsButton)).click();

	}

}
