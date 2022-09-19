package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends PageBase {

	public ProductPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "div[data-hook='sku']")
	WebElement productIdTxt;
	
	@FindBy(css = "div[data-hook='color-picker-item']")
	 List<WebElement> colorPickers;
	
	@FindBy(css = "div[data-hook='number-input-spinner-container']")
	WebElement QuantityInput;
	
	@FindBy(css = "span[data-hook='number-input-spinner-up-arrow']")
	WebElement QuantityInputIncreaseBtn;
	
	
	@FindBy(css = "button[data-hook='add-to-cart']")
	WebElement addToCartBtn;
	
	
	@FindBy(tagName = "cart-popup")
	WebElement cartPopupModal;
	
	@FindBy(id = "widget-view-cart-button")
	WebElement viewCartBtn;
	
	
	public  String getproductIdTxt() {
		wait20.until(ExpectedConditions.visibilityOf(productIdTxt));
		return getTextElementText(productIdTxt);
	}
	
	

	public void addToCart () {
		WebElement randomColorPicker = colorPickers.get((int) Math.round( Math.random() ));
		clickButton(randomColorPicker);
		
		
		builder.moveToElement(QuantityInput)
		.click(QuantityInputIncreaseBtn)
		.click(QuantityInputIncreaseBtn)
		.build().perform();		
		clickButton(addToCartBtn);
		
	}
	
	public void viewCart () {
		//for popup frame
		driver.switchTo().frame(1);
		clickButton(viewCartBtn);
		driver.switchTo().defaultContent();

	}
	

}
