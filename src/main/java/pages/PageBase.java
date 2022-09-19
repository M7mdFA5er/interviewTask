package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {

	protected WebDriver driver;
	protected WebDriverWait wait20;
	protected JavascriptExecutor executor;
	protected Actions builder;

	public PageBase(WebDriver driver) {
		this.driver = driver;
		this.wait20 = new WebDriverWait(this.driver, Duration.ofSeconds(20));
		this.executor = (JavascriptExecutor) this.driver;
		this.builder = new Actions(driver);
		PageFactory.initElements(driver, this);
	}

	protected static void clickButton(WebElement button) {
		button.click();
	}

	protected static void setTextElementText(WebElement textElement, String value) {
		textElement.sendKeys(value);
	}

	protected static String getTextElementText(WebElement textElement) {
		return textElement.getText();
	}
}
