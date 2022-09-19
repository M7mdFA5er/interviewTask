package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[@id=\"comp-iy4cwgmq1label\"]")
	private WebElement shopLink;

	@FindBy(id="comp-j4o0vucr")
	private WebElement shopSectionPTxt;
	
	@FindBy(css = "li[data-hook='product-list-grid-item']")
	private List<WebElement> products;

	public String goToShopSection() {
		clickButton(shopLink);
		 wait20.until(ExpectedConditions.visibilityOf(shopSectionPTxt));
		return getTextElementText(shopSectionPTxt);
	}

	public void scrollToFourthProduct()  {
		WebElement FourthProductLink = products.get(3)
				.findElement(By.cssSelector("a[data-hook='product-item-container']"));
		
		//executor.executeScript("arguments[0].scrollIntoView();" , FourthProductLink);
		wait20.until(ExpectedConditions.elementToBeClickable(FourthProductLink));
		clickButton(FourthProductLink);
	}

}
