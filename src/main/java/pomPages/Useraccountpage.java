package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Useraccountpage {

	@FindBy(xpath = "//a[@class='account']")
	private WebElement useraccountpageverification;

	public Useraccountpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public String getuseraccoutpage() {
		return useraccountpageverification.getText();
	}
}
