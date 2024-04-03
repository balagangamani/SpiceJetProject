package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.ProjectSpecificationMethod;

public class LoginPage extends ProjectSpecificationMethod {

	@FindBy(xpath = "//div[contains(text(), 'Email')]")
	WebElement emailbutton;

	// Assuming the id for the email input field on the SpiceJet login page
	@FindBy(xpath = "//input[@type='email']")
	WebElement emailField;

	// Assuming the id for the password input field on the SpiceJet login page
	@FindBy(xpath = "//input[@type='password']")
	WebElement passwordField;

	// Assuming the text on the login button and updating the XPath accordingly
	@FindBy(xpath = "//div[@data-testid='login-cta']")
	WebElement logInButton;

	// Assuming there's a link to redirect users to the homepage after login failure
	// or for navigation purpose
	@FindBy(xpath = "//a[contains(text(),'Return to Home')]")
	WebElement returnToHomePageLink;

	public LoginPage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	public void Login(String email, String password) throws Exception {
		emailbutton.click();
		fillField(emailField, email);
		fillField(passwordField, password);
		logInButton.click();

	}

	private void fillField(WebElement field, String value) {
		field.clear();
		field.sendKeys(value);

	}

}
