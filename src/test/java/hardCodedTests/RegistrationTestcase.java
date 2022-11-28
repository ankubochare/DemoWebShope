package hardCodedTests;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegistrationTestcase {

	public static void main(String[] args) {

		Random random = new Random();
		int randomNum = random.nextInt(100);
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement logo = driver.findElement(By.xpath("//div[@class='header-logo']"));
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

		driver.findElement(By.xpath("//input[@value='F']")).click();
		String firstname = "ankita" + randomNum;
		driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys(firstname);

		String lastname = "bochare";
		driver.findElement(By.xpath("//input[@name='LastName']")).sendKeys("lastname");

		String emailaddress = firstname + lastname + "@gmail.com";
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(emailaddress);

		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("123456");
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
