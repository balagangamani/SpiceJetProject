package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificationMethod;

public class SelectFlightsPage extends ProjectSpecificationMethod {

	@FindBy(xpath = "//div[@data-testid='home-page-flight-cta']")
	WebElement searchFlightsButton;

	@FindBy(xpath = "//div[text()='SG 616']")
	private WebElement selectDepartureFlight;

	@FindBy(xpath = "//div[@data-testid='continue-search-page-cta']")
	private WebElement Continuebutton;

	@FindBy(xpath = "(//div[contains(@class, 'r-1wtj0ep')])[2]")
	WebElement titlename;

	@FindBy(xpath = "//div[@data-testid='first-inputbox-contact-details']")
	WebElement fname;

	@FindBy(xpath = "//div[@data-testid='last-inputbox-contact-details']")
	WebElement lname;

	@FindBy(xpath = "//div[@data-testid='contact-number-input-box']")
	WebElement phone;

	@FindBy(xpath = "//div[@data-testid='emailAddress-inputbox-contact-details']")
	WebElement mail;

	@FindBy(xpath = "//div[text()='India']")
	WebElement country;

	@FindBy(xpath = "//div[@data-testid='city-inputbox-contact-details']")
	WebElement citysel;

	@FindBy(xpath = "//div[text()='Retain my details for the next visit.']")
	WebElement checkbox;

	@FindBy(xpath = "//div[text()='I am flying as the primary passenger']")
	WebElement primary;

	@FindBy(xpath = "//div[@data-testid='traveller-info-continue-cta']")
	WebElement continuepay;

	private WebDriverWait wait;

	public void selectTitle(String title) {
		// Click the title dropdown to open it
		titlename.click();

	}

	public SelectFlightsPage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void selectDepartureFlight() throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(selectDepartureFlight)).isSelected();

		// Continue to the payment section
		Continuebutton.click();

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		selectTitle("Mr");

		wait.until(ExpectedConditions.visibilityOf(fname)).sendKeys("PAVAN");

		lname.sendKeys("KUMAR");
		phone.sendKeys("9441349527");
		mail.sendKeys("pavan789@gmail.com");

		citysel.sendKeys("Hyderabad");

		WebElement checkboxElement = wait.until(ExpectedConditions.elementToBeClickable(checkbox));
		if (!checkboxElement.isSelected()) {
			checkboxElement.click();
		}
		WebElement primaryElement = wait.until(ExpectedConditions.elementToBeClickable(primary));
		if (!primaryElement.isSelected()) {
			primaryElement.click();
		}
		// continuepay.click();
		wait.until(ExpectedConditions.elementToBeClickable(continuepay)).click();

	}

}
