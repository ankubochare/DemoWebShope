package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registerpage {

	@FindBy(xpath = "//div[@class=\"page-title\"]")
	private WebElement Registerverification;

	@FindBy(xpath = "//input[@value='F']")
	private WebElement Genderselection;

	@FindBy(xpath = "//input[@name='FirstName']")
	private WebElement firstNametext;

	@FindBy(xpath = "//input[@name='LastName']")
	private WebElement lastNametext;

	@FindBy(xpath = "//input[@id='Email']")
	private WebElement Emailaddresstext;

	@FindBy(xpath = "//input[@id='Password']")
	private WebElement passtext;

	@FindBy(xpath = "//input[@id='ConfirmPassword']")
	private WebElement conpasswordtext;

	@FindBy(xpath = "//input[@value='Register']")
	private WebElement rig;

	public Registerpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public String getRegisterpageVerification() {
		return Registerverification.getText();
	}

	public void fillgender() {
		Genderselection.click();
	}

	public void setFirstName(String firstname) {
		firstNametext.sendKeys(firstname);
	}

	public void setLastName(String lastname) {
		lastNametext.sendKeys(lastname);
	}

	public void setEmailaddress(String emailaddress) {
		Emailaddresstext.sendKeys(emailaddress);
	}

	public void setPass(String password) {
		passtext.sendKeys(password);
	}

	public void setConpassword(String confirmpassword) {
		conpasswordtext.sendKeys(confirmpassword);
	}

	public void Registerclick() {
		rig.click();
	}

}
