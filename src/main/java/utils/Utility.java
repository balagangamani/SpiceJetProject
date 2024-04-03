package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Utility {

	public static WebDriver driver;
	public String sheetName;
	public static ExtentReports extent;
	public static ExtentTest test;
	public String testName;
	public String testDescription;
	public String testCategory;
	public String testAuthor;

	public static String readProperty(String key) throws Exception {
		String projectPath = "E:\\EclipseClass\\SpiceJetProject\\src\\main\\\\resources\\";
		File file = new File("E:\\EclipseClass\\SpiceJetProject\\src\\main\\resources\\SpiceJetData.properties");
		try (FileInputStream fileInput = new FileInputStream(file)) {
			Properties prop = new Properties();
			prop.load(fileInput);
			return prop.getProperty(key); // Directly use getProperty instead of get().toString()
		}

	}

	public static void launchBrowser(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			driver = new ChromeDriver(new ChromeOptions().addArguments("--headless"));
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			driver = new FirefoxDriver(new FirefoxOptions().addArguments("--headless"));
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public static void waitExplicit(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void waitExplicitUntillTitle(String titleToWait) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.titleIs(titleToWait));
	}

	public static void waitImplicit() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
	}

	public static void getApplication(String url) {
		driver.get(url);
	}

	public void type(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	public void clickOn(WebElement element) {
		waitExplicit(element);
		element.click();
	}

	public static String getPageTitle() {
		waitExplicitUntillTitle(driver.getTitle());
		return driver.getTitle();
	}

	public static String extractText(WebElement element) {
		return element.getText();
	}

	public static int getResponseCode(String url) throws Exception, Exception {
		URL link = new URL(url);
		HttpURLConnection connect = (HttpURLConnection) link.openConnection();
		// connect.setRequestMethod("Head");
		// connect.connect();
		int responseCode = connect.getResponseCode();
		return responseCode;
	}

	public static Object[][] dataReader(String sheetName, String excelFilePath) throws IOException {
		try (FileInputStream fis = new FileInputStream(new File(excelFilePath));
				XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
			XSSFSheet sheet = workbook.getSheet(sheetName);
			int rows = sheet.getPhysicalNumberOfRows();
			int columns = sheet.getRow(0).getPhysicalNumberOfCells();
			Object[][] data = new Object[rows][columns];

			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < columns; j++) {
					data[i][j] = sheet.getRow(i).getCell(j).toString();

				}

			}
			// Close the FileInputStream
			return data;

		}

	}

	public static void selectFromDropDown(WebElement title, String visibleText) {
		Select select = new Select(title);
		select.selectByVisibleText(visibleText);
	}

	public static void titleAssertion(String expTitle) {
		Assert.assertEquals(getPageTitle(), expTitle);
	}

	public static void jsScrollUntillElement(WebElement element) {
		waitExplicit(element);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public static void jsClickOn(WebElement element) {
		waitExplicit(element);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

	public static int screenShot(String testName) throws Exception {
		int ranNum = (int) (Math.random() * 9999999 + 1000000);
		Thread.sleep(3000);
		String projectPath = "E:\\EclipseClass\\SpiceJetProject";
		FileUtils.copyFile(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE),
				new File(projectPath + "/Screenshot/" + testName + ranNum + ".png"));
		return ranNum;
	}

	public static void softAssert(String actResult, String expResult) {
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actResult, expResult);
	}

	public void reportStep(String stepDetails, String stepStatus, String testName) throws Exception {
		int ranNum = screenShot(testName);
		String projectPath = "E:\\EclipseClass\\SpiceJetProject";
		if (stepStatus.equalsIgnoreCase("pass")) {
			test.pass(stepDetails, MediaEntityBuilder
					.createScreenCaptureFromPath(projectPath + "/Screenshot/" + testName + ranNum + ".png").build());
		} else if (stepStatus.equalsIgnoreCase("fail")) {
			test.fail(stepDetails, MediaEntityBuilder
					.createScreenCaptureFromPath(projectPath + "/Screenshot/" + testName + ranNum + ".png").build());
			throw new RuntimeException("See extent report for more details");
		}
	}

}
