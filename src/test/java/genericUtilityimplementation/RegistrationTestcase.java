package genericUtilityimplementation;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import genericLibraries.AutoConstantpathh;
import genericLibraries.ExcellFileUtility;
import genericLibraries.JavaUtility;
import genericLibraries.PropertyFileUtility;
import genericLibraries.WebDriverUtility;

public class RegistrationTestcase {

	public static void main(String[] args) throws IOException {

		WebDriverUtility webdriver = new WebDriverUtility();
		JavaUtility javautility = new JavaUtility();

		PropertyFileUtility property = new PropertyFileUtility();
		property.propertyFileInitialization(AutoConstantpathh.PROPERTY_FILE_PATH);
		ExcellFileUtility excel = new ExcellFileUtility();
		excel.excelFileInitialization(AutoConstantpathh.EXCEL_FILE_PATH);

		String url = property.getDataFromPropertyFile("url");
		String time = property.getDataFromPropertyFile("timeout");
		WebDriver driver = webdriver.openBrowserAndApplication(url, Long.parseLong(time));

		WebElement logo = driver.findElement(By.xpath("\"//div[@class='header-logo']\""));

		if (logo.isDisplayed()) {
			System.out.println("pass: Home page displayed");
		} else {
			System.out.println("Fail: Home page not found");
		}

		driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();

		String Registerpageverify = driver.findElement(By.xpath("//div[@class=\"page-title\"]")).getText();
		if (Registerpageverify.contains("Register")) {
			System.out.println("Pass: Register page is displayed");
		} else {
			System.out.println("Fail: Register page not found");
		}

		Map<String, String> map = excel.fetchMultipleDataBasedOnKeyFromExcel("DemoTestData", "Register");

		driver.findElement(By.xpath("//input[@value='F']")).click();
		String firstname = map.get("FirstName") + javautility.generateRandomNumber(100);
		driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys(firstname);

		String lastname = map.get("LastName");
		driver.findElement(By.xpath("//input[@name='LastName']")).sendKeys(lastname);

		String emailaddress = map.get("Email");
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(emailaddress);

		String password = map.get("Password");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(password);
		String confirmpassword = map.get("Confirm Password");
		driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys(confirmpassword);
		driver.findElement(By.xpath("//input[@value='Register']")).click();

		String Registrationcompleted = driver
				.findElement(By.xpath("//div[@class=\"page registration-result-page\"]")).getText();
		if (Registrationcompleted.contains("Your registration completed")) {
			System.out.println("Pass: Registatoin result page displayed");
		} else {
			System.out.println("Fail: Registatoin result page not displayed");
		}

		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		String useraccountpage = driver.findElement(By.xpath("//a[@class='account']")).getText();
		if (useraccountpage.contains("com")) {
			System.out.println("Pass: user register successully and Account page is displayed");
		} else {
			System.out.println("Fail: User Account page not found");
		}
		driver.findElement(By.xpath("//a[contains(text(),'Log out')]")).click();
		System.out.println("User logout successfully");
		driver.quit();
	}

}
