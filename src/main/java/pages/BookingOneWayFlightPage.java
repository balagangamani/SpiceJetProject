package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificationMethod;

public class BookingOneWayFlightPage extends ProjectSpecificationMethod {

	@FindBy(xpath = "//input[@value='Select Destination']")
	WebElement arrivalCity;

	@FindBy(xpath = "//div[text()='Departure Date']")
	WebElement depDate;

	@FindBy(xpath = "(//div[text()='11'])[1]")
	WebElement departureDate;

	@FindBy(xpath = "//div[@data-testid='home-page-flight-cta']")
	WebElement searchFlightsButton;

	public BookingOneWayFlightPage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	public void bookOneWayFlight(String city) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		arrivalCity.sendKeys(city);
		Thread.sleep(3000);

		wait.until(ExpectedConditions.elementToBeClickable(departureDate)).click();
		wait.until(ExpectedConditions.elementToBeClickable(searchFlightsButton)).click();

	}

}
