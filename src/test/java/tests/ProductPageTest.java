package tests;

import org.testng.annotations.Test;

import pages.ProductPage;

public class ProductPageTest extends TestBase {

	ProductPage productObject; 
	
	@Test(dependsOnGroups = {"homeTest"})
	public void userCanAddToCart() {
		productObject = new ProductPage(driver);
		productObject.addToCart();
	}
	
	
	@Test(dependsOnMethods = "userCanAddToCart" , groups= {"cartTest"})
	public void userCanViewCart() {
		productObject.viewCart();
	}
}
