package genericLibraries;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import pomPages.Landingpage;
import pomPages.LogoutPage;
import pomPages.RegisterConfrmationpage;
import pomPages.Registerpage;
import pomPages.Useraccountpage;

public class BaseClass {
	protected ExcellFileUtility excel;
	protected PropertyFileUtility property;
	protected JavaUtility java;
	protected WebDriverUtility webdriver;
	protected WebDriver driver;
	protected Landingpage landingpage;
	protected Registerpage registerpage;
	protected RegisterConfrmationpage registerconfrmationpage;
	protected Useraccountpage useraccountpage;
	protected LogoutPage logoutpage;
	
	//@BeforeSuite 
	@BeforeTest
	
	public void testSetup() {
		 excel=new ExcellFileUtility();
		 property=new PropertyFileUtility();
		 java=new JavaUtility();
		 webdriver=new WebDriverUtility();
		 
		 property.propertyFileInitialization(AutoConstantpathh.PROPERTY_FILE_PATH);
		 excel.excelFileInitialization(AutoConstantpathh.EXCEL_FILE_PATH);
	}
	@BeforeClass
	
	public void ClassSetup() throws IOException
	{
		String url = property.getDataFromPropertyFile("url");
		String time = property.getDataFromPropertyFile("timeouts");
		long timeouts = Long.parseLong(time);
		webdriver.openBrowserAndApplication(url, timeouts);

		 landingpage=new Landingpage(driver);
			if (landingpage.getLogo().isDisplayed()) {
				System.out.println("pass: Home page displayed");
			} else {
				System.out.println("Fail: Home page not found");
			}
		 registerpage=new Registerpage(driver);
	 registerconfrmationpage=new RegisterConfrmationpage(driver);
		 useraccountpage=new Useraccountpage(driver);
		 logoutpage=new LogoutPage(driver);

	}



	@AfterClass
	public void ClassTearDown() {
		logoutpage.ClickonLogout();
		// webdriver.closeBrowser();
	}
	@AfterTest
	public void afterTestTearDown() {
		excel.closeExcel();
	}
	// @afterSuit

}
