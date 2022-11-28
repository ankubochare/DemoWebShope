package TestNGImplimentation;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;

import genericLibraries.BaseClass;

public class RegistrationTestcase extends BaseClass {

	@Test
	public void Registrationtestcase() throws IOException {

//		WebDriverUtility webdriver = new WebDriverUtility();
//		JavaUtility javautility = new JavaUtility();
//
//		PropertyFileUtility property = new PropertyFileUtility();
//		property.propertyFileInitialization(AutoConstantpathh.PROPERTY_FILE_PATH);
//		ExcellFileUtility excel = new ExcellFileUtility();
//		excel.excelFileInitialization(AutoConstantpathh.EXCEL_FILE_PATH);
//
//		String url = property.getDataFromPropertyFile("url");
//		long time = Long.parseLong(property.getDataFromPropertyFile("timeouts"));
//
//		WebDriver driver = webdriver.openBrowserAndApplication(url, time);
//
//		Landingpage landingpage = new Landingpage(driver);
//		Registerpage registerpage = new Registerpage(driver);
//		RegisterConfrmationpage registerconfrmationpage = new RegisterConfrmationpage(driver);
//		Useraccountpage useraccountpage = new Useraccountpage(driver);
//		LogoutPage logoutpage = new LogoutPage(driver);

//		if (landingpage.getLogo().isDisplayed()) {
//			System.out.println("pass: Home page displayed");
//		} else {
//			System.out.println("Fail: Home page not found");
//		}

		landingpage.registerationpage();

		// driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();

		// String Registerpageverify =
		// driver.findElement(By.xpath("//div[@class=\"page-title\"]")).getText();
		if (registerpage.getRegisterpageVerification().contains("Register")) {
			System.out.println("Pass: Register page is displayed");
		} else {
			System.out.println("Fail: Register page not found");
		}

		Map<String, String> map = excel.fetchMultipleDataBasedOnKeyFromExcel("DemoTestData", "Register");

		registerpage.fillgender();

		// driver.findElement(By.xpath("//input[@value='F']")).click();
		String firstname = map.get("FirstName") + java.generateRandomNumber(100);
		registerpage.setFirstName(firstname);
		// driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys(firstname);

		String lastname = map.get("LastName");
		registerpage.setLastName(lastname);
		// driver.findElement(By.xpath("//input[@name='LastName']")).sendKeys(lastname);

		String emailaddress = firstname + lastname + "@gmai.com";

		registerpage.setEmailaddress(emailaddress);
		// driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(emailaddress);

		String password = map.get("Password");
		registerpage.setPass(password);
		// driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(password);
		String confirmpassword = map.get("Confirmpassword");
		registerpage.setConpassword(confirmpassword);

		// driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys(confirmpassword);
		registerpage.Registerclick();
		// driver.findElement(By.xpath("//input[@value='Register']")).click();

		// String Registrationcompleted =
		// driver.findElement(By.xpath("//div[@class=\"page
		// registration-result-page\"]")).getText();
		if (registerconfrmationpage.getRegisterresultpage().contains("Your registration completed")) {
			System.out.println("Pass: Registatoin result page displayed");
		} else {
			System.out.println("Fail: Registatoin result page not displayed");
		}

		registerconfrmationpage.clickcontinus();
		// driver.findElement(By.xpath("//input[@value='Continue']")).click();
		// String useraccountpage1 =
		// driver.findElement(By.xpath("//a[@class='account']")).getText();

		if (useraccountpage.getuseraccoutpage().contains("com")) {
			System.out.println("Pass: user register successully and Account page is displayed");
		} else {
			System.out.println("Fail: User Account page not found");
		}

		// logoutpage.ClickonLogout();
		// driver.findElement(By.xpath("//a[contains(text(),'Log out')]")).click();
		// System.out.println("User logout successfully");

//		excel.closeExcel();
//		webdriver.closeBrowser();
		// driver.quit();
	}

}
