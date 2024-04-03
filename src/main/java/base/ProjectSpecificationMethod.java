package base;

import java.io.File;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utils.Utility;

public class ProjectSpecificationMethod extends Utility {

	@BeforeSuite
	public void startReport() {
		String reportPath = "./reports/result.html";
		File reportDir = new File(reportPath).getParentFile();

		if (!reportDir.exists() && !reportDir.isDirectory()) {
			// Attempt to create the directory if it does not exist
			reportDir.mkdirs();
		}
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(reportPath);
		reporter.setAppendExisting(false);
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}

	@BeforeClass
	public void testDetails() {
		test = extent.createTest(testName, testDescription);
		test.assignCategory(testCategory);
		test.assignAuthor(testAuthor);
	}

	@BeforeMethod
	public void start() throws Exception {
		launchBrowser(readProperty("browser"));
		getApplication(readProperty("url"));
	}

	@AfterMethod
	public void close() {
		driver.close();
	}

	@DataProvider(name = "getFromExcel")
	public Object[][] excelData() throws Exception {
		// Assuming a method 'readExcelData' in Utility class that returns Object[][]
		String excelFilePath = System.getProperty("user.dir") + "/data/Book1.xlsx";
		// Assuming 'dataReader' method is static and accessible, calling it with the
		// sheet name and the Excel file path
		return dataReader(sheetName, excelFilePath);

	}

	@AfterSuite
	public void endReport() {
		extent.flush();
	}

}
