package tests;

import org.testng.annotations.Test;

import pages.CheckoutPage;

public class CheckoutTest extends TestBase {

	CheckoutPage checkoutObject ;
	
	@Test(dependsOnGroups = {"cartTest"})
	public void userCanCheckout() {
		checkoutObject = new CheckoutPage(driver);
		checkoutObject.checkout();
	}

}
