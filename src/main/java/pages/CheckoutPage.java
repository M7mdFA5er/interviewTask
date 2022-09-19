package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage  extends PageBase{

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "total-sum")
	WebElement total;
	
	
	@FindBy(css = "button[data-hook='CheckoutButtonDataHook.button']")
	WebElement checkoutBtn;
	
	public String getTotal () {
		return getTextElementText(total);
	}
	
	public void checkout() {
		clickButton(checkoutBtn);
	}
	
	
	

}
