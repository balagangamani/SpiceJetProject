package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificationMethod;

public class SignUpPage extends ProjectSpecificationMethod {

	@FindBy(xpath = "//select[contains(@class, 'form-control form-select ')]") // Locator for the Title dropdown
	private WebElement titleDropdown;

	@FindBy(id = "first_name")
	private WebElement firstNameField;

	@FindBy(id = "last_name")
	private WebElement lastNameField;

	@FindBy(xpath = "//select[@class='form-control form-select']")
	private WebElement countryDropdown;

	@FindBy(id = "dobDate")
	private WebElement dobField;

	@FindBy(xpath = "//input[@type='tel']")
	private WebElement mobileNumberField;

	@FindBy(id = "email_id")
	private WebElement emailField;

	@FindBy(id = "new-password")
	private WebElement passwordField;

	@FindBy(id = "c-password")
	private WebElement confirmPasswordField;

	@FindBy(xpath = "//label[@class='form-check-label font-14']")
	private WebElement termsCheckbox;

	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	private WebElement submitButton;

	public SignUpPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void SignUp(String title, String firstName, String lastName, String country, String dob, String mobile,
			String email, String password, String confirmPassword) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(titleDropdown));
		new Select(titleDropdown).selectByVisibleText(title);
		firstNameField.sendKeys(firstName);
		lastNameField.sendKeys(lastName);
		wait.until(ExpectedConditions.elementToBeClickable(countryDropdown));
		new Select(countryDropdown).selectByVisibleText(country);
		dobField.sendKeys(dob); // Ensure the format matches the input field requirements
		mobileNumberField.sendKeys(mobile);
		emailField.sendKeys(email);
		passwordField.sendKeys(password);
		confirmPasswordField.sendKeys(confirmPassword);
		if (!termsCheckbox.isSelected()) {
			termsCheckbox.click();
		}
		submitButton.click();

	}

}