package tests;

 import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductPage;

public class HomePageTest extends TestBase {

	HomePage homeObject;
	ProductPage productObject;
	
	@Test(alwaysRun = true)
	public void userCanSelectShopSection () {
		homeObject = new HomePage(driver);
		Assert.assertTrue(homeObject.goToShopSection().contains("OUR COLLECTION"));
	}
	
	@Test(dependsOnMethods = "userCanSelectShopSection" , groups = {"homeTest"})
	public void userCanSelectProduct() {

		productObject = new ProductPage(driver);
		
		homeObject.scrollToFourthProduct();
		Assert.assertTrue(productObject.getproductIdTxt().contains("0004"));
	}
	
}
