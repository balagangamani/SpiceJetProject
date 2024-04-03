package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.ProjectSpecificationMethod;

public class HomePage extends ProjectSpecificationMethod {

	@FindBy(xpath = "//div[text()='Flights']")
	WebElement Flights;

	@FindBy(xpath = "//div[text()='check-in']")
	WebElement CheckIn;

	@FindBy(xpath = "//div[text()='flight status']")
	WebElement FlightStatus;

	@FindBy(xpath = "//div[text()='manage booking']")
	WebElement ManageBooking;

	@FindBy(xpath = "//div[text()='Signup']")
	WebElement Signup;

	@FindBy(xpath = "//div[text()='Login']")
	WebElement Login;

	@FindBy(xpath = "//div[@data-testid='home-page-flight-cta']")
	WebElement searchFlightsButton;

	@FindBy(xpath = "//div[@data-testid='continue-search-page-cta']")
	WebElement Continuebutton;

	public HomePage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	public void goToSignup() {
		clickOn(Signup);

	}

	public void goToLogin() {
		clickOn(Login);

	}

	public void flights() {
		clickOn(Flights);
	}

	public void goTosearchFlightsButton() {
		clickOn(searchFlightsButton);
	}

	public void goToContinuebutton() {
		clickOn(Continuebutton);
	}

	public void goToCheckIn() {
		clickOn(CheckIn);
	}

	public void goToFlightstatus() {
		clickOn(FlightStatus);
	}

	public void goTomanageBooking() {
		clickOn(ManageBooking);
	}

	public void navigateToSpiceJet() {
		PageFactory.initElements(driver, this);
	}

}
