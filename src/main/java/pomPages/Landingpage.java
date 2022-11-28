package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Landingpage {

	@FindBy(xpath = "//div[@class='header-logo']")
	private WebElement logo;

	@FindBy(xpath = "//a[contains(text(),'Register')]")
	private WebElement registerlink;

	public Landingpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLogo() {
		return logo;
	}

	public void registerationpage() {
		registerlink.click();
	}

}
