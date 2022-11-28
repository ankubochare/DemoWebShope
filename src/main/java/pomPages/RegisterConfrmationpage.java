package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterConfrmationpage {

	@FindBy(xpath = "//div[@class='page-title']")
	private WebElement rigresult;

	@FindBy(xpath = "(//div[@class='buttons'])[2]")
	private WebElement continuebutton;

	public RegisterConfrmationpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public String getRegisterresultpage() {
		return rigresult.getText();
	}

	public void clickcontinus() {
		continuebutton.click();
	}
}
